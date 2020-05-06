/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DataKeretaDAO;
import KeretaApi.DataKereta;
import KeretaApi.Loket;
import KeretaApi.Menu;
import KeretaApi.PesanTiket;
import enkapsulasi.enkapsulasiDataKereta;
import implement.implementDataKereta;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import tabel.TabelDataKereta;
import enkapsulasi.enkapsulasiLoket;

/**
 *
 * @author ASUS
 */
public class datakeretaController {
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private List<enkapsulasiDataKereta> List;
    private static DataKereta keretaPanel;
    private implementDataKereta implementDataKereta;
    

    public datakeretaController(DataKereta keretaPanel) {
        this.keretaPanel = keretaPanel;
        implementDataKereta = new DataKeretaDAO();
        lokasiform();
        Tabel();
        
    }
    
    public void lokasiform(){
        int x = layar.width / 2  -keretaPanel.getSize().width / 2;
        int y = layar.height / 2 - keretaPanel.getSize().height / 2;
        keretaPanel.setLocation(x, y);
    }
    
    public void save(){
        String kodekereta = null;
        String namakereta = null;
        String jurusan = null;
        String keberangkatan = null;
        String jenis = null;
        String nomorkursi = null;
        String harga = null;
        
        if (keretaPanel.getCbkodekereta().getSelectedItem().toString().equals("")){
            kodekereta = "null";
        }else{
            kodekereta = keretaPanel.getCbkodekereta().getSelectedItem().toString();
        }
        
        if (keretaPanel.getCbnamakereta().getSelectedItem().toString().equals("")){
            namakereta = "null";
        }else{
            namakereta = keretaPanel.getCbnamakereta().getSelectedItem().toString();
        }
        
        if (keretaPanel.getCbjurusan().getSelectedItem().toString().equals("")){
            jurusan = "null";
        }else{
            jurusan = keretaPanel.getCbjurusan().getSelectedItem().toString();
        }
        
        if (keretaPanel.getCbkeberangkatan().getSelectedItem().toString().equals("")){
            keberangkatan = "null";
        }else{
            keberangkatan = keretaPanel.getCbkeberangkatan().getSelectedItem().toString();
        }
        
        if (keretaPanel.getCbjenis().getSelectedItem().toString().equals("")){
            jenis = "null";
        }else{
            jenis = keretaPanel.getCbjenis().getSelectedItem().toString();
        }
        if (keretaPanel.getNomorkursi2().getText().toString().equals("")){
            nomorkursi = "null";
        }else{
            nomorkursi = keretaPanel.getNomorkursi2().getText().toString();
        }
        
        if (keretaPanel.getHarga2().getText().toString().equals("")){
            harga = "null";
        }else{
            harga = keretaPanel.getHarga2().getText().toString();
        }
        
        if (implementDataKereta.save(kodekereta, namakereta, jurusan, keberangkatan, jenis, nomorkursi, harga)){
            JOptionPane.showMessageDialog(null, "Data Telah Ditambahkan");
            Tabel();
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
        }
    }
    
    
    //untuk menghapus data
    public void tombolDelete(){
        if(implementDataKereta.delete(keretaPanel.getCbkodekereta().getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
            Tabel();
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
    
    }
}
    
    //untuk mencari data
    public void tombolSearch(){
        String kodekereta = null;
        String namakereta = null;
        String jurusan = null;
        String keberangkatan = null;
        String jenis = null;
        String nomorkursi = null;
        String harga = null;
          if (keretaPanel.getCbkodekereta().getSelectedItem().toString().equals("")){
            kodekereta = "null";
        }else{
            kodekereta = keretaPanel.getCbkodekereta().getSelectedItem().toString();
        }
        
        if (keretaPanel.getCbnamakereta().getSelectedItem().toString().equals("")){
            namakereta = "null";
        }else{
            namakereta = keretaPanel.getCbnamakereta().getSelectedItem().toString();
        }
        
        if (keretaPanel.getCbjurusan().getSelectedItem().toString().equals("")){
            jurusan = "null";
        }else{
            jurusan = keretaPanel.getCbjurusan().getSelectedItem().toString();
        }
        
        if (keretaPanel.getCbkeberangkatan().getSelectedItem().toString().equals("")){
            keberangkatan = "null";
        }else{
            keberangkatan = keretaPanel.getCbkeberangkatan().getSelectedItem().toString();
        }
        
        if (keretaPanel.getCbjenis().getSelectedItem().toString().equals("")){
            jenis = "null";
        }else{
            jenis = keretaPanel.getCbjenis().getSelectedItem().toString();
        }
        
        if (keretaPanel.getNomorkursi2().getText().toString().equals("")){
            nomorkursi = "null";
        }else{
            nomorkursi = keretaPanel.getNomorkursi2().getText().toString();
        }
        
        if (keretaPanel.getHarga2().getText().toString().equals("")){
            harga = "null";
        }else{
            harga = keretaPanel.getHarga2().getText().toString();
        }
        
        List = implementDataKereta.search(kodekereta, namakereta, jurusan, keberangkatan, jenis, nomorkursi, harga);

        keretaPanel.getTabeldatakereta().setModel(new TabelDataKereta(List));
        JOptionPane.showMessageDialog(null,"Data Ditemukan");

        //komponen("cari");
        
    
        }

    public void tombolUpdate(){
        String kodekereta = keretaPanel.getCbkodekereta().getSelectedItem().toString();
        String namakereta = keretaPanel.getCbnamakereta().getSelectedItem().toString();
        String jurusan = keretaPanel.getCbjurusan().getSelectedItem().toString();
        String keberangkatan = keretaPanel.getCbkeberangkatan().getSelectedItem().toString();
        String jenis = keretaPanel.getCbjenis().getSelectedItem().toString();
        String nomorkursi = keretaPanel.getNomorkursi2().getText().toString();
        String harga = keretaPanel.getHarga2().getText().toString();
        if (implementDataKereta.update(kodekereta, namakereta, jurusan, keberangkatan, jenis, nomorkursi, harga)) {
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Update");
            Tabel();
        } else {
            JOptionPane.showMessageDialog(null, "Data gagal Di Update");
        }
    }
    
    
    
    public void klikTabel(java.awt.event.MouseEvent evt){
        try {
            
            int row = keretaPanel.getTabeldatakereta().rowAtPoint(evt.getPoint());

            String kodekereta = keretaPanel.getTabeldatakereta().getValueAt(row, 0).toString();
            String namakereta = keretaPanel.getTabeldatakereta().getValueAt(row, 1).toString();
            String jurusan = keretaPanel.getTabeldatakereta().getValueAt(row, 2).toString();
            String keberangkatan = keretaPanel.getTabeldatakereta().getValueAt(row, 3).toString();
            String jenis = keretaPanel.getTabeldatakereta().getValueAt(row, 4).toString();
            String nomorkursi = keretaPanel.getTabeldatakereta().getValueAt(row, 5).toString();
            String harga = keretaPanel.getTabeldatakereta().getValueAt(row, 6).toString();
           
            keretaPanel.getCbkodekereta().setSelectedItem(String.valueOf(kodekereta));
            keretaPanel.getCbnamakereta().setSelectedItem(String.valueOf(namakereta));
            keretaPanel.getCbjurusan().setSelectedItem(String.valueOf(jurusan));
            keretaPanel.getCbkeberangkatan().setSelectedItem(String.valueOf(keberangkatan));
            keretaPanel.getCbjenis().setSelectedItem(String.valueOf(jenis));
            keretaPanel.getNomorkursi2().setText(String.valueOf(nomorkursi));
            keretaPanel.getHarga2().setText(String.valueOf(harga));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Tabel (){
        List = implementDataKereta.getAllDataKereta();
        keretaPanel.getTabeldatakereta().setModel(new TabelDataKereta(List));
    }
    
     public void tombolReset(){
        keretaPanel.getCbkodekereta().setSelectedItem("---");
        keretaPanel.getCbnamakereta().setSelectedItem("---");
        keretaPanel.getCbjurusan().setSelectedItem("---");
        keretaPanel.getCbkeberangkatan().setSelectedItem("---");
        keretaPanel.getCbjenis().setSelectedItem("---");
        keretaPanel.getNomorkursi2().setText("---");
        keretaPanel.getHarga2().setText("---");
       
       
   }
    
   
    
    public void tombolNext(){
        new Loket().setVisible(true);
        keretaPanel.setVisible(false);
    }
    
    public void tombolBack(){
        new PesanTiket().setVisible(true);
        keretaPanel.setVisible(false);
    }
    public void Menu(){
        new Menu().setVisible(true);
        keretaPanel.setVisible(false);
    }
    
    public void DataTiket(){
        new PesanTiket().setVisible(true);
        keretaPanel.setVisible(false);
    }
}


