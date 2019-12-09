
import java.util.Vector;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class VectorPractice
{

    private static void out(Vector<String> strings_to_print)
    {
        for(String string_to_print: strings_to_print)
            out(string_to_print);
    }

    private static void out(String... strings_to_print)
    {
        for(String string_to_print : strings_to_print)
            System.out.println(string_to_print);
    }

    private static Vector<String> vectorCollection = null;


    public static void main(String[] args)
    {
        long runTime = System.nanoTime();
        // Vector is a collection from Java 1.0.
        // Vector is synchronized.
        // Vector maintains insertion order.
        // Vector allows duplicates.
        // Vector allows null values.
        // Vector doesn't provide sorting.
        //Vector<String> vectorCollection = new Vector();
        vectorCollection = new Vector();

        // Vector maintains insertion order.
        vectorCollection.add("One");
        vectorCollection.add("Two");
        vectorCollection.add("Three");
        out(vectorCollection);

        // Vector allows duplicates.
        vectorCollection.add("One");

        // Vector allows nulls.
        //vectorCollection.add(null);
        //out(vectorCollection);

        // Vector doesn't provide sorting capabilities, 
        // however we can use stream to provide that for us.
        Stream<String> streamOfVector = Stream.of(vectorCollection.toArray(new String[vectorCollection.size()]));

        // Sorted lexicographically.
        streamOfVector.sorted().forEach(System.out::println);

        // Create a million ints to concurrently input into vector.
        IntStream ints = IntStream.range(1, 1000000);
        // Use parallelism to input the numbers into our Vector concurrently.
        ints.parallel().forEach(VectorPractice::input);
        //ints.parallel().forEach(x -> vectorCollection.add(String.valueOf(x)));
        out(vectorCollection);

        // Calculate run time for testing efficiency.
        runTime = System.nanoTime() - runTime;
        System.out.println("Run time:" + runTime / 1000000000f);
    }

    private static void input(Integer to_input)
    {
        vectorCollection.add(String.valueOf(to_input));
    }
}