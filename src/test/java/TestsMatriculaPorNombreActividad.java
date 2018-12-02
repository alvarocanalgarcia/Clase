import static org.junit.Assert.*;

import org.junit.Test;

public class TestsMatriculaPorNombreActividad {

	

	@Test
	public void testCompareAsignatura() {	
		MatriculaPorNombreActividad apc = new MatriculaPorNombreActividad();
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		Asignatura a2 = new Asignatura("TP",9,801,Tipo.Troncal);
		Actividad a3 = new Asignatura("IA",7,701,Tipo.Obligatoria);
		Asignatura a4 = new Asignatura("TP",6,701,Tipo.Troncal);

		Estudiante est1 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(a1, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m2 = new Matricula(a2, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m3 = new Matricula(a3, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m4 = new Matricula(a4, est1, Curso.C1617,OrdenMatricula.M3,21.21);
		
		
		assertTrue("POO es mayor que IA", apc.compare(m1,m3)>0);
		assertTrue("POO es menor que TP", apc.compare(m1,m2)<0);
		assertTrue("IA es menor que TP", apc.compare(m3,m2)<0);
		assertTrue("TP es igual que TP", apc.compare(m2,m4)==0);
		
		
		
		
	}	
}

