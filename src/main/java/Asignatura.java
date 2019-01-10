/* Nombre: Alvaro CaÃ±al GarcÃ­a
Grupo: INFO1
Nombre del fichero: Asignatura.java
DescripciÃ³n: Archivo que contiene la clase Asignatura*/

public class Asignatura extends Actividad {
	
	private int planEstudios;
	private Tipo tipo;
	private double coeficientePrecio=1.0;
	
	public Asignatura(){
		this.planEstudios=0;
		this.tipo=Tipo.Troncal;
	}
	
	public Asignatura(String nombre, int creditos, int planEstudios, Tipo tipo) {
		super.setNombre(nombre);
		super.setCreditos(creditos);
		this.planEstudios=planEstudios;
		this.tipo=tipo;
	}

	public int getPlanEstudios() {
		return planEstudios;
	}

	public void setPlanEstudios(int planEstudios) {
		this.planEstudios = planEstudios;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public double getCoeficientePrecio() {
		return this.coeficientePrecio;
	}
	
	public void setCoeficientePrecio(double a) {
		this.coeficientePrecio=a;
	}
	
	public String toString() {
		return(super.toString()+ " Plan estudios: "+ this.getPlanEstudios()+ " Tipo : "+this.getTipo());
	}
	
	public boolean equals(Object a) {
		boolean aux =false;
		if (this == a) {
			return true;
		}
		if (a == null) {
			return false;
		}
		if (a instanceof Asignatura) {
			Asignatura b = (Asignatura) a;
			if(super.equals(b) && this.planEstudios==b.planEstudios && this.tipo==b.tipo) {
				aux=true;
			}
		}
		return aux;
	}
}
