import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import logica.Excepciones.objetos.Exc_Persistencia;
import persistencia.Propiedades;


public class main
{
	public static void main (final String[] args) throws Exc_Persistencia, IOException
	{
		try
			{
			//hola
				Propiedades p = new Propiedades();
				String driver = p.buscar("driver");
				String url = p.buscar("url");
				String usuario = p.buscar("usuario");
				String password = p.buscar("password");
				
				// primer programa de prueba para ejemplo de acceso a MySQL desde Java 
				// accede a una base de datos de MySQL llamada Prueba que contiene una tabla llamada Personas 
				// dentro de dicha tabla hay una columna llamada nombre 

				// 1. cargo dinamicamente el driver de MySQL 
				Class.forName(driver);

				// 2. una vez cargado el driver, me conecto con la base de datos 
				Connection con = DriverManager.getConnection(url, usuario, password);
				
				PreparedStatement pstmt = con.prepareStatement("CREATE DataBase Bedelias");
				pstmt.execute();
				System.out.println("Creo la base de datos");
				
				pstmt = con.prepareStatement("CREATE Table Bedelias.Examenes(Codigo Varchar(45) not null, Materia Varchar(45) not null, Precio varchar(45) not null, primary key (Codigo))");
				pstmt.execute();
				System.out.println("Creo la tabla Examenes");
				
				pstmt = con.prepareStatement("CREATE Table Bedelias.Resultados(Cedula int not null, Codigo Varchar(45) not null, Calificacion int not null, primary key (Cedula), CONSTRAINT fk_Codigo FOREIGN KEY (Codigo) REFERENCES Examenes (Codigo)");
				pstmt.execute();
				System.out.println("Creo la tabla Resultado");
				
				String insert = "INSERT INTO Bedelias.Examenes VALUES (?,?,?)";
				pstmt = con.prepareStatement(insert);
				pstmt.setString(1, "MD2012Dic");
				pstmt.setString(2, "Matematica discreta");
				pstmt.setString(3, "Diciembre 2012");
				pstmt.executeUpdate();
				System.out.println("Inserte primer tupla");	

				insert = "INSERT INTO Bedelias.Examenes VALUES (?,?,?)";
				pstmt = con.prepareStatement(insert);
				pstmt.setString(1, "P12012Dic");
				pstmt.setString(2, "Programacion");
				pstmt.setString(3, "Diciembre 2012");
				pstmt.executeUpdate();
				System.out.println("Inserte segunda tupla");					
				
				insert = "INSERT INTO Bedelias.Examenes VALUES (?,?,?)";
				pstmt = con.prepareStatement(insert);
				pstmt.setString(1, "BD2012Dic");
				pstmt.setString(2, "Base de datos");
				pstmt.setString(3, "Diciembre 2012");
				pstmt.executeUpdate();
				System.out.println("Inserte tercer tupla");		
				
				insert = "INSERT INTO Bedelias.Examenes VALUES (?,?,?)";
				pstmt = con.prepareStatement(insert);
				pstmt.setString(1, "MD2013Feb");
				pstmt.setString(2, "Matematica discreta");
				pstmt.setString(3, "Febrero 2013");
				pstmt.executeUpdate();
				System.out.println("Inserte cuarta tupla");			

				pstmt.close();
				con.close();
				
				
				System.out.println("EXITO!!!");	
				
			}
			catch (SQLException  e){	
				e.printStackTrace();
			}
			catch (ClassNotFoundException  e){	
				e.printStackTrace();
			}

	}

}
