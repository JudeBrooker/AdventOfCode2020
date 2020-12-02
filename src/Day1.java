import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<Integer> Input = ReadFile("Input/Day1");
        Part1(Input);
        Part2(Input);

    }

    public static void Part1(ArrayList<Integer> Input) {
        for (int i = 0; i < Input.size(); i++) {
            for (int j = i+1; j < Input.size(); j++) {
                if(Input.get(i) + Input.get(j) == 2020) {
                    System.out.println(Input.get(i) * Input.get(j));
                    return;
                }
            }
        }
        System.out.println("Failed");
    }

    public static void Part2(ArrayList<Integer> Input) {
        for (int i = 0; i < Input.size(); i++) {
            for (int j = i+1; j < Input.size(); j++) {
                for (int k = j+1; k < Input.size(); k++) {
                    if(Input.get(i) + Input.get(j) + Input.get(k) == 2020) {
                        System.out.println(Input.get(i) * Input.get(j) * Input.get(k));
                        return;
                    }
                }
            }
        }
        System.out.println("Failed");
    }

    public static ArrayList<Integer> ReadFile(String FileName) {
        ArrayList<Integer> Ouput = new ArrayList<>();
        try {
            File Input = new File(FileName);
            Scanner Reader = new Scanner(Input);
            while(Reader.hasNextLine()) {
                Ouput.add(Reader.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Ouput;
    }
}
