package beandefinition;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class Person {

    protected  String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
