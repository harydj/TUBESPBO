/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author x-user
 */
public abstract class Orang {

    private String nama, alamat;
    private String id;

    public Orang(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public Orang(String nama, String id, String alamat) {
        this.nama = nama;
        this.id = id;
        this.alamat = alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    @Override
    public String toString() {
        return "Orang{" + "nama=" + nama + ", alamat=" + alamat + ", id=" + id + '}';
    }

}
