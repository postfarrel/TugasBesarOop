/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


public class DataBarangMasuk {
    private String KodeBarang,NamaBarang, HargaNet, Stock, Jumlah, SubTotal;
   
    public DataBarangMasuk() { 
    }
    public String getKodeBrg(){
        return KodeBarang ;
    }
    public void setKodeBrg(String KodeBarang){
        this.KodeBarang = KodeBarang;
    }
    public String getNamaBrg(){
        return NamaBarang;
    }
    public void setNamaBrg(String NamaBarang){
        this.NamaBarang = NamaBarang;
    }
    public String getHargaNet(){
        return HargaNet;
    }
    public void setHargaNet(String HargaNet){
        this.HargaNet = HargaNet;
    }
    public String getStock(){
        return Stock;
    }
    public void setStock(String Stock){
        this.Stock = Stock;
    }
    public String getJumlah(){
        return Jumlah;
    }
    public void setJumlah(String Jumlah){
        this.Jumlah = Jumlah;
    }
    public String getSubTotal(){
        return SubTotal;
    }
    public void setSubTotal(String SubTotal){
        this.SubTotal = SubTotal;
    }
}
