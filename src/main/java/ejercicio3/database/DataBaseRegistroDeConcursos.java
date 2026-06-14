package ejercicio3.database;

import ejercicio3.model.Concurso;
import ejercicio3.model.RegistroDeConcursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRegistroDeConcursos implements RegistroDeConcursos {

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    private List<Concurso> listaDeConcursos;

    public DataBaseRegistroDeConcursos() {
        this.listaDeConcursos = new ArrayList<>();
    }

    @Override
    public List<Concurso> concursos() {

        PreparedStatement statement;
        Connection conn;
        try {
            conn = ConnectionManager.getConnection();

            statement = conn.prepareStatement("SELECT id_concurso, concurso_nombre, fecha_inicio_inscripcion, fecha_fin_inscripcion FROM concursos");
            rs = statement.executeQuery();

            while (rs.next()) {
                Concurso empleado = new Concurso(
                        rs.getInt("id_concurso"),
                        rs.getString("concurso_nombre"),
                        rs.getDate("fecha_inicio_inscripcion").toLocalDate(),
                        rs.getDate("fecha_fin_inscripcion").toLocalDate()
                );
                listaDeConcursos.add(empleado);
            }

            return listaDeConcursos;

        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        } finally {
            try {
                ConnectionManager.disconnect();
            } catch (SQLException e) {
                throw new RuntimeException("SQLException", e);
            }
        }
    }
}
