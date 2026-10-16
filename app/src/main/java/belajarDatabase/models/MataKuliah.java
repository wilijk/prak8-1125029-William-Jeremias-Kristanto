package belajarDatabase.models;

public class MataKuliah {
    
    public String kodeMataKuliah;
    public String namaMataKuliah;
    public int sks;
    public String kodeJurusan;

    public MataKuliah (String kodeMataKuliah, String namaMataKuliah, int sks, String kodeJurusan){
        this.kodeMataKuliah = kodeMataKuliah;
        this.namaMataKuliah = namaMataKuliah;
        this.sks = sks;
        this.kodeJurusan = kodeJurusan;
    }
}
