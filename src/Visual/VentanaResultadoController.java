package Visual;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

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
		con.setTransactionIsolation
		(Connection.TRANSACTION_SERIALIZABLE);
		con.setAutoCommit(false);
				
	}

	
	public void IngresarResultado(String codigo,int cedula,int calificacion) throws SQLException, Exc_AccessoBD {
		
		try {
			AccessoBD accBD = new AccessoBD();
			Resultado res = new Resultado(cedula, codigo, calificacion);
			accBD.ingresarResultado(this.con, res);
			con.commit();
		}
		catch (Exc_AccessoBD e) {
			con.rollback();
			throw e;
		}		
	}
	
	public LinkedList <Examen> ListarExamenes() throws Exc_AccessoBD{
		
		AccessoBD accbd = new AccessoBD();
		LinkedList <Examen> examenes = accbd.listarExamenes(this.con);
		return examenes;
		
	}
	
	
}
