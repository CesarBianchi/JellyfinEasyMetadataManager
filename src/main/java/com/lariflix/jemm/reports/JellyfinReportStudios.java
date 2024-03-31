package com.lariflix.jemm.reports;

import com.lariflix.jemm.core.LoadFolders;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.core.LoadStudios;
import com.lariflix.jemm.dtos.JellyfinCadStudioItems;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.utils.JellyfimParameters;
import com.lariflix.jemm.utils.JellyfinReportTypes;
import com.lariflix.jemm.utils.JellyfinUtilFunctions;
import com.lariflix.jemm.utils.JemmVersion;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * The JellyfinReportStudios class is used to represent studios in a report.
 *
 * This class contains the details of a studio, such as the name and other relevant details. It provides methods to set and retrieve these details.
 *
 * @author Cesar Bianchi
 */
public class JellyfinReportStudios {
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportStudiosStructure items = new JellyfinReportStudiosStructure();
    private ArrayList<JellyfinItem> nonOrdenedEpisodes = new ArrayList();
    private int totalsubItems = 0;
    private JellyfinReportTypes reportType = null;  
    
    /**
     * Constructor for the JellyfinReportStudios class.
     *
     * This constructor initializes a new instance of the JellyfinReportStudios class with the given report type.
     *
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be either STUDIOS_BASIC or STUDIOS_FULL.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportStudios(JellyfinReportTypes rpType) {
        this.reportType = rpType;
    }

    /**
     * Constructor for the JellyfinReportStudios class.
     *
     * This constructor initializes a new instance of the JellyfinReportStudios class with the given instance data and report type.
     *
     * @param instanceData A JellyfinInstanceDetails object representing the details of the Jellyfin instance from which to generate the report. This includes the URL, API token, and other necessary details.
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be either STUDIOS_BASIC or STUDIOS_FULL.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportStudios(JellyfinInstanceDetails instanceData, JellyfinReportTypes rpType) {
        JellyfinReportStudios.instanceData = instanceData;
        this.reportType = rpType;
    }
   
    /**
     * Loads the report items for this JellyfinReportStudios.
     *
     * This method loads the items for this JellyfinReportStudios based on the report type. If the report type is STUDIOS_BASIC, it only loads the items. If the report type is STUDIOS_FULL, it loads both the items and the sub-items.
     *
     * This method throws an IOException if there is a problem with the input or output, a MalformedURLException if the URL of the Jellyfin instance is not formatted correctly, a ParseException if there is a problem with parsing the data, and a JRException if there is a problem with generating the report.
     *
     * @throws IOException If there is a problem with the input or output.
     * @throws MalformedURLException If the URL of the Jellyfin instance is not formatted correctly.
     * @throws ParseException If there is a problem with parsing the data.
     * @throws JRException If there is a problem with generating the report.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void loadReportItems() throws IOException, MalformedURLException, ParseException, JRException{
        
        switch(reportType) {
            case STUDIOS_BASIC:
                this.loadItems();
                break;
            case STUDIOS_FULL:
                this.loadItems();
                this.loadSubItems();
                break;
        }
    }

    /**
     * Loads the items for this JellyfinReportStudios.
     *
     * This method retrieves all studios from the Jellyfin instance, creates a new JellyfinReportStudiosItem for each studio, sets the item and studio metadata of the JellyfinReportStudiosItem to the studio, and adds the JellyfinReportStudiosItem to the items list. 
     * The items list is then sorted in ascending order by name.
     *
     * This method throws an IOException if there is a problem with the input or output, a MalformedURLException if the URL of the Jellyfin instance is not formatted correctly, and a ParseException if there is a problem with parsing the data.
     *
     * @throws IOException If there is a problem with the input or output.
     * @throws MalformedURLException If the URL of the Jellyfin instance is not formatted correctly.
     * @throws ParseException If there is a problem with parsing the data.
     * @since 1.1
     * @author Cesar Bianchi
     */
    private void loadItems() throws IOException, MalformedURLException, ParseException {
        LoadStudios loadStudios = new LoadStudios();
        loadStudios.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadStudios.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadStudios.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinCadStudioItems studios = loadStudios.requestStudios();
        
        
        for(int nI = 0; nI < studios.getTotalRecordCount();nI++){            
            JellyfinReportStudiosItem item = new JellyfinReportStudiosItem();
            item.setItem( studios.getItems().get(nI) );
            
            //Get Studio Item Metadata
            LoadItemMetadata loadStudioItemMetadata = new LoadItemMetadata();
            loadStudioItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadStudioItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadStudioItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            loadStudioItemMetadata.setcItemID(item.getId());                
            JellyfinItemMetadata studioItemMetadata = loadStudioItemMetadata.requestItemMetadata();            
            item.setStudioMetadata(studioItemMetadata);
            
            items.add(item);
        }

        items.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
    }

    /**
     * Loads the sub-items for this JellyfinReportStudios.
     *
     * This method retrieves all folders from the Jellyfin instance, retrieves all items for each folder, and adds each item to the non-ordered episodes list. Then, for each episode, it retrieves the metadata and checks if the studio episode is the same as the studio-item. If it is, it adds the episode and its metadata to the studio-item.
     *
     * This method throws an IOException if there is a problem with the input or output, and a ParseException if there is a problem with parsing the data.
     *
     * @throws IOException If there is a problem with the input or output.
     * @throws ParseException If there is a problem with parsing the data.
     * @since 1.1
     * @author Cesar Bianchi
     */
    private void loadSubItems() {
        
        //1* Get All Folders
        LoadFolders loadItems = new LoadFolders(JellyfimParameters.FOLDERS_AND_SUBFOLDERS);
        loadItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadItems.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinFolders folders;
        try {
            folders = loadItems.requestFolders();
            
            //2* Get All Itens for each folder
            LoadItems loadSubItems = new LoadItems(JellyfimParameters.JUST_ITEMS);
            loadSubItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadSubItems.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadSubItems.setcUserAdminID(instanceData.adminUser.getId());        
            
            for (int nI = 0; nI< folders.getItems().size(); nI++){            
                loadSubItems.setcParentID(folders.getItems().get(nI).getId());                            
                JellyfinItems subItems = loadSubItems.requestItems();                
                
                for (int nJ = 0; nJ < subItems.getItems().size(); nJ++){                    
                    nonOrdenedEpisodes.add(subItems.getItems().get(nJ));
                }
            }
            
            //3* For each episode, Get the metadata and check if the studio episode is the same of studios-item
            LoadItemMetadata loadEpisodeMetadata = new LoadItemMetadata();
            loadEpisodeMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadEpisodeMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadEpisodeMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            for (int nI = 0; nI < this.items.size(); nI++){
            
                //for (int nJ = 0; nJ < 10; nJ++){
                for (int nJ = 0; nJ < nonOrdenedEpisodes.size(); nJ++){
                    
                    loadEpisodeMetadata.setcItemID(nonOrdenedEpisodes.get(nJ).getId());                
                    JellyfinItemMetadata studioItemMetadata = loadEpisodeMetadata.requestItemMetadata();                            
                    for (int nK = 0; nK < studioItemMetadata.getStudios().size(); nK++){
                    
                        if (studioItemMetadata.getStudios().get(nK).getId().equals(this.getItems().get(nI).getId())){
                            
                            this.items.get(nI).addStudioEpisode(nonOrdenedEpisodes.get(nJ),studioItemMetadata);
                        }                        
                    }
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(JellyfinReportStudios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinReportStudios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Prints the report for this JellyfinReportStudios.
     *
     * This method generates and displays a report based on the report type. 
     * If the report type is STUDIOS_BASIC, it generates a basic report. 
     * If the report type is STUDIOS_FULL, it generates a full report with sub-items.
     *
     * The method first determines the paths for the report files, then compiles the report based on the report type. 
     * If the application is running in debug mode, it uses local files. Otherwise, it uses embedded resources.
     *
     * After compiling the report, it sets the data source to the items of this JellyfinReportStudios, sets the report parameters, fills the report with data, and displays the report in a new JasperViewer.
     *
     * This method throws a JRException if there is a problem with generating the report, a MalformedURLException if the URL of the Jellyfin instance is not formatted correctly, and an IOException if there is a problem with the input or output.
     *
     * @throws JRException If there is a problem with generating the report.
     * @throws MalformedURLException If the URL of the Jellyfin instance is not formatted correctly.
     * @throws IOException If there is a problem with the input or output.
     * @since 1.1
     * @author Cesar Bianchi
     */
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
            case STUDIOS_BASIC:
                
                if(instanceData.isDebug()){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");                    
                    jrxmlFile = localReportBasePath.concat("/InstanceStudiosBasic/JemmInstanceStudiosBasic.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstanceStudiosBasic/JemmInstanceStudiosBasic.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                }
                break;
            
            case STUDIOS_FULL:
            
                if(instanceData.isDebug() ){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");   
                    jrxmlFile = localReportBasePath.concat("/InstanceStudiosFull/JemmInstanceStudiosFull.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                    
                    
                    jrxmlSubRepFile = localReportBasePath.concat("/InstanceStudiosFull/JemmInstanceStudiosFullSubItems.jrxml");       
                    drawSub = JRXmlLoader.load( jrxmlFile );
                    subreport = JasperCompileManager.compileReport( drawSub );
                    
                    //Use a localfile subreport
                    JasperCompileManager.compileReportToFile(jrxmlSubRepFile,tempFilesPath.concat("JemmInstanceStudiosFullSubItems.jasper"));
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstanceStudiosFull/JemmInstanceStudiosFull.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                    
                    //Extract subreport from resource to a localfile                    
                    jrxmlSubRepFile =  resorceReportBasePath.concat("/InstanceStudiosFull/JemmInstanceStudiosFullSubItems.jrxml");                    
                    if (commonFunctions.extractFileFromJar(jrxmlSubRepFile, "JemmInstanceStudiosFullSubItems.jrxml") ){
                        JasperCompileManager.compileReportToFile(tempFilesPath.concat("JemmInstanceStudiosFullSubItems.jrxml"),tempFilesPath.concat("JemmInstanceStudiosFullSubItems.jasper"));                    
                    }
                }
                
                                
                break;
                
        }       

        //Set report Data Source
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.getItems());

        //Set Report Parameters
        Map reportParameters = new HashMap();
        reportParameters.put("INSTANCE_URL",instanceData.getCredentials().getBaseURL());
        reportParameters.put("JEMM_VERSION",new JemmVersion().getVersion() );
        reportParameters.put("TOTAL_FOLDERITEMS",Integer.toString(this.items.size()));
        reportParameters.put("TOTAL_CONTENT",Integer.toString(this.totalsubItems));
        reportParameters.put("SUBREPORT_JASPER_FILE",tempFilesPath.concat("JemmInstanceStudiosFullSubItems.jasper"));
        
        //Paint Report
        JasperPrint paintedReport = JasperFillManager.fillReport( report , reportParameters,  dataSource);
        
        //Show Report
        JasperViewer viewer = new JasperViewer( paintedReport , false );
        viewer.setTitle("Jellyfin Easy Metadata Manager - Studios Report");
        viewer.show();
       
    }
    
    /**
     * Retrieves the items property of this JellyfinReportStudios.
     *
     * @return A JellyfinReportStudiosStructure object representing the items of this JellyfinReportStudios. 
     * Each item in the JellyfinReportStudiosStructure represents a studio in the report.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportStudiosStructure getItems() {
        return items;
    }

    /**
     * Retrieves the totalsubItems property of this JellyfinReportStudios.
     *
     * @return An integer representing the total number of sub-items in this JellyfinReportStudios.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public int getTotalsubItems() {
        return totalsubItems;
    }

    /**
     * Sets the totalsubItems property of this JellyfinReportStudios.
     *
     * @param totalsubItems An integer that should be used as the new total number of sub-items in this JellyfinReportStudios.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setTotalsubItems(int totalsubItems) {
        this.totalsubItems = totalsubItems;
    }
    
}
