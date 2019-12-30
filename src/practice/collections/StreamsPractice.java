package practice.collections;

import static java.lang.System.out;
import static java.util.stream.Stream.*;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream.Builder;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class StreamsPractice
{

    public static void main(String[] args) throws IOException
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
            .forEach(System.out::println);


        // Stream contains a filter function which allows us to select
        // a subset of the data based on a specified predicate.
        // Our filter below will select only the integers that are
        // equal to Three.
        Stream<Integer> valuesOfThree = of(2, 3, 2, 3, 1, 4, 5, 3)
            .filter(possibleThree -> possibleThree == 3);

            // Reusing a previous stream will throw an Illegal State
            // Exception. As a stream should only be used once then 
            // collected or piped.
            //duplicateStream.filter(ourInt -> ourInt == 3);

        // Print out our selected Three's.
        valuesOfThree.forEach(System.out::println);

        // Using the limit function we can limit the size of a
        // Stream. 
        // Using the Random class we can generate a random stream
        // of ints.
        Random randomGenerator = new Random();

        System.out.println("Limit integers:");
        // Generate the stream of integers and use the limit function
        // in order to only create One-Hundred integers.
        randomGenerator.ints().limit(100)
            // Print out each of the integers.
            .forEach(System.out::print);

        // Stream provides sorting capabilities, by default it is
        // sorted Lexicographically. A comparator can also be used
        // to sort values in a custom manner. Though not with IntStream.

        // Generate a random stream of integers.
        IntStream randomIntegers = randomGenerator.ints().limit(10);

        System.out.println("\nSorted integers:");
        // Using the sorted function, the stream will sort the integers
        // in ascending order.
        randomIntegers.sorted().forEach(System.out::print);

        // In case we wish to create an empty stream, we use the empty
        // function. This is helpful for avoiding nulls.
        Stream<String> emptyStream = empty();

        // In case we need to convert a Stream into an Array.
        // We can use the Arrays.stream function in order to convert
        // this for us.
        String[] arrayOfStrings = new String[]{"abc", "cba", "bac"};

        // Now using the stream function we convert our Array into a
        // Stream.
        // We can also define the beginning and ending index of which
        // we want made into a Stream.
        Stream<String> streamOfStrings = Arrays.stream(arrayOfStrings, 0, 3);

        // Display out each string.
        streamOfStrings.forEach(System.out::println);

        // Using Stream.Builder we can generate a Stream ad hoc, by
        // using the incorporated the builder pattern.
        Stream.Builder<String> streamBuilder = Stream.<String>builder()
            // Add on the elements we wish to have in stream.
            .add("Start")
            .add("End");

        // Create the desired Stream from the StreamBuilder. 
        Stream<String> streamFromBuilder = streamBuilder.build();

        // Execute a function on the Stream. 
        streamFromBuilder.forEach(System.out::println);

        // We can generate a Stream using the generate function.
        // It uses the Supplier interface for element generation.

        // A character set for random generation.
        char[] alphabet = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
            'u', 'v', 'w', 'x', 'y', 'z'
        };

        // A supplier interface for generating the characters randomly.
        Supplier<Character> randomCharacterGenerator = () -> alphabet[
            randomGenerator.nextInt(26)];

        // Here we generate our characters into a Stream with a limit
        // of twenty. 
        Stream<Character> generatedStream = Stream
            .generate(randomCharacterGenerator)
            // It is important to place a limit on the Stream
            // as it is infinite.
            .limit(20);

        // Print out each generated character.
        generatedStream.forEach(System.out::print);

        // Another way of generating a Stream, is by using the iterate
        // function. This function allows us to set an initial variable,
        // which will be fed into the next iteration and applied to the 
        // second function parameter.
        System.out.println(); // New line.
        // Start at ten, iterate over it and add One to it each time.
        Stream.iterate(10, x -> x + 1)
            // Repeat only Ten times.
            .limit(10)
            // Print out each calculating.
            .forEach(System.out::println);

        // A quick way of reading a File line by line can be achieved
        // using a Files function called lines, which will create a 
        // Stream of type <String>.

        // Get path to the file.
        Path textFileToRead = Paths.get("src/practice/collections/file_to_read.txt");
        
        // Read each of the lines inside the text file and return it
        // as a Stream to be operated on. 
        // We're importing it as a UTF charset.
        List<String> linesOfFile = new ArrayList();
        try(Stream<String> lines = Files.lines(textFileToRead, Charset.forName("UTF-8")))
        {
            linesOfFile = lines.collect(Collectors.toList());
        }

        // Print out each line read in from file.
        linesOfFile.stream().forEach(System.out::println);

        // As Stream is not a Collection. It can't be reused after
        // a terminal operation has been performed on it.
        // Else an IllegalStateException will occur.
        // Here's an example.

        Stream<String> streamThatCantBeReused = of("a", "b", "c")
            // We chain some functional operations together.
            .filter(value -> value.equals("a"))
            .map(x -> x + "1");

        // We preform a terminal operation. Which closes the Stream,
        // afterwards.
        streamThatCantBeReused.findFirst();

        // Now our next terminal operation will fail with an Illegal
        // State Exception.
        try
        {
            streamThatCantBeReused.findAny();
        }
        catch(IllegalStateException streamReuseError)
        {
            System.out.println("Stream exception caught.");   
        }

        // So as we've just witnessed. Streams can't be reused after
        // a terminal operation. 
        // This is because Stream is a pipeline for functional operations.
        // A Stream is made up of Three concepts,
        // Source -> Intermediate Operations -> Terminal Operation.
        //
        // A Source is a Collection or sequence of variables.
        //
        // Intermediate Operations are operations that manipulate the 
        // current Source elements and return a new Stream.
        //
        // A Terminal Operation is an operation which applies an action
        // to each element in the Stream, and probably returns a result.
        //
        // After the Terminal Operation has been executed. A findFirst
        // or count function for example. The Stream is closed.
        //
        // To counteract this, we collect our elements.
        // Using the collect function. We can gather the Stream elements
        // and insert them into a new collection. 
        // Which can be used as a Stream again.

        Stream<String> streamToCollect = of("a", "b", "a")
            // Apply an intermediate operation.
            .filter(x -> x.equals("a"));

        // Apply our terminal operation.
        // Collect our closed Stream to a new List.
        List<String> collectedStream = streamToCollect.collect(Collectors.toList());

        // Apply our terminal operation.
        long streamCount = collectedStream.size();
        
        // Create another Stream from our collected Stream List.
        collectedStream.stream().forEach(System.out::println);

        // Stream has several functions for matching. These
        // are anyMatch, allMatch and noneMatch. 

        String[] testStrings = new String[]{"Bob", "Dob", "Cob"};

        // Any match will return based on any of the values
        // matching the predicate function. 
        boolean doesAnyContainD = Arrays.stream(testStrings)
            .anyMatch(str -> str.contains("D"));

        // Print out the anyMatch result which should be True.
        System.out.println("Does any contain D: " + doesAnyContainD);

        // All match will return based on each of the values 
        // entirely matching the same predicate.
        boolean doesAllContainO = Arrays.stream(testStrings)
            .allMatch(str -> str.contains("o"));

        // Print out the allMatch result which should be True.
        System.out.println("Does all elements contain o: " + doesAllContainO);

        // None match will return based on each of the values
        // entirely not matching the same predicate.
        boolean doesNoneContainX = Arrays.stream(testStrings)
            .noneMatch(str -> str.contains("x"));

        // Print out the noneMatch result which should be True.
        System.out.println("Does none of these values contain x: " + doesNoneContainX);

        // Much like the iterate function, we can use reduce to 
        // iterate over a Streams values and accumulating them 
        // using a specified logic which stored in a literal function.

        // There is Two Reduction concepts that you need to be aware of.
        // The first concept is the Accumulator, which specifies the logic
        // of the aggregation. Along with an initial value or not.

        // Without initial value.
        // Optional<Integer> summedValue = streamOfInts.reduce( (x, y) -> x.get() + y.get());

        // With initial value.
        final int initialValue = 2;
        int summedValue = listOfIntegers.stream().reduce(initialValue, (x, y) -> x + y);

        // Print out the summed result.
        System.out.println("Reduced accumulated value: " + summedValue);

        // The second concept is that of the combiner.
        // The combiner is another literal function which aggregates the results
        // of the accumulator. 
        // Combiner is called only in parallel mode in order to reduce the results
        // from different threads. 
        int summedParallelValue = listOfIntegers.parallelStream().reduce(initialValue, 
            // Reducing literal.
            (x, y) -> x + y,
            // Aggregation literal.
            (x, y) -> 
            {
                int summedValues = x + y;
                System.out.println("Combiner sum for " + x + " and " + y + " is: " 
                + summedValues);
                return summedValues;
            });

        // Print out the summed Combiner result.
        System.out.println("Reduced accumulated value from Combiner: " + 
            summedParallelValue);

        // Reduction can also be achieved using the collect function.
        // Collect as seen above, retrieves the results of a stream.
        // It takes a type parameter of type Collector and there's already
        // a great deal of Collector types for common scenarios.
        // Such as collect to list, averaging or summing ints.

        // Collect to list.
        List<Integer> collectedInts = listOfIntegers.stream().collect(Collectors.toList());

        // Collect/Reduce to single string.
        String joinedStreamStrings = linesOfFile.stream().collect(Collectors.joining(" "));
        System.out.println("Reduced string: " + joinedStreamStrings);

        // Collect/Reduce to averaged integer.
        double average = listOfIntegers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Reduced average: " + average);

        // Collect/Reduce to sum.
        int totalCollectedValue = listOfIntegers.stream().collect(Collectors.summingInt(x -> x));
        System.out.println("Reduced sum: " + totalCollectedValue);

        // Collectors class also contains a statistics function called,
        // summarizingInt. Which can be used to collect the statistical
        // information of a Stream containing some kind of Integer.
        // Using this we can retrieve the sum, min, max and average of a
        // group of integers.

        IntSummaryStatistics statistics = listOfIntegers.stream()
            .collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + statistics.getCount() + 
            ", Min: " + statistics.getMin() + 
            ", Max: " + statistics.getMax() + 
            ", Average: " + statistics.getAverage());

        // We can also group by a certain value using the collect function.
        Map<Integer, List<Integer>> groupedByNumber = listOfIntegers.stream()
            .collect(Collectors.groupingBy(x -> x));
        groupedByNumber.forEach((x, y) -> System.out.println(x + " has " + y.size() 
            + " number of elements."));

        // Or group by a specified predicate.
        Map<Boolean, List<Integer>> overTwenty = listOfIntegers.stream()
            .collect(Collectors.partitioningBy(x -> x > 20));
        overTwenty.forEach((x, y) -> System.out.println(x + " has this many elements: " 
            + y.size()));
        
        // Finally with the Collector, we can create custom Collectors.
        // This will allow us to create custom aggregators for streams.
        
        // First we create our Collector.
        // This collector will gather our ints and add them to a ArrayList.
        Collector<
            // Expected type to accumulate.
            Integer,
            // Accumulator type.
             ?,
            // Return type.
            ArrayList<Integer>> customArrayListCollector = Collector.of(
                // Supplier function.
                ArrayList::new,
                // Accumulator function.
                ArrayList::add, 
                // Combiner function.
                (x, y) -> { x.addAll(y); return x;});
        
        // Use our custom collector to create an ArrayList.
        ArrayList<Integer> customArrayListCollected = listOfIntegers.stream()
            .collect(customArrayListCollector);
        customArrayListCollected.forEach(System.out::println);
    }
}