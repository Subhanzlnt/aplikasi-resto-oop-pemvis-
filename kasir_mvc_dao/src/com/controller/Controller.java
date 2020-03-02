
package com.controller;

import com.model.Menu;
import com.model.dao.MenuDAO;
import com.model.tabel.TabelModelMenu;
import com.view.PanelForm;
import java.util.List;
import javax.swing.JOptionPane;
import com.model.dao.ImplementMenu;

/**
 *
 * @author asus
 */
public class Controller {

    private final PanelForm panel;
    private List<Menu> list;
    private final ImplementMenu implementMenu;
    
    public Controller(PanelForm panel) {
        this.panel = panel;
        implementMenu = new MenuDAO();
        list = implementMenu.getAllMenu();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtNama().setText("");
        panel.getTxtHarga().setText("");
        panel.getTabelMenu().clearSelection();
    }
    
    public void isiTabel(){
        list = implementMenu.getAllMenu();
        panel.getTabelMenu().setModel(new TabelModelMenu(list));
        
    }
    
    public  void getDataField(){
        
        int row = panel.getTabelMenu().getSelectedRow();
        
        if (row != -1){
            
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtNama().setText(list.get(row).getNama());
            panel.getTxtHarga().setText(list.get(row).getHarga());
            
        }
       
    }
    
    public void insert(){
        
        Menu data = new Menu();
        data.setNama(panel.getTxtNama().getText());
        data.setHarga(panel.getTxtHarga().getText());
        implementMenu.input(data);
    }

    public void update(){
        
        Menu data = new Menu();
        data.setId(Integer.parseInt(panel.getTxtId().getText()));
        data.setNama(panel.getTxtNama().getText());
        data.setHarga(panel.getTxtHarga().getText());
        
        implementMenu.update(data);
    
    }
    
    public void delete(){
        
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "No data deleted....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int row = Integer.parseInt(panel.getTxtId().getText());
        
        implementMenu.delete(row);
        
    }
    
    public void getData(){
        
        if (panel.getTxtNama().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Isi data Nama yang mau di cari....? ", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nama = panel.getTxtNama().getText();
        
        implementMenu.getMenu(nama);
        isiTabelCari(nama);
    }

   public void isiTabelCari(String nama){
        
        list = implementMenu.getMenu(nama);
        panel.getTabelMenu().setModel(new TabelModelMenu(list));
    }
}
    

