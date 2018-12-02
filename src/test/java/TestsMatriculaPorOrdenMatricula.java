import static org.junit.Assert.*;

import org.junit.Test;

public class TestsMatriculaPorOrdenMatricula {

	

	@Test
	public void testCompareAsignatura() {	
		MatriculaPorOrdenMatricula apc = new MatriculaPorOrdenMatricula();
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		Asignatura a2 = new Asignatura("TP",9,801,Tipo.Troncal);
		Actividad a3 = new Asignatura("IA",7,701,Tipo.Obligatoria);
		Asignatura a4 = new Asignatura("TP",6,701,Tipo.Troncal);

		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(a1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m2 = new Matricula(a2, est1, Curso.C1718,OrdenMatricula.M2,21.21);
		Matricula m3 = new Matricula(a3, est1, Curso.C1819,OrdenMatricula.M1,21.21);
		Matricula m4 = new Matricula(a4, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		
		
		assertTrue("matricula POO es mayor que IA", apc.compare(m1,m3)>0);
		assertTrue("matricula POO es igual que TP2", apc.compare(m1,m4)==0);
		assertTrue("matricula IA es menor que TP1", apc.compare(m3,m2)<0);
		
		
		
		
	}	
}

