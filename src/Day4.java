import java.util.ArrayList;

public class Day4 {
    public static void main(String[] args) {
        Part1(ReadFile.String("Input/Day4"));
        Part2(ReadFile.String("Input/Day4"));
    }

    public static void Part1(ArrayList<String> input) {
        int valid = 0;
        for (int i = 0; i < input.size(); i++) {
            String passport = " ";
            while (i < input.size() && input.get(i).length() != 0) {
                passport += " " + input.get(i);
                i++;
            }
            if (passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") &&
                    passport.contains("hgt") && passport.contains("hcl") && passport.contains("ecl") &&
                    passport.contains("pid")) {
                valid += 1;
            }
        }
        System.out.println(valid);
    }

    public static void Part2(ArrayList<String> input) {
        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        int valid = 0;
        for (int i = 0; i < input.size(); i++) {
            String passport = " ";
            while (i < input.size() && input.get(i).length() != 0) {
                passport += " " + input.get(i);
                i++;
            }
            passport += " ";
            if (passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") &&
                    passport.contains("hgt") && passport.contains("hcl") && passport.contains("ecl") &&
                    passport.contains("pid")) {
                int validFields = 0;
                for (String field : fields) {
                    int start = passport.indexOf(field) + 4;
                    int end = passport.indexOf(" ", start);
                    String fieldEntry = passport.substring(start, end);
                    if (field.equals("byr")) {
                        if (Integer.parseInt(fieldEntry) >= 1920 && Integer.parseInt(fieldEntry) <= 2002) {
                            validFields++;
                        }
                    } else if (field.equals("iyr")) {
                        if (Integer.parseInt(fieldEntry) >= 2010 && Integer.parseInt(fieldEntry) <= 2020) {
                            validFields++;
                        }
                    } else if (field.equals("eyr")) {
                        if (Integer.parseInt(fieldEntry) >= 2020 && Integer.parseInt(fieldEntry) <= 2030) {
                            validFields++;
                        }
                    } else if (field.equals("hgt")) {
                        String value = fieldEntry.substring(0, fieldEntry.length() - 2);
                        if (fieldEntry.contains("cm")) {
                            if (Integer.parseInt(value) >= 150 && Integer.parseInt(value) <= 193) {
                                validFields++;
                            }
                        } else if (fieldEntry.contains("in")) {
                            if (Integer.parseInt(value) >= 59 && Integer.parseInt(value) <= 76) {
                                validFields++;
                            }
                        }
                    } else if (field.equals("hcl")) {
                        if (fieldEntry.charAt(0) == '#') {
                            if (fieldEntry.length() == 7) {
                                validFields++;
                            }
                        }
                    } else if (field.equals("ecl")) {
                        if (fieldEntry.matches("amb|blu|brn|gry|grn|hzl|oth")) {
                            validFields++;
                        }
                    } else if (field.equals("pid")) {
                        if (fieldEntry.matches("[0-9]{9}")) {
                            validFields++;
                        }
                    }
                }
                if (validFields == 7) {
                    valid++;
                }
            }
        }
        System.out.println(valid);
    }
}
