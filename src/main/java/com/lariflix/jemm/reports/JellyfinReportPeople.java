package com.lariflix.jemm.reports;

import com.lariflix.jemm.utils.JellyfinReportTypes;
import com.lariflix.jemm.core.LoadFolders;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.core.LoadPeople;
import com.lariflix.jemm.dtos.JellyfinCadPeopleItems;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.utils.JellyfimParameters;
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
 * The JellyfinReportPeople class is used to represent people in a report.
 *
 * This class contains the details of a person, such as the name, role, and other relevant details. 
 * It provides methods to set and retrieve these details.
 *
 * @author Cesar Bianchi
 */
public class JellyfinReportPeople {

    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportPeopleStructure items = new JellyfinReportPeopleStructure();
    private ArrayList<JellyfinItem> nonOrdenedEpisodes = new ArrayList();
    private JellyfinReportTypes reportType = null;  
    
    /**
     * Constructor for the JellyfinReportPeople class.
     *
     * This constructor initializes a new instance of the JellyfinReportPeople class with the given report type.
     *
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be either PEOPLE_BASIC or PEOPLE_FULL.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportPeople(JellyfinReportTypes rpType) {
        this.reportType = rpType;
    }

    /**
     * Constructor for the JellyfinReportPeople class.
     *
     * This constructor initializes a new instance of the JellyfinReportPeople class with the given instance data and report type.
     *
     * @param instanceData A JellyfinInstanceDetails object representing the details of the Jellyfin instance from which to generate the report. This includes the URL, API token, and other necessary details.
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be either PEOPLE_BASIC or PEOPLE_FULL.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportPeople(JellyfinInstanceDetails instanceData, JellyfinReportTypes rpType) {
        JellyfinReportPeople.instanceData = instanceData;
        this.reportType = rpType;
    }
    
    /**
     * Loads the report items for this JellyfinReportPeople.
     *
     * This method loads the items for this JellyfinReportPeople based on the report type. 
     * If the report type is PEOPLE_BASIC, it only loads the items. 
     * If the report type is PEOPLE_FULL, it loads both the items and the episodes.
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
            case PEOPLE_BASIC:
                this.loadItems();
                break;
            case PEOPLE_FULL:
                this.loadItems();
                this.loadEpisodes();
                break;
        }
    }
    
    /**
     * Loads the items for this JellyfinReportPeople.
     *
     * This method retrieves the people from the Jellyfin instance, creates a new JellyfinReportPeopleItem for each person, sets the item and people metadata of the JellyfinReportPeopleItem to the person, and adds the JellyfinReportPeopleItem to the items list. 
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
    private void loadItems() throws IOException, MalformedURLException, ParseException{
        
        LoadPeople loadPeople = new LoadPeople();
        loadPeople.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadPeople.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadPeople.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinCadPeopleItems people = loadPeople.requestPeople();
        
        
        for(int nI = 0; nI < people.getTotalRecordCount();nI++){            
            JellyfinReportPeopleItem item = new JellyfinReportPeopleItem();
            
            item.setItem( people.getItems().get(nI) );
            
            /*Get People Metadata*/
            LoadItemMetadata loadPepopleMetadata = new LoadItemMetadata();
            loadPepopleMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadPepopleMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadPepopleMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            loadPepopleMetadata.setcItemID(item.getId());                
            JellyfinItemMetadata peopleMetadata = loadPepopleMetadata.requestItemMetadata();            
            item.setPeopleMetadata(peopleMetadata);
            
            items.add(item);
        }
        
        items.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
    }

    /**
     * Loads the episodes for this JellyfinReportPeople.
     *
     * This method retrieves all folders from the Jellyfin instance, retrieves all items for each folder, and adds each item to the non-ordered episodes list. 
     * Then, for each episode, it retrieves the metadata and checks if the people episode is the same as the people-item. 
     * If it is, it adds the episode and its metadata to the people-item.
     *
     * This method throws an IOException if there is a problem with the input or output, and a ParseException if there is a problem with parsing the data.
     *
     * @throws IOException If there is a problem with the input or output.
     * @throws ParseException If there is a problem with parsing the data.
     * @since 1.1
     * @author Cesar Bianchi
     */
    private void loadEpisodes() {
        
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
            
            //3* For each episode, Get the metadata and check if the people episode is the same of people-item
            LoadItemMetadata loadEpisodeMetadata = new LoadItemMetadata();
            loadEpisodeMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadEpisodeMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadEpisodeMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            for (int nI = 0; nI < this.items.size(); nI++){
            
                //for (int nJ = 0; nJ < 10; nJ++){
                for (int nJ = 0; nJ < nonOrdenedEpisodes.size(); nJ++){
                    
                    loadEpisodeMetadata.setcItemID(nonOrdenedEpisodes.get(nJ).getId());                
                    JellyfinItemMetadata episodeMetadata = loadEpisodeMetadata.requestItemMetadata();
                    
                    
                    for (int nK = 0; nK < episodeMetadata.getPeople().size(); nK++){
                    
                        if (episodeMetadata.getPeople().get(nK).getId().equals(this.getItems().get(nI).getId())){
                            
                            this.items.get(nI).addPeopleEpisode(nonOrdenedEpisodes.get(nJ),episodeMetadata);
                        }                        
                    }
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(JellyfinReportGenres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinReportGenres.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Prints the report for this JellyfinReportPeople.
     *
     * This method generates and displays a report based on the report type. If the report type is PEOPLE_BASIC, it generates a basic report. 
     * If the report type is PEOPLE_FULL, it generates a full report with sub-items.
     *
     * The method first determines the paths for the report files, then compiles the report based on the report type.
     * If the application is running in debug mode, it uses local files. Otherwise, it uses embedded resources.
     *
     * After compiling the report, it sets the data source to the items of this JellyfinReportPeople, sets the report parameters, fills the report with data, and displays the report in a new JasperViewer.
     *
     * This method throws a JRException if there is a problem with generating the report, a MalformedURLException if the URL of the Jellyfin instance is not formatted correctly, and an IOException if there is a problem with the input or output.
     *
     * @throws JRException If there is a problem with generating the report.
     * @throws MalformedURLException If the URL of the Jellyfin instance is not formatted correctly.
     * @throws IOException If there is a problem with the input or output.
     * @since 1.0
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
            case PEOPLE_BASIC:
                
                if(instanceData.isDebug()){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");                    
                    jrxmlFile = localReportBasePath.concat("/InstancePeopleBasic/JemmInstancePeopleBasic.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstancePeopleBasic/JemmInstancePeopleBasic.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                }
                break;
            
            case PEOPLE_FULL:
            
                if(instanceData.isDebug() ){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");   
                    jrxmlFile = localReportBasePath.concat("/InstancePeopleFull/JemmInstancePeopleFull.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                    
                    
                    jrxmlSubRepFile = localReportBasePath.concat("/InstancePeopleFull/JemmInstancePeopleFullSubItems.jrxml");       
                    drawSub = JRXmlLoader.load( jrxmlFile );
                    subreport = JasperCompileManager.compileReport( drawSub );
                    
                    //Use a localfile subreport
                    JasperCompileManager.compileReportToFile(jrxmlSubRepFile,tempFilesPath.concat("JemmInstancePeopleFullSubItems.jasper"));
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstancePeopleFull/JemmInstancePeopleFull.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                    
                    //Extract subreport from resource to a localfile                    
                    jrxmlSubRepFile =  resorceReportBasePath.concat("/InstancePeopleFull/JemmInstancePeopleFullSubItems.jrxml");                    
                    if (commonFunctions.extractFileFromJar(jrxmlSubRepFile, "JemmInstancePeopleFullSubItems.jrxml") ){
                        JasperCompileManager.compileReportToFile(tempFilesPath.concat("JemmInstancePeopleFullSubItems.jrxml"),tempFilesPath.concat("JemmInstancePeopleFullSubItems.jasper"));                    
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
        //reportParameters.put("TOTAL_CONTENT",Integer.toString(this.totalsubItems));
        reportParameters.put("SUBREPORT_JASPER_FILE",tempFilesPath.concat("JemmInstancePeopleFullSubItems.jasper"));
        
        //Paint Report
        JasperPrint paintedReport = JasperFillManager.fillReport( report , reportParameters,  dataSource);
        
        //Show Report
        JasperViewer viewer = new JasperViewer( paintedReport , false );
        viewer.setTitle("Jellyfin Easy Metadata Manager - People Report");
        viewer.show();
       
    }
    
    /**
     * Retrieves the items property of this JellyfinReportPeople.
     *
     * @return A JellyfinReportPeopleStructure object representing the items of this JellyfinReportPeople. 
     * Each item in the JellyfinReportPeopleStructure represents a person in the report.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinReportPeopleStructure getItems() {
        return items;
    }
    
}
