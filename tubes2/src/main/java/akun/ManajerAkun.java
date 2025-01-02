package akun;

import exception.LoginException;
import pengguna.Pengguna;
import pengguna.PembeliPenjual;
import java.util.HashMap;

public class ManajerAkun {
    private HashMap<String, Pengguna> daftarPengguna = new HashMap<>();

    public ManajerAkun() {
        daftarPengguna.put("user1", new PembeliPenjual("user1", "user1", "user1@gmail.com", "62811-2222-3333"));
        daftarPengguna.put("user2", new PembeliPenjual("user2", "user2", "user2@gmail.com", "62811-4444-5555"));
        daftarPengguna.put("user3", new PembeliPenjual("user3", "user3", "user3@gmail.com", "62811-6666-7777"));
    }
    
    public void register(String username, String password, String email, String noTelepon) {
        Pengguna user = new PembeliPenjual(username, password, email, noTelepon);
        daftarPengguna.put(username, user);
    }

    public Pengguna login(String username, String password) throws LoginException {
        Pengguna user = daftarPengguna.get(username);
        if (user != null && user.verifikasiPassword(password)) {
            return user;
        } else {
            throw new LoginException("Username atau password salah.");
        }
    }

    public HashMap<String, Pengguna> getDaftarPengguna() {
        return daftarPengguna;
    }
}
