package test.stack;

public class ArrayListBased {
    public static void main(String[] args) {
        var stack = new stack.ArrayListBased<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
