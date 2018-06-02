package com.yao.chapter19_Composite;

/**
 * Created by shanyao on 2018/6/2.
 */
public class CompositeMain {
    public static void main(String[] args) {
        //生成树根roo，跟上长出两叶LeafA，LeafB
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        //根上长出分支CompositeX,分支上也长出两页LeafXA，LeafXB
        Composite composite = new Composite("Composite X");
        composite.add(new Leaf("Leaf XA"));
        composite.add(new Leaf("Leaf XB"));

        root.add(composite);

        //在Compisite X上在长出分支Conposite XY，分支上也长出两页LeafXYA，LeafXYB
        Composite composite2 = new Composite("Composite XY");
        composite2.add(new Leaf("Leaf XYA"));
        composite2.add(new Leaf("Leaf XYB"));
        composite.add(composite2);

        //根部又长出两叶LeafC，LeafD，可惜D没张牢北风吹掉了
        root.add(new Leaf("Leaf C"));
        Leaf leaf =new Leaf("Leaf D");
        root.add(leaf);
        root.remove(leaf);

        root.display(1);

    }
}
