package chapter04;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {
    //前置通知
    @Before("execution(** chapter04.Performance.perform(..))")
    public void silenceCellPhone() {
        System.out.println("关闭手机");
    }
}
