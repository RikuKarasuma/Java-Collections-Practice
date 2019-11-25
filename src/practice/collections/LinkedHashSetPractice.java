package practice.collections;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetPractice
{

    public static void main(String[] args)
    {
        // A LinkedHashSet from java.util. Which will maintain
        // its insertion order.
        LinkedHashSet linkedHashSetType = new LinkedHashSet();

        // A LinkedHashSet will maintain the variable insertion
        // order
        linkedHashSetType.add("1");
        linkedHashSetType.add("3");
        linkedHashSetType.add("2");

        // A LinkedHashSet doesn't allow duplicates.
        linkedHashSetType.add("1");

        // A LinkedHashSet will allow a single null.
        // However this crashes the stream return for some reason.
        // Doesn't appear in the HashSet
        //linkedHashSetType.add(null);

        // A LinkedHashSet doesn't contain sorting,
        // however we can use the java.util.stream.Streams
        // function to do this for us.
        linkedHashSetType.stream().sorted().forEach(System.out::println);

        // A LinkedHashSet isn't thread safe. However we can use
        // a java.util.Collections function to return a SynchronizedSet
        // which will be serially accessible.
        Set<String> synchronizedSet = Collections.synchronizedSet(linkedHashSetType);

        // When dealing with synchronized collections. We must use the
        // synchronized block when iterating over them. Or risk non
        // deterministic behavior.
        synchronized (synchronizedSet)
        {
            synchronizedSet.forEach(System.out::println);
        }
    }
}
