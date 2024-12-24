 import java.sql.SQLOutput;
 import java.util.*;


 public class Penjualan_produk {
     // pesananMap Tes
     private HashMap<String, HashMap<String, String>> pesananMap = new HashMap<>();
     // barangSiapKirim Tes
     ArrayList<String> barangSiapKirim = new ArrayList<>();
     // kategoriList Tes
     private  List<String> kategoriList = new ArrayList<>();
     //HashMap menyimpan produk
     private HashMap<String, HashMap<String, Object>> produkMap = new HashMap<>();

     private String Id_produk;
     private String Nama_produk;
     private int Jumlah_produk;
     private  int Harga;
     private String Id_pesanan;
     private String Jasa_pengiriman;

     public Penjualan_produk(String id_produk, String nama_produk, int jumlah_produk, int harga, String id_pesanan, String jasa_pengiriman) {
         this.Id_produk = id_produk;
         this.Nama_produk = nama_produk;
         this.Jumlah_produk = jumlah_produk;
         this.Harga = harga;
         this.Id_pesanan = id_pesanan;
         this.Jasa_pengiriman = jasa_pengiriman;
     }

     public String getId_produk() {
         return Id_produk;
     }

     public void setId_produk(String id_produk) {
         Id_produk = id_produk;
     }

     public String getNama_produk() {
         return Nama_produk;
     }

     public void setNama_produk(String nama_produk) {
         Nama_produk = nama_produk;
     }

     public int getJumlah_produk() {
         return Jumlah_produk;
     }

     public void setJumlah_produk(int jumlah_produk) {
         Jumlah_produk = jumlah_produk;
     }

     public int getHarga() {
         return Harga;
     }

     public void setHarga(int harga) {
         Harga = harga;
     }

     public String getId_pesanan() {
         return Id_pesanan;
     }

     public void setId_pesanan(String id_pesanan) {
         Id_pesanan = id_pesanan;
     }

     public String getJasa_pengiriman() {
         return Jasa_pengiriman;
     }

     public void setJasa_pengiriman(String jasa_pengiriman) {
         Jasa_pengiriman = jasa_pengiriman;
     }

     public HashMap<String, HashMap<String, String>> getPesananMap() {
         return pesananMap;
     }

     public void setPesananMap(HashMap<String, HashMap<String, String>> pesananMap) {
         this.pesananMap = pesananMap;
     }

     public ArrayList<String> getBarangSiapKirim() {
         return barangSiapKirim;
     }

     public void setBarangSiapKirim(ArrayList<String> barangSiapKirim) {
         this.barangSiapKirim = barangSiapKirim;
     }

     public List<String> getKategoriList() {
         return kategoriList;
     }

     public void setKategoriList(List<String> kategoriList) {
         this.kategoriList = kategoriList;
     }

     public HashMap<String, HashMap<String, Object>> getProdukMap() {
         return produkMap;
     }

     public void setProdukMap(HashMap<String, HashMap<String, Object>> produkMap) {
         this.produkMap = produkMap;
     }

     // function dan procedure penjualan produk

     public void Jual_barang(String Id_produk, String Nama_produk, int  Jumlah, int Harga, String Kategori) {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Masukan Id Produk: ");
         String idproduk = scanner.nextLine();

         if (produkMap.containsKey(idproduk)) {
             System.out.println("Id Produk sudah ada. Silakan masukkan produk dengan Id berbeda.");
             return;
         }

         System.out.println("Masukan Nama Produk: ");
         String namaProduk = scanner.nextLine();

         System.out.println("Masukan Jumlah Produk: ");
         int jumlah = scanner.nextInt();

         System.out.println("Masukan Harga Produk: ");
         int harga = scanner.nextInt();

         scanner.nextLine();

         // Inisialisasi data dummy untuk kategori
         kategoriList.add("Elektronik");
         kategoriList.add("Pakaian");
         kategoriList.add("Rumah Tangga");
         kategoriList.add("Buku dan Alat Tulis");
         kategoriList.add("Kesehatan dan Kecantikan");
         kategoriList.add("Makanan dan Minuman");
         kategoriList.add("Hobi dan Mainan");
         kategoriList.add("Olahraga");
         kategoriList.add("Peralatan Kantor");
         kategoriList.add("Aksesoris & Perhiasan");

         System.out.println("Pilih Kategori (dari daftar berikut): ");
         for (String kategori : kategoriList ) {
             System.out.println("- " + kategori);
         }

         // Menampilkan kategori yang telah dikelola oleh class Kategori
         System.out.println("Daftar Kategori Produk yang Tersedia:");
         int nomor = 1; // Digunakan untuk menampilkan nomor kategori
         HashMap<Integer, String> nomorKategoriMap = new HashMap<>();

         for (String kategori : kategoriList) {
             System.out.println(nomor + ". " + kategori);
             nomorKategoriMap.put(nomor, kategori); // Menyimpan nomor dan kategori dalam HashMap
             nomor++;
         }

         // Memasukkan kategori produk
         System.out.print("Pilih kategori produk (masukkan nomor): ");
         int pilihan;
         try {
             pilihan = Integer.parseInt(scanner.nextLine());

             if (!nomorKategoriMap.containsKey(pilihan)) {
                 System.out.println("Kategori tidak valid. Silakan pilih nomor yang tersedia.");
                 return;
             }
         } catch (NumberFormatException e) {
             System.out.println("Input kategori tidak valid. Masukkan nomor yang benar.");
             return;
         }

         // Mengambil kategori berdasarkan pilihan nomor
         String kategori = nomorKategoriMap.get(pilihan);
         System.out.println("Kategori yang dipilih: " + kategori);


         HashMap<String, Object> detailProduk = new HashMap<>();
         detailProduk.put("Nama_produk", namaProduk);
         detailProduk.put("Jumlah",jumlah);
         detailProduk.put("Harga", harga);
         detailProduk.put("Kategori", kategori);

         produkMap.put(idproduk, detailProduk);
         System.out.println("Produk berhasil ditambahkan!");

     }

     public void Tampilkan_produk() {
         if (produkMap.isEmpty()) {
             System.out.println("Tidak ada produk yang tersedia.");
             return;
         }

         for (String key : produkMap.keySet()) {
             HashMap<String, Object> produk = produkMap.get(key);
             System.out.println("ID Produk: " + key);
             System.out.println("\tNama: " + produk.get("Nama_produk"));
             System.out.println("\tHarga: " + produk.get("Harga"));
             System.out.println("\tJumlah: " + produk.get("Jumlah"));
         }
     }

     public void Hapus_barang(String id_produk, String nama_produk){
         Scanner scanner = new Scanner(System.in);

         // tampilkan semua produk
         Tampilkan_produk();

         if (produkMap.isEmpty()){
             System.out.println("Tidak ada produk untuk dihapus!.");
             return;
         }

         System.out.println("\nMasukan ID Produk (opsional): ");
         id_produk = scanner.nextLine();

         System.out.println("Masukan Nama Produk (opsional): ");
         nama_produk = scanner.nextLine();

         HashMap<String, Object> produkDitemukan = null;
         String idDitemukan = null;

         if (!id_produk.isEmpty() && produkMap.containsKey(id_produk)){
             produkDitemukan = produkMap.get(id_produk);
             idDitemukan = id_produk;
         } else if (!nama_produk.isEmpty()){
             for (Map.Entry<String, HashMap<String, Object>> entry : produkMap.entrySet()) {
                 if (entry.getValue().get("Nama_produk").equals(nama_produk)){
                     produkDitemukan = entry.getValue();
                     idDitemukan = entry.getKey();
                     break;
                 }
             }
         }

         if (produkDitemukan == null){
             System.out.println("Produk tidak ditemukan berdasarkan ID atau nama yang diberikan.");
             return;
         }

         System.out.println("\nProduk yang ditemukan: ");
         System.out.println("ID Produk: " + idDitemukan);
         System.out.println("Nama Produk: " + produkDitemukan.get("Nama_produk"));
         System.out.println("Jumlah: " + produkDitemukan.get("Jumlah"));
         System.out.println("Harga: " + produkDitemukan.get("Harga"));
         System.out.println("Kategori: " + produkDitemukan.get("Kategori"));

         System.out.println("\nApakah Anda yakin ingin menghapus produk ini? (y/n): ");
         String konfirmasi = scanner.nextLine();

         if (konfirmasi.equalsIgnoreCase("y")) {
             produkMap.remove(idDitemukan);
             System.out.println("Produk dengan ID " + idDitemukan + " berhasil dihapus.");
         } else {
             System.out.println("Penghapusan produk dibatalkan.");
         }


     }

     public void Kirim_barang(String Id_pesanan, String penggunaAktif, ArrayList<String> barangSudahDikirim) {
         if (penggunaAktif == null) {
             System.out.println("Anda harus login terlebih dahulu untuk mengelola pengiriman barang.");
             return;
         }

         Scanner scanner = new Scanner(System.in);

         System.out.println("\n=== Pengelolaan Pengiriman Barang ===");

         for (String id : pesananMap.keySet()) {
             HashMap<String, String> detailPesanan = pesananMap.get(id);
             String pemilikBarang = detailPesanan.get("pemilik");
             String pembeliBarang = detailPesanan.get("pembeli");

             // Cek bahwa barang bukan milik sendiri
             if (pembeliBarang.equals(penggunaAktif) && !pemilikBarang.equals(penggunaAktif)) {
                 barangSiapKirim.add(id);
             }
         }

         // Jika tidak ada barang untuk dikirim
         if (barangSiapKirim.isEmpty()) {
             System.out.println("Tidak ada barang yang siap untuk dikirim.");
             return;
         }

         // Tampilkan daftar barang yang siap dikirim
         System.out.println("Daftar barang yang siap dikirim:");
         for (int i = 0; i < barangSiapKirim.size(); i++) {
             String idPesanan = barangSiapKirim.get(i);
             HashMap<String, String> detail = pesananMap.get(idPesanan);
             System.out.println((i + 1) + ". Pesanan ID: " + idPesanan
                     + ", Barang: " + detail.get("nama_barang")
                     + ", Pembeli: " + detail.get("pembeli"));
         }

         // Input pengguna: pilih barang yang akan dikirim
         System.out.println("\nPilih barang yang akan dikirim (masukkan nomor): ");
         int pilihan = scanner.nextInt();
         scanner.nextLine(); // Buang newline

         if (pilihan < 1 || pilihan > barangSiapKirim.size()) {
             System.out.println("Pilihan tidak valid.");
             return;
         }

         String barangTerpilih = barangSiapKirim.get(pilihan - 1);
         HashMap<String, String> detailTerpilih = pesananMap.get(barangTerpilih);

         // Konfirmasi pengiriman barang
         System.out.println("\nApakah Anda yakin ingin mengirim barang berikut?");
         System.out.println("Barang: " + detailTerpilih.get("nama_barang"));
         System.out.println("Pembeli: " + detailTerpilih.get("pembeli"));
         System.out.print("Ketik 'Y' untuk mengkonfirmasi: ");
         String konfirmasi = scanner.nextLine();

         if (!konfirmasi.equalsIgnoreCase("Y")) {
             System.out.println("Pengiriman dibatalkan.");
             return;
         }

         // Menandai barang sebagai sudah dikirim
         barangSudahDikirim.add(barangTerpilih);
         System.out.println("Barang dengan ID pesanan " + barangTerpilih + " telah berhasil dikirim!");

         // (Opsional: Hapus dari barangSiapKirim jika diperlukan)
         barangSiapKirim.remove(barangTerpilih);
     }

     public void Mengatur_stok_barang(String Id_produk, int jumlah, String penggunaAktif) {
         if (penggunaAktif == null || penggunaAktif.isEmpty()) {
             System.out.println("Anda harus login terlebih dahulu untuk mengatur stok barang.");
             return;
         }

         Scanner scanner = new Scanner(System.in);

         HashMap<String, HashMap<String, Object>> barangMilikPengguna = new HashMap<>();

         // Filter barang milik pengguna aktif dari produkMap
         for (Map.Entry<String, HashMap<String, Object>> entry : produkMap.entrySet()) {
             String id_produk = entry.getKey();
             HashMap<String, Object> detailBarang = entry.getValue();

             // Validasi kepemilikan barang menggunakan id_pengguna
             if (penggunaAktif.equals(detailBarang.get("id_pengguna"))) {
                 barangMilikPengguna.put(id_produk, detailBarang);
             }
         }

         // Tampilkan daftar barang milik pengguna
         if (barangMilikPengguna.isEmpty()) {
             System.out.println("Tidak ada barang yang bisa diatur stoknya. Anda belum memiliki barang.");
             return;
         }

         System.out.println("\n=== Daftar Barang Anda ===");
         int index = 1;
         HashMap<Integer, String> indexToIdProduk = new HashMap<>(); // Untuk menyimpan pilihan indeks ke Id_produk
         for (Map.Entry<String, HashMap<String, Object>> entry : barangMilikPengguna.entrySet()) {
             String id_produk = entry.getKey();
             HashMap<String, Object> detailBarang = entry.getValue();
             System.out.println(index + ". ID Produk: " + id_produk +
                     ", Nama: " + detailBarang.get("nama_produk") +
                     ", Stok: " + detailBarang.get("Jumlah_produk"));
             indexToIdProduk.put(index, id_produk);
             index++;
         }

         // Pilih barang yang stoknya ingin diatur
         System.out.print("\nPilih barang yang ingin diatur stoknya (masukkan nomor): ");
         int pilihan = scanner.nextInt();
         scanner.nextLine(); // Clear buffer

         if (!indexToIdProduk.containsKey(pilihan)) {
             System.out.println("Pilihan tidak valid.");
             return;
         }

         // Ambil ID produk yang dipilih
         String idBarangDipilih = indexToIdProduk.get(pilihan);
         HashMap<String, Object> barangDipilih = barangMilikPengguna.get(idBarangDipilih);

         System.out.println("\nBarang dipilih: " + barangDipilih.get("nama_produk"));
         System.out.println("Stok saat ini: " + barangDipilih.get("Jumlah_produk"));

         // Masukkan jumlah perubahan stok
         System.out.print("Masukkan perubahan stok (positif untuk menambah, negatif untuk mengurangi): ");
         int perubahan = scanner.nextInt();
         scanner.nextLine(); // Clear buffer

         // Validasi bahwa perubahan stok tidak membuat stok menjadi negatif
         int stokBaru = (int) barangDipilih.get("Jumlah_produk") + perubahan;
         if (stokBaru < 0) {
             System.out.println("Perubahan stok tidak valid. Stok barang tidak boleh negatif.");
             return;
         }

         // Konfirmasi perubahan stok
         System.out.println("Perubahan stok: Stok awal = " + barangDipilih.get("Jumlah_produk") +
                 ", Stok baru = " + stokBaru);
         System.out.print("Apakah Anda yakin ingin memperbarui stok barang ini? (Y/N): ");
         String konfirmasi = scanner.nextLine();

         if (!konfirmasi.equalsIgnoreCase("Y")) {
             System.out.println("Perubahan stok dibatalkan.");
             return;
         }

         // Perbarui stok barang
         barangDipilih.put("Jumlah_produk", stokBaru);
         produkMap.put(idBarangDipilih, barangDipilih); // Update produkMap
         System.out.println("Stok barang berhasil diperbarui.");

     }

     public void Terima_pembayaran(String Id_pesanan) {
         if (Id_pesanan == null || Id_pesanan.isEmpty()) {
             System.out.println("ID Pesanan tidak valid.");
             return;
         }

         // Periksa apakah pesanan ada di pesananMap
         if (!pesananMap.containsKey(Id_pesanan)) {
             System.out.println("Pesanan dengan ID " + Id_pesanan + " tidak ditemukan.");
             return;
         }

         HashMap<String, String> pesanan = pesananMap.get(Id_pesanan);
         // Ambil data pesanan berdasarkan ID pesanan
         String id_penjual = pesanan.get("id_penjual");
         String statusPesanan = pesanan.get("status");
         int hargaPesanan = Integer.parseInt(pesanan.get("harga"));

         // Periksa apakah status pesanan sudah diterima oleh pembeli
         if (!"DITERIMA".equalsIgnoreCase(statusPesanan)) {
             System.out.println("Pembayaran tidak dapat diterima karena pesanan belum diterima oleh pembeli.");
             return;
         }

         // Validasi akun penjual untuk menambahkan saldo
         if (id_penjual == null || id_penjual.isEmpty()) {
             System.out.println("ID Penjual di pesanan tidak valid.");
             return;
         }

         // Tambahkan saldo penjual sesuai dengan harga barang
         if (!produkMap.containsKey(id_penjual)) {
             System.out.println("Penjual dengan ID " + id_penjual + " tidak ditemukan.");
             return;
         }

         // Asumsikan ada data penjual dengan saldo yang tersimpan
         HashMap<String, Object> detailPenjual = produkMap.get(id_penjual);

         // Ambil saldo awal dan perbarui
         int saldoAwal = (int) detailPenjual.getOrDefault("saldo", 0);
         int saldoBaru = saldoAwal + hargaPesanan;
         detailPenjual.put("saldo", saldoBaru);
         System.out.println("Saldo berhasil diperbarui. Saldo baru penjual dengan ID " + id_penjual + " adalah: " + saldoBaru);

         // Update produkMap dengan detail penjual baru
         produkMap.put(id_penjual, detailPenjual);
     }

 }
