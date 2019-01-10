
public class Convalidacion extends Actividad{
	private String nombreAsignaturaOriginal;
	private String universidadOrigen;
	private double coeficientePrecio = 0.5;
	
	public Convalidacion(String a, int b, String c, String d) {
		super.setNombre(a);
		super.setCreditos(b);
		this.nombreAsignaturaOriginal=c;
		this.universidadOrigen=d;
	}
	
	public String getNombreAsignaturaOriginal() {
		return this.nombreAsignaturaOriginal;
	}
	
	public String getUniversidadOrigen() {
		return this.universidadOrigen;
	}
	
	public double getCoeficientePrecio() {
		return this.coeficientePrecio;
	}
	
	public void setCoeficientePrecio(double a) {
		this.coeficientePrecio=a;
	}
	
	public String toString() {
		return(super.toString()+" Asignatura de origen: " + this.getNombreAsignaturaOriginal ()+" Universidad de origen: " + this.getUniversidadOrigen ());
	}
	public boolean equals(Object a) {
		boolean aux=false;
		if (this == a) {
			return true;
		}
		if (a == null) {
			return false;
		}
		if (a instanceof Convalidacion) {
			Convalidacion b = (Convalidacion) a;
			if(super.equals(b) && this.nombreAsignaturaOriginal==b.nombreAsignaturaOriginal && this.universidadOrigen==b.universidadOrigen) {
				aux=true;
			}
		}
		return aux;
	}
}
