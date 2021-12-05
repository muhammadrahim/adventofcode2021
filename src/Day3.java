import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day3 {

    static void run() {
        List<String> input = UtilsKt.readInput("Day03");

        System.out.println(task1(input));
        System.out.println(task2(input));
    }


    private static int task1(List<String> list) {
        StringBuilder result = new StringBuilder();
        StringBuilder lcb = new StringBuilder();
        for (int j = 0; j < list.get(0).length(); j++) {
            int one = 0;
            for (String s : list) {
                int bit = Integer.parseInt(s.charAt(j) + "");
                if (bit == 1) {
                    one++;
                }
            }
            if (one > list.size() / 2) {
                result.append("1");
                lcb.append("0");
            } else {
                result.append("0");
                lcb.append("1");
            }
        }
        int res = Integer.parseInt(result.toString(), 2);
        int lcb1 = Integer.parseInt(lcb.toString(), 2);
        return lcb1 * res;
    }

    private static int task2(List<String> list) {
        return calcOxygenGeneratorRating(list) * calcCO2ScrubberRating(list);
    }

    private static int calcCO2ScrubberRating(List<String> list) {
        for (int i = 0; i < list.get(0).length(); i++) {
            int totalZeros = 0;
            for (String s : list) {
                char c = s.charAt(i);
                if (c == '0') {
                    totalZeros++;
                }
            }
            if ((totalZeros * 2 < list.size()) || totalZeros * 2 == list.size()) {
                int finalI = i;
                list = list.stream().filter(e -> e.charAt(finalI) == '0').collect(toList());
            } else {
                int finalI1 = i;
                list = list.stream().filter(e -> e.charAt(finalI1) == '1').collect(toList());
            }
            if (list.size() == 1) return Integer.parseInt(list.get(0), 2);
        }
        return -1;
    }

    private static int calcOxygenGeneratorRating(List<String> list) {
        for (int i = 0; i < list.get(0).length(); i++) {
            int totalOnes = 0;
            for (String s : list) {
                char c = s.charAt(i);
                if (c == '1') {
                    totalOnes++;
                }
            }
            if ((totalOnes * 2 > list.size()) || totalOnes * 2 == list.size()) {
                int finalI = i;
                list = list.stream().filter(e -> e.charAt(finalI) == '1').collect(toList());
            } else {
                int finalI1 = i;
                list = list.stream().filter(e -> e.charAt(finalI1) == '0').collect(toList());
            }
            if (list.size() == 1) return Integer.parseInt(list.get(0), 2);
        }
        return -1;
    }
}
