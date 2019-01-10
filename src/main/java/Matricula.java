import java.util.Arrays;
import java.util.OptionalDouble;

/* Nombre: Alvaro CaÃ±al GarcÃ­a
Grupo: INFO1
Nombre del fichero: Matricula.java
DescripciÃ³n: Archivo que contiene la clase Matricula*/

public class Matricula<T> implements Compara<T>{
	private Actividad actividad;
	private Estudiante estudiante;
	private Curso curso;
	private OrdenMatricula ordenMatricula;
	private double precio;
	private int convAgotadas;
	private Calificacion calificaciones[];
	private static final int convAnuales = 2;
	
	public Matricula(Actividad a, Estudiante b, Curso c, OrdenMatricula d, double e) {
		this.actividad=a;
		this.estudiante=b;
		this.curso=c;
		this.ordenMatricula=d;
		this.precio=e;
		this.calificaciones= new Calificacion[convAnuales];
		this.convAgotadas=0;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public OrdenMatricula getOrdenMatricula() {
		return ordenMatricula;
	}

	public double getPrecio() {
		double x =0;
    	if ((this.estudiante.getFamiliaNumerosa()==false)&&(this.ordenMatricula== OrdenMatricula.M1)) {
    		x=this.precio*this.actividad.getCreditos()*this.getActividad().getCoeficientePrecio();
    	}
    	if ((this.estudiante.getFamiliaNumerosa()==false) && (this.ordenMatricula== OrdenMatricula.M2)){
    		x=(this.precio*this.actividad.getCreditos()*2*this.getActividad().getCoeficientePrecio());
    	}
    	if ((this.estudiante.getFamiliaNumerosa()==false)&&(this.ordenMatricula== OrdenMatricula.M3)) {
    		x=(this.precio*this.actividad.getCreditos()*(4)*this.getActividad().getCoeficientePrecio());
    	}
    	if ((this.estudiante.getFamiliaNumerosa()==false)&&(this.ordenMatricula== OrdenMatricula.M4)) {
    		x=(this.precio*this.actividad.getCreditos()*6*this.getActividad().getCoeficientePrecio());
    	}
    	
    	if ((this.estudiante.getFamiliaNumerosa()==true)&&(this.ordenMatricula== OrdenMatricula.M1)) {
    		x=(this.precio*this.actividad.getCreditos()*(0.5)*this.getActividad().getCoeficientePrecio());
    	}
    	if ((this.estudiante.getFamiliaNumerosa()==true) && (this.ordenMatricula== OrdenMatricula.M2)){
    		x=(this.precio*this.actividad.getCreditos()*(0.5*2)*this.getActividad().getCoeficientePrecio());
    	}
    	if ((this.estudiante.getFamiliaNumerosa()==true)&&(this.ordenMatricula== OrdenMatricula.M3)) {
    		x=(this.precio*this.actividad.getCreditos()*(0.5*4)*this.getActividad().getCoeficientePrecio());
    	}
    	if ((this.estudiante.getFamiliaNumerosa()==true)&&(this.ordenMatricula== OrdenMatricula.M4)) {
    		x=(this.precio*this.actividad.getCreditos()*(0.5*6)*this.getActividad().getCoeficientePrecio());
    	}
    	return x;

	}
	
	public int getConvAgotadas() {
		return this.convAgotadas;
	}

	public Calificacion[] getCalificaciones() {
		return this.calificaciones;
	}
	
	public boolean anyadirCalificacion(Calificacion a) {
		if(this.convAgotadas<2) {
			this.calificaciones[this.convAgotadas]=a;
			this.convAgotadas++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean aprobado() {
		int i=0;
		boolean aprobado = false;
		while(i<this.convAgotadas && aprobado==false) {
			if(this.calificaciones[i].aprobado()) {
				aprobado=true;
			}
			i++;
		}
		return aprobado;
	}
	
	public String toString() {
		return("Estudiante:" + this.getEstudiante ().toString()+
				"Actividad:" + this.getActividad ().toString()+
				"Curso:" + this.getCurso ().toString()+
				"Matrícula: "+this.getOrdenMatricula ().toString()+
				"Precio:" + this.getPrecio ()+
				"Convocatorias Agotadas:" + this.getConvAgotadas ()+
				"Calificaciones:"+Arrays.toString(calificaciones)+ 
				"Aprobado:" +this.aprobado ());
	}
	
	public boolean equals(Object a) {
		if(this==a) {
    		return true;
    	}
    	if(a instanceof Matricula) {
    		Matricula b=(Matricula)a;
    		boolean aux = (this.actividad == b.actividad && this.estudiante == b.estudiante&&this.curso==b.curso );
			return aux;
    	}
    	return false;

	}
	
	public boolean mayorQue(T a) {
		if(this==a) {
			return false;
		}
		if(a instanceof Matricula) {
			Matricula b=(Matricula) a;
			Curso[] c=new Curso[2];
			c[0]=this.getCurso();
			c[1]=b.getCurso();
			Arrays.sort(c);
			if(this.getCurso()==c[1]&&this.getCurso()!=b.getCurso()) {
				return true;
			}
		}
		return false;

	}
	
	public boolean menorQue(T a) {
		if(this==a) {
			return false;
		}
		if(a instanceof Matricula) {
			Matricula b=(Matricula) a;
			Curso[] c=new Curso[2];
			c[0]=this.getCurso();
			c[1]=b.getCurso();
			Arrays.sort(c);
			if(this.getCurso()==c[0]&&this.getCurso()!=b.getCurso()) {
				return true;
			}
		}
		return false;

	}
	
	public boolean igualQue(T a) {
		if(this==a) {
			return true;
		}
		if(a instanceof Matricula) {
			Matricula b = (Matricula) a;
			boolean c = (this.getCurso()==b.getCurso());
			return c;
		}
		return false;

	}
}
