/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satria_26122022.model;

/**
 *
 * @author Satria
 */
import satria_26122022.model.Anggota;
import java.util.List;
/**
 *
 * @author ACER
 */
public interface AnggotaDao {
     void save(Anggota anggota);
    void update(int index, Anggota anggota);
    void delete (int index);
    Anggota getAnggota(int index);
    List<Anggota> getAll();

}