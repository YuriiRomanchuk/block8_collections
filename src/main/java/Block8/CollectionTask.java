package Block8;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CollectionTask {


    public Map<Integer, Integer> receiveNumberOfEntry(Integer... ints) {

        final Map<Integer, Integer> numbers = new TreeMap<>();

        Arrays.asList(ints).forEach(n->numbers.put(n, numbers.getOrDefault(n, 0)+1));

        return numbers;
    }

}
