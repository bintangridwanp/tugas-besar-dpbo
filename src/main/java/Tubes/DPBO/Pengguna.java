package Tubes.DPBO;

import java.util.ArrayList;
import java.util.Scanner;

public class Pengguna {
    private String Id_pengguna;
    private String Username;
    private String Password;
    private String Nama_depan;
    private String Nama_belakang;
    private String Email;
    private String Alamat;
    private String Tanggal_lahir;
    private boolean isVerifikasi;

    public Pengguna(String Id_pengguna, String Username, String Password, String Nama_depan, String Nama_belakang, String Email, String Alamat, String Tanggal_lahir, boolean isVerifikasi) {
        this.Id_pengguna = Id_pengguna;
        this.Username = Username;
        this.Password = Password;
        this.Nama_depan = Nama_depan;
        this.Nama_belakang = Nama_belakang;
        this.Alamat = Alamat;
        this.Email = Email;
        this.Tanggal_lahir = Tanggal_lahir;
        this.isVerifikasi = isVerifikasi;
    }

    public String getId_pengguna() {
        return Id_pengguna;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getNama_depan() {
        return Nama_depan;
    }

    public String getNama_belakang() {
        return Nama_belakang;
    }

    public String getEmail(){
        return Email;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getTanggal_lahir() {
        return Tanggal_lahir;
    }

    public boolean isIsVerifikasi() {
        return isVerifikasi;
    }

    public void setId_pengguna(String Id_pengguna) {
        this.Id_pengguna = Id_pengguna;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setNama_depan(String Nama_depan) {
        this.Nama_depan = Nama_depan;
    }

    public void setNama_belakang(String Nama_belakang) {
        this.Nama_belakang = Nama_belakang;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public void setTanggal_lahir(String Tanggal_lahir) {
        this.Tanggal_lahir = Tanggal_lahir;
    }

    public void setIsVerifikasi(boolean isVerifikasi) {
        this.isVerifikasi = isVerifikasi;
    }

    ArrayList<Pengguna> penggunaList = new ArrayList<>(); // ArrayList untuk menyimpan data pengguna
    public void Daftar (ArrayList<Pengguna> PenggunaList){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Form Pendaftaran Pengguna ===");

            System.out.print("Masukkan Username      : ");
            String username = scanner.nextLine();

            System.out.print("Masukkan Password      : ");
            String password = scanner.nextLine();

            System.out.print("Masukkan Nama Depan    : ");
            String namaDepan = scanner.nextLine();

            System.out.print("Masukkan Nama Akhir    : ");
            String namaAkhir = scanner.nextLine();

            System.out.print("Masukkan Alamat        : ");
            String alamat = scanner.nextLine();

            System.out.print("Masukkan Tanggal Lahir (dd/mm/yyyy): ");
            String tanggalLahir = scanner.nextLine();

            System.out.print("Masukkan Email         : ");
            String email = scanner.nextLine();

            // Generate ID unik untuk pengguna baru
            String id_pengguna = "U" + (penggunaList.size() + 1);

            // Membuat objek Pengguna dan menambahkannya ke dalam ArrayList
            Pengguna penggunaBaru = new Pengguna(Id_pengguna, Username, Password, Nama_depan, Nama_belakang, Alamat, Email,  Tanggal_lahir );
            penggunaList.add(penggunaBaru);

            System.out.println("Pendaftaran berhasil! ID Anda: " + id_pengguna);
            System.out.println("-----------------------------------------");
            

    };

    public boolean Masuk(String username, String password) {
        // Membandingkan data untuk masuk
        return this.Username.equals(username) && this.Password.equals(password);
    }

    public void Keluar(String Id_pengguna){
        Scanner scanner = new Scanner(System.in);
        String pilihan;

        System.out.println("\\nApakah Anda yakin ingin keluar dari akun? (y/n): ");

        pilihan = scanner.nextLine();
        if (pilihan.equalsIgnoreCase("y")) {
            System.out.println("Anda telah berhasil keluar dari akun.");
            System.exit(0); // Keluar dari program
        } else if (pilihan.equalsIgnoreCase("n")) {
            System.out.println("Anda tetap berada di akun.");
        } else {
            System.out.println("Pilihan tidak valid. Kembali ke menu utama.");
        }   
    };

    public void Pencarian_barang(String nama_barang){
        boolean ditemukan = false;
        for (String produk : daftarProduk) {
            if (produk.toLowerCase().contains(nama_barang.toLowerCase())) { 
                System.out.println("Barang ditemukan: " + produk);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    };

    public void Verifikasi(String Id_pengguna, String inputKode){
        // verifikasi menggunakan email dan code otp
        String kodeOTP = "123456"; // kode otp di kirim dari class admin
        if (this.Email.equals(email)) { // Pastikan variabel instance Email ada
            System.out.println("Kode OTP telah dikirim ke: " + email);
            System.out.println("Masukkan Kode OTP: ");
            if (inputKode.equals(kodeOTP)) {
                this.isVerifikasi = true;
                System.out.println("Verifikasi berhasil! Akun Anda sekarang terverifikasi.");
                return true;
            } else {
                System.out.println("Kode OTP salah. Verifikasi gagal.");
                return false;
            }
        }
        System.out.println("Email tidak ditemukan dalam sistem.");
        return false;
    };

    public void Edit_profile(ArrayList<Pengguna> penggunaList1, String Id_pengguna){
         // Cari pengguna berdasarkan ID
        Pengguna target = null;
        for (Pengguna p : penggunaList) {
            if (p.getIdPengguna().equals(id_pengguna)) {
                target = p;
                break;
            }
        }

        if (target == null) {
            System.out.println("ID Pengguna tidak ditemukan.");
            return;
        }

        // Menampilkan data lama
        System.out.println("\nData Lama:");
        target.tampilkanData();

        System.out.println("Pilih data yang ingin diubah:");
        System.out.println("1. Username");
        System.out.println("2. Nama Depan");
        System.out.println("3. Nama Akhir");
        System.out.println("4. Alamat");
        System.out.println("5. Tanggal Lahir");
        System.out.println("6. Email");
        System.out.println("7. Semua Data");
        System.out.print("Masukkan pilihan Anda: ");
        int pilihan = Integer.parseInt(scanner.nextLine());

        // Edit data sesuai pilihan
        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Username baru: ");
                target.setUsername(scanner.nextLine());
                break;
            case 2:
                System.out.print("Masukkan Nama Depan baru: ");
                target.setNamaDepan(scanner.nextLine());
                break;
            case 3:
                System.out.print("Masukkan Nama Akhir baru: ");
                target.setNamaAkhir(scanner.nextLine());
                break;
            case 4:
                System.out.print("Masukkan Alamat baru: ");
                target.setAlamat(scanner.nextLine());
                break;
            case 5:
                System.out.print("Masukkan Tanggal Lahir baru: ");
                target.setTanggalLahir(scanner.nextLine());
                break;
            case 6:
                System.out.print("Masukkan Email baru: ");
                target.setEmail(scanner.nextLine());
                break;
            case 7:
                System.out.print("Masukkan Username baru: ");
                target.setUsername(scanner.nextLine());
                System.out.print("Masukkan Nama Depan baru: ");
                target.setNamaDepan(scanner.nextLine());
                System.out.print("Masukkan Nama Akhir baru: ");
                target.setNamaAkhir(scanner.nextLine());
                System.out.print("Masukkan Alamat baru: ");
                target.setAlamat(scanner.nextLine());
                System.out.print("Masukkan Tanggal Lahir baru: ");
                target.setTanggalLahir(scanner.nextLine());
                System.out.print("Masukkan Email baru: ");
                target.setEmail(scanner.nextLine());
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        System.out.println("\nData Berhasil Diperbarui!");
        target.tampilkanData();
    }
}