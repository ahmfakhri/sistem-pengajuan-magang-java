import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    static ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
    static ArrayList<Perusahaan> listPerusahaan = new ArrayList<>();
    static ArrayList<Pengajuan> listPengajuan = new ArrayList<>();
    static ArrayList<Magang> listMagang = new ArrayList<>();
    static ArrayList<Dosen> listDosen = new ArrayList<>();

    public static void main(String[] args) {

        // ===== DATA AWAL =====
        Admin admin = new Admin(1, "admin", "admin@mail.com", "123", "Admin Fulan");

        listMahasiswa.add(new Mahasiswa(1, "Fakhri", "fakhri@gmail.com", "123", "250215003", "Fakhri", "08123", 3.5));
        listPerusahaan.add(new Perusahaan("Google", "google@mail.com", "USA"));
        listPerusahaan.add(new Perusahaan("Tokopedia", "tokopedia@mail.com", "Indonesia"));
        listDosen.add(new Dosen(1, "dosen1", "d1@mail.com", "123",
        "001", "Pak Harto", "0812"));
        listDosen.add(new Dosen(2, "dosen2", "d2@mail.com", "123",
        "002", "Bu Sri", "0822"));

        while (true) {
            System.out.println("\n=== MASUK SEBAGAI ===");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Dosen");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    menuAdmin(admin);
                    break;
                case 2:
                    menuMahasiswa();
                    break;
                case 3:
                    menuDosen();
                    break;

                case 0:
                    System.out.println("Program selesai");
                    return;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    // ================= ADMIN =================
    static void menuAdmin(Admin admin) {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("Login sebagai: " + admin.getNama());
            System.out.println("1. Lihat Pengajuan");
            System.out.println("2. Proses Pengajuan");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    if (listPengajuan.isEmpty()) {
                        System.out.println("Belum ada pengajuan");
                    } else {
                        for (Pengajuan p : listPengajuan) {
                            p.tampilkanDetail();
                            System.out.println("------------------");
                        }
                    }
                    break;

                case 2:
                    if (listPengajuan.isEmpty()) {
                        System.out.println("Tidak ada pengajuan");
                        break;
                    }

                    System.out.println("\n=== DAFTAR PENGAJUAN ===");
                    
                    for (int i = 0; i < listPengajuan.size(); i++) {
                        System.out.println((i + 1) + ". " + listPengajuan.get(i).tampilkanList());
                    }

                    System.out.print("Pilih pengajuan: ");
                    int pilihPengajuan = input.nextInt();

                    if (pilihPengajuan < 1 || pilihPengajuan > listPengajuan.size()) {
                        System.out.println("Pilihan tidak valid!");
                        break;
                    }

                    Pengajuan p = listPengajuan.get(pilihPengajuan - 1);

                    System.out.print("Status (Diterima/Ditolak): ");
                    String status = input.next();

                    System.out.print("Alasan: ");
                    String alasan = input.next();

                    

                    // pilih dosen
                    if (status.equalsIgnoreCase("Diterima")) {

                        if (listDosen.isEmpty()) {
                            System.out.println("Belum ada dosen!");
                            break;
                        }

                        System.out.println("Pilih dosen:");
                        for (int i = 0; i < listDosen.size(); i++) {
                        System.out.println((i + 1) + ". " + listDosen.get(i).getNama());
                        }

                        int pilihDosen = input.nextInt();
                        Dosen d = listDosen.get(pilihDosen - 1);
                    
                        // panggil logic di Admin
                        admin.prosesStatusPengajuan(p, status, alasan, listMagang, d);
                        }

                    break;

                case 0:
                    return;
            }
        }
    }

    // ================= MAHASISWA =================
    static void menuMahasiswa() {

        Mahasiswa mhs;

            if (listMahasiswa.isEmpty()) {
                System.out.println("Belum ada mahasiswa terdaftar.");
                return;
            } else {
                mhs = listMahasiswa.get(0);
            }

        while (true) {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Ajukan Magang");
            System.out.println("2. Lihat Pengajuan");
            System.out.println("3. Lihat Magang");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    if (listPerusahaan.isEmpty()) {
                        System.out.println("Belum ada perusahaan tersedia.");
                        break;
                        }

                    System.out.println("\n=== DAFTAR PERUSAHAAN ===");
                    for (int i = 0; i < listPerusahaan.size(); i++) {
                        System.out.println((i + 1) + ". "
                        + listPerusahaan.get(i).getNama()
                        + " - "
                        + listPerusahaan.get(i).getAlamat());
                        }

                    System.out.print("Pilih perusahaan: ");
                    int pilihPerusahaan = input.nextInt();

                    if (pilihPerusahaan < 1 || pilihPerusahaan > listPerusahaan.size()) {
                        System.out.println("Pilihan tidak valid!");
                        break;
                    }

                    Perusahaan p = listPerusahaan.get(pilihPerusahaan - 1);

                    Pengajuan pengajuan = mhs.ajukanMagang(p);
                    listPengajuan.add(pengajuan);

                    System.out.println("Pengajuan berhasil ke " + p.getNama() + "!");
                    break;

                case 2:
                    mhs.lihatPengajuan(listPengajuan);
                    break;

                case 3:
                    mhs.lihatMagang(listMagang);
                    break;

                case 0:
                    return;
            }
        }
    }

    // ================= DOSEN =================
    static void menuDosen() {

        if (listDosen.isEmpty()) {
            System.out.println("Belum ada data dosen.");
            return;
        }

        System.out.println("\n=== LOGIN SEBAGAI ===");
        for (int i = 0; i < listDosen.size(); i++) {
            System.out.println((i + 1) + ". " + listDosen.get(i).getNama());
        }

        System.out.print("Pilih: ");
        int pilihDosen = input.nextInt();

        if (pilihDosen < 1 || pilihDosen > listDosen.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        Dosen dsn = listDosen.get(pilihDosen - 1);

        // masuk menu dosen
        while (true) {
            System.out.println("\n=== MENU DOSEN ===");
            System.out.println("Login sebagai: " + dsn.getNama());
            System.out.println("1. Lihat Mahasiswa Bimbingan");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    dsn.lihatMahasiswaBimbingan(listMagang);
                    break;

                case 0:
                    return;
            }
        }
    }
}


