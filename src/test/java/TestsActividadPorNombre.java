import static org.junit.Assert.*;

import org.junit.Test;

public class TestsActividadPorNombre {

	

	@Test
	public void testCompareAsignatura() {	
		ActividadPorNombre apc = new ActividadPorNombre();
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		Asignatura a2 = new Asignatura("TP",6,801,Tipo.Troncal);
		Actividad a3 = new Asignatura("IA",6,701,Tipo.Obligatoria);
		Asignatura a4 = new Asignatura("TP",6,701,Tipo.Troncal);
		assertTrue("POO es mayor que IA", apc.compare(a1,a3)>0);
		assertTrue("POO es menor que TP", apc.compare(a1,a2)<0);
		assertTrue("IA es menor que TP", apc.compare(a3,a2)<0);
		assertTrue("TP es igual que TP", apc.compare(a2,a4)==0);
		
	}
	
	@Test
	public void testCompareConvalidacion() {
		ActividadPorNombre apc = new ActividadPorNombre();
		Convalidacion a1 = new Convalidacion("POO",6,"TP","Salamanca");
		Convalidacion a2 = new Convalidacion("TP",9,"TP","Burgos");
		Convalidacion a3 = new Convalidacion("IA",7,"TP","Salamanca");
		Convalidacion a4 = new Convalidacion("TP",6,"TP","Salamanca");
		assertTrue("POO es mayor que IA", apc.compare(a1,a3)>0);
		assertTrue("POO es menor que TP", apc.compare(a1,a2)<0);
		assertTrue("IA es menor que TP", apc.compare(a3,a2)<0);
		assertTrue("TP es igual que TP", apc.compare(a2,a4)==0);
		
	}
	
	@Test
	public void testCompareReconocimiento() {	
		ActividadPorNombre apc = new ActividadPorNombre();
		Reconocimiento a1 = new Reconocimiento("POO",6,"ingles");
		Reconocimiento a2 = new Reconocimiento("TP",9,"ingles");
		Reconocimiento a3 = new Reconocimiento("IA",7,"ingles");
		Reconocimiento a4 = new Reconocimiento("TP",6,"ingles");
		assertTrue("POO es mayor que IA", apc.compare(a1,a3)>0);
		assertTrue("POO es menor que TP", apc.compare(a1,a2)<0);
		assertTrue("IA es menor que TP", apc.compare(a3,a2)<0);
		assertTrue("TP es igual que TP", apc.compare(a2,a4)==0);
		
	}
	
	
	
}

