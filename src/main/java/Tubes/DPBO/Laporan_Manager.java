/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;

import Tubes.DPBO.LaporanList.*;
import Tubes.DPBO.Util.UtilityClass;

/**
 *
 * @author Zuhri
 */
public class Laporan_Manager {
    private ListLaporan listPending = new LaporanPENDING();
    private ListLaporan listInProgress = new LaporanIN_PROGRESS();
    private ListLaporan listResolved = new LaporanRESOLVED();
    private ListLaporan listRejected = new LaporanREJECTED();
    private ListLaporan listOnHold = new LaporanON_HOLD();
    
    
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

        listPending.addLaporan(laporan);
        System.out.println("Laporan berhasil dibuat dengan ID: " + idLaporan);
    }

    public void ViewLaporan() {
        System.out.println("\n=== Daftar Laporan PENDING ===");
        listPending.ViewLaporan();

        System.out.println("\n=== Daftar Laporan IN_PROGRESS ===");
        listInProgress.ViewLaporan();

        System.out.println("\n=== Daftar Laporan RESOLVED ===");
        listResolved.ViewLaporan();

        System.out.println("\n=== Daftar Laporan REJECTED ===");
        listRejected.ViewLaporan();

        System.out.println("\n=== Daftar Laporan ON_HOLD ===");
        listOnHold.ViewLaporan();
    }

    public void updateStatusLaporan(String idLaporan, Report_Pengguna.ReportStatus newStatus) {
        Report_Pengguna laporan = null;

        laporan = listPending.findAndRemoveLaporan(idLaporan);
        if (laporan == null) laporan = listInProgress.findAndRemoveLaporan(idLaporan);
        if (laporan == null) laporan = listResolved.findAndRemoveLaporan(idLaporan);
        if (laporan == null) laporan = listRejected.findAndRemoveLaporan(idLaporan);
        if (laporan == null) laporan = listOnHold.findAndRemoveLaporan(idLaporan);

        if (laporan != null) {
            laporan.setStatusLaporan(newStatus);

            switch (newStatus) {
                case PENDING -> listPending.addLaporan(laporan);
                case IN_PROGRESS -> listInProgress.addLaporan(laporan);
                case RESOLVED -> listResolved.addLaporan(laporan);
                case REJECTED -> listRejected.addLaporan(laporan);
                case ON_HOLD -> listOnHold.addLaporan(laporan);
                case CLOSED -> System.out.println("Laporan dengan ID " + idLaporan + " ditutup.");
                default -> System.out.println("Status tidak valid.");
            }
            System.out.println("Status laporan dengan ID " + idLaporan + " berhasil diperbarui ke " + newStatus);
        } else {
            System.out.println("Laporan dengan ID " + idLaporan + " tidak ditemukan.");
        }
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
}
