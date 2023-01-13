/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UASB.controller;
import UASB.model.PelangganDao;
import UASB.model.PelangganDaoImpl;
import UASB.view.FormWarnet;
import UASB.model.WarnetDao;
import UASB.model.WarnetDaoImpl;
import UASB.model.Pelanggan;
import UASB.model.Warnet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class WarnetController {
     private PelangganDao pelangganDao;
     private FormWarnet formWarnet;
     private WarnetDao WarnetDao;
     private Warnet warnet;

    public WarnetController(FormWarnet view) {
        this.formWarnet = view;
        WarnetDao = new WarnetDaoImpl();
        pelangganDao = new PelangganDaoImpl();

    }
    
     public void clearForm(){
        formWarnet.getTxtTgl().setText("");
        formWarnet.getTxtJamMasuk().setText("");
        formWarnet.getTxtJamKeluar().setText("");
        formWarnet.getTxtjen().setText("");
        formWarnet.getTxtLama().setText("");
        formWarnet.getTxtTarif().setText("");
        formWarnet.getTxtTotal().setText("");
        formWarnet.getTxtIndex().setText("");

    }
      public void saveWarnet(){
        warnet = new Warnet();
        warnet.setKodepelanggan(formWarnet.getCboKode()
                .getSelectedItem().toString());       
        warnet.setNama(formWarnet.getCboNama()
                .getSelectedItem().toString());       
        warnet.setTglmasuk(formWarnet.getTxtTgl().getText());
        warnet.setJammasuk(formWarnet.getTxtJamMasuk().getText());
        warnet.setJamkeluar(formWarnet.getTxtJamKeluar().getText());
        warnet.setTarif(Integer.parseInt(formWarnet.getTxtTarif().getText()));
        warnet.setTotal(Integer.parseInt(formWarnet.getTxtTotal().getText()));
        warnet.setJenispelanggan(Integer.parseInt(formWarnet.getTxtjen().getText()));    
        warnet.setLama(Integer.parseInt(formWarnet.getTxtLama().getText()));
        WarnetDao.save(warnet);
        javax.swing.JOptionPane.showMessageDialog(formWarnet, "Entri Ok");
    }
      public void getWarnet(){
        int index = formWarnet.getTabelWarnet().getSelectedRow();
        warnet = WarnetDao.getWarnet(index);
        if(warnet != null){
            formWarnet.getTxtTgl().setText(warnet.getTglmasuk());
            formWarnet.getTxtJamMasuk().setText(warnet.getJamkeluar());
            formWarnet.getTxtJamKeluar().setText(warnet.getJamkeluar());
            formWarnet.getTxtTarif().setText(String.valueOf(warnet.getTarif()));
            formWarnet.getTxtjen().setText(String.valueOf(warnet.getJenispelanggan()));
            formWarnet.getTxtTotal().setText(String.valueOf(warnet.getTotal()));
            formWarnet.getTxtLama().setText(String.valueOf(warnet.getLama()));

        }
    }
    
    public void updateWarnet(){
        int index = formWarnet.getTabelWarnet().getSelectedRow();
        warnet.setKodepelanggan(formWarnet.getCboKode()
                .getSelectedItem().toString());       
        warnet.setNama(formWarnet.getCboNama()
                .getSelectedItem().toString());       
        warnet.setTglmasuk(formWarnet.getTxtTgl().getText());
        warnet.setJammasuk(formWarnet.getTxtJamMasuk().getText());
        warnet.setJamkeluar(formWarnet.getTxtJamKeluar().getText());
        warnet.setTarif(Integer.parseInt(formWarnet.getTxtTarif().getText()));
        warnet.setTotal(Integer.parseInt(formWarnet.getTxtTotal().getText()));
        warnet.setJenispelanggan(Integer.parseInt(formWarnet.getTxtjen().getText()));
        warnet.setLama(Integer.parseInt(formWarnet.getTxtLama().getText()));
        WarnetDao.update(index, warnet);
        javax.swing.JOptionPane.showMessageDialog(formWarnet, "Update Ok");
    }
    
    public void deleteWarnet(){
        int index = formWarnet.getTabelWarnet().getSelectedRow();
        WarnetDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formWarnet, "Delete Ok");
    }
    
      public void search(){
        int index = Integer.parseInt(formWarnet.getTxtIndex().getText());
        warnet = WarnetDao.getWarnet(index);
        if(warnet!=null){
            formWarnet.getCboKode().setSelectedItem(warnet.getKodepelanggan());
            formWarnet.getCboNama().setSelectedItem(warnet.getNama());
            formWarnet.getTxtTgl().setText(warnet.getTglmasuk());
            formWarnet.getTxtJamMasuk().setText(warnet.getJamkeluar());
            formWarnet.getTxtJamKeluar().setText(warnet.getJamkeluar());
            formWarnet.getTxtTarif().setText(String.valueOf(warnet.getTarif()));
            formWarnet.getTxtjen().setText(String.valueOf(warnet.getJenispelanggan()));
            formWarnet.getTxtTotal().setText(String.valueOf(warnet.getTotal()));
            formWarnet.getTxtLama().setText(String.valueOf(warnet.getLama()));
        }else{
            JOptionPane.showMessageDialog(formWarnet, "Data Tidak Ada");
        }
      }
    
      
      public void lama(){
           try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            String jammasuk = formWarnet.getTxtJamMasuk().getText();
            String jamkeluar = formWarnet.getTxtJamKeluar().getText();
            Date timemasuk = format.parse(jammasuk);
            Date timekeluar = format.parse(jamkeluar);
            if(timekeluar.getTime() <= timemasuk.getTime()){
                formWarnet.getTxtLama().setText("0");
            }else{
                long diff = timekeluar.getTime() - timemasuk.getTime();
                long diffHours = diff / (60 * 60 * 1000) % 24;
//                long diffSeconds = diff / 1000 % 60;
//                long diffMinutes = diff / (60 * 1000) % 60;
//                long diffDays = diff / (24 * 60 * 60 * 1000);
                formWarnet.getTxtLama().setText(diffHours+"");
            }
        } catch (ParseException ex) {
            Logger.getLogger(WarnetController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public void total(){
          int jenispel = Integer.parseInt((String) formWarnet.getCboKode().getSelectedItem());
          int tarif = Integer.parseInt(formWarnet.getTxtTarif().getText());
          int lama = Integer.parseInt(formWarnet.getTxtLama().getText());
          double diskon = 0;
          int hargakotor = 0;
          int total = 0;
          if(jenispel == 1){
              hargakotor = (int) (lama * tarif);
              diskon = (double) (0.02 * hargakotor);
          } else if(jenispel == 2) {
              hargakotor = (int) (lama * tarif);
              diskon = (double) (0.05 * hargakotor);
          }
          total = (int) (hargakotor - diskon);
          formWarnet.getTxtTotal().setText(String.valueOf(total));
      }
      
      public void viewTable(){
        try {
            DefaultTableModel tabelModel = (DefaultTableModel) formWarnet.getTabelWarnet().getModel();
            tabelModel.setRowCount(0);
            List<Warnet> listKembali = WarnetDao.getAllWarnet();
            for(Warnet warnet : listKembali) {
                Object[] data = {
                    warnet.getKodepelanggan(),
                    warnet.getTglmasuk(),
                    warnet.getJammasuk(),
                    warnet.getJamkeluar(),
                    warnet.getTarif(),
                    warnet.getJenispelanggan(),
                    warnet.getTotal(),
                    warnet.getNama(),
                    warnet.getLama(),
                };
               tabelModel.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(WarnetController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }  
      
       public void setCboKode(){
        formWarnet.getCboKode().removeAllItems();
        List<Pelanggan> list= pelangganDao.getAllPelanggan();
        for(Pelanggan pelanggan : list){
            formWarnet.getCboKode().
                    addItem(pelanggan.getKode());
        } 
    }
    
     public void setCboNama(){
        formWarnet.getCboNama().removeAllItems();
        List<Pelanggan> list= pelangganDao.getAllPelanggan();
        for(Pelanggan pelanggan : list){
            formWarnet.getCboNama().
                    addItem(pelanggan.getNama());
        } 
    }
     

}