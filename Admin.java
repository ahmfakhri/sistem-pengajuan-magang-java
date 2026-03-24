import java.util.ArrayList;

public class Admin extends User {
    private String nama;

    public Admin(int id, String username, String email, String password, String nama) {
        super(id, username, email, password, "Admin");
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    // ================= PENGAJUAN =================
    public void prosesPengajuan(Pengajuan p, String status, String alasan, ArrayList<Magang> listMagang, Dosen dosen) {
        p.setStatus(status);
        p.setAlasan(alasan);

        if (status.equalsIgnoreCase("Diterima")) {
            listMagang.removeIf(m ->
            m.getMahasiswa() == p.getMahasiswa() &&
            m.getPerusahaan() == p.getPerusahaan()
            );

            Magang m = tentukanDosen(p, dosen);
            listMagang.add(m);
        }

        else if (status.equalsIgnoreCase("Ditolak")) {
            listMagang.removeIf(m ->
            m.getMahasiswa() == p.getMahasiswa() &&
            m.getPerusahaan() == p.getPerusahaan()
        );
        }
        
        System.out.println("Pengajuan diproses: " + status);
    }
    

        
    

    // ================= MAGANG =================
    public Magang tentukanDosen(Pengajuan p, Dosen d) {
        Magang m = new Magang(p.getMahasiswa(), p.getPerusahaan());
        m.setDosenPembimbing(d);
        return m;
    }
}