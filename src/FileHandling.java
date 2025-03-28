import java.io.*;


// TODO: Gem i mapper (year/month) til åbning i menuen statisticYearMenu

@SuppressWarnings("CallToPrintStackTrace")
public class FileHandling {

    public static void createFile(String path) {
        try {
            File fil = new File(path);
            if (fil.createNewFile()) {
                System.out.println("File created: " + fil.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public static void writeToFile(String tekstTilFil, String path) {
        try {
            FileWriter myWriter = new FileWriter(path, true);
            myWriter.write(tekstTilFil);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
