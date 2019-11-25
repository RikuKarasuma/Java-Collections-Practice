package practice.collections;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapPractice
{
    public static void main(String[] args)
    {
        // A LinkedHashMap is from java.util package.
        // A LinkedHashMap maintains the insertion order.
        // It maintains Key, Value pairs.
        // Keys are unique.
        // Values can contain duplicates.
        // A LinkedHashMap isn't thread safe.
        // A LinkedHashMap doesn't provide sorting.
        // A LinkedHashMap only allows a single null key.
        // A LinkedHashMap allows multiple nulls.

        // A LinkedHashMap from java.util.
        LinkedHashMap<String, String> linkedHashMapPractice = new LinkedHashMap<>();

        // A LinkedHashMap will maintain its insertion order.
        linkedHashMapPractice.put("1", "One");
        linkedHashMapPractice.put("3", "Three");
        linkedHashMapPractice.put("2", "Two");

        // A LinkedHashMap doesn't allow duplicate keys.
        linkedHashMapPractice.put("1", "One");

        // A LinkedHashMap will allow duplicate values.
        linkedHashMapPractice.put("4", "One");

        // A LinkedHashMap will allow a single null key.
        // And will allow multiple null values.
        linkedHashMapPractice.put(null, null);
        linkedHashMapPractice.put("5", null);


        // A LinkedHashSet is not thread safe. However we
        // can use java.util.Collections to return a synchronized
        // map will which allow thread safe serial access.
        Map<String, String> synchronizedMap = Collections.synchronizedMap(linkedHashMapPractice);

        // When iterating over a synchronized collection we must
        // use a synchronized block or risk non-deterministic behavior.
        synchronized (synchronizedMap) {
            Object[] entries = synchronizedMap.entrySet().toArray();
            for(int i = 0; i < entries.length; i ++)
                System.out.println(((Map.Entry)entries[0]).getKey() + ":" + ((Map.Entry)entries[0]).getValue());
        }
    }
}
