/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import databases.koneksi;
import enkapsulasi.enkapsulasiPesan;
import implement.implementPesan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class pesanDAO extends Parent implements implementPesan {
    
    private List<enkapsulasiPesan> List;

    

    @Override
    public boolean save(String nik, String nama, String alamat, String gender, String telepon) {
    try {
            String sql = "insert into penumpang "
                    + " values ("
                    + "'" + nik + "', "
                    + "'" + nama + "',"
                    + "'" + alamat + "',"
                    + "'" + gender + "',"
                    + "'" + telepon + "'"
                    + ")";

            Connection conn = (Connection) koneksi.koneksiDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return false;
        }
    
    
    }

    @Override
    public boolean delete(String nik) {
     try {
            String sql = "delete from penumpang where nik='" + nik + "'";

            Connection conn = (Connection) koneksi.koneksiDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return false;
        }
      
    }

    @Override
    public List<enkapsulasiPesan> search(String nik, String nama, String alamat, String gender, String telepon) {
     List = new ArrayList<enkapsulasiPesan>();
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select* from penumpang where nik like '%" + nik + "%' or nama like '%" + nama + "%' or alamat like '%" + alamat + "%' or gender like '%" + gender + "%'");

            while (result.next()) {
                enkapsulasiPesan user = new enkapsulasiPesan();
                user.setNik(result.getString("nik"));
                user.setNama(result.getString("nama"));
                user.setAlamat(result.getString("alamat"));
                user.setGender(result.getString("gender"));
                user.setTelepon(result.getString("telepon"));
                List.add(user);

            }
            return List;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return null;    
    }
}
    
    
    @Override
    public boolean update(String nik, String nama, String alamat, String gender, String telepon) {
    try {
            String sql = "update penumpang set "
                    +"nama ='"+nama
                    +"',alamat ='"+alamat
                    +"',gender ='"+gender
                    +"',telepon ='"+telepon
                    +"'where nik = '"+nik+"'";

            Connection conn = (Connection) koneksi.koneksiDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return false;
        }    
    }
    
   
    public List<enkapsulasiPesan> getAllPesan(){
        List = new ArrayList<enkapsulasiPesan>();
        try {

            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select nik, nama ,alamat ,gender ,telepon  from penumpang ORDER BY nik");

            while (result.next()) {
                enkapsulasiPesan user = new enkapsulasiPesan();
                user.setNik(result.getString("nik"));
                user.setNama(result.getString("nama"));
                user.setAlamat(result.getString("alamat"));
                user.setGender(result.getString("gender"));
                user.setTelepon(result.getString("telepon"));
                List.add(user);
            }

            return List;

        } catch (SQLException e) {
            messageFailed(e.getMessage());
            return null;
        }

    }

    
    
    }
    
    

