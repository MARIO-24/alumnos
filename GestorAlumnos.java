package ejemplo1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorAlumnos {
    Conexion c = new Conexion();

  
    public void alta(Alumno p) throws SQLException {
        String sql = "INSERT INTO alumno (nombre, apellido, telefono, correo, curso, genero) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = c.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellido());
            stmt.setString(3, p.getTelefono());
            stmt.setString(4, p.getCorreo());
            stmt.setString(5, p.getCurso());
            stmt.setString(6, p.getGenero());
            stmt.executeUpdate();
        }
    }

    public List<Alumno> listar() throws SQLException {
        String sql = "SELECT * FROM alumno";
        List<Alumno> lista = new ArrayList<>();

        try (Connection conn = c.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Alumno p = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("curso"),
                        rs.getString("genero")
                );
                lista.add(p);
            }
        }
        return lista;
    }


    public Alumno buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM alumno WHERE id = ?";
        try (Connection conn = c.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Alumno(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("telefono"),
                            rs.getString("correo"),
                            rs.getString("curso"),
                            rs.getString("genero")
                    );
                }
            }
        }
        return null; 
    }

    public boolean modificarAlumno(int id, String nombre, String apellido, String telefono, String correo, String curso, String genero) throws SQLException {
        String sql = "UPDATE cliente SET nombre = ?, apellido = ?, telefono = ?, correo = ?, curso = ?, genero = ? WHERE id = ?";

        try (Connection conn = c.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, telefono);
            stmt.setString(4, correo);
            stmt.setString(5, curso);
            stmt.setString(6, genero);
            stmt.setInt(7, id);

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        }
    }

 
    public boolean eliminarAlumno(int id) throws SQLException {
        String sql = "DELETE FROM alumno WHERE id = ?";

        try (Connection conn = c.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        }
    }
}