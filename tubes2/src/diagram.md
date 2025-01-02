classDiagram
direction BT
class AkunManagement {
  + AkunManagement() 
  + handleLogout() void
  + handleLogin() void
  + handleRegistrasi() void
  + daftarPengguna() void
   PembeliPenjual penggunaAktif
}
class BarangManagement {
  + BarangManagement(ManajerAkun) 
  + checkoutPembelian(PembeliPenjual) void
  + lacakBarang(PembeliPenjual) void
  + perbaruiStokBarang(PembeliPenjual) void
  + lihatBarangJualan() void
  + buatPenawaran(PembeliPenjual, Produk, double) void
  + tampilkanPenawaran() void
  + ubahStatusPengiriman(PembeliPenjual) void
  + tambahBarang(PembeliPenjual) void
  + lihatReviewJualan(PembeliPenjual) void
  + handlePembelian(PembeliPenjual) void
  + handleBuatPenawaran(PembeliPenjual) void
  + cariBarang(String) Produk
  + cekBarangJualan(PembeliPenjual) void
  + chat(PembeliPenjual) void
  + reviewProduk(PembeliPenjual) void
   ArrayList~Produk~ barangJualan
}
class Chat {
  + Chat(PembeliPenjual, PembeliPenjual, String) 
  + kirimPesan() void
  + tampilkanHistory(PembeliPenjual) void
}
class LoginException {
  + LoginException(String) 
}
class MainTest {
  + MainTest() 
  + main(String[]) void
}
class ManajerAkun {
  + ManajerAkun() 
  + login(String, String) Pengguna
  + register(String, String, String, String) void
   HashMap~String, Pengguna~ daftarPengguna
}
class Menu {
  + Menu() 
  + run() void
  + printMenu() int
}
class Notifikasi {
  + Notifikasi() 
  + kirimNotifikasi(String, String) void
  + lihatNotifikasi(String) void
}
class NotifikasiInterface {
<<Interface>>
  + kirimNotifikasi(String, String) void
  + lihatNotifikasi(String) void
}
class PembeliPenjual {
  + PembeliPenjual(String, String, String, String) 
  + tampilkanRole() void
  + tambahNotifikasi(String) void
  + tambahPemesanan(Pemesanan) void
  + tambahKeBarangJualan(Produk) void
  + clearKeranjang() void
  + tampilkanSemuaNotifikasi() void
  + tambahKeKeranjang(Produk, int) void
   ArrayList~Produk~ barangJualan
   Map~Produk, Integer~ keranjang
   ArrayList~Pemesanan~ daftarPemesanan
}
class Pemesanan {
  + Pemesanan(Produk, int, PembeliPenjual) 
  + toString() String
   String statusPengiriman
   PembeliPenjual pembeli
   int jumlah
   Produk produk
}
class Penawaran {
  + Penawaran(String, PembeliPenjual, Produk, double) 
  + tampilkanPenawaran() void
   String status
}
class Pengguna {
  + Pengguna(String, String) 
  + Pengguna(String, String, String, String) 
  + verifikasiPassword(String) boolean
  + tampilkanRole() void
   String password
   String noTelepon
   String username
   String email
}
class Produk {
  + Produk(String, String, double, PembeliPenjual) 
  + Produk(String, String, double, int, PembeliPenjual) 
  + Produk(String, String, double, int, String, String, PembeliPenjual) 
  + tambahStok(int) void
  + lihatReview() void
  + toString() String
  + tambahReview(Review) void
  + kurangiStok(int) void
   PembeliPenjual penjual
   String namaProduk
   double harga
   String lokasi
   int stok
   String deskripsi
   String idProduk
}
class Review {
  + Review(PembeliPenjual, int, String) 
  + toString() String
   PembeliPenjual pengguna
   String komentar
   int rating
}
class Utils {
  + Utils() 
  + inputInt() int
  + inputString() String
  + formatRupiah(double) String
  + clearBuffer() void
  + inputDouble() double
  + closeScanner() void
}

AkunManagement "1" *--> "manajerAkun 1" ManajerAkun 
AkunManagement "1" *--> "penggunaAktif 1" PembeliPenjual 
BarangManagement "1" *--> "manajerAkun 1" ManajerAkun 
BarangManagement "1" *--> "penawaranList *" Penawaran 
BarangManagement "1" *--> "barangJualan *" Produk 
Chat "1" *--> "pengirim 1" PembeliPenjual 
MainTest "1" *--> "menu 1" Menu 
ManajerAkun "1" *--> "daftarPengguna *" Pengguna 
Menu "1" *--> "akunManagement 1" AkunManagement 
Menu "1" *--> "barangManagement 1" BarangManagement 
Menu "1" *--> "manajerAkun 1" ManajerAkun 
Menu "1" *--> "penggunaAktif 1" PembeliPenjual 
Notifikasi  ..>  NotifikasiInterface 
PembeliPenjual "1" *--> "notifikasiList *" Notifikasi 
PembeliPenjual "1" *--> "daftarPemesanan *" Pemesanan 
PembeliPenjual  -->  Pengguna 
PembeliPenjual "1" *--> "keranjang *" Produk 
Pemesanan "1" *--> "pembeli 1" PembeliPenjual 
Pemesanan "1" *--> "produk 1" Produk 
Penawaran "1" *--> "pembeli 1" PembeliPenjual 
Penawaran "1" *--> "barang 1" Produk 
Produk "1" *--> "penjual 1" PembeliPenjual 
Produk "1" *--> "reviews *" Review 
Review "1" *--> "pengguna 1" PembeliPenjual 
