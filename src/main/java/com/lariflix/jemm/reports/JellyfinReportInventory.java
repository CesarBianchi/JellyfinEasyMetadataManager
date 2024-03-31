package com.lariflix.jemm.reports;

import com.lariflix.jemm.utils.JellyfinReportTypes;
import com.lariflix.jemm.core.LoadFolders;
import com.lariflix.jemm.core.LoadItemMetadata;
import com.lariflix.jemm.core.LoadItems;
import com.lariflix.jemm.dtos.JellyfinFolders;
import com.lariflix.jemm.dtos.JellyfinInstanceDetails;
import com.lariflix.jemm.dtos.JellyfinItemMetadata;
import com.lariflix.jemm.dtos.JellyfinItems;
import com.lariflix.jemm.utils.JellyfimParameters;
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
import java.io.IOException;
import java.io.InputStream;

/**
 * The JellyfinReportInventory class is used to generate inventory reports from a Jellyfin server.
 *
 * This class retrieves inventory data from the Jellyfin server and formats it into a report. 
 * The report includes details such as the item name, the number of items in each category, and other relevant details.
 *
 * @author Cesar Bianchi
 */
public class JellyfinReportInventory {
    
    static JellyfinInstanceDetails instanceData = new JellyfinInstanceDetails();    
    private JellyfinReportInventoryStructure items = new JellyfinReportInventoryStructure();
    private int totalsubItems = 0;
    private JellyfinReportTypes reportType = null;  
    
    /**
     * Constructor for the JellyfinReportInventory class.
     *
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be any of the types defined in the JellyfinReportTypes class.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportInventory(JellyfinReportTypes rpType) {
        this.reportType = rpType;
    }

    /**
     * Constructor for the JellyfinReportInventory class.
     *
     * @param instanceData A JellyfinInstanceDetails object containing the details of the Jellyfin instance from which to generate the report. This includes the URL, API token, and other necessary details.
     * @param rpType A JellyfinReportTypes object representing the type of report to generate. This could be any of the types defined in the JellyfinReportTypes class.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportInventory(JellyfinInstanceDetails instanceData, JellyfinReportTypes rpType) {
        JellyfinReportInventory.instanceData = instanceData;
        this.reportType = rpType;
    }

    public void  loadReportItems() throws IOException, MalformedURLException, ParseException, JRException{
        
        switch(reportType) {
            case INVENTORY_BASIC:
                this.loadItems();
                this.loadSubItems(JellyfinReportTypes.INVENTORY_BASIC);
                this.setTotalOfSubItems();
                break;
            case INVENTORY_FULL:
                this.loadItems();
                this.loadSubItems(JellyfinReportTypes.INVENTORY_FULL);
                this.setTotalOfSubItems();
                break;
        }
    }
    
    /**
     * Loads the report items.
     *
     * This method loads the report items based on the report type. If the report type is INVENTORY_BASIC, it loads the items and their basic sub-items. If the report type is INVENTORY_FULL, it loads the items and their full sub-items. After loading the items and sub-items, it sets the total number of sub-items.
     *
     * @throws IOException If an I/O error occurs. This can happen if there's a problem with the network connection, the server, or the local machine.
     * @throws MalformedURLException If the URL of the Jellyfin server is not formatted correctly.
     * @throws ParseException If there is an error parsing the server's response. This can happen if the server's response does not match the expected format.
     * @throws JRException If there is an error generating the report. This can happen if there's a problem with the report template, the data, or the JasperReports engine.
     * @since 1.1
     * @author Cesar Bianchi
     */
    private void loadItems() throws IOException, MalformedURLException, ParseException{
        
        LoadFolders loadItems = new LoadFolders(JellyfimParameters.FOLDERS_AND_SUBFOLDERS);
        loadItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadItems.setcUserAdminID(instanceData.adminUser.getId());        
        JellyfinFolders folders = loadItems.requestFolders();
        
        for(int nI = 0; nI < folders.getItems().size();nI++){            
            JellyfinReportInventoryItem item = new JellyfinReportInventoryItem();
            item.setItem( folders.getItems().get(nI) );
            
            //load itemMetadata
            LoadItemMetadata loadItemMetadata = new LoadItemMetadata();
            loadItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
            loadItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
            loadItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());
            loadItemMetadata.setcItemID(item.getId());            
            JellyfinItemMetadata itemMetadata = loadItemMetadata.requestItemMetadata();            
            item.setItemMetadata(itemMetadata);
            
            items.add(item);
        }
        
        items.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));
        
    }

    /**
     * Loads the sub-items for each item.
     *
     * This method loads the sub-items for each item from the Jellyfin server based on the report type. 
     * If the report type is INVENTORY_BASIC, it loads the basic sub-items. 
     * If the report type is INVENTORY_FULL, it loads the full sub-items and their metadata.
     *
     * @param tpInventoryReport A JellyfinReportTypes object representing the type of report to generate. This could be either INVENTORY_BASIC or INVENTORY_FULL.
     * @throws IOException If an I/O error occurs. This can happen if there's a problem with the network connection, the server, or the local machine.
     * @throws ParseException If there is an error parsing the server's response. This can happen if the server's response does not match the expected format.
     * @since 1.1
     * @author Cesar Bianchi
     */
    private void loadSubItems(JellyfinReportTypes tpInventoryReport){
        
        LoadItems loadSubItems = new LoadItems(JellyfimParameters.JUST_ITEMS);
        loadSubItems.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
        loadSubItems.setApiToken(instanceData.getCredentials().getTokenAPI());
        loadSubItems.setcUserAdminID(instanceData.adminUser.getId());
        
        for (int nI = 0; nI < items.size(); nI++){
            
            loadSubItems.setcParentID(items.get(nI).getId());            
            try {
                JellyfinItems subItems = loadSubItems.requestItems();
                
                items.get(nI).setSubItems(subItems);
                
                //load subitems metadata
                if (tpInventoryReport == JellyfinReportTypes.INVENTORY_FULL){
                    for (int nJ = 0; nJ < items.get(nI).getSubItems().size(); nJ++){ 
                        LoadItemMetadata loadsubItemMetadata = new LoadItemMetadata();
                        loadsubItemMetadata.setJellyfinInstanceUrl(instanceData.getCredentials().getBaseURL());
                        loadsubItemMetadata.setApiToken(instanceData.getCredentials().getTokenAPI());
                        loadsubItemMetadata.setcUserAdminID(instanceData.getAdminUser().getId());

                        String subItemID = items.get(nI).getSubItems().get(nJ).getId();                            

                        loadsubItemMetadata.setcItemID(subItemID);                
                        JellyfinItemMetadata subItemMetadata = loadsubItemMetadata.requestItemMetadata();                                

                        items.get(nI).getSubItems().get(nJ).setSubItemMetadata(subItemMetadata);
                    }
                }
                
            } catch (IOException ex) {
                Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(JellyfinReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
    }

    /**
     * Prints the inventory report.
     *
     * This method generates and prints the inventory report based on the report type. 
     * If the report type is INVENTORY_BASIC, it generates a basic report. 
     * If the report type is INVENTORY_FULL, it generates a full report with sub-items. 
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
            case INVENTORY_BASIC:
                
                if(instanceData.isDebug()){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");                    
                    jrxmlFile = localReportBasePath.concat("/InstanceInventoryBasic/JemmInstanceInventoryBasic.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstanceInventoryBasic/JemmInstanceInventoryBasic.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                }
                break;
            
            case INVENTORY_FULL:
            
                if(instanceData.isDebug() ){                    
                    //DEBUG WAY
                    System.out.println("This Application is running on Netbeans, in DEBUG MODE");   
                    jrxmlFile = localReportBasePath.concat("/InstanceInventoryFull/JemmInstanceInventoryFull.jrxml");       
                    draw = JRXmlLoader.load( jrxmlFile );
                    report =  JasperCompileManager.compileReport( draw );
                    
                    
                    jrxmlSubRepFile = localReportBasePath.concat("/InstanceInventoryFull/JemmInstanceInventoryFullSubItems.jrxml");       
                    drawSub = JRXmlLoader.load( jrxmlFile );
                    subreport = JasperCompileManager.compileReport( drawSub );
                    
                    //Use a localfile subreport
                    JasperCompileManager.compileReportToFile(jrxmlSubRepFile,tempFilesPath.concat("JemmInstanceInventoryFullSubItems.jasper"));
                } else {
                    //EMBEBED WAY
                    jrxmlFile = resorceReportBasePath.concat("/InstanceInventoryFull/JemmInstanceInventoryFull.jrxml");
                    InputStream drawIS = getClass().getResourceAsStream(jrxmlFile);
                    report =  JasperCompileManager.compileReport( drawIS );
                    
                    //Extract subreport from resource to a localfile                    
                    jrxmlSubRepFile =  resorceReportBasePath.concat("/InstanceInventoryFull/JemmInstanceInventoryFullSubItems.jrxml");                    
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
    
    /**
     * Retrieves the instanceData property of the JellyfinReportInventory class.
     *
     * @return A JellyfinInstanceDetails object representing the details of the Jellyfin instance from which to generate the report. This includes the URL, API token, and other necessary details.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public static JellyfinInstanceDetails getInstanceData() {
        return instanceData;
    }

    /**
     * Retrieves the items property of this JellyfinReportInventory.
     *
     * @return A JellyfinReportInventoryStructure object representing the items of this JellyfinReportInventory. This includes the inventory items and their sub-items.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public JellyfinReportInventoryStructure getItems() {
        return items;
    }

    /**
     * Sets the instanceData property of the JellyfinReportInventory class.
     *
     * @param instanceData A JellyfinInstanceDetails object that should be used as the new instance data for the JellyfinReportInventory class. 
     * This includes the URL, API token, and other necessary details.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public static void setInstanceData(JellyfinInstanceDetails instanceData) {
        JellyfinReportInventory.instanceData = instanceData;
    }

    /**
     * Sets the items property of this JellyfinReportInventory.
     *
     * @param items A JellyfinReportInventoryStructure object that should be used as the new items for this JellyfinReportInventory. 
     * This includes the inventory items and their sub-items.
     * @since 1.1
     * @author Cesar Bianchi
     */
    public void setItems(JellyfinReportInventoryStructure items) {
        this.items = items;
    }

    /**
     * Sets the totalsubItems property of this JellyfinReportInventory.
     *
     * This method calculates the total number of sub-items in all items of this JellyfinReportInventory and sets the totalsubItems property to this value.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    private void setTotalOfSubItems() {
        // method body
    }
    
}
