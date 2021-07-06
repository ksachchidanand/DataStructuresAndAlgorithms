package stack;

import java.util.ArrayList;

public class ArrayListBased<T> {
    private ArrayList<T> items;
    private int top;

    public ArrayListBased() {
        items = new ArrayList<>();
        top = -1;
    }

    public void push(T item) {
        items.add(++top, item);
    }

    public T pop() {
        return items.remove(top--);
    }

    public T peek() {
        return items.get(top);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
