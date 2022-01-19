/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;
import javax.swing.JOptionPane;

    public class koneksi {
    private Connection conn;
    private Statement stm , stml;
    ResultSet rs;
    String url = "jdbc:mysql://localhost/dbretail";
    String user = "root";
    String pass = "";
 
public koneksi(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection
                (url,user,pass);
            stm=conn.createStatement();
            stml=conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        }catch(SQLException ex){
         System.err.print(ex);
        }catch(ClassNotFoundException ex){
         System.err.print(ex);
        }
    }
public ResultSet getData(String SQLString)
    {
        try
        {
            rs=stm.executeQuery(SQLString);
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"error :"
                +e.getMessage(),"Comunication Error",
        JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
 public void query(String SQLString)
        {
            try{
                stm.execute(SQLString);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog
                        (null,"error"+e.getMessage(),
                                "Communication Error",
                                JOptionPane.WARNING_MESSAGE);
             }
            }
    }