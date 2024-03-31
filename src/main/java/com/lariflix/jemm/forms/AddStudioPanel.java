
package com.lariflix.jemm.forms;

import com.lariflix.jemm.core.ConnectJellyfinAPI;
import com.lariflix.jemm.dtos.JellyfinCadStudioItem;
import com.lariflix.jemm.dtos.JellyfinCadStudioItems;
import com.lariflix.jemm.utils.JellyfinUtilFunctions;
import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.json.simple.parser.ParseException;

/**
 * This class represents a panel for adding studios in the application.
 * It extends javax.swing.JPanel and provides the necessary interface and methods to handle user interactions for adding new studios.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 * @see javax.swing.JPanel
 
 */
public class AddStudioPanel extends javax.swing.JPanel {

    static int existingStudioSelected = 1;
    static int newStudioSelected = 2;
    static ConnectJellyfinAPI connectAPI = new ConnectJellyfinAPI();
    
    /**
     * Constructs a new AddStudioPanel.
     * This constructor initializes the components of the panel.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public AddStudioPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Type of Studio"));

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Existing Studio");
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }
        });
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        jRadioButton2.setText("New Studio");
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jRadioButton1)
                .addGap(26, 26, 26)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Existing Studio"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Studio"));

        jLabel1.setText("ID:");

        jTextField1.setEnabled(false);

        jLabel2.setText("Name:");

        jTextField2.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(358, Short.MAX_VALUE))
        );

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 249, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton1StateChanged

    }//GEN-LAST:event_jRadioButton1StateChanged

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        this.itemChecked(existingStudioSelected);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged

    }//GEN-LAST:event_jRadioButton2StateChanged

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        this.itemChecked(newStudioSelected);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.studioSelected();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        this.studioSelected();
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //First, check if all mandatory fields are full
        if (!jTextField2.getText().trim().isEmpty() ) {
            Window win = SwingUtilities.getWindowAncestor(this);
            if (win != null) {
                win.dispose();
            }
        } else {
            ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/images/jellyfinIconTransparency_small.png"));
            JOptionPane.showMessageDialog(this,"One or more mandatory fields are empty","Pay Attention!! ",JOptionPane.WARNING_MESSAGE,icon);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //Clean fields before end form
        jTextField1.setText("");
        jTextField2.setText("");

        Window win = SwingUtilities.getWindowAncestor(this);
        if (win != null) {
            win.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Handles the event of a studio being selected from the table.
     * This method gets the selected row from the table and retrieves the id and name of the studio from the selected row.
     * It then sets the text of the id and name text fields to the retrieved id and name.
     * If no row is selected, it does nothing.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    private void studioSelected() {
        
        if (jTable1.getSelectedRow() >= 0){
        
            String cID = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
            String cName = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString();
        
            jTextField1.setText(cID);
            jTextField2.setText(cName);
        }

    }
    
    /**
     * Handles the event of a radio button being selected.
     * This method checks which radio button was selected and performs the appropriate actions.
     * If the "Existing Studio" radio button was selected, it enables the table, sets its background color to white, disables the text field, and loads the existing studios into the table.
     * If the "New Studio" radio button was selected, it disables the table, sets its background color to gray, enables the text field, and clears the text fields.
     * 
     * @param selectedOption The option that was selected. 1 for "Existing Studio", 2 for "New Studio".
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    private void itemChecked(int selectedOption) {
        
        if (selectedOption == existingStudioSelected){
            
            //UnLooping Control
            jRadioButton1.setSelected(true); // For not UnCheck
            if (jRadioButton2.isSelected())
                jRadioButton2.setSelected(false);
            
            //Enable itens control
            jTable1.setEnabled(true);
            Color gray = new Color(255, 255, 255);
            jTable1.setBackground(gray);
            jTextField2.setEditable(false);
            jTextField2.setEnabled(false);
            jTextField2.setText("");
            
            //load rows of grid
            this.loadExistingStudio();
            
        } else if ((selectedOption == newStudioSelected)) {
            
            //UnLooping Control
            jRadioButton2.setSelected(true); // For not UnCheck
            if (jRadioButton1.isSelected())
                jRadioButton1.setSelected(false);
            
            //Enable itens control
            jTable1.setEnabled(false);
            jTable1.clearSelection();
            
            Color gray = new Color(237, 237, 237);
            jTable1.setBackground(gray);
            jTextField2.setEditable(true);
            jTextField2.setEnabled(true);
            
            //Clean fields before
            jTextField1.setText("");
            jTextField2.setText("");


        }
        
    }
    
    /**
     * Retrieves the instance of ConnectJellyfinAPI used by the AddStudioPanel.
     * 
     * @return The instance of ConnectJellyfinAPI used by the AddStudioPanel.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public static ConnectJellyfinAPI getLoadedData() {
        return connectAPI;
    }

    /**
     * Retrieves the instance of ConnectJellyfinAPI used by the AddStudioPanel.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public void setLoadedData(ConnectJellyfinAPI lData) {
        connectAPI = lData;
        loadExistingStudio();
    }
    
    /**
     * Loads the existing studios from the Jellyfin server and displays them in the table.
     * This method requests the existing studios from the Jellyfin server, clears the table, and adds the existing studios to the table.
     * Each row in the table represents a studio and contains the id and name of the studio.
     * After adding the existing studios to the table, it resizes the table width columns.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public void loadExistingStudio() {
        JellyfinCadStudioItem studioItem = new JellyfinCadStudioItem();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        //Request existing People
        JellyfinCadStudioItems existingStudios = null;
        try {
            existingStudios = connectAPI.getStudios();
        } catch (IOException ex) {
            Logger.getLogger(AddStudioPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AddStudioPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //add People in Grid Existing People
        //Clean Grid before load again
        model = new JellyfinUtilFunctions().eraseModel(model);
        for (int nI = 0; nI < existingStudios.getItems().size(); nI++ ){

            studioItem = existingStudios.getItems().get(nI);

            Object[] row = { studioItem.getId(), studioItem.getName() };
            model.addRow(row);                
        }
        jTable1.setModel(model);

        //Resize table width columns
        this.resizeTableWidthColumns(jTable1);
        
    }
    
    /**
     * Resizes the width of the columns of the given table based on the content of the cells.
     * This method iterates over each column of the table and for each column, it iterates over each row to find the maximum preferred width of the cells in the column.
     * It then sets the preferred width of the column to the maximum preferred width found.
     * If the maximum preferred width found is less than 100, it sets the preferred width of the column to 100.
     * After resizing the columns, it disables the auto resizing of the table.
     * 
     * @param table The table whose columns are to be resized.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
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
    
    /**
     * Retrieves the jTextField1 property of this AddStudioPanel.
     *
     * @return A JTextField object representing the jTextField1 of this AddStudioPanel. This JTextField is typically used for user input in a GUI.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JTextField getjTextField1() {
        return jTextField1;
    }

    /**
     * Sets the jTextField1 property of this AddStudioPanel.
     *
     * @param jTextField1 A JTextField object that should be used as the new jTextField1 for this AddStudioPanel. This JTextField is typically used for user input in a GUI.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    /**
     * Retrieves the jTextField2 property of this AddStudioPanel.
     *
     * @return A JTextField object representing the jTextField2 of this AddStudioPanel. This JTextField is typically used for user input in a GUI.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public JTextField getjTextField2() {
        return jTextField2;
    }

    /**
     * Sets the jTextField2 property of this AddStudioPanel.
     *
     * @param jTextField2 A JTextField object that should be used as the new jTextField2 for this AddStudioPanel. This JTextField is typically used for user input in a GUI.
     * @since 1.0
     * @author Cesar Bianchi
     */
    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }
    
         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
