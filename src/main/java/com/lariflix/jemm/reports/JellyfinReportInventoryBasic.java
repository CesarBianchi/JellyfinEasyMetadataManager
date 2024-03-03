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
import com.lariflix.jemm.utils.JemmVersion;
import java.io.IOException;
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

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportInventoryBasic {
    
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportInventoryStructure items = new JellyfinReportInventoryStructure();
        
    public JellyfinReportInventoryBasic() {
    }

    public JellyfinReportInventoryBasic(JellyfinInstanceDetails instanceData) {
        JellyfinReportInventoryBasic.instanceData = instanceData;

    }

    public void  loadReportItems() throws IOException, MalformedURLException, ParseException, JRException{
        this.loadItems();
        this.loadSubItems();
        //this.loadSubItemsMetadata();
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
        
        
        System.out.println("breakpoint");
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
                Logger.getLogger(JellyfinReportInventoryBasic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(JellyfinReportInventoryBasic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        System.out.println("breakpoint");
    }

    public void paintReport() throws JRException, MalformedURLException, IOException {
        //gerando o jasper design
        
        //DEBUG WAY
        String jrxmlFile = "/Users/cesarbianchi/JaspersoftWorkspace/JellyfinEasyMetadataManager/InstanceInventoryBasic/JemmInstanceInventoryBasic.jrxml";       
        JasperDesign desenho = JRXmlLoader.load( jrxmlFile );
        
        //EMBEBED WAY
        //String jrxmlFile = "/reports/jasperfiles/InstanceInventoryBasic/JemmInstanceInventoryBasic.jrxml";
        //InputStream desenho = getClass().getResourceAsStream(jrxmlFile);
        
        //compila o relatório
        JasperReport relatorio =  JasperCompileManager.compileReport( desenho );

        //implementação da interface JRDataSource para DataSource ResultSet
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.items);

        //executa o relatório
        Map parametros = new HashMap();
        parametros.put("INSTANCE_URL",instanceData.getCredentials().getBaseURL());
        parametros.put("JEMM_VERSION",new JemmVersion().getVersion() );
        
        JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros,  dataSource);
        
        //exibe o resultado
        JasperViewer viewer = new JasperViewer( impressao , true );
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
                    Logger.getLogger(JellyfinReportInventoryBasic.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(JellyfinReportInventoryBasic.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }            
        }
        
        System.out.println("breakpoint");
    }

    public static JellyfinInstanceDetails getInstanceData() {
        return instanceData;
    }

    public JellyfinReportInventoryStructure getItems() {
        return items;
    }

    public static void setInstanceData(JellyfinInstanceDetails instanceData) {
        JellyfinReportInventoryBasic.instanceData = instanceData;
    }

    public void setItems(JellyfinReportInventoryStructure items) {
        this.items = items;
    }
    
}
