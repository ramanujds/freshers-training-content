import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExample {



    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 6, 10);



       int first = list.stream()
                                    .filter(i -> i % 2 == 0)
                                    .peek(i -> System.out.println(i))
                                    .map(i -> i*i)
                                    .peek(i -> System.out.println(i))
                                    .findFirst().get();
        System.out.println(first);


    }

}


