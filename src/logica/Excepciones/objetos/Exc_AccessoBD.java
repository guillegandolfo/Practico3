package logica.Excepciones.objetos;

public class Exc_AccessoBD extends Exception{

	String Mensaje;
	
	public Exc_AccessoBD(){
		
	}
	
	public Exc_AccessoBD(String mensaje){
		this.Mensaje = mensaje;
	}
	
	public String DarMensajes () {
		return "Error al conectarce a la base";
	}

}
