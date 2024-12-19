/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;

/**
 *
 * @author USER
 */

public class Pesanan {
    private String Id_order;
    private String Tanggal_pemesanan;
    private String Status;
    private int Harga;

    public Pesanan(String Id_order, String Tanggal_pemesanan, String Status, int Harga) {
        this.Id_order = Id_order;
        this.Tanggal_pemesanan = Tanggal_pemesanan;
        this.Status = Status;
        this.Harga = Harga;
    }

    public void Beli_barang(String Id_order, String Tanggal_pemesanan, int Harga) {
        this.Id_order = Id_order;
        this.Tanggal_pemesanan = Tanggal_pemesanan;
        this.Harga = Harga;
        this.Status = "Dipesan";
    }

    public boolean Pembayaran(String Id_order, String metodePembayaran) {
        if (this.Id_order.equals(Id_order) && this.Status.equals("Dipesan")) {
            this.Status = "Dibayar";
            System.out.println("Pembayaran berhasil menggunakan metode: " + metodePembayaran);
            return true;
        }
        System.out.println("Maaf, saat ini pembayaran anda sedang tidak bisa kami proses, dana anda sudah di refund.");
        return false;
    }

    public void Review_barang(String Id_order, int rating, String Deskripsi_ulasan) {
        if (this.Id_order.equals(Id_order) && this.Status.equals("Dibayar")) {
            System.out.println("Ulasan untuk pesanan " + Id_order + ":");
            System.out.println("Rating: " + rating);
            System.out.println("Deskripsi: " + Deskripsi_ulasan);
        } else {
            System.out.println("Ulasan tidak dapat diberikan.");
        }
    }
    
    public void Mencari_barang(String nama_barang) {
        System.out.println("Mencari barang: " + nama_barang);
    }

    public String getId_order() {
        return Id_order;
    }

    public void setId_order(String Id_order) {
        this.Id_order = Id_order;
    }

    public String getTanggal_pemesanan() {
        return Tanggal_pemesanan;
    }

    public void setTanggal_pemesanan(String Tanggal_pemesanan) {
        this.Tanggal_pemesanan = Tanggal_pemesanan;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
}