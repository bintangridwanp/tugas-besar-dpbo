package produk;

import pengguna.PembeliPenjual;

public class Review {
    private PembeliPenjual pengguna;
    private int rating; // 1-5
    private String komentar;

    public Review(PembeliPenjual pengguna, int rating, String komentar) {
        this.pengguna = pengguna;
        this.rating = rating;
        this.komentar = komentar;
    }

    public PembeliPenjual getPengguna() {
        return pengguna;
    }

    public int getRating() {
        return rating;
    }

    public String getKomentar() {
        return komentar;
    }

    @Override
    public String toString() {
        return String.format("Rating: %d/5\nKomentar: %s\nDiberikan oleh: %s", 
                              rating, komentar, pengguna.getUsername());
    }
}
