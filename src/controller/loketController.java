/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LoketDAO;
import KeretaApi.DaftarTiket;
import KeretaApi.DataKereta;
import KeretaApi.Loket;
import KeretaApi.Menu;
import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import enkapsulasi.enkapsulasiLoket;
import implement.implementLoket;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import tabel.TabelLoket;

/**
 *
 * @author DIAH
 */
public class loketController {
    
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private List<enkapsulasiLoket> List;
    private static Loket loketPanel;
    private static implementLoket implementLoket;
    

    public loketController(Loket loketPanel) {
        this.loketPanel = loketPanel;
        implementLoket = new LoketDAO();
        lokasiform();
        Tabel();
        loketPanel.getNik2().setText(enkapsulasiLoket.getSession_nik());//jtex dipisah dengan controlle, tiket panel memannggil nik, set text langsung ada nilai dengan nilai yang diambil dari session
        loketPanel.getNama2().setText(enkapsulasiLoket.getSession_nama());//jtex dipisah dengan controlle, tiket panel memannggil nik, set text langsung ada nilai dengan nilai yang diambil dari session
        
    }


    public void lokasiform(){
        int x = layar.width / 2  - loketPanel.getSize().width / 2;
        int y = layar.height / 2 - loketPanel.getSize().height / 2;
        loketPanel.setLocation(x, y);
    }
    
    //untuk menyimpan data
    public void save(){
        String idtiket = null;
        String nik = null;
        String nama = null;
        String totalbayar = null;
        String uangbayar = null;
        String uangkembali = null;
        
        if (loketPanel.getIdtiket2().getText().toString().equals("")){
            idtiket = "null";
        }else{
            idtiket = loketPanel.getIdtiket2().getText().toString();
        }
        
        if (loketPanel.getNik2().getText().toString().equals("")){
            nik = "null";
        }else{
            nik = loketPanel.getNik2().getText().toString();
        }
        
        if (loketPanel.getNama2().getText().toString().equals("")){
            nama = "null";
        }else{
            nama= loketPanel.getNama2().getText().toString();
        }
        
        if (loketPanel.getTotalbayar2().getText().toString().equals("")){
            totalbayar = "null";
        }else{
            totalbayar = loketPanel.getTotalbayar2().getText().toString();
        }
        
        if (loketPanel.getUangbayar2().getText().toString().equals("")){
            uangbayar = "null";
        }else{
            uangbayar = loketPanel.getUangbayar2().getText().toString();
        }
        if (loketPanel.getUangkembali2().getText().toString().equals("")){
            uangkembali = "null";
        }else{
            uangkembali = loketPanel.getUangkembali2().getText().toString();
        }
        if (implementLoket.save(idtiket, nik, nama, totalbayar, uangbayar, uangkembali)){
            JOptionPane.showMessageDialog(null, "Data Telah Ditambahkan");
            Tabel();
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
        }
    }
    
    
    //untuk menghapus data
    public void tombolDelete(){
        if(implementLoket.delete(loketPanel.getIdtiket2().getText().toString())){
            JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
            Tabel();
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
    
    }
}
    
    //untuk mencari data
    public void tombolSearch(){
        String idtiket = null;
        String nik = null;
        String nama = null;
        String totalbayar = null;
        String uangbayar = null;
        String uangkembali = null;
        
        if (loketPanel.getIdtiket2().getText().toString().equals("")){
            idtiket = "null";
        }else{
            idtiket = loketPanel.getIdtiket2().getText().toString();
        }
        
        if (loketPanel.getNik2().getText().toString().equals("")){
            nik = "null";
        }else{
            nik = loketPanel.getNik2().getText().toString();
        }
        
        if (loketPanel.getNama2().getText().toString().equals("")){
            nama = "null";
        }else{
            nama= loketPanel.getNama2().getText().toString();
        }
        
        if (loketPanel.getTotalbayar2().getText().toString().equals("")){
            totalbayar = "null";
        }else{
            totalbayar = loketPanel.getTotalbayar2().getText().toString();
        }
        
        if (loketPanel.getUangbayar2().getText().toString().equals("")){
            uangbayar = "null";
        }else{
            uangbayar = loketPanel.getUangbayar2().getText().toString();
        }
        if (loketPanel.getUangkembali2().getText().toString().equals("")){
            uangkembali = "null";
        }else{
            uangkembali = loketPanel.getUangkembali2().getText().toString();
        }
        List = implementLoket.search(idtiket, nik, nama, totalbayar, uangbayar, uangkembali);
        loketPanel.getTabelloket().setModel(new TabelLoket(List));
        JOptionPane.showMessageDialog(null,"Data Ditemukan");

        //komponen("cari");
        
    
        }

    public void tombolUpdate(){
        String idtiket = loketPanel.getIdtiket2().getText().toString();
        String nik = loketPanel.getNik2().getText().toString();
        String nama = loketPanel.getNama2().getText().toString();
        String totalbayar = loketPanel.getTotalbayar2().getText().toString();
        String uangbayar = loketPanel.getUangbayar2().getText().toString();
        String uangkembali = loketPanel.getUangkembali2().getText().toString();
        if (implementLoket.update(idtiket, nik, nama, totalbayar, uangbayar, uangkembali)) {
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Update");
            Tabel();
        } else {
            JOptionPane.showMessageDialog(null, "Data gagal Diubah");
        }
    }
    
    
    public void tombolReset(){
        loketPanel.getIdtiket2().setText(null);
        loketPanel.getNik2().setText(null);
        loketPanel.getNama2().setText(null);
        loketPanel.getTotalbayar2().setText(null);
        loketPanel.getUangbayar2().setText(null);
        loketPanel.getUangkembali2().setText(null);
   }
    public void kembalian(){
        int totalharga = Integer.parseInt(loketPanel.getTotalbayar2().getText());
        int uangbayar = Integer.parseInt(loketPanel.getUangbayar2().getText());
        int uangkembali = uangbayar - totalharga;
        loketPanel.getUangkembali2().setText(String.valueOf(uangkembali));
    }
    
    public void klikTabel(java.awt.event.MouseEvent evt){
        try {
            
            int row = loketPanel.getTabelloket().rowAtPoint(evt.getPoint());

            String idtiket = loketPanel.getTabelloket().getValueAt(row, 0).toString();
            String nik = loketPanel.getTabelloket().getValueAt(row, 1).toString();
            String nama = loketPanel.getTabelloket().getValueAt(row, 2).toString();
            String totalbayar = loketPanel.getTabelloket().getValueAt(row, 3).toString();
            String uangbayar = loketPanel.getTabelloket().getValueAt(row, 4).toString();
            String uangkembali = loketPanel.getTabelloket().getValueAt(row, 5).toString();
           

            loketPanel.getIdtiket2().setText(String.valueOf(idtiket));
            loketPanel.getNik2().setText(String.valueOf(nik));
            loketPanel.getNama2().setText(String.valueOf(nama));
            loketPanel.getTotalbayar2().setText(String.valueOf(totalbayar));
            loketPanel.getUangbayar2().setText(String.valueOf(uangbayar));
            loketPanel.getUangkembali2().setText(String.valueOf(uangkembali));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Tabel (){
        List = implementLoket.getAllLoket();
        loketPanel.getTabelloket().setModel(new TabelLoket(List));
    }
   
    public void tombolBack(){
        new DataKereta().setVisible(true);
        loketPanel.setVisible(false);
}
    public void tombolNext(){
        new DaftarTiket().setVisible(true);
        loketPanel.setVisible(false);
    }
    
    public void Menu(){
        new Menu().setVisible(true);
        loketPanel.setVisible(false);
    }
}
