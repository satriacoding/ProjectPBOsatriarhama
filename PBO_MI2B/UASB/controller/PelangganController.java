/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UASB.controller;
import UASB.view.FormPelanggan;
import UASB.model.PelangganDao;
import UASB.model.PelangganDaoImpl;
import UASB.model.Pelanggan;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author satri
 */
public class PelangganController {
     private FormPelanggan FormPelanggan;
     private PelangganDao PelangganDao;
     private Pelanggan pelanggan;

    public PelangganController(FormPelanggan view) {
        this.FormPelanggan = view;
        PelangganDao = new PelangganDaoImpl();
        
    }
    
     public void clearForm(){
        FormPelanggan.getTxtKodePel().setText("");
        FormPelanggan.getTxtNamapelanggan().setText("");
        FormPelanggan.getTxtJenisPelanggan().setText("");
        FormPelanggan.getTxtIndex().setText("");

    }
    
    public void savePelanggan(){
        pelanggan = new Pelanggan();
        pelanggan.setKode(FormPelanggan.getTxtKodePel().getText());
        pelanggan.setNama(FormPelanggan.getTxtNamapelanggan().getText());
        pelanggan.setJenispelanggan(Integer.parseInt(FormPelanggan.getTxtJenisPelanggan().getText()));
        PelangganDao.save(pelanggan);
        javax.swing.JOptionPane.showMessageDialog(FormPelanggan, "Entri Ok");
    }
    
    public void getPelanggan(){
        int index = FormPelanggan.getTabelPelanggan().getSelectedRow();
        pelanggan = PelangganDao.getPelanggan(index);
        if(pelanggan != null){
            FormPelanggan.getTxtKodePel().setText(pelanggan.getKode());
            FormPelanggan.getTxtNamapelanggan().setText(pelanggan.getNama());
            FormPelanggan.getTxtJenisPelanggan().setText(String.valueOf(pelanggan.getJenispelanggan()));
        }
    }
    
    public void updatePelanggan(){
        int index = FormPelanggan.getTabelPelanggan().getSelectedRow();
        pelanggan.setKode(FormPelanggan.getTxtKodePel().getText());
        pelanggan.setNama(FormPelanggan.getTxtNamapelanggan().getText());
        pelanggan.setJenispelanggan(Integer.parseInt(FormPelanggan.getTxtJenisPelanggan().getText()));
        PelangganDao.update(index, pelanggan);
        javax.swing.JOptionPane.showMessageDialog(FormPelanggan, "Update Ok");
    }
    
    public void deletePelanggan(){
        int index = FormPelanggan.getTabelPelanggan().getSelectedRow();
        PelangganDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(FormPelanggan, "Delete Ok");
    }
    
    
      public void search(){
        int index = Integer.parseInt(FormPelanggan.getTxtIndex().getText());
        pelanggan = PelangganDao.getPelanggan(index);
        if(pelanggan!=null){
           FormPelanggan.getTxtKodePel().setText(pelanggan.getKode());
            FormPelanggan.getTxtNamapelanggan().setText(String.valueOf(pelanggan.getNama()));
            FormPelanggan.getTxtJenisPelanggan().setText(String.valueOf(pelanggan.getJenispelanggan()));
       
        }else{
            JOptionPane.showMessageDialog(FormPelanggan, "Data Tidak Ada");
        }
      }
    
    public void viewData(){
        DefaultTableModel tabelModel = 
               (DefaultTableModel) FormPelanggan.getTabelPelanggan().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Pelanggan> list = PelangganDao.getAllPelanggan();
        for(Pelanggan pelanggan : list){
            Object[] data = {
                pelanggan.getKode(),
                pelanggan.getNama(),
                pelanggan.getJenispelanggan()
            };
            tabelModel.addRow(data); 
        }
    }
}
