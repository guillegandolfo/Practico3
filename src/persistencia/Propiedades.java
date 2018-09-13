package persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import logica.Excepciones.objetos.Exc_Persistencia;

public class Propiedades {
	
	public String buscar(String nomProp) throws Exc_Persistencia{ 
		try{
			Properties p = new Properties();
			String nombreProperties = ".settings/datos.properties";
			p.load(new FileInputStream(nombreProperties));
			if(nomProp == "driver"){
				String archivo = p.getProperty("driver");
				return archivo;
			}else if(nomProp == "url"){
				String archivo = p.getProperty("url");
				return archivo;
			}else if((nomProp == "usuario")){
				String archivo = p.getProperty("usuario");
				return archivo;
			}else if((nomProp == "password")){
				String archivo = p.getProperty("password");
				return archivo;
			}else{
			throw new Exc_Persistencia("No se encuentra los datos en la Properties");
			}
		}
		catch (IOException e){ 
			e.printStackTrace();
		throw new Exc_Persistencia("Hubo un error al buscar la properties");
		}	
	}
}
