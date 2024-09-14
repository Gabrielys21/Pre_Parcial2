package DataBase.Dao;

import DataBase.Model.Dato;
import DataBase.Util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatoDao {

    public void insertar(Dato dato) throws SQLException {
        String sql = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dato.getNombre());
            pstmt.setString(2, dato.getApellido());
            pstmt.setString(3, dato.getDepartamento());
            pstmt.setDate(4, java.sql.Date.valueOf(dato.getFechaNacimiento())); // Convertir LocalDate a java.sql.Date
            pstmt.executeUpdate();
        }
    }

    public void actualizar(Dato dato) throws SQLException {
        String sql = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dato.getNombre());
            pstmt.setString(2, dato.getApellido());
            pstmt.setString(3, dato.getDepartamento());
            pstmt.setDate(4, java.sql.Date.valueOf(dato.getFechaNacimiento())); // Convertir LocalDate a java.sql.Date
            pstmt.setInt(5, dato.getCodigo());
            pstmt.executeUpdate();
        }
    }

    public void eliminar(int codigo) throws SQLException {
        String sql = "DELETE FROM tb_datos WHERE codigo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
        }
    }

    public Dato buscarPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT * FROM tb_datos WHERE codigo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    java.sql.Date sqlDate = rs.getDate("fecha_nacimiento"); // Obtener java.sql.Date de ResultSet
                    LocalDate localDate = sqlDate.toLocalDate(); // Convertir java.sql.Date a LocalDate
                    return new Dato(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("departamento"),
                            localDate // Usar LocalDate en lugar de java.sql.Date
                    );
                }
            }
        }
        return null;
    }

    public List<Dato> listarTodos() throws SQLException {
        List<Dato> datos = new ArrayList<>();
        String sql = "SELECT * FROM tb_datos";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("fecha_nacimiento"); // Obtener java.sql.Date de ResultSet
                LocalDate localDate = sqlDate.toLocalDate(); // Convertir java.sql.Date a LocalDate
                datos.add(new Dato(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("departamento"),
                        localDate // Usar LocalDate en lugar de java.sql.Date
                ));
            }
        }
        return datos;
    }
}

