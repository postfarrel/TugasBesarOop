package view;
import Bean.DataJenis;
import java.awt.*;
import koneksi.*;
import javax.swing.*;

import Tabel.*;

import java.awt.event.*;
import java.sql.*;

public class formJenis extends javax.swing.JFrame {
    private Object tabel;
    private TabelDataJenis ModelDataJenis;
    private koneksi conn;
    
    public formJenis() {
        initComponents();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height>screenSize.width){
            frameSize.height=screenSize.width;
        }
        this.setLocation((screenSize.width-frameSize.width)/2,
                (screenSize.height=screenSize.height)/4);
        ModelDataJenis = new TabelDataJenis();
        tbljenis.setModel(ModelDataJenis);
        conn = new koneksi();
        tampil();
        setEditOff();
        kdauto();
    }

    private void tampil() {
        try{
            int baris = tbljenis.getRowCount ();
            for (int i = 0; i < baris; i++) {
                ModelDataJenis.delete(0, baris);
            }
            String sql = "select * from tbljenis";
            ResultSet rs = conn.getData(sql);
            while (rs.next()) {
                DataJenis jenis = new DataJenis();
                jenis.setKodeJenis(rs.getString(1));
                jenis.setJenis(rs.getString(2));
                ModelDataJenis.add(jenis);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    
   
    int row = 0;
    public void TampilText(){
        row= tbljenis.getSelectedRow();
        DataJenis jenis = ModelDataJenis.get(row);
        kdjenis.setText(jenis.getKodeJenis());
        jnsbrg.setText(jenis.getJenis());
        save.setEnabled(false);
        setEditOn();
    }

        public void kdauto(){
            try{
                String sql = "select max(right(kode_jenis,3)) from tbljenis";
                ResultSet rs = conn.getData(sql);
                while(rs.next()){
                    if(rs.first()==true){
                        rs.last();
                        int hitung = rs.getInt(1)+1;
                        String itung = String.valueOf(hitung);
                        int panjang = itung.length();
                        for(int i=0;i<2-panjang;i++){
                            itung = "00"+hitung;
                        }
                        kdjenis.setText("J"+itung);
                        }else{
                        jnsbrg.setText("J001");
                    }
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        
        }
    
    public void BersihData(){
    kdjenis.setText("");
    jnsbrg.setText("");
    }
    
    public void setEditOff(){
        kdjenis.setEnabled(false);
        jnsbrg.setEnabled(false);
        save.setEnabled(false);
        delete.setEnabled(false);
        update.setEnabled(false);
        add.setEnabled(true);
    }
    
    public void setEditOn(){
        kdjenis.setEnabled(true);
        jnsbrg.setEnabled(true);
        delete.setEnabled(true);
        update.setEnabled(true);
        add.setEnabled(false);
    }
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kdjenis = new javax.swing.JTextField();
        jnsbrg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbljenis = new javax.swing.JTable();
        add = new javax.swing.JButton();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Entri data jenis Barang");

        jLabel2.setText("Kode Jenis :");

        jLabel3.setText("Jenis Barang :");

        kdjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdjenisActionPerformed(evt);
            }
        });

        jnsbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnsbrgActionPerformed(evt);
            }
        });

        tbljenis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbljenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbljenisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbljenis);

        add.setText("Add New");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        cancel.setText("cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(kdjenis)
                                            .addComponent(jnsbrg, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(add)
                                        .addGap(18, 18, 18)
                                        .addComponent(save)
                                        .addGap(18, 18, 18)
                                        .addComponent(update)
                                        .addGap(18, 18, 18)
                                        .addComponent(delete)
                                        .addGap(18, 18, 18)
                                        .addComponent(cancel)
                                        .addGap(18, 18, 18)
                                        .addComponent(close)))
                                .addGap(0, 90, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(233, 233, 233))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kdjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jnsbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(save)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(cancel)
                    .addComponent(close))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jnsbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnsbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnsbrgActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        BersihData();
        kdjenis.requestFocus();
        save.setEnabled(true);
        setEditOn();
    }//GEN-LAST:event_addActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
            // TODO add your handling code here:
            String KJ=kdjenis.getText();
        String J=jnsbrg.getText();
        if ((KJ.isEmpty()) | (J.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                    "silahkan dilengkapi");
        kdjenis.requestFocus();
    
    }else{
    try{
        String SQL = "insert into tbljenis values ("
                + "'"+kdjenis.getText()+"',"
                + "'"+jnsbrg.getText()+"'"
                + ")";
        conn.query(SQL);
        tampil();
        JOptionPane.showMessageDialog(null, jnsbrg.getText()+
                "Berhasil Disimpan");
        BersihData();
        setEditOff();
        add.setEnabled(true);
    } catch (Exception ex){
    System.err.println(ex.getMessage());
    }
        }               
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
         String KJ=kdjenis.getText();
        String J=jnsbrg.getText();
        if ((KJ.isEmpty()) | (J.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                    "silahkan dilengkapi");
        kdjenis.requestFocus();
    }else{
    try{
        String SQL = "update tbljenis set "
                + " jenis ='"+jnsbrg.getText()+"' where"
                + " kode_jenis ='"+kdjenis.getText()+"'";
          
        conn.query(SQL);
        tampil();
        JOptionPane.showMessageDialog(null, kdjenis.getText()+
                "Berhasil Diubah");
        BersihData();
        setEditOff();
        add.setEnabled(true);
    } catch (Exception ex){
    System.err.println(ex.getMessage());
    } 
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        String KJ=kdjenis.getText();
        String J=jnsbrg.getText();
        if ((KJ.isEmpty()) | (J.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                    "silahkan dilengkapi");
        kdjenis.requestFocus();
    
    }else {
    try {
        String SQL = "delete from tbljenis where "
                + "jenis = '"+jnsbrg.getText()+"'";
        conn.query(SQL);
        tampil();
        JOptionPane.showMessageDialog(null,
                "data dihapus");
        BersihData();
        setEditOff();
        add.setEnabled(true);
    } catch (Exception ex){
    System.err.println(ex);
    }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        setEditOff();
    }//GEN-LAST:event_cancelActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(null,"This application will be close"+
                "\n if you pass button OK","information",
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)
                ==JOptionPane.OK_OPTION){
            this.dispose();            
        }
    }//GEN-LAST:event_closeActionPerformed

    private void tbljenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbljenisMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1){
            TampilText();
        }
    }//GEN-LAST:event_tbljenisMouseClicked

    private void kdjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdjenisActionPerformed
    }//GEN-LAST:event_kdjenisActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new HalamanUtama().show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(formJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formJenis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton close;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jnsbrg;
    private javax.swing.JTextField kdjenis;
    private javax.swing.JButton save;
    private javax.swing.JTable tbljenis;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
