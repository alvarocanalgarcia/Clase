public class ArrList<T> implements AbsList<T> {
	private Object[] data= new Object[MAX];
	private int length;
	private static final int MAX=1000;
	
	public ArrList() {
		this.length=0;
	}
	
	public boolean add(T a) {
		if(this.length < MAX) {
			this.data[this.length]=a;
			this.length++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clear() {
		while(this.length>0) {
			data[this.length-1]=0;
			this.length--;
		}
	}
	
	public boolean contains(Object a) {
		int n=0;
		boolean x= false;
		while((x==false) && n<this.length){
			if(data[n].equals(a)) {
				x=true;
			}
			n++;
		}
		return x;
	}
	
	public T get(int a) {
		T b = null;
		if(a < length) {
			b=(T)data[a];
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
		boolean x = false;
		int i=0;
		int contador=0;
		while(i<this.length) {
			this.data[i]=this.data[i+contador];
			while (a.equals(this.data[i])) {
				this.length--;
				contador++;
				x=true;
				if(i<this.length) {
					this.data[i]=this.data[i+contador];
				}
				else break;
			}
			i++;
		}
		return x;
	}
	
	public T remove(int a) {
		if(0<=a && a<this.length) {
			T aux;
			int cont=a;
			aux=(T)this.data[a];
			this.data[a]=null;
			while(cont<this.length) {
				this.data[cont]=this.data[cont+1];
				cont++;
			}
			length--;
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
		if(a < this.length) {
			c=(T) data[a];
			data[a]=b;
		}
		return c;
	}
	
	public boolean equals(Object a) {
		if(this==a) {
			return true;
		}
		if(a instanceof ArrList) {
			int i=0;
			ArrList b= (ArrList)a;
			boolean igual=true;
			if(this.length!=b.length) {
				return false;
			}
			while(i<this.length && igual==true) {
				if(!this.data[i].equals(b.data[i])) {
					igual=false;
				}
			i++;
			}
			return igual;
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
		AbsList c=new ArrList();
		while(a<b) {
			c.add(this.data[a]);
			a++;
		}
		return c;
		}

	}
	
	public String toString() {
		String a = null;
		if(!(this.length==0)) {
			int n=0;
			while(n<=this.length) {
				a=a+super.toString();
				n++;
			}
		}
	return a;
	}
	
	public Object[] toArray() {
		if(this.length==0)return null;
		else {
			
			Object[]arr=new Object[this.length];
			int i=0;
			while(i<this.length) {
				
				arr[i]=this.data[i];
				i++;
			}
			return arr;
			
		}

	}
	
}
