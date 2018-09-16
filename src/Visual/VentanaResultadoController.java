package Visual;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import persistencia.Propiedades;
import accessoBD.AccessoBD;
import logica.Excepciones.objetos.Exc_AccessoBD;
import ValueObjet.Examen;
import ValueObjet.Resultado;

public class VentanaResultadoController {

	
	public VentanaResultado miventana;
	public Connection con;

	public VentanaResultadoController(VentanaResultado ventana) throws ClassNotFoundException, SQLException {
			
		miventana = ventana;
		Propiedades prop = new Propiedades();
		Class.forName(prop.GetDriver());
		String url = prop.GetUrl();
		String usuario = prop.GetUser();
		String password = prop.GetPass();
		con = (Connection) DriverManager.getConnection(url, usuario, password);  
				
	}

	
	public void IngresarResultado(String codigo,int cedula,int calificacion) {
		
		try {
			AccessoBD accBD = new AccessoBD();
			Resultado res = new Resultado(cedula, codigo, calificacion);
			accBD.ingresarResultado(this.con, res);
		}
		catch (Exc_AccessoBD e) {

			e.printStackTrace();
		}		
	}
	
	public LinkedList <Examen> ListarExamenes() throws Exc_AccessoBD{
		
		AccessoBD accbd = new AccessoBD();
		LinkedList <Examen> examenes = accbd.listarExamenes(this.con);
		return examenes;
		
	}
	
	
}
