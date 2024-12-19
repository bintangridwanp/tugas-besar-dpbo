/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Zuhri
 */

public class Kategori {
    private String id_kategori;
    private String nama_Kategori;
    private String deskripsi_Kategori;
    private HashMap<String, ArrayList<Produk>> kategoriList;
    private Produk produk;

    public Kategori() {
        kategoriList = new HashMap<>();
    }

    public void tambahKategori(String id_kategori, Produk produk) throws KategoriException {
        if (id_kategori == null || id_kategori.isEmpty()) {
            throw new KategoriException("id kategori tidak boleh kosong!");
        }
        if (kategoriList.containsKey(id_kategori)) {
            throw new KategoriException("Kategori dengan id ini sudah ada!");
        } else {
            kategoriList.put(id_kategori, new ArrayList<>());
        }
    
        kategoriList.get(id_kategori).add(produk);
        System.out.println("Produk berhasil ditambahkan ke kategori: " + id_kategori);
    }

    public void hapusKategori(String id_kategori) throws KategoriException {
        if (!kategoriList.containsKey(id_kategori)) {
            throw new KategoriException("Kategori dengan id ini tidak ditemukan!");
        }
        kategoriList.remove(id_kategori);
    }

    /*
    public void hapusProdukPadaKategori(String id_kategori, Produk produk) {
        
    }
    
    public void perbaruiKategori(String id_kategori, String deskripsiBaru) throws KategoriException {
        if (!kategoriList.containsKey(id_kategori)) {
            throw new KategoriException("Kategori dengan nama ini tidak ditemukan!");
        }
        kategoriList.put(id_kategori, deskripsiBaru);
    }

    public String getDeskripsi(String id_kategori) throws KategoriException {
        if (!kategoriList.containsKey(id_kategori)) {
            throw new KategoriException("Kategori dengan nama ini tidak ditemukan!");
        }
        return kategoriList.get(id_kategori);
    } */

    public void tampilkanKategori() throws KategoriException {
        if (kategoriList.isEmpty()) {
            throw new KategoriException("Belum ada kategori yang terdaftar.");
        }

        System.out.println("Daftar Kategori dan Produk:");
        for (String idKategori : kategoriList.keySet()) {
            System.out.println("Kategori: " + idKategori);
            ArrayList<Produk> produkList = kategoriList.get(idKategori);
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