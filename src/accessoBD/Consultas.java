package accessoBD;

public class Consultas {
	
	public Consultas() {
	}
	
	public String listarExamenes(){
		return "select * from Bedelias.Examenes";
	}
	
	public String insertarResultado(){
		return "INSERT INTO Bedelias.Resultados VALUES (?,?,?)";
	}
	
}
