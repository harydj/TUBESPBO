/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hariyanto
 */
import Database.Database;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Aplikasi {
   private ArrayList<Pasien> daftarPasien;
   private ArrayList<Dokter> daftarDokter;
   private ArrayList<PasienInap> daftarPasienInap;
   private ArrayList<Ruangan> daftarRuangan;
   private Database con;
    
   
    public Aplikasi() {
        this.daftarPasien = new ArrayList<>();
        this.daftarDokter = new ArrayList<>();
        this.daftarPasienInap = new ArrayList<>();
        this.daftarRuangan = new ArrayList<>();
        this.con = new Database();
        con.connect();
    }
    
    public void createPasien(String nama,String id, String alamat,String keluhan) {
        Pasien p = new Pasien(nama,id,alamat);
        p.setKeluhan(keluhan);
        daftarPasien.add(p);
        con.savePasien(p);
    }
    
    public Pasien getPasien(String idP) {
        for (Pasien p : daftarPasien) {
            if (p.getId().length() == idP.length()) {
                return p;
            }
        }
        return null;        
        //Pasien p = con.getPasien(idP);
        //daftarPasien.add(p);
        //return p;
    }
    
    public void lihatPasien(){
        System.out.println("Data Pasien :");
        
        for (Pasien p : daftarPasien) {
            System.out.println("==============================");
            System.out.println("ID           : "+p.getId());
            System.out.println("Nama         : "+p.getNama());
            System.out.println("Alamat       : "+p.getAlamat());
            System.out.println("==============================");
            System.out.println("\n");
        }
    }
    
    public void deletePasien(String idp){
        int x =0;
        for(Pasien p : daftarPasien){
            if(p.getId().length() == idp.length()){
                break;
            }
            x++;
        }
            daftarPasien.remove(x);
            
    }
    
    public void deleteDataPasien(int index, String idPas){
        daftarPasien.remove(index);
        con.deletePasien(idPas);
    }
    
    public ArrayList<Pasien> getALLPasien(){ 
         daftarPasien = con.getTabelPasien();
         return daftarPasien; 
    }
    
    public void cariPasien(String idp){
        for(Pasien p : daftarPasien){
            if(p.getId().length() == idp.length()){
                System.out.println("Data Ditemukan :");
                System.out.println("==============================");
                System.out.println("ID           : "+p.getId());
                System.out.println("Nama         : "+p.getNama());
                System.out.println("Alamat       : "+p.getAlamat());
                System.out.println("==============================");
            }
        }
    }
    
    public void createDokter(String nama,String id,String spesialisasi) {
        Dokter d = new Dokter(nama,id);
        d.setSpesialisasi(spesialisasi);
        daftarDokter.add(d);
        con.saveDokter(d);      
    }
    
    public Dokter getDokter(String idP) {
        for (Dokter d : daftarDokter) {
            if (d.getId().length() == idP.length()) {
                return d;
            }
        }
        return null;
        //Dokter d = con.getDokter(idP);
        //daftarDokter.add(d);
        //return d;
    }
    
    
    public void lihatDokter(){
        System.out.println("Data Dokter :");
        
        for (Dokter d : daftarDokter) {
            System.out.println("==============================");
            System.out.println("ID           : "+d.getId());
            System.out.println("Nama         : "+d.getNama());
            System.out.println("Spesialisasi : "+d.getSpesialisasi());
            System.out.println("==============================");
            System.out.println("\n");
        }
    }
    
     public ArrayList<Dokter> getALLDokter(){ 
         daftarDokter = con.getTabelDokter();
         return daftarDokter; 
    }
    
    public void deleteDokter(String idp){
        int x =0;
        for(Dokter d : daftarDokter){
            if(d.getId().length() == idp.length()){
                break;
            }
            x++;
        }
            daftarDokter.remove(x);
            
    }
    
    public void deleteDataDokter(int index, String idDok){
        daftarDokter.remove(index);
        con.deleteDokter(idDok);
    }
    
    public void cariDokter(String idp){
        for(Dokter d : daftarDokter){
            if(d.getId().length() == idp.length()){
                System.out.println("Data Ditemukan :");
                System.out.println("==============================");
                System.out.println("ID           : "+d.getId());
                System.out.println("Nama         : "+d.getNama());
                System.out.println("Spesialisasi : "+d.getSpesialisasi());
                System.out.println("==============================");
            }
        }
    }
    
    public void createRuangan(String noRuang, String namaRuangan){
        Ruangan r = new Ruangan(noRuang,namaRuangan);
        daftarRuangan.add(r);
        con.saveRuangan(r);
    }
    
    public Ruangan getRuangan(String noRuang){
        for (Ruangan r : daftarRuangan){
            if(r.getNoRuang().length() == noRuang.length()){
                return r;    
            }
            
        }
                return null;
    }
    
     public void lihatRuangan(){
         try{
        System.out.println("Data Ruangan : ");    
        int xi = 0;
        int yi = 1;
        for (Ruangan r : daftarRuangan) {
            System.out.println("==============================");
            System.out.println("No Ruang                : "+r.getNoRuang());
            System.out.println("Nama Ruang              : "+r.getNama());
            while(xi < r.getnPasien()){
            System.out.println("Pasien Inap "+yi+"            ");
            System.out.println("ID                      : "+r.getPasienInapByIndex(xi).getIdpas());
            xi++;
            yi++;
            }
            System.out.println("==============================");
            System.out.println("\n");
        }
         }
           catch(NullPointerException e){
               System.out.println(e.getMessage());
            }
    }
    
    public void updatePiRuangan(PasienInap pi){
        int x = 0;
        for (Ruangan r : daftarRuangan){
            if(r.getPasienInapByIndex(x) == pi){
                r.tambahPasienInap(pi);
            }
            x++;
        }
    }
    
    public void tambahPasienInap(String noRuang,String idpas){
        try{
            PasienInap pi = getPasienInap(idpas);
            Ruangan r = getRuangan(noRuang);
            r.tambahPasienInap(pi);     
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Pasien atau Dokter tidak terdaftar");
        }
    }
    
    public void createPasienInap(String idpas,String iddok,String diagnosa){
        PasienInap pi = new PasienInap(idpas,iddok);
        pi.addDiagnosa(diagnosa);
        daftarPasienInap.add(pi);
        con.savePasienInap(pi);

        
    }
    
     public PasienInap getPasienInap(String idP) {
        for (PasienInap pi : daftarPasienInap) {
            if (pi.getIdpas().length() == idP.length()) {
                return pi;
            }
        }
        return null;        
        //Pasien p = con.getPasien(idP);
        //daftarPasien.add(p);
        //return p;
    }
     
      public ArrayList<PasienInap> getALLPasienInap(){ 
         daftarPasienInap = con.getTabelPasienInap();
         return daftarPasienInap; 
    }
      
      public ArrayList<Ruangan> getALLRuangan(){ 
         daftarRuangan = con.getTabelRuangan();
         return daftarRuangan; 
    }
         
      public void deleteDataPasienInap(int index, String idPas){
        daftarPasienInap.remove(index);
        con.deletePasienInap(idPas);
    }
      
        public void deleteDataRuangan(int index, String noRuang){
        daftarRuangan.remove(index);
        con.deleteRuangan(noRuang);
    }
    
     public void lihatPasienInap(){
        System.out.println("Data Pasien Inap : ");      
        for (PasienInap py : daftarPasienInap) {
            System.out.println("==============================");
            System.out.println("ID Pasien               : "+py.getIdpas());
            System.out.println("Dokter Pemeriksa        : "+py.getIddok());
            System.out.println("Diagnosa                : "+py.getDiagnosa());
            System.out.println("==============================");
            System.out.println("\n");
        }
    }
     
     public void deletePasienInap(String idp){
        int x =0;
        for(PasienInap pi : daftarPasienInap){
            if(pi.getIdpas().length() == idp.length()){
                break;
            }
            x++;
        }
            daftarPasienInap.remove(x);
            
    } 
            
    
}
