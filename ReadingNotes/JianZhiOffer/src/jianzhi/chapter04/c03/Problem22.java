package jianzhi.chapter04.c03;

import java.util.Stack;

/**
 * Created by shanyao on 2018/6/24.
 */
public class Problem22 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack();
        int lenA = pushA.length;
        int lenB = popA.length;
        int b = 0;
        for(int i = 0; i < lenA; i++) {
            if(pushA[i]==popA[b]){
                b++;
                continue;
            } else {
                stack.push(pushA[i]);
            }
        }
        while(!stack.isEmpty()) {
            if(stack.pop() != popA[b++]){
                return false;
            }
        }
        return true;
    }
}
