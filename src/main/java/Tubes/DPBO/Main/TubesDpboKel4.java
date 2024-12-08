/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Tubes.DPBO.Main;
import Tubes.DPBO.Kategori;
import Tubes.DPBO.KategoriException;

/**
 *
 * @author Muh Zhafran
 */
public class TubesDpboKel4 {

    public static void main(String[] args) {
        Kategori kategori = new Kategori();

        try {
            kategori.tambahKategori("Elektronik", "Produk terkait alat elektronik");
            kategori.tambahKategori("Pakaian", "Produk untuk kebutuhan pakaian");

            kategori.tampilkanKategori();

            System.out.println("Deskripsi Pakaian: " + kategori.getDeskripsi("Pakaian"));

            kategori.perbaruiDeskripsi("Pakaian", "Produk pakaian terbaru dan terupdate");
            System.out.println("Deskripsi diperbarui: " + kategori.getDeskripsi("Pakaian"));

            kategori.hapusKategori("Elektronik");
            kategori.tampilkanKategori();

        } catch (KategoriException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
