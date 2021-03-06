/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author $ujen
 */
public class ExtractionGUI extends javax.swing.JFrame {
    private String filename;
   // private String defaultDirectory="C:\\Users\\$ujen\\Documents\\NetBeansProjects\\ETLTool";
    private String defaultDirectory="C:\\DWM\\ETLTool";

    /**
     * Creates new form ExtractionGUI
     */
    
    
    public ExtractionGUI() {
        
        this.setVisible(true);
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

        mdbTables = new javax.swing.ButtonGroup();
        sqlTables = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFile = new javax.swing.JTextField();
        textBrowse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        mdbFile = new javax.swing.JTextField();
        mdbBrowse = new javax.swing.JButton();
        mdbTable1 = new javax.swing.JCheckBox();
        mdbTable2 = new javax.swing.JCheckBox();
        mdbTable3 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        SQLDBName = new javax.swing.JTextField();
        sqlConnect = new javax.swing.JButton();
        sqlTable1 = new javax.swing.JCheckBox();
        sqlTable2 = new javax.swing.JCheckBox();
        sqlTable3 = new javax.swing.JCheckBox();
        extractButton = new javax.swing.JButton();
        statusField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Extraction");

        jLabel2.setText("Choose text file");

        textBrowse.setText("Browse");
        textBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBrowseActionPerformed(evt);
            }
        });

        jLabel3.setText("Choose MS Access File");

        mdbBrowse.setText("Browse");
        mdbBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdbBrowseActionPerformed(evt);
            }
        });

        mdbTables.add(mdbTable1);
        mdbTable1.setText("table1");
        mdbTable1.setVisible(false);

        mdbTables.add(mdbTable2);
        mdbTable2.setText("table2");
        mdbTable2.setVisible(false);

        mdbTables.add(mdbTable3);
        mdbTable3.setText("table3");
        mdbTable3.setVisible(false);

        jLabel4.setText("Enter SQL Databse Name");

        sqlConnect.setText("Connect");
        sqlConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqlConnectActionPerformed(evt);
            }
        });

        sqlTables.add(sqlTable1);
        sqlTable1.setText("table1");
        sqlTable1.setVisible(false);

        sqlTables.add(sqlTable2);
        sqlTable2.setText("table2");
        sqlTable2.setVisible(false);

        sqlTables.add(sqlTable3);
        sqlTable3.setText("table3");
        sqlTable3.setVisible(false);

        extractButton.setText("Extract");
        extractButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractButtonActionPerformed(evt);
            }
        });

        statusField.setText("Status : ");
        statusField.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mdbTable1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mdbTable2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mdbTable3))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SQLDBName, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                    .addComponent(mdbFile, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFile, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textBrowse)
                                    .addComponent(mdbBrowse)
                                    .addComponent(sqlConnect)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sqlTable1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sqlTable2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sqlTable3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(extractButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mdbFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mdbBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mdbTable1)
                    .addComponent(mdbTable2)
                    .addComponent(mdbTable3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SQLDBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sqlConnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sqlTable1)
                    .addComponent(sqlTable2)
                    .addComponent(sqlTable3))
                .addGap(18, 18, 18)
                .addComponent(extractButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusField)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(569, 385));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mdbBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdbBrowseActionPerformed
 
        JFileChooser browse=new JFileChooser(defaultDirectory);
        browse.showOpenDialog(null);
 
        if(browse.getSelectedFile()!=null){
            try {
                File f=browse.getSelectedFile();
                filename=f.getAbsolutePath();
                mdbFile.setText(filename);
                ExtractMdb exMDB=new ExtractMdb(filename);
                exMDB.extractTable("Products");
            } catch (Exception ex) {
                Logger.getLogger(ExtractionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }//GEN-LAST:event_mdbBrowseActionPerformed

    private void sqlConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqlConnectActionPerformed
        
        if(!SQLDBName.getText().equals("")){
        try {
            ExtractSQL exSQL=null;
            try {
                exSQL = new ExtractSQL(SQLDBName.getText());
            } catch (IOException ex) {
                Logger.getLogger(ExtractionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            String table[]=exSQL.getTableNames();
            String a[]=exSQL.getTableNames();
           
            sqlTable3.setText(table[2]);
            sqlTable1.setText(table[0]);
            sqlTable2.setText(table[1]);
            sqlTable1.setVisible(true);           
            sqlTable2.setVisible(true);           
            sqlTable3.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(ExtractionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please enter Database name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_sqlConnectActionPerformed

    private void extractButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractButtonActionPerformed
       
        boolean flag=false;
        File file=null;
        
//        if(!mdbFile.getText().equals("")){
//            flag=true;
//        }
        
        if(!SQLDBName.getText().equals("")){
            flag=true;
        try {
            ExtractSQL exSQL=new ExtractSQL(SQLDBName.getText());
            
            if(sqlTable1.isSelected()){
                exSQL.extractTable(sqlTable1.getText());
            }
            if(sqlTable2.isSelected()){
                exSQL.extractTable(sqlTable2.getText());
            }
            if(sqlTable3.isSelected()){
                exSQL.extractTable(sqlTable3.getText());
            }
            
            file=exSQL.getOutputFile();
           
        } catch (IOException ex) {
            Logger.getLogger(ExtractionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        if(!textFile.getText().equals("")){
            flag=true;
            try {
                ExtractTxt exTxt=new ExtractTxt(filename);
                file=exTxt.getOutputFile();
           
            } catch (IOException ex) {
                Logger.getLogger(ExtractionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         if (flag){
             if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().edit(file);
                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(ExtractionGUI.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    
                    int msg;
                    msg = JOptionPane.showConfirmDialog(null, "Do you want to transform the file", "",JOptionPane.YES_NO_OPTION , JOptionPane.INFORMATION_MESSAGE);
                    //System.out.println(msg);
                    
                    if(msg==1){
                        this.dispose();
                    }
                    else if(msg==0){
                    TransformationGUI tr=new TransformationGUI(file.getAbsolutePath());
                }
                    
                } catch (IOException ex) {
                    Logger.getLogger(ExtractionGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                        } else {
    // dunno, up to you to handle this
                            }
        }
        else if(flag==false) {
            
            JOptionPane.showMessageDialog(null, "Please enter atleast one Data Source", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_extractButtonActionPerformed

    private void textBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBrowseActionPerformed
 
        JFileChooser browse=new JFileChooser(defaultDirectory);
        browse.showOpenDialog(null);
 
        if(browse.getSelectedFile()!=null){
        File f=browse.getSelectedFile();
        filename=f.getAbsolutePath();
        textFile.setText(filename);
       
        }   
    }//GEN-LAST:event_textBrowseActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExtractionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExtractionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExtractionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExtractionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExtractionGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SQLDBName;
    private javax.swing.JButton extractButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton mdbBrowse;
    private javax.swing.JTextField mdbFile;
    private javax.swing.JCheckBox mdbTable1;
    private javax.swing.JCheckBox mdbTable2;
    private javax.swing.JCheckBox mdbTable3;
    private javax.swing.ButtonGroup mdbTables;
    private javax.swing.JButton sqlConnect;
    private javax.swing.JCheckBox sqlTable1;
    private javax.swing.JCheckBox sqlTable2;
    private javax.swing.JCheckBox sqlTable3;
    private javax.swing.ButtonGroup sqlTables;
    private javax.swing.JLabel statusField;
    private javax.swing.JButton textBrowse;
    private javax.swing.JTextField textFile;
    // End of variables declaration//GEN-END:variables
}
