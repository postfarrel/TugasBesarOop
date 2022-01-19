package Bean;

public class DataBarang {
    private String kd_brg,nama_brg, kode_jenis, jenis_brg, Harga_net, Harga_jual, Stock;
   
    public DataBarang() { 
    }
    public String getKodeBrg(){
        return kd_brg ;
    }
    public void setKodeBrg(String kd_brg){
        this.kd_brg = kd_brg;
    }
    public String getNamaBrg(){
        return nama_brg;
    }
    public void setNamaBrg(String nama_brg){
        this.nama_brg = nama_brg;
    }
    public String getKode_jenis(){
        return kode_jenis;
    }
    public void setKode_jenis(String kode_jenis){
        this.kode_jenis = kode_jenis;
    }
    public String getJenisBrg(){
        return jenis_brg;
    }
    public void setJenisBrg(String jenis_brg){
        this.jenis_brg = jenis_brg;
    }
    public String getHargaNet(){
        return Harga_net;
    }
    public void setHargaNet(String Harga_net){
        this.Harga_net = Harga_net;
    }
    public String getHargaJual(){
        return Harga_jual;
    }
    public void setHargaJual(String Harga_jual){
        this.Harga_jual = Harga_jual;
    }
    public String getStock(){
        return Stock;
    }
    public void setStock(String Stock){
        this.Stock = Stock;
    }
}