import static org.junit.Assert.*;

import org.junit.Test;

public class TestsActividadPorCreditos {

	

	@Test
	public void testCompareAsignatura() {	
		ActividadPorCreditos apc = new ActividadPorCreditos();
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		Asignatura a2 = new Asignatura("TP1",9,801,Tipo.Troncal);
		Actividad a3 = new Asignatura("IA",7,701,Tipo.Obligatoria);
		Asignatura a4 = new Asignatura("TP",6,701,Tipo.Troncal);
		assertTrue("IA es mayor que POO", apc.compare(a3,a1)>0);
		assertTrue("POO es menor que TP1", apc.compare(a1,a2)<0);
		assertTrue("IA es menor que TP1", apc.compare(a3,a2)<0);
		assertTrue("POO es igual que TP", apc.compare(a1,a4)==0);
		
	}
	
	@Test
	public void testCompareConvalidacion() {
		ActividadPorCreditos apc = new ActividadPorCreditos();
		Convalidacion a1 = new Convalidacion("POO",6,"TP","Salamanca");
		Convalidacion a2 = new Convalidacion("TP1",9,"TP","Burgos");
		Convalidacion a3 = new Convalidacion("IA",7,"TP","Salamanca");
		Convalidacion a4 = new Convalidacion("TP",6,"TP","Salamanca");
		assertTrue("IA es mayor que POO", apc.compare(a3,a1)>0);
		assertTrue("POO es menor que TP1", apc.compare(a1,a2)<0);
		assertTrue("IA es menor que TP1", apc.compare(a3,a2)<0);
		assertTrue("POO es igual que TP", apc.compare(a1,a4)==0);
		
	}
	
	@Test
	public void testCompareReconocimiento() {	
		ActividadPorCreditos apc = new ActividadPorCreditos();
		Reconocimiento a1 = new Reconocimiento("POO",6,"ingles");
		Reconocimiento a2 = new Reconocimiento("TP1",9,"ingles");
		Reconocimiento a3 = new Reconocimiento("IA",7,"ingles");
		Reconocimiento a4 = new Reconocimiento("TP",6,"ingles");
		assertTrue("IA es mayor que POO", apc.compare(a3,a1)>0);
		assertTrue("POO es menor que TP1", apc.compare(a1,a2)<0);
		assertTrue("IA es menor que TP1", apc.compare(a3,a2)<0);
		assertTrue("POO es igual que TP", apc.compare(a1,a4)==0);
		
	}
	
	
	
}

