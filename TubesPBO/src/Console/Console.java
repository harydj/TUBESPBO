/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.util.Scanner;

/**
 *
 * @author hariyanto
 */
public class Console {

    public static void menu() {
        Scanner pil = new Scanner(System.in);
        int x = 0;
    while(x != 5){
        System.out.println("Pilih Menu :");
        System.out.println("1. Create Ruangan");
        System.out.println("2. Registrasi Pasien");
        System.out.println("3. Tambah Pasien Inap");
        System.out.println("4. Lihat Data");
        System.out.println("5. Keluar");
        System.out.println("Pilih Menu : ");
        x = pil.nextInt();
        switch (x) {
            case 1:
                System.out.println("Under constructed");
                break;
            case 2:
                System.out.println("Under constructed");
                break;
            case 3:
                System.out.println("Under constructed");
                break;
            case 4:
                System.out.println("Under constructed");
                break;
            case 5:
                System.out.println("Terima Kasih");
                System.exit(0);
            default:
                System.out.println("pilih ulang");
                break;
        }
        }
    }
}
