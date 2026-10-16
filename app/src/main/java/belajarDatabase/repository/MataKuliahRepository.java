package belajarDatabase.repository;

import belajarDatabase.database.Database;
import belajarDatabase.models.MataKuliah;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MataKuliahRepository {
    
    private static final Connection conn;

    static {
        conn = Database.connect();
    }
    
    // CREATE
    public static void addMataKuliah(MataKuliah mtk){
        String sql = "INSERT INTO matakuliah (kode_matakuliah, nama, sks, kode_jurusan) VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mtk.kodeMataKuliah);
            preparedStatement.setString(2, mtk.namaMataKuliah);
            preparedStatement.setInt(3, mtk.sks);
            preparedStatement.setString(4, mtk.kodeJurusan);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // READ ALL
    public static List<MataKuliah> getAllMataKuliah() {
        List<MataKuliah> result = new ArrayList<>();
        String sql = "SELECT kode_matakuliah, nama, sks, kode_jurusan FROM matakuliah";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                result.add(
                    new MataKuliah(
                        resultSet.getString("kode_matakuliah"),
                        resultSet.getString("nama"),
                        resultSet.getInt("sks"),
                        resultSet.getString("kode_jurusan")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // UPDATE
    public static void updateMataKuliah(MataKuliah mtk){
        String sql = "UPDATE matakuliah SET nama = ?, sks = ?, kode_jurusan = ? where kode_matakuliah = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mtk.namaMataKuliah);
            preparedStatement.setInt(2, mtk.sks);
            preparedStatement.setString(3, mtk.kodeJurusan);
            preparedStatement.setString(4, mtk.kodeMataKuliah);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteMataKuliah(String kode_matakuliah) {
        String sql = "DELETE FROM matakuliah WHERE kode_matakuliah = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kode_matakuliah);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
