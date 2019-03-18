package Block8;

import Block8.my_array_list.MyArrayList;
import Block8.my_array_list.MyList;
import Block8.my_hash_map.MyHashMap;
import Block8.my_hash_map.MyMap;
import Block8.my_linked_list.Linked;
import Block8.my_linked_list.MyLinkedList;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CollectionTask collectionTask = new CollectionTask();

        Integer[] ints = {4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7};

        collectionTask.receiveNumberOfEntry(ints).forEach((k, v) -> System.out.println(k + "- " + v));

        List<Integer> integers = new ArrayListWithOutRemove<>();
        integers.add(1);
        integers.remove(0);


        MyList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");

        myArrayList.forEach(s -> System.out.println(s));

        System.out.println("//---------------------------------");

        Linked<String> strings = new MyLinkedList<>();
        strings.addFirst("1");
        strings.addFirst("2");
        strings.addFirst("3");
        strings.addLast("4");

        strings.remove(2);

        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println("//---------------------------------");


        MyMap<String, String> stringsMap = new MyHashMap<>();
        stringsMap.insert("1", "1");
        stringsMap.insert("2", "2");
        stringsMap.insert("3", "3");
        stringsMap.insert("4", "4");
        stringsMap.insert("5", "5");
        stringsMap.insert("6", "6");

        stringsMap.delete("4");


        for (String s : stringsMap) {
            System.out.println(s);
        }




    }
}
