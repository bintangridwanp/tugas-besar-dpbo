import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pengguna {
    private HashMap<String, HashMap<String, String>> penggunaMap = new HashMap<>();

    private String Id_pengguna;
    private String Username;
    private String Password;
    private String Nama_depan;
    private String Nama_belakang;
    private String Email;
    private String Alamat;
    private String Tanggal_lahir;
    private boolean Verifikasi;
    private String Pengguna_aktif;

    public Pengguna(String id_pengguna, String username, String password, String nama_depan, String nama_belakang, String email, String alamat, String tanggal_lahir, boolean verifikasi, String pengguna_aktif) {
        Id_pengguna = id_pengguna;
        Username = username;
        Password = password;
        Nama_depan = nama_depan;
        Nama_belakang = nama_belakang;
        Email = email;
        Alamat = alamat;
        Tanggal_lahir = tanggal_lahir;
        Verifikasi = verifikasi;
        Pengguna_aktif = id_pengguna;
    }

    public String getId_pengguna() {
        return Id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        Id_pengguna = id_pengguna;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNama_depan() {
        return Nama_depan;
    }

    public void setNama_depan(String nama_depan) {
        Nama_depan = nama_depan;
    }

    public String getNama_belakang() {
        return Nama_belakang;
    }

    public void setNama_belakang(String nama_belakang) {
        Nama_belakang = nama_belakang;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getTanggal_lahir() {
        return Tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        Tanggal_lahir = tanggal_lahir;
    }

    public boolean isVerifikasi() {
        return Verifikasi;
    }

    public void setVerifikasi(boolean verifikasi) {
        Verifikasi = verifikasi;
    }

    public String getPengguna_aktif() {
        return Pengguna_aktif;
    }

    public void setPengguna_aktif(String pengguna_aktif) {
        Pengguna_aktif = pengguna_aktif;
    }

    public HashMap<String, HashMap<String, String>> getPenggunaMap() {
        return penggunaMap;
    }

    public void setPenggunaMap(HashMap<String, HashMap<String, String>> penggunaMap) {
        this.penggunaMap = penggunaMap;
    }

    public int otp() {
        int kodeOtp = (int) (Math.random() * 900000) + 100000;
        return kodeOtp;
    }

    public void cekOtp(String inputOtp) {
        int kodeOtp = otp();
        if (inputOtp.equals(String.valueOf(kodeOtp))) {}
    }

    public void Daftar(String Id_pengguna, String username, String password, String nama_depan, String nama_belakang, String email, String alamat, String tanggal_lahir, boolean verifikasi, String penggunaAktif) {
        Scanner scanner = new Scanner(System.in);

        // Validasi: Jika pengguna sedang login, mencegah pendaftaran
        if (penggunaAktif != null && !penggunaAktif.isEmpty()) {
            System.out.println("Logout terlebih dahulu sebelum mendaftar akun baru.");
            return;
        }

        // Masukkan ID Pengguna
        System.out.println("Masukan ID Pengguna (unik): ");
        Id_pengguna = scanner.nextLine();

        // Validasi: Pastikan ID Pengguna unik
        while (penggunaMap.containsKey(Id_pengguna)) {
            System.out.println("ID Pengguna sudah digunakan. Silakan gunakan ID Pengguna lain.");
            System.out.println("Masukan ID Pengguna (unik): ");
            Id_pengguna = scanner.nextLine();
        }

        // Masukkan data pengguna lainnya
        System.out.println("Masukan Username: ");
        username = scanner.nextLine();

        System.out.println("Masukan Password: ");
        password = scanner.nextLine();

        System.out.println("Masukan Nama Depan: ");
        nama_depan = scanner.nextLine();

        System.out.println("Masukan Nama Belakang: ");
        nama_belakang = scanner.nextLine();

        System.out.println("Masukan Email: ");
        email = scanner.nextLine();

        System.out.println("Masukan Alamat: ");
        alamat = scanner.nextLine();

        System.out.println("Masukkan Tanggal Lahir (YYYY-MM-DD): ");
        tanggal_lahir = scanner.nextLine();

        // Proses verifikasi melalui OTP
        System.out.println("\nSebelum menyelesaikan pendaftaran, Anda harus memverifikasi melalui OTP.");
        System.out.println("Apakah Anda ingin memverifikasi? (y/n): ");
        char konfirmasi = scanner.next().charAt(0);

        if (konfirmasi == 'y' || konfirmasi == 'Y') {
            // Menggenerate kode OTP dan memverifikasi
            int kodeOtp = otp(); // Memanggil dari class admin method otp
            System.out.println("OTP Anda adalah: " + kodeOtp);
            System.out.println("Masukkan OTP Anda: ");
            int inputOtp;

            try {
                inputOtp = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input OTP tidak valid. Silakan coba lagi.");
                return;
            }

            if (inputOtp == kodeOtp) {
                // Jika OTP sesuai, pendaftaran berhasil
                System.out.println("Pendaftaran berhasil! Akun Anda kini telah terdaftar.");
                System.out.println("ID Anda: " + Id_pengguna);

                // Menyimpan data pengguna ke dalam penggunaMap
                HashMap<String, String> dataPengguna = new HashMap<>();
                dataPengguna.put("username", username);
                dataPengguna.put("password", password);
                dataPengguna.put("nama_depan", nama_depan);
                dataPengguna.put("nama_belakang", nama_belakang);
                dataPengguna.put("email", email);
                dataPengguna.put("alamat", alamat);
                dataPengguna.put("tanggal_lahir", tanggal_lahir);
                penggunaMap.put(Id_pengguna, dataPengguna);
            } else {
                // Jika OTP salah
                System.out.println("OTP salah. Pendaftaran dibatalkan.");
            }
        } else {
            // Jika verifikasi dibatalkan oleh pengguna
            System.out.println("Anda telah membatalkan pendaftaran.");
        }
    }

    public boolean Masuk(String inputId, String inputPassword, String penggunaAktif) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Halaman Login ===");
        System.out.print("Masukkan Username atau Email: ");
        inputId = scanner.nextLine();

        System.out.print("Masukkan Password: ");
        inputPassword = scanner.nextLine();

        for (Map.Entry<String, HashMap<String, String>> entry : penggunaMap.entrySet()) {
            String idPengguna = entry.getKey();
            HashMap<String, String> dataPengguna = entry.getValue();

            if ((dataPengguna.get("username").equals(inputId) || dataPengguna.get("email").equals(inputId))
                    && dataPengguna.get("password").equals(inputPassword)) {
                penggunaAktif = idPengguna;

                System.out.println("Login berhasil! Selamat datang, " + dataPengguna.get("nama_depan"));
                return true;
            }
        }
        System.out.println("Login gagal! Username/Email atau Password salah.");
        return false;
    }

    public void EditProfile(String Id_pengguna, String username, String password, String nama_depan, String nama_belakang, String email, String alamat, String tanggal_lahir, boolean verifikasi, String penggunaAktif) {
        if (penggunaAktif == null) {
            System.out.println("Anda belum login. Silakan login terlebih dahulu untuk mengedit profil Anda.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> dataPengguna = penggunaMap.get(penggunaAktif);

        System.out.println("Apakah Anda ingin mengedit semua data atau sebagian data?");
        System.out.print("[1] Semua Data, [2] Sebagian Data: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Buang newline

        if (pilihan == 1) {
            System.out.print("Masukkan username baru: ");
            username = scanner.nextLine();
            System.out.print("Masukkan password baru: ");
            password = scanner.nextLine();
            System.out.print("Masukkan nama depan baru: ");
            nama_depan = scanner.nextLine();
            System.out.print("Masukkan nama belakang baru: ");
            nama_belakang = scanner.nextLine();
            System.out.print("Masukkan email baru: ");
            email = scanner.nextLine();
            System.out.print("Masukkan alamat baru: ");
            alamat = scanner.nextLine();
            System.out.print("Masukkan tanggal lahir baru (YYYY-MM-DD): ");
            tanggal_lahir = scanner.nextLine();

            dataPengguna.put("username", username);
            dataPengguna.put("password", password);
            dataPengguna.put("nama_depan", nama_depan);
            dataPengguna.put("nama_belakang", nama_belakang);
            dataPengguna.put("email", email);
            dataPengguna.put("alamat", alamat);
            dataPengguna.put("tanggal_lahir", tanggal_lahir);

            System.out.println("Profil Anda telah berhasil diperbarui!");
        } else if (pilihan == 2) {
            System.out.println("Pilih data yang ingin Anda edit:");
            System.out.println("[1] Username");
            System.out.println("[2] Password");
            System.out.println("[3] Nama Depan");
            System.out.println("[4] Nama Belakang");
            System.out.println("[5] Email");
            System.out.println("[6] Alamat");
            System.out.println("[7] Tanggal Lahir");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihanEdit = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanEdit) {
                case 1:
                    System.out.print("Masukkan username baru: ");
                    String usernameBaru = scanner.nextLine();
                    dataPengguna.put("username", usernameBaru);
                    System.out.println("Username berhasil diperbarui.");
                    break;
                case 2:
                    System.out.print("Masukkan password baru: ");
                    String passwordBaru = scanner.nextLine();
                    dataPengguna.put("password", passwordBaru);
                    System.out.println("Password berhasil diperbarui.");
                    break;
                case 3:
                    System.out.print("Masukkan nama depan baru: ");
                    String namaDepanBaru = scanner.nextLine();
                    dataPengguna.put("nama_depan", namaDepanBaru);
                    System.out.println("Nama depan berhasil diperbarui.");
                    break;
                case 4:
                    System.out.print("Masukkan nama belakang baru: ");
                    String namaBelakangBaru = scanner.nextLine();
                    dataPengguna.put("nama_belakang", namaBelakangBaru);
                    System.out.println("Nama belakang berhasil diperbarui.");
                    break;
                case 5:
                    System.out.print("Masukkan email baru: ");
                    String emailBaru = scanner.nextLine();
                    dataPengguna.put("email", emailBaru);
                    System.out.println("Email berhasil diperbarui.");
                    break;
                case 6:
                    System.out.print("Masukkan alamat baru: ");
                    String alamatBaru = scanner.nextLine();
                    dataPengguna.put("alamat", alamatBaru);
                    System.out.println("Alamat berhasil diperbarui.");
                    break;
                case 7:
                    System.out.print("Masukkan tanggal lahir baru (YYYY-MM-DD): ");
                    String tanggalLahirBaru = scanner.nextLine();
                    dataPengguna.put("tanggal_lahir", tanggalLahirBaru);
                    System.out.println("Tanggal lahir berhasil diperbarui.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

    }

    public void Pencarian_barang(String nama_barang) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Halaman Pencarian Barang ===");
        System.out.println("Masukan nama barang yang ingin dicari: ");

        // HashMap<String, HashMap<String, String>> barangMap = this.getBarangMap(); di ambil dari data semua data barang

        String id_pengguna_aktif = this.getPengguna_aktif();

        boolean barangDitemukan = false;

        System.out.println("Hasil pencarian barang dengan nama: " + nama_barang);

        for (Map.Entry<String, HashMap<String, String>> entry : barangMap.entrySet()) {
            HashMap<String, String> barangDetails = entry.getValue();

            String namaBarang = barangDetails.get("nama");
            String idPemilik = barangDetails.get("id_pemilik");

            // Jika nama barang mengandung string yang dicari dan bukan barang milik pengguna aktif
            if (namaBarang != null && idPemilik != null
                    && namaBarang.toLowerCase().contains(nama_barang.toLowerCase())
                    && !idPemilik.equals(id_pengguna_aktif)) {

                System.out.println("ID Barang: " + entry.getKey() + ", Nama: " + namaBarang +
                        ", Harga: " + barangDetails.get("harga") +
                        ", Deskripsi: " + barangDetails.get("deskripsi"));
                barangDitemukan = true;
            }
        }

        if (!barangDitemukan) {
            System.out.println("Tidak ditemukan barang dengan nama: " + nama_barang + " milik pengguna lain.");
        }
    }

    public void Keluar(String penggunaAktif) {
        if (penggunaAktif == null || penggunaAktif.isEmpty()) {
            System.out.println("Tidak ada pengguna yang sedang login.");
            return;
        }
        System.out.println("Pengguna " + penggunaAktif + " telah logout.");
        setPengguna_aktif(null);
    }
}


