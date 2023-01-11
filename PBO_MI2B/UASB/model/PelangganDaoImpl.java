/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UASB.model;

/**
 *
 * @author satri
 */
import UASB.model.PelangganDao;
import UASB.model.Pelanggan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class PelangganDaoImpl implements PelangganDao {
     private List<Pelanggan> data = new ArrayList<>();

    public PelangganDaoImpl() {
    }
    

    @Override
    public void save(Pelanggan pelanggan) {
                data.add(pelanggan);
    }

    @Override
    public void update(int index, Pelanggan pelanggan) {
                data.set(index, pelanggan);
    }

    @Override
    public void delete(int index) {
         data.remove(index);
    }

    @Override
    public Pelanggan getPelanggan(int index) {
        return data.get(index);
    }

    @Override
    public List<Pelanggan> getAllPelanggan() {
        return data;
    }
}