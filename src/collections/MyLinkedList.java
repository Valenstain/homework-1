package collections;
/**
 * Реализация двунаправленного связанного списка
 * @author Солодков Владимир
 * @version 1.0.0
 * @param <T> тип объекта
 */
public class MyLinkedList<T> implements MyList<T> {

    /**
     * Первый узел
     */
    private Node<T> first;
    /**
     * Последний узел
     */
    private Node<T> last;

    /**
     * Конструктор для создания связанного списка
     */
    public MyLinkedList() {
        first = null;
        last = null;
    }

    /**
     * Получение узла из связанного списка
     * @param index индекс элемента, если индекс находится вне диапазона, вызывается исключение IndexOutOfBoundsException
     * @return возвращает найденный узел
     */
    private Node<T> getNode(int index) {

        // Индекс не может быть меньше 0
        if (index < 0)
            throw new IndexOutOfBoundsException();

        // Задаем начальное значение
        Node<T> node = first;

        // Перебираем все элементы используя ссылку на следующий элемент
        for (int i = 1; i <= index; i++) {

            node = node.getNext();

            if (node == null)
                throw new IndexOutOfBoundsException();
        }

        return node;
    }

    @Override
    public void add(T item) {

        Node<T> newNode = new Node<>(item);

        // Если первого элемента нет
        if (first == null)
            first = newNode;

        // Если последний есть, меняем ссылки
        if (last != null) {
            newNode.setPrevious(last);
            last.setNext(newNode);
        }

        // Заменяем последний элемент
        last = newNode;
    }

    @Override
    public boolean remove(T item) {

        // Если запрашиваемая нода первая
        if (item.hashCode() == first.getValue().hashCode() && item.equals(first.getValue())) {
            Node<T> nextNode = first.getNext();
            nextNode.setPrevious(null);
            first = nextNode;
            return true;
        }

        // Если запрашиваемая нода последняя
        if (item.hashCode() == last.getValue().hashCode() && item.equals(last.getValue())) {
            Node<T> prevNode = last.getPrevious();
            prevNode.setNext(null);
            last = prevNode;
            return true;
        }

        // Не первая и не последняя, придеться искать
        Node<T> node = first.getNext();

        while (node != null) {

            if (item.hashCode() == node.getValue().hashCode() && item.equals(node.getValue())) {
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
                return true;
            }

            node = node.getNext();
        }

        return false;
    }

    @Override
    public boolean remove(int index) {

        // Если запрашиваемая нода первая
        if (index == 0) {
            Node<T> nextNode = first.getNext();
            nextNode.setPrevious(null);
            first = nextNode;
            return true;
        }

        Node<T> node = getNode(index);

        // Если запрашиваемая нода последняя
        if (node.getValue().hashCode() == last.getValue().hashCode() && node.getValue().equals(last.getValue())) {
            Node<T> prevNode = last.getPrevious();
            prevNode.setNext(null);
            last = prevNode;
            return true;
        }

        // Где-то посередине
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());

        return true;
    }

    @Override
    public T get(int index) {
        return getNode(index).getValue();
    }

    @Override
    public void set(int index, T item) {

        // Индекс не может быть меньше 0
        if (index < 0)
            throw new IndexOutOfBoundsException();

        // Получаем узел и задаем значение
        getNode(index).setValue(item);
    }

    @Override
    public MyList<T> subList(int start, int end) {

        // Индекс не может быть меньше 0
        if (start < 0)
            throw new IndexOutOfBoundsException();

        // Создаем новый список
        MyList<T> subList = new MyLinkedList<>();

        // Задаем начальное значение узла
        Node<T> node = first;

        // Перебираем все значения, когда значения попадают
        // в диапозон - добавляем в новый список
        for (int i = 0; i <= end; i++) {

            if (node == null)
                throw new IndexOutOfBoundsException();

            if (start <= i)
                subList.add(node.getValue());

            node = node.getNext();
        }

        return subList;
    }

    @Override
    public int size() {

        // Счетчик
        int size = 0;

        // Задаем начальное значение узла
        Node<T> node = first;

        // Перебираем все значения и считаем
        while (node != null) {
            node = node.getNext();
            size++;
        }

        return size;
    }

    @Override
    public void forEach(ForEach fe) {

        // Задаем начальное значение узла
        Node<T> node = first;

        // Перебираем все значения и пропускаем их
        // через функциональный интерфейс
        while (node != null) {
            fe.fn(node.getValue());
            node = node.getNext();
        }
    }

    /**
     * String представление списка
     * @return возвращает String представление списка
     */
    @Override
    public String toString() {

        // Задаем начальное значение узла
        Node<T> node = first;

        // Создаем StringBuilder для записи значений
        StringBuilder sb = new StringBuilder();

        // Перебираем все значения
        while (node != null) {
            sb.append(node.getValue()).append(", ");
            node = node.getNext();
        }

        // Удаляем запятую в конце
        sb.delete(sb.length() - 2, sb.length());

        return String.format("{ %s }", sb);
    }
}
