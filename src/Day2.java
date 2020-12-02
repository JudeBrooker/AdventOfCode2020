import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {
        Part1(ReadingFiles.ReadFileString("Input/Day2"));
        Part2(ReadingFiles.ReadFileString("Input/Day2"));
    }

    public static void Part1(ArrayList<String> Input) {
        int CountValid = 0;
        int CountLetter;
        for (int i = 0; i < Input.size(); i++) {
            CountLetter = 0;
            String Line = Input.get(i);
            int Separator = Line.indexOf(':');
            String Occurrences = Line.substring(0, Separator - 2);
            int OccurrencesSeparator = Occurrences.indexOf('-');
            int Max = Integer.parseInt(Occurrences.substring(OccurrencesSeparator + 1));
            int Min = Integer.parseInt(Occurrences.substring(0, OccurrencesSeparator));
            String Letter = Line.substring(Separator - 1, Separator);
            String Password = Line.substring(Separator + 2);
            for (int j = 0; j < Password.length(); j++) {
                if (Password.substring(j, j + 1).equals(Letter)) {
                    CountLetter++;
                }
            }
            if (CountLetter <= Max && CountLetter >= Min) {
                CountValid++;
            }
        }
        System.out.println(CountValid);
    }

    public static void Part2(ArrayList<String> Input) {
        int CountValid = 0;
        for (int i = 0; i < Input.size(); i++) {
            String Line = Input.get(i);
            int Separator = Line.indexOf(':');
            String Occurrences = Line.substring(0, Separator - 2);
            int OccurrencesSeparator = Occurrences.indexOf('-');
            int index1 = Integer.parseInt(Occurrences.substring(OccurrencesSeparator + 1)) - 1;
            int index2 = Integer.parseInt(Occurrences.substring(0, OccurrencesSeparator)) - 1;
            char Letter = Line.charAt(Separator - 1);
            String Password = Line.substring(Separator + 2);
            if (index1 < Password.length() && index2 < Password.length()) {
                if (Password.charAt(index1) == Letter ^ Password.charAt(index2) == Letter) {
                    CountValid++;
                }
            }
        }
        System.out.println(CountValid);
    }
}
