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
    private String id_Pembeli;
    private String metodePembayaran;
    private String alamatPengiriman;
    private String statusPengiriman;

    public Riwayat_pesanan(String idPembeli, String metodePembayaran, String alamatPengiriman, String statusPengiriman) {
        this.id_Pembeli = idPembeli;
        this.metodePembayaran = metodePembayaran;
        this.alamatPengiriman = alamatPengiriman;
        this.statusPengiriman = statusPengiriman;
    }

    public String getId_pembeli() {
        return id_Pembeli;
    }

    public void setId_pembeli(String idPembeli) {
        this.id_Pembeli = idPembeli;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getAlamatPengiriman() {
        return alamatPengiriman;
    }

    public void setAlamatPengiriman(String alamatPengiriman) {
        this.alamatPengiriman = alamatPengiriman;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }

    public void Mulai_transaksi(String idPembeli, String idOrder, String metodePembayaran, String alamatPengiriman) {
        this.id_Pembeli = idPembeli;
        this.metodePembayaran = metodePembayaran;
        this.alamatPengiriman = alamatPengiriman;
        this.statusPengiriman = "Diproses";
        System.out.println("Transaksi dimulai untuk ID Order: " + idOrder);
    }

    public void perbarui_Status_Transaksi(String idOrder, String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
        System.out.println("Status pengiriman untuk ID Order: " + idOrder + " diperbarui menjadi: " + statusPengiriman);
    }

    public void lihat_Detail_Transaksi(String idOrder) {
        System.out.println("Detail Transaksi:");
        System.out.println("ID Order: " + idOrder);
        System.out.println("ID Pembeli: " + id_Pembeli);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Alamat Pengiriman: " + alamatPengiriman);
        System.out.println("Status Pengiriman: " + statusPengiriman);
    }

    public void show_Riwayat(String idPembeli) {
        System.out.println("Riwayat transaksi untuk pembeli: " + idPembeli);
    }
}
