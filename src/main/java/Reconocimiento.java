
public class Reconocimiento extends Actividad{
	
	private String descripcion;
	private double coeficientePrecio=0.75;

	public Reconocimiento(String nombre, int creditos, String descripcion) {
		super.setNombre(nombre);
		super.setCreditos(creditos);
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getCoeficientePrecio() {
		return this.coeficientePrecio;
	}
	
	public void setCoeficientePrecio(double a) {
		this.coeficientePrecio=a;
	}
	
	public String toString() {
		return(super.toString()+" Descripcion : "+this.getDescripcion());
	}
	
	public boolean equals(Object a) {
		boolean aux =false;
		if (this == a) {
			return true;
		}
		if (a == null) {
			return false;
		}
		if (a instanceof Reconocimiento) {
			Reconocimiento b = (Reconocimiento) a;
			if(super.equals(b) && this.descripcion==b.descripcion) {
				aux=true;
			}
		}
		return aux;
	}
}
