package day08;

import java.util.LinkedHashMap;
import java.util.Set;

public class ObjectTest {

    int m = 1000000000;
    public static void main(String[] args) {

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("jeck",100);
        linkedHashMap.put("luse",60);

        Set<String> set = linkedHashMap.keySet();
        for (String s:set) {
            System.out.println(linkedHashMap.get(s));
        }
    }
}
