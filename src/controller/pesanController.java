/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.pesanDAO;
import KeretaApi.DataKereta;
import KeretaApi.Menu;
import KeretaApi.PesanTiket;
import enkapsulasi.enkapsulasiLoket;
import enkapsulasi.enkapsulasiPesan;
import implement.implementPesan;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import tabel.TabelPesan;

/**
 *
 * @author ASUS
 */
public class pesanController {
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private List<enkapsulasiPesan> List;
    private static PesanTiket pesanPanel;
    private static implementPesan implementPesan;
    

    public pesanController(PesanTiket pesanPanel) {
        this.pesanPanel = pesanPanel;
        implementPesan = new pesanDAO();
        lokasiform();
        Tabel();
    }
    
    public void lokasiform(){
        int x = layar.width / 2  -pesanPanel.getSize().width / 2;
        int y = layar.height / 2 - pesanPanel.getSize().height / 2;
        pesanPanel.setLocation(x, y);
    }
    
    //untuk menyimpan data
    public void save(){
        String nik = null;
        String nama = null;
        String alamat = null;
        String gender = null;
        String telepon = null;
        
        if (pesanPanel.getNik2().getText().toString().equals("")){
            nik = "null";
        }else{
            nik = pesanPanel.getNik2().getText().toString();
        }
        
        if (pesanPanel.getNama2().getText().toString().equals("")){
            nama = "null";
        }else{
            nama = pesanPanel.getNama2().getText().toString();
        }
        
        if (pesanPanel.getAlamat2().getText().toString().equals("")){
            alamat = "null";
        }else{
            alamat = pesanPanel.getAlamat2().getText().toString();
        }
        
        if (pesanPanel.getCbgender2().getSelectedItem().toString().equals("")){
            gender = "null";
        }else{
            gender = pesanPanel.getCbgender2().getSelectedItem().toString();
        }
        
        if (pesanPanel.getTelepon2().getText().toString().equals("")){
            telepon = "null";
        }else{
            telepon = pesanPanel.getTelepon2().getText().toString();
        }
         
        if (implementPesan.save(nik, nama, alamat, gender, telepon)){
            JOptionPane.showMessageDialog(null, "Data Telah Ditambahkan");
            Tabel();
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
        }
    }
    
    
    //untuk menghapus data
    public void tombolDelete(){
        if(implementPesan.delete(pesanPanel.getNik2().getText().toString())){
            JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
            Tabel();
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
    
    }
}
    
    //untuk mencari data
    public void tombolSearch(){
        String nik = null;
        String nama = null;
        String alamat = null;
        String gender = null;
        String telepon = null;
        if (pesanPanel.getNik2().getText().toString().equals("")){
            nik = "null";
        }else{
            nik = pesanPanel.getNik2().getText().toString();
        }
        
        if (pesanPanel.getNama2().getText().toString().equals("")){
            nama = "null";
        }else{
            nama = pesanPanel.getNama2().getText().toString();
        }
        if (pesanPanel.getAlamat2().getText().toString().equals("")){
            alamat = "null";
        }else{
            alamat = pesanPanel.getAlamat2().getText().toString();
        }
        if (pesanPanel.getCbgender2().getSelectedItem().toString().equals("")){
            gender = "null";
        }else{
            gender = pesanPanel.getCbgender2().getSelectedItem().toString();
        }
        if (pesanPanel.getTelepon2().getText().toString().equals("")){
            telepon = "null";
        }else{
            telepon = pesanPanel.getTelepon2().getText().toString();
        }
        List = implementPesan.search(nik, nama, alamat, gender, telepon);

        pesanPanel.getTabelpesan().setModel(new TabelPesan(List));
        JOptionPane.showMessageDialog(null,"Data Ditemukan");

        //komponen("cari");
        
    
        }

    public void tombolUpdate(){
        String nik = pesanPanel.getNik2().getText().toString();
        String nama = pesanPanel.getNama2().getText().toString();
        String alamat = pesanPanel.getAlamat2().getText().toString();
        String gender = pesanPanel.getCbgender2().getSelectedItem().toString();
        String telepon = pesanPanel.getTelepon2().getText().toString();
        if (implementPesan.update(nik, nama, alamat, gender, telepon)) {
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Update");
            Tabel();
        } else {
            JOptionPane.showMessageDialog(null, "Data gagal Diubah");
        }
    }
    
    
    public void tombolReset(){
        pesanPanel.getNik2().setText(null);
        pesanPanel.getNama2().setText(null);
        pesanPanel.getAlamat2().setText(null);
        pesanPanel.getCbgender2().setSelectedItem("---");
        pesanPanel.getTelepon2().setText(null);
   }
    
    public void klikTabel(java.awt.event.MouseEvent evt){
        try {
            
            int row = pesanPanel.getTabelpesan().rowAtPoint(evt.getPoint());

            String nik = pesanPanel.getTabelpesan().getValueAt(row, 0).toString();
            String nama = pesanPanel.getTabelpesan().getValueAt(row, 1).toString();
            String alamat = pesanPanel.getTabelpesan().getValueAt(row, 2).toString();
            String gender = pesanPanel.getTabelpesan().getValueAt(row, 3).toString();
            String telepon = pesanPanel.getTabelpesan().getValueAt(row, 4).toString();
           

            pesanPanel.getNik2().setText(String.valueOf(nik));
            pesanPanel.getNama2().setText(String.valueOf(nama));
            pesanPanel.getAlamat2().setText(String.valueOf(alamat));
            pesanPanel.getCbgender2().setSelectedItem(String.valueOf(gender));
            pesanPanel.getTelepon2().setText(String.valueOf(telepon));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Tabel (){
        List = implementPesan.getAllPesan();
        pesanPanel.getTabelpesan().setModel(new TabelPesan(List));
    }
   
    
    public void tombolNext(){
        
        enkapsulasiLoket.setSession_nik(pesanPanel.getNik2().getText());
        enkapsulasiLoket.setSession_nama(pesanPanel.getNama2().getText());
        new DataKereta().setVisible(true);
        pesanPanel.setVisible(false);
 
    }
     public void tombolBack(){
        new Menu().setVisible(true);
        pesanPanel.setVisible(false);
}
    
    public void Menu(){
        new Menu().setVisible(true);
        pesanPanel.setVisible(false);
    }
    
    public void DataKereta(){
        new DataKereta().setVisible(true);
        pesanPanel.setVisible(false);
    }
}
