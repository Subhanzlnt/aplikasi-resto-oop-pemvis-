
package com.model.dao;

import com.model.Menu;
import java.util.List;

/**
 *
 * @author asus
 */
public interface ImplementMenu {
    
    public void input(Menu data);
    
    public void update(Menu data);
    
    public void delete(int id);
    
    public List<Menu> getMenu(String nama);
    
    public List<Menu> getAllMenu();

}
