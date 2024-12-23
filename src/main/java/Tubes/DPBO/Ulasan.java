package Tubes.DPBO;

public class Ulasan {
    private String id_Pembeli;
    private String tanggal;
    private int rating;
    private String deskripsiUlasan;

    public Ulasan(String idPembeli, String tanggal, int rating, String deskripsiUlasan) {
        this.id_Pembeli = idPembeli;
        this.tanggal = tanggal;
        this.rating = rating;
        this.deskripsiUlasan = deskripsiUlasan;
    }

    public String getId_Pembeli() {
        return id_Pembeli;
    }

    public void setId_Pembeli(String id_Pembeli) {
        this.id_Pembeli = id_Pembeli;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDeskripsi_ulasan() {
        return deskripsiUlasan;
    }

    public void setDeskripsi_ulasan(String deskripsiUlasan) {
        this.deskripsiUlasan = deskripsiUlasan;
    }

    public void Buat_ulasan(String idPembeli, String tanggal, int rating, String deskripsiUlasan) {
        this.id_Pembeli = idPembeli;
        this.tanggal = tanggal;
        this.rating = rating;
        this.deskripsiUlasan = deskripsiUlasan;
        System.out.println("Ulasan berhasil dibuat!");
    }

    public void Edit_ulasan(String idPembeli) {
        if (this.id_Pembeli.equals(idPembeli)) {
            System.out.println("Ulasan berhasil diubah!");
        } else {
            System.out.println("ID Pembeli tidak cocok!");
        }
    }

    public void Hapus_ulasan(String idPembeli, String tanggal) {
        if (this.id_Pembeli.equals(idPembeli) && this.tanggal.equals(tanggal)) {
            this.id_Pembeli = null;
            this.tanggal = null;
            this.rating = 0;
            this.deskripsiUlasan = null;
            System.out.println("Ulasan berhasil dihapus!");
        } else {
            System.out.println("Data tidak cocok untuk dihapus.");
        }
    }
}
