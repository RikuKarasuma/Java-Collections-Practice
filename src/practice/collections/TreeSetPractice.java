package practice.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetPractice
{

    public static void main(String[] args)
    {
        // A java.util.TreeSet class which will not
        // maintain the insertion order, will not
        // allow duplicates and will not allow nulls.
        // A TreeSet has ascending sorting.
        // A TreeSet has auto sorting, in ascending.
        TreeSet<String> treeSetPractice = new TreeSet<>();

        // A TreeSet will not maintain insertion order.
        treeSetPractice.add("1");
        treeSetPractice.add("3");
        treeSetPractice.add("2");

        // A TreeSet doesn't allow duplicates
        treeSetPractice.add("2");

        // A TreeSet doesn't allow nulls.
        // Will throw a nullpointerexception.
        //treeSetPractice.add(null);

        // A TreeSet auto sorts in ascending order.
        // For more complex sorting, java.util.stream.Stream
        // can be used.
        treeSetPractice.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // A TreeSet is not thread safe. However we can use
        // java.util.Collections function to return a SynchronizedSet
        // which will allow us serial thread safe access.
        Set<String> synchronizedSet = Collections.synchronizedSet(treeSetPractice);

        // When using synchronized collections from java.util.Collections.
        // We must use synchronized blocks when iterating over it. Or
        // else risk non-deterministic behavior.
        synchronized (synchronizedSet)
        {
            synchronizedSet.forEach(System.out::println);
        }
    }
}
