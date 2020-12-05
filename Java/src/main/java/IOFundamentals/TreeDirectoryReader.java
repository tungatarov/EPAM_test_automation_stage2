package IOFundamentals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeDirectoryReader {

    public List<String> readTxtFile(File path) {
        List<String> dirStructure = new ArrayList<>();

        try (Scanner scanner = new Scanner(
                            new FileReader(path))) {

            while (scanner.hasNext()) {
                dirStructure.add(scanner.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        dirStructure.removeIf(e -> e.equals("|"));
        return dirStructure;
    }
}
