package com.lariflix.jemm.reports;

import com.lariflix.jemm.core.LoadFolders;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.utils.JellyfinParameters;
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
 * The JellyfinReportTags class is used to represent tags in a report.
 *
 * This class contains the details of a tag, such as the name and other relevant details. 
 * It provides methods to set and retrieve these details.
 *
 * @author Cesar Bianchi
 */
public class JellyfinReportTags {

    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportTagsStructure items = new JellyfinReportTagsStructure();
    private ArrayList<JellyfinItem> nonOrdenedEpisodes = new ArrayList();
    private int totalsubItems = 0;
    private JellyfinReportTypes reportType = null;  
    
    /**
     * Constructor for the JellyfinReportTags class.
     *
     * This constructor initializes a new instance of the JellyfinReportTags class with the given report type.
     *
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be either TAGS_BASIC or TAGS_FULL.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportTags(JellyfinReportTypes rpType) {
        this.reportType = rpType;
    }

    /**
     * Constructor for the JellyfinReportTags class.
     *
     * This constructor initializes a new instance of the JellyfinReportTags class with the given instance data and report type.
     *
     * @param instanceData A JellyfinInstanceDetails object representing the details of the Jellyfin instance from which to generate the report. This includes the URL, API token, and other necessary details.
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be either TAGS_BASIC or TAGS_FULL.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportTags(JellyfinInstanceDetails instanceData, JellyfinReportTypes rpType) {
        JellyfinReportTags.instanceData = instanceData;
        this.reportType = rpType;
    }
    
     
    /**
     * Loads the report items for this JellyfinReportTags.
     *
     * This method loads the items for this JellyfinReportTags based on the report type. 
     * If the report type is TAGS_BASIC, it only loads the items. 
     * If the report type is TAGS_FULL, it loads both the items and the sub-items.
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
            case TAGS_BASIC:
                this.loadItems();
                break;
            case TAGS_FULL:
                this.loadItems();
                break;
        }
    }

    /**
     * Loads the items for this JellyfinReportTags.
     *
     * This method retrieves all folders from the Jellyfin instance, retrieves all items for each folder, and adds each item to the non-ordered episodes list. 
     * Then, for each episode, it retrieves the metadata and checks if the tag episode is the same as the tag-item. If it is, it adds the episode and its metadata to the tag-item.
     *
     * This method throws an IOException if there is a problem with the input or output, and a ParseException if there is a problem with parsing the data.
     *
     * @throws IOException If there is a problem with the input or output.
     * @throws ParseException If there is a problem with parsing the data.
     * @since 1.1
     * @author Cesar Bianchi
     */
    private void loadItems() {
        
        //1* Get All Folders
        LoadFolders loadItems = new LoadFolders(JellyfinParameters.FOLDERS_AND_SUBFOLDERS);
        loadItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadItems.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinFolders folders;
        try {
            folders = loadItems.requestFolders();
            
            //2* Get All Itens for each folder
            LoadItems loadSubItems = new LoadItems(JellyfinParameters.JUST_ITEMS);
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
            
            //3* For each episode, Get the ItemMetadata
            LoadItemMetadata loadEpisodeMetadata = new LoadItemMetadata();
            loadEpisodeMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadEpisodeMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadEpisodeMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            
            //for (int nJ = 0; nJ < 10; nJ++){
            for (int nJ = 0; nJ < nonOrdenedEpisodes.size(); nJ++){

                loadEpisodeMetadata.setcItemID(nonOrdenedEpisodes.get(nJ).getId());                
                JellyfinItemMetadata episodeItemMetadata = loadEpisodeMetadata.requestItemMetadata();                                                
                nonOrdenedEpisodes.get(nJ).setItemMetadata(episodeItemMetadata);
                
                //4* add the itemTag to TagList
                for (int nK = 0; nK < episodeItemMetadata.getTags().size(); nK++){

                    //Check if the tag has already added before
                    String tag = episodeItemMetadata.getTags().get(nK);
                    boolean added = false;

                    for (int nI = 0; nI < this.items.size() ; nI++){
                        String tempTag = this.items.get(nI).getTagName();
                        if (tempTag.equals(tag)){
                            added = true;

                            //add the Episode as TagSubItem
                            JellyfinReportInventorySubItem episode = new JellyfinReportInventorySubItem();
                            episode.setSubItem(nonOrdenedEpisodes.get(nJ));                           
                            episode.setSubItemMetadata(nonOrdenedEpisodes.get(nJ).getItemMetadata());
                            
                            this.items.get(nI).addTagEpisode(episode);

                            break;                                
                        }
                    }

                    if (!added){
                        JellyfinReportInventorySubItem episode = new JellyfinReportInventorySubItem();
                        episode.setSubItem(nonOrdenedEpisodes.get(nJ));                                
                        episode.setSubItemMetadata(nonOrdenedEpisodes.get(nJ).getItemMetadata());
                        JellyfinReportTagsItem newTag = new JellyfinReportTagsItem();
                        newTag.setTagName(tag);
                        newTag.addTagEpisode(episode);

                        this.items.add(newTag);
                    }

                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(JellyfinReportGenres.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JellyfinReportGenres.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        items.sort((o1, o2) -> o1.getTagName().toUpperCase().compareTo(o2.getTagName().toUpperCase()));
        
    }

    /**
     * Prints the report for this JellyfinReportTags.
     *
     * This method generates and displays a report based on the report type. 
     * If the report type is TAGS_BASIC, it generates a basic report. 
     * If the report type is TAGS_FULL, it generates a full report with sub-items.
     *
     * The method first determines the paths for the report files, then compiles the report based on the report type. 
     * If the application is running in debug mode, it uses local files. Otherwise, it uses embedded resources.
     *
     * After compiling the report, it sets the data source to the items of this JellyfinReportTags, sets the report parameters, fills the report with data, and displays the report in a new JasperViewer.
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
            case TAGS_BASIC:
                
                if(instanceData.isDebug()){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");                    
                    jrxmlFile = localReportBasePath.concat("/InstanceTagsBasic/JemmInstanceTagsBasic.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstanceTagsBasic/JemmInstanceTagsBasic.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                }
                break;
            
            case TAGS_FULL:
            
                if(instanceData.isDebug() ){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");   
                    jrxmlFile = localReportBasePath.concat("/InstanceTagsFull/JemmInstanceTagsFull.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                    
                    
                    jrxmlSubRepFile = localReportBasePath.concat("/InstanceTagsFull/JemmInstanceTagsFullSubItems.jrxml");       
                    drawSub = JRXmlLoader.load( jrxmlFile );
                    subreport = JasperCompileManager.compileReport( drawSub );
                    
                    //Use a localfile subreport
                    JasperCompileManager.compileReportToFile(jrxmlSubRepFile,tempFilesPath.concat("JemmInstanceTagsFullSubItems.jasper"));
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstanceTagsFull/JemmInstanceTagsFull.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                    
                    //Extract subreport from resource to a localfile                    
                    jrxmlSubRepFile =  resorceReportBasePath.concat("/InstanceTagsFull/JemmInstanceTagsFullSubItems.jrxml");                    
                    if (commonFunctions.extractFileFromJar(jrxmlSubRepFile, "JemmInstanceTagsFullSubItems.jrxml") ){
                        JasperCompileManager.compileReportToFile(tempFilesPath.concat("JemmInstanceTagsFullSubItems.jrxml"),tempFilesPath.concat("JemmInstanceTagsFullSubItems.jasper"));                    
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
        reportParameters.put("SUBREPORT_JASPER_FILE",tempFilesPath.concat("JemmInstanceTagsFullSubItems.jasper"));
        
        //Paint Report
        JasperPrint paintedReport = JasperFillManager.fillReport( report , reportParameters,  dataSource);
        
        //Show Report
        JasperViewer viewer = new JasperViewer( paintedReport , false );
        viewer.setTitle("Jellyfin Easy Metadata Manager - Tags Report");
        viewer.show();
       
    }

    /**
     * Retrieves the items property of this JellyfinReportTags.
     *
     * @return A JellyfinReportTagsStructure object representing the items of this JellyfinReportTags. Each item in the JellyfinReportTagsStructure represents a tag in the report.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JellyfinReportTagsStructure getItems() {
        return items;
    }


    
}
