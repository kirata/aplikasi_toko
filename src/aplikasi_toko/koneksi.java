/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_toko;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author cosnors
 */
public class koneksi {
    Connection conn;
    Statement st;
    ResultSet rs;
    
    public Connection setKoneksi()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:33062/toko_db","root","root");
            st=conn.createStatement();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal Bro : " +e);
    }
        return conn;
    }
}    
    
    