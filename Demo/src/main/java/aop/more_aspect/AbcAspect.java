package aop.more_aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AbcAspect {
    @Before("execution(* aop.more_aspect.UserService.*(..))")
    public void abc() {
        System.out.println("abc abc abc");
    }
    @Before("execution(* aop.more_aspect.UserService.*(..))")
    public void def() {
        System.out.println("def def def");
    }
}
