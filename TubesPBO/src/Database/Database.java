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
import Model.Dokter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
        public Dokter getDokter(String idDokter) {
        Dokter d = null;
        try {
            String query = "SELECT * FROM `dokter` WHERE `id` = " + idDokter;
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

}
