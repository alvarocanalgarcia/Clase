import static org.junit.Assert.*;

import org.junit.Test;

public class TestsConvalidacion {

	@Test
	public void testConstructor() {
		
		Convalidacion a1 = new Convalidacion("POO",6,"TP","Salamanca");
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El numero de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("El nombre original debe ser TP", "TP", a1.getNombreAsignaturaOriginal());
		assertEquals("El nombre de la universidad original es salamanca", "Salamanca", a1.getUniversidadOrigen());
		
	}
	
	@Test
	public void testSetNombre() {	
		Convalidacion a1 = new Convalidacion("POO",6,"TP","Salamanca");
		a1.setNombre("TP");
		assertEquals("El nombre de la asignatura a1 debe ser TP", "TP", a1.getNombre());
		assertEquals("El numero de creditos de la asignatura a1 debe ser 6", 6, a1.getCreditos());
		assertEquals("El nombre original debe ser TP", "TP", a1.getNombreAsignaturaOriginal());
		assertEquals("El nombre de la universidad original es salamanca", "Salamanca", a1.getUniversidadOrigen());
		
	}

	
	@Test
	public void testSetCreditos() {	
		Convalidacion a1 = new Convalidacion("POO",6,"TP","Salamanca");
		a1.setCreditos(9);
		assertEquals("El nombre de la asignatura a1 debe ser POO", "POO", a1.getNombre());
		assertEquals("El numero de creditos de la asignatura a1 debe ser 9", 9, a1.getCreditos());
		assertEquals("El nombre original debe ser TP", "TP", a1.getNombreAsignaturaOriginal());
		assertEquals("El nombre de la universidad original es salamanca", "Salamanca", a1.getUniversidadOrigen());
	}
	
	
	@Test
	public void testGetSetCoeficientePrecio() {	
		Convalidacion a1 = new Convalidacion("POO",6,"TP","Salamanca");
		assertEquals("El coeficiente precio de una convalidacion es 0.5", 0.5, a1.getCoeficientePrecio(),0.0001);
		a1.setCoeficientePrecio(0.75);
		assertEquals("El coeficiente precio de una convalidacion ha pasado a ser 0.75", 0.75, a1.getCoeficientePrecio(),0.0001);
		
	}
	
	@Test
	public void testToString() {
		Convalidacion a1 = new Convalidacion("POO",6,"TP","Salamanca");
		String a1ToString = a1.toString();
		assertTrue("Contiene el texto actividad", a1ToString.contains("Actividad"));
		assertTrue("Contiene el nombre de la actividad", a1ToString.contains(a1.getNombre()));
		assertTrue("Contiene el texto creditos", a1ToString.contains("Creditos"));
		assertTrue("Contiene los creditos de la actividad", a1ToString.contains(""+a1.getCreditos()));
		assertTrue("Contiene el coeficiente precio", a1ToString.contains("Coeficiente"));
		assertTrue("Contiene los creditos de la actividad", a1ToString.contains(""+a1.getCoeficientePrecio()));
		assertTrue("Contiene la asignatura origen", a1ToString.contains(a1.getNombreAsignaturaOriginal()));
		assertTrue("Contiene la universidad de origen", a1ToString.contains(a1.getUniversidadOrigen()));
		
		
	}
	
	
	@Test
	public void testEqual() {
		Convalidacion c1 = new Convalidacion("POO",6,"TP","Salamanca");
		Convalidacion c2 = new Convalidacion("TP",9,"TP","Burgos");
		Convalidacion c3 = new Convalidacion("POO",7,"TP","Salamanca");
		Convalidacion c4 = new Convalidacion("POO",6,"TP","Salamanca");
		c4.setCoeficientePrecio(5.0);
		
		assertNotEquals(c1, c2);
		assertNotEquals(c1, c3);
		assertNotEquals(c2, c3);
		assertEquals(c1,c4);
			
			
		
	}
	
	@Test
	public void testCompara() {	
		Convalidacion a1 = new Convalidacion("POO",6,"TP","Salamanca");
		Convalidacion a2 = new Convalidacion("TP",9,"TP","Burgos");
		Convalidacion a3 = new Convalidacion("IA",7,"TP","Salamanca");
		Convalidacion a4 = new Convalidacion("TP",6,"TP","Salamanca");
		assertTrue("POO es mayor que IA", a1.mayorQue(a3));
		assertTrue("POO es menor que TP", a1.menorQue(a2));
		assertTrue("IA es menor que TP", a3.menorQue(a2));
		assertTrue("TP es igual que TP", a2.igualQue(a4));
		
	}
	
	
}
