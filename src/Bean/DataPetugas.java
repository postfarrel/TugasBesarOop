/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


public class DataPetugas {
        private String idpetugas, namapetugas, alamat, email, telepon, password, hakakses;
    
    public DataPetugas(){
    }
    public String getIdPetugas(){
        return idpetugas;
    }
    public void setIdPetugas(String idpetugas){
        this.idpetugas = idpetugas;
    }
    public String getNamaPetugas(){
        return namapetugas;        
    }
    public void setNamaPetugas(String namapetugas){
        this.namapetugas = namapetugas;
    }    
    public String getAlamat(){
        return alamat;        
    }
    public void setAlamat (String alamat){
        this.alamat = alamat;
    }   
    public String getEmail(){
        return email;        
    }
    public void setEmail(String email){
        this.email = email;
    }   
    public String getTelepon(){
        return telepon;        
    }
    public void setTelepon(String telepon){
        this.telepon = telepon;
    }   
    public String getPassword(){
        return password;        
    }
    public void setPassword(String password){
        this. password = password;
    }
    public String getHakAkses(){
        return hakakses;        
    }
    public void setHakAkses(String hakakses){
        this.hakakses = hakakses;
    }   
}
