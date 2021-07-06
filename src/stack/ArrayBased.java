package stack;

import java.util.NoSuchElementException;

public class ArrayBased {
    private int[] items;
    private int top;

    public ArrayBased(int capacity) {
        items = new int[capacity];
        top = -1;
    }

    public void push(int item) {
        if (top == items.length - 1)
            throw new StackOverflowError();
        items[++top] = item;
    }

    public int pop() {
        if (top == -1)
            throw new NoSuchElementException();
        return items[top--];
    }

    public int peek() {
        if (top == -1)
            throw new NoSuchElementException();
        return items[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
