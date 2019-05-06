package com.example.demo;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandProperties.Setter;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by sunyunhao on 2019/4/19.
 */
public class HystrixObservableCommandTest extends HystrixObservableCommand<String> {
    private final String name;
    public HystrixObservableCommandTest(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("groupkey"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500000)));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        return  Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observer) {
                System.out.println("ObservableCommandTest");
            }
        });
    }

    //    @Override
//    protected String getFallback() {
//        return "error, fallback";
//    }
}
