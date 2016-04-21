/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import Model.Aplikasi;
import java.util.Scanner;


/**
 *
 * @author hariyanto
 */
public class Console {
    public static void menu() {
        Aplikasi model = new Aplikasi();
        Scanner pil = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int x = 0;
        int y = 0;
    while(x != 5){
        System.out.println("Pilih Menu :");
        System.out.println("1. Data Dokter");
        System.out.println("2. Data Pasien");
        System.out.println("3. Data Pasien Inap");
        System.out.println("4. Data Ruangan");
        System.out.println("5. Keluar");
        System.out.println("Pilih Menu : ");
        x = pil.nextInt();
        switch (x) {
            case 1:
              while(y!=5){
                System.out.println("Pilih Menu :");
                System.out.println("1. Tambah Dokter");
                System.out.println("2. Lihat Data Dokter");
                System.out.println("3. Hapus Dokter");
                System.out.println("4. Cari Dokter");
                System.out.println("5. Kembali");
                System.out.println("Pilih Menu : ");
                y = pil.nextInt();
                switch (y) {
                    case 1:
                        System.out.println("Nama Dokter : ");
                        String s = input.nextLine();
                        System.out.println("Spesialisasi :");
                        String l = input.nextLine();
                        System.out.println("ID Dokter : ");
                        String i = input.nextLine();
                        
                        
                        model.createDokter(s,i,l);
                        input = new Scanner(System.in);
                        break;
                    case 2:
                        model.lihatDokter();
                        break;
                    case 3:
                        System.out.println("Masukkan ID Dokter : ");
                        String v = input.nextLine();
                        model.deleteDokter(v);
                        break;
                    case 4:
                        System.out.println("Masukkan ID Dokter yang dicari : ");
                        String w = input.nextLine();
                        model.cariDokter(w);
               }
                }
                y = 0;
                break;
              
            case 2:
              while(y!=5){
                System.out.println("Pilih Menu :");
                System.out.println("1. Tambah Pasien");
                System.out.println("2. Lihat Data Pasien");
                System.out.println("3. Hapus Data Pasien");
                System.out.println("4. Cari Data Pasien");
                System.out.println("5. Kembali");
                System.out.println("Pilih Menu : ");
                y = pil.nextInt();
                switch (y) {
                    case 1:
                        System.out.println("Nama Pasien : ");
                        String s = input.nextLine();
                        System.out.println("Alamat :");                                                                                         
                        String l = input.nextLine();
                        System.out.println("ID : ");
                        String i = input.nextLine();
                        
                        
                        model.createPasien(s,i,l);
                        input = new Scanner(System.in);
                        break;
                    case 2:
                        model.lihatPasien();
                        break;
                    case 3:
                        System.out.println("Masukkan ID Pasien : ");
                        String o = input.nextLine();
                        model.deletePasien(o);
                        input = new Scanner(System.in);
                        break;
                    case 4:
                        System.out.println("Masukkan ID Pasien yang dicari : ");
                        String w = input.nextLine();
                        model.cariPasien(w);
                        input = new Scanner(System.in);
                        break;
                        
                }
              }
                y = 0;
                break;
            case 3:
                while(y!=4){  
                System.out.println("Pilih Menu :");
                System.out.println("1. Daftar Pasien Inap");
                System.out.println("2. Lihat Data ");
                System.out.println("3. Hapus Pasien Inap");
                System.out.println("4. Kembali");
                System.out.println("Pilih Menu : ");
                y = pil.nextInt();
                switch (y) {
                    case 1:
                        System.out.println("Masukkan Diagnosa : ");
                        String u = input.nextLine();
                        System.out.println("Masukkan ID Pasien : ");
                        String o = input.nextLine();
                        System.out.println("Masukkan ID Dokter yang Memeriksa");
                        String w = input.nextLine();                      
                        model.createPasienInap(o,w,u);
                        input = new Scanner(System.in);
                        break;
                    case 2:
                        model.lihatPasienInap();
                        break;
                    case 3:
                        System.out.println("Masukkan ID Pasien : ");
                        String k = input.nextLine();
                        model.deletePasienInap(k);
                        input = new Scanner(System.in);
                        break;
                }
              }
                y = 0;
                break;
            case 4:
              while(y!=4){  
                System.out.println("Pilih Menu :");
                System.out.println("1. Tambah Ruangan");
                System.out.println("2. Tambah Pasien Inap");
                System.out.println("3. Lihat Data Ruangan");
                System.out.println("4. Kembali");
                System.out.println("Pilih Menu : ");
                y = pil.nextInt();
                switch (y) {
                    case 1:
                        System.out.println("Nama Ruangan : ");
                        String s = input.nextLine();
                        System.out.println("No Ruangan :");                                                                                         
                        String l = input.nextLine();
                        model.createRuangan(s, l);
                        input = new Scanner(System.in);
                        break;
                    case 2:
                        System.out.println("Pilih ID Ruangan : ");
                        String ir = input.nextLine();
                        System.out.println("Masukkan ID Pasien Inap : ");
                        String d = input.nextLine();
                        model.tambahPasienInap(ir, d);
                        break;
                    case 3:
                        model.lihatRuangan();                        
                        break;
                }
              }
                y = 0;
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("pilih ulang");
                break;
        }
        }
    }

}
