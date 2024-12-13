package com.mycompany.tubes.dpbo.kel4;

import java.util.HashMap;
import java.util.Scanner;

public class List_Produk {
    private HashMap<String, Produk> produkMap;

    public List_Produk() {
        this.produkMap = new HashMap<>();
    }

    public void Tambah_Produk() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Inputkan Id Produk: ");
            String idProduk = scanner.nextLine();

            if (produkMap.containsKey(idProduk)) {
                System.out.println("ID Produk sudah ada! Masukkan ID baru.");
                return;
            }

            Produk produk = new Produk();
            produk.setId_produk(idProduk);

            System.out.print("Inputkan Nama Barang: ");
            produk.setNama_barang(scanner.nextLine());

            System.out.print("Inputkan Harga Barang: ");
            produk.setHarga(scanner.nextInt());
            scanner.nextLine(); // Clear newline

            System.out.print("Inputkan Stok Barang: ");
            produk.setStok(scanner.nextInt());
            scanner.nextLine(); // Clear newline

            System.out.print("Inputkan Lokasi Barang: ");
            produk.setLokasi(scanner.nextLine());

            System.out.print("Inputkan Deskripsi Barang: ");
            produk.setDeskripsi(scanner.nextLine());

            produkMap.put(idProduk, produk);
            System.out.println("Produk berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }

    public void Tambah_N_Produk(int jumlah) {
        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < jumlah; i++) {
                System.out.println("\nMenambahkan produk ke-" + (i + 1));

                System.out.print("Inputkan Id Produk: ");
                String idProduk = scanner.nextLine();

                if (produkMap.containsKey(idProduk)) {
                    System.out.println("ID Produk sudah ada! Masukkan ID baru.");
                    i--; // Retry current iteration
                    continue;
                }

                Produk produk = new Produk();
                produk.setId_produk(idProduk);

                System.out.print("Inputkan Nama Barang: ");
                produk.setNama_barang(scanner.nextLine());

                System.out.print("Inputkan Harga Barang: ");
                produk.setHarga(scanner.nextInt());
                scanner.nextLine(); // Clear newline

                System.out.print("Inputkan Stok Barang: ");
                produk.setStok(scanner.nextInt());
                scanner.nextLine(); // Clear newline

                System.out.print("Inputkan Lokasi Barang: ");
                produk.setLokasi(scanner.nextLine());

                System.out.print("Inputkan Deskripsi Barang: ");
                produk.setDeskripsi(scanner.nextLine());

                produkMap.put(idProduk, produk);
                System.out.println("Produk berhasil ditambahkan!");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }

    public void Edit_Produk(String idProduk) {
        try {
            if (!produkMap.containsKey(idProduk)) {
                System.out.println("ID Produk tidak ditemukan!");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            Produk produk = produkMap.get(idProduk);

            System.out.print("Inputkan Nama Barang: ");
            produk.setNama_barang(scanner.nextLine());

            System.out.print("Inputkan Harga Barang: ");
            produk.setHarga(scanner.nextInt());
            scanner.nextLine(); // Clear newline

            System.out.print("Inputkan Stok Barang: ");
            produk.setStok(scanner.nextInt());
            scanner.nextLine(); // Clear newline

            System.out.print("Inputkan Lokasi Barang: ");
            produk.setLokasi(scanner.nextLine());

            System.out.print("Inputkan Deskripsi Barang: ");
            produk.setDeskripsi(scanner.nextLine());

            System.out.println("Produk berhasil diperbarui!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengedit produk: " + e.getMessage());
        }
    }

    public void Hapus_Produk(String idProduk) {
        try {
            if (produkMap.remove(idProduk) != null) {
                System.out.println("Produk berhasil dihapus!");
            } else {
                System.out.println("ID Produk tidak ditemukan!");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus produk: " + e.getMessage());
        }
    }
    
    public HashMap<String, Produk> getAll_Produk() {
        return this.produkMap;
    }

    public void Tampilkan_Produk() {
        try {
            if (produkMap.isEmpty()) {
                System.out.println("Tidak ada produk yang tersedia.");
                return;
            }

            for (Produk produk : produkMap.values()) {
                System.out.println(produk);
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menampilkan produk: " + e.getMessage());
        }
    }
    
    public HashMap<String, Produk> Cari_Produk_Dengan_Nama(String nama_produk) {
        HashMap<String, Produk> hasil = new HashMap<>();
        try {
            for (String key : produkMap.keySet()) {
                Produk produk = produkMap.get(key);
                if (produk.getNama_barang().toLowerCase().contains(nama_produk.toLowerCase())) {
                    hasil.put(key, produk);
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mencari produk dengan nama: " + e.getMessage());
        }
        return hasil;
    }
    
    public Produk Cari_Produk_Dengan_ID(String id_produk) {
        try {
            return produkMap.getOrDefault(id_produk, null);
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mencari produk dengan ID : " + id_produk);
        }
        return null;
    }
}