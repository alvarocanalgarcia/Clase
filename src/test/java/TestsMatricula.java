import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestsMatricula {
	
	
	@Test
	public void testPrecioFamiliaNoNumerosaPrimeraMatricula() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Actividad act3 = new Convalidacion("TP", 6, "Tecnologia Programacion", "Universidad Zaragoza");
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M1,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M1,10);
		Matricula m3 = new Matricula(act3, est1, Curso.C1718,OrdenMatricula.M1,10);
			
		assertEquals("Precio familia no numerosa, primera matricula de asignatura es precio por nº creditos",127.26, m1.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, primera matricula de reconociemiento es precio por nº creditos por 0.75",15, m2.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, primera matricula de convalidacion es precio por nº creditos por 0.5",30, m3.getPrecio(),0.0001);
		
	}
	
	@Test
	public void testPrecioFamiliaNoNumerosaSegundaMatricula() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Actividad act3 = new Convalidacion("TP", 6, "Tecnologia Programacion", "Universidad Zaragoza");
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M2,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M2,10);
		Matricula m3 = new Matricula(act3, est1, Curso.C1718,OrdenMatricula.M1,10);
			
		assertEquals("Precio familia no numerosa, segunda de asignatura matricula es precio por nº creditos por 2",254.52, m1.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, segunda de reconociemiento matricula es precio por nº creditos por 2 por 0.75",30, m2.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, segunda matricula de convalidacion  es precio por nº creditos por 2 por 0.5",30, m3.getPrecio(),0.0001);
		 
	}
	
	@Test
	public void testPrecioFamiliaNoNumerosaTerceraMatricula() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M3,10);
			
		assertEquals("Precio familia no numerosa, tercera de asignatura matricula es precio por nº creditos por 4.4",509.04, m1.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, tercera matricula de reconocimiento es precio por nº creditos por 4.4 por 0.75",66, m2.getPrecio(),0.0001);
		 
	}
	
	@Test
	public void testPrecioFamiliaNoNumerosaCuartaMatricula() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M4,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M4,10);
			
		assertEquals("Precio familia no numerosa, cuarta de asignatura matricula es precio por nº creditos por 6",763.56, m1.getPrecio(),0.0001);
		assertEquals("Precio familia no numerosa, cuarta de reconocimiento matricula es precio por nº creditos por 6 por 0.75",90, m2.getPrecio(),0.0001);
		 
	}
	
	@Test
	public void testPrecioFamiliaNumerosa() {
		
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Actividad act2 = new Reconocimiento("Deportes", 2, "Campeonatos universitarios");
		Actividad act3 = new Asignatura("TP",5, 2010, Tipo.Obligatoria);
		Actividad act4 = new Reconocimiento("Deportes", 4, "Campeonatos universitarios");
		Actividad act5 = new Convalidacion("TP", 6, "Tecnologia Programacion", "Universidad Zaragoza");
		Estudiante est1 = new Estudiante("peperez",true);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M1,21.21);
		Matricula m2 = new Matricula(act2, est1, Curso.C1718,OrdenMatricula.M2,10);
		Matricula m3 = new Matricula(act3, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m4 = new Matricula(act4, est1, Curso.C1718,OrdenMatricula.M4,10);
		Matricula m5 = new Matricula(act5, est1, Curso.C1718,OrdenMatricula.M1,10);
			
		assertEquals("Precio familia numerosa, primera matricula de asignatura es precio por nº creditos por 0.5 ",63.63, m1.getPrecio(),0.0001);
		assertEquals("Precio familia numerosa, segunda matricula de reconocimiento es precio por nº creditos por 2 por 0.5 por 0.75",15, m2.getPrecio(),0.0001);
		assertEquals("Precio familia numerosa, tercera matricula de asignatura es precio por nº creditos por 4.4 por 0.5",212.10, m3.getPrecio(),0.0001);
		assertEquals("Precio familia numerosa, cuarta matricula de reconociemiento es precio por nº creditos por 6 por 0.5 por 0.75",90, m4.getPrecio(),0.0001);
		assertEquals("Precio familia numerosa, primera matricula convalidacion, es precio por nº creditos por 0.5 por 0.5",15, m5.getPrecio(),0.0001);
		
	}
	
	
	@Test
	public void testMatriculaCreacion() {
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
			
		assertEquals("Al crear la matricula no han pasado convocatorias",0, m1.getConvAgotadas());
		 

		
	}
	
	@Test
	public void testAnyadirCalificacion() {
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Calificacion c = new Calificacion(LocalDate.now(), 3);	
		assertEquals("Podemos añadir una calificacion",true, m1.anyadirCalificacion(c));
		assertEquals("Ha pasado una convocatoria",1, m1.getConvAgotadas());
		assertEquals("Podemos añadir una calificacion",true, m1.anyadirCalificacion(c));
		assertEquals("Han pasado dos convocatorias",2, m1.getConvAgotadas());
		 
		assertEquals("No podemos añadir otra calificacion",false, m1.anyadirCalificacion(c));
		assertEquals("Han pasado dos convocatorias",2, m1.getConvAgotadas());
		
	}
	
	@Test
	public void testAprobadoSuspenso() {
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		assertEquals("Al principio la asignatura no esta aprobada",false, m1.aprobado());
		
		
		Calificacion c = new Calificacion(LocalDate.now(), 3);
		m1.anyadirCalificacion(c);
		assertEquals("El alumno sigue suspenso",false, m1.aprobado());
		m1.anyadirCalificacion(c);
		assertEquals("El alumno sigue suspenso",false, m1.aprobado());
		
		
		Matricula m2 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		assertEquals("Al principio la asignatura no esta aprobada",false, m2.aprobado());
		m2.anyadirCalificacion(c);
		assertEquals("El alumno sigue suspenso",false, m2.aprobado());
		Calificacion c2 = new Calificacion(LocalDate.now(), 6);
		m2.anyadirCalificacion(c2);
		assertEquals("El alumno aprueba",true, m2.aprobado());
		
		Matricula m3 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		assertEquals("Al principio la asignatura no esta aprobada",false, m3.aprobado());
		m3.anyadirCalificacion(c2);
		assertEquals("El alumno aprueba",true, m3.aprobado());
	}
	
	@Test
	public void testToString() {
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Calificacion c = new Calificacion(LocalDate.now(), 3);
		m1.anyadirCalificacion(c);
		Calificacion c1 = new Calificacion(LocalDate.now(), 5);
		m1.anyadirCalificacion(c1);
		
		String a1ToString = m1.toString();
		assertTrue("Contiene el estudiante", a1ToString.contains(est1.toString()));
		assertTrue("Contiene la actividad", a1ToString.contains(act1.toString()));
		assertTrue("Contiene el curso", a1ToString.contains(m1.getCurso().toString()));
		assertTrue("Contiene el orden matricula", a1ToString.contains(""+m1.getOrdenMatricula().toString()));
		assertTrue("Contiene el precio", a1ToString.contains("" + m1.getPrecio()));
		assertTrue("Contiene convocatorias agotadas", a1ToString.contains("2"));
		assertTrue("Contiene cada calificacion", a1ToString.contains(c.toString()));
		assertTrue("Contiene cada calificacion", a1ToString.contains(c1.toString()));
		assertTrue("Contiene si esta aprobado", a1ToString.contains(""+m1.aprobado()));
		
		
	}
	

	@Test
	public void testEqual() {
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		
		Matricula m2 = new Matricula(act1, est1, Curso.C1718,OrdenMatricula.M3,21.21);
		Matricula m3 = new Matricula(act1, est1, Curso.C1718,OrdenMatricula.M2,10);
		Matricula m4 = new Matricula(act1, est1, Curso.C1718,OrdenMatricula.M3,21.21);
		
		
		assertNotEquals(m1, m2);
		assertNotEquals(m1,m4);
		assertEquals(m2,m3);	
			
		
	}
	
	
	
	@Test
	public void testCompara() {	
		Actividad act1 = new Asignatura("POO", 6, 2010, Tipo.Troncal);
		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		
		Matricula m2 = new Matricula(act1, est1, Curso.C1718,OrdenMatricula.M3,21.21);
		Matricula m3 = new Matricula(act1, est1, Curso.C1819,OrdenMatricula.M2,10);
		Matricula m4 = new Matricula(act1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		assertTrue("m1 es menor que m2", m1.menorQue(m2));
		assertTrue("m3 es mayor que m2", m3.mayorQue(m2));
		assertTrue("m1 es menor que m3", m1.menorQue(m3));
		assertTrue("m1 es igual que m4", m1.igualQue(m4));
		
	}
	
	

}
