package distinct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamDistinct {
    public static void main(String[] args) {
        int arr[] = { 100,14, 46, 47, 94, 94, 52, 86, 36, 94, 89 };

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(94);
        list.add(58);

        System.out.println(list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());


    }
}
