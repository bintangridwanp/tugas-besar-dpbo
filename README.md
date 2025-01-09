# Platform Jual Beli Barang Bekas - Tugas Besar DPBO

## Deskripsi
Platform ini dirancang untuk memfasilitasi proses jual beli barang bekas secara efisien dan mudah. Dengan antarmuka yang ramah pengguna, platform ini memungkinkan pengguna untuk:
- Memasarkan barang bekas mereka.
- Mencari barang yang diinginkan dengan cepat menggunakan fitur pencarian canggih.
- Melakukan transaksi yang aman dan transparan.

Platform ini bertujuan untuk mempromosikan praktik penggunaan ulang barang guna mengurangi limbah dan mendukung keberlanjutan. Dengan pendekatan ini, kami berharap dapat menciptakan ekosistem perdagangan barang bekas yang bermanfaat bagi pengguna dan lingkungan.

## Implementasi Materi OOP
Berikut adalah konsep OOP yang diterapkan dalam proyek ini:

### 1. **Encapsulation**
- **Getter dan Setter:**
  - Digunakan dalam kelas seperti `Produk` dan `Pengguna` untuk mengakses dan memodifikasi atribut secara aman.
- **Akses Modifier:**
  - `private` digunakan untuk atribut untuk menjaga integritas data.
  - `public` digunakan untuk metode yang perlu diakses oleh kelas lain.

### 2. **Inheritance**
- Kelas `Pengguna` menjadi superclass untuk kelas `PembeliPenjual`, yang mewarisi atribut dan metode dasar dari `Pengguna`.

### 3. **Polymorphism**
- **Overriding:**
  - Metode `toString` di-override pada kelas seperti `Produk` untuk menampilkan informasi dengan format tertentu.
- **Interface Polimorfisme:**
  - Kelas `Notifikasi` mengimplementasikan `NotifikasiInterface` untuk mendukung variasi notifikasi.

### 4. **Dynamic Binding**
- Metode yang dipanggil pada objek akan diputuskan saat runtime, seperti pada objek bertipe `Pengguna` yang sebenarnya merupakan instance `PembeliPenjual`.

### 5. **Abstract Class**
- Kelas abstrak digunakan untuk mendefinisikan struktur dasar tanpa implementasi penuh, seperti pada `Pengguna`.

### 6. **Collection Framework**
- `ArrayList` digunakan untuk menyimpan daftar produk dan pengguna.
- `HashMap` digunakan untuk menyimpan data pasangan kunci-nilai tertentu, seperti pencocokan nama pengguna dan kata sandi.

### 7. **Exception Handling**
- **Try-Catch:**
  - Digunakan untuk menangani kesalahan pada login atau input pengguna.
- **Custom Exception:**
  - Kelas `LoginException` digunakan untuk memberikan pesan khusus saat pengguna gagal login.
- **Throws:**
  - Digunakan untuk melemparkan exception dari metode tertentu, seperti pada validasi input.

### 8. **Method Overloading**
- Metode `addProduk` memiliki beberapa versi untuk menangani parameter yang berbeda.

### 9. **Keyword `this`**
- Digunakan untuk membedakan atribut kelas dan parameter dalam constructor atau metode.

## Cara Penggunaan
1. **Clone Repository**
   Clone repository ini ke lokal Anda:
   ```bash
   git clone https://github.com/bintangridwanp/tugas-besar-dpbo.git
   cd bintangridwanp-tugas-besar-dpbo
   ```

2. **Buka Proyek di IDE**
   - Pastikan Anda menggunakan IDE seperti IntelliJ IDEA atau NetBeans.
   - Impor proyek sebagai Maven Project.

3. **Jalankan Program**
   - Navigasikan ke kelas `MainTest.java` di `src/main/java/tubes/main/`.
   - Jalankan file ini untuk memulai aplikasi.

4. **Gunakan Aplikasi**
   - Masuk sebagai pengguna dengan nama pengguna dan kata sandi.
   - Tambahkan, cari, atau beli produk sesuai kebutuhan.
   - Sistem akan memberikan notifikasi dan menangani kesalahan seperti login gagal.

5. **Unit Testing**
   - Unit test untuk fungsi-fungsi utama dapat dijalankan melalui file `MainTest.java`.

6. **Struktur Kode**
   - **Manajemen Akun:** Kode terkait login dan pembuatan akun berada di paket `akun`.
   - **Produk:** Semua operasi terkait produk, seperti menambah atau mencari, ada di paket `produk`.
   - **Transaksi:** Paket `transaksi` menangani pemesanan dan pembelian barang.

---

Terima kasih telah menggunakan platform jual beli barang bekas ini! Jika ada pertanyaan atau saran, jangan ragu untuk menghubungi pengembang melalui repository ini.


