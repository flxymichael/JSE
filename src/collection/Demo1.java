package collection;

import java.util.*;


public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        //迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String tmp = iterator.next();
            System.out.println(tmp);
        }
        ;

        MapTest();
    }

    //Set:无序、不重复，主要子类为HashSet,依靠hashmap的key实现
    //由于无序，不能用for循环遍历，可以用foreach和iterator
    private static void SetTest() {
        HashSet<String> set = new HashSet<>();
        set.add("666");
        set.add("666");
        set.add("666");
        for (String tmp : set
        ) {
            System.out.println(tmp);
        }
    }

    private static void MapTest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("123","f");
        map.put("234","fk");
        map.put("345","fku");
        Set<String> keySet = map.keySet();
        Collection<String> values = map.values();
        for (String tmp:keySet
             ) {
            System.out.println(tmp);
        }
        for (String tmp: values
             ) {
            System.out.println(tmp);
        }


    }
}
