/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.loginDAO;
import KeretaApi.LoginAdmin;
import KeretaApi.Menu;
import implement.implementLogin;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class loginController {
    
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private static LoginAdmin loginPanel;
    private static implementLogin implementLogin;

    public loginController(LoginAdmin loginPanel) {
        this.loginPanel = loginPanel;
        implementLogin = new loginDAO();
        lokasiform();
    }
    
    public void lokasiform(){
        int x = layar.width / 2  -loginPanel.getSize().width / 2;
        int y = layar.height / 2 - loginPanel.getSize().height / 2;
        loginPanel.setLocation(x, y);
    }

    public void login(){
        String userid = loginPanel.getUserid().getText().toString();
        String password = loginPanel.getPassword().getText().toString();
        if(implementLogin.login(userid, password)){
            JOptionPane.showMessageDialog(null, "Login Sukses");
            new Menu().setVisible(true);
            loginPanel.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Periksa USER ID dan PASSWORD anda ");
        }
        
        
    }

    
}
