package belajarDatabase.repository;

import belajarDatabase.database.Database;
import belajarDatabase.models.Jurusan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JurusanRepository {
    
    private static final Connection conn;

    static {
        conn = Database.connect();
    }
    
    // CREATE
    public static void addJurusan(Jurusan jr){
        String sql = "INSERT INTO jurusan (kode_jurusan, nama) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, jr.kodeJurusan);
            preparedStatement.setString(2, jr.namaJurusan);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // READ ALL
    public static List<Jurusan> getAllJurusan() {
        List<Jurusan> result = new ArrayList<>();
        String sql = "SELECT kode_jurusan, nama FROM jurusan";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                result.add(
                    new Jurusan(
                        resultSet.getString("kode_jurusan"),
                        resultSet.getString("nama")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    // UPDATE
    public static void updateJurusan(Jurusan jr){
        String sql = "UPDATE jurusan SET nama = ? where kode_jurusan = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, jr.namaJurusan);
            preparedStatement.setString(2, jr.kodeJurusan);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteJurusan(String kode_jurusan) {
        String sql = "DELETE FROM jurusan WHERE kode_jurusan = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kode_jurusan);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
