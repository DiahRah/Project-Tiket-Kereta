/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Parent {
    
    protected void messageSuccess (String Pesan){
        JOptionPane.showMessageDialog(null, Pesan, "pesan", JOptionPane.INFORMATION_MESSAGE);
    
    }
     protected void messageFailed (String Pesan){
        JOptionPane.showMessageDialog(null, Pesan, "pesan", JOptionPane.ERROR_MESSAGE);
    }
}
