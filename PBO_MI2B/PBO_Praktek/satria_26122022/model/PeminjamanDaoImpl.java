/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satria_26122022.model;

/**
 *
 * @author satri
 */
import satria_26122022.model.Peminjaman;
import satria_26122022.model.PeminjamanDao;
import java.util.ArrayList;
import java.util.List;

public class PeminjamanDaoImpl implements PeminjamanDao{
    List<Peminjaman> data= new ArrayList<>();
    
      public PeminjamanDaoImpl() {
        data.add(new Peminjaman("2101092046","12323","2002-02-19","2002-02-20"));
        data.add(new Peminjaman("2101092046","12323","2002-02-19","2002-02-12"));
        data.add(new Peminjaman("2001092015","12323","2002-02-19","2002-02-21"));
        data.add(new Peminjaman("2101092046","12323","2002-02-19","2002-02-27"));   
    }
      
    public Peminjaman save(Peminjaman peminjaman){
        data.add(peminjaman);
        return peminjaman;
    }
    
    public Peminjaman update(int index,Peminjaman peminjaman){
        data.set(index,peminjaman);
        return peminjaman;
    }
    
    public Peminjaman delete(int index){
        return data.remove(index);
    }
    
    public Peminjaman  getPeminjaman(int index){
        return data.get(index);
    }
    
    public List<Peminjaman> getAllPeminjaman(){
        return data;
    }
}