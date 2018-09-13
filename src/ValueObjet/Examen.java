package ValueObjet;


public class Examen {
	private String Codigo;
	private String Asignatura;
	private String Periodo;
	
	
	public Examen(String codigo, String asignatura, String periodo) {
		super();
		Codigo = codigo;
		Asignatura = asignatura;
		Periodo = periodo;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getAsignatura() {
		return Asignatura;
	}
	public void setAsignatura(String asignatura) {
		Asignatura = asignatura;
	}
	public String getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}
}
