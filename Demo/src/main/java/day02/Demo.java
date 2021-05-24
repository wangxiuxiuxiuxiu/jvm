package day02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
        Dog bean = ctx.getBean(Dog.class);
        bean.say();
        ctx.close();
    }


}
@Profile("city")//Profile  标识在组件中，当组件是激活状态时，才会把组件加入ioc容器中
@Configuration
class config{
    @Conditional(ExistBossCondition.class)
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Dog getDog() {
        Dog dog = new Dog();
        dog.setName();
        return dog;
    }
}

