
public interface Collection<T> {
	boolean add(T a);
	void clear();
	boolean contains (Object a);
	boolean equals (Object a);
	boolean isEmpty();
	boolean remove (Object a);
	int size();
	Object[] toArray();
}
