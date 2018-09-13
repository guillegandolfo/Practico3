package logica.Excepciones.objetos;

public class Exc_AccessoBD extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Exc_AccessoBD(){
		super("Error generico en Buses.");
	}
	public Exc_AccessoBD(String mensaje){
		super(mensaje);
	}
}
