import java.time.LocalDate;

public class Calificacion {
	private LocalDate fecha;
	private double nota;
	
	public Calificacion(LocalDate a, double b) {
		this.fecha=a;
		this.nota=b;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getNota() {
		return this.nota;
	}
	
	public boolean aprobado() {
		if(this.nota>=5) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return("Fecha: "+ this.getFecha().toString()+" Nota: "+this.getNota());
	}
	
	public boolean equals(Object a) {
		boolean aux =false;
		if (this == a) {
			return true;
		}
		if (a == null) {
			return false;
		}
		if (a instanceof Calificacion) {
			Calificacion b = (Calificacion) a;
			if(this.fecha==b.fecha && this.nota==b.nota) {
				aux=true;
			}
		}
		return aux;
	}
}
