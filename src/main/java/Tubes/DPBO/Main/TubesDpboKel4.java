/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Tubes.DPBO.Main;
import Tubes.DPBO.Admin;
import Tubes.DPBO.Kategori;
import Tubes.DPBO.KategoriException;
import Tubes.DPBO.Produk;
import Tubes.DPBO.Util.UtilityClass;
import java.util.Scanner;
import Tubes.DPBO.Pengguna;
import java.util.ArrayList;

public class TubesDpboKel4 {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Admin admin = new Admin();
        UtilityClass util = new UtilityClass();
        System.out.println(util.Waktu_Sekarang());
        ArrayList<Pengguna> daftarPengguna = new ArrayList<>();
        Pengguna pengguna = new Pengguna();

        // menu mau daftar pengguna baru
        daftarPengguna.add(pengguna.Daftar());
        
        String userName = util.getStringInput(myObj, "Masukkan Nama Pengguna \t-> ");
        String password = util.getStringInput(myObj, "Masukkan Kata Sandi \t-> ");
        
        System.out.println(admin.login(userName, password));
        /*
        Produk produk = new Produk("P12", "HP", 0, 0, "bandung", "type hp oppo, murah"){
        
        };
        Kategori kategori = new Kategori();

        try {
            kategori.tambahKategori("Elektronik", "Produk terkait alat elektronik");
            kategori.tambahKategori("Pakaian", "Produk untuk kebutuhan pakaian");

            kategori.tampilkanKategori();

            System.out.println("Deskripsi Pakaian: " + kategori.getDeskripsi("Pakaian"));

            kategori.perbaruiDeskripsi("Pakaian", "Produk pakaian terbaru dan terupdate");
            System.out.println("Deskripsi diperbarui: " + kategori.getDeskripsi("Pakaian"));

            kategori.hapusKategori("Elektronik");
            kategori.tampilkanKategori();

        } catch (KategoriException e) {
            System.err.println("Error: " + e.getMessage());
        } */
        
    }
}
