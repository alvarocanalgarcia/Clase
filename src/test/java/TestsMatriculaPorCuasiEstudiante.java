import static org.junit.Assert.*;

import org.junit.Test;

public class TestsMatriculaPorCuasiEstudiante {

	

	@Test
	public void testCompareAsignatura() {	
		MatriculaPorCuasiEstudiante apc = new MatriculaPorCuasiEstudiante();
		Asignatura a1 = new Asignatura("POO",6,701,Tipo.Troncal);
		Asignatura a2 = new Asignatura("TP",9,801,Tipo.Troncal);
		Actividad a3 = new Asignatura("IA",7,701,Tipo.Obligatoria);
		Asignatura a4 = new Asignatura("TP",6,701,Tipo.Troncal);

		Estudiante e1 = new Estudiante("peperez",true);
		Estudiante e2 = new Estudiante("malopez",true);
		Estudiante e3 = new Estudiante("roromero",true);
		Estudiante e4 = new Estudiante("peperez",false);
		Matricula m1 = new Matricula(a1, e1, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m2 = new Matricula(a2, e2, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m3 = new Matricula(a3, e3, Curso.C1617,OrdenMatricula.M3,21.21);
		Matricula m4 = new Matricula(a4, e4, Curso.C1617,OrdenMatricula.M3,21.21);
		
		
		assertTrue("matricula pepeperez es mayor que malopez", apc.compare(m1,m2)>0);
		assertTrue("matricula pepeperez es menor que roromero", apc.compare(m1,m3)<0);
		assertTrue("matricula malopez es menor que roromero", apc.compare(m2,m3)<0);
		assertTrue("matricula peperez es igual que peperez", apc.compare(m1,m4)==0);
		
		
		
		
	}	
}

