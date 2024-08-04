package interviews;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        Map map = getCountOfCharcaters("Aniket Narayan");

        map.forEach((character,count) -> {
            System.out.println(character + " : "+count);
        });

    }

    private static Map<Character,Long> getCountOfCharcaters(String inputString){

        return inputString.chars().
                mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    }
}
