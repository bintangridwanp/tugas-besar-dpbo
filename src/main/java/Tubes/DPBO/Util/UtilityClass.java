/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes.DPBO.Util;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 *
 * @author Zuhri
 */
public class UtilityClass {
    private static HashMap<String, Integer> prefixCounters = new HashMap<>();
    
    public static String Waktu_Sekarang() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public static String getStringInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextLine();
            } catch (NullPointerException e) {
                System.out.println("Input tidak valid. Harap masukkan lagi.");
            } catch (Exception e) {
                System.out.println("Ada kesalahan silakan coba lagi");
            }
        }     
    }
    
    public static int getIntInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            } catch (NullPointerException e) {
                System.out.println("Input tidak valid. Harap masukkan lagi.");
            } catch (Exception e) {
                System.out.println("Ada kesalahan silakan coba lagi");
            }
        }
    }
    
     public static String generateID(String prefix) {
        prefix = prefix.toUpperCase();
        prefixCounters.putIfAbsent(prefix, 0);
        int nextNumber = prefixCounters.get(prefix) + 1;
        prefixCounters.put(prefix, nextNumber);
        String formattedNumber = String.format("%02d", nextNumber);
        return prefix + "-" + formattedNumber;
    }
}
