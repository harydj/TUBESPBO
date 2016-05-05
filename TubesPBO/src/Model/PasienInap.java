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
public class PasienInap {

    private String idpas;
    private String iddok;
    private Dokter dokter;
    private String diagnosa;
    private int ndiagnosa = 0;

    public PasienInap(String idpas, String iddok) {
        this.idpas = idpas;
        this.iddok = iddok;
    }

    public String getIdpas() {
        return idpas;
    }

    public String getIddok() {
        return iddok;
    }



    public void setDokter(Dokter d) {
        dokter = d;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void addDiagnosa(String d) {
        this.diagnosa = d;

    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void deleteDiagnosa(String d) {
        d = null;
    }

    @Override
    public String toString() {
        return "PasienInap{" + "idpas=" + idpas + ", iddok=" + iddok + ", dokter=" + dokter + ", diagnosa=" + diagnosa + ", ndiagnosa=" + ndiagnosa + '}';
    }


    

}
