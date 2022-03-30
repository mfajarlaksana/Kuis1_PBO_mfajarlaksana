package com.company;

import java.util.Scanner;
import java.sql.SQLOutput;
import java.util.Date;

// Anggota Perpustakaan
class AnggotaPerpustakaan{
    // Data Diri Anggota Perpustakaan
    String IDanggota;
    String nama;
    String NPM;
    String jurusan;
    String prodi;
    String tempatLahir;
    String tanggalLahir;
    String alamat;
    String masaAktifKeanggotaan;
    Buku buku;

    // Method
    void pinjamBuku(Buku buku){
        this.buku = buku;
    }

    // Constructor Anggota
    AnggotaPerpustakaan(String IDanggota, String nama, String NPM, String jurusan, String prodi, String tempatLahir, String tanggalLahir, String alamat, String masaAktifKeanggotaan){
        this.IDanggota = IDanggota;
        this.nama = nama;
        this.NPM = NPM;
        this.jurusan = jurusan;
        this.prodi = prodi;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        this.masaAktifKeanggotaan = masaAktifKeanggotaan;
    }

    void dataAnggota(){
        System.out.println("Data Peminjaman Buku");
        System.out.println("ID Anggota : " + IDanggota );
        System.out.println("Nama : " + nama );
        System.out.println("NPM : " + NPM);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("Program Studi : " + prodi);
        System.out.println("TTL : " + tempatLahir + ", " + tanggalLahir);
        System.out.println("Alamat : " + alamat);
        System.out.println("Masa Aktif Anggota : " + masaAktifKeanggotaan + "\n");
        buku.dataBuku();
    }

    // Get ID Anggota
    String getIDanggota(){
        return this.IDanggota;
    }
}

//Buku
class Buku{
    // Data Buku
    String IDbuku;
    String judul;
    String penulis;
    String penerbit;
    String tahunTerbit;
    int tebalHalaman;
    int stokBuku;

    // Constructor Buku
    Buku(String IDbuku, String judul, String penulis, String penerbit, String tahunTerbit, int tebalHalaman, int stokBuku){
        this.IDbuku = IDbuku;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.tebalHalaman = tebalHalaman;
        this.stokBuku = stokBuku;
    }

    void dataBuku(){
        System.out.println("ID Buku : " + IDbuku);
        System.out.println("Judul : " + judul);
        System.out.println("Penulis : " + penulis);
        System.out.println("Penerbit : " + penerbit);
        System.out.println("Tahun Terbit : " + tahunTerbit);
        System.out.println("Tebal Halaman : " + tebalHalaman);
        System.out.println("Stok Tersedia : " + stokBuku);
    }

    String getIDbuku(){
        return this.IDbuku;
    }
}

public class Main {
    public static void main(String[] args) {
        // Deklarasi Scanner
        Scanner input = new Scanner(System.in);

        // Anggota Perpus
        AnggotaPerpustakaan anggota1 = new AnggotaPerpustakaan("8716891548", "Muhammad Fajar Laksana", "2055061008", "Teknik Elektro", "Teknik Informatika", "Jakarta", "25 Maret 2002", "Kampung Baru", "1 Februari 2023");
        AnggotaPerpustakaan anggota2 = new AnggotaPerpustakaan("3256996055", "Maulana Fadhillah", "2065063022", "Teknik Sipil", "Teknik Sipil", "Lampung", "2 Mei 2001", "Kedaton", "29 Juni 2022");
        AnggotaPerpustakaan anggota3 = new AnggotaPerpustakaan("2575846213", "Elfrida Wikan", "2015051006", "Teknik Sipil", "Teknik Lingkungan", "Yogyakarta", "18 Juli 2002", "Rajabasa", "9 Agustus 2023");

        // Buku
        Buku buku1 = new Buku("530782", "Hujan", "Tere Liye", "Gramedia Pustaka Utama", "2016", 320, 3);
        Buku buku2 = new Buku("632903", "Garis Waktu", "Fiersa Besari", "Media Kita", "2018", 212, 1);
        Buku buku3 = new Buku("369565", "Soedirman : Seorang Panglima, Seorang Martir", "Tim Tempo", "Kepustakaan Popular Gramedia", "2017", 176, 1);

        // Main Program
        System.out.println("-- Menu Log-in --");
        System.out.println("ID Anggota : ");
        String IDanggota = input.next();
        if (IDanggota.equals(anggota1.getIDanggota())) {
            int pilih;
            System.out.println("\n-- Menu Utama --");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Kembalikan Buku");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    int pilihanBuku;
                    System.out.println("\n-- Menu Pinjam Buku --");
                    System.out.println("1. Hujan - Tere Liye");
                    System.out.println("2. Garis Waktu - Fiersa Besari");
                    System.out.println("3. Soedirman : Seorang Panglima, Seorang Martir");
                    pilihanBuku = input.nextInt();
                    switch (pilihanBuku) {
                        case 1:
                            anggota1.pinjamBuku(buku1);
                            anggota1.dataAnggota();
                            break;
                        case 2:
                            anggota1.pinjamBuku(buku2);
                            anggota1.dataAnggota();
                            break;
                        case 3:
                            anggota1.pinjamBuku(buku3);
                            anggota1.dataAnggota();
                            break;
                        default:
                            System.out.println("Mohon memasukkan input yang tersedia.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\n-- Menu Kembalikan Buku --");
                    System.out.println("Masukkan ID buku : ");
                    String IDbuku = input.next();
                    if (IDbuku.equals(buku1.getIDbuku())) {
                        System.out.println("Berhasil Mengembalikan Buku :");
                        buku1.dataBuku();
                    } else if (IDbuku.equals(buku2.getIDbuku())) {
                        System.out.println("Berhasil Mengembalikan Buku :");
                        buku2.dataBuku();
                    } else if (IDbuku.equals(buku3.getIDbuku())) {
                        System.out.println("Berhasil Mengembalikan Buku :");
                        buku3.dataBuku();
                    }else{
                        System.out.println("ID Buku tidak terdaftar, Coba Lagi.");
                        break;
                    }
                default:
                    System.out.println("Mohon memasukkan input yang tersedia.");
                    break;
            }
        }else if(IDanggota.equals(anggota2.getIDanggota())){
            int pilih;
            System.out.println("\n-- Menu Utama --");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Kembalikan Buku");
            pilih = input.nextInt();

        switch (pilih){
            case 1 :
                int pilihanBuku;
                System.out.println("\n-- Menu Pinjam Buku --");
                System.out.println("1. Hujan - Tere Liye");
                System.out.println("2. Garis Waktu - Fiersa Besari");
                System.out.println("3. Soedirman : Seorang Panglima, Seorang Martir");
                pilihanBuku = input.nextInt();
                switch (pilihanBuku){
                    case 1 :
                        anggota2.pinjamBuku(buku1);
                        anggota2.dataAnggota();
                        break;
                    case 2 :
                        anggota2.pinjamBuku(buku2);
                        anggota2.dataAnggota();
                        break;
                    case 3 :
                        anggota2.pinjamBuku(buku3);
                        anggota2.dataAnggota();
                        break;
                    default:
                        System.out.println("Mohon memasukkan input yang tersedia.");
                        break;
                }
                break;

            case 2 :
                System.out.println("\n-- Menu Kembalikan Buku --");
                System.out.println("Masukkan ID buku : ");
                String IDbuku = input.next();
                if(IDbuku.equals(buku1.getIDbuku())){
                    System.out.println("Berhasil Mengembalikan Buku :");
                    buku1.dataBuku();
                }else if(IDbuku.equals(buku2.getIDbuku())){
                    System.out.println("Berhasil Mengembalikan Buku :");
                    buku2.dataBuku();
                }else if(IDbuku.equals(buku3.getIDbuku())){
                    System.out.println("Berhasil Mengembalikan Buku :");
                    buku3.dataBuku();
                }else{
                    System.out.println("ID Buku tidak terdaftar, Coba Lagi.");
                    break;
                }
            default:
                System.out.println("Mohon memasukkan input yang tersedia.");
                break;
            }
        }else if(IDanggota.equals(anggota3.getIDanggota())){
            int pilih;
            System.out.println("\n-- Menu Utama --");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Kembalikan Buku");
            pilih = input.nextInt();

            switch (pilih){
                case 1 :
                    int pilihanBuku;
                    System.out.println("\n-- Menu Pinjam Buku --");
                    System.out.println("1. Hujan - Tere Liye");
                    System.out.println("2. Garis Waktu - Fiersa Besari");
                    System.out.println("3. Soedirman : Seorang Panglima, Seorang Martir");
                    pilihanBuku = input.nextInt();
                    switch (pilihanBuku){
                        case 1 :
                            anggota3.pinjamBuku(buku1);
                            anggota3.dataAnggota();
                            break;
                        case 2 :
                            anggota3.pinjamBuku(buku2);
                            anggota3.dataAnggota();
                            break;
                        case 3 :
                            anggota3.pinjamBuku(buku3);
                            anggota3.dataAnggota();
                            break;
                        default:
                            System.out.println("Mohon memasukkan input yang tersedia.");
                            break;
                    }
                    break;

                case 2 :
                    System.out.println("\n-- Menu Kembalikan Buku --");
                    System.out.println("Masukkan ID buku : ");
                    String IDbuku = input.next();
                    if(IDbuku.equals(buku1.getIDbuku())){
                        System.out.println("Berhasil Mengembalikan Buku :");
                        buku1.dataBuku();
                    }else if(IDbuku.equals(buku2.getIDbuku())){
                        System.out.println("Berhasil Mengembalikan Buku :");
                        buku2.dataBuku();
                    }else if(IDbuku.equals(buku3.getIDbuku())){
                        System.out.println("Berhasil Mengembalikan Buku :");
                        buku3.dataBuku();
                    }else{
                        System.out.println("ID Buku tidak terdaftar, Coba Lagi.");
                        break;
                    }
                default:
                    System.out.println("Mohon memasukkan input yang tersedia.");
                    break;
            }
        }else{
            System.out.println("ID Anggota Anda tidak terdaftar atau sudah tidak aktif.");
        }
    }
}