import java.util.List;
import java.util.function.Function;

public class Day1 {
      static void run() {
        Function<List<Integer>, Integer> part1 = list -> {
            int count = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) < list.get(i + 1)) {
                    count++;
                }
            }
            return count;
        };

        Function<List<Integer>, Integer> part2 = list -> {
            int count = 0;
            int prevSum = list.get(0) + list.get(1) + list.get(2);
            for (int i = 2; i < list.size() -1; i++) {
                int currSum = list.get(i-1) + list.get(i) + list.get(i+1);
                if (currSum > prevSum) {
                    count++;
                }
                prevSum = currSum;
            }
            return count;
        };

        List<Integer> input = UtilsKt.readInputAsIntegerList("Day01_1");

        System.out.println(part1.apply(input));

        System.out.println(part2.apply(input));
    }
}
