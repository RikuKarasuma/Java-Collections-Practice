package practice.collections;

import static java.lang.System.out;
import static java.util.stream.Stream.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StreamsPractice
{

    public static void main(String[] args)
    {
        // Found in java.util.stream.
        // A stream is a sequence of elements.
        // Streams can be created from any Collection using the stream
        // function.
        // Or from a sequence of instances using Stream.of function.
        // Streams contain functional aggregation concepts such as map,
        // flatMap, filter, max, min, reduce etc. 
        // Streams support pipelining back the values to Collections,
        // using the Collectors class.

        // Create our Stream input list.
        List<Integer> listOfIntegers = Arrays.asList(5, 2, 4 , 15, 52, 23);

        // Create a Stream from the input list.
        Stream<Integer> streamOfIntegers = listOfIntegers.stream();

        // Print out our Stream values.
        // Using the forEach function, which will allow us 
        // to apply a literal function to each value.
        streamOfIntegers.forEach(System.out::println);
        
        // We can also craete Streams using of function.
        // Then manually passing the values desired.
        Stream<Integer> streamOfIntegersManual = of(4, 2, 1, 5, 23, 54);

        // Streams also have a sorted function for implicit
        // and explicit sorting of values.
        Stream<Integer> sortedStreamOfIntegers = streamOfIntegersManual.sorted();

        // Print out our Integers which are sorted in ascending 
        // manner.
        sortedStreamOfIntegers.forEach(System.out::println);


        // Stream contains a distinct function which allows us to
        // return only unique values.
        Stream<Integer> duplicateStream = of(2, 2, 3, 3, 4);

        // We now use our disinct function to get only the unique
        // values then print them out.
        duplicateStream.distinct().forEach(System.out::println);


        // Stream has a map function, which will allow us to transform
        // our values by applying literal functions to them.
        // We will double our values for output.
        listOfIntegers.stream().map(ourInt -> ourInt * 2)
            .forEach(System.out::println);;

    }
}