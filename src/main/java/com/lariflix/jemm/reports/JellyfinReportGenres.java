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
package com.lariflix.jemm.reports;

import com.lariflix.jemm.core.LoadGenres;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.dtos.JellyfinCadGenresItems;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import static com.lariflix.jemm.reports.JellyfinReportGenres.instanceData;
import static com.lariflix.jemm.reports.JellyfinReportInventory.instanceData;
import com.lariflix.jemm.utils.JellyfinUtilFunctions;
import com.lariflix.jemm.utils.JemmVersion;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
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
import org.json.simple.parser.ParseException;

/**
 *
 * @author cesarbianchi
 */
public class JellyfinReportGenres {
    
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportGenresStructure items = new JellyfinReportGenresStructure();
    private int totalsubItems = 0;
    private JellyfinReportTypes reportType = null;  
    
    public JellyfinReportGenres(JellyfinReportTypes rpType) {
        this.reportType = rpType;
    }

    public JellyfinReportGenres(JellyfinInstanceDetails instanceData, JellyfinReportTypes rpType) {
        JellyfinReportGenres.instanceData = instanceData;
        this.reportType = rpType;
    }
    
    public void  loadReportItems() throws IOException, MalformedURLException, ParseException, JRException{
        
        switch(reportType) {
            case GENRES_BASIC:
                this.loadItems();
                //this.loadSubItems();
                break;
            case GENRES_FULL:
                this.loadItems();
                //this.loadSubItems();
                //this.loadSubItemsMetadata();
                break;
        }
    }
    
    private void loadItems() throws IOException, MalformedURLException, ParseException{
        
        LoadGenres loadGenres = new LoadGenres();
        loadGenres.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadGenres.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadGenres.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinCadGenresItems genres = loadGenres.requestGenres();
        
        
        for(int nI = 0; nI < genres.getTotalRecordCount();nI++){            
            JellyfinReportGenresItem item = new JellyfinReportGenresItem();
            item.setItem( genres.getItems().get(nI) );
            
            /*Get Genre Item Metadata*/
            LoadItemMetadata loadGenreItemMetadata = new LoadItemMetadata();
            loadGenreItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadGenreItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadGenreItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            loadGenreItemMetadata.setcItemID(item.getId());                
            JellyfinItemMetadata genreItemMetadata = loadGenreItemMetadata.requestItemMetadata();            
            item.setGenreMetadata(genreItemMetadata);
            
            items.add(item);
        }
        
        items.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
    
    public void printReport() throws JRException, MalformedURLException, IOException {
        String localReportBasePath = new JellyfinUtilFunctions().getJRXMLLocalPath();
        String resorceReportBasePath =  new  JellyfinUtilFunctions().getJRXMLResourcePath();
        
        String jrxmlFile = new String();
        JasperDesign draw = null;
        JasperReport report = null;
        
        String jrxmlSubRepFile = new String();
        JasperReport subreport = null;
        JasperDesign drawSub = null;
        JellyfinUtilFunctions commonFunctions = new JellyfinUtilFunctions();
        String tempFilesPath = System.getProperty("java.io.tmpdir");
        
        switch(reportType) {
            case GENRES_BASIC:
                
                if(instanceData.isDebug()){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");                    
                    jrxmlFile = localReportBasePath.concat("/InstanceGenresBasic/JemmInstanceGenresBasic.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstanceGenresBasic/JemmInstanceGenresBasic.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                }
                break;
            
            case GENRES_FULL:
            
                if(instanceData.isDebug() ){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");   
                    jrxmlFile = localReportBasePath.concat("/InstanceGenresFull/JemmInstanceGenresFull.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                    
                    
                    jrxmlSubRepFile = localReportBasePath.concat("/InstanceGenresFull/JemmInstanceGenresFullSubItems.jrxml");       
                    drawSub = JRXmlLoader.load( jrxmlFile );
                    subreport = JasperCompileManager.compileReport( drawSub );
                    
                    //Use a localfile subreport
                    JasperCompileManager.compileReportToFile(jrxmlSubRepFile,tempFilesPath.concat("JemmInstanceGenresFullSubItems.jasper"));
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstanceGenresFull/JemmInstanceGenresFull.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                    
                    //Extract subreport from resource to a localfile                    
                    jrxmlSubRepFile =  resorceReportBasePath.concat("/InstanceGenresFull/JemmInstanceGenresFullSubItems.jrxml");                    
                    if (commonFunctions.extractFileFromJar(jrxmlSubRepFile, "JemmInstanceGenresFullSubItems.jrxml") ){
                        JasperCompileManager.compileReportToFile(tempFilesPath.concat("JemmInstanceGenresFullSubItems.jrxml"),tempFilesPath.concat("JemmInstanceGenresFullSubItems.jasper"));                    
                    }
                }
                
                                
                break;
                
        }       

        //Set report Data Source (From jellyfinReportGenresItem List)
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.getItems());

        //Set Report Parameters
        Map reportParameters = new HashMap();
        reportParameters.put("INSTANCE_URL",instanceData.getCredentials().getBaseURL());
        reportParameters.put("JEMM_VERSION",new JemmVersion().getVersion() );
        reportParameters.put("TOTAL_FOLDERITEMS",Integer.toString(this.items.size()));
        reportParameters.put("TOTAL_CONTENT",Integer.toString(this.totalsubItems));
        reportParameters.put("SUBREPORT_JASPER_FILE",tempFilesPath.concat("JemmInstanceGenresFullSubItems.jasper"));
        
        //Paint Report
        JasperPrint paintedReport = JasperFillManager.fillReport( report , reportParameters,  dataSource);
        
        //Show Report
        JasperViewer viewer = new JasperViewer( paintedReport , false );
        viewer.setTitle("Jellyfin Easy Metadata Manager - Genres Report");
        viewer.show();
       
    }

    public JellyfinReportGenresStructure getItems() {
        return items;
    }
    
    
    
}