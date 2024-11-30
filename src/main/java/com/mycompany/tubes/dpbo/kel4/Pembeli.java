public class Pembeli extends Pengguna {

    private String Id_pembeli;
    private String Nama_pembeli;
    private String Alamat_pembeli;

    public Pembeli(String id_pembeli, String nama_pembeli, String alamat_pembeli) {
        Id_pembeli = id_pembeli;
        Nama_pembeli = nama_pembeli;
        Alamat_pembeli = alamat_pembeli;
    }

    public String getId_pembeli() {
        return Id_pembeli;
    }

    public String getNama_pembeli() {
        return Nama_pembeli;
    }

    public String getAlamat_pembeli() {
        return Alamat_pembeli;
    }

    public void setId_pembeli(String id_pembeli) {
        Id_pembeli = id_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        Nama_pembeli = nama_pembeli;
    }

    public void setAlamat_pembeli(String alamat_pembeli) {
        Alamat_pembeli = alamat_pembeli;
    }

    public void Beli_barang(String id_produk, int jumlah){

    }

    public void Pembayaran(String id_pesanan, int rating, String metode){

    }

    public void Review_barang(String id_pesanan, int rating, String deskripsi){

    }

    public void Melakukan_ulasan(String id_ulasan, int rating, String deskripsi){

    }

    public void Mencari_barang(String nama_barang ){

    }

}
