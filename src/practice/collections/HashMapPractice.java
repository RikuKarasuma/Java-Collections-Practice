package practice.collections;

import java.util.*;

public class HashMapPractice
{

    public static void main(String[] args)
    {
        // A HashMap contains Key/Value pairs.
        // Keys are unique, values can be duplicates.
        // HashMap doesn't maintain insertion order.
        // HashMap isn't thread safe.
        // HashMap allows a single null key.
        // HashMap allows multiple duplicate keys.
        // HashMap doesn't provide sorting.
        // HashMap auto sorts key values in ascending order.

        // HashMap from the java.util package.
        HashMap hashMapType = new HashMap();

        // A HashMap doesn't maintain insertion order.
        hashMapType.put("1", "One");
        hashMapType.put("3", "Three");
        hashMapType.put("2", "Two");

        // A Hashamp won't allow duplicate keys
        // but will allow duplicate values.
        hashMapType.put("1", "One");
        hashMapType.put("4", "One");

        // A HashMap doesn't allow more than one null key.
        hashMapType.put(null, null);

        // A HashMap allows multiple null values.
        hashMapType.put("5", null);

        // A HashMap is not thread safe. However we can use
        // the java.util.Collections class to return a synchronized
        // map.
        Map<String, String> synchronizedMap = Collections.synchronizedMap(hashMapType);


        // While using a synchronized collection. We must
        // use a synchronized block once iterating or else
        // risk non-deterministic behavior.
        synchronized (synchronizedMap) {
            Object[] entries = synchronizedMap.entrySet().toArray();
            for (int i = 0; i < synchronizedMap.size(); i++)
                System.out.println(((Map.Entry) entries[i]).getKey() + ":" + ((Map.Entry) entries[i]).getValue());
        }
    }
}
