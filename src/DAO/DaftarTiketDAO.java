/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import databases.koneksi;
import enkapsulasi.enkapsulasiDaftarTiket;
import implement.implementDaftarTiket;
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
public class DaftarTiketDAO extends Parent implements implementDaftarTiket {
    
    private List<enkapsulasiDaftarTiket> List;
    
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
    public List<enkapsulasiDaftarTiket> search(String idtiket) {
     List = new ArrayList<enkapsulasiDaftarTiket>();
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select penumpang.nik, penumpang.nama, loket.id_tiket, datakereta.kode_kereta, datakereta.jurusan, datakereta.keberangkatan, datakereta.nomor_kursi from penumpang, loket, datakereta where penumpang.nik= loket.nik and loket.kode_kereta=datakereta.kode_kereta;" );
            while (result.next()) {
                enkapsulasiDaftarTiket user = new enkapsulasiDaftarTiket();
                user.setIdtiket(result.getString("id_tiket"));
                user.setNik(result.getString("nik"));
                user.setNama(result.getString("nama"));
                user.setKodekereta(result.getString("kode_kereta"));
                user.setJurusan(result.getString("jurusan"));
                user.setKeberangkatan(result.getString("keberangkatan"));
                user.setNomorkursi(result.getString("nomor_kursi"));
                List.add(user);

            }
            return List;
        } catch (Exception e) {
            messageFailed(e.getMessage());
            return null;    
    }
}
    
    public List<enkapsulasiDaftarTiket> getAllDaftarTiket(){
        List = new ArrayList<enkapsulasiDaftarTiket>();
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select penumpang.nik, penumpang.nama, loket.id_tiket, datakereta.kode_kereta, datakereta.jurusan, datakereta.keberangkatan, datakereta.nomor_kursi from penumpang, loket, datakereta where penumpang.nik= loket.nik and loket.kode_kereta=datakereta.kode_kereta;" );

            while (result.next()) {
                enkapsulasiDaftarTiket user = new enkapsulasiDaftarTiket();
                user.setIdtiket(result.getString("id_tiket"));
                user.setNik(result.getString("nik"));
                user.setNama(result.getString("nama"));
                user.setKodekereta(result.getString("kode_kereta"));
                user.setJurusan(result.getString("jurusan"));
                user.setKeberangkatan(result.getString("keberangkatan"));
                user.setNomorkursi(result.getString("nomor_kursi"));
                List.add(user);
            }

            return List;

        } catch (SQLException e) {
            messageFailed(e.getMessage());
            return null;
        }    
    }
    
    
}
