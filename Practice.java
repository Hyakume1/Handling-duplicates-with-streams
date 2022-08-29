import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
generate a list of nums
 sort them
 list unique
 list the repeated
 list the non-repeated
 list the map in how much each repeats
 list the map of each that repeats more than once
 */
public class Practice {
    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>(IntStream
                .generate(() -> {return (int)(Math.random()*10);})
                .limit(20)
                .boxed()
                .sorted()
                .toList());

        Set<Integer> unique = new HashSet<>(numbers);

        Set<Integer> repeated = numbers.stream()
                .filter(e -> Collections.frequency(numbers, e)>1)
                .collect(Collectors.toSet());

        Set<Integer> notReapeated = numbers.stream()
                        .filter(e -> Collections.frequency(numbers,e) == 1)
                        .collect(Collectors.toSet());

        Map<Integer, Long> repetitonMap = numbers.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> multiplesMap = numbers.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue()>1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("the set of numbers: " + numbers);
        System.out.println("taking out duplicates: " + unique);
        System.out.println("the ones that were repeated:" + repeated);
        System.out.println("the ones that were not repeated: " + notReapeated);
        System.out.println("map for repetition: " + repetitonMap);
        System.out.println("map for those that appear more than once: " + multiplesMap);

    }
}
