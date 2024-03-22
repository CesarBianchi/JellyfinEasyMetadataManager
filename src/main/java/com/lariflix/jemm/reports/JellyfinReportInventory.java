package com.lariflix.jemm.reports;
/*
 * Copyright (C) 2024 cesarbianchi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */



import com.lariflix.jemm.core.LoadFolders;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import static com.lariflix.jemm.reports.JellyfinReportTypes.INVENTORY_BASIC;
import static com.lariflix.jemm.reports.JellyfinReportTypes.INVENTORY_FULL;
import com.lariflix.jemm.utils.JellyfinUtilFunctions;
import com.lariflix.jemm.utils.JemmVersion;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportInventory {
    
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportInventoryStructure items = new JellyfinReportInventoryStructure();
    private int totalsubItems = 0;
    private JellyfinReportTypes reportType = null;  
    
    public JellyfinReportInventory(JellyfinReportTypes rpType) {
        this.reportType = rpType;
    }

    public JellyfinReportInventory(JellyfinInstanceDetails instanceData, JellyfinReportTypes rpType) {
        JellyfinReportInventory.instanceData = instanceData;
        this.reportType = rpType;

    }

    public void  loadReportItems() throws IOException, MalformedURLException, ParseException, JRException{
        
        switch(reportType) {
            case INVENTORY_BASIC:
                this.loadItems();
                this.loadSubItems();
                this.setTotalOfSubItems();
                break;
            case INVENTORY_FULL:
                this.loadItems();
                this.loadSubItems();
                this.loadSubItemsMetadata();
                this.setTotalOfSubItems();
                break;
        }
    }
    
    private void loadItems() throws IOException, MalformedURLException, ParseException{
        
        LoadFolders loadItems = new LoadFolders();
        loadItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadItems.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinFolders folders = loadItems.requestFolders();
        
        for(int nI = 0; nI < folders.getTotalRecordCount();nI++){            
            JellyfinReportInventoryItem item = new JellyfinReportInventoryItem();
            item.setItem( folders.getItems().get(nI) );
            
            //set itemMetadata
            LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
            loadItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            loadItemMetadata.setcItemID(item.getId());            
            JellyfinItemMetadata itemMetadata = loadItemMetadata.requestItemMetadata();            
            item.setItemMetadata(itemMetadata);
            
            items.add(item);
        }
        
        items.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        
    }

    
    private void loadSubItems(){
        
        LoadItems loadSubItems = new LoadItems();
        loadSubItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadSubItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadSubItems.setcUserAdminID(instanceData.adminUser.getId());
        
        for (int nI = 0; nI < items.size(); nI++){
            
            loadSubItems.setcParentID(items.get(nI).getId());            
            try {
                JellyfinItems subItems = loadSubItems.requestItems();
                
                items.get(nI).setSubItems(subItems);                
                
            } catch (IOException ex) {
                Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
    }

    public void printReport() throws JRException, MalformedURLException, IOException {
        String jrxmlFile = new String();
        JasperDesign draw = null;
        JasperReport report = null;
        
        String jrxmlSubRepFile = new String();
        JasperReport subreport = null;
        JasperDesign drawSub = null;
        JellyfinUtilFunctions commonFunctions = new JellyfinUtilFunctions();
        String tempFilesPath = System.getProperty("java.io.tmpdir");
        
        switch(reportType) {
            case INVENTORY_BASIC:
                
                if(instanceData.isDebug()){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");                    
                    jrxmlFile = "/Users/cesarbianchi/JaspersoftWorkspace/JellyfinEasyMetadataManager/InstanceInventoryBasic/JemmInstanceInventoryBasic.jrxml";       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                } else {
                    //EMBEBED WAY
                    jrxmlFile = "/reports/jasperfiles/InstanceInventoryBasic/JemmInstanceInventoryBasic.jrxml";
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                }
                break;
            
            case INVENTORY_FULL:
            
                if(instanceData.isDebug() ){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");   
                    jrxmlFile = "/Users/cesarbianchi/JaspersoftWorkspace/JellyfinEasyMetadataManager/InstanceInventoryFull/JemmInstanceInventoryFull.jrxml";       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                    
                    
                    jrxmlSubRepFile = "/Users/cesarbianchi/JaspersoftWorkspace/JellyfinEasyMetadataManager/InstanceInventoryFull/JemmInstanceInventoryFullSubItems.jrxml";       
                    drawSub = JRXmlLoader.load( jrxmlFile );
                    subreport = JasperCompileManager.compileReport( drawSub );
                    
                    //Use a localfile subreport
                    JasperCompileManager.compileReportToFile(jrxmlSubRepFile,tempFilesPath.concat("JemmInstanceInventoryFullSubItems.jasper"));
                } else {
                    //EMBEBED WAY
                    jrxmlFile = "/reports/jasperfiles/InstanceInventoryFull/JemmInstanceInventoryFull.jrxml";
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                    
                    //Extract subreport from resource to a localfile                    
                    jrxmlSubRepFile =  "/reports/jasperfiles/InstanceInventoryFull/JemmInstanceInventoryFullSubItems.jrxml";                    
                    if (commonFunctions.extractFileFromJar(jrxmlSubRepFile, "JemmInstanceInventoryFullSubItems.jrxml") ){
                        JasperCompileManager.compileReportToFile(tempFilesPath.concat("JemmInstanceInventoryFullSubItems.jrxml"),tempFilesPath.concat("JemmInstanceInventoryFullSubItems.jasper"));                    
                    }
                }
                
                                
                break;
                
        } 
        

        //Set report Data Source (From jellyfinReportInventoryItem List)
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.getItems());

        //Set Report Parameters
        Map reportParameters = new HashMap();
        reportParameters.put("INSTANCE_URL",instanceData.getCredentials().getBaseURL());
        reportParameters.put("JEMM_VERSION",new JemmVersion().getVersion() );
        reportParameters.put("TOTAL_FOLDERITEMS",Integer.toString(this.items.size()));
        reportParameters.put("TOTAL_CONTENT",Integer.toString(this.totalsubItems));
        reportParameters.put("SUBREPORT_JASPER_FILE",tempFilesPath.concat("JemmInstanceInventoryFullSubItems.jasper"));
        
        //Paint Report
        JasperPrint paintedReport = JasperFillManager.fillReport( report , reportParameters,  dataSource);
        
        //Show Report
        JasperViewer viewer = new JasperViewer( paintedReport , false );
        viewer.setTitle("Jellyfin Easy Metadata Manager - Inventory Report");
        viewer.show();
       
    }
    
    
    
    private void loadSubItemsMetadata() {
        
        LoadItemMetadata loadSubItemMetadata = new LoadItemMetadata();
        loadSubItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadSubItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadSubItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
        
        for (int nI = 0; nI < items.size(); nI++){            
            for (int nJ = 0; nJ < items.get(nI).getSubItems().size(); nJ++){
                
                String cItemID = items.get(nI).getSubItems().get(nJ).getId();                
                loadSubItemMetadata.setcItemID(cItemID);
                
                JellyfinItemMetadata subItemMetadata;
                try {
                    subItemMetadata = loadSubItemMetadata.requestItemMetadata();
                    items.get(nI).getSubItems().get(nJ).setSubItemMetadata(subItemMetadata);
                    
                } catch (IOException ex) {
                    Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }            
        }
       
    }

    public static JellyfinInstanceDetails getInstanceData() {
        return instanceData;
    }

    public JellyfinReportInventoryStructure getItems() {
        return items;
    }

    public static void setInstanceData(JellyfinInstanceDetails instanceData) {
        JellyfinReportInventory.instanceData = instanceData;
    }

    public void setItems(JellyfinReportInventoryStructure items) {
        this.items = items;
    }

    private void setTotalOfSubItems() {
        int countSubItems = 0;
        
        for (int nI = 0; nI< this.items.size();nI++){
            countSubItems = countSubItems + this.items.get(nI).getSubItems().size();
        }
        
        this.totalsubItems = countSubItems;
    }
    
}
