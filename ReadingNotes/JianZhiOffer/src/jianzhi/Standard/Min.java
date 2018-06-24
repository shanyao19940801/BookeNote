package jianzhi.Standard;

import java.util.Stack;

/**
 * Created by shanyao on 2018/6/24.
 */
public class Min {
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

}
