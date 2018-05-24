package jianzhi.capter02.c03;

import java.util.Stack;

/**
 * Created by user on 2018/3/8.
 * 两个栈实现队列并
 */
public class Problem07 {
    private Stack<Integer> tail = new Stack<Integer>();
    private Stack<Integer> head = new Stack<Integer>();

    public void appendTail(Integer value) {
        if (head == null || head.size() == 0) {

            tail.add(value);
        } else {
            while(head.size() > 0) {
                tail.add(head.pop());
            }
            tail.add(value);
        }
    }

    public Integer deleteHead() throws Exception {
        if (head.isEmpty() && tail.isEmpty()) {
            throw new Exception("List is Enpoty");
        } else if (tail == null || tail.size() == 0) {
            return head.pop();
        } else {
            while(tail.size() > 0) {
                head.add(tail.pop());
            }
            return head.pop();
        }
    }

    public void Print() {
        System.out.print("Head:");
        for (Integer value : head) {
            System.out.print(value + " ");
        }
        System.out.print("Tail:");

        for (Integer value : tail) {
            System.out.print(value + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        Problem07 list = new Problem07();
        try {
            System.out.println(list.deleteHead());
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.appendTail(1);
        list.appendTail(2);
        list.appendTail(3);
        list.appendTail(4);
        list.Print();
        try {
            System.out.println(list.deleteHead());
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.Print();
        list.appendTail(6);
        list.Print();
    }
}
