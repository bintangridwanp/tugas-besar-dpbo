/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes.dpbo.kel4;

/**
 *
 * @author Zuhri
 */
public interface Diskon {
    public String getIdPengguna();
    public void tambahDiskon(String Id_pengguna, int Jumlah_diskon);
    public double calculateDiskon(double harga);
    public void hapusDiskon(String Id_pengguna);
}
