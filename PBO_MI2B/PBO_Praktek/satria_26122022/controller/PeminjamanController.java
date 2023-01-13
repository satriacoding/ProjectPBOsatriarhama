/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satria_26122022.controller;

/**
 *
 * @author satri
 */
import satria_26122022.model.*;
import satria_26122022.view.FormPeminjaman;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import satria_26122022.view.FormPengembalian;
/**
 *
 * @author Lenovo
 */
public class PeminjamanController {
    private FormPeminjaman formPeminjaman;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    private Peminjaman peminjaman;
    private PeminjamanDao peminjamanDao;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        this.formPeminjaman=formPeminjaman;
        anggotaDao= new AnggotaDaoImpl();
        bukuDao= new BukuDaoImpl();
        peminjamanDao=new PeminjamanDaoImpl();
    }
    
    public void bersihForm(){
        formPeminjaman.getTxtTanggalPeminjaman().setText("");
        formPeminjaman.getTxtTanggalPengembalian().setText("");
    }
    
    public void setCboNobp(){
        formPeminjaman.getCboNobp().removeAllItems();
        List<Anggota> list= anggotaDao.getAll();
        for(Anggota anggota : list){
            formPeminjaman.getCboNobp().
                    addItem(anggota.getNobp()+"-"+anggota.getNama());
        } 
    }
    
    public void setCboKodeBuku(){
        formPeminjaman.getCboKodebuku().removeAllItems();
        List<Buku> list= bukuDao.getAll();
        for(Buku buku : list){
            formPeminjaman.getCboKodebuku().
                    addItem(buku.getKodebuku());
        } 
    }
    
     
    
    public void save(){
        peminjaman=new Peminjaman();
        peminjaman.setNobp(formPeminjaman.getCboNobp()
                .getSelectedItem().toString().split("-")[0]);
        peminjaman.setKode(formPeminjaman.getCboKodebuku()
                .getSelectedItem().toString());
        peminjaman.setTglpinjam(formPeminjaman.getTxtTanggalPeminjaman().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTanggalPengembalian().getText());
        peminjamanDao.save(peminjaman);
        JOptionPane.showMessageDialog(formPeminjaman,"Entri Data Ok");
    }
    
    public void getPeminjaman(){
        int index=formPeminjaman.getTablePeminjaman().getSelectedRow();
        peminjaman=peminjamanDao.getPeminjaman(index);
        if(peminjaman!=null){
            List<Anggota> listAnggota=anggotaDao.getAll();
            for(Anggota anggota:listAnggota){
                if(peminjaman.getNobp()==anggota.getNobp()){
                    formPeminjaman.getCboNobp()
                    .setSelectedItem(anggota.getNobp()+"-"+anggota.getNama());
                    break;
                }
            }
            formPeminjaman.getCboKodebuku().setSelectedItem(peminjaman.getKode());
            formPeminjaman.getTxtTanggalPeminjaman().setText(peminjaman.getTglpinjam());
            formPeminjaman.getTxtTanggalPengembalian().setText(peminjaman.getTglkembali());
        }
    }
    
    public void update(){
        int index=formPeminjaman.getTablePeminjaman().getSelectedRow();
        peminjaman=peminjamanDao.getPeminjaman(index);
        peminjaman.setNobp(formPeminjaman.getCboNobp()
                .getSelectedItem().toString().split("-")[0]);
        peminjaman.setKode(formPeminjaman.getCboKodebuku()
                .getSelectedItem().toString());
        peminjaman.setTglpinjam(formPeminjaman.getTxtTanggalPeminjaman().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTanggalPengembalian().getText());
        peminjamanDao.update(index,peminjaman);
        JOptionPane.showMessageDialog(formPeminjaman,"Update Data Ok");
    }
    
    public void delete(){
        int index=formPeminjaman.getTablePeminjaman().getSelectedRow();
        peminjamanDao.delete(index);
        JOptionPane.showMessageDialog(formPeminjaman,"Delete Data Ok");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel=
                (DefaultTableModel) formPeminjaman.getTablePeminjaman().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Peminjaman>listPeminjaman=peminjamanDao.getAllPeminjaman();
        for(Peminjaman peminjaman : listPeminjaman){
            Object[] data={
                peminjaman.getNobp(),
                peminjaman.getKode(),
                peminjaman.getTglpinjam(),
                peminjaman.getTglkembali()
            };
            tabelModel.addRow(data);
        }
    }
    
}