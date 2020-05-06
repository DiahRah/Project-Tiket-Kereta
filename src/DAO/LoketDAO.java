/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import databases.koneksi;
import enkapsulasi.enkapsulasiLoket;
import implement.implementLoket;
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
public class LoketDAO extends Parent implements implementLoket{
    
    private List<enkapsulasiLoket> List;

    

    @Override
    public boolean save(String idtiket, String nik, String nama, String totalbayar, String uangbayar, String uangkembali) {
    try {
            String sql = "insert into loket"
                    + " values ("
                    + "'" + idtiket + "', "
                    + "'" + nik + "',"
                    + "'" + enkapsulasiLoket.getKode_kereta() + "',"
                    + "'" + nama + "',"
                    + "'" + totalbayar + "',"
                    + "'" + uangbayar + "',"
                    + "'" + uangkembali + "'"
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
    public boolean delete(String idtiket) {
     try {
            String sql = "delete from loket where id_tiket='" + idtiket + "'";

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
    public List<enkapsulasiLoket> search(String idtiket, String nik, String nama, String totalbayar, String uangbayar, String uangkembali) {
     List = new ArrayList<enkapsulasiLoket>();
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select* from loket where id_tiket like '%" + idtiket + "%' or nik like '%" + nik + "%' or nama like '%" + nama + "%' or totalbayar like '%" + totalbayar + "%' or uangbayar like '%" + uangbayar + "%' or uangkembali like '%" + uangkembali + "%'" );
            
            while (result.next()) {
                enkapsulasiLoket user = new enkapsulasiLoket();
                user.setIdtiket(result.getString("id_tiket"));
                user.setNik(result.getString("nik"));
                user.setNama(result.getString("nama"));
                user.setTotalbayar(result.getString("totalbayar"));
                user.setUangbayar(result.getString("uangbayar"));
                user.setUangkembali(result.getString("uangkembali"));
                List.add(user);

            }
            return List;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return null;    
    }
}
    
    
    @Override
    public boolean update(String idtiket, String nik, String nama, String totalbayar, String uangbayar, String uangkembali) {
    try {
            String sql = "update loket set "
                    +"id_tiket ='"+idtiket
                    +"',nik ='"+nik
                    +"',nama ='"+nama
                    +"',totalbayar ='"+totalbayar
                    +"',uangbayar ='"+uangbayar
                    +"',uangkembali ='"+uangkembali
                    +"'where id_tiket = '"+idtiket+"'";

            Connection conn = (Connection) koneksi.koneksiDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return false;
        }    
    }
    
   
    public List<enkapsulasiLoket> getAllLoket(){
        List = new ArrayList<enkapsulasiLoket>();
        try {

            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select * from loket");

            while (result.next()) {
                enkapsulasiLoket user = new enkapsulasiLoket();
                user.setIdtiket(result.getString("id_tiket"));
                user.setNik(result.getString("nik"));
                user.setNama(result.getString("nama"));
                user.setTotalbayar(result.getString("totalbayar"));
                user.setUangbayar(result.getString("uangbayar"));
                user.setUangkembali(result.getString("uangkembali"));
                List.add(user);
            }

            return List;

        } catch (SQLException e) {
            messageFailed(e.getMessage());
            return null;
        }
    }
}
