package belajarDatabase.controllers;

import java.util.List;
import java.util.Scanner;

import belajarDatabase.models.Jurusan;
import belajarDatabase.repository.JurusanRepository;

public class JurusanController {
    private Scanner scanner = new Scanner(System.in);

    public void addNewJurusan() {
        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        System.out.print("Masukkan Nama Jurusan: ");
        String namaJurusan = scanner.nextLine();
        
        Jurusan jr = new Jurusan(kodeJurusan, namaJurusan);
        JurusanRepository.addJurusan(jr);
    }

    public void deleteJurusan() {
        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        JurusanRepository.deleteJurusan(kodeJurusan);
    }

    public void updateJurusan(){
        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        System.out.print("Masukkan Nama Jurusan: ");
        String namaJurusan = scanner.nextLine();
        
        Jurusan jr = new Jurusan(kodeJurusan, namaJurusan);
        JurusanRepository.updateJurusan(jr);
    }


    public  void printAllJurusan() {
        List<Jurusan> allJurusan = JurusanRepository.getAllJurusan();
        System.out.println("\n📋 Daftar Jurusan:");
        for (Jurusan j : allJurusan) {
            System.out.println(j.kodeJurusan + " - " + j.namaJurusan);
        }
    }


}
