/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satria_26122022.model;
import satria_26122022.model.Buku;
import java.util.List;

/**
 *
 * @author LABMM07
 */
public interface BukuDao {
    void save(Buku buku);
    void update(int index, Buku buku);
    void delete (int index);
    Buku getBuku(int index);
    List<Buku> getAll();
}
