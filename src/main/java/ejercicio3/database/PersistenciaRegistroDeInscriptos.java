package ejercicio3.database;

import ejercicio3.database.ConnectionManager;
import ejercicio3.model.Inscripto;
import ejercicio3.model.RegistroInscriptos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersistenciaRegistroDeInscriptos implements RegistroInscriptos {

    @Override
    public void registrar(Inscripto inscripto) {

        PreparedStatement statement;
        Connection conn;
        try {
            conn = ConnectionManager.getConnection();
            statement = conn.prepareStatement(
                    "INSERT INTO inscriptos(nombre, apellido, telefono, email, id_concurso) VALUES(?, ?, ?, ?, ?)"
            );
            statement.setString(1, inscripto.nombre());
            statement.setString(2, inscripto.apellido());
            statement.setString(3, inscripto.telefono());
            statement.setString(4, inscripto.email());
            statement.setInt(5, inscripto.idConcurso());

            if (statement.executeUpdate() == 0) {
                throw new RuntimeException("No fue posible realizar la carga");
            }


        } catch (Exception e1) {
            //excepcion
            throw new RuntimeException("SQLException", e1);
        } finally {
            try {
                ConnectionManager.disconnect();
            } catch (SQLException e) {
                //excepcion
                throw new RuntimeException("SQLException", e);
            }
        }
    }
}
