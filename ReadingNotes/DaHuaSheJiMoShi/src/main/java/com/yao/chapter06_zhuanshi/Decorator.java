package com.yao.chapter06_zhuanshi;

/**
 * Created by shanyao on 2018/4/30.
 */
public abstract class Decorator extends Component{
    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    public void operation() {
        if (component != null) {
            component.operation();
        }
    }
}
