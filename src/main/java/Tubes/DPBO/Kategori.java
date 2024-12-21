/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;
import Tubes.DPBO.Util.UtilityClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Zuhri
 */

public class Kategori {
    private String Nama_Kategori;
    private HashMap<String, ArrayList<Produk>> List_Kategori;
    
    UtilityClass util = new UtilityClass();
    Scanner myObj = new Scanner(System.in);

    public Kategori() {
        List_Kategori = new HashMap<>();
    }

    public void tambahKategori(String Nama_Kategori) throws KategoriException {
        if (List_Kategori.containsKey(Nama_Kategori)) {
            throw new KategoriException("Kategori dengan nama : " + Nama_Kategori + " sudah ada!");
        } else {
            List_Kategori.put(Nama_Kategori, new ArrayList<>());
        }
    
        List_Kategori.get(Nama_Kategori).add(null);
        System.out.println("Kategori " + Nama_Kategori +  " berhasil ditambahkan!");
    }

    public void hapusKategori(String Nama_Kategori) throws KategoriException {
        if (!List_Kategori.containsKey(Nama_Kategori)) {
            throw new KategoriException("Kategori dengan id ini tidak ditemukan!");
        }
        List_Kategori.remove(Nama_Kategori);
    }

    public void tambahProdukKeKategori(Produk produk) {
        System.out.println("Pilih Kategori");
        for (Map.Entry<String, ArrayList<Produk>> entry : List_Kategori.entrySet()) {
            Object key = entry.getKey();
            System.out.println("-> " + key);
        }
        String input = util.getStringInput(myObj, "Masukkan nama Kategori : ");
        List_Kategori.get(input).add(produk);
        
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