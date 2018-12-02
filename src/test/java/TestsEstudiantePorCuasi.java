import static org.junit.Assert.*;

import org.junit.Test;

public class TestsEstudiantePorCuasi {

	

	@Test
	public void testCompare() {	
		EstudiantePorCuasi epc = new EstudiantePorCuasi();
		Estudiante e1 = new Estudiante("peperez",true);
		Estudiante e2 = new Estudiante("malopez",true);
		Estudiante e3 = new Estudiante("roromero",true);
		Estudiante e4 = new Estudiante("peperez",false);
		assertTrue("pepeperez es mayor que malopez", epc.compare(e1,e2)>0);
		assertTrue("pepeperez es menor que roromero", epc.compare(e1,e3)<0);
		assertTrue("malopez es menor que roromero", epc.compare(e2,e3)<0);
		assertTrue("peperez es igual que peperez", epc.compare(e1,e4)==0);
		
	}
	
	
}

