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

    public void lihatListPengajuan(java.util.ArrayList<Pengajuan> listPengajuan) {
        boolean ada = false;
        for (Pengajuan p : listPengajuan) {
            System.out.println("\n=== DATA PENGAJUAN ===");
            System.out.println("Mahasiswa : " + p.getMahasiswa().getNama());
            System.out.println("Perusahaan : " + p.getPerusahaan().getNama());
            System.out.println("Status : " + p.getStatus());
            System.out.println("Alasan : " + p.getAlasan());
            System.out.println("------------------");
            ada = true;
        }
        if (!ada) {
            System.out.println("Belum ada data pengajuan.");
        }
    }

    public void lihatListMagang(java.util.ArrayList<Magang> listMagang) {
        boolean ada = false;
        for (Magang m : listMagang) {
            System.out.println("\n=== DATA MAGANG ===");
            System.out.println("Mahasiswa : " + m.getMahasiswa().getNama());
            System.out.println("Perusahaan : " + m.getPerusahaan().getNama());
            if (m.getDosen() != null) {
                System.out.println("Dosen Pembimbing : " + m.getDosen().getNama());
            }
            System.out.println("------------------");
            ada = true;
        }
        if (!ada) {
            System.out.println("Belum ada data magang.");
        }
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