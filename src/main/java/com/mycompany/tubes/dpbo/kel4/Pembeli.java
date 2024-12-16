package com.mycompany.tubes.dpbo.kel4;
import java.util.ArrayList;
import java.util.Scanner;


public class Pembeli extends Pengguna {

    public Pembeli(String id_pengguna, String username, String password, String nama, String alamat) {
        super(id_pengguna, username, password, nama, alamat);
    }

    @Override
    public void Daftar(ArrayList<Pengguna> penggunaList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();

        String id_pengguna = "S" + (penggunaList.size() + 1); // Auto-generate ID


        System.out.println("Pendaftaran berhasil! ID Anda: " + id_pengguna);
    }

    public boolean Masuk(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }
    
}
