/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satria_26122022.model;
import satria_26122022.model.Anggota;
import satria_26122022.model.AnggotaDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author satri
 */
public class AnggotaDaoImpl implements AnggotaDao {
     List<Anggota> data = new ArrayList<>();
    
        public AnggotaDaoImpl() {
        data.add(new Anggota("2101092046","Satria","Padang"));
        data.add(new Anggota("2001092015","Viola yosevi","Kalumbuk"));
        data.add(new Anggota("2101092046","ghdjh","Padang"));   
    }
        
    public void save(Anggota anggota){
        data.add(anggota);
    }
    public void update(int index, Anggota anggota){
        data.set(index, anggota);
    }
    public void delete (int index){
        data.remove(index);
    }
    public Anggota getAnggota(int index){
        return data.get(index);
    }
    public List<Anggota> getAll(){
        return data;
    } 
    

    
}