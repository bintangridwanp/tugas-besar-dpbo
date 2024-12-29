package tubes.main;

import akun.ManajerAkun;
import pengguna.PembeliPenjual;
import produk.Produk;
import transaksi.Pemesanan;
import utils.Utils;

public class Menu {
    private ManajerAkun manajerAkun = new ManajerAkun();
    private PembeliPenjual penggunaAktif = null;
    private BarangManagement barangManagement; // Deklarasi objek barangManagement
    private AkunManagement akunManagement = new AkunManagement();

    // Konstruktor untuk menginisialisasi barangManagement dengan manajerAkun
    public Menu() {
        this.barangManagement = new BarangManagement(manajerAkun);
    }

    public void run() {
        int menu = printMenu();
        while (menu != 0) {
            switch (menu) {
                case 1:
                    akunManagement.handleRegistrasi();
                    break;
                case 2:
                    akunManagement.handleLogin();
                    // Sinkronisasi pengguna aktif
                    penggunaAktif = akunManagement.getPenggunaAktif();
                    break;
                case 3:
                    akunManagement.handleLogout();
                    // Reset pengguna aktif setelah logout
                    penggunaAktif = akunManagement.getPenggunaAktif();
                    break;
                case 4:
                    barangManagement.lihatBarangJualan();
                    break;
                case 5:
                    barangManagement.handlePembelian(penggunaAktif);
                    break;
                case 6:
                    barangManagement.checkoutPembelian(penggunaAktif);
                    break;
                case 7:
                    barangManagement.lacakBarang(penggunaAktif);
                    break;
                case 8:
                    barangManagement.reviewProduk(penggunaAktif);
                    break;
                case 9:
                    barangManagement.cekBarangJualan(penggunaAktif);
                    break;
                case 10:
                    barangManagement.tambahBarang(penggunaAktif);
                    break;
                case 11:
                    barangManagement.perbaruiStokBarang(penggunaAktif);
                    break;
                case 12:
                    barangManagement.lihatReviewJualan(penggunaAktif);
                    break;
                case 13:
                    barangManagement.chat(penggunaAktif);
                    break;
                case 14:
                    akunManagement.daftarPengguna();
                    break;
                case 15:
                    barangManagement.ubahStatusPengiriman(penggunaAktif);
                    break;
                default:
                    System.out.println("Menu tidak valid.");
                    break;
            }
            menu = printMenu();
        }
        System.out.println("Program keluar.");
    }


    public int printMenu() {
        int menu;
        System.out.println("\n================== Daftar Menu ==================");
        if (penggunaAktif != null) {
            System.out.println("Akun sedang login: " + penggunaAktif.getUsername());
        } else {
            System.out.println("Belum ada akun yang login.");
        }
	System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Logout");
        System.out.println("4. Daftar Barang Yang Dijual");
        System.out.println("5. Beli Barang");
        System.out.println("6. Checkout Pembelian");
        System.out.println("7. Lacak Barang Pembelian");
        System.out.println("8. Review Produk Pembelian");
        System.out.println("9. Cek Barang Jualan Anda");
        System.out.println("10. Tambah Barang yang Dijual");
        System.out.println("11. Perbarui Stok Barang");
        System.out.println("12. Lihat Review Jualan");
        System.out.println("13. Chat");
        System.out.println("14. [System] Daftar Akun Pengguna");
        System.out.println("15. Ubah Status Pengiriman Barang");
        System.out.println("0. Keluar");
        System.out.println("=================================================");
        System.out.print("> Input Menu : ");
        menu = Utils.inputInt();
        return menu;
    }
}
