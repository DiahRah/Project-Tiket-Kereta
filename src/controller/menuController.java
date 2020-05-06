/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import KeretaApi.DaftarTiket;
import KeretaApi.DataKereta;
import KeretaApi.Loket;
import KeretaApi.Menu;
import KeretaApi.PesanTiket;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author ASUS
 */
public class menuController {
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private static Menu menuPanel;

    public menuController(Menu menuPanel) {
        this.menuPanel = menuPanel;
        lokasiform();
    }
    
    public void lokasiform(){
        int x = layar.width / 2  -menuPanel.getSize().width / 2;
        int y = layar.height / 2 - menuPanel.getSize().height / 2;
        menuPanel.setLocation(x, y);
    }
    public void PesanTiket(){
        new PesanTiket().setVisible(true);
        menuPanel.setVisible(false);
    }
    public void DataKereta(){
        new DataKereta().setVisible(true);
        menuPanel.setVisible(false);
    }
    public void Loket(){
        new Loket().setVisible(true);
        menuPanel.setVisible(false);
    }
    public void DaftarTiket(){
        new DaftarTiket().setVisible(true);
        menuPanel.setVisible(false);
    }
}
