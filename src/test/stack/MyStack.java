package test.stack;

public class MyStack {
    public static void main(String[] args) {
        var stack = new stack.MyStack();
        stack.push(5);
        stack.push(15);
        stack.push(25);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(35);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
