import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Day9 {
    public static void main(String[] args) {
        System.out.println(Part1(ReadFile.Long("Input/Day9")));
        Part2(ReadFile.Long("Input/Day9"));
    }

    public static long Part1(ArrayList<Long> input) {
        for (int i = 25; i < input.size(); i++) {
            Long target = input.get(i);
            boolean sum = false;
            for (int j = i - 25; j < i; j++) {
                for (int k = j; k < j + 25 && k < input.size(); k++) {
                    if (input.get(j) + input.get(k) == target && input.get(j) != input.get(k)) {
                        sum = true;
                        break;
                    }
                }
                if (sum) {
                    break;
                }
            }
            if (!sum) {
                return target;
            }
        }
        return -1;
    }

    public static void Part2(ArrayList<Long> input) {
        long target = Part1(ReadFile.Long("Input/Day9"));
        long sum = 0;
        ArrayList<Long> nums = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            nums = new ArrayList<>();
            sum = 0;
            for (int j = i; j < input.size(); j++) {
                sum += input.get(j);
                nums.add(input.get(j));
                if (sum == target) {
                    break;
                }
            }
            if (sum == target) {
                break;
            }
        }
        System.out.println(Collections.max(nums) + Collections.min(nums));
    }
}
