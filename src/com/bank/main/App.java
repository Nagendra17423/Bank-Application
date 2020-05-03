/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.main;

import com.bank.screens.Login;
import javax.swing.SwingUtilities;


public class App {
    public static void main(String[] args) {
        
  
    Runnable r=new Runnable(){

        @Override
        public void run() {
            Login l=new Login();
            l.setVisible(true);
        }
        
    };
    
    SwingUtilities.invokeLater(r);
    

}  }
