package tubes.main;

import akun.ManajerAkun;
import java.util.HashMap;
import pengguna.PembeliPenjual;
import pengguna.Pengguna;
import utils.Utils;

public class AkunManagement {
    private ManajerAkun manajerAkun = new ManajerAkun();
    private PembeliPenjual penggunaAktif = null;

    public void handleRegistrasi() {
        System.out.println("=====================Registrsi=====================");
        System.out.print("Masukkan username: ");
        String username = Utils.inputString();
        System.out.print("Masukkan password: ");
        String password = Utils.inputString();
        System.out.print("Masukkan email: ");
        String email = Utils.inputString();
        System.out.print("Masukkan nomor telepon: ");
        String noTelepon = Utils.inputString();
        
        // Registrasi pengguna
        try {
            manajerAkun.register(username, password, email, noTelepon);
            System.out.println("Registrasi berhasil!");
            System.out.println("==================================================");
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
            System.out.println("==================================================");
        }
    }

    public void handleLogin() {
        if (penggunaAktif != null) {
            System.out.println("|==================================================|");
            System.out.println("|Anda sudah login sebagai: " + penggunaAktif.getUsername() + "|");
            System.out.println("|================================================== |");
            return; // Jika sudah login, jangan login lagi
        }

        System.out.println("======================Login======================");
        System.out.print("Masukkan username: ");
        String username = Utils.inputString();
        System.out.print("Masukkan password: ");
        String password = Utils.inputString();
        
        // Login pengguna
        try {
            penggunaAktif = (PembeliPenjual) manajerAkun.login(username, password);
            System.out.println("\n");
            System.out.println("==================================================");
            System.out.println("Login berhasil! Selamat datang, " + penggunaAktif.getUsername() + "|");
            System.out.println("==================================================");
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
            System.out.println("==================================================");
        }
    }

    public void handleLogout() {
        if (penggunaAktif != null) {
            System.out.println("Anda telah logout.");
            System.out.println("==================================================");
            penggunaAktif = null;
        } else {
            System.out.println("Tidak ada akun yang sedang login.");
            System.out.println("==================================================");
        }
    }
    
    public void daftarPengguna() {
        HashMap<String, Pengguna> daftarPengguna = manajerAkun.getDaftarPengguna();
        if(daftarPengguna == null || daftarPengguna.isEmpty()) {
            System.out.println("Tidak ada akun pengguna yang terdaftar saat ini.");
            System.out.println("==================================================");
        } else {
            System.out.println("[System] Daftar akun pengguna : ");
            System.out.printf("%-3s %-14s %-14s\n", "No.", "Nama Pengguna", "Email");
            System.out.println("==================================================");
            int nomor = 1;
            for (Pengguna pengguna : daftarPengguna.values()) {
                System.out.printf("%-3s %-14s %-14s\n", nomor++, pengguna.getUsername(), pengguna.getEmail());
            }
            System.out.println(" ");
        }
    }
    
    // Getter untuk pengguna aktif
    public PembeliPenjual getPenggunaAktif() {
        return penggunaAktif;
    }
}
