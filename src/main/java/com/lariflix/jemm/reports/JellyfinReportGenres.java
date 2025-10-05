package com.lariflix.jemm.reports;

import com.lariflix.jemm.utils.JellyfinReportTypes;
import com.lariflix.jemm.core.LoadFolders;
import com.lariflix.jemm.core.LoadGenres;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinCadGenresItems;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.utils.JellyfinParameters;
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
 * The JellyfinReportGenres class is used to generate genre reports from a Jellyfin server.
 *
 * This class retrieves genre data from the Jellyfin server and formats it into a report. 
 * The report includes details such as the genre name, the number of items in each genre, and other relevant details.
 *
 * @author Cesar Bianchi
 */
public class JellyfinReportGenres {
    
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportGenresStructure items = new JellyfinReportGenresStructure();
    private ArrayList<JellyfinItem> nonOrdenedEpisodes = new ArrayList();
    private int totalsubItems = 0;
    private JellyfinReportTypes reportType = null;  
    
    /**
     * Constructor for the JellyfinReportGenres class.
     *
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be any of the types defined in the JellyfinReportTypes class.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportGenres(JellyfinReportTypes rpType) {
        this.reportType = rpType;
    }

    /**
     * Constructor for the JellyfinReportGenres class.
     *
     * @param instanceData A JellyfinInstanceDetails object containing the details of the Jellyfin instance from which to generate the report. This includes the URL, API token, and other necessary details.
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be any of the types defined in the JellyfinReportTypes class.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportGenres(JellyfinInstanceDetails instanceData, JellyfinReportTypes rpType) {
        JellyfinReportGenres.instanceData = instanceData;
        this.reportType = rpType;
    }
    
    /**
     * Loads the report items.
     *
     * This method loads the report items based on the report type. 
     * If the report type is GENRES_BASIC, it loads the items. 
     * If the report type is GENRES_FULL, it loads the items and the sub-items.
     *
     * @throws IOException If an I/O error occurs. This can happen if there's a problem with the network connection, the server, or the local machine.
     * @throws MalformedURLException If the URL of the Jellyfin server is not formatted correctly.
     * @throws ParseException If there is an error parsing the server's response. This can happen if the server's response does not match the expected format.
     * @throws JRException If there is an error generating the report. This can happen if there's a problem with the report template, the data, or the JasperReports engine.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void loadReportItems() throws IOException, MalformedURLException, ParseException, JRException{
        
        switch(reportType) {
            case GENRES_BASIC:
                this.loadItems();
                break;
            case GENRES_FULL:
                this.loadItems();
                this.loadSubItems();
                break;
        }
    }
    
    /**
     * Loads the genre items.
     *
     * This method loads the genre items from the Jellyfin server. 
     * It creates a new LoadGenres object, sets the necessary parameters, and then requests the genres from the server. 
     * It then loops through the genres, creates a new JellyfinReportGenresItem for each one, loads the metadata for the genre, and adds the item to the items list. Finally, it sorts the items list in ascending order by name.
     *
     * @throws IOException If an I/O error occurs. This can happen if there's a problem with the network connection, the server, or the local machine.
     * @throws MalformedURLException If the URL of the Jellyfin server is not formatted correctly.
     * @throws ParseException If there is an error parsing the server's response. This can happen if the server's response does not match the expected format.
     * @since 1.0
     * @author Cesar Bianchi
     */
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
        
        items.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
    }
    
    /**
     * Loads the sub-items for each genre.
     *
     * This method loads the sub-items for each genre from the Jellyfin server. 
     * It first gets all folders from the server, then gets all items for each folder. For each item, it gets the metadata and checks 
     * if the genre of the item is the same as the genre of the genre-item. If it is, it adds the item to the genre-item's list of episodes.
     *
     * @throws IOException If an I/O error occurs. This can happen if there's a problem with the network connection, the server, or the local machine.
     * @throws ParseException If there is an error parsing the server's response. This can happen if the server's response does not match the expected format.
     * @since 1.1
     * @author Cesar Bianchi
     */
    private void loadSubItems() {
        
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
            
            //3* For each episode, Get the metadata and check if the genre episode is the same of genres-item
            LoadItemMetadata loadEpisodeMetadata = new LoadItemMetadata();
            loadEpisodeMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadEpisodeMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadEpisodeMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            for (int nI = 0; nI < this.items.size(); nI++){
            
                //for (int nJ = 0; nJ < 10; nJ++){
                for (int nJ = 0; nJ < nonOrdenedEpisodes.size(); nJ++){
                    
                    loadEpisodeMetadata.setcItemID(nonOrdenedEpisodes.get(nJ).getId());                
                    JellyfinItemMetadata genreItemMetadata = loadEpisodeMetadata.requestItemMetadata();                            
                    for (int nK = 0; nK < genreItemMetadata.getGenreItems().size(); nK++){
                    
                        if (genreItemMetadata.getGenreItems().get(nK).getId().equals(this.getItems().get(nI).getId())){
                            
                            this.items.get(nI).addGenreEpisode(nonOrdenedEpisodes.get(nJ),genreItemMetadata);
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
     * Prints the genre report.
     *
     * This method generates and prints the genre report based on the report type.
     * If the report type is GENRES_BASIC, it generates a basic report. If the report type is GENRES_FULL, it generates a full report with sub-items. 
     * The method first compiles the report, then sets the data source and report parameters, and finally fills the report and shows it.
     *
     * @throws JRException If there is an error generating the report. This can happen if there's a problem with the report template, the data, or the JasperReports engine.
     * @throws MalformedURLException If the URL of the Jellyfin server is not formatted correctly.
     * @throws IOException If an I/O error occurs. This can happen if there's a problem with the network connection, the server, or the local machine.
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

        //Set report Data Source
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

    /**
     * Retrieves the items property of this JellyfinReportGenres.
     *
     * @return A JellyfinReportGenresStructure object representing the items of this JellyfinReportGenres. This includes the genre items and their sub-items.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportGenresStructure getItems() {
        return items;
    }
    
}
