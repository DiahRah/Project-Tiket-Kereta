/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import databases.koneksi;
import enkapsulasi.enkapsulasiDataKereta;
import implement.implementDataKereta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DataKeretaDAO extends Parent implements implementDataKereta {

    private List<enkapsulasiDataKereta> List;

    @Override
    public boolean save(String kodekereta, String namakereta, String jurusan, String keberangkatan, String jenis, String nomorkursi, String harga) {
        try {
            String sql = "insert into datakereta "
                    + " values ("
                    + "'" + kodekereta + "', "
                    + "'" + namakereta + "',"
                    + "'" + jurusan + "',"
                    + "'" + keberangkatan + "',"
                    + "'" + jenis + "',"
                    + "'" + nomorkursi + "',"
                    + "'" + harga + "'"
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
    public boolean delete(String kodekereta) {
        try {
            String sql = "delete from datakereta where kode_kereta='" + kodekereta + "'";

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
    public List<enkapsulasiDataKereta> search(String kodekereta, String namakereta, String jurusan, String keberangkatan, String jenis, String nomorkursi, String harga) {
        List = new ArrayList<enkapsulasiDataKereta>();
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select* from datakereta where kode_kereta like '%" + kodekereta + "%' or nama_kereta like '%" + namakereta + "%' or jurusan like '%" + jurusan + "%' or keberangkatan like '%" + keberangkatan + "%' or jenis like '%" + jenis + "%' or nomor_kursi like '%" + nomorkursi + "%' or harga like '%" + harga + "%'" );
            

            while (result.next()) {
                enkapsulasiDataKereta user = new enkapsulasiDataKereta();
                user.setKodekereta(result.getString("kode_kereta"));
                user.setNamakereta(result.getString("nama_kereta"));
                user.setJurusan(result.getString("jurusan"));
                user.setKeberangkatan(result.getString("keberangkatan"));
                user.setJenis(result.getString("jenis"));
                user.setNomorkursi(result.getString("nomor_kursi"));
                user.setHarga(result.getString("harga"));
                List.add(user);

            }
            return List;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return null;
        }
    }

    @Override
     public boolean update(String kodekereta, String namakereta, String jurusan, String keberangkatan, String jenis, String nomorkursi, String harga) {
        try {
            String sql = "update datakereta set "
                    +"kode_kereta ='"+kodekereta
                    +"',nama_kereta ='"+namakereta
                    +"',jurusan ='"+jurusan
                    +"',keberangkatan ='"+keberangkatan
                    +"',jenis ='"+jenis
                    +"',nomor_kursi ='"+nomorkursi
                    +"',harga ='"+harga
                    +"'where kode_kereta = '"+kodekereta+"'";

            Connection conn = (Connection) koneksi.koneksiDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return false;
        }

    }

    public List<enkapsulasiDataKereta> getAllDataKereta() {
        List = new ArrayList<enkapsulasiDataKereta>();
        try {

            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select kode_kereta, nama_kereta ,jurusan, keberangkatan, jenis, nomor_kursi, harga from datakereta ORDER BY kode_kereta");

            while (result.next()) {
                enkapsulasiDataKereta user = new enkapsulasiDataKereta();
                user.setKodekereta(result.getString("kode_kereta"));
                user.setNamakereta(result.getString("nama_kereta"));
                user.setJurusan(result.getString("jurusan"));
                user.setKeberangkatan(result.getString("keberangkatan"));
                user.setJenis(result.getString("jenis"));
                user.setNomorkursi(result.getString("nomor_kursi"));
                user.setHarga(result.getString("harga"));
                List.add(user);

            }
            return List;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return null;
        }
    }
}
