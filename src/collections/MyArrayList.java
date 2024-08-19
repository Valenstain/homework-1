package collections;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private Object[] list;

    public MyArrayList() {
        this.list = new Object[0];
    }

    public MyArrayList(Object[] list) {
        this.list = list;
    }

    @Override
    public void add(T item) {
        Object[] newList = new Object[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        newList[newList.length - 1] = item;
        list = newList;
    }

    @Override
    public boolean remove(T item) {

        int index = -1;

        for (int i = 0; i < list.length; i++) {
            if (list[i].hashCode() == item.hashCode() && list[i].equals(item)) {
                index = i;
                break;
            }
        }

        if (index >= 0)
            remove(index);

        return false;
    }

    @Override
    public boolean remove(int index) {

        if (index > list.length - 1 || index < 0)
            throw new IndexOutOfBoundsException();

        Object[] newList = new Object[list.length - 1];

        if (index > 0)
            System.arraycopy(list, 0, newList, 0, index);

        if (index != list.length - 1)
            System.arraycopy(list, index + 1, newList, index, list.length - (index + 1));

        list = newList;

        return true;
    }

    @Override
    public T get(int index) {
        return (T) list[index];
    }

    @Override
    public void set(int index, T item) {
        list[index] = item;
    }

    @Override
    public MyList<T> subList(int start, int end) {

        Object[] newList = new Object[end - start + 1];
        System.arraycopy(list, start, newList, 0, end - start + 1);
        return new MyArrayList<>(newList);
    }

    @Override
    public int size() {
        return list.length;
    }

    public void forEach(ForEach liamda) {
        for (Object o : list)
            liamda.fn(o);
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
