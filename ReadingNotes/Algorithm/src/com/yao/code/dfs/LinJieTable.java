package com.yao.code.dfs;

import com.yao.util.ListNode;

/**
 * Created by shanyao on 2018/7/17.
 */
public class LinJieTable {
    public ListNode first;
    public ListNode last;

    public void insert(int x) {
        ListNode newNode = new ListNode(x);
        /*if(this.isEmpty()) {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }*/
    }
}
