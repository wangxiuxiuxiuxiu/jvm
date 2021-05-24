package beanlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat {

    @Value("miaomiao")
    private String name;

    @Autowired
    private Person master;

    // getter setter toString

    public void setName(String name) {
        this.name = name;
    }

    public void setMaster(Person master) {
        this.master = master;
    }

    public String getName() {
        return name;
    }

    public Person getMaster() {
        return master;
    }
}