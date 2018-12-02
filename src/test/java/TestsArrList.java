import static org.junit.Assert.*;

import org.junit.Test;

public class TestsArrList {

	@Test
	public void testConstructor() {
		ArrList<Integer> al = new ArrList<>();	
		assertEquals("El tamaño de la lista es 0",0,al.size());
	}
	
		
	
	
	@Test
	public void testAdd() {
		ArrList<Integer> al = new ArrList<>();	
		for(int i=0;i<1000;i++) {
			assertEquals("El elemento " + i + " fue añadido",true,al.add(i));
			assertEquals("La lista contiene el elemento " + i,true,al.contains(i));
			assertEquals("La longitud de la lista es " + i+1,i+1,al.size());
		}
		
		assertEquals("No se pueden añadir más elementos ",false,al.add(1000));
		assertEquals("No se añadió el elemento ",false,al.contains(1000));
		assertEquals("La longitud de la lista es 1000",1000,al.size());
		
	}
	
	@Test
	public void testClear() {
		ArrList<Integer> al = new ArrList<>();	
		for(int i=0;i<1000;i++) {
			assertEquals("El elemento " + i + " fue añadido",true,al.add(i));
			assertEquals("La lista contiene el elemento " + i,true,al.contains(i));
			assertEquals("La longitud de la lista es " + i+1,i+1,al.size());
		}
		al.clear();
		assertEquals("La longitud de la lista es 0",0,al.size());
		for(int i=0;i<1000;i++) {
			assertEquals("El elemento " + i + " fue añadido de nuevo",true,al.add(i));
		}
		
	}
	

	
	@Test
	public void testGetGreaterOrEqualThanLength() {
		ArrList<Integer> al = new ArrList<>();	
		for(int i=0;i<50;i++) {
			al.add(i);
		}
		
		for(int i=50;i<100;i++) {
			assertEquals("No hay elemento " + i,null,al.get(i));
		}
				
	}
	
	@Test
	public void testIsEmpty() {
		ArrList<Integer> al = new ArrList<>();	
		assertEquals("Al comienzo la lista está vacía",true,al.isEmpty());
		al.add(1);
		assertEquals("Al añadir un elemento la lista deja de estar vacía",false,al.isEmpty());
	}

	@Test
	public void testRemove() {
		ArrList<Double> al = new ArrList<>();	
		for(int j=0;j<4;j++) {
		for(int i=0;i<250;i++) {
			al.add(Double.parseDouble(""+i));
		}
		}
		for(int i=0;i<250;i++) {
			assertEquals("El elemento " + i + " fue eliminado",true,al.remove(Double.parseDouble(""+i)));
			assertEquals("La lista no contiene el elemento " + i,false,al.contains(Double.parseDouble(""+i)));
			assertEquals("La longitud de la lista es " + (1000-(i+1)*4),(1000-(i+1)*4),al.size());
		}
		
		assertEquals("El elemento no fue eliminado porque no estaba",false,al.remove(Double.parseDouble("-1")));
	}
	
	
	@Test
	public void testRemoveIsEmpty() {
		ArrList<Double> al = new ArrList<>();	
		assertEquals("Al comienzo la lista está vacía",true,al.isEmpty());
		al.add(Double.parseDouble(""+1));
		assertEquals("Al añadir un elemento la lista deja de estar vacía",false,al.isEmpty());
		al.remove(Double.parseDouble(""+1));
		assertEquals("Al eliminar el elemento la lista esta vacía de nuevo",true,al.isEmpty());
	}
	
	
	@Test
	public void testSet() {
		ArrList<Integer> al = new ArrList<>();	
		assertEquals("El método set no se puede usar al principio ",null,al.set(0,0));
		
		
		for(int i=0;i<250;i++) {
			al.add(i);
		}
		
		for(int i=0;i<250;i++) {
			al.set(i,250+i);
			assertEquals("La lista contiene al nuevo elemento ",true,al.contains(250+i));
		}
		
		for(int i=250;i<500;i++) {
			assertEquals("No se puede añadir en la posición " + i,null,al.set(i,i));
		}	
	}
	
	@Test
	public void testGetSet() {
		ArrList<Integer> al = new ArrList<>();	
		for(int i=0;i<50;i++) {
			al.add(i);
		}
		
		for(int i=0;i<50;i++) {
			Integer o = al.get(i);
			assertEquals("Hemos añadido el elemento en la posición " + i,o,al.set(i,250+i));
			assertTrue("Hemos añadido correctamente el elemento en la posición " + i,250+i==al.get(i));
		}
				
	}
	
	
	@Test
	public void testToString() {
		ArrList<Integer>  al= new ArrList<>();
		assertEquals("Caso lista vacía ",null,al.toString());
		
	}
	
	@Test
	public void testRemoveIndex() {
		ArrList<Double> al = new ArrList<>();
		for(int i=0;i<100;i++) {
			al.add(Double.parseDouble(""+i));
		}
		assertEquals("No se puede eliminar un elemento si el índice es menor que 0",null,al.remove(-1));
		assertEquals("El tamaño de la lista no disminuye",100,al.size());
		assertEquals("No se puede eliminar un elemento si el índice es mayor que la longitud",null,al.remove(500));
		assertEquals("El tamaño de la lista no disminuye",100,al.size());
		assertEquals("Podemos eliminar el primer elemento",Double.parseDouble(""+0),(Double)al.remove(0),0.001);
		assertEquals("El tamaño de la lista disminuye en 1",99,al.size());
		for(int i=0;i<99;i++) {
			assertEquals("Resto elementos lista están en posición correcta",Double.parseDouble(""+(i+1)),(Double)al.get(i),0.001);
		}
		assertEquals("Podemos eliminar el último elemento",Double.parseDouble("99"),(Double)al.remove(98),0.001);
		assertEquals("El tamaño de la lista disminuye en 1",98,al.size());
		for(int i=0;i<98;i++) {
			assertEquals("Resto elementos lista están en posición correcta",Double.parseDouble(""+(i+1)),(Double)al.get(i),0.001);
		}
		
		assertEquals("Podemos eliminar un elemento de la mitad",Double.parseDouble("50"),(Double)al.remove(49),0.001);
		assertEquals("El tamaño de la lista disminuye en 1",97,al.size());
		for(int i=0;i<49;i++) {
			assertEquals("Resto elementos lista están en posición correcta",Double.parseDouble(""+(i+1)),(Double)al.get(i),0.001);
		}
		for(int i=49;i<97;i++) {
			assertEquals("Resto elementos lista están en posición correcta",Double.parseDouble(""+(i+2)),(Double)al.get(i),0.001);
		}
		
	}
	
	
	@Test
	public void testEqual() {
		ArrList<Double> al = new ArrList<>();
		for(int i=0;i<5;i++) {
			al.add(Double.parseDouble(""+i));
		}
		
		ArrList<Double> al2 = new ArrList<>();
		for(int i=0;i<5;i++) {
			al2.add(Double.parseDouble(""+i));
		}
		
		
		assertEquals("Una lista es igual a si misma",al,al);
		assertEquals("Dos listas construidas del mismo modo son iguales",al,al2);
		
		al2.add(7.0);
		assertNotEquals("Listas de distinto tamaño son distintas",al,al2);
		
		
		ArrList<Double> al3 = new ArrList<>();
		for(int i=4;i>=0;i--) {
			al3.add(Double.parseDouble(""+i));
		}
		assertNotEquals("Listas con mismos elementos pero ordenados al revés son distintas",al,al3);
		
		
		assertNotEquals("Lista con elementos es distinta a la lista nula",al,null);
	}
	
	@Test
	public void testSubList() {
		ArrList<Double> al = new ArrList<>();
		for(int i=0;i<100;i++) {
			al.add(Double.parseDouble(""+i));
		}
		
		
		assertNull("Caso primer índice mayor que segundo",al.subList(12,8));
		assertNull("Caso primer índice mayor que tamaño lista",al.subList(105,150));
		
		
		ArrList<Double> al1 = new ArrList<>();
		for(int i=0;i<10;i++) {
			al1.add(Double.parseDouble(""+(i+10)));
		}
		assertEquals("Caso bueno, sublista de los índices 10 a 20",al1,al.subList(10,20));
		
		
		ArrList<Double> al2 = new ArrList<>();
		for(int i=0;i<5;i++) {
			al2.add(Double.parseDouble(""+(i+95)));
		}
		assertEquals("Caso segundo índice mayor que tamaño lista",al2,al.subList(95,150));
		assertEquals("Caso segundo índice igual que tamaño lista",al2,al.subList(95,100));
		
		ArrList<Double> al3 = new ArrList<>();
		for(int i=0;i<10;i++) {
			al3.add(Double.parseDouble(""+(i)));
		}
		assertEquals("Caso primer índice negativo",al3,al.subList(-5,10));
		
		assertEquals("Caso primer índice negativo, segundo índice mayor que tamaño lista",al,al.subList(-5,150));
		
		
	}
	
	
	@Test
	public void testToArray() {
			
		ArrList<Double> al = new ArrList<>();
		assertNull("Caso lista vacía",al.toArray());
		
		Object[] res = new Object[5];
		
		for(int i=0;i<5;i++) {
			al.add(Double.parseDouble(""+i));
			res[i]=Double.parseDouble(""+i);
		}
		
		
		assertArrayEquals("toArray es correcto",al.toArray(),res);
	}
}
