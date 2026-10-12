package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.LoadNFOFile;
import com.lariflix.jemm.dtos.JellyfinItem;
import com.lariflix.jemm.dtos.nfo.JemmNFO;
import com.lariflix.jemm.dtos.nfo.JemmNFODiffs;
import com.lariflix.jemm.utils.JellyfinUtilFunctions;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

/**
 *
 * @author cesarbianchi
 */
public class NFODialog extends JDialog {
    private NFOStructurePanel NFODiag = new NFOStructurePanel();
    private javax.swing.JPanel jPanelMain = null;

    public NFODialog(JFrame parent) {
        super(parent, parent.getTitle(), true);
        jPanelMain = NFODiag.jPanelBase;
        this.setSize(1165, 551);
        this.setLocationRelativeTo(parent);
        this.setUndecorated(true);
        
        NFODiag.jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor((Component) e.getSource());
                dialog.dispose();
                NFODiag.isImportNFO = false;
            }
        });
        
        NFODiag.jButtonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor((Component) e.getSource());
                dialog.dispose();
                NFODiag.isImportNFO = true;
            }
        });
        
        this.add(NFODiag);
        
    }
    
    @Override
    public void setVisible(boolean type){        
        this.setVisible(type);        
    }
    
    /**
     * Loads the NFO content, builds the tree view, and populates the diff grid
     * for the specified Jellyfin item.
     *
     * @param cNFOFile path to the NFO file to be imported
     * @param itemID identifier of the Jellyfin item being compared
     * @param itemObj current Jellyfin item data used to calculate differences
     * @throws IOException if the NFO file cannot be read or parsed
     * @since 1.0
     * @see LoadNFOFile
     */
    public void loadTree(String cNFOFile, String itemID, JellyfinItem itemObj) throws IOException{
        //Load NFO File        
        LoadNFOFile loadTree = new LoadNFOFile();
        loadTree.setNfoFilePath(cNFOFile);
        loadTree.loadXMLFile();

        //Load Tree with NFO content
        TreeModel model = new DefaultTreeModel(loadTree.getTree());        
        NFODiag.jTree1.setModel(model);        
        for (int i = 0; i < NFODiag.jTree1.getRowCount(); i++) {
            NFODiag.jTree1.expandRow(i);
        }
                
        //Load Differences Grid
        loadTree.loadDifferences(itemID,itemObj);
        ArrayList<JemmNFODiffs> differences = loadTree.getDifferences();        
        DefaultTableModel modelGrid = (DefaultTableModel) NFODiag.jTable1.getModel();
        modelGrid = new JellyfinUtilFunctions().eraseModel(modelGrid);        
        for (int nI = 0; nI < differences.size(); nI++){
            Object[] row = { differences.get(nI).getProperty(), differences.get(nI).getAsis(), differences.get(nI).getTobe() };
            modelGrid.addRow(row);
        }
        NFODiag.jTable1.setModel(modelGrid);
        this.resizeTableWidthColumns(NFODiag.jTable1);
        
        NFODiag.NFOObject = loadTree.getNFOObject();
    }
    
    private void resizeTableWidthColumns(JTable table) {
        //Resize Table Columns (Width)
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +5 , width);
            }
            
            if(width < 100)
                width=100;
        
            columnModel.getColumn(column).setPreferredWidth(width);
        }
        table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
    }
 
    public JemmNFO getNFOObject(){
        return NFODiag.NFOObject;
    }
    
    public boolean isProcessNFO(){
        return NFODiag.isImportNFO;
    }
    
}
