// 20. Valid Parentheses

package HW_Java_4;

import java.util.Stack;

public class Task_1 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));

        s = "()[]{}";
        System.out.println(isValid(s));

        s = "(]";
        System.out.println(isValid(s));

        s = "([)]";
        System.out.println(isValid(s));

        s = "[()]";
        System.out.println(isValid(s));

        s = "]()]";
        System.out.println(isValid(s));

        s = "[[";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character curCh : s.toCharArray()) {
            if (curCh == '(' || curCh == '[' || curCh == '{') {
                stack.push(curCh);
            } else if (!stack.empty()) {
                char ch = stack.peek();
                if ((curCh == ')' && ch == '(') || (curCh == '}' && ch == '{') || (curCh == ']' && ch == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}