package jianzhi.chapter04.c04;

import jianzhi.Standard.RandomListNode;

import java.util.HashMap;

/**
 * Created by shanyao on 2018/6/25.
 */
public class Problem26 {
    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        RandomListNode clone = new RandomListNode(pHead.label);
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode returnNode = clone;
        map.put(pHead,clone);
        RandomListNode head = pHead;
        while(head!=null) {
            RandomListNode cloneT = new RandomListNode(head.label);
            map.put(head,cloneT);
            clone.next = cloneT;
            clone = clone.next;
            head = head.next;

        }
        clone = returnNode;
        head = pHead;
        while(head != null) {
            if(head.random == null) {
                clone.random = null;
            } else {
                clone.random = map.get(head.random);
            }
            head = head.next;
            clone = clone.next;
        }
        return returnNode;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        r1.next = r2;
        RandomListNode r3 = new RandomListNode(3);
        r2.next = r3;
        RandomListNode r4 = new RandomListNode(4);
        r3.next = r4;
        RandomListNode r5 = new RandomListNode(5);
        r4.next = r5;

        r1.random = r3;
        r2.random = r5;
        r3.random = null;
        r4.random = r2;
        r5.random = null;

        RandomListNode c = Clone(r1);
        System.out.println(r1);
    }
}
