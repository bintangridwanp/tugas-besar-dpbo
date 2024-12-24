/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;

/**
 *
 * @author Zuhri
 */
public class Report_Pengguna {
    private String idLaporan;
    private String idPenggunaPelapor;
    private String idPenggunaTerlapor;
    private String deskripsiLaporan;
    private String waktuPelaporan;
    private ReportStatus statusLaporan;

    public Report_Pengguna(String idLaporan, String idPenggunaPelapor, String idPenggunaTerlapor, String deskripsiLaporan, String waktuPelaporan, ReportStatus statusLaporan) {
        this.idLaporan = idLaporan;
        this.idPenggunaPelapor = idPenggunaPelapor;
        this.idPenggunaTerlapor = idPenggunaTerlapor;
        this.deskripsiLaporan = deskripsiLaporan;
        this.waktuPelaporan = waktuPelaporan;
        this.statusLaporan = statusLaporan;
    }

    public String getIdLaporan() {
        return idLaporan;
    }

    public String getIdPenggunaPelapor() {
        return idPenggunaPelapor;
    }

    public String getIdPenggunaTerlapor() {
        return idPenggunaTerlapor;
    }

    public String getDeskripsiLaporan() {
        return deskripsiLaporan;
    }

    public String getWaktuPelaporan() {
        return waktuPelaporan;
    }

    public ReportStatus getStatusLaporan() {
        return statusLaporan;
    }

    public void setStatusLaporan(ReportStatus statusLaporan) {
        this.statusLaporan = statusLaporan;
    }

    public enum ReportStatus {
        PENDING,
        IN_PROGRESS,
        RESOLVED,
        REJECTED,
        CLOSED,
        ON_HOLD,
    }
}