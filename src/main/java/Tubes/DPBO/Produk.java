package com.mycompany.tubes.dpbo.kel4;

public abstract class Produk {
    private String Id_produk; // Gunakan camelCase untuk konsistensi dengan Java conventions
    private String Nama_barang;
    private int Harga;
    private int Stok;
    private String Lokasi;
    private String Deskripsi;

    // Constructor default
    public Produk() {}

    // Constructor dengan parameter
    public Produk(String idProduk, String namaBarang, int harga, int stok, String lokasi, String deskripsi) {
        this.Id_produk = idProduk;
        this.Nama_barang = namaBarang;
        this.Harga = harga;
        this.Stok = stok;
        this.Lokasi = lokasi;
        this.Deskripsi = deskripsi;
    }

    // Getter dan Setter
    public String getId_produk() {
        return Id_produk;
    }

    public void setId_produk(String idProduk) {
        this.Id_produk = idProduk;
    }

    public String getNama_barang() {
        return Nama_barang;
    }

    public void setNama_barang(String namaBarang) {
        this.Nama_barang = namaBarang;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        if (harga < 0) {
            System.out.println("Harga tidak bisa negatif!");
            return;
        }
        this.Harga = harga;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak bisa negatif!");
            return;
        }
        this.Stok = stok;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        this.Lokasi = lokasi;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.Deskripsi = deskripsi;
    }

    // Metode untuk menambah stok
    public void Tambah_Stok(int jumlah) {
        if (jumlah < 0) {
            System.out.println("Jumlah penambahan tidak valid!");
            return;
        }
        this.Stok += jumlah;
    }

    // Metode untuk mengurangi stok
    public void Kurangi_Stok(int jumlah) {
        if (jumlah < 0) {
            System.out.println("Jumlah pengurangan tidak valid!");
            return;
        }
        if (jumlah > this.Stok) {
            System.out.println("Stok tidak cukup untuk pengurangan!");
            return;
        }
        this.Stok -= jumlah;
    }

    // Override metode toString untuk menampilkan informasi produk
    @Override
    public String toString() {
        return "================================"
             + "\nId Produk   : " + this.Id_produk
             + "\nNama Barang : " + this.Nama_barang
             + "\nHarga       : Rp " + this.Harga
             + "\nStok        : " + this.Stok
             + "\nLokasi      : " + this.Lokasi
             + "\nDeskripsi   : " + this.Deskripsi
             + "\n================================";
    }
}
