import java.util.ArrayList;

public class Dosen extends User {
    private String nidn;
    private String nama;

    public Dosen(int id, String username, String email, String password,
                 String nidn, String nama) {

        super(id, username, email, password, "Dosen");

        this.nidn = nidn;
        this.nama = nama;
    }

    public String getNidn() {
        return nidn;
    }

    public String getNama() {
        return nama;
    }

    // fitur utama
    public void lihatMahasiswaBimbingan(ArrayList<Magang> listMagang) {
        boolean ada = false;

        for (Magang m : listMagang) {
            if (m.getDosen() == this) {
                System.out.println("Mahasiswa : " + m.getMahasiswa().getNama());
                System.out.println("Perusahaan: " + m.getPerusahaan().getNama());
                System.out.println("------------------");
                ada = true;
            }
        }

        if (!ada) {
            System.out.println("Belum ada mahasiswa bimbingan.");
        }
    }
}