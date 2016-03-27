/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import static tubespbo.Console.menu;
import java.util.Scanner;
/**
 *
 * @author hariyanto
 */
public class driver {
    public static void main(String[] args) {
        
        Ruangan r1 = new Ruangan("Garuda");
        Ruangan r2 = new Ruangan("Gagak");
        Ruangan r3 = new Ruangan("Pelikan");
        
        Dokter d1 = new Dokter("Dr. Niko",00001);
        Dokter d2 = new Dokter("Dr. Kiblat",00002);
        Dokter d3 = new Dokter("Dr. Ariana",00003);
        
        d1.setSpesialisasi("Umum");
        d2.setSpesialisasi("Penyakit Dalam");
        d3.setSpesialisasi("Penyakit Kulit");
        
        Pasien p01 = new Pasien("Adrian",0001,"Jl. Pelikan jaya No.2");
        Pasien p11 = new Pasien("Kirana",1001,"Jl. Garuda No.3");
        Pasien p21 = new Pasien("Erika",2001,"Jl. Gagak Merda No.14");
        
        p01.setKeluhan("Sakit leher");
        p01.setTanggalDatang("20-03-2016");
        p11.setKeluhan("Jerawat Meletus letus");
        p11.setTanggalDatang("14-03-2016");
        p21.setKeluhan("Sakit Kepala sudah dua minggu");
        p21.setTanggalDatang("02-03-2016");
                
        PasienInap pi01 = new PasienInap(p11);
        PasienInap pi02 = new PasienInap(p21);
        
        pi01.setDokter(d3);
        pi01.addDiagnosa("Alergi Riningitis");
        pi02.setDokter(d1);
        pi02.addDiagnosa("Migrain Cluster");
        
        r1.tambahPasienInap(pi01);
        r1.tambahPasienInap(pi02);
        
        menu();
        
        Scanner input = new Scanner(System.in);
        int pilih;
        System.out.println("System Informasi Data Pasien Inap di Rumah Sakit");
        System.out.println("Menu Aplikasi :");
        System.out.println("1. Form Registrasi Pasien");
        System.out.println("2. Daftarkan Ruangan Baru");
        System.out.println("3. Registrasi Pasien Inap");
        System.out.println("4. Data Pasien Inap");
        System.out.println("Masukkan Pilihan Anda : ");
        pilih = input.nextInt();
        switch(pilih){
            case 1 :
                System.out.println("Form Registrasi Pasien\n");
                System.out.println("Nama : " + nama);
                System.out.println("Alamat : " + alamat);
                break;
            case 2 :
                System.out.println("Daftarkan Ruangan Baru\n");
                System.out.println("Nama Ruangan : " + namaRuangan);
                System.out.println("Maksimal Pasien : " + maxPasien);
                break;
            case 3 :
                System.out.println("Registrasi Pasien Inap\n");
                System.out.println("ID Pasien : " + id);
                System.out.println("Dokter : " + nama);
                System.out.println("Diagnosa Awal : " + diagnosa);
                System.out.println("Ruangan : " + namaRuangan);
                System.out.println("Tanggal Masuk : " + tanggalDatang);
                break;
            case 4 :
                System.out.println("Data Pasien Inap\n");
                System.out.println("Nama Pasien : " + nama);
                System.out.println("Maaf to gw krg ngerti cara manggil variable nya biar bener");
        }
    }
}
