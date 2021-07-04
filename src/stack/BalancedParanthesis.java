package stack;

import java.util.LinkedList;

public class BalancedParanthesis {
    public boolean isBalanced(String string) {
        var stack = new LinkedList<Character>();

        if (string == null)
            throw new IllegalArgumentException();

        for (char ch : string.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                else {
                    var left = stack.pop();
                    switch (left) {
                        case '(':
                            if (ch == ')')
                                break;
                            else
                                return false;
                        case '{':
                            if (ch == '}')
                                break;
                            else
                                return false;

                        case '[':
                            if (ch == ']')
                                break;
                            else
                                return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
