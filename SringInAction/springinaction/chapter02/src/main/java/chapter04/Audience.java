package chapter04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    //定义一个可重用的切点
    //该方法内容应该是一个空的，本身只是一个标识
    @Pointcut("execution(* chapter04.Performance.perform(..))")
    public void performance(){}
    //前置通知
    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("关闭手机");
    }
    //前置通知
    @Before("performance()")
    public void takeSeats() {
        System.out.println("坐好");
    }
    //后置通知
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("鼓掌");
    }
    //异常通知
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("失败了，没关系，重新开始！");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("手机静音");
            System.out.println("坐好");
            jp.proceed();
            System.out.println("鼓掌");
        } catch (Throwable throwable) {
            System.out.println("异常");
        }
    }
}
