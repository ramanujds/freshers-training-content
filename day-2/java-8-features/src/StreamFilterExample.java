import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamFilterExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("John", "Harsh", "Rohit", "Karan", "Riya");

        // find all the name starts with R

        // Capitalize the names

        // Print them

        var output = list.stream()
                .filter(s -> s.startsWith("R"))
                .map(s -> s.toUpperCase())
                .toList();

        System.out.println(output);


    }

}
