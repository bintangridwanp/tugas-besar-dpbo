package pengguna;
import produk.Produk;
import java.util.ArrayList;

// Class Penawaran
public class Penawaran {
    private String id;
    private PembeliPenjual pembeli;
    private Produk barang;
    private double hargaPenawaran;
    private String status; // "Pending", "Diterima", "Ditolak"

    public Penawaran(String id, PembeliPenjual pembeli, Produk barang, double hargaPenawaran) {
        this.id = id;
        this.pembeli = pembeli;
        this.barang = barang;
        this.hargaPenawaran = hargaPenawaran;
        this.status = "Pending";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void tampilkanPenawaran() {
        System.out.printf("Penawaran #%s: Barang - %s, Harga Penawaran - %.2f, Status - %s\n",
                id, barang.getNamaProduk(), hargaPenawaran, status);
    }
}
