/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satria_26122022.controller;
import satria_26122022.model.PengembalianDaoImpl;
import satria_26122022.model.PengembalianDao;
import satria_26122022.model.Pengembalian;
import satria_26122022.model.*;
import satria_26122022.view.FormPengembalian;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author satri
 */
public class PengembalianController {
    private FormPengembalian formPengembalian;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    private PeminjamanDao peminjamanDao;
    private Pengembalian pengembalian;
    private PengembalianDao pengembalianDao;
    
    public PengembalianController(FormPengembalian formPengembalian){
        this.formPengembalian=formPengembalian;
        anggotaDao= new AnggotaDaoImpl();
        bukuDao= new BukuDaoImpl();
        peminjamanDao=new PeminjamanDaoImpl();
        pengembalianDao=new PengembalianDaoImpl();
    }
    
    public void bersihForm(){
        formPengembalian.getTxtTanggalPengembalian().setText("");
    }
    
    public void setCboNobp(){
        formPengembalian.getCboNobp().removeAllItems();
        List<Anggota> list= anggotaDao.getAll();
        for(Anggota anggota : list){
            formPengembalian.getCboNobp().
                    addItem(anggota.getNobp()+"-"+anggota.getNama());
        } 
    }
    
    public void setCboKodeBuku(){
        formPengembalian.getCboKodeBuku().removeAllItems();
        List<Buku> list= bukuDao.getAll();
        for(Buku buku : list){
            formPengembalian.getCboKodeBuku().
                    addItem(buku.getKodebuku());
        } 
    }
    
    public void setCboKembali(){
        formPengembalian.getCboTanggalKembali().removeAllItems();
        List<Peminjaman> list= peminjamanDao.getAllPeminjaman();
        for(Peminjaman peminjaman : list){
            formPengembalian.getCboTanggalKembali().
                    addItem(peminjaman.getTglkembali());
        } 
    }
    
    public void save(){
        pengembalian=new Pengembalian();
        pengembalian.setNobp(formPengembalian.getCboNobp()
                .getSelectedItem().toString().split("-")[0]);
        pengembalian.setKode(formPengembalian.getCboKodeBuku()
                .getSelectedItem().toString());
        pengembalian.setTglkembali(formPengembalian.getCboTanggalKembali()
                .getSelectedItem().toString());
        pengembalian.setTglpengembalian(formPengembalian.getTxtTanggalPengembalian().getText());
        pengembalianDao.save(pengembalian);
        JOptionPane.showMessageDialog(formPengembalian,"Entri Data Ok");
    }
    
    public void getPengembalian(){
        int index=formPengembalian.getTablePengembalian().getSelectedRow();
        pengembalian=pengembalianDao.getPengembalian(index);
        if(pengembalian!=null){
            List<Anggota> listAnggota=anggotaDao.getAll();
            for(Anggota anggota:listAnggota){
                if(pengembalian.getNobp()==anggota.getNobp()){
                    formPengembalian.getCboNobp()
                    .setSelectedItem(anggota.getNobp()+"-"+anggota.getNama());
                    break;
                }
            }
            formPengembalian.getCboKodeBuku().setSelectedItem(pengembalian.getKode());
            formPengembalian.getCboTanggalKembali().setSelectedItem(pengembalian.getTglkembali());
            formPengembalian.getTxtTanggalPengembalian().setText(pengembalian.getTglpengembalian());
            pengembalian.getDenda();
        }
    }
    
    public void update(){
        int index=formPengembalian.getTablePengembalian().getSelectedRow();
        pengembalian=pengembalianDao.getPengembalian(index);
        pengembalian.setNobp(formPengembalian.getCboNobp()
                .getSelectedItem().toString().split("-")[0]);
        pengembalian.setKode(formPengembalian.getCboKodeBuku()
                .getSelectedItem().toString());
        pengembalian.setTglkembali(formPengembalian.getCboTanggalKembali()
                .getSelectedItem().toString());
        pengembalian.setTglpengembalian(formPengembalian.getTxtTanggalPengembalian().getText());
        pengembalianDao.update(index,pengembalian);
        JOptionPane.showMessageDialog(formPengembalian,"Update Data Ok");
    }
    
    public void delete(){
        int index=formPengembalian.getTablePengembalian().getSelectedRow();
        pengembalianDao.delete(index);
        JOptionPane.showMessageDialog(formPengembalian,"Delete Data Ok");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel=
                (DefaultTableModel) formPengembalian.getTablePengembalian().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Pengembalian>listPengembalian=pengembalianDao.getAllPengembalian();
        for(Pengembalian pengembalian : listPengembalian){
            Object[] data={
                pengembalian.getNobp(),
                pengembalian.getKode(),
                pengembalian.getTglkembali(),
                pengembalian.getTglpengembalian(),
                pengembalian.getDenda()
            };
            tabelModel.addRow(data);
        }
    }    
}
