package belajarDatabase.view;

import belajarDatabase.controllers.JurusanController;
import belajarDatabase.controllers.MahasiswaController;
import belajarDatabase.controllers.MataKuliahController;

import java.util.Scanner;

public class AppView {

    private Scanner sc = new Scanner(System.in);

    public void menuAwal() {
        System.out.println("\n-- Menu Data --");
        System.out.println("1. Mahasiswa");
        System.out.println("2. Jurusan");
        System.out.println("3. Mata Kuliah");
        System.out.println("4. Keluar");
        System.out.print("Pilih : ");
    }

    public String input() {
        return sc.nextLine();
    }

    public void menuMahasiswa() {
        System.out.println("\n-- Mahasiswa --");
        System.out.println("1. View All");
        System.out.println("2. Create");
        System.out.println("3. Edit");
        System.out.println("4. Delete");
        System.out.println("5. Ambil Mata Kuliah");
        System.out.println("0. kembali");
        System.out.print("Pilih : ");
    }

    public boolean responMahasiswa(String mm) {
        MahasiswaController mc = new MahasiswaController();
        switch (mm) {
            case "1":
                mc.printAllMahasiswa();
                return true;
            case "2":
                mc.addNewMahasiswa();
                return true;
            case "3":
                mc.updateMahasiswa();
                return true;
            case "4":
                mc.deleteMahasiswa();
                return true;
            case "5":
                mc.ambilMatkul();
                return true;
            case "0":
                return false;
            default:
                System.out.println("Tidak Valid");
                return true;
        }
    }
    public void menuJurusan() {
        System.out.println("\n-- Jurusan --");
        System.out.println("1. View All");
        System.out.println("2. Create");
        System.out.println("3. Edit");
        System.out.println("4. Delete");
        System.out.println("0. kembali");
        System.out.print("Pilih : ");
    }

    public boolean responJurusan(String mj) {
        JurusanController jc = new JurusanController();
        switch (mj) {
            case "1":
                jc.printAllJurusan();
                return true;
            case "2":
                jc.addNewJurusan();
                return true;
            case "3":
                jc.updateJurusan();
                return true;
            case "4":
                jc.deleteJurusan();
                return true;
            case "0":
                return false;
            default:
                System.out.println("Tidak Valid");
                return true;
        }
    }
    public void menuMatkul() {
        System.out.println("\n-- Mata Kuliah --");
        System.out.println("1. View All");
        System.out.println("2. Create");
        System.out.println("3. Edit");
        System.out.println("4. Delete");
        System.out.println("0. kembali");
        System.out.print("Pilih : ");
    }

    public boolean responMatakul(String mk) {
        MataKuliahController mkc = new MataKuliahController();
        switch (mk) {
            case "1":
                mkc.printAllMatakuliah();
                return true;
            case "2":
                mkc.addNewMataKuliah();
                return true;
            case "3":
                mkc.updateMataKuliah();
                return true;
            case "4":
                mkc.deletMatakuliah();
                return true;
            case "0":
                return false;
            default:
                System.out.println("Tidak Valid");
                return true;
        }
    }

    public void app() {
        boolean run = true;
        while (run) {
            menuAwal();
            String mn = input();

            switch (mn) {
                case "1":
                    menuMahasiswa();
                    String mm = input();
                    responMahasiswa(mm);
                    break;
                case "2":
                    menuJurusan();
                    String jm = input();
                    responJurusan(jm);
                    break;
                case "3":
                    menuMatkul();
                    String mmk = input();
                    responMatakul(mmk);
                    break;
                case "4":
                    run = false;
                    break;

                default:
                    break;
            }
        }

    }

}
