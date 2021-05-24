package aop.more_aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class AspectOrderApplication {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectOrderConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.saveUser("abc");
     //   Assert.notNull(null,"BeanDefinitionRegistry must not be null");
        System.out.println("............999");



    }
}







