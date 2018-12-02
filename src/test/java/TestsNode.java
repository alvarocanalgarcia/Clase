import static org.junit.Assert.*;

import org.junit.Test;

public class TestsNode {

	@Test
	public void testConstructorVacio() {
		Node<Integer> n = new Node<Integer>();
		assertEquals("El elem de un nodo vacío es null ",null,n.getElem());
		assertEquals("El next de un nodo vacío es null ",null,n.getNext());
	}
	
	@Test
	public void testConstructorObjeto() {
		Node<Integer> n = new Node<Integer>(1);
		assertTrue("El elem del nodo es 1",1==n.getElem());
		assertEquals("El next del nodo es null ",null,n.getNext());
	}

}
