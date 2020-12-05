package IOFundamentals;

import java.io.File;
import java.util.*;

public class TreeDirectoryCreator {

    private List<String> dirStructure = new ArrayList<>();

    public List<String> writeStructureOfFoldersAndFiles(File rootDir) {
        Deque<File> files = new ArrayDeque<>(getChildren(rootDir));

        for (File file : files) {

            if (file.exists()) {
                dirStructure.add(file.getName());
            }

            writeStructureOfFoldersAndFiles(file, "  ");
        }
        return dirStructure;
    }

    private void writeStructureOfFoldersAndFiles(File rootDir, String fileIndent) {
        Deque<File> files = new ArrayDeque<>(getChildren(rootDir));

        StringBuilder dirIndent = new StringBuilder("|-----");
        dirIndent.insert(0, fileIndent);

        if (files.size() > 0 && countDirs(files) > 0) {
            fileIndent += "|";
        }

        fileIndent += "       ";

        while (files.size() != 0) {

            File file = files.pop();

            if (file.isFile()) {

                dirStructure.add(fileIndent + file.getName());

            }

            if (file.isDirectory()) {

                dirStructure.add(dirIndent + file.getName());

            }

            if (files.isEmpty()) {
                fileIndent = fileIndent.replaceAll("\\|\\s*$", "        ");
                dirIndent.insert(0, fileIndent);
            }

            writeStructureOfFoldersAndFiles(file, fileIndent);
        }
    }

    private List<File> getChildren(File dir) {
        File[] children = dir.listFiles();

        return children == null || children.length == 0 ?
                Collections.EMPTY_LIST :
                Arrays.asList(children);
    }

    private int countDirs(Deque<File> files) {
        int TheNumOfDir = 0;
        for (File f : files) {
            if (f.isDirectory()) {
                TheNumOfDir++;
            }
        }
        return TheNumOfDir;
    }
}
