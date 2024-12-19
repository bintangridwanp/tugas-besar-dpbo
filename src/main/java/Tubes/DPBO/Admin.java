/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;

/**
 *
 * @author Zuhri
 */
public class Admin {
    private final String Nama_Pengguna = "Admin123";
    private final String Kata_Sandi = "Admin123";
    
    public String login(String Nama_Pengguna, String Kata_Sandi) {
        if (this.Nama_Pengguna.equals(Nama_Pengguna)){
            if (this.Kata_Sandi.equals(Kata_Sandi)) {
                return "login Berhasil";
            }
            
            return "Login Gagal kata sandi salah";
        }
        
        return "Login Gagal username salah";   
    }
    
}
