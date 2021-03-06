/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import Bean.DataPetugas;
import java.awt.*;
import koneksi.*;
import javax.swing.*;

import Tabel.*;

import java.awt.event.*;
import java.sql.*;

public class FormPetugas extends javax.swing.JFrame {
private Object tabel;
    private TabelDataPetugas ModelDataPetugas;
    private koneksi conn;
    /**
     * Creates new form FormPetugas
     */
    public FormPetugas() {
        
        initComponents();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height>screenSize.height){
            frameSize.height=screenSize.height;
        }
        if(frameSize.width>screenSize.width){
            frameSize.width=screenSize.width;            
        }
        this.setLocation((screenSize.width-frameSize.width)/2,
                (screenSize.height=screenSize.height)/4);
        ModelDataPetugas = new TabelDataPetugas();
        formpetugas.setModel(ModelDataPetugas);
        conn = new koneksi();
        tampil();
        SetEditOff();
       }
    private void tampil(){
        try{
            int baris =formpetugas.getRowCount();
            for (int i =0; i < baris; i++){
                ModelDataPetugas.delete(0,baris);
            }
            String SQL = "select * from tblpetugas";
            ResultSet rs = conn.getData(SQL);
            while (rs.next()) {
                DataPetugas petugas = new DataPetugas();
                petugas.setIdPetugas (rs.getString(1));
                petugas.setNamaPetugas (rs.getString(2));
                petugas.setAlamat (rs.getString(3));
                petugas.setEmail (rs.getString(4));
                petugas.setTelepon (rs.getString(5));
                petugas.setPassword (rs.getString(6));
                petugas.setHakAkses (rs.getString(7));
                ModelDataPetugas.add(petugas);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
            }
    }
    int row = 0;
    public void TampilText(){
            row = formpetugas.getSelectedRow();
            DataPetugas aPetugas = ModelDataPetugas.get(row);
            txtpetugas.setText(aPetugas.getIdPetugas());
            txtnamapetugas.setText(aPetugas.getNamaPetugas());
            txtalamat.setText(aPetugas.getAlamat());
            txtemail.setText(aPetugas.getEmail());
            txttelepon.setText(aPetugas.getTelepon());
            txtpassword.setText(aPetugas.getPassword());
            txthakakses.setText(aPetugas.getHakAkses());
            save.setEnabled(false);
            SetEditOn();
            }
    
    public void BersihData(){
        txtpetugas.setText("");
        txtnamapetugas.setText("");
        txtalamat.setText("");
        txtemail.setText("");
        txttelepon.setText("");
        txtpassword.setText("");
        txthakakses.setText("");
        }
    
    public void SetEditOff(){
        txtpetugas.setEnabled(false);
        txtnamapetugas.setEnabled(false);
        txtalamat.setEnabled(false);
        txtemail.setEnabled(false);
        txttelepon.setEnabled(false);
        txtpassword.setEnabled(false);
        txthakakses.setEnabled(false);
        save.setEnabled(false);
        delete.setEnabled(false);
        update.setEnabled(false);           
        add.setEnabled(true);
    
    }

    public void SetEditOn(){
        txtpetugas.setEnabled(true);
        txtnamapetugas.setEnabled(true);
        txtalamat.setEnabled(true);
        txtemail.setEnabled(true);
        txttelepon.setEnabled(true);
        txtpassword.setEnabled(true);
        txthakakses.setEnabled(true);
        save.setEnabled(true);
        delete.setEnabled(true);
        update.setEnabled(true);           
        add.setEnabled(false);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpetugas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnamapetugas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttelepon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txthakakses = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        formpetugas = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        close = new javax.swing.JButton();
        add = new javax.swing.JButton();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Form Petugas");

        jLabel2.setText("ID Petugas");

        jLabel3.setText("Nama Petugas");

        txtnamapetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamapetugasActionPerformed(evt);
            }
        });

        jLabel4.setText("Alamat");

        jLabel5.setText("Email");

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabel6.setText("Telepon");

        jLabel7.setText("Password");

        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        jLabel8.setText("Hak Akes");

        formpetugas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(formpetugas);

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
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txtpetugas)
                    .addComponent(txtnamapetugas)
                    .addComponent(txtalamat)
                    .addComponent(txtemail)
                    .addComponent(txttelepon)
                    .addComponent(txtpassword)
                    .addComponent(txthakakses, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                        .addComponent(close)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthakakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(save)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(cancel)
                    .addComponent(close))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamapetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamapetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamapetugasActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        String i=txtpetugas.getText();
        String n=txtnamapetugas.getText();
        String a=txtalamat.getText();
        String e=txtemail.getText();
        String t=txttelepon.getText();
        String p=txtpassword.getText();
        String h=txthakakses.getText();
        if ((i.isEmpty()) | (n.isEmpty()) | (a.isEmpty()) | (e.isEmpty()) | (t.isEmpty()) | (p.isEmpty()) | (h.isEmpty())){            
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                "silahkan dilengkapi");
            txtnamapetugas.requestFocus();

        }else {
            try {
                String SQL = "delete from tblpetugas where "
                + "idpetugas = '"+txtpetugas.getText()+"'";
                conn.query(SQL);
                tampil();
                JOptionPane.showMessageDialog(null,
                    "data dihapus");
                BersihData();
                SetEditOff();
                add.setEnabled(true);
            } catch (Exception ex){
                System.err.println(ex);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        SetEditOff();
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

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
       BersihData();
        txtpetugas.requestFocus();
        save.setEnabled(true);
        SetEditOn();
    }//GEN-LAST:event_addActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
       String i=txtpetugas.getText();
        String n=txtnamapetugas.getText();
        String a=txtalamat.getText();
        String e=txtemail.getText();
        String t=txttelepon.getText();
        String p=txtpassword.getText();
        String h=txthakakses.getText();
        if ((i.isEmpty()) | (n.isEmpty()) | (a.isEmpty()) | (e.isEmpty()) | (t.isEmpty()) | (p.isEmpty()) | (h.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, "+
                "silahkan dilengkapi");
            txtpetugas.requestFocus();

        }else{
            try{
                String SQL = "insert into tblpetugas values ("
                + "'"+txtpetugas.getText()+"',"
                + "'"+txtnamapetugas.getText()+"',"
                + "'"+txtalamat.getText()+"',"
                + "'"+txtemail.getText()+"',"
                + "'"+txttelepon.getText()+"',"
                + "'"+txtpassword.getText()+"',"
                + "'"+txthakakses.getText()+"'"
                + ")";
                conn.query(SQL);
                tampil();
                JOptionPane.showMessageDialog(null, txtpetugas.getText()+
                    "Berhasil Disimpan");
                BersihData();
                SetEditOff();
                add.setEnabled(true);
            } catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }                                       

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        String i=txtpetugas.getText();
        String n=txtnamapetugas.getText();
        String a=txtalamat.getText();
        String e=txtemail.getText();
        String t=txttelepon.getText();
        String p=txtpassword.getText();
        String h=txthakakses.getText();
        if ((i.isEmpty()) | (n.isEmpty()) | (a.isEmpty()) | (e.isEmpty()) | (t.isEmpty()) | (p.isEmpty()) | (h.isEmpty())){            
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                "silahkan dilengkapi");
            txtpetugas.requestFocus();
        }else{
            try{
                String SQL = "update tblpetugas set "
                + " namapetugas ='"+txtnamapetugas.getText()+"',"
                + " alamat ='"+txtalamat.getText()+"',"
                + " email ='"+txtemail.getText()+"',"
                + " telepon ='"+txttelepon.getText()+"',"
                + " password ='"+txtpassword.getText()+"',"
                + " hakakses ='"+txthakakses.getText()+"' where"
                + " idpetugas ='"+txtpetugas.getText()+"'";

                conn.query(SQL);
                tampil();
                JOptionPane.showMessageDialog(null, txthakakses.getText()+
                    "Berhasil Diubah");
                BersihData();
                SetEditOff();
                add.setEnabled(true);
            } catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
         String i=txtpetugas.getText();
        String n=txtnamapetugas.getText();
        String a=txtalamat.getText();
        String e=txtemail.getText();
        String t=txttelepon.getText();
        String p=txtpassword.getText();
        String h=txthakakses.getText();
        if ((i.isEmpty()) | (n.isEmpty()) | (a.isEmpty()) | (e.isEmpty()) | (t.isEmpty()) | (p.isEmpty()) | (h.isEmpty())){            
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                "silahkan dilengkapi");
            txtpetugas.requestFocus();
        }else{
            try{
                String SQL = "update tblpetugas set "
                + " namapetugas ='"+txtnamapetugas.getText()+"',"
                + " alamat ='"+txtalamat.getText()+"',"
                + " email ='"+txtemail.getText()+"',"
                + " telepon ='"+txttelepon.getText()+"',"
                + " password ='"+txtpassword.getText()+"',"
                + " hakakses ='"+txthakakses.getText()+"' where"
                + " idpetugas ='"+txtpetugas.getText()+"'";

                conn.query(SQL);
                tampil();
                JOptionPane.showMessageDialog(null, txthakakses.getText()+
                    "Berhasil Diubah");
                BersihData();
                SetEditOff();
                add.setEnabled(true);
            } catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         new HalamanUtama().show();
        this.dispose();             
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPetugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton close;
    private javax.swing.JButton delete;
    private javax.swing.JTable formpetugas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthakakses;
    private javax.swing.JTextField txtnamapetugas;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtpetugas;
    private javax.swing.JTextField txttelepon;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
