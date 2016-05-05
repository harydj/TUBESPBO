/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Arrays;

/**
 *
 * @author hariyanto
 */
public class Ruangan {

    private PasienInap[] daftarPasien;
    private int maxPasien;
    private int nPasien = 0;
    private String namaRuangan;
    private String noRuang;

    public Ruangan(String noRuang,String namaRuangan) {
        this.namaRuangan = namaRuangan;
        this.noRuang = noRuang;
        maxPasien = 4;
        daftarPasien = new PasienInap[maxPasien];
    }

    public void tambahPasienInap(PasienInap pi) {
        if (nPasien <= maxPasien) {
            this.daftarPasien[nPasien] = pi;
            nPasien++;
        } else {
            System.out.println("Ruangan Penuh");
        }
    }
    

    public PasienInap getPasienInapByIndex(int x) {
        return daftarPasien[x];
    }

    public void setNama(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public String getNama() {
        return namaRuangan;
    }

    public void setNoRuang(String noRuang) {
        this.noRuang = noRuang;
    }
    

    public String getNoRuang() {
        return noRuang;
    }
    

    public PasienInap[] getDaftarPasien() {
        return daftarPasien;
    }

    public int getnPasien() {
        return nPasien;
    }

    @Override
    public String toString() {
        return "Ruangan{" + "daftarPasien=" + Arrays.toString(daftarPasien) + ", namaRuangan=" + namaRuangan + '}';
    }

}
