/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Fiqry
 */
public class Pasien extends Orang {

    private String tanggalDatang;
    private String keluhan;

    public Pasien(String nama, String id, String alamat) {
        super(nama, id, alamat);
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getKeluhan() {
        return keluhan;
    }
    
    @Override
    public void setNama(String nama) {
        super.setNama(nama);
    }

    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setAlamat(String alamat){
        super.setAlamat(alamat);
    }
    @Override
    public String getAlamat() {
        return super.getAlamat();
    }

    @Override
    public String toString() {
        return "Pasien{" + "tanggalDatang=" + tanggalDatang + ", keluhan=" + keluhan + '}';
    }

}
