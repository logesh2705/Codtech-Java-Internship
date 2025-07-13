import java.io.*;

public class FileHandler {
    public static void main(String[] args) throws IOException {
        String filename = "example.txt";

        // Write to file
        FileWriter writer = new FileWriter(filename);
        writer.write("This is a sample text.");
        writer.close();
        System.out.println("File written successfully.");

        // Read file
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        System.out.println("Reading from file:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        // Modify file
        FileWriter modifier = new FileWriter(filename);
        modifier.write("This is the modified content.");
        modifier.close();
        System.out.println("File modified.");
    }
}
