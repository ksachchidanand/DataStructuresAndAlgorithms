package stack;

public class MyStack {
    private int[] stack;
    private int size;

    public MyStack() {
        stack = new int[10];
    }

    public MyStack(int capacity) {
        stack = new int[capacity];
    }

    public void push(int item) {
        stack[size++] = item;
    }

    public int pop() {
        return stack[--size];
    }

    public int peek() {
        return stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
