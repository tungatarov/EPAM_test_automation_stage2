package IOFundamentals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TreeDirectoryWriter {

    private File file;

    public TreeDirectoryWriter(File file) {
        this.file = file;
    }

    public void writeTreeDirectoryToTxt(List<String> treeDirectory) {

        try (FileWriter writer = new FileWriter(file)) {
            for (String s : treeDirectory) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
