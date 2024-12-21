/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;
import java.util.Random;
import java.util.Scanner;
import Tubes.DPBO.Util.UtilityClass;

/**
 *
 * @author Zuhri
 */
public class Admin {
    private final String Nama_Pengguna = "Admin123";
    private final String Kata_Sandi = "Admin123";
    
    Scanner myObj = new Scanner(System.in);
    Kategori kategori = new Kategori();
    
    public String login(String Nama_Pengguna, String Kata_Sandi) {
        if (this.Nama_Pengguna.equals(Nama_Pengguna) && this.Kata_Sandi.equals(Kata_Sandi)) {
            return "Login Berhasil";
        }
        
        return "Login Gagal, Silakan Coba Lagi";
    }
    
    public String keluar() {
        return "Anda berhasil keluar";
    }
    

    public int otp() {
        Random otp = new Random();
        return otp.nextInt(90000) + 10000; 
    }

    public void Verifikasi_otp(int otp) {
        int userInput = UtilityClass.getIntInput(myObj, "Masukkan OTP yang diterima: ");

        if (userInput == otp) {
            System.out.println("Verifikasi berhasil!");
        } else {
            System.out.println("Verifikasi gagal! OTP tidak cocok.");
        }
    }
    
    public void tambah_kategori() {
        String namaKategori = UtilityClass.getStringInput(myObj, "Masukkan Nama Kategori : ");
        try {
            kategori.tambahKategori(namaKategori);
        } catch (KategoriException e) {
            System.err.println("[Error] " + e.getMessage());
        }
        
    }
    
    public void UpdateStatusLaporan(int StatusLaporan) {
        Report_Pengguna ReportPengguna = new Report_Pengguna();
        
    }
    
    public void HalamanAdmin() {
        while (true) {
            while (true) {
                System.out.println("\nTekan enter untuk keluar!");
                String userName = UtilityClass.getStringInput(myObj, "Masukkan Nama Pengguna \t: ");
                if (userName.isEmpty()) {System.exit(0);}
                String password = UtilityClass.getStringInput(myObj, "Masukkan Kata Sandi \t: ");
                String loginResult = login(userName, password);
                if (loginResult.equals("Login Berhasil")) {
                    System.out.println(loginResult);
                    break;
                } else {
                    System.out.println(loginResult);
                }
            }

            while (true) {
                System.out.println("\n=== Halaman Admin ===");
                System.out.println("1. Tambah Kategori");
                System.out.println("2. Ganti Status Laporan");
                System.out.println("3. Keluar");

                int pilihan = UtilityClass.getIntInput(myObj, "Pilih opsi: ");

                switch (pilihan) {
                    case 1 -> tambah_kategori();
                    case 2 ->  UpdateStatusLaporan(pilihan);
                    case 3 -> System.out.println(keluar());
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }

                if (pilihan == 3) {break;}  
            }
        }
    }   
}
