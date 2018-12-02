import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class TestsCalificacion {

	@Test
	public void testConstructor() {
		LocalDate now = LocalDate.now();
		Calificacion c = new Calificacion(now, 7.0);
		assertEquals("Calificacion con fecha de hoy y nota 7.0", now,c.getFecha());
		assertEquals("Calificacion con fecha de hoy y nota 7.0", 7.0,c.getNota(),0.001);
		
	}
	
	@Test
	public void testAprobado() {
		Calificacion c = new Calificacion(LocalDate.now(), 7.0);
		assertTrue("La asigatura con nota 7 esta aprobada",c.aprobado());
		Calificacion c1 = new Calificacion(LocalDate.now(), 5.0);
		assertTrue("La asigatura con nota 5 esta aprobada",c1.aprobado());
		Calificacion c2 = new Calificacion(LocalDate.now(), 2.0);
		assertFalse("La asigatura con nota 2 esta suspendida",c2.aprobado());
	}

	@Test
	public void testToString() {
		Calificacion c = new Calificacion(LocalDate.now(), 7.0);
		String a1ToString = c.toString();
		assertTrue("Contiene el texto fecha", a1ToString.contains("Fecha"));
		assertTrue("Contiene la fecha", a1ToString.contains(c.getFecha().toString()));
		assertTrue("Contiene nota", a1ToString.contains("Nota"));
		assertTrue("Contiene la nota", a1ToString.contains(""+c.getNota()));		
		
	}
	
	@Test
	public void testEqual() {
		LocalDate now1 = LocalDate.now();
		Calificacion c1 = new Calificacion(now1, 7.0);
		Calificacion c2 = new Calificacion(now1.plus(10, ChronoUnit.DAYS), 3.0);
		Calificacion c3 = new Calificacion(LocalDate.parse("2017-02-03"), 7.0);
		Calificacion c4 = new Calificacion(now1, 4.0+3.0);
		
		assertNotEquals(c1, c2);
		assertNotEquals(c1, c3);
		assertNotEquals(c2, c3);
		assertEquals(c1,c4);
			
		
	}
	
	
}
