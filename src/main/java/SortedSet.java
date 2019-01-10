import java.util.Comparator;

public class SortedSet<T> implements Collection<T> {
	private Comparator<T> comparator;
	private Object[] data=new Object[MAX];
	private int length;
	private final static int MAX=1000;
	
	public SortedSet(Comparator<T> a){
			this.comparator= a;
			this.length=0;
	}
	public boolean add(T a) {
		int i=0;
		if(this.length<MAX) {
			if(!this.contains(a)) {
				while(i<this.length) {
					T b=(T)this.data[i];
					if(comparator.compare(a,b)<0) {
						Object c=this.data[i];
						this.data[i]=a;
						Object d;
						i++;
						this.length++;
						while(i<this.length) {
							d=this.data[i];
							this.data[i]=c;
							c=d;
							i++;
						}
						return true;
					}
					i++;
				}
				this.data[this.length]=a;
				this.length++;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public void clear() {
		this.length=0;
	}
	public boolean contains(Object a) {
		int i=0;
		while(i<this.length) {
			if(this.data[i].equals(a)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public boolean equals(Object a) {
		if(this==a) {
			return true;
		}
		if(a instanceof SortedSet<?>) {
			int i=0;
			SortedSet<T> b=(SortedSet<T>) a;
			if(b.length!=this.length) {
				return false;
			}
			while(i<this.length) {
				if(!this.data[i].equals(b.data[i])) {
					return false;
				}
				i++;
			}
			return true;
		}
		else {
			return false;
		}
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
		int i=0;
		while(i<this.length) {
			if(this.data[i].equals(a)) {
				while(i<this.length) {
					this.data[i]=this.data[i+1];
					i++;
				}
				this.length--;
				return true;
			}
			i++;
		}
		return false;
	}
	public int size() {
		return this.length;
	}
	public Object[] toArray() {
		int i=0;
		Object[] a = new Object[this.length];
		while(i<this.length) {
			if(this.data[i]!=null) {
				a[i]=this.data[i];
			}
			i++;
		}
		return a;
	}
	public String toString() {
		if(this.length==0) {
			return null;
		}
		String a=this.data[0].toString();
		int i=1;
		while(i<this.length) {
			a=a+this.data[i].toString();
			i++;
		}
		return a;
	}
	public Comparator<T> getComparator(){
		return this.comparator;
	}
	public SortedSet<T> headSet(T a){
		int i=0;
		SortedSet<T> b=new SortedSet<T>(this.comparator);
		while(i<this.length) {
			T c=(T) this.data[i];
			if(this.comparator.compare(a,c)>0) {
				b.data[i]=this.data[i];
				b.length++;
			}
			i++;
		}
		return b;
	}
	public SortedSet<T> subSet(T a, T b){
		int i=0;
		int n=0;
		SortedSet<T> c=new SortedSet<T>(this.comparator);
		while(i<this.length) {
			T d=(T) this.data[i];
			if((this.comparator.compare(a,d)<=0) && (this.comparator.compare(b,d)>0)) {
				c.data[n]=this.data[i];
				c.length++;
				n++;
			}
			i++;
		}
		return c;
	}
	public SortedSet<T> tailSet(T a){
		int i=0;
		int n=0;
		SortedSet<T> b=new SortedSet<T>(this.comparator);
		while(i<this.length) {
			T c=(T) this.data[i];
			if(this.comparator.compare(a,c)<=0) {
				b.data[n]=this.data[i];
				b.length++;
				n++;
			}
			i++;
		}
		return b;
	}

}
