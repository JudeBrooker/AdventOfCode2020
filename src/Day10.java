import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day10 {
    public static void main(String[] args) {
        Part1(ReadFile.Int("Input/Day10"));
        Part2(ReadFile.Int("Input/TestCaseDay10"));
    }

    public static void Part1(ArrayList<Integer> input) {
        int deviceJoltage = Collections.max(input) + 3;
        int joltage = 0;
        HashMap<Integer, Integer> joltDifferences = new HashMap<>();
        joltDifferences.put(1, 0);
        joltDifferences.put(2, 0);
        joltDifferences.put(3, 0);
        while (joltage < deviceJoltage - 3) {
            boolean found = false;
            for (int i = 0; i < input.size(); i++) {
                if (input.get(i) == joltage + 1) {
                    joltDifferences.put(1, joltDifferences.get(1) + 1);
                    joltage = input.get(i);
                    input.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int i = 0; i < input.size(); i++) {
                    if (input.get(i) == joltage + 2) {
                        joltDifferences.put(2, joltDifferences.get(2) + 1);
                        joltage = input.get(i);
                        input.remove(i);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                for (int i = 0; i < input.size(); i++) {
                    if (input.get(i) == joltage + 3) {
                        joltDifferences.put(3, joltDifferences.get(3) + 1);
                        joltage = input.get(i);
                        input.remove(i);
                        break;
                    }
                }
            }
        }
        joltDifferences.put(3, joltDifferences.get(3) + 1);
        System.out.println(joltDifferences.get(1) * joltDifferences.get(3));
    }

    public static void Part2(ArrayList<Integer> input) {
        long arrangements = 0;

    }
}
