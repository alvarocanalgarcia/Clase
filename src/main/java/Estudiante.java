import java.util.Arrays;

/* Nombre: Alvaro CaÃ±al GarcÃ­a
Grupo: INFO1
Nombre del fichero: Estudiante.java
DescripciÃ³n: Archivo que contiene la clase Estudiante*/

public class Estudiante<T> implements Compara<T> {
	private String cuasi;
	private boolean familiaNumerosa;
	
	public Estudiante() {
		this.cuasi="";
		this.familiaNumerosa=false;
	}
	
	public Estudiante(String cuasi, boolean familiaNumerosa) {
		this.cuasi=cuasi;
		this.familiaNumerosa=familiaNumerosa;
	}

	public String getCuasi() {
		return cuasi;
	}

	public void setCuasi(String cuasi) {
		this.cuasi = cuasi;
	}

	public boolean getFamiliaNumerosa() {
		return familiaNumerosa;
	}

	public void setFamiliaNumerosa(boolean familiaNumerosa) {
		this.familiaNumerosa = familiaNumerosa;
	}
	
	public String toString() {
		return("CUASI: " + this.getCuasi()+" Pertenece a familia numerosa: " + this.getFamiliaNumerosa ());
	}
	
	public boolean equals(Object a) {
		boolean aux =false;
		if (this == a) {
			return true;
		}
		if (a == null) {
			return false;
		}
		if (a instanceof Estudiante) {
			Estudiante b = (Estudiante) a;
			if(this.cuasi==b.cuasi && this.familiaNumerosa==b.familiaNumerosa) {
				aux=true;
			}
		}
		return aux;
	}
	
	public boolean mayorQue(T a) {
		if(this==a) {
			return false;
		}
		if(a instanceof Estudiante) {
			Estudiante b=(Estudiante) a;
			String[] c=new String[2];
			c[0]=this.getCuasi();
			c[1]=b.getCuasi();
			Arrays.sort(c);
			if(this.getCuasi()==c[1]&&this.getCuasi()!=b.getCuasi()) {
				return true;
			}
		}
		return false;

	}
	
	public boolean menorQue(T a) {
		if(this==a) {
			return false;
		}
		if(a instanceof Estudiante) {
			
			Estudiante b=(Estudiante) a;
			String[] c=new String[2];
			c[0]=this.getCuasi();
			c[1]=b.getCuasi();
			
			Arrays.sort(c);
			
			if(this.getCuasi()==c[0]&&this.getCuasi()!=b.getCuasi()) {
				return true;
			}
		}
		return false;

	}
	
	public boolean igualQue(T a) {
		if(this==a) {
			return true;
		}
		if(a instanceof Estudiante) {
			Estudiante b = (Estudiante) a;
			boolean c = (this.getCuasi()==b.getCuasi());
			return c;
		}
		return false;

	}
}
