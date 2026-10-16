package belajarDatabase.controllers;

import java.util.List;
import java.util.Scanner;

import belajarDatabase.models.Mahasiswa;
import belajarDatabase.repository.MahasiswaRepository;

public class MahasiswaController {
    private Scanner scanner = new Scanner(System.in);

    public void addNewMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama, kodeJurusan);
        MahasiswaRepository.addMahasiswa(mhs);
    }

    public void deleteMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        MahasiswaRepository.deleteMahasiswa(nim);
    }

    public void updateMahasiswa(){
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();
        
        Mahasiswa mhs = new Mahasiswa(nim, nama, kodeJurusan);
        MahasiswaRepository.updateMahasiswa(mhs);
    }

    public void ambilMatkul(){
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Kode Mata Kuliah: ");
        String kodeMatkul = scanner.nextLine();
        
        MahasiswaRepository.ambilMataKuliahMahasiswa(nim, kodeMatkul);
    }

    public  void printAllMahasiswa() {
        List<Mahasiswa> allMahasiswa = MahasiswaRepository.getAllMahasiswa();
        System.out.println("\n📋 Daftar Mahasiswa:");
        for (Mahasiswa m : allMahasiswa) {
            System.out.println(m.nim + " - " + m.nama + " - "  + m.kodeJurusan);
        }
    }


}
