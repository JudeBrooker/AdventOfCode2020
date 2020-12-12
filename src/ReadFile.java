import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public static ArrayList<Integer> Int(String FileName) {
        ArrayList<Integer> Output = new ArrayList<>();
        try {
            File Input = new File(FileName);
            Scanner Reader = new Scanner(Input);
            while (Reader.hasNextLine()) {
                Output.add(Reader.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Output;
    }

    public static ArrayList<String> String(String FileName) {
        ArrayList<String> Output = new ArrayList<>();
        try {
            File Input = new File(FileName);
            Scanner Reader = new Scanner(Input);
            while (Reader.hasNextLine()) {
                Output.add(Reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Output;
    }

    public static ArrayList<Long> Long(String FileName) {
        ArrayList<Long> Output = new ArrayList<>();
        try {
            File Input = new File(FileName);
            Scanner Reader = new Scanner(Input);
            while (Reader.hasNextLine()) {
                Output.add(Reader.nextLong());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Output;
    }
}
