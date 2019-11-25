package practice.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetPractice
{
    public static void main(String[] args)
    {
        // A HashSet class from java.util.
        HashSet<String> hashSetType = new HashSet<>();

        // A HashSet doesn't insert variables by insertion
        // order. And won't maintain them in that order.
        hashSetType.add("3");
        hashSetType.add("1");
        hashSetType.add("2");

        // A HashSet doesn't allow duplicate values.
        hashSetType.add("1");

        // A HashSet doesn't contain sorting functions.
        // However by using the java.util.stream.Streams
        // return, we can use that sorting.
        hashSetType.stream().sorted().forEach(System.out::println);

        // A HashSet does allow a single null.
        hashSetType.add(null);

        // A HashSet isn't thread safe however we can get
        // around this by using the java.util.Collections
        // function to create a SynchronizedSet.
        Set<String> synchronizedHashSet = Collections.synchronizedSet(hashSetType);

        // When we iterate over the synchronized set, we must use
        // a synchronized block or risk non-deterministic behavior.
        synchronized (synchronizedHashSet)
        {
            synchronizedHashSet.forEach(System.out::println);
        }

    }
}
