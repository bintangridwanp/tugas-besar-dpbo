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
public class LaporanON_HOLD extends ListLaporan{
    @Override
    public void updateStatusLaporan(String idLaporan, Report_Pengguna.ReportStatus newStatus) {
        for (Report_Pengguna laporan : listLaporan) {
            if (laporan.getIdLaporan().equals(idLaporan)) {
                if (newStatus == Report_Pengguna.ReportStatus.IN_PROGRESS || 
                    newStatus == Report_Pengguna.ReportStatus.RESOLVED || 
                    newStatus == Report_Pengguna.ReportStatus.REJECTED) {
                    laporan.setStatusLaporan(newStatus);
                    System.out.println("Status laporan dengan ID " + idLaporan + " berhasil diperbarui menjadi " + newStatus);
                } else {
                    System.out.println("Status tidak valid untuk laporan PENDING.");
                }
                return;
            }
        }
        System.out.println("Laporan dengan ID " + idLaporan + " tidak ditemukan.");
    }
}
