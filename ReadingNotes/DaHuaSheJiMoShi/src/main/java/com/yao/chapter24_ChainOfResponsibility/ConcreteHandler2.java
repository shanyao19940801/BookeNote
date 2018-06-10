package com.yao.chapter24_ChainOfResponsibility;

/**
 * Created by shanyao on 2018/6/10.
 */
public class ConcreteHandler2 extends Handler {
    public void HandleRequest(int request) {
        //当请求数在0-10之间有权处理，否则转到下一位
        if (request >= 10 && request < 20) {
            System.out.println("处理2号处理了"+request);
        } else if (successor != null){
            successor.HandleRequest(request);
        }
    }
}
