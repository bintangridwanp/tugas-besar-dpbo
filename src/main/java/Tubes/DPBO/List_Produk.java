package Tubes.DPBO;

import java.util.ArrayList;
import java.util.Collections;

public class List_Produk {
    private ArrayList<Produk> produkList;

    // Konstruktor
    public List_Produk() {
        this.produkList = new ArrayList<>();
        this.Inisialisasi_Data_Dummy();
    }

    // Inisialisasi data dummy
    public void Inisialisasi_Data_Dummy() {
        produkList.add(new Produk("P001", "Laptop", 15000000, 10, "Jakarta", "Laptop untuk desain grafis"));
        produkList.add(new Produk("P002", "Smartphone", 5000000, 20, "Bandung", "Smartphone 5G terbaru"));
        produkList.add(new Produk("P003", "Mouse", 200000, 50, "Surabaya", "Mouse wireless"));
        produkList.add(new Produk("P004", "Keyboard", 600000, 30, "Medan", "Keyboard mechanical RGB"));
        produkList.add(new Produk("P005", "Monitor", 2000000, 15, "Makassar", "Monitor 24 inch 144Hz"));
        produkList.add(new Produk("P006", "Headphone", 1000000, 25, "Palembang", "Headphone noise-cancelling"));
        produkList.add(new Produk("P007", "Tablet", 4000000, 18, "Denpasar", "Tablet untuk membaca e-book"));
        produkList.add(new Produk("P008", "Printer", 1200000, 12, "Yogyakarta", "Printer all-in-one"));
        produkList.add(new Produk("P009", "Router", 800000, 40, "Semarang", "Router dual-band WiFi 6"));
        produkList.add(new Produk("P010", "Hard Drive", 1000000, 35, "Malang", "Hard drive eksternal 1TB"));
        produkList.add(new Produk("P011", "SSD", 1500000, 22, "Manado", "SSD NVMe 500GB"));
        produkList.add(new Produk("P012", "Power Bank", 300000, 60, "Pontianak", "Power bank 20000mAh"));
        produkList.add(new Produk("P013", "Speaker", 700000, 27, "Jayapura", "Speaker Bluetooth"));
        produkList.add(new Produk("P014", "Webcam", 400000, 18, "Ambon", "Webcam Full HD"));
        produkList.add(new Produk("P015", "Smartwatch", 2500000, 20, "Banjarmasin", "Smartwatch untuk olahraga"));
        produkList.add(new Produk("P016", "Game Console", 7000000, 8, "Balikpapan", "Game console terbaru"));
        produkList.add(new Produk("P017", "Microphone", 500000, 25, "Bandar Lampung", "Microphone untuk podcast"));
        produkList.add(new Produk("P018", "Camera", 8000000, 10, "Pekanbaru", "Camera mirrorless"));
        produkList.add(new Produk("P019", "Tripod", 150000, 50, "Tangerang", "Tripod untuk kamera"));
        produkList.add(new Produk("P020", "RAM", 1200000, 30, "Depok", "RAM DDR4 16GB"));
        produkList.add(new Produk("P021", "GPU", 5000000, 5, "Bogor", "GPU RTX 3060"));
        produkList.add(new Produk("P022", "PSU", 1200000, 12, "Padang", "PSU modular 650W"));
        produkList.add(new Produk("P023", "Motherboard", 2500000, 10, "Samarinda", "Motherboard ATX"));
        produkList.add(new Produk("P024", "CPU", 4000000, 8, "Malang", "Processor Ryzen 5"));
        produkList.add(new Produk("P025", "Cooler", 700000, 20, "Surakarta", "Cooler untuk CPU"));
        produkList.add(new Produk("P026", "Laptop Stand", 300000, 35, "Bengkulu", "Stand untuk laptop"));
        produkList.add(new Produk("P027", "Docking Station", 1000000, 18, "Mataram", "Docking station USB-C"));
        produkList.add(new Produk("P028", "Graphics Tablet", 2500000, 10, "Tasikmalaya", "Tablet untuk desain grafis"));
        produkList.add(new Produk("P029", "VR Headset", 6000000, 5, "Cirebon", "Headset VR terbaru"));
        produkList.add(new Produk("P030", "External SSD", 2000000, 15, "Palu", "SSD eksternal 1TB"));
    }

    // Menampilkan daftar produk secara random
    public void Tampilkan_Produk_Secara_Random() {
        if (produkList.isEmpty()) {
            System.out.println("Tidak ada produk yang tersedia.");
            return;
        }

        // Mengacak daftar produk
        //Collections.shuffle(produkList);

        System.out.println("Daftar produk yang ada:");
        int nomor = 1;
        for (Produk produk : produkList) {
            System.out.println(nomor + ". " + produk.getNama_barang() + " ***** " + produk.getHarga() + " ***** " + produk.getLokasi() + " ***** " + produk.getDeskripsi());
            nomor++;
        }
    }
}
