public class LinkList<T> implements AbsList<T> {
	private Node head;
	private int length;
	
	public LinkList() {
		this.head=null;
		this.length=0;
	}
	
	public boolean add(T a) {
		Node aux = new Node(a);
		if(this.head==null) {
			this.head=aux;
		}
		else {
			Node i = this.head;
			while(i.getNext()!=null) {
				i=i.getNext();
			}
			i.setNext(aux);
		}
		this.length++;
		return true;
	}
	
	public void clear() {
		this.head=null;
		this.length=0;
	}
	
	public boolean contains(Object a) {
		boolean existe=false;
        Node aux= this.head;
 
        while(aux!=null && existe==false){
            if(aux.getElem().equals(a)){
                existe=true;
            }
            else aux=aux.getNext();
        }
        return existe;
	}
	
	public T get(int a) {
		T b=null;
		Node aux = this.head;
        int cont=0;
        if(a<this.length){
        while(cont<a) {
        	aux=aux.getNext();
        	cont++;
        }
        if(!(aux.getElem().equals(null))) {
        	b=(T)aux.getElem();
        }
        }
        return b;

	}
	
	public boolean isEmpty() {
		if(this.length==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean remove(Object a) {
		boolean cont=false;
		if(a!=null) {
			Node aux=this.head;
			while(aux!=null && aux.getElem().equals(a)) {
				this.head=this.head.getNext();
				aux=this.head;
				cont=true;
				this.length--;
			}
			if(aux!=null) {
				Node aux2=this.head;
				aux=this.head.getNext();
				while(aux!=null) {
					if(aux.getElem().equals(a) && aux!=null) {
						cont=true;
						aux=aux.getNext();
						aux2.setNext(aux);
						this.length--;
					}
					if(aux!=null) {
						aux=aux.getNext();
						aux2=aux2.getNext();
					}
				}
			}
		}
		return cont;
	}
	
	public T remove(int a) {
		if(0<=a&&a<this.length) {
			T aux=null;
			Node aux1=null;
			Node aux2=this.head;
			int cont=0;
			if(a==0) {
				aux=(T) this.head.getElem();
				this.head=this.head.getNext();
			}
			else {
				while(cont<a) {
					aux1=aux2;
					aux2=aux2.getNext();
					cont++;
				}
				aux=(T) aux2.getElem();
				aux1.setNext(aux2.getNext());
			}
			this.length--;
			return aux;
		}
		else {
			return null;
		}

	}
	
	public int size() {
		return this.length;
	}
	
	public T set(int a, T b) {
		T c=null;
		int cont=0;
		Node aux=this.head;
		if(a<this.length) {
			while(cont<a) {
				aux=aux.getNext();
				cont++;
			}
			if(!(aux.getElem().equals(null))) {
				
				c=(T) aux.getElem();
				aux.setElem(b);
			}
		}
		return c;
	}
	
	public boolean equals(Object a) {
		if(this==a) {
			return true;
		}
		if(a instanceof LinkList) {
			boolean b=true;
			Node aux=this.head;
			LinkList c=(LinkList)a;
			Node aux2 = c.head;
			if(this.length!=c.length) {
				return false;
			}
			while(aux!=null && b==true) {
				if(!aux.getElem().equals(aux2.getElem())) {
					b=false;
				}
				aux=aux.getNext();
				aux2=aux2.getNext();
			}
			return b;
		}
		else {
			return false;
		}

	}
	
	public AbsList<T> subList(int a, int b) {
		if(a>=b||a>this.length) {
			return null;
		}
		else {
		if(a<0) {
			a=0;
		}
		if(b>this.length) {
			b=this.length;
		}
		AbsList c=new LinkList();
		int d=0;
		Node aux = this.head;
		while(d<a) {
			aux=aux.getNext();
			d++;
		}
		while (a<b) {
			c.add(aux.getElem());
			aux=aux.getNext();
			a++;
		}
		return c;
		}

	}
	
	public String toString() {
		if (this.length==0) {
			return null;
		}
		else {
			Node aux=this.head;
			String a=null;
			while(aux!=null) {	
				a=a+super.toString();
				aux=aux.getNext();
			}
			return a;
		}
	}
	
	public Object[] toArray() {
		if(this.length==0)return null;
		else {
			Object[]arr=new Object[this.length];
			int i=0;
			Node aux = this.head;
			while(i<this.length) {
				arr[i]=aux.getElem();
				aux= aux.getNext();
				i++;
			}
			return arr;
		}
	}
}
