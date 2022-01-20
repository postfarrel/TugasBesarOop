/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author adi
 */

public class DataDistributor {
    private String iddistributor, namadistributor, alamat, email, telepon, kotaasal ;
    
    public DataDistributor(){
    }
    public String getIdDistributor(){
        return iddistributor;
    }
    public void setIdDistributor(String iddistributor){
        this.iddistributor = iddistributor;
    }
    public String getNamaDistributor(){
        return namadistributor;        
    }
    public void setNamaDistributor(String namadistributor){
        this.namadistributor = namadistributor;
    }    
    public String getAlamat(){
        return alamat;        
    }
    public void setAlamat (String alamat){
        this.alamat = alamat;
    }
    public String getKotaAsal(){
        return kotaasal;        
    }
    public void setKotaAsal(String kotaasal){
        this.kotaasal = kotaasal;
    }   
    public String getTelepon(){
        return telepon;        
    }
    public void setTelepon(String telepon){
        this.telepon = telepon;
    }   
    public String getEmail(){
        return email;        
    }
    public void setEmail(String email){
        this.email = email;
    }   
}