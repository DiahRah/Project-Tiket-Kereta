/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaftarTiketDAO;
import KeretaApi.DaftarTiket;
import KeretaApi.Loket;
import KeretaApi.Menu;
import enkapsulasi.enkapsulasiDaftarTiket;
import implement.implementDaftarTiket;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import tabel.TabelDaftarTiket;

/**
 *
 * @author ASUS
 */
public class daftartiketController {
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private List<enkapsulasiDaftarTiket> List;
    private static DaftarTiket tiketPanel;
    private implementDaftarTiket implementDaftarTiket;
    

    public daftartiketController(DaftarTiket tiketPanel) {
        this.tiketPanel = tiketPanel;
        implementDaftarTiket = new DaftarTiketDAO();
        lokasiform();
        Tabel();
        
    }
    
    public void lokasiform(){
        int x = layar.width / 2  -tiketPanel.getSize().width / 2;
        int y = layar.height / 2 - tiketPanel.getSize().height / 2;
        tiketPanel.setLocation(x, y);
    }
        
    //untuk menghapus data
    public void tombolDelete(){
        if(implementDaftarTiket.delete(tiketPanel.getTxtIdTiket().getText().toString())){
            JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
            Tabel();
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
    }
}
    //untuk mencari data
    public void tombolSearch(){
        String idtiket = tiketPanel.getIdtiket2().getText();
        List = implementDaftarTiket.search(idtiket);
        tiketPanel.getTabeltiket().setModel(new TabelDaftarTiket(List));
        JOptionPane.showMessageDialog(null, "Data Telah Ditemukan");
     
    }   
    public void klikTabel(java.awt.event.MouseEvent evt){
        try {
            int row = tiketPanel.getTabeltiket().rowAtPoint(evt.getPoint()); 
            String idtiket = tiketPanel.getTabeltiket().getValueAt(row, 0).toString();
            tiketPanel.getTxtIdTiket().setText(String.valueOf(idtiket));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Tabel (){
        List = implementDaftarTiket.getAllDaftarTiket();
        tiketPanel.getTabeltiket().setModel(new TabelDaftarTiket(List));
    }
    
    public void tombolBack(){
        new Loket().setVisible(true);
        tiketPanel.setVisible(false);
}
    public void Menu(){
        new Menu().setVisible(true);
        tiketPanel.setVisible(false);
    }
}



