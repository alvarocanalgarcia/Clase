
public interface AbsList <T> extends Collection<T>{
	public boolean add(T a);
	public void clear();
	public boolean contains(Object a);
	public T get(int a);
	public boolean isEmpty();
	public boolean remove(Object a);
	public T remove(int a);
	public int size();
	public T set(int a, T b);
	public boolean equals(Object a);
	public AbsList<T> subList(int a, int b);
	public String toString();
	public Object[] toArray();
}
