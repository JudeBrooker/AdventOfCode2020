import java.util.ArrayList;

public class Day5 {
    public static void main(String[] args) {
        Part1(ReadFile.String("Input/Day5"));
        Part2(ReadFile.String("Input/Day5"));
    }

    public static void Part1(ArrayList<String> input) {
        int maxSeatID = 0;
        for (String boardingPass : input) {
            String row = boardingPass.substring(0, 7);
            String column = boardingPass.substring(7);
            int rowMin = 0;
            int rowMax = 127;
            int columnMin = 0;
            int columnMax = 7;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == 'F') {
                    rowMax -= Math.pow(2, (6 - i));
                } else if (row.charAt(i) == 'B') {
                    rowMin += Math.pow(2, (6 - i));
                }
            }
            for (int j = 0; j < column.length(); j++) {
                if (column.charAt(j) == 'L') {
                    columnMax -= Math.pow(2, (2 - j));
                } else if (row.charAt(j) == 'R') {
                    columnMin += Math.pow(2, (2 - j));
                }
            }
            maxSeatID = Math.max(maxSeatID, rowMin * 8 + columnMax);
        }
        System.out.println(maxSeatID);
    }

    public static void Part2(ArrayList<String> input) {
        ArrayList<Integer> allSeatIDs = new ArrayList<>();
        for (int row = 0; row < 128; row++) {
            for (int column = 0; column < 8; column++) {
                allSeatIDs.add(row * 8 + column);
            }
        }

        ArrayList<Integer> takenSeatIDs = new ArrayList<>();
        for (String boardingPass : input) {
            String row = boardingPass.substring(0, 7);
            String column = boardingPass.substring(7);
            int rowMin = 0;
            int rowMax = 127;
            int columnMin = 0;
            int columnMax = 7;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == 'F') {
                    rowMax -= Math.pow(2, (6 - i));
                } else if (row.charAt(i) == 'B') {
                    rowMin += Math.pow(2, (6 - i));
                }
            }
            for (int j = 0; j < column.length(); j++) {
                if (column.charAt(j) == 'L') {
                    columnMax -= Math.pow(2, (2 - j));
                } else if (row.charAt(j) == 'R') {
                    columnMin += Math.pow(2, (2 - j));
                }
            }
            takenSeatIDs.add(rowMin * 8 + columnMax);
        }

        ArrayList<Integer> freeSeatIDs = new ArrayList<>();
        for (int seatID : allSeatIDs) {
            if (!takenSeatIDs.contains(seatID)) {
                freeSeatIDs.add(seatID);
            }
        }
        System.out.println(freeSeatIDs);
    }
}
