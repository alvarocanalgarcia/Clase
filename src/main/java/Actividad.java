import java.util.Arrays;

public abstract class Actividad<T> implements Compara<T> {
	
	private String nombre;
	private int creditos;
	
	public Actividad() {
		this.nombre="";
		this.creditos=0;
	}
	
	public Actividad(String a, int b) {
		this.nombre=a;
		this.creditos=b;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public abstract double getCoeficientePrecio();
	
	public abstract void setCoeficientePrecio(double a);
	
	public String toString() {
		return("Actividad: " + this.getNombre()+" Creditos: " + this.getCreditos ()+" Coeficiente: " + this.getCoeficientePrecio());
	}
	
	public boolean equals(Object a) {
		boolean aux =false;
		if (this == a) {
			return true;
		}
		if (a == null) {
			return false;
		}
		if (a instanceof Actividad) {
			Actividad b = (Actividad) a;
			if(this.nombre==b.nombre && this.creditos==b.creditos) {
				aux=true;
			}
		}
		return aux;
	}
	
	public boolean mayorQue(T a) {
		if(this==a) {
			return false;
		}
		if(a instanceof Actividad) {
			Actividad b=(Actividad) a;
			String[] c=new String[2];
			c[0]=this.getNombre();
			c[1]=b.getNombre();
			Arrays.sort(c);
			if(this.getNombre()==c[1]&&this.getNombre()!=b.getNombre()) {
				return true;
			}
		}
		return false;

	}
	
	public boolean menorQue(T a) {
		if(this==a) {
			return false;
		}
		if(a instanceof Actividad) {
			Actividad b=(Actividad) a;
			String[] c=new String[2];
			c[0]=this.getNombre();
			c[1]=b.getNombre();
			
			Arrays.sort(c);
			
			if(this.getNombre()==c[0]&&this.getNombre()!=b.getNombre()) {
				return true;
			}
		}
		return false;

	}
	
	public boolean igualQue(T a) {
		if(this==a) {
			return true;
		}
		if(a instanceof Actividad) {
			Actividad b = (Actividad) a;
			boolean c = (this.getNombre()==b.getNombre());
			return c;
		}
		return false;

	}
}
