/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.util.Scanner;

/**
 *
 * @author hariyanto
 */
public class Console {

    
        static void menu(){
        Scanner pil = new Scanner(System.in);

        System.out.println("Pilih Menu :");
        System.out.println("1. Create Ruangan");
        System.out.println("2. Registrasi Pasien");
        System.out.println("3. Tambah Pasien Inap");
        System.out.println("4. Lihat Data");
        System.out.println("5. Keluar");
        int x = pil.nextInt();  
            switch (x) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
