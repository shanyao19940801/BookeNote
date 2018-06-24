package jianzhi.chapter04.c03;

import java.util.Stack;

/**
 * Created by shanyao on 2018/6/24.
 */
public class Problem22 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minInt = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (!minInt.isEmpty()) {
            int top = minInt.peek();
            if (top > node)
                minInt.push(node);
            else {
                minInt.push(top);
            }
        } else {
            minInt.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minInt.pop();
    }

    public int top() {
        minInt.pop();
        return stack.pop();
    }

    public int min() {
        return minInt.peek();
    }

    public static void main(String[] args) {
/*        Stack s = new Stack();
        s.pop();*/
        Problem22 p = new Problem22();
        p.push(3);
        System.out.println(p.min());
        p.push(4);
        System.out.println(p.min());
        p.push(2);
        System.out.println(p.min());
        p.push(3);
        System.out.println(p.min());
        p.pop();
        System.out.println(p.min());
        p.pop();
        System.out.println(p.min());
        p.pop();
        System.out.println(p.min());
        p.push(0);
        System.out.println(p.min());
    }
}
