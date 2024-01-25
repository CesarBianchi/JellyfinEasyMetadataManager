package com.lariflix.jemm.forms;

/**
 * The WaitingPanel class represents a panel that displays a waiting message
 * while downloading or uploading data.
 *
 * @author Cesar Bianchi
 */
public class WaitingPanel extends javax.swing.JPanel {

    // Constants for the selected option
    private final int DOWNLOADING_DATA = 1;
    private final int UPLOADING_DATA = 2;
    
    // The currently selected option
    private int SELECTED_OPTION = 0;
    
    // The message to be displayed
    private String cMessage = new String();
    
    // The base URL for downloading or uploading data
    private String baseURL = new String();
    
    /**
     * Constructs a WaitingPanel object with the specified base URL and option.
     * 
     * @param cInsURL the base URL for downloading or uploading data
     * @param nOption the option for displaying the waiting message (1 for downloading, 2 for uploading)
     */
    public WaitingPanel(String cInsURL, int nOption) {       
        initComponents();
        
        this.setBaseURL(cInsURL);
        if (nOption == DOWNLOADING_DATA){
            this.setOptionDowloading();
        } else if (nOption == UPLOADING_DATA){
            this.setOptionUploading();
        }
    }

    /**
     * Sets the option for downloading data.
     */
    public void setOptionDowloading() {
        this.SELECTED_OPTION = DOWNLOADING_DATA;
        this.setcMessage("Downloading data from ".concat(this.getBaseURL()));
        jLabel2.setText(this.getcMessage());
    }
    
    /**
     * Sets the option for uploading data.
     */
    public void setOptionUploading() {
        this.SELECTED_OPTION = UPLOADING_DATA;
        this.setcMessage("Uploading data to ".concat(this.getBaseURL()));
        jLabel2.setText(this.getcMessage());
    }

    /**
     * Returns the base URL for downloading or uploading data.
     * 
     * @return the base URL
     */
    public String getBaseURL() {
        return baseURL;
    }

    /**
     * Sets the base URL for downloading or uploading data.
     * 
     * @param baseURL the base URL
     */
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    /**
     * Returns the current message to be displayed.
     * 
     * @return the message
     */
    public String getcMessage() {
        return cMessage;
    }

    /**
     * Sets the message to be displayed.
     * 
     * @param cMessage the message
     */
    public void setcMessage(String cMessage) {
        this.cMessage = cMessage;
    }
    
    // Rest of the code...
}
