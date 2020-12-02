import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingFiles {
    public static ArrayList<Integer> ReadFileInt(String FileName) {
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

    public static ArrayList<String> ReadFileString(String FileName) {
        ArrayList<String> Ouput = new ArrayList<>();
        try {
            File Input = new File(FileName);
            Scanner Reader = new Scanner(Input);
            while(Reader.hasNextLine()) {
                Ouput.add(Reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Ouput;
    }
}
