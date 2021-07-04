package test.stack;

public class TwoStack {
    public static void main(String[] args) {
        var twoStack = new stack.TwoStack(8);
        twoStack.push1(12);
        twoStack.push2(6);
        twoStack.push2(15);
        twoStack.push1(12);
        twoStack.push1(6);
        twoStack.push1(15);
        twoStack.push2(19);
        // twoStack.push1(11);
        twoStack.push2(6);
        System.out.println(twoStack);
    }
}
