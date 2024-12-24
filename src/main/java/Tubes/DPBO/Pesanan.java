/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;

/**
 *
 * @author USER
 */

import java.util.Scanner;

public class Pesanan {
    private String id_Order;
    private String tanggal_Pemesanan;
    private String status;
    private int harga;
    private String jasaPengiriman; 

    public Pesanan(String id_Order, String tanggal_Pemesanan, String status, int harga) {
        this.id_Order = id_Order;
        this.tanggal_Pemesanan = tanggal_Pemesanan;
        this.status = status;
        this.harga = harga;
        this.jasaPengiriman = ""; 
    }

    public String getId_Order() {
        return id_Order;
    }

    public void setId_Order(String id_Order) {
        this.id_Order = id_Order;
    }

    public String getTanggalPemesanan() {
        return tanggal_Pemesanan;
    }

    public void setTanggal_Pemesanan(String tanggalPemesanan) {
        this.tanggal_Pemesanan = tanggalPemesanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getJasaPengiriman() {
        return jasaPengiriman;
    }

    public void setJasaPengiriman(String jasaPengiriman) {
        this.jasaPengiriman = jasaPengiriman;
    }
    
    public void beli_Barang(String idPesanan, String tanggalPemesanan, int harga) {
        Scanner scanner = new Scanner(System.in);
        
        this.id_Order = idPesanan;
        this.tanggal_Pemesanan = tanggalPemesanan;
        this.harga = harga;
        this.status = "Pesanan Dibuat";

        System.out.println("Pilih jasa pengiriman:");
        System.out.println("1. JNE");
        System.out.println("2. SiCepat");
        System.out.println("3. TIKI");
        System.out.println("4. Pos Indonesia");
        System.out.print("Masukkan pilihan (1-4): ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                this.jasaPengiriman = "JNE";
                break;
            case 2:
                this.jasaPengiriman = "SiCepat";
                break;
            case 3:
                this.jasaPengiriman = "TIKI";
                break;
            case 4:
                this.jasaPengiriman = "Pos Indonesia";
                break;
            default:
                System.out.println("Pilihan tidak valid. Jasa pengiriman default: JNE");
                this.jasaPengiriman = "JNE";
                break;
        }
        System.out.println("Barang berhasil dipesan!");
        System.out.println("Detail Pesanan:");
        System.out.println("ID Pesanan: " + this.id_Order);
        System.out.println("Tanggal Pemesanan: " + this.tanggal_Pemesanan);
        System.out.println("Harga: " + this.harga);
        System.out.println("Jasa Pengiriman: " + this.jasaPengiriman);
    }

    public void pembayaran(String idPesanan, String metode) {
        System.out.println("Pembayaran untuk ID Pesanan " + idPesanan + " menggunakan metode " + metode + " berhasil!");
    }
}
