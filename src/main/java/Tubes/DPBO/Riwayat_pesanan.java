/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;

/**
 *
 * @author USER
 */
public class Riwayat_pesanan {
    private String Id_pembeli;
    private String metodePembayaran;
    private String alamatPengiriman;
    private String statusPengiriman;
    
    public Riwayat_pesanan(String Id_pembeli, String metodePembayaran, String alamatPengiriman, String statusPengiriman) {
        this.Id_pembeli = Id_pembeli;
        this.metodePembayaran = metodePembayaran;
        this.alamatPengiriman = alamatPengiriman;
        this.statusPengiriman = statusPengiriman;
    }
    
    public void Mulai_Transaksi(String Id_pembeli, String id_order, String metodePembayaran, String alamatPengiriman) {
        this.Id_pembeli = Id_pembeli;
        this.metodePembayaran = metodePembayaran;
        this.alamatPengiriman = alamatPengiriman;
        this.statusPengiriman = "Dalam Proses";
        System.out.println("Transaksi dimulai untuk order " + id_order + " dengan metode pembayaran " + metodePembayaran);
    }

    public void Perbarui_Status_Transaksi(String id_order, String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
        System.out.println("Status pengiriman untuk order " + id_order + " diperbarui menjadi: " + statusPengiriman);
    }
    
    public String Lihat_Detail_Transaksi(String id_order) {
        return """
               Detail Transaksi:
               ID Pembeli: """ + Id_pembeli + "\n" +
                "Metode Pembayaran: " + metodePembayaran + "\n" +
                "Alamat Pengiriman: " + alamatPengiriman + "\n" +
                "Status Pengiriman: " + statusPengiriman + "\n" +
                "ID Order: " + id_order;
    }

    public void Show_Riwayat(String Id_pembeli) {
        if (this.Id_pembeli.equals(Id_pembeli)) {
            System.out.println("Menampilkan riwayat untuk pembeli: " + Id_pembeli);
            System.out.println(Lihat_Detail_Transaksi("-"));
        } else {
            System.out.println("Riwayat tidak ditemukan untuk pembeli: " + Id_pembeli);
        }
    }
}