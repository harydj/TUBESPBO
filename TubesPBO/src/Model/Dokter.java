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
public class Dokter extends Orang {

    private String spesialisasi;

    public Dokter(String nama, long id) {
        super(nama, id);
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    @Override
    public String toString() {
        return "Dokter{" + "spesialisasi=" + spesialisasi + '}';
    }

}
