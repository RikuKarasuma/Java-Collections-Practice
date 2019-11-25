package practice.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListPractice
{

    public static void main(String[] args)
    {
        // LinkedList is available in java.util.
        LinkedList<String> linkedListType = new LinkedList<>();

        // LinkedList elements are listed in order of insertion.
        linkedListType.add("2");
        linkedListType.add("1");
        linkedListType.add("3");

        // LinkedList allows duplicate elements.
        linkedListType.add("2");

        // LinkedList doesn't contain sorting functions.
        // However java.util.stream.Stream can be used to sort
        // for us in this situation.
        linkedListType.stream().sorted().forEach(System.out::println);

        // linkedList contains a function called push, which pushes an
        // element to the top of the stack.
        linkedListType.push("2b");

        // LinkedList contains a function called pop, which returns and
        // removes the first element on top of this list.
        linkedListType.pop();

        // LinkedList allows Nulls to be elements.
        linkedListType.add(null);

        // LinkedLists are not thread safe, however a java.util.Collections
        // function can return a thread safe list that can be serially accessed
        // by multiple threads.
        List<String> threadSafe = Collections.synchronizedList(linkedListType);

        // We must use the synchronized block with the synchronized list though.
        // Or else we might face non-deterministic behavior.
        synchronized (threadSafe) {
            threadSafe.forEach(System.out::println);
        }
    }
}
