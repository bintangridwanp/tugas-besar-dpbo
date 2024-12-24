/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO.LaporanList;
import Tubes.DPBO.Report_Pengguna;

/**
 *
 * @author Zuhri
 */
public class LaporanIN_PROGRESS extends ListLaporan {
    @Override
    public void updateStatusLaporan(String idLaporan, Report_Pengguna.ReportStatus newStatus) {
        for (Report_Pengguna laporan : listLaporan) {
            if (laporan.getIdLaporan().equals(idLaporan)) {
                if (newStatus == Report_Pengguna.ReportStatus.PENDING || 
                    newStatus == Report_Pengguna.ReportStatus.RESOLVED || 
                    newStatus == Report_Pengguna.ReportStatus.REJECTED || 
                    newStatus == Report_Pengguna.ReportStatus.ON_HOLD) {
                    laporan.setStatusLaporan(newStatus);
                    System.out.println("Status laporan dengan ID " + idLaporan + " berhasil diperbarui menjadi " + newStatus);
                } else {
                    System.out.println("Status tidak valid untuk laporan IN_PROGRESS.");
                }
                return;
            }
        }
        System.out.println("Laporan dengan ID " + idLaporan + " tidak ditemukan.");
    }

    public void Hapus_Laporan(String idLaporan, String idPenggunaPelapor) {
        Report_Pengguna laporanToRemove = null;

        for (Report_Pengguna laporan : listLaporan) {
            if (laporan.getIdLaporan().equals(idLaporan)) {
                if (laporan.getIdPenggunaPelapor().equals(idPenggunaPelapor)) {
                    laporanToRemove = laporan;
                } else {
                    System.out.println("Anda tidak memiliki izin untuk menghapus laporan ini.");
                    return;
                }
            }
        }

        if (laporanToRemove != null) {
            listLaporan.remove(laporanToRemove);
            System.out.println("Laporan dengan ID " + idLaporan + " berhasil dihapus.");
        } else {
            System.out.println("Laporan dengan ID " + idLaporan + " tidak ditemukan.");
        }
    }
}
