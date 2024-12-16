package com.mycompany.tubes.dpbo.kel4;
import java.util.ArrayList;
import java.util.Scanner;


public class Pembeli extends Pengguna {
    
    // data tes
    private String idPembeli;
    private String nama;
    private ArrayList<String> keranjang = new ArrayList<>();
    private ArrayList<String> daftarProduk = new ArrayList<>();
    private ArrayList<String> barangDiterima = new ArrayList<>();
    private ArrayList<String> reviewBarang = new ArrayList<>();


    public Pembeli(String id_pengguna, String username, String password, String nama, String alamat) {
        this.idPembeli = idPembeli;
        this.nama = nama;
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
    
    
    
    // function dan procedure pembeli
    public void Beli_barang(String Id_produk, int jumlah){
        
    }
    
    public void Pembayaran(String Id_pesanan, String metode){
        Scanner scanner = new Scanner(System.in);
        String[] metodePembayaran = {"BNI", "Mandiri", "BCA", "BRI", "CIMB Niaga", "OVO", "Shopee Pay", "Dana", "SeaBank"};

        System.out.println("Pilih Metode Pembayaran:");
        for (int i = 0; i < metodePembayaran.length; i++) {
            System.out.println((i + 1) + ". " + metodePembayaran[i]);
        }

        int pilihan = scanner.nextInt();
        if (pilihan > 0 && pilihan <= metodePembayaran.length) {
            System.out.println("Anda memilih metode pembayaran: " + metodePembayaran[pilihan - 1]);
            System.out.print("Apakah Anda yakin ingin membayar? (y/n): ");
            char konfirmasi = scanner.next().charAt(0);
            if (konfirmasi == 'y' || konfirmasi == 'Y') {
                //Random random = new Random();
                int kodePembayaran = 1000000000 + random.nextInt(900000000);
                System.out.println("Pembayaran berhasil! Kode pembayaran Anda: " + kodePembayaran);
            } else {
                System.out.println("Pembayaran dibatalkan. Kembali ke menu pembayaran.");
                //pembayaran();
            }
        } else {
            System.out.println("Pilihan tidak valid. Coba lagi.");
            //pembayaran();
        }
    }
    
    public void Review_barang(String Id_pesanan, int rating, String deskripsi){
        Scanner scanner = new Scanner(System.in);
        if (barangDiterima.isEmpty()) {
            System.out.println("Belum ada barang yang diterima untuk direview.");
        } else {
            System.out.println("Daftar Barang yang Diterima:");
            for (int i = 0; i < barangDiterima.size(); i++) {
                System.out.println((i + 1) + ". " + barangDiterima.get(i));
            }

            System.out.print("Pilih barang untuk direview (masukkan nomor): ");
            int pilihan = scanner.nextInt();
            if (pilihan > 0 && pilihan <= barangDiterima.size()) {
                scanner.nextLine(); // Membersihkan buffer
                System.out.print("Masukkan review Anda untuk " + barangDiterima.get(pilihan - 1) + ": ");
                String review = scanner.nextLine();
                reviewBarang.add("Barang: " + barangDiterima.get(pilihan - 1) + ", Review: " + review);
                System.out.println("Review berhasil disimpan!");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
    public void Mencari_barang(String nama_barang){
        boolean ditemukan = false;
        for (String produk : daftarProduk) {
            if (produk.toLowerCase().contains( /*isi dari daftar produk*/ .toLowerCase())) {
                System.out.println("Barang ditemukan: " + produk);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }
    
    // end pembeli

    @Override
    public void Keluar(String Id_pengguna) {
        if (currentUser != null && currentUser.getId_pengguna().equals(Id_pengguna)) {
            System.out.println("Logout berhasil untuk pengguna: " + currentUser.getNama());
            currentUser = null;
        } else {
            System.out.println("Logout gagal. Tidak ada pengguna yang sedang login.");
        }
    }

    @Override
    public void Validasi(String Id_pengguna) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
