package ValueObjet;

public class Resultado {
	private int Cedula;
	private String Codigo;
	private int Calificacion;

public Resultado(int cedula, String codigo, int calificacion) {
	super();
	setCedula(cedula);
	setCodigo(codigo);
	setCalificacion(calificacion);
}

public int getCedula() {
	return Cedula;
}

public void setCedula(int cedula) {
	Cedula = cedula;
}

public String getCodigo() {
	return Codigo;
}

public void setCodigo(String codigo) {
	Codigo = codigo;
}

public int getCalificacion() {
	return Calificacion;
}

public void setCalificacion(int calificacion) {
	Calificacion = calificacion;
}

}