package accessoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import logica.Excepciones.objetos.Exc_AccessoBD;
import com.mysql.jdbc.Connection;
import ValueObjet.Examen;


public class AccessoBD {
	
	public LinkedList <Examen> listarExamenes(Connection con) throws Exc_AccessoBD{
		
		LinkedList <Examen> Examenes = new LinkedList <Examen>();
		Statement stmt;
		try {
			stmt = con.createStatement();

		Consultas consulta = new Consultas();
		String query = consulta.listarExamenes();
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next())
		{
			String Codigo = rs.getString("Codigo");
			String Materia = rs.getString("Materia");
			String Periodo = rs.getString("Periodo");
			
			Examen Exam = new Examen(Codigo, Materia, Periodo);
			Examenes.add(Exam);
		}
		
		return Examenes;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exc_AccessoBD("Error en el accceso a la base de datos");
		}
	}
	
}
