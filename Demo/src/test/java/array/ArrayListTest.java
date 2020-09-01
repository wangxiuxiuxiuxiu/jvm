package array;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList <String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("3");
        list.add("5");
        list.add("1");
        list.add("1");

       // list = removeDuplicate_2( list);
     //  list =  remove( list);


        Map map = new HashMap();
        map.put("jack",100);
        map.put("lucy",200);
        map.put("lucy",300);
        map.get("lucy");
/*
        for (String SS:list) {
            System.out.println(SS);
        }*/
    }
    public static ArrayList removeDuplicate_2(ArrayList list){
        HashSet set = new HashSet(list);
        //使用LinkedHashSet可以保证输入的顺序
        //LinkedHashSet<String> set2 = new LinkedHashSet<String>(list);
        list.clear();
        list.addAll(set);
        return list;
    }
    public static ArrayList remove(ArrayList<String> list){


        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String na = iterator.next();
            if(na.equals("1")){
                iterator.remove();
            }
        }


        return list;
    }


}
