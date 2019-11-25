package practice.collections;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapPractice
{

    public static void main(String [] args)
    {
        // A TreeMap doesn't maintain insertion order.
        // A TreeMap takes Key, Value pairs.
        // TreeMap keys must be unique.
        // TreeMap values can be duplicates.
        // TreeMap sorts keys in ascending order.
        // TreeMap isn't thread safe.
        // TreeMap doesn't allow null keys.

        // A TreeMap from java.util package.
        TreeMap<String, String> treeMapType = new TreeMap<>();

        // A TreeMap will not maintain insertion order.
        treeMapType.put("1", "One");
        treeMapType.put("3", "Three");
        treeMapType.put("2", "Two");

        // A TreeMap doesn't allow null keys.
        //treeMapType.put(null, null);
        // A TreeMap will allow null values.
        treeMapType.put("4", null);
        treeMapType.put("5", null);

        // A TreeMap isn't thread safe. However we can use
        // java.util.Collections class to return a synchronized
        // map which will provide serial thread safe access.
        Map<String, String> synchronizedTreeMap = Collections.synchronizedMap(treeMapType);

        // When using a synchronized map. We must use a synchronized
        // block while iterating or else risk non-deterministic behavior.
        synchronized (synchronizedTreeMap)
        {
            Object[] enteries = synchronizedTreeMap.entrySet().toArray();
            for(int i = 0; i < enteries.length; i ++)
                System.out.println(((Map.Entry)enteries[i]).getKey()+":"+((Map.Entry)enteries[i]).getValue());
        }
    }
}
