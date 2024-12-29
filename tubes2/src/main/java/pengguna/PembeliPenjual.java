package pengguna;

import produk.Produk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import transaksi.Pemesanan;

public class PembeliPenjual extends Pengguna {
    private Map<Produk, Integer> keranjang; //untuk checkout barang
    private ArrayList<Produk> barangJualan;
    private ArrayList<Pemesanan> daftarPemesanan = new ArrayList<>();  //untuk pelacakan barang
    
    public PembeliPenjual(String username, String password, String email, String noTelepon) {
        super(username, password, email, noTelepon);
        this.keranjang = new HashMap<>();
        this.barangJualan = new ArrayList<>();
    }

    // Menambah barang ke keranjang
    public void tambahKeKeranjang(Produk produk, int jumlah) {
        if (keranjang.containsKey(produk)) {
            keranjang.put(produk, keranjang.get(produk) + jumlah);
        } else {
            keranjang.put(produk, jumlah);
        }
    }
    
    public Map<Produk, Integer> getKeranjang() {
        return keranjang;
    }
    
    // Mengembalikan stok barang setelah pembatalan
    public void clearKeranjang() {
        keranjang.clear();
    }

    @Override
    public void tampilkanRole() {
        System.out.println("Role: Pembeli dan Penjual");
    }

    public ArrayList<Produk> getBarangJualan() {
        return barangJualan;
    }

    public void tambahKeBarangJualan(Produk produk) {
        barangJualan.add(produk);
        System.out.println(produk.getNamaProduk() + " ditambahkan ke barang jualan.");
    }
    
    public void tambahPemesanan(Pemesanan pemesanan) {
        daftarPemesanan.add(pemesanan);
    }
    
    public ArrayList<Pemesanan> getDaftarPemesanan() {
        return daftarPemesanan;
    }
}
