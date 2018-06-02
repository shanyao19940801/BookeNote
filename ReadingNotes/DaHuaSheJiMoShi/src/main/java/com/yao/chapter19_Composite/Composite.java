package com.yao.chapter19_Composite;

import java.util.ArrayList;
import java.util.List;
import com.yao.chapter19_Composite.Component;
/**
 * Created by shanyao on 2018/6/2.
 * Composite定义有节点行为，用来存储子部件，在Component接口中实现与子部件有关的操作，比如增加Add删除remove
 */
public class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public void display(int depth) {
        String g = "";
        for (int i = 0; i < depth; i++) {
            g += "-";
        }
        System.out.println("-" + g + name);

        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}
