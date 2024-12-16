package com.mycompany.tubes.dpbo.kel4;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pengguna {
    private String Id_pengguna;
    private String Username;
    private String Password;
    private String Nama;
    private String Alamat;

    public Pengguna(String id_pengguna, String username, String password, String nama, String alamat) {
        Id_pengguna = id_pengguna;
        Username = username;
        Password = password;
        Nama = nama;
        Alamat = alamat;
    }

    public String getId_pengguna() {
        return Id_pengguna;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getNama() {
        return Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setId_pengguna(String id_pengguna) {
        Id_pengguna = id_pengguna;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }
    
    public abstract void Daftar (ArrayList<Pengguna> PenggunaList);
    public abstract boolean Masuk (String Username, String password);
    public abstract void Keluar(String Id_pengguna);
    // public abstract void Pencarian_barang(String nama_barang);
    public abstract void Validasi(String Id_pengguna);
    // public abstract void Edit_profile(String Id_pengguna, String data_baru);
    
}
