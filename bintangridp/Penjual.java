public class Penjual extends  {

    private String Id_penjual;
    private String Nama_penjual;
    private String Alamat_penjual;

    public Penjual(String id_penjual, String nama_penjual, String alamat_penjual) {
        Id_penjual = id_penjual;
        Nama_penjual = nama_penjual;
        Alamat_penjual = alamat_penjual;
    }

    public String getId_penjual() {
        return Id_penjual;
    }

    public void setId_penjual(String id_penjual) {
        Id_penjual = id_penjual;
    }

    public String getNama_penjual() {
        return Nama_penjual;
    }

    public void setNama_penjual(String nama_penjual) {
        Nama_penjual = nama_penjual;
    }

    public String getAlamat_penjual() {
        return Alamat_penjual;
    }

    public void setAlamat_penjual(String alamat_penjual) {
        Alamat_penjual = alamat_penjual;
    }

    public void Jual_barang(String id_produk, int jumlah, int harga){

    }

    public void Kirim_barang(String id_pesanan){

    }

    public void Mengatur_pengiriman(String id_pesanan, String jasa_pengiriman){

    }

    public void Mengatur_stok_barang(String id_produk, int jumlah){

    }

    public void Terima_pembayaran(String id_pesanan){

    }
}
