package IOFundamentals;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File in = new File(args[0]);

        if (in.exists()) {
            if (in.isDirectory()) {

                TreeDirectoryCreator creator = new TreeDirectoryCreator();

                File out = new File("./java/src/main/resources/file.txt");
                TreeDirectoryWriter writer = new TreeDirectoryWriter(out);
                writer.writeTreeDirectoryToTxt(creator.writeStructureOfFoldersAndFiles(in));

            } else if (in.isFile() && in.getName().endsWith(".txt")) {

                TreeDirectoryReader reader = new TreeDirectoryReader();

                TreeDirectoryAnalyser analyser = new TreeDirectoryAnalyser(
                        reader.readTxtFile(in));


                System.out.printf("Number of folders: %d\n", analyser.countNumOfFolders());
                System.out.printf("Number of files: %d\n", analyser.countNumOfFiles());
                System.out.printf("Average number of files in a folder: %.1f\n",
                        analyser.countAverageNumOfFilesInFolder());
                System.out.printf("Average file name length: %d\n",
                        analyser.countAverageNameLengthOfFiles());


            } else {
                System.out.println(in.getName()
                        + " isn't a directory or file.");
            }
        } else {
            System.out.println(in.getName() + " has not been found");
        }
   }
}
