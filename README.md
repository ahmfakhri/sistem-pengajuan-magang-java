# Sistem Magang Mahasiswa (Java)

Project ini dibuat untuk memenuhi tugas mata kuliah Pemrograman Berorientasi Objek (PBO).

## Informasi
- Nama: Ahmad Fakhri Abdullah
- NPM: 250215003
- Kelas: TRPL-1A

---

## 1. Analisis Sistem

### Class yang digunakan:
- User
- Admin
- Mahasiswa
- Dosen
- Perusahaan
- Pengajuan
- Magang

### Tabel Class

| Class | Atribut | Method |
|------|--------|--------|
| User | id, username, email, password, role | getUsername(), getRole() |
| Admin | nama | getNama(), lihatListPengajuan(), lihatListMagang(), prosesPengajuan(), tentukanDosen() |
| Mahasiswa | npm, nama, ipk | getNama(), getNpm(), getIpk(), ajukanMagang(), lihatPengajuan(), lihatMagang() |
| Dosen | nidn, nama | getNidn(), getNama(), lihatMahasiswaBimbingan() |
| Perusahaan | id_perusahaan, nama, email, alamat | getIdPerusahaan(), getNama(), getEmail(), getAlamat() |
| Pengajuan | status, alasan, mahasiswa, perusahaan | setStatus(), setAlasan(), getStatus(), getAlasan(), getMahasiswa(), getPerusahaan(), tampilkanDetail(), tampilkanList() |
| Magang | mahasiswa, perusahaan, dosen | getMahasiswa(), getPerusahaan(), getDosen(), setDosenPembimbing(), tampilkanMagang() |

### Relasi:
- Mahasiswa mengajukan Pengajuan
- Pengajuan terkait Perusahaan
- Pengajuan diproses menjadi Magang
- Magang memiliki Dosen pembimbing

---

## 2. Class Diagram

<img width="1225" height="932" alt="magang4- drawio" src="https://github.com/user-attachments/assets/12e989ed-ccd8-46bb-9131-3862e35c1944" />





---

## 3. Implementasi Program

Program dibuat menggunakan:
- Java (PBO)
- ArrayList
- Percabangan (if/switch)
- Perulangan (looping)
- Input user (Scanner)

Fitur:
- Mahasiswa mengajukan magang
- Admin memproses pengajuan
- Penentuan dosen pembimbing
- Menampilkan data magang

---

## 4. Analisis Konsep PBO

### 1. Class & Object
Konsep class dan object diterapkan dengan menjadikan setiap entitas dalam sistem sebagai class, seperti Mahasiswa, Admin, Pengajuan, dan Magang. Object dari class tersebut digunakan untuk menjalankan alur program, misalnya object Mahasiswa membuat object Pengajuan saat mengajukan magang, dan object Admin memproses pengajuan tersebut hingga menghasilkan object Magang.

### 2. Enkapsulasi
Atribut dibuat private dan diakses melalui method (getter/setter), sehingga data lebih aman.

### 3. Kelebihan PBO
Pendekatan PBO memudahkan pengelolaan sistem karena setiap entitas seperti Mahasiswa, Pengajuan, dan Magang direpresentasikan sebagai class yang saling berhubungan.
Sebagai contoh, ketika status pengajuan diubah menjadi ditolak, maka data magang yang terkait juga dapat dihapus melalui relasi antar object. Hal ini menunjukkan bahwa perubahan pada satu object dapat mempengaruhi object lain secara terstruktur.
Dengan PBO, alur sistem pengajuan magang menjadi lebih mudah diatur karena setiap class memiliki tanggung jawab masing-masing, seperti Mahasiswa mengajukan magang dan Admin memproses pengajuan.

---

## 5. Refleksi

### 1. Bagian tersulit
Bagian tersulit adalah memahami alur program dan keterkaitan antar class, terutama dalam kode Java yang cukup kompleks.
Namun, melalui proses pengerjaan tugas ini saya mulai memahami bagaimana setiap bagian program saling terhubung dan bekerja bersama.

### 2. Hal baru
Saya mempelajari bagaimana konsep relasi antar object dalam PBO tidak hanya sebagai teori, tetapi dapat diterapkan langsung dalam program untuk menghubungkan dan mengelola data.
Sebagai contoh, relasi antara Mahasiswa, Pengajuan, dan Magang digunakan untuk menentukan data yang ditampilkan dan memastikan konsistensi data, seperti saat status pengajuan diubah maka data magang yang terkait juga ikut berubah.
Saya juga memahami bagaimana keyword seperti `this` digunakan untuk mereferensikan object yang sedang aktif dalam proses tersebut.

### 3. Pengembangan
Jika sistem ini dikembangkan lebih lanjut, dapat ditambahkan fitur login serta penyimpanan data menggunakan database.
