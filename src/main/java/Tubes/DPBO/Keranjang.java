/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;

import java.util.HashMap;

public class Keranjang {
    private HashMap<String, Integer> daftarBarang;

    public void tambahBarang(String idBarang, int jumlah) {
        if (daftarBarang.containsKey(idBarang)) {
            daftarBarang.put(idBarang, daftarBarang.get(idBarang) + jumlah);
        } else {
            daftarBarang.put(idBarang, jumlah);
        }
        // Simpan perubahan keranjang ke database
    }

    public void hapusBarang(String idBarang, int jumlah) {
        if (daftarBarang.containsKey(idBarang)) {
            int stokSekarang = daftarBarang.get(idBarang);
            if (stokSekarang <= jumlah) {
                daftarBarang.remove(idBarang);
            } else {
                daftarBarang.put(idBarang, stokSekarang - jumlah);
            }
            // Simpan perubahan keranjang ke database
        }
    }

    public HashMap<String, Integer> getBarangDiKeranjang() {
        return this.daftarBarang;
    }
}