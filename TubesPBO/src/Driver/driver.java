/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Console.Console;
import Control.ControllerMenu;
import Model.Aplikasi;
import Model.Dokter;
import Model.Pasien;
import Model.PasienInap;
import Model.Ruangan;

/**
 *
 * @author hariyanto
 */
public class driver {

    public static void main(String[] args) {
        
        Aplikasi model = new Aplikasi();

        //Ruangan r1 = new Ruangan("Garuda","r001");
        //Ruangan r2 = new Ruangan("Elang","r002");
        //Ruangan r3 = new Ruangan("Pelikan","r003");

        //Dokter d1 = new Dokter("Dr. Niko", 00001);
        //Dokter d2 = new Dokter("Dr. Kiblat", 00002);
        //Dokter d3 = new Dokter("Dr. Ariana", 00003);

        //d1.setSpesialisasi("Umum");
        //d2.setSpesialisasi("Penyakit Dalam");
        //d3.setSpesialisasi("Penyakit Kulit");

        //Pasien p01 = new Pasien("Adrian", 0001, "Jl. Pelikan jaya No.2");
        //Pasien p11 = new Pasien("Kirana", 1001, "Jl. Garuda No.3");
        //Pasien p21 = new Pasien("Erika", 2001, "Jl. Gagak Merda No.14");

        //p01.setKeluhan("Sakit leher");
        //p01.setTanggalDatang("20-03-2016");
        //p11.setKeluhan("Jerawat Meletus letus");
        //p11.setTanggalDatang("14-03-2016");
        //p21.setKeluhan("Sakit Kepala sudah dua minggu");
        //p21.setTanggalDatang("02-03-2016");

        //PasienInap pi01 = new PasienInap(p11);
        //PasienInap pi02 = new PasienInap(p21);

       // pi01.setDokter(d3);
       // pi01.addDiagnosa("Alergi Riningitis");
       // pi02.setDokter(d1);
       // pi02.addDiagnosa("Migrain Cluster");

       // r1.tambahPasienInap(pi01);
       // r1.tambahPasienInap(pi02);

      //  Console.menu();
       new ControllerMenu(model);
    }
}
