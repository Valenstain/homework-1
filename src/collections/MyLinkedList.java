package collections;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> first;
    private Node<T> last;

    public MyLinkedList() {
        first = null;
        last = null;
    }

    private Node<T> getNode(int index) {

        if (index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> node = first;

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

        if (first == null)
            first = newNode;

        if (last != null) {
            newNode.setPrevious(last);
            last.setNext(newNode);
        }

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

        if (index < 0)
            throw new IndexOutOfBoundsException();

        getNode(index).setValue(item);
    }

    @Override
    public MyList<T> subList(int start, int end) {

        if (start < 0)
            throw new IndexOutOfBoundsException();

        MyList<T> subList = new MyLinkedList<>();
        Node<T> node = first;

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

        int size = 0;
        Node<T> node = first;

        while (node != null) {
            node = node.getNext();
            size++;
        }

        return size;
    }

    @Override
    public void forEach(ForEach fe) {

        Node<T> node = first;

        while (node != null) {
            fe.fn(node.getValue());
            node = node.getNext();
        }
    }

    @Override
    public String toString() {

        Node<T> node = first;
        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node.getValue()).append(", ");
            node = node.getNext();
        }

        sb.delete(sb.length() - 2, sb.length());

        return String.format("{ %s }", sb);
    }
}
