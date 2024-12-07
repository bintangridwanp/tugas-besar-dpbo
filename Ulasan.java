package com.mycompany.tubesdpbokel4;

import java.util.List;

public class Ulasan {
    private String Id_pembeli;
    private String Tanggal;
    private int Rating;
    private String Deskripsi_ulasan;

    public Ulasan(String Id_pembeli, String Tanggal, int Rating, String Deskripsi_ulasan) {
        this.Id_pembeli = Id_pembeli;
        this.Tanggal = Tanggal;
        this.Rating = Rating;
        this.Deskripsi_ulasan = Deskripsi_ulasan;
    }

    public String getId_pembeli() {
        return Id_pembeli;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public int getRating() {
        return Rating;
    }

    public String getDeskripsi_ulasan() {
        return Deskripsi_ulasan;
    }

    public void setDeskripsi_ulasan(String Deskripsi_ulasan) {
        this.Deskripsi_ulasan = Deskripsi_ulasan;
    }

    public static Ulasan Buat_ulasan(String Id_pembeli, String Tanggal, int Rating, String Deskripsi_ulasan) {
        return new Ulasan(Id_pembeli, Tanggal, Rating, Deskripsi_ulasan);
    }

    public void Edit_ulasan(String Deskripsi_ulasan) {
        this.setDeskripsi_ulasan(Deskripsi_ulasan);
    }

    public static void Hapus_ulasan(List<Ulasan> ulasanList, String Id_pembeli, String Tanggal) {
        ulasanList.removeIf(ulasan -> ulasan.getId_pembeli().equals(Id_pembeli) && ulasan.getTanggal().equals(Tanggal));
    }
}