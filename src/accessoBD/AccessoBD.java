package accessoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import logica.Excepciones.objetos.Exc_AccessoBD;

import com.mysql.jdbc.Connection;

import ValueObjet.Examen;
import ValueObjet.Resultado;


public class AccessoBD {
	
 	public AccessoBD() {
 		
 	}
	
	
	public LinkedList <Examen> listarExamenes(Connection con) throws Exc_AccessoBD {
		
		try {
		LinkedList <Examen> Examenes = new LinkedList <Examen>();
		Statement stmt;
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
	
	public void ingresarResultado (Connection con, Resultado resu) throws Exc_AccessoBD{
	/* ingresa el resultado de un examen en la BD, los datos del */
	/* resultado vienen almacenados en el objeto resu */ 
		try{
			
			Consultas consulta = new Consultas();
			String query = consulta.insertarResultado();			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, resu.getCedula());
			pstmt.setString(2, resu.getCodigo());
			pstmt.setInt(3, resu.getCalificacion());
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exc_AccessoBD("Error en el accceso a la base de datos");
		}
	}
}
