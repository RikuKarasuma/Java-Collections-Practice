package practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListPractice
{
    public static void main(String[] args)
    {
        ArrayList<String> arrayListType = new ArrayList<>();

        //ArrayList uses insertion order.
        arrayListType.add("1");
        arrayListType.add("3");
        arrayListType.add("2");

        // ArrayList allows duplicates.
        arrayListType.add("1");

        // ArrayList does not contain sorting
        // Streams can be used to sort instead.
        // java.util.stream.Stream<E>
        arrayListType.stream().sorted().forEach(System.out::println);

        // ArrayList allows null elements
        arrayListType.add(null);

        // ArrayList is not Thread safe.
        // But a Collections function can generate a
        // serially accessible list for you.
        List<String> synchronizedList = Collections.synchronizedList(arrayListType);

        // We must use the synchronized block when iterating over the list,
        // or we might face non-deterministic behavior.
        synchronized (synchronizedList) {
            synchronizedList.forEach(System.out::println);
        }
    }
}
