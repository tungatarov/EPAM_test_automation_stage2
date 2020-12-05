package IOFundamentals;

import java.util.List;

public class TreeDirectoryAnalyser {

    private List<String> dirStructure;

    public TreeDirectoryAnalyser(List<String> dirStructure) {
        this.dirStructure = dirStructure;
    }

    public int countNumOfFolders() {
        int numOfFolders = 0;
        for (String s : dirStructure) {
            if (s.startsWith("|-----") || !s.contains(".")) {
                numOfFolders++;
            }
        }
        return numOfFolders;
    }

    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (String s : dirStructure) {
            if (!s.startsWith("|-----") && s.contains(".")) {
                numOfFiles++;
            }
        }
        return numOfFiles;
    }

    public double countAverageNumOfFilesInFolder() {
        return ((double) countNumOfFiles()) / countNumOfFolders();
    }

    public int countAverageNameLengthOfFiles() {
        int averageLength = 0;
        dirStructure.removeIf(e -> !e.startsWith("|-----") && e.contains("."));
        for (String s : dirStructure) {
            averageLength += removeExtension(s).length();
        }
        return averageLength / dirStructure.size();
    }

     private String removeExtension(String fileName) {
        if (fileName.startsWith(".")) {
            if (fileName.lastIndexOf('.') == fileName.indexOf('.')) return fileName;
        }
        if (!fileName.contains(".")) return fileName;
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }
}
