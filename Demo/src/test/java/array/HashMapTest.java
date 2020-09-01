package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/*Effective Java 第三版——11. 重写equals方法时同时也要重写hashcode方法*/
public class HashMapTest {
    public static void main(String[] args) {

        Map<Person,String> map = new HashMap();
       // Person person = new Person(20,"彭于晏");
        map.put(new Person(20,"彭于晏"),"LUCY");
        System.out.println(map.get(new Person(20,"彭于晏")));
        Object obj = new Object();
        obj.hashCode();
    }
}

class Person{
    private int age;
    private String name;

    Person(int age,String name){
        this.age=age;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

/*   @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }*/
}
