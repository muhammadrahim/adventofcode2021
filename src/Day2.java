import kotlin.Pair;

import java.util.List;
import java.util.function.Function;

public class Day2 {

    static void run() {

        Function<List<Pair<String,Integer>>, Integer> part1 = Day2::task1;
        Function<List<Pair<String,Integer>>, Long> part2 = Day2::task2;

        List<Pair<String, Integer>> input = UtilsKt.readInputAsCoords("Day02");
        System.out.println(part1.apply(input));

        System.out.println(part2.apply(input));
    }


    private static Integer task1(List<Pair<String, Integer>> list) {
        int[] coords = new int[]{0, 0};
        for (Pair<String, Integer> input : list) {
            int[] coord = Coord.valueOf(input.component1()).array;
            Integer scalar = input.component2();

            coords[0] += coord[0] * scalar;
            coords[1] += coord[1] * scalar;
        }
        return Math.abs(coords[0]) * Math.abs(coords[1]);
    }

    private static Long task2(List<Pair<String, Integer>> list) {
        long horizontal = 0;
        long aim = 0;
        long depth = 0;
        for (Pair<String, Integer> input : list) {
            int[] coord = Coord.valueOf(input.component1()).array;
            long scalar = input.component2();

            aim += coord[1] * scalar;
            horizontal += coord[0] * scalar;
            depth += Math.abs(aim)*coord[0]*scalar;
        }
        return horizontal * Math.abs(depth);
    }

    enum Coord {
        FORWARD(new int[]{1,0}),
        UP(new int[]{0,1}),
        DOWN(new int[]{0,-1});

        private final int[] array;

        Coord(int[] array) {
            this.array = array;
        }
    }
}
