
package com.model.dao;

import com.model.Menu;
import com.model.database.ConnectionDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class MenuDAO implements ImplementMenu{
    
    private List<Menu> list;
            
    @Override
    public void input(Menu data) {
        
        try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement(""
                    + "INSERT INTO menu (id, nama, harga) VALUES (null, ?, ?)");
            
            statement.setString(1, data.getNama());
            statement.setString(2, data.getHarga());
            
            statement.executeUpdate();
          
          
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Menu data) {
          try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement(""
                    + "UPDATE menu SET nama=?, harga=? WHERE id=?");
            
            statement.setString(1, data.getNama());
            statement.setString(2, data.getHarga());
            statement.setInt(3, data.getId());
            
          
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          
    }

    @Override
    public void delete(int id) {
   
          try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement(""
                    + "DELETE FROM menu WHERE id=?");
            
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

    @Override
    public List<Menu> getMenu(String nama) {
       list = new ArrayList<Menu>();
        
        try {
            
            Statement statement = ConnectionDatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM menu WHERE nama LIKE '%" + nama + "%'");
            
            while (result.next()) { 
                Menu data = new Menu();
                data.setId(result.getInt(1));
                data.setNama(result.getString("nama"));
                data.setHarga(result.getString("harga"));
                list.add(data);
            }
            
            statement.close();
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
           }

    @Override
    public List<Menu> getAllMenu() {
       list = new ArrayList<Menu>();
        
        try {
            
            Statement statement = ConnectionDatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM menu");
            
            while (result.next()) { 
                Menu mahasiswa = new Menu();
                mahasiswa.setId(result.getInt(1));
                mahasiswa.setNama(result.getString("nama"));
                mahasiswa.setHarga(result.getString("harga"));
                list.add(mahasiswa);
            }
            
            
            statement.close();
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } }

}
