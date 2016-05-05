/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author hariyanto
 */
import Model.Aplikasi;
import Model.Dokter;
import Model.Pasien;
import Model.PasienInap;
import Model.Ruangan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Database {
    
    private String server = "jdbc:mysql://localhost:3306/pbo", dbuser ="root", dbpass ="";
    private Statement st;
    private Connection con;
    
    public void connect() {
        try {
            con = DriverManager.getConnection(server, dbuser, dbpass);
            st = con.createStatement();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public void saveDokter(Dokter d) {

        try {

            String query = "INSERT INTO `dokter`(`id`, `nama`, `spesialisasi`) VALUES ("
                    + "'" + d.getId() + "',"
                    + "'" + d.getNama() + "',"
                    + "'" + d.getSpesialisasi() + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public void saveRuangan(Ruangan r) {

        try {

            String query = "INSERT INTO `ruangan` (`noruang`, `nama`) VALUES ("
                    + "'" + r.getNoRuang()+ "',"
                    + "'" + r.getNama()+ "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
        public Dokter getDokter(String idDokter) {
        Dokter d = null;
        try {
            String query = "SELECT * FROM `dokter` WHERE `id` = '"+idDokter+"'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                d = new Dokter(rs.getString(1), rs.getString(2));
                d.setSpesialisasi(rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;
    }
        
        public ArrayList getTabelDokter(){
            ArrayList<Dokter> listDokter = new ArrayList<>();
            Dokter d = null;
            int x = 0;
        try {
            String query = "SELECT * FROM `dokter`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                d = new Dokter(rs.getString(2), rs.getString(1));
                d.setSpesialisasi(rs.getString(3));
                listDokter.add(d);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listDokter;
        }
        
        public void deleteDokter(String id){
            int hasil =0;
            try {
            String query = "DELETE FROM `dokter` WHERE id ='"+id+"'";
            hasil = st.executeUpdate(query);
                }catch(SQLException e){
                  JOptionPane.showMessageDialog(null, "tidak bisa hapus data "+e.getMessage());
                }
                  if(hasil==1){
                      JOptionPane.showMessageDialog(null,"berhasil hapus data");
                  }else{
                      JOptionPane.showMessageDialog(null,"gagal hapus data");
                  }
                  
        }
        
        public void savePasien(Pasien p) {

        try {

            String query = "INSERT INTO `Pasien`(`id`, `nama`, `alamat`,`keluhan`) VALUES ("
                    + "'" + p.getId() + "',"
                    + "'" + p.getNama() + "',"
                    + "'" + p.getAlamat() + "',"
                    + "'" + p.getKeluhan() + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
        public Pasien getPasien(String idPasien) {
        Pasien p = null;
        try {
            String query = "SELECT * FROM `pasien` WHERE `id` = " + idPasien;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pasien(rs.getString(1), rs.getString(2), rs.getString(3));
                p.setKeluhan(rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
        
        public ArrayList getTabelPasien(){
            ArrayList<Pasien> listPasien = new ArrayList<>();
            Pasien p = null;
            int x = 0;
        try {
            String query = "SELECT * FROM `pasien`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pasien(rs.getString(2), rs.getString(1), rs.getString(3));
                p.setKeluhan(rs.getString(4));
                listPasien.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listPasien;
        }
        
        public void deletePasien(String id){
            int hasil =0;
            try {
            String query = "DELETE FROM `pasien` WHERE id ='"+id+"'";
            hasil = st.executeUpdate(query);
                }catch(SQLException e){
                  JOptionPane.showMessageDialog(null, "tidak bisa hapus data "+e.getMessage());
                }
                  if(hasil==1){
                      JOptionPane.showMessageDialog(null,"berhasil hapus data");
                  }else{
                      JOptionPane.showMessageDialog(null,"gagal hapus data");
                  }
                  
        }
        
        public void savePasienInap(PasienInap pi) {

        try {

            String query = "INSERT INTO `pasieninap`(`id`, `dokter`, `diagnosa`) VALUES ("
                    + "'" + pi.getIdpas()+ "',"
                    + "'" + pi.getIddok()+ "',"
                    + "'" + pi.getDiagnosa() + "')";
             st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
        public PasienInap getPasienInap(String idpas) {
        PasienInap pi = null;
        Aplikasi model = new Aplikasi();
        try {
            String query = "SELECT * FROM `pasieninap` WHERE `id` = " + idpas;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pi = new PasienInap(rs.getString(1),rs.getString(2));
                pi.addDiagnosa(rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pi;
    }
        
        public ArrayList getTabelPasienInap(){
            ArrayList<PasienInap> listPasienInap = new ArrayList<>();
            PasienInap pi = null;
            Aplikasi model = new Aplikasi();
            Pasien p;
            Dokter d;
            int x = 0;
        try {
            String query = "SELECT * FROM `pasieninap`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pi = new PasienInap(rs.getString(1),rs.getString(2));
                pi.addDiagnosa(rs.getString(3));
                listPasienInap.add(pi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listPasienInap;
        }
        
        public ArrayList getTabelRuangan(){
            ArrayList<Ruangan> listRuangan = new ArrayList<>();
            Ruangan r = null;
            Aplikasi model = new Aplikasi();
            int x = 0;
        try {
            String query = "SELECT * FROM `ruangan`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                r = new Ruangan(rs.getString(1),rs.getString(2));
                listRuangan.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listRuangan;
        }
        
        public void deletePasienInap(String id){
            int hasil =0;
            try {
            String query = "DELETE FROM `pasieninap` WHERE id ='"+id+"'";
            hasil = st.executeUpdate(query);
                }catch(SQLException e){
                  JOptionPane.showMessageDialog(null, "tidak bisa hapus data "+e.getMessage());
                }
                  if(hasil==1){
                      JOptionPane.showMessageDialog(null,"berhasil hapus data");
                  }else{
                      JOptionPane.showMessageDialog(null,"gagal hapus data");
                  }
                  
        }
        
        public void deleteRuangan(String noruang){
            int hasil =0;
            try {
            String query = "DELETE FROM `ruangan` WHERE noruang ='"+noruang
                    +"'";
            hasil = st.executeUpdate(query);
                }catch(SQLException e){
                  JOptionPane.showMessageDialog(null, "tidak bisa hapus data "+e.getMessage());
                }
                  if(hasil==1){
                      JOptionPane.showMessageDialog(null,"berhasil hapus data");
                  }else{
                      JOptionPane.showMessageDialog(null,"gagal hapus data");
                  }
                  
        }

}
