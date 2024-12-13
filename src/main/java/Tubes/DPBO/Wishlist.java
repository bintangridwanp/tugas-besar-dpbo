package Tubes.DPBO;

import java.util.ArrayList;

public class Wishlist {
    private ArrayList<Produk> wishlist;

    public Wishlist() {
        this.wishlist = new ArrayList<>();
    }

    // Menambahkan produk ke wishlist
    public void Tambah_Ke_Wishlist(Produk produk) {
        // Mengecek apakah produk sudah ada di wishlist
        for (Produk p : wishlist) {
            if (p.getId_produk().equals(produk.getId_produk())) {
                System.out.println("Produk sudah ada di wishlist.");
                return;
            }
        }
        wishlist.add(produk);
        System.out.println("Produk berhasil ditambahkan ke wishlist!");
    }

    // Menghapus produk dari wishlist berdasarkan ID
    public void Hapus_Dari_Wishlist(String id_produk) {
        boolean removed = false;
        for (Produk p : wishlist) {
            if (p.getId_produk().equals(id_produk)) {
                wishlist.remove(p);
                removed = true;
                System.out.println("Produk berhasil dihapus dari wishlist!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Produk dengan ID " + id_produk + " tidak ditemukan di wishlist.");
        }
    }

    // Menampilkan semua produk dalam wishlist
    public void Tampilkan_Wishlist() {
        if (wishlist.isEmpty()) {
            System.out.println("Wishlist kosong.");
            return;
        }
        for (Produk p : wishlist) {
            System.out.println(p);
        }
    }

    // Mendapatkan semua produk dalam wishlist
    public ArrayList<Produk> getWishlist() {
        return this.wishlist;
    }
}
