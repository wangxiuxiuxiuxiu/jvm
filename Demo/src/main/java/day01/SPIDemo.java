package day01;


import java.util.Iterator;
import java.util.ServiceLoader;

public class SPIDemo{

    public static void main(String[] args) {
        ServiceLoader<SPID> load = ServiceLoader.load(SPID.class);
        Iterator<SPID> iterator = load.iterator();
        while (iterator.hasNext()){
            SPID next = iterator.next();
            next.say();
        }
    }

}

