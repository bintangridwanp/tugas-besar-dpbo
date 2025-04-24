/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes.dpbo.kel4;

import java.util.ArrayList;

public class Pelacakan_Barang {
    private String idPesanan;
    private String statusPesanan;
    private ArrayList<String> historiPesanan;

    public void pelacakBarang(String idBarang) {
        // Ambil data status dan history pesanan dari database
        // Simpan ke atribut statusPesanan dan historiPesanan
        System.out.println("Barang\t: " + idBarang);
        System.out.println("Status\t: " + this.statusPesanan);
        System.out.println("History\t:");
        for (String history : this.historiPesanan) {
            System.out.println(history);
        }
    }
}
