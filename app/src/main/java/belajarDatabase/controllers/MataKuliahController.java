package belajarDatabase.controllers;

import java.util.List;
import java.util.Scanner;

import belajarDatabase.models.MataKuliah;
import belajarDatabase.repository.MataKuliahRepository;

public class MataKuliahController {
    private Scanner scanner = new Scanner(System.in);

    public void addNewMataKuliah() {
        System.out.print("Masukkan Kode Mata Kuliah: ");
        String kodeMatakuliah = scanner.nextLine();

        System.out.print("Masukkan Nama Mata Kuliah: ");
        String namaMatakuliah = scanner.nextLine();
        
        System.out.print("Masukkan int: ");
        int sks = scanner.nextInt();

        System.out.print("Masukkan kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        MataKuliah mk = new MataKuliah(kodeMatakuliah, namaMatakuliah, sks, kodeJurusan);
        MataKuliahRepository.addMataKuliah(mk);
    }

    public void deletMatakuliah() {
        System.out.print("Masukkan Kode Mata Kuliah: ");
        String kodeMatakuliah = scanner.nextLine();

        MataKuliahRepository.deleteMataKuliah(kodeMatakuliah);
    }

    public void updateMataKuliah(){
        System.out.print("Masukkan Kode Mata Kuliah: ");
        String kodeMatakuliah = scanner.nextLine();

        System.out.print("Masukkan Nama Mata Kuliah: ");
        String namaMatakuliah = scanner.nextLine();
        
        System.out.print("Masukkan int: ");
        int sks = scanner.nextInt();

        System.out.print("Masukkan kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        MataKuliah mk = new MataKuliah(kodeMatakuliah, namaMatakuliah, sks, kodeJurusan);
        MataKuliahRepository.updateMataKuliah(mk);
    }


    public  void printAllMatakuliah() {
        List<MataKuliah> allMatakuliah = MataKuliahRepository.getAllMataKuliah();
        System.out.println("\n📋 Daftar Mata Kuliah:");
        for (MataKuliah mk : allMatakuliah) {
            System.out.println(mk.kodeMataKuliah + " - " + mk.namaMataKuliah + " - " + mk.sks + " SKS - " + mk.kodeJurusan);
        }
    }


}
