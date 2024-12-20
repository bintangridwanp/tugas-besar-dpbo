/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zuhri
 */

public class Kategori {
    private String Nama_Kategori;
    private HashMap<String, ArrayList<Produk>> List_Kategori;

    public Kategori() {
        List_Kategori = new HashMap<>();
    }

    public void tambahKategori(String Nama_Kategori, Produk produk) throws KategoriException {
        if (Nama_Kategori == null || Nama_Kategori.isEmpty()) {
            throw new KategoriException("id kategori tidak boleh kosong!");
        }
        if (List_Kategori.containsKey(Nama_Kategori)) {
            throw new KategoriException("Kategori dengan id ini sudah ada!");
        } else {
            List_Kategori.put(Nama_Kategori, new ArrayList<>());
        }
    
        List_Kategori.get(Nama_Kategori).add(produk);
        System.out.println("Produk berhasil ditambahkan ke kategori: " + Nama_Kategori);
    }

    public void hapusKategori(String Nama_Kategori) throws KategoriException {
        if (!List_Kategori.containsKey(Nama_Kategori)) {
            throw new KategoriException("Kategori dengan id ini tidak ditemukan!");
        }
        List_Kategori.remove(Nama_Kategori);
    }

    public void tambah_kategori_keProduk(String Nama_Kategori, Produk produk) {
        if (List_Kategori.containsKey(Nama_Kategori)) {
            List_Kategori.get(Nama_Kategori).add(produk);
        } else {
            ArrayList<Produk> produkList = new ArrayList<>();
            produkList.add(produk);
            List_Kategori.put(Nama_Kategori, produkList);
        }
    }

    /*
    public void hapusProdukPadaKategori(String Nama_Kategori, Produk produk) {
        
    }
    
    public void perbaruiKategori(String Nama_Kategori, String deskripsiBaru) throws KategoriException {
        if (!List_Kategori.containsKey(Nama_Kategori)) {
            throw new KategoriException("Kategori dengan nama ini tidak ditemukan!");
        }
        List_Kategori.put(Nama_Kategori, deskripsiBaru);
    }

    public String getDeskripsi(String Nama_Kategori) throws KategoriException {
        if (!List_Kategori.containsKey(Nama_Kategori)) {
            throw new KategoriException("Kategori dengan nama ini tidak ditemukan!");
        }
        return List_Kategori.get(Nama_Kategori);
    } */

    public void tampilkanKategori() throws KategoriException {
        if (List_Kategori.isEmpty()) {
            throw new KategoriException("Belum ada kategori yang terdaftar.");
        }

        System.out.println("Daftar Kategori dan Produk:");
        for (String idKategori : List_Kategori.keySet()) {
            System.out.println("Kategori: " + idKategori);
            ArrayList<Produk> produkList = List_Kategori.get(idKategori);
            if (produkList.isEmpty()) {
                throw new KategoriException("  Tidak ada produk dalam kategori ini.");
            } else {
                for (Produk produk : produkList) {
                    System.out.println(produk.toString());
                }
            }
        }
    }
}