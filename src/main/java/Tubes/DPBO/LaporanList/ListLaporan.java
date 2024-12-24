/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO.LaporanList;

import Tubes.DPBO.Report_Pengguna;
import java.util.LinkedList;

/**
 *
 * @author Zuhri
 */
public abstract class ListLaporan {
    protected LinkedList<Report_Pengguna> listLaporan = new LinkedList<>();

    public void ViewLaporan() {
        if (listLaporan.isEmpty()) {
            System.out.println("Tidak ada laporan yang tersedia.");
        } else {
            for (Report_Pengguna laporan : listLaporan) {
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
    
    public boolean addLaporan(Report_Pengguna laporan) {
        for (Report_Pengguna existingLaporan : listLaporan) {
            if (existingLaporan.getIdLaporan().equals(laporan.getIdLaporan())) {
                System.out.println("Laporan dengan ID " + laporan.getIdLaporan() + " sudah ada dalam daftar.");
                return false;
            }
        }
        listLaporan.add(laporan);
        System.out.println("Laporan dengan ID " + laporan.getIdLaporan() + " berhasil ditambahkan.");
        return true;
    }

    public Report_Pengguna findAndRemoveLaporan(String idLaporan) {
        for (Report_Pengguna laporan : listLaporan) {
            if (laporan.getIdLaporan().equals(idLaporan)) {
                listLaporan.remove(laporan);
                return laporan;
            }
        }
        return null;
    }
    
    public abstract void updateStatusLaporan(String idLaporan, Report_Pengguna.ReportStatus newStatus);
}
