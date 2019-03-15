package Block8;

import Block8.my_array_list.MyArrayList;
import Block8.my_array_list.MyList;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CollectionTask collectionTask = new CollectionTask();

        Integer[] ints = {4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7};

        collectionTask.recieveNumberOfEntry(ints).forEach((k, v) -> System.out.println(k + "- " + v));

        List<Integer> integers = new ArrayListWithOutRemove<>();
        integers.add(1);
        integers.remove(0);


        MyList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");

        myArrayList.forEach(s -> System.out.println(s));


    }
}
