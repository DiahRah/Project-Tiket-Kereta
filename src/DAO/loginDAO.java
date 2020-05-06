/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import databases.koneksi;
import implement.implementLogin;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class loginDAO extends Parent implements implementLogin{

    @Override
    public boolean login(String userid, String password) {
    
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select userid, password from admin where userid='" + userid + "' and password='" + password + "'");
            
            if (result.next()) {
                return true;
                    
                }
            
        } catch (Exception e) {
         messageFailed(e.getMessage());
        }
        
        return false;
        
    }
    
}
