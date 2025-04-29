package tecsup.edu.pe.democrudjdbc.dao;
import tecsup.edu.pe.democrudjdbc.model.Curso;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private final String url = "jdbc:mysql://localhost:3306/escuela?useSSL=false&serverTimezone=UTC";
    private final String user = "root";
    private final String pass = "";

    // Cargar el driver manualmente antes de la conexión
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver MySQL JDBC cargado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: Driver MySQL JDBC no encontrado.");
        }
    }

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM curso"; // Confirma que 'curso' es el nombre correcto de la tabla

        try (Connection conn = conectar()) {
            if (conn != null) {
                System.out.println("✅ Conexión establecida con MySQL.");
            } else {
                System.out.println("❌ Error: No se pudo conectar a la base de datos.");
                return lista;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("✅ Ejecutando consulta SQL: " + sql);

                while (rs.next()) {
                    Curso c = new Curso();
                    c.setCodigo(rs.getString("chrCurCodigo"));
                    c.setNombre(rs.getString("vchCurNombre"));
                    c.setCreditos(rs.getInt("intCurCreditos"));
                    lista.add(c);

                    System.out.println("📌 Curso recuperado - Código: " + c.getCodigo() + ", Nombre: " + c.getNombre() + ", Créditos: " + c.getCreditos());
                }

                System.out.println("✅ Total cursos obtenidos en CursoDAO: " + lista.size());

                // Si no hay cursos, mostrar mensaje claro
                if (lista.isEmpty()) {
                    System.out.println("⚠️ Advertencia: No se encontraron cursos en la tabla 'curso'.");
                }

            } catch (SQLException e) {
                System.out.println("❌ Error ejecutando la consulta: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("❌ Error en la conexión a la base de datos: " + e.getMessage());
        }

        return lista;
    }



    public boolean insertar(Curso curso) {
        String sql = "INSERT INTO curso (chrCurCodigo, vchCurNombre, intCurCreditos) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, curso.getCodigo());
            ps.setString(2, curso.getNombre());
            ps.setInt(3, curso.getCreditos());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean actualizar(Curso curso) {
        String sql = "UPDATE curso SET vchCurNombre = ?, intCurCreditos = ? WHERE chrCurCodigo = ?";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getCreditos());
            ps.setString(3, curso.getCodigo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "DELETE FROM curso WHERE chrCurCodigo = ?";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public Curso buscarPorCodigo(String codigo) {
        String sql = "SELECT * FROM curso WHERE chrCurCodigo = ?";
        Curso curso = null;

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                curso = new Curso();
                curso.setCodigo(rs.getString("chrCurCodigo"));
                curso.setNombre(rs.getString("vchCurNombre"));
                curso.setCreditos(rs.getInt("intCurCreditos"));
            }

        } catch (SQLException e) {
            return null;
        }

        return curso;
    }
}

