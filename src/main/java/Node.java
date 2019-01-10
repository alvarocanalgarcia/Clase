public class Node<T> {
	private T elem;
	private Node<T> next;
	
	public Node() {
		this.elem=null;
		this.next=null;
	}
	public Node (T a) {
		this.elem=a;
		this.next=null;
	}
	public T getElem() {
		return this.elem;
	}
	public void setElem(T a) {
		this.elem=a;
	}
	public Node<T> getNext() {
		return this.next;
	}
	public void setNext(Node<T> a) {
		this.next=a;
	}
}
