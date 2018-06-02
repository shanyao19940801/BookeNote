package com.yao.chapter06_zhuanshi;


/**
 * Created by shanyao on 2018/4/30.
 */
public abstract class Decorator extends Component16 {
    protected Component16 component16;

    public void setComponent16(Component16 component16) {
        this.component16 = component16;
    }

    public void operation() {
        if (component16 != null) {
            component16.operation();
        }
    }
}
