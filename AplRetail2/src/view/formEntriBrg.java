package view;

import Bean.DataBarang;
import Tabel.*;
import java.awt.*;
import koneksi.*;
import javax.swing.*;
import java.sql.*;


public class formEntriBrg extends javax.swing.JFrame {
private Object tabel;

private TabelDataBarang ModelDataBarang;

private koneksi conn;

    public formEntriBrg() {
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
       ModelDataBarang = new TabelDataBarang();
       tbl_jenis_barang.setModel(ModelDataBarang);
        conn = new koneksi();
        tampil();
        SetEditOff();
        //kdauto();
        TampilComboJenis();
    }

   public void TampilComboJenis(){
       try {
           koneksi konek = new koneksi();
           String SQL = "SELECT * FROM tbljenis";
           ResultSet res = konek.getData(SQL);
           while(res.next()){
               Kode_jenis.addItem(res.getString("Kode_Jenis"));
             }
          } catch (SQLException ex) {
       }
    }
   
   private void tampil(){
        try{
            int baris = tbl_jenis_barang.getRowCount();
            for (int i =0; i < baris; i++){
                ModelDataBarang.delete(0,baris);
            }
            String sql = "select * from tbldata_brg";
            ResultSet rs = conn.getData(sql);
            while (rs.next()) {
                DataBarang nama_brg = new DataBarang();
                nama_brg.setKodeBrg (rs.getString(1));
                nama_brg.setNamaBrg (rs.getString(2));
                nama_brg.setKode_jenis (rs.getString(3));
                nama_brg.setJenisBrg (rs.getString(4));
                nama_brg.setHargaNet (rs.getString(5));
                nama_brg.setHargaJual (rs.getString(6));
                nama_brg.setStock (rs.getString(7));
                ModelDataBarang.add(nama_brg);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    int row = 0;
    
    public void TampilText(){
            row = tbl_jenis_barang.getSelectedRow();
            DataBarang dData = ModelDataBarang.get(row);
            KodeBrg.setText(dData.getKodeBrg());
            NamaBrg.setText(dData.getNamaBrg());
            Kode_jenis.setSelectedItem(dData.getKode_jenis());
            JenisBrg.setText(dData.getJenisBrg());
            HargaNet.setText(dData.getHargaNet());
            HargaJual.setText(dData.getHargaJual());
            Stock.setText(dData.getStock());
            Save.setEnabled(false);
            SetEditOn();
    }
    
    public void BersihData(){
        //kdauto();
        NamaBrg.setText("");
        Kode_jenis.setSelectedItem("");
        JenisBrg.setText("");
        HargaNet.setText("");
        HargaJual.setText("");
        Stock.setText("");
    }
    
    public void SetEditOff(){
        KodeBrg.setEnabled(false);
        NamaBrg.setEnabled(false);
        Kode_jenis.setEnabled(false);
        JenisBrg.setEnabled(false);
        HargaNet.setEnabled(false);
        HargaJual.setEnabled(false);
        Stock.setEnabled(false);
        Save.setEnabled(false);
        Delete.setEnabled(false);
        Update.setEnabled(false);           
        Addnew.setEnabled(true);
    }

    public void SetEditOn(){
        KodeBrg.setEnabled(true);
        NamaBrg.setEnabled(true);
        Kode_jenis.setEnabled(true);
        JenisBrg.setEnabled(true);
        HargaNet.setEnabled(true);
        HargaJual.setEnabled(true);
        Stock.setEnabled(true);
        Save.setEnabled(true);
        Delete.setEnabled(true);
        Update.setEnabled(true);           
        Addnew.setEnabled(false);
    }
    /*
    public void kdauto(){
           try{
               String sql = "select max(right(kd_brg,2)) from tbldata_brg";
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
                       KodeBrg.setText("B"+itung);
                   }else{
                       NamaBrg.setText("B001");
                   }
               }
           
                   }catch(SQLException e){
                    System.out.println(e.getMessage());
               }
    }
    */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        KodeBrg = new javax.swing.JTextField();
        NamaBrg = new javax.swing.JTextField();
        JenisBrg = new javax.swing.JTextField();
        HargaNet = new javax.swing.JTextField();
        HargaJual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_jenis_barang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        Kode_jenis = new javax.swing.JComboBox<>();
        Stock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Addnew = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Entri Data Barang");

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Nama barang");

        jLabel4.setText("Kode Jenis Barang");

        jLabel5.setText("Jenis Barang");

        jLabel6.setText("Harga Net");

        jLabel7.setText("Harga Jual");

        tbl_jenis_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_jenis_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jenis_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_jenis_barang);

        jLabel8.setText("Stok");

        Kode_jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Barang" }));
        Kode_jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kode_jenisActionPerformed(evt);
            }
        });

        jLabel9.setText("Rp");

        jLabel10.setText("Rp");

        Addnew.setText("Add New");
        Addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddnewActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
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
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(HargaJual, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addComponent(HargaNet)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                            .addComponent(JenisBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(NamaBrg, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KodeBrg, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Kode_jenis, 0, 122, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cancel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Addnew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Save)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(364, 364, 364))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KodeBrg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NamaBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Kode_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JenisBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(HargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(HargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Addnew)
                            .addComponent(Save)
                            .addComponent(Update))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Delete)
                            .addComponent(Close)
                            .addComponent(Cancel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jButton1))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Kode_jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kode_jenisActionPerformed
        // TODO add your handling code here:
        try {
          koneksi konek = new koneksi();
          String SQL = "SELECT * FROM tbljenis where Kode_Jenis='"+
        Kode_jenis.getSelectedItem().toString()+"'";
        
        ResultSet rs = konek.getData(SQL);
        while (rs.next()) {
        JenisBrg.setText(rs.getString("Jenis"));
        }
        } catch (SQLException ex){
        }
       
    }//GEN-LAST:event_Kode_jenisActionPerformed

    private void AddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddnewActionPerformed
        // TODO add your handling code here:
        BersihData();
        KodeBrg.requestFocus();
        Save.setEnabled(true);
        SetEditOn();
    }//GEN-LAST:event_AddnewActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        String KB=KodeBrg.getText();
        String NB=NamaBrg.getText();
        String KJ=(String) Kode_jenis.getSelectedItem();
        String JB=JenisBrg.getText();
        String HN=HargaNet.getText();
        String HJ=HargaJual.getText();
        String S=Stock.getText();
        if ((KB.isEmpty()) | (NB.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                    "silahkan dilengkapi");
        KodeBrg.requestFocus();
        }else{
         try{
        String SQL = "insert into tbldata_brg values ("
                     + "'" + KodeBrg.getText()+ "',"
                     + "'" + NamaBrg.getText()+ "',"
                     + "'" + Kode_jenis.getSelectedItem()+ "',"
                     + "'" + JenisBrg.getText()+ "',"
                     + "'" + HargaNet.getText()+ "',"
                     + "'" + HargaJual.getText()+ "',"
                     + "'" + Stock.getText()+ "'"
                     + ")";
          
        conn.query(SQL);
        tampil();
        JOptionPane.showMessageDialog(null, NamaBrg.getText()+
                "Data Berhasil Disimpan");
        BersihData();
        SetEditOff();
        Addnew.setEnabled(true);
    } catch (Exception ex){
    System.err.println(ex.getMessage());
    }
                                                 
      
                                       
        }                              
    }//GEN-LAST:event_SaveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        String KB=KodeBrg.getText();
        String NB=NamaBrg.getText();
        String KJ=(String) Kode_jenis.getSelectedItem();
        String JB=JenisBrg.getText();
        String HN=HargaNet.getText();
        String HJ=HargaJual.getText();
        String S=Stock.getText();
        if ((KB.isEmpty()) | (NB.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                    "slahkan dilengkapi");
        KodeBrg.requestFocus();
    
    }else {
    try {
        String SQL = "delete from tbldata_brg where "
                + "nama_brg = '"+NamaBrg.getText()+"'";
        conn.query(SQL);
        tampil();
        JOptionPane.showMessageDialog(null,
                "data dihapus");
    BersihData();
    SetEditOff();
    Addnew.setEnabled(true);
    } catch (Exception ex){
    System.err.println(ex);
    }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        String KB=KodeBrg.getText();
        String NB=NamaBrg.getText();
        String KJ=(String) Kode_jenis.getSelectedItem();
        String JB=JenisBrg.getText();
        String HN=HargaNet.getText();
        String HJ=HargaJual.getText();
        String S=Stock.getText();
        if ((KB.isEmpty()) | (NB.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                    "slahkan dilengkapi");
        KodeBrg.requestFocus();
        }else{
         try{
                  String SQL = "update tbldata_brg set "
                     + " kodebarang = '" + KodeBrg.getText() + "',"
                     + " nama_brg = '" + NamaBrg.getText() + "',"
                     + " kode_jenis = '" + Kode_jenis.getSelectedItem() + "',"
                     + " jenis_brg = '" + JenisBrg.getText() + "',"
                     + " Harga_net = '" + HargaNet.getText() + "',"
                     + " Harga_jual = '" + HargaJual.getText() + "' where"
                     + " Stock = '" + Stock.getText() + "'";
        conn.query(SQL);
        tampil();
        JOptionPane.showMessageDialog(null, NamaBrg.getText()+"Berhasil Diubah");
        BersihData();
        SetEditOff();
        Addnew.setEnabled(true);
    } catch (Exception ex){
    System.err.println(ex.getMessage());
    
                                                 
        }
         }                  
    }//GEN-LAST:event_UpdateActionPerformed

    private void tbl_jenis_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jenis_barangMouseClicked
        // TODO add your handling code here:
         if (evt.getClickCount()==1){
            TampilText();
         }
    }//GEN-LAST:event_tbl_jenis_barangMouseClicked

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        SetEditOff();
    }//GEN-LAST:event_CancelActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"This application will be close"+
                "\n if you pass button OK","information",
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)
                ==JOptionPane.OK_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_CloseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new HalamanUtama().show();
        this.dispose();               
    }//GEN-LAST:event_jButton1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addnew;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Close;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField HargaJual;
    private javax.swing.JTextField HargaNet;
    private javax.swing.JTextField JenisBrg;
    private javax.swing.JTextField KodeBrg;
    private javax.swing.JComboBox<String> Kode_jenis;
    private javax.swing.JTextField NamaBrg;
    private javax.swing.JButton Save;
    private javax.swing.JTextField Stock;
    private javax.swing.JButton Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_jenis_barang;
    // End of variables declaration//GEN-END:variables
}