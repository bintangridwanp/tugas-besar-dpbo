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
    private HashMap<String, String> kategoriMap;

    public Kategori() {
        kategoriMap = new HashMap<>();
    }

    public void tambahKategori(String namaKategori, String deskripsi) throws KategoriException {
        if (namaKategori == null || namaKategori.isEmpty()) {
            throw new KategoriException("Nama kategori tidak boleh kosong!");
        }
        if (kategoriMap.containsKey(namaKategori)) {
            throw new KategoriException("Kategori dengan nama ini sudah ada!");
        }
        kategoriMap.put(namaKategori, deskripsi);
    }

    public void hapusKategori(String namaKategori) throws KategoriException {
        if (!kategoriMap.containsKey(namaKategori)) {
            throw new KategoriException("Kategori dengan nama ini tidak ditemukan!");
        }
        kategoriMap.remove(namaKategori);
    }

    public void perbaruiDeskripsi(String namaKategori, String deskripsiBaru) throws KategoriException {
        if (!kategoriMap.containsKey(namaKategori)) {
            throw new KategoriException("Kategori dengan nama ini tidak ditemukan!");
        }
        kategoriMap.put(namaKategori, deskripsiBaru);
    }

    public String getDeskripsi(String namaKategori) throws KategoriException {
        if (!kategoriMap.containsKey(namaKategori)) {
            throw new KategoriException("Kategori dengan nama ini tidak ditemukan!");
        }
        return kategoriMap.get(namaKategori);
    }

    public void tampilkanKategori() {
        if (kategoriMap.isEmpty()) {
            System.out.println("Belum ada kategori yang terdaftar.");
            return;
        }
        System.out.println("Daftar Kategori:");
        for (String namaKategori : kategoriMap.keySet()) {
            System.out.println("- " + namaKategori + ": " + kategoriMap.get(namaKategori));
        }
    }
}
