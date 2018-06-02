package com.yao.chapter19_Composite;

/**
 * Created by shanyao on 2018/6/2.
 * Leaf在组合中表示叶节点对象，叶节点没有子节点
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    public void add(Component component) {
        System.out.println("不能添加子节点");
    }

    public void remove(Component component) {
        System.out.println("没有子节点");
    }

    public void display(int depth) {

        String g = "";
        for (int i = 0; i < depth; i++) {
            g += "-";
        }
        System.out.println("-" + g + name);
    }
}
