package collections;

import java.util.Arrays;

/**
 * Реализация списка элементов используя массив
 * @author Солодков Владимир
 * @version 1.0.0
 * @param <T> тип объекта
 */
public class MyArrayList<T> implements MyList<T> {

    /**
     * Массив объектов
     */
    private Object[] list;

    /**
     * Конструктор для создания нового списка элементов
     * @see MyArrayList#MyArrayList(Object[] list)
     */
    public MyArrayList() {
        this.list = new Object[0];
    }

    /**
     * Конструктор для создания нового списка элементов используя массив
     * @param list массив элементов
     * @see MyArrayList#MyArrayList()
     */
    public MyArrayList(Object[] list) {
        this.list = list;
    }

    @Override
    public void add(T item) {

        // Создаем новый массив на 1 элемент больше
        Object[] newList = new Object[list.length + 1];

        // Копируем все элементы из старого в новый
        System.arraycopy(list, 0, newList, 0, list.length);

        // Добавляем новый элемент в конец
        newList[newList.length - 1] = item;

        // Заменяем массив на новый
        list = newList;
    }

    @Override
    public boolean remove(T item) {

        int index = -1;

        // Определяем индекс удаляемого объекта
        for (int i = 0; i < list.length; i++) {
            if (list[i].hashCode() == item.hashCode() && list[i].equals(item)) {
                index = i;
                break;
            }
        }

        // Удаляем элемент по индексу
        if (index >= 0)
            return remove(index);

        return false;
    }

    @Override
    public boolean remove(int index) {

        // Проверяем, находится ли индекс в диапазоне
        if (index > list.length - 1 || index < 0)
            throw new IndexOutOfBoundsException();

        // Создаем новый массив
        Object[] newList = new Object[list.length - 1];

        // Копируем левую часть до индекса
        if (index > 0)
            System.arraycopy(list, 0, newList, 0, index);

        // Копируем правую часть пропуская индекс удаляемого объекта
        if (index != list.length - 1)
            System.arraycopy(list, index + 1, newList, index, list.length - (index + 1));

        // Заменяем массив на новый
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

        // Создаем новый массив
        Object[] newList = new Object[end - start + 1];

        // Копируем часть массива в новый
        System.arraycopy(list, start, newList, 0, end - start + 1);

        return new MyArrayList<>(newList);
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public void forEach(ForEach liamda) {
        // Перебираем линейно все значения массива и пропускам
        // каждый элемент через функциональный интерфейс
        for (Object o : list)
            liamda.fn(o);
    }

    /**
     * String представление списка
     * @return возвращает String представление списка
     */
    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
