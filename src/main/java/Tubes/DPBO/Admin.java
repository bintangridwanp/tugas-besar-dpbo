/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO;
import java.util.Random;
import java.util.Scanner;

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

    public int otp() {
        Random otp = new Random();
        return otp.nextInt(90000) + 10000;
    }

    public void Verifikasi_otp(int otp) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan OTP yang diterima: ");
        int userInput = scanner.nextInt();

        if (userInput == otp) {
            System.out.println("Verifikasi berhasil!");
        } else {
            System.out.println("Verifikasi gagal! OTP tidak cocok.");
        }
    }
    
}
