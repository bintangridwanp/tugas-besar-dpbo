package Tubes.DPBO;

public class Produk_Diskon extends Produk implements Diskon {
    private int Jumlah_diskon;

    public Produk_Diskon() {
        super(); // Memanggil konstruktor dari kelas Produk
    }

    public Produk_Diskon(String id_produk, String nama_barang, int harga, int stok, String lokasi, String deskripsi, int jumlah_diskon) {
        super(id_produk, nama_barang, harga, stok, lokasi, deskripsi); // Memanggil konstruktor dari kelas Produk
        this.Jumlah_diskon = jumlah_diskon;
    }

    public int getJumlah_diskon() {
        return Jumlah_diskon;
    }

    public void setJumlah_diskon(int jumlah_diskon) {
        if (jumlah_diskon < 0 || jumlah_diskon > 100) {
            throw new IllegalArgumentException("Diskon harus antara 0 dan 100.");
        }
        this.Jumlah_diskon = jumlah_diskon;
    }

    // Metode untuk menghitung harga setelah diskon
    public int Harga_Setelah_Diskon() {
        return (int) (getHarga() * (1 - Jumlah_diskon / 100.0)); // Menghitung harga setelah diskon
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + 
               "Jumlah Diskon\t: " + this.Jumlah_diskon + "%\n" +
               "Harga Setelah Diskon\t: " + Harga_Setelah_Diskon() + "\n" + 
               "================================";
    }
}
