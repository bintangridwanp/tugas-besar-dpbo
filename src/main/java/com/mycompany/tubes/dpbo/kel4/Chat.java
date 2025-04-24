/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes.dpbo.kel4;

import java.util.ArrayList;

public class Chat {
    private String idPembeli;
    private String namaPembeli;
    private String idPenjual;
    private String namaPenjual;
    private ArrayList<String> riwayatChat;

    public Chat(String idPembeli, String namaPembeli, String idPenjual, String namaPenjual) {
        this.idPembeli = idPembeli;
        this.namaPembeli = namaPembeli;
        this.idPenjual = idPenjual;
        this.namaPenjual = namaPenjual;
        this.riwayatChat = new ArrayList<>();
    }

    public void tambahChat(String pengirim, String pesan) {
        String chatEntry = pengirim + ": " + pesan;
        this.riwayatChat.add(chatEntry);
        // Simpan chat ke database
    }

    public void lihatRiwayatChat() {
        System.out.println("Riwayat Chat:");
        for (String chat : this.riwayatChat) {
            System.out.println(chat);
        }
    }

    public void kirimPesanPembeli(String pesan) {
        this.tambahChat(this.namaPembeli, pesan);
    }

    public void kirimPesanPenjual(String pesan) {
        this.tambahChat(this.namaPenjual, pesan);
    }
}
