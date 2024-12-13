package Tubes.DPBO;

import java.util.ArrayList;

public class Wishlist {
    private ArrayList<Produk> wishlist;

    public Wishlist() {
        this.wishlist = new ArrayList<>();
    }

    // Menambahkan produk ke wishlist
    public void tambahKeWishlist(Produk produk) {
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
    public void hapusDariWishlist(String idProduk) {
        boolean removed = false;
        for (Produk p : wishlist) {
            if (p.getId_produk().equals(idProduk)) {
                wishlist.remove(p);
                removed = true;
                System.out.println("Produk berhasil dihapus dari wishlist!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Produk dengan ID " + idProduk + " tidak ditemukan di wishlist.");
        }
    }

    // Menampilkan semua produk dalam wishlist
    public void tampilkanWishlist() {
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
