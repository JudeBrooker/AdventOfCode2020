import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        Part1(ReadFile.String("input/Day3"));
        Part2(ReadFile.String("input/Day3"));
    }

    public static void Part1(ArrayList<String> Input) {
        int x = 0;
        int y = 0;
        int endY = Input.size();
        int endX = Input.get(0).length();
        int countTrees = 0;
        while (y < endY) {
            x %= endX;
            if (Input.get(y).charAt(x) == '#') countTrees++;
            x += 3;
            y++;
        }
        System.out.println(countTrees);
    }

    public static void Part2(ArrayList<String> Input) {
        long output = 1;
        int[][] slopes = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
        for (int[] slope : slopes) {
            int x = 0;
            int y = 0;
            int endY = Input.size();
            int endX = Input.get(0).length();
            int countTrees = 0;
            while (y < endY) {
                x %= endX;
                if (Input.get(y).charAt(x) == '#') countTrees++;
                x += slope[0];
                y += slope[1];
            }
            output *= countTrees;
        }
        System.out.println(output);
    }
}
