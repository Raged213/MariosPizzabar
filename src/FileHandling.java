import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// TODO: Gem i mapper (year/month) til åbning i menuen statisticYearMenu

public class FileHandling {

    public static void createFile() {
        try {
            File fil = new File("PizzaListe");
            if (fil.createNewFile()) {
                System.out.println("File created: " + fil.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String Pizza) {
        try {
            FileWriter myWriter = new FileWriter("PizzaListe.txt", true);
            myWriter.write(Pizza);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void readFile() {
        try {
            File fil = new File("PizzaListe.txt");
            Scanner myReader = new Scanner(fil);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");
                System.out.println(Arrays.toString(words));
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void sortFile() {
        File fil = new File("PizzaListe.txt");


    }



}
