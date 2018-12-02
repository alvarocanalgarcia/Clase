import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class TestsSortedSet {
	
	// Unas clases auxiliares para los tests
    private class DoubleComparator implements Comparator<Double>{

		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}
    }
    
    private class Persona{
    	protected String nombre;
    	protected int edad;
    	public Persona (String nombre, int edad) {
    		this.nombre = nombre;
    		this.edad = edad;
    	}
    	public boolean equals(Object o){
    		if(o instanceof Persona){
    			Persona p1 = (Persona) o;
    			return (this.nombre.equals(p1.nombre) && this.edad==p1.edad);
    		}else{
    			return false;
    		}
    	}
    }
    
    class PersonaPorEdad implements Comparator<Persona> {
		public int compare (Persona p1, Persona p2) {
			return (p1.edad - p2.edad);
		}
	}
    
    
    private DoubleComparator dc = new DoubleComparator();
    private PersonaPorEdad ppe = new PersonaPorEdad();

	
	
	
	
	// Los tests empiezan a partir de aqui	
	
    @Test
	public void testConstructor() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		assertEquals("El tamaño del sorted set inicial es 0",0,ss.size());
	}
	
	@Test
	public void testAdd() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		
		for(int i=0;i<500;i++) {
			assertEquals("El elemento " + i + " fue añadido",true,ss.add(Double.parseDouble(""+i)));
			assertEquals("La lista contiene el elemento " + i,true,ss.contains(Double.parseDouble(""+i)));
			assertEquals("La longitud de la lista es " + i+1,i+1,ss.size());
		}
		
		for(int i=0;i<500;i++) {
			assertEquals("El elemento " + i + " no fue añadido de nuevo",false,ss.add(Double.parseDouble(""+i)));
		}
		

	}
	
	@Test
	public void testAddFailsWhenLimitIsReached() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		
		for(int i=0;i<1000;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		
		assertEquals("No se pueden añadir más elementos ",false,ss.add(Double.parseDouble("1000")));
		assertEquals("No se añadió el elemento ",false,ss.contains(Double.parseDouble("1000")));
		assertEquals("La longitud de la lista es 1000",1000,ss.size());	
	}
	
	
	@Test
	public void testAddFailsWhenElementIsInSortedSet() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		
		for(int i=0;i<500;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		
		for(int i=499;i>=0;i--) {
			assertEquals("No se pueden añadir el elemento de nuevo ",false,ss.add(Double.parseDouble(""+i)));
		}
		
	}
	
	@Test
	public void testAddElementsIgualesButNotEquals() {
		SortedSet<Persona> ss = new SortedSet<>(ppe);
		for(int i=0;i<10;i++) {
			assertEquals("La persona " + i + " fue añadida",true,ss.add(new Persona("persona" + i, 10+i)));
		}
		
		assertFalse("La persona " + 5 + " no puede añadirse de nuevo",ss.add(new Persona("persona" + 5, 15)));
		assertTrue("Si podemos añadir otra persona de edad 15",ss.add(new Persona("persona", 15)));
		
	}
	
	@Test
	public void testAddSortedToArray() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		// Incluimos unos cuantos elementos
		for(int i=20;i<50;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		// Incluimos unos cuantos elementos al principio
		for(int i=0;i<10;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		// Incluimos unos cuantos elementos por medio
		for(int i=10;i<20;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		// Incluimos unos cuantos elementos al final
		for(int i=50;i<100;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		
		Object[] res = new Object[100];
		
		for(int i=0;i<100;i++) {
			res[i]=Double.parseDouble(""+i);
		}
		
		
		assertArrayEquals("Los elementos se añaden de manera ordenada",ss.toArray(),res);
	}
	
	
	@Test
	public void testAddSortedToArrayPersona() {
		SortedSet<Persona> ss = new SortedSet<>(ppe);
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20-"+i,20));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe10-"+i,10));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20b-"+i,20));
		}
		
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe50-"+i,50));
		}
		
		Object[] res = new Object[40];
		
		for(int i=0;i<10;i++) {
			res[i]=(new Persona("PersonaDe10-"+i,10));
		}
		for(int i=0;i<10;i++) {
			res[i+10]=(new Persona("PersonaDe20-"+i,20));
		}
		for(int i=0;i<10;i++) {
			res[i+20]=(new Persona("PersonaDe20b-"+i,20));
		}
		for(int i=0;i<10;i++) {
			res[i+30]=(new Persona("PersonaDe50-"+i,50));
		}
		
		assertArrayEquals("Los elementos se añaden de manera ordenada",ss.toArray(),res);
	}
	
	
	
	@Test
	public void testClear() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		
		for(int i=0;i<1000;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		ss.clear();
		assertEquals("La longitud de la lista es 0",0,ss.size());
		for(int i=0;i<1000;i++) {
			assertEquals("El elemento " + i + " fue añadido de nuevo",true,ss.add(Double.parseDouble(""+i)));
		}
	}

	
	@Test
	public void testIsEmpty() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		assertEquals("Al comienzo la lista está vacía",true,ss.isEmpty());
		ss.add(1.0);
		assertEquals("Al añadir un elemento la lista deja de estar vacía",false,ss.isEmpty());
	}


	
	
	
	@Test
	public void testEquals() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		for(int i=0;i<5;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		
		SortedSet<Double> ss2 = new SortedSet<>(dc);
		for(int i=0;i<5;i++) {
			ss2.add(Double.parseDouble(""+i));
		}
		
		
		assertEquals("Un sortedset es igual a si mismo",ss,ss);
		assertEquals("Dos sortedset construidos del mismo modo son iguales",ss,ss2);
		
		ss2.add(7.0);
		assertNotEquals("SortedSets de distinto tamaño son distintos",ss,ss2);
		
		
		SortedSet<Double> ss3 = new SortedSet<>(dc);
		for(int i=4;i>=0;i--) {
			ss3.add(Double.parseDouble(""+i));
		}
		assertEquals("Sortedset ss1 y ss3 son iguales",ss,ss3);
		
		
		assertNotEquals("SortedSet con elementos es distinto a sortedset nulo",ss,null);
	}
	
	
	@Test
	public void testRemove() {
		SortedSet<Double> al = new SortedSet<>(dc);
		
		for(int i=0;i<250;i++) {
			al.add(Double.parseDouble(""+i));
		}
		
		for(int i=0;i<250;i++) {
			assertEquals("El elemento " + i + " fue eliminado",true,al.remove(Double.parseDouble(""+i)));
			assertEquals("La lista no contiene el elemento " + i,false,al.contains(Double.parseDouble(""+i)));
			assertEquals("La longitud de la lista es " + (250-i),(250-i-1),al.size());
		}
		
		assertEquals("El elemento no fue eliminado porque no estaba",false,al.remove(Double.parseDouble("-1")));

	}
	
	
	@Test
	public void testRemovePersona() {
		SortedSet<Persona> ss = new SortedSet<>(ppe);
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20-"+i,20));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe10-"+i,10));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20b-"+i,20));
		}
		
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe50-"+i,50));
		}
		
		assertFalse("Una nueva persona con edad 10 no se elimina",ss.remove(new Persona("persona",10)));
		
		for(int i=0;i<10;i++) {
			assertTrue("La persona PersonaDe10-"+i +"fue eliminada",ss.remove(new Persona("PersonaDe10-"+i,10)));
			assertFalse("La lista no contiene a la persona PersonaDe10-"+i,ss.contains(new Persona("PersonaDe10-"+i,10)));

		}
		
	}
	
	
	@Test
	public void testRemoveIsEmpty() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		assertEquals("Al comienzo la lista está vacía",true,ss.isEmpty());
		ss.add(Double.parseDouble(""+1));
		assertEquals("Al añadir un elemento la lista deja de estar vacía",false,ss.isEmpty());
		ss.remove(Double.parseDouble(""+1));
		assertEquals("Al eliminar el elemento la lista esta vacía de nuevo",true,ss.isEmpty());
	}
	
	
	
	@Test
	public void testToString() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		
		for(int i=0;i<10;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		
		assertEquals("El método toString es correcto","0.01.02.03.04.05.06.07.08.09.0",ss.toString());
		
	}
	
	
	@Test
	public void testGetComparator() {
		
		SortedSet<Double> ss = new SortedSet<>(dc);
		assertEquals("El comparator devuelto es el correcto",dc,ss.getComparator());
	}
	
	
	
	@Test
	public void testHeadSetDouble() {

		SortedSet<Double> ss = new SortedSet<>(dc);
		for(int i=0;i<100;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		
		SortedSet<Double> ss1 = new SortedSet<>(dc);
		for(int i=0;i<20;i++) {
			ss1.add(Double.parseDouble(""+i));
		}
		
		assertEquals("Toma los elementos menores que 20",ss1,ss.headSet(Double.parseDouble("20.0")));
		assertEquals("Toma los elementos menores que 150",ss,ss.headSet(Double.parseDouble("150.0")));
		assertEquals("Toma los elementos menores que 0",new SortedSet<>(dc),ss.headSet(Double.parseDouble("0.0")));
		assertEquals("Toma los elementos menores que -5",new SortedSet<>(dc),ss.headSet(Double.parseDouble("-5.0")));
		
		
	}
	
	
	@Test
	public void testHeadSetPersona() {

		SortedSet<Persona> ss = new SortedSet<>(ppe);
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20-"+i,20));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe10-"+i,10));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20b-"+i,20));
		}
		
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe50-"+i,50));
		}
		
		SortedSet<Persona> ss1 = new SortedSet<>(ppe);
		for(int i=0;i<10;i++) {
			ss1.add(new Persona("PersonaDe10-"+i,10));
		}
		
		assertEquals("Toma las personas menores de 20",ss1,ss.headSet(new Persona("PersonaDe20",20)));
		assertEquals("Toma las personas menores de 60",ss,ss.headSet(new Persona("PersonaDe60",60)));
		assertEquals("Toma las personas menores de 10",new SortedSet<>(dc),ss.headSet(new Persona("PersonaDe10",10)));
		assertEquals("Toma las personas menores de 5",new SortedSet<>(dc),ss.headSet(new Persona("PersonaDe5",5)));
		
		
	}
	
	@Test
	public void testSubSetDouble() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		for(int i=0;i<100;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		
		SortedSet<Double> ss1 = new SortedSet<>(dc);
		for(int i=20;i<50;i++) {
			ss1.add(Double.parseDouble(""+i));
		}
		
		SortedSet<Double> ss2 = new SortedSet<>(dc);
		for(int i=75;i<100;i++) {
			ss2.add(Double.parseDouble(""+i));
		}
		
		SortedSet<Double> ss3 = new SortedSet<>(dc);
		for(int i=0;i<10;i++) {
			ss3.add(Double.parseDouble(""+i));
		}
		
		assertEquals("Toma los elementos mayores-iguales que 20 y menores de 50",ss1,ss.subSet(Double.parseDouble("20.0"),Double.parseDouble("50.0")));
		assertEquals("Toma los elementos mayores-iguales que 75 y menores que 100",ss2,ss.subSet(Double.parseDouble("75.0"),Double.parseDouble("100.0")));
		assertEquals("Toma los elementos mayores-iguales que 0 y menores que 10",ss3,ss.subSet(Double.parseDouble("0.0"),Double.parseDouble("10.0")));
		assertEquals("Toma los elementos mayores-iguales que 75 y menores que 150",ss2,ss.subSet(Double.parseDouble("75.0"),Double.parseDouble("150.0")));
		assertEquals("Toma los elementos mayores-iguales que -5 y menores que 10",ss3,ss.subSet(Double.parseDouble("-5.0"),Double.parseDouble("10.0")));
		assertEquals("Toma los elementos mayores-iguales que 20 y menores que 10",new SortedSet<>(dc) ,ss.subSet(Double.parseDouble("20.0"),Double.parseDouble("10.0")));
		assertEquals("Toma los elementos mayores-iguales que 150 y menores que 170",new SortedSet<>(dc) ,ss.subSet(Double.parseDouble("150.0"),Double.parseDouble("170.0")));
		assertEquals("Toma los elementos mayores-iguales que -5 y menores que 0",new SortedSet<>(dc) ,ss.subSet(Double.parseDouble("-5.0"),Double.parseDouble("0.0")));
	}
	
	@Test
	public void testSubSetPersona() {
		SortedSet<Persona> ss = new SortedSet<>(ppe);
		SortedSet<Persona> ss1 = new SortedSet<>(ppe);
		SortedSet<Persona> ss2 = new SortedSet<>(ppe);
		SortedSet<Persona> ss3 = new SortedSet<>(ppe);
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20-"+i,20));
			ss1.add(new Persona("PersonaDe20-"+i,20));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe10-"+i,10));
			ss3.add(new Persona("PersonaDe10-"+i,10));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20b-"+i,20));
			ss1.add(new Persona("PersonaDe20b-"+i,20));
		}
		
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe50-"+i,50));
			ss2.add(new Persona("PersonaDe50-"+i,50));
		}
		
		
		
		assertEquals("Toma las personas mayores-iguales que 20 y menores de 50",ss1,ss.subSet(new Persona("PersonaDe20",20),new Persona("PersonaDe50",50)));
		assertEquals("Toma las personas mayores-iguales que 50 y menores que 100",ss2,ss.subSet(new Persona("PersonaDe50",50),new Persona("PersonaDe100",100)));
		assertEquals("Toma las personas mayores-iguales que 0 y menores que 11",ss3,ss.subSet(new Persona("PersonaDe0",0),new Persona("PersonaDe11",11)));
		assertEquals("Toma las personas mayores-iguales que 20 y menores que 10",new SortedSet<>(dc) ,ss.subSet(new Persona("PersonaDe-20",20),new Persona("PersonaDe10",10)));
		assertEquals("Toma las personas mayores-iguales que 150 y menores que 170",new SortedSet<>(dc) ,ss.subSet(new Persona("PersonaDe-150",150),new Persona("PersonaDe170",170)));
		assertEquals("Toma las personas mayores-iguales que -5 y menores que 0",new SortedSet<>(dc) ,ss.subSet(new Persona("PersonaDe-5",-5),new Persona("PersonaDe0",0)));
		
	}
	
	@Test
	public void testTailSetDouble() {
		SortedSet<Double> ss = new SortedSet<>(dc);
		for(int i=0;i<100;i++) {
			ss.add(Double.parseDouble(""+i));
		}
		
		SortedSet<Double> ss1 = new SortedSet<>(dc);
		for(int i=20;i<100;i++) {
			ss1.add(Double.parseDouble(""+i));
		}
		
		assertEquals("Toma los elementos mayores-iguales que 20",ss1,ss.tailSet(Double.parseDouble("20.0")));
		assertEquals("Toma los elementos mayores-iguales que 150",new SortedSet<>(dc),ss.tailSet(Double.parseDouble("150.0")));
		assertEquals("Toma los elementos mayores-iguales que 100",new SortedSet<>(dc),ss.tailSet(Double.parseDouble("100.0")));
		assertEquals("Toma los elementos mayores-iguales que 0",ss,ss.tailSet(Double.parseDouble("0.0")));
		assertEquals("Toma los elementos mayores-iguales que -5",ss,ss.tailSet(Double.parseDouble("-5.0")));
		
	}
	
	@Test
	public void testTailSetPersona() {

		SortedSet<Persona> ss = new SortedSet<>(ppe);
		SortedSet<Persona> ss1 = new SortedSet<>(ppe);
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20-"+i,20));
			ss1.add(new Persona("PersonaDe20-"+i,20));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe10-"+i,10));
		}
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe20b-"+i,20));
			ss1.add(new Persona("PersonaDe20b-"+i,20));
		}
		
		for(int i=0;i<10;i++) {
			ss.add(new Persona("PersonaDe50-"+i,50));
			ss1.add(new Persona("PersonaDe50-"+i,50));
		}
		
		
		
		
		assertEquals("Toma las personas mayores-iguales de 20",ss1,ss.tailSet(new Persona("PersonaDe20",20)));
		assertEquals("Toma las personas mayores-iguales de 60",new SortedSet<>(dc),ss.tailSet(new Persona("PersonaDe60",60)));
		assertEquals("Toma las personas mayores-iguales de 10",ss,ss.tailSet(new Persona("PersonaDe10",10)));
		assertEquals("Toma las personas mayores-iguales de 5",ss,ss.tailSet(new Persona("PersonaDe5",5)));
		
		
	}
	
	
}
