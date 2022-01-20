/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Bean.DataBarangMasuk;
import koneksi.koneksi;
import Tabel.*;
import java.util.Date;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author adi
 */
public class formDataBrgMasuk extends javax.swing.JFrame {
private Object tabel;

private TabelDataBarangMasuk ModelDataBarangMasuk;

private koneksi conn;

    public formDataBrgMasuk() {
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
       ModelDataBarangMasuk = new TabelDataBarangMasuk();
       tabel_data_barang_masuk.setModel(ModelDataBarangMasuk);
        conn = new koneksi();
        tampildetail();
        SetEditOff();
        //nonotaotomatis();
        TanggalOtomatis();
        TampilComboBarang();
        TampilComboPetugas();
        TampilComboDistributor();
        
    }
    
    
    public void TampilComboBarang(){
       try {
           koneksi konek = new koneksi();
           String SQL = "SELECT * FROM tbldata_brg";
           ResultSet res = konek.getData(SQL);
           while(res.next()){
               KodeBarang.addItem(res.getString("kodebarang"));
             }
          } catch (SQLException ex) {
       }
    }
    
    public void TampilComboPetugas(){
       try {
           koneksi konek = new koneksi();
           String SQL = "SELECT * FROM tblpetugas";
           ResultSet res = konek.getData(SQL);
           while(res.next()){
               IdPetugas.addItem(res.getString("idpetugas"));
             }
          } catch (SQLException ex) {
       }
    }
    
    public void TampilComboDistributor(){
       try {
           koneksi konek = new koneksi();
           String SQL = "SELECT * FROM tbldistributor";
           ResultSet res = konek.getData(SQL);
           while(res.next()){
               IdDistributor.addItem(res.getString("iddistributor"));
             }
          } catch (SQLException ex) {
       }
    }
    
private void tampildetail(){
        try{
            int baris = tabel_data_barang_masuk.getRowCount();
            for (int i =0; i < baris; i++){
                ModelDataBarangMasuk.delete(0,baris);
            }
            String sql = "SELECT tbldata_brg.kodebarang,tbldata_brg.nama_brg,"
                          + "tbldata_brg.Harga_net,tbldata_brg.Stock,tbldetailbrgmasuk.jumlah,"
                          + "tbldetailbrgmasuk.subtotal,tbldetailbrgmasuk.nonota "
                          + " FROM tbldata_brg,tbldetailbrgmasuk "
                          + "WHERE tbldata_brg.kodebarang=tbldetailbrgmasuk.kodebarang "
                          + " AND tbldetailbrgmasuk.nonota='" + NoNota.getText() + "'";
            ResultSet rs = conn.getData(sql);
            while (rs.next()) {
                DataBarangMasuk nama_brg = new DataBarangMasuk();
                nama_brg.setKodeBrg (rs.getString(1));
                nama_brg.setNamaBrg (rs.getString(2));
                nama_brg.setHargaNet (rs.getString(3));
                nama_brg.setStock (rs.getString(4));
                nama_brg.setJumlah (rs.getString(5));
                nama_brg.setSubTotal (rs.getString(6));
                ModelDataBarangMasuk.add(nama_brg);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }

private void tampil(){
        try{
            int baris = tabel_data_barang_masuk.getRowCount();
            for (int i =0; i < baris; i++){
                ModelDataBarangMasuk.delete(0,baris);
            }
            String sql = "SELECT tblbrgmasuk.nonota,tblbrgmasuk.tglmasuk,"
                          + "tblbrgmasuk.iddistributor,tblbrgmasuk.idpetugas,"
                          + "tblbrgmasuk.total FROM tblbrgmasuk, tbldistributor, "
                          + "tblpetugas WHERE tblpetugas.idpetugas=tblbrgmasuk.idpetugas "
                          + "And tbldistributor.iddistributor=tblbrgmasuk.iddistributor "
                          + "AND tblbrgmasuk.nonota='" + NoNota.getText() + "'";
            ResultSet rs = conn.getData(sql);
            while (rs.next()) {
                IdDistributor.setSelectedItem(rs.getString(3));
                IdPetugas.setSelectedItem(rs.getString(4));
                total.setText(rs.getString(5));
                tampildetail(); 
            }
           SetEditOn();
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }


    
    public void SetEditOff() {
        NoNota.setEnabled(true);
        Cari.setEnabled(true);
        IdPetugas.setEnabled(false);
        IdDistributor.setEnabled(false);
        TglBrgMasuk.setEnabled(false);
        NamaPetugas.setEnabled(false);
        NamaDistributor.setEnabled(false);
        AddNew.setEnabled(true);
        Save.setEnabled(false);
        Close.setEnabled(true);
        total.setEnabled(false);
        KodeBarang.setEnabled(false);
        NamaBarang.setEnabled(false);
        HargaNet.setEnabled(false);
        Stock.setEnabled(false);
        SubTotal.setEnabled(false);
        total.setEnabled(false);
        Jumlah.setEnabled(false);
        btnhitung.setEnabled(false);
        btnAddItem.setEnabled(false);
        total.setText("0");
}
    
    public void SetEditOn() {
        NoNota.setEnabled(true);
        KodeBarang.setEnabled(true);
        IdDistributor.setEnabled(true);
        IdPetugas.setEnabled(true);
        Jumlah.setEnabled(true);
        btnhitung.setEnabled(true);
        Save.setEnabled(true);
        btnAddItem.setEnabled(true);
        AddNew.setEnabled(false);
    }
    public void BersihDetail() {
        KodeBarang.setSelectedIndex(0);
        NamaBarang.setText("");
        Stock.setText("");
        HargaNet.setText("");
        Jumlah.setText("");
        SubTotal.setText("");
        
}
    
    public void BersihData() {
        KodeBarang.setSelectedIndex(0);
        NamaBarang.setText("");
        Stock.setText("");
        HargaNet.setText("");
        IdDistributor.setSelectedIndex(0);
        NamaDistributor.setText("");
        IdPetugas.setSelectedIndex(0);
        NamaPetugas.setText("");
        Jumlah.setText("");
        SubTotal.setText("");
        total.setText("0");
        
        
}
    
    public void TanggalOtomatis() {
        Date tanggal = new Date();
        TglBrgMasuk.setText("" + (String.format("%1$td-%1$tb-%1$tY", tanggal)));
}
    
   /* public void nonotaotomatis(){
           try{
               String sql = "select max(right(nonota,3)) as nota from tblbrgmasuk";
               ResultSet rs = conn.getData(sql);
               while(rs.next()){
                   if(rs.first()==false){
                       NoNota.setText("N001");
                   }else {
                       rs.last();
                       int autonota = rs.getInt(1)+1;
                       String nomor = String.valueOf(autonota);
                       int nolong = nomor.length();
                       for(int a=0; a<3-nolong;a++){
                            nomor = "0"+nomor;
                   }
                       NoNota.setText("N"+nomor);
                        }
                    }
                   }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                           }
           }
   */
           
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AditamaPutra = new javax.swing.JLabel();
        ADITAMAPUTRA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NoNota = new javax.swing.JTextField();
        Cari = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        IdPetugas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        IdDistributor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TglBrgMasuk = new javax.swing.JTextField();
        NamaPetugas = new javax.swing.JTextField();
        NamaDistributor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        KodeBarang = new javax.swing.JComboBox<>();
        NamaBarang = new javax.swing.JTextField();
        HargaNet = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Stock = new javax.swing.JTextField();
        Jumlah = new javax.swing.JTextField();
        btnhitung = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        SubTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data_barang_masuk = new javax.swing.JTable();
        AddNew = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        AditamaPutra.setText(".");
        AditamaPutra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AditamaPutraMouseClicked(evt);
            }
        });

        ADITAMAPUTRA.setText(".");
        ADITAMAPUTRA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADITAMAPUTRAMouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Halaman Data Barang Masuk");

        jLabel2.setText("No. Nota");

        NoNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoNotaActionPerformed(evt);
            }
        });

        Cari.setText("Ok");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        jLabel3.setText("Id Petugas");

        IdPetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        IdPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdPetugasActionPerformed(evt);
            }
        });

        jLabel4.setText("Id Distributor");

        IdDistributor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        IdDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdDistributorActionPerformed(evt);
            }
        });

        jLabel5.setText("Tanggal Barang Masuk");

        jLabel6.setText("Nama Petugas");

        jLabel7.setText("Nama Distributor");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Kode Barang");

        jLabel10.setText("Nama Barang");

        jLabel11.setText("Harga Net");

        KodeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        KodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeBarangActionPerformed(evt);
            }
        });

        jLabel12.setText("Stock");

        jLabel13.setText("Jumlah");

        jLabel14.setText(" Sub Total Rp.");

        btnhitung.setText("Hitung");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });

        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NamaBarang)
                            .addComponent(KodeBarang, 0, 140, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddItem)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(43, 43, 43)
                                        .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 27, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Jumlah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnhitung))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(HargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(KodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnhitung)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(HargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Data Barang Masuk");

        tabel_data_barang_masuk.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_data_barang_masuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_data_barang_masukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_data_barang_masuk);

        AddNew.setText("Add New");
        AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewActionPerformed(evt);
            }
        });

        Save.setText("Save Transaction");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        jLabel15.setText("Total Rp.");

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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cari))
                            .addComponent(IdDistributor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IdPetugas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NamaPetugas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NamaDistributor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(TglBrgMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(AddNew)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Close)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cari)
                            .addComponent(jLabel5)
                            .addComponent(TglBrgMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(IdPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(NamaPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(IdDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(NamaDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddNew)
                            .addComponent(Save)
                            .addComponent(Close)
                            .addComponent(jLabel15)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137)
                .addComponent(jButton1)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NoNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoNotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoNotaActionPerformed

    private void IdPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdPetugasActionPerformed
        // TODO add your handling code here:
    try {
          koneksi konek = new koneksi();
          String SQL = "SELECT * FROM tblpetugas where idpetugas='"+
          IdPetugas.getSelectedItem().toString()+"'";
        
        ResultSet rs = konek.getData(SQL);
        while (rs.next()) {
        NamaPetugas.setText(rs.getString("namapetugas"));
        }
        } catch (SQLException ex){
        }
    }//GEN-LAST:event_IdPetugasActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:
        String NN=NoNota.getText();
        String KB=KodeBarang.getSelectedItem().toString();
        String JM=Jumlah.getText();
        if ((NN.isEmpty()) | (KB.isEmpty())  | (JM.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                    "silahkan dilengkapi");
        KodeBarang.requestFocus();
        }else{
         try{
        String SQL = "insert into tbldetailbrgmasuk values (" +
                      "'"+NoNota.getText()+"'," +
                      "'"+KodeBarang.getSelectedItem()+"'," +
                      "'"+Jumlah.getText()+"'," +
                      "'"+SubTotal.getText()+"')";
                     conn.query(SQL);
                     String SQL1 = "update tbldata_brg Set stock=stock + " +
                     "'"+Jumlah.getText()+"'" +
                     "Where kodebarang='"+KodeBarang.getSelectedItem().toString()+"'";
                     conn.query(SQL1);
                     KodeBarang.requestFocus();
                     btnAddItem.setEnabled(true);
                     
                     tampildetail();
                     BersihDetail();
      } catch (Exception ex){
    System.err.println(ex.getMessage());
    }                              
        }                              
         
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        int jml = Integer.parseInt(Jumlah.getText());
        int hNet = Integer.parseInt(HargaNet.getText());
        int Sub,tot;
        Sub=jml*hNet;
        tot= Integer.parseInt(total.getText());
        tot=tot+Sub;
        SubTotal.setText(String.valueOf(Sub));
        total.setText(String.valueOf(tot));
    }//GEN-LAST:event_btnhitungActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        String NN=NoNota.getText();
        String ID=IdDistributor.getSelectedItem().toString();
        String IP=IdPetugas.getSelectedItem().toString();
        if ((NN.isEmpty()) | (ID.isEmpty())  | (IP.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong,"+
                    "silahkan dilengkapi");
        KodeBarang.requestFocus();
        }else{
         try{
        String SQL = "insert into tblbrgmasuk values (" +
                      "'"+NoNota.getText()+"'," +
                      "'"+TglBrgMasuk.getText()+"'," +
                      "'"+IdPetugas.getSelectedItem().toString()+"'," +
                      "'"+IdPetugas.getSelectedItem().toString()+"'," +
                      "'"+total.getText()+"')";
                     conn.query(SQL);
                     KodeBarang.requestFocus();
                     BersihDetail();
                     BersihData();
                     SetEditOff();
                     tampildetail();
                     AddNew.setEnabled(true);
                     } catch (Exception ex){
    System.err.println(ex.getMessage());
    }                              
        }                              
                 
        

                     
    }//GEN-LAST:event_SaveActionPerformed

    private void AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewActionPerformed
        // TODO add your handling code here:
        BersihData();
        KodeBarang.requestFocus();
        Save.setEnabled(true);
        NoNota.setEditable(true);
        SetEditOn();    
    }//GEN-LAST:event_AddNewActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
        tampil();
        SetEditOn();
        Save.setEnabled(false);
        AddNew.setEnabled(true);
    }//GEN-LAST:event_CariActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"This application will be close"+
                "\n if you pass button OK","information",
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)
                ==JOptionPane.OK_OPTION){
            this.dispose();            
        }
    }//GEN-LAST:event_CloseActionPerformed

    private void KodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeBarangActionPerformed
        // TODO add your handling code here:
        try {
          koneksi konek = new koneksi();
          String SQL = "SELECT * FROM tbldata_brg where kodebarang='"+
          KodeBarang.getSelectedItem().toString()+"'";
        
        ResultSet rs = konek.getData(SQL);
        while (rs.next()) {
        NamaBarang.setText(rs.getString("nama_brg"));
        HargaNet.setText(rs.getString("Harga_net"));
        Stock.setText(rs.getString("Stock"));
        }
        } catch (SQLException ex){
        }
    }//GEN-LAST:event_KodeBarangActionPerformed
//aditama Putra
    private void IdDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdDistributorActionPerformed
        // TODO add your handling code here:
        try {
          koneksi konek = new koneksi();
          String SQL = "SELECT * FROM tbldistributor where iddistributor='"+
          IdDistributor.getSelectedItem().toString()+"'";
        
        ResultSet rs = konek.getData(SQL);
        while (rs.next()) {
        NamaDistributor.setText(rs.getString("namadistributor"));
        }
        } catch (SQLException ex){
        }
    }//GEN-LAST:event_IdDistributorActionPerformed

    private void tabel_data_barang_masukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_data_barang_masukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_data_barang_masukMouseClicked

    private void AditamaPutraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AditamaPutraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AditamaPutraMouseClicked

    private void ADITAMAPUTRAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADITAMAPUTRAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ADITAMAPUTRAMouseClicked

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
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formDataBrgMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADITAMAPUTRA;
    private javax.swing.JButton AddNew;
    private javax.swing.JLabel AditamaPutra;
    private javax.swing.JButton Cari;
    private javax.swing.JButton Close;
    private javax.swing.JTextField HargaNet;
    private javax.swing.JComboBox<String> IdDistributor;
    private javax.swing.JComboBox<String> IdPetugas;
    private javax.swing.JTextField Jumlah;
    private javax.swing.JComboBox<String> KodeBarang;
    private javax.swing.JTextField NamaBarang;
    private javax.swing.JTextField NamaDistributor;
    private javax.swing.JTextField NamaPetugas;
    private javax.swing.JTextField NoNota;
    private javax.swing.JButton Save;
    private javax.swing.JTextField Stock;
    private javax.swing.JTextField SubTotal;
    private javax.swing.JTextField TglBrgMasuk;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabel_data_barang_masuk;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
