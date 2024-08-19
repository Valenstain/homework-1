package collections;
/**
 * Интерфейс описывающий функционал списка
 * @author Солодков Владимир
 * @version 1.0.0
* */
public interface MyList<T> {
    /**
     * Добавление нового элемента в список
     * @param item добавляемый элемент
     */
    public void add(T item);

    /**
     * Удаление элемента из списка
     * @param item удаляемый элемент
     * @return возвращает true в случае успеха, иначе false
     */
    public boolean remove(T item);

    /**
     * Удаление элемента из списка по его индексу
     * @param index индекс удаляемого элемента
     * @return возвращает true в случае успеха, иначе false
     */
    public boolean remove(int index);

    /**
     * Получение одного элемента из списка
     * @param index индекс желаемого элемента
     * @return возвращает запрашиваемый элемент
     */
    public T get(int index);

    /**
     * Изменение элемента по его индексу
     * @param index индекс изменяемого элемента
     * @param item элемент на который будет произведена замена
     */
    public void set(int index, T item);

    /**
     * Получение нового списка используя диапазон из существующего
     * @param start начальный индекс
     * @param end конечный индекс
     * @return возвращает новый список заданного диапозона
     */
    public MyList<T> subList(int start, int end);

    /**
     * Получение количества элементов в списке
     * @return возвращает количество элементов в списке
     */
    public int size();

    /**
     * Дополнительный метод, для перебора всех элементов списка
     * @param fe Функциональный интерфейс для элементов списка
     */
    public void forEach(ForEach fe);
}
