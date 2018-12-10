package chapter04;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {
    //前置通知
    @Before("execution(** chapter04.Performance.perform(..))")
    public void silenceCellPhone() {
        System.out.println("关闭手机");
    }
    //前置通知
    @Before("execution(** chapter04.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("坐好");
    }
    //后置通知
    @AfterReturning("execution(** chapter04.Performance.perform(..))")
    public void applause() {
        System.out.println("鼓掌");
    }
    //异常通知
    @AfterThrowing("execution(** chapter04.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("失败了，没关系，重新开始！");
    }


}
