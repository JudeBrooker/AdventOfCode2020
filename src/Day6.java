import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day6 {
    public static void main(String[] args) {
        Part1(ReadFile.String("Input/Day6"));
        Part2(ReadFile.String("Input/Day6"));
    }

    public static void Part1(ArrayList<String> input) {
        int numQuestions = 0;
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<String> inputGroup = new ArrayList<>();
        ArrayList<HashMap<Character, Boolean>> allQuestions = new ArrayList<>();
        for (String line : input) {
            if (line.length() == 0) {
                groups.add(inputGroup);
                inputGroup = new ArrayList<>();
            } else {
                inputGroup.add(line);
            }
        }
        groups.add(inputGroup);
        for (ArrayList<String> group : groups) {
            HashMap<Character, Boolean> questions = new HashMap<>();
            for (String person : group) {
                for (int i = 0; i < person.length(); i++) {
                    questions.put(person.charAt(i), true);
                }
            }
            allQuestions.add(questions);
        }
        for (HashMap<Character, Boolean> question : allQuestions) {
            numQuestions += question.size();
        }
        System.out.println(numQuestions);
    }

    public static void Part2(ArrayList<String> input) {
        int numQuestions = 0;
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<String> inputGroup = new ArrayList<>();
        ArrayList<HashMap<Character, Boolean>> allQuestions = new ArrayList<>();
        for (String line : input) {
            if (line.length() == 0) {
                groups.add(inputGroup);
                inputGroup = new ArrayList<>();
            } else {
                inputGroup.add(line);
            }
        }
        groups.add(inputGroup);
        for (ArrayList<String> group : groups) {
            int numPeople = group.size();
            HashMap<Character, Boolean> questions = new HashMap<>();
            HashMap<Character, Integer> numYes = new HashMap<>();
            for (String person : group) {
                for (int i = 0; i < person.length(); i++) {
                    if (!numYes.containsKey(person.charAt(i))) {
                        numYes.put(person.charAt(i), 1);
                    } else {
                        numYes.put(person.charAt(i), numYes.get(person.charAt(i)) + 1);
                    }
                }
            }
            numYes.forEach((question, responses) -> {
                if (responses == numPeople) {
                    questions.put(question, true);
                }
            });
            allQuestions.add(questions);
        }
        for (HashMap<Character, Boolean> question : allQuestions) {
            numQuestions += question.size();
        }
        System.out.println(numQuestions);
    }
}
