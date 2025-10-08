package tests;

public class InterfaceTest {

    public interface Consumer<T> {
        void accept(T t);
    }

    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
    }
}






public void print(String message) {
    System.out.println(message);
}

Printer p = message -> System.out.println(message);



import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // Ordinary way: loop and filter even numbers, then square them
        List<Integer> result = new ArrayList<>();
        for (int n : numbers) {
            if (n % 2 == 0) {
                result.add(n * n);
            }
        }

        System.out.println("Ordinary way: " + result);
    }
}


public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // Stream way: filter + map + collect
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)     // keep even numbers
                .map(n -> n * n)             // square each
                .collect(Collectors.toList()); // put into a new list

        System.out.println("Stream + lambda: " + result);
    }
}