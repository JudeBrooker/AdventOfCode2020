import java.util.ArrayList;

public class Day7 {
    public static void main(String[] args) {
        Part1(ReadFile.String("Input/TestCaseDay7"));
    }

    public static void Part1(ArrayList<String> input) {
        int numColours = 0;
        for (String line : input) {
            String bagColour = line.substring(0, line.indexOf("bags") - 1);
            String rule = line.substring(line.indexOf("contain") + 8);
            if (rule.contains("shiny gold")) {
                numColours++;
            }
        }
        System.out.println(numColours);
    }
}
