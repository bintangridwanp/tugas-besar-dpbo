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
public class LaporanREJECTED extends ListLaporan {

    @Override
    public void updateStatusLaporan(String idLaporan, Report_Pengguna.ReportStatus newStatus) {
        for (Report_Pengguna laporan : listLaporan) {
            if (laporan.getIdLaporan().equals(idLaporan)) {
                if (newStatus == Report_Pengguna.ReportStatus.CLOSED) {
                    laporan.setStatusLaporan(newStatus);
                    System.out.println("Status laporan dengan ID " + idLaporan + " berhasil diperbarui menjadi CLOSED.");
                } else {
                    System.out.println("Hanya status CLOSED yang valid untuk laporan REJECTED.");
                }
                return;
            }
        }
        System.out.println("Laporan dengan ID " + idLaporan + " tidak ditemukan.");
    }
}

