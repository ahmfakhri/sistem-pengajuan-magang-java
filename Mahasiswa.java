public class Mahasiswa extends User {
    private String npm;
    private String nama;
    private String no_hp;
    private double ipk;

    public Mahasiswa(int id, String username, String email, String password,
                     String npm, String nama, String no_hp, double ipk) {

        super(id, username, email, password, "Mahasiswa");

        this.npm = npm;
        this.nama = nama;
        this.no_hp = no_hp;
        this.ipk = ipk;
    }

    public String getNama() {
        return nama;
    }

    public String getNpm() {
        return npm;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public double getIpk() {
        return ipk;
    }

    public Pengajuan ajukanMagang(Perusahaan perusahaan) {
        return new Pengajuan(this, perusahaan);
    }

    public void lihatPengajuan(java.util.ArrayList<Pengajuan> listPengajuan) {
        boolean ada = false;
        
        for (Pengajuan p : listPengajuan) {
            if (p.getMahasiswa() == this) {
                System.out.println("\n=== DATA PENGAJUAN ===");
                System.out.println("Perusahaan : " + p.getPerusahaan().getNama());
                System.out.println("Status : " + p.getStatus());
                ada = true;
            }
        }
        if (!ada) {
            System.out.println("Belum ada data pengajuan.");
        }
    }

    public void lihatMagang(java.util.ArrayList<Magang> listMagang) {
        boolean ada = false;
        for (Magang m : listMagang) {
            if (m.getMahasiswa() == this) {
                System.out.println("\n=== DATA MAGANG ===");
                System.out.println("Perusahaan : " + m.getPerusahaan().getNama());
                System.out.println("Magang Aktif");
                System.out.println("------------------");
                ada = true;
            }
        }
            if (!ada) {
                System.out.println("Belum ada data magang.");
            }
        
    }
}