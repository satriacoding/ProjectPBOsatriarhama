/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UASB.model;

import UASB.model.WarnetDao;
import UASB.model.Pelanggan;
import UASB.model.Warnet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author satri
 */
public class WarnetDaoImpl implements WarnetDao {
    private List<Warnet> data = new ArrayList<>();

    public WarnetDaoImpl() {
      data.add(new Warnet("2002-02-23","10:00:00","09:00:00",100000));
      data.add(new Warnet("2002-02-24","11:00:00","12:00:00",140000));
      data.add(new Warnet("2002-02-13","02:00:00","08:00:00",240000));


    }
  public Warnet save(Warnet warnet){
        data.add(warnet);
        return warnet;
    }
    
    public Warnet update(int index,Warnet warnet){
        data.set(index,warnet);
        return warnet;
    }
    
    public Warnet delete(int index){
        return data.remove(index);
    }
    
    public Warnet  getWarnet(int index){
        return data.get(index);
    }
    
    public List<Warnet> getAllWarnet(){
        return data;
    }
   
}
