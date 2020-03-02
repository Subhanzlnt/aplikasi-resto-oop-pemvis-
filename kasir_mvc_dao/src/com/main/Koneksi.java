package com.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
 
public class Koneksi {
    Connection con;
    Statement stm;
    
    public void config() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/kasir_mvc", "root", "");
            stm = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }
}


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//
//public class Koneksi {
//    Connection koneksi;
//    
//    public static Connection Koneksi() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/restombokdar", "root", "");
//            
//            return koneksi;
//        } catch(ClassNotFoundException | SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//            
//            return null;
//        }
//    }
//}