/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;
import java.util.HashMap;

/**
 *
 * @author Zuhri
 */

public class Kategori {
    private String id_kategori;
    private String nama_Kategori;
    private String deskripsi_kategori;
    private HashMap<String, Produk> kategoriList;
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
        }
        kategoriList.put(id_kategori, produk);
    }

    public void hapusKategori(String id_kategori) throws KategoriException {
        if (!kategoriList.containsKey(id_kategori)) {
            throw new KategoriException("Kategori dengan id ini tidak ditemukan!");
        }
        kategoriList.remove(id_kategori);
    }

    /*
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
    }

    public void tampilkanKategori() {
        if (kategoriList.isEmpty()) {
            System.out.println("Belum ada kategori yang terdaftar.");
            return;
        }
        System.out.println("Daftar Kategori:");
        for (String id_kategori : kategoriList.keySet()) {
            System.out.println("- " + id_kategori + ": " + kategoriList.get(id_kategori));
        }
    }
    */
}