import java.util.ArrayList;
import java.util.HashMap;

public class Day8 {
    public static void main(String[] args) {
        Part1(ReadFile.String("Input/Day8"));
        Part2(ReadFile.String("Input/Day8"));
    }

    public static void Part1(ArrayList<String> input) {
        int index = 0;
        int accumulator = 0;
        boolean repeated = false;
        HashMap<Integer, Boolean> runInstructions = new HashMap<>();
        while (!repeated) {
            String instruction = input.get(index);
            String operation = instruction.substring(0, 3);
            String argument = instruction.substring(4);
            if (runInstructions.containsKey(index)) {
                repeated = true;
            } else {
                runInstructions.put(index, true);
                switch (operation) {
                    case "nop":
                        index++;
                        break;
                    case "jmp":
                        index += Integer.parseInt(argument);
                        break;
                    case "acc":
                        accumulator += Integer.parseInt(argument);
                        index++;
                        break;
                }
            }
        }
        System.out.println(accumulator);
    }

    public static void Part2(ArrayList<String> input) {
        int accumulator = 0;
        for (int i = 0; i < input.size(); i++) {
            ArrayList<String> tempInput = new ArrayList<>(input);
            String instruction = input.get(i);
            String operation = instruction.substring(0, 3);
            String argument = instruction.substring(4);
            if (operation.equals("jmp")) {
                tempInput.set(i, "nop " + argument);
            } else if (operation.equals("nop")) {
                tempInput.set(i, "jmp " + argument);
            }
            HashMap<Integer, Boolean> runInstructions = new HashMap<>();
            int index = 0;
            accumulator = 0;
            boolean repeated = false;
            while (!repeated && index < tempInput.size()) {
                instruction = tempInput.get(index);
                operation = instruction.substring(0, 3);
                argument = instruction.substring(4);
                if (runInstructions.containsKey(index)) {
                    repeated = true;
                } else {
                    runInstructions.put(index, true);
                    switch (operation) {
                        case "nop":
                            index++;
                            break;
                        case "jmp":
                            index += Integer.parseInt(argument);
                            break;
                        case "acc":
                            accumulator += Integer.parseInt(argument);
                            index++;
                            break;
                    }
                }
            }
            if (!repeated) {
                break;
            }
        }
        System.out.println(accumulator);
    }
}
