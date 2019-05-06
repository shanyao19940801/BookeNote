package com.example.demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * Created by sunyunhao on 2019/4/19.
 */
public class HystrixCommandTest extends HystrixCommand<String> {
    private final String name;
    public  HystrixCommandTest(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("groupkey"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("key"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadpool"))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(501))
        );
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
//        double random = Math.random();
//        if (random > 0.3){
//            int i = 1/0;
//        }
        int i = 1/0;
        return "Hello " + name + "!";
    }

//    @Override
//    protected String getCacheKey() {
//        return name;
//    }

//    @Override
//    protected String getFallback() {
//        System.out.println("fallback");
//        return "error, fallback";
//    }
}
