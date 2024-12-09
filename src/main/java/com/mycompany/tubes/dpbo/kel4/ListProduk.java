/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes.dpbo.kel4;
import java.util.Scanner;

public class ListProduk extends Produk {
    private Produk[] Isi_produk;
    private int Jumlah_produk;

    public ListProduk(int kapasitas) {
        Isi_produk = new Produk[kapasitas];
        Jumlah_produk = 0;
    }
   
    private boolean ID_Produk_Tersedia(String idProduk) {
        for (int i = 0; i < Jumlah_produk; i++) {
            if (Isi_produk[i] != null && Isi_produk[i].getId_produk().equalsIgnoreCase(idProduk)) {
                return true;
            }
        }
        return false;
    }
    
    public void Tambah_N_Produk(int jumlah) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < jumlah; i++) {
            if (Jumlah_produk >= Isi_produk.length) {
                System.out.println("Kapasitas penuh! Tidak dapat menambah produk baru.");
                break;
            }

            System.out.print("Inputkan Id Produk: ");
            String idProduk = scanner.nextLine();

            if (ID_Produk_Tersedia(idProduk)) {
                System.out.println("ID Produk sudah ada! Masukkan ID baru.");
                i--; // Mengulangi iterasi jika ID sudah ada
                continue;
            }

            Produk produkBaru = new Produk() {}; // Menggunakan instansiasi anonim dari Produk
            produkBaru.setId_produk(idProduk);

            System.out.print("Inputkan Nama Barang: ");
            produkBaru.setNama_barang(scanner.nextLine());

            System.out.print("Inputkan Harga Barang: ");
            produkBaru.setHarga(scanner.nextInt());

            System.out.print("Inputkan Stok Barang: ");
            produkBaru.setStok(scanner.nextInt());
            scanner.nextLine(); // Membersihkan buffer

            System.out.print("Inputkan Lokasi Barang: ");
            produkBaru.setLokasi(scanner.nextLine());

            System.out.print("Inputkan Deskripsi Barang: ");
            produkBaru.setDeskripsi(scanner.nextLine());

            Isi_produk[Jumlah_produk++] = produkBaru;
            System.out.println("Produk berhasil ditambahkan!");
        }
    }
    
    public void Tambah_Produk() {
        Scanner scanner = new Scanner(System.in);

        if (Jumlah_produk >= Isi_produk.length) {
            System.out.println("Kapasitas penuh! Tidak dapat menambah produk baru.");
            return;
        }

        System.out.print("Inputkan Id Produk: ");
        String idProduk = scanner.nextLine();

        if (ID_Produk_Tersedia(idProduk)) {
            System.out.println("ID Produk sudah ada! Masukkan ID baru.");
            return;
        }

        Produk produkBaru = new Produk() {};
        produkBaru.setId_produk(idProduk);

        System.out.print("Inputkan Nama Barang: ");
        produkBaru.setNama_barang(scanner.nextLine());

        System.out.print("Inputkan Harga Barang: ");
        produkBaru.setHarga(scanner.nextInt());

        System.out.print("Inputkan Stok Barang: ");
        produkBaru.setStok(scanner.nextInt());
        scanner.nextLine(); // Membersihkan buffer

        System.out.print("Inputkan Lokasi Barang: ");
        produkBaru.setLokasi(scanner.nextLine());

        System.out.print("Inputkan Deskripsi Barang: ");
        produkBaru.setDeskripsi(scanner.nextLine());

        Isi_produk[Jumlah_produk++] = produkBaru;
        System.out.println("Produk berhasil ditambahkan!");
    }

    
    public void Edit_Produk(String id_produk) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < Jumlah_produk; i++) {
            if (Isi_produk[i] != null && Isi_produk[i].getId_produk().equalsIgnoreCase(id_produk)) {
                System.out.print("Inputkan Nama Barang: ");
                Isi_produk[i].setNama_barang(scanner.nextLine());

                System.out.print("Inputkan Harga Barang: ");
                Isi_produk[i].setHarga(scanner.nextInt());

                System.out.print("Inputkan Stok Barang: ");
                Isi_produk[i].setStok(scanner.nextInt());
                scanner.nextLine(); // Membersihkan buffer

                System.out.print("Inputkan Lokasi Barang: ");
                Isi_produk[i].setLokasi(scanner.nextLine());

                System.out.print("Inputkan Deskripsi Barang: ");
                Isi_produk[i].setDeskripsi(scanner.nextLine());

                System.out.println("Produk berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Produk dengan ID tersebut tidak ditemukan!");
    }

    
    public void Hapus_Produk(String id_produk) {
        for (int i = 0; i < Jumlah_produk; i++) {
            if (Isi_produk[i] != null && Isi_produk[i].getId_produk().equalsIgnoreCase(id_produk)) {
                // Geser elemen ke kiri
                for (int j = i; j < Jumlah_produk - 1; j++) {
                    Isi_produk[j] = Isi_produk[j + 1];
                }
                Isi_produk[--Jumlah_produk] = null; // Kurangi count dan hapus elemen terakhir
                System.out.println("Produk berhasil dihapus!");
                return;
            }
        }
        System.out.println("Produk dengan ID tersebut tidak ditemukan!");
    }
    
    public Produk[] getAllProduk() {
        return this.Isi_produk;
    }
    
    public void Tampilkan_Isi_Produk() {
        if (Jumlah_produk == 0) {
            System.out.println("Tidak ada produk yang tersedia.");
            return;
        }

        for (int i = 0; i < Jumlah_produk; i++) {
            System.out.println(Isi_produk[i].toString());
        }
    }
}
