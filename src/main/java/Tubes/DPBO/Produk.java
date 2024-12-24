package Tubes.DPBO;

public class Produk {
    private String Id_produk;
    private String Nama_barang;
    private int Harga;
    private int Stok;
    private String Lokasi;
    private String Deskripsi;
    private Kategori Kategori_Produk;

    public Produk(){}

    public Produk(String Id_produk, String Nama_barang, int Harga, int Stok, String Lokasi, String Deskripsi) {
        this.Id_produk = Id_produk;
        this.Nama_barang = Nama_barang;
        this.Harga = Harga;
        this.Stok = Stok;
        this.Lokasi = Lokasi;
        this.Deskripsi = Deskripsi;
    }
    
    public void Tambah_stock(int jumlah) {
        if (jumlah < 0) {
            throw new IllegalArgumentException("Jumlah stok yang ditambahkan tidak boleh negatif.");
        }
        this.Stok += jumlah;
    }

    public void Kurangi_stock(int jumlah) {
        if (jumlah < 0) {
            throw new IllegalArgumentException("Jumlah stok yang dikurangi tidak boleh negatif.");
        }
        if (this.Stok < jumlah) {
            throw new IllegalStateException("Stok tidak mencukupi untuk pengurangan.");
        }
        this.Stok -= jumlah;
    }

    public String getId_produk() {
        return Id_produk;
    }

    public void setId_produk(String Id_produk) {
        this.Id_produk = Id_produk;
    }

    public String getNama_barang() {
        return Nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.Nama_barang = nama_barang;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif.");
        }
        this.Harga = harga;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif.");
        }
        this.Stok = stok;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        this.Lokasi = lokasi;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.Deskripsi = deskripsi;
    }

    public Kategori getKategori_Produk() {
        return Kategori_Produk;
    }

    public void setKategori_Produk(Kategori kategori_produk) {
        this.Kategori_produk = kategori_produk;
    }

    @Override
    public String toString() {
        return "================================\n" +
               "Id Produk\t: " + this.Id_produk + "\n" +
               "Nama Barang\t: " + this.Nama_barang + "\n" +
               "Harga\t: " + this.Harga + "\n" +
               "Stok\t: " + this.Stok + "\n" +
               "Lokasi\t: " + this.Lokasi + "\n" +
               "Deskripsi\t: " + this.Deskripsi + "\n" +
               "================================";
    }
}