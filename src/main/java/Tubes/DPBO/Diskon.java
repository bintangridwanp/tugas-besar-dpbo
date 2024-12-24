package Tubes.DPBO;

public interface Diskon {

    public String getIdPengguna();

    public int getJumlah_diskon();

    public void setJumlah_diskon(int jumlah_diskon);

    public int Harga_Setelah_Diskon();

    public String toString();
}