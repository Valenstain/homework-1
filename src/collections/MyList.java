package collections;
/**
 * @author Solodkov Vladimir
 * @version 1.0.0
* */
public interface MyList<T> {

    public void add(T item);

    public boolean remove(T item);

    public boolean remove(int index);

    public T get(int index);

    public void set(int index, T item);

    public MyList<T> subList(int start, int end);

    public int size();
}
