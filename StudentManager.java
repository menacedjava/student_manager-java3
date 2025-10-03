import java.io.*;
import java.util.*;

public class StudentManager {
    static String file = "students.csv";

    public static void addStudent(String name, int... grades) throws IOException {
        double avg = Arrays.stream(grades).average().orElse(0);
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(name + "," + avg + "\n");
        }
    }

    public static void listStudents() throws IOException {
        File f = new File(file);
        if (!f.exists()) return;
        for (String line : java.nio.file.Files.readAllLines(f.toPath()))
            System.out.println(line);
    }

    public static void main(String[] args) throws Exception {
        addStudent("Ali", 90, 80, 100);
        addStudent("Laylo", 75, 88, 92);
        listStudents();
    }
}
