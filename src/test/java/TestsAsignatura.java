import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class TestsAsignatura {

	@Test
	public void testConstructor() {
		Asignatura a = new Asignatura();
		assertEquals("El nombre de una asignatura construida con constructor vacío debe estar vacío", "", a.getNombre());
		assertEquals("El numero de creditos de una asignatura construida con constructor vacío debe ser 0", 0, a.getCreditos());
		assertEquals("El plan de estudios de una asignatura construida con constructor vacío debe ser 0", 0, a.getPlanEstudios());
		assertEquals("El tipo de la asignatura es Troncal", Tipo.Troncal, a.getTipo());
		
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El numero de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 701", 701, a1.getPlanEstudios());
		assertEquals("El tipo de la asignatura es Troncal", Tipo.Troncal, a1.getTipo());
		
	}
	
	@Test
	public void testSetNombre() {	
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		a1.setNombre("TP");
		assertEquals("El nombre de la asignatura a1 debe ser TP", "TP", a1.getNombre());
		assertEquals("El numero de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 701", 701, a1.getPlanEstudios());
		assertEquals("El tipo de la asignatura es Troncal", Tipo.Troncal, a1.getTipo());
		
	}

	
	@Test
	public void testSetCreditos() {	
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		a1.setCreditos(9);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El numero de creditos de la asignatura a1 debe ser 9", 9, a1.getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 701", 701, a1.getPlanEstudios());
		assertEquals("El tipo de la asignatura es Troncal", Tipo.Troncal, a1.getTipo());
		
	}
	
	@Test
	public void testSetTipo() {	
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		a1.setTipo(Tipo.Obligatoria);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El numero de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("El plan de estudios de la asignatura a1 debe ser 701", 701, a1.getPlanEstudios());
		assertEquals("El tipo de la asignatura es Troncal", Tipo.Obligatoria, a1.getTipo());
		a1.setTipo(Tipo.Optativa);
		assertEquals("El tipo de la asignatura es Troncal", Tipo.Optativa, a1.getTipo());
	}
	
	
	@Test
	public void testGetSetCoeficientePrecio() {	
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		assertEquals("El coeficiente precio de una asignatura es 1.0", 1.0, a1.getCoeficientePrecio(),0.0001);
		a1.setCoeficientePrecio(0.75);
		assertEquals("El coeficiente precio de una asignatura ha pasado a ser 0.75", 0.75, a1.getCoeficientePrecio(),0.0001);
		
	}
	
	@Test
	public void testToString() {
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		String a1ToString = a1.toString();
		assertTrue("Contiene el texto Actividad", a1ToString.contains("Actividad"));
		assertTrue("Contiene el nombre de la actividad", a1ToString.contains(a1.getNombre()));
		assertTrue("Contiene el texto creditos", a1ToString.contains("Creditos"));
		assertTrue("Contiene los creditos de la actividad", a1ToString.contains(""+a1.getCreditos()));
		assertTrue("Contiene el coeficiente precio", a1ToString.contains("Coeficiente"));
		assertTrue("Contiene los creditos de la actividad", a1ToString.contains(""+a1.getCoeficientePrecio()));
		assertTrue("Contiene el plan de estudios", a1ToString.contains(""+a1.getPlanEstudios()));
		assertTrue("Contiene el tipo", a1ToString.contains(""+a1.getTipo()));
		
		
	}
	
	
	@Test
	public void testEqual() {
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		Asignatura a2 = new Asignatura("POO",6,801,Tipo.Troncal);
		Actividad a3 = new Asignatura("POO",6,701,Tipo.Obligatoria);
		Asignatura a4 = new Asignatura("POO",6,701,Tipo.Troncal);
		a4.setCoeficientePrecio(5.0);
		
		assertNotEquals(a1, a2);
		assertNotEquals(a1, a3);
		assertNotEquals(a2, a3);
		assertEquals(a1,a4);
			
		
	}
	
	@Test
	public void testCompara() {	
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		Asignatura a2 = new Asignatura("TP",6,801,Tipo.Troncal);
		Actividad a3 = new Asignatura("IA",6,701,Tipo.Obligatoria);
		Asignatura a4 = new Asignatura("TP",6,701,Tipo.Troncal);
		assertTrue("POO es mayor que IA", a1.mayorQue(a3));
		assertTrue("POO es menor que TP", a1.menorQue(a2));
		assertTrue("IA es menor que TP", a3.menorQue(a2));
		assertTrue("TP es igual que TP", a2.igualQue(a4));
		
	}
	
	
}
