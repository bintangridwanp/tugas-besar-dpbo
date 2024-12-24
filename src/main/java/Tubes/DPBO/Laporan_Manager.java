/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;

import Tubes.DPBO.Util.UtilityClass;
import java.util.LinkedList;

/**
 *
 * @author Zuhri
 */
public class Laporan_Manager {
    private LinkedList<Report_Pengguna> ListLaporanBaru = new LinkedList<>();
    private LinkedList<Report_Pengguna> ListLaporanSelesai = new LinkedList<>();

    public LinkedList<Report_Pengguna> getListLaporan() {
        return ListLaporanBaru;
    }
    
    public void Buat_Laporan(String idPenggunaPelapor, String idPenggunaTerlapor, String deskripsiLaporan) {
        String waktuPelaporan = UtilityClass.Waktu_Sekarang();
        String idLaporan = UtilityClass.generateID("LAP");

        Report_Pengguna laporan = new Report_Pengguna(
            idLaporan,
            idPenggunaPelapor,
            idPenggunaTerlapor,
            deskripsiLaporan,
            waktuPelaporan,
            Report_Pengguna.ReportStatus.PENDING
        );

        ListLaporanBaru.add(laporan);
        System.out.println("Laporan berhasil dibuat dengan ID: " + idLaporan);
    }

    public void inisialisasiLaporanDummy() {
        String[] pelapor = {"USR01", "USR02", "USR03", "USR04", "USR05"};
        String[] terlapor = {"USR06", "USR07", "USR08", "USR09", "USR10"};
        String[] deskripsi = {
            "Pelanggaran aturan komunitas.",
            "Spam di komentar.",
            "Konten tidak pantas.",
            "Akun terindikasi penipuan.",
            "Penggunaan bahasa kasar.",
            "Menyebarkan informasi palsu.",
            "Penggunaan akun ganda.",
            "Pelaporan aktivitas mencurigakan.",
            "Penyalahgunaan sistem.",
            "Melanggar kebijakan privasi.",
            "Menyebarkan malware.",
            "Penggunaan identitas palsu.",
            "Spam berulang kali.",
            "Perilaku tidak pantas di grup.",
            "Melanggar hak cipta."
        };

        for (int i = 0; i < 15; i++) {
            String idPelapor = pelapor[i % pelapor.length];
            String idTerlapor = terlapor[i % terlapor.length];
            String laporanDeskripsi = deskripsi[i % deskripsi.length];

            Buat_Laporan(idPelapor, idTerlapor, laporanDeskripsi);
        }
    }
    
    public void ViewLaporan() {
        if (ListLaporanBaru.isEmpty()) {
            System.out.println("Tidak ada laporan yang tersedia.");
        } else {
            System.out.println("Daftar Laporan:");
            for (Report_Pengguna laporan : ListLaporanBaru) {
                System.out.println("ID Laporan: " + laporan.getIdLaporan());
                System.out.println("Pelapor: " + laporan.getIdPenggunaPelapor());
                System.out.println("Terlapor: " + laporan.getIdPenggunaTerlapor());
                System.out.println("Deskripsi: " + laporan.getDeskripsiLaporan());
                System.out.println("Waktu: " + laporan.getWaktuPelaporan());
                System.out.println("Status: " + laporan.getStatusLaporan());
                System.out.println("--------------------------");
            }
        }
    }

    public void Hapus_Laporan(String idLaporan) {
        Report_Pengguna laporanToRemove = null;

        for (Report_Pengguna laporan : ListLaporanBaru) {
            if (laporan.getIdLaporan().equals(idLaporan)) {
                laporanToRemove = laporan;
                break;
            }
        }

        if (laporanToRemove != null) {
            ListLaporanBaru.remove(laporanToRemove);
            System.out.println("Laporan dengan ID " + idLaporan + " berhasil dihapus.");
        } else {
            System.out.println("Laporan dengan ID " + idLaporan + " tidak ditemukan.");
        }
    }

    public void updateStatusLaporan(String idLaporan, Report_Pengguna.ReportStatus newStatus) {
        for (Report_Pengguna laporan : ListLaporanBaru) {
            if (laporan.getIdLaporan().equals(idLaporan)) {
                laporan.setStatusLaporan(newStatus);
                System.out.println("Status laporan dengan ID " + idLaporan + " berhasil diubah menjadi " + newStatus);
                return;
            }
        }
        System.out.println("Laporan dengan ID " + idLaporan + " tidak ditemukan.");
    }

    public void pindahkanLaporan(String idLaporan) {
        Report_Pengguna laporanToMove = null;

        for (Report_Pengguna laporan : ListLaporanBaru) {
            if (laporan.getIdLaporan().equals(idLaporan)) {
                laporanToMove = laporan;
                break;
            }
        }

        if (laporanToMove != null) {
            if (laporanToMove.getStatusLaporan() == Report_Pengguna.ReportStatus.RESOLVED || 
                laporanToMove.getStatusLaporan() == Report_Pengguna.ReportStatus.CLOSED) {
                
                ListLaporanBaru.remove(laporanToMove);
                ListLaporanSelesai.add(laporanToMove);
                System.out.println("Laporan dengan ID " + idLaporan + " berhasil dipindahkan ke daftar laporan selesai.");
            } else {
                System.out.println("Laporan dengan ID " + idLaporan + " tidak memiliki status RESOLVED atau CLOSED.");
            }
        } else {
            System.out.println("Laporan dengan ID " + idLaporan + " tidak ditemukan.");
        }
    }

    public void ViewLaporanSelesai() {
        if (ListLaporanSelesai.isEmpty()) {
            System.out.println("Tidak ada laporan selesai yang tersedia.");
        } else {
            System.out.println("Daftar Laporan Selesai:");
            for (Report_Pengguna laporan : ListLaporanSelesai) {
                System.out.println("ID Laporan \t: " + laporan.getIdLaporan());
                System.out.println("Pelapor \t: " + laporan.getIdPenggunaPelapor());
                System.out.println("Terlapor \t: " + laporan.getIdPenggunaTerlapor());
                System.out.println("Deskripsi \t: " + laporan.getDeskripsiLaporan());
                System.out.println("Waktu \t: " + laporan.getWaktuPelaporan());
                System.out.println("Status \t: " + laporan.getStatusLaporan());
                System.out.println("--------------------------");
            }
        }
    }
}
