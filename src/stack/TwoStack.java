package stack;

import java.util.Arrays;

public class TwoStack {
    private int[] twoStack;
    private int top1;
    private int top2;

    public TwoStack(int capacity) {
        twoStack = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    public void push1(int item) {
        if (top1 == top2 - 1)
            throw new StackOverflowError();
        twoStack[++top1] = item;
    }

    public void push2(int item) {
        if (top1 + 1 == top2)
            throw new StackOverflowError();
        twoStack[--top2] = item;
    }

    public int pop1() {
        if (top1 == -1)
            throw new IllegalArgumentException("Stack underflow");
        return twoStack[top1--];
    }

    public int pop2() {
        if (top2 == twoStack.length)
            throw new IllegalArgumentException("Stack underflow");
        return twoStack[top2++];
    }

    public int peek1() {
        if (top1 == -1)
            throw new IllegalArgumentException("Stack underflow");
        return twoStack[top1];
    }

    public int peek2() {
        if (top2 == twoStack.length)
            throw new IllegalArgumentException("Stack underflow");
        return twoStack[top2];
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == twoStack.length;
    }

    public int size1() {
        return top1 + 1;
    }

    public int size2() {
        return twoStack.length - top2;
    }

    @Override
    public String toString() {
        return Arrays.toString(twoStack);
    }
}
