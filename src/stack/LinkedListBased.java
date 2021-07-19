package stack;

import java.util.NoSuchElementException;

public class LinkedListBased<T> {
    private class Node {
        T item;
        Node next;

        Node(T item) {
            this.item = item;
        }
    }

    private Node head;
    private int size;

    public void push(T item) {
        var temp = head;
        head = new Node(item);
        head.next = temp;
        size++;
    }

    public T pop() {
        if (head == null)
            throw new NoSuchElementException();
        var temp = head;
        head = head.next;
        temp.next = null;
        size--;
        return temp.item;
    }

    public T peek() {
        if (head == null)
            throw new NoSuchElementException();
        return head.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
