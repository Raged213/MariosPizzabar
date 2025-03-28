import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.List;

// TODO: Gem i mapper (year/month) til åbning i menuen statisticYearMenu

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
    public static void readFile(String path) {
        try {
            File fil = new File(path);
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

    public static void sortFile(String path) {
        File fil = new File(path);


    }

    public static void savePizzaList(List<Pizza> pizzaList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("pizzaList.txt"))) {
            for (Pizza pizza : pizzaList) {
                writer.println(pizza.getPizzaNummer() + ";" + pizza.getName() + ";" + pizza.getIngredients() + ";" + pizza.getPrice() + ";" + pizza.getIsNyhed());
            }
            System.out.println("Pizza menuen gemt i pizzaList.txt");
        } catch (IOException e) {
            System.out.println("fejl, kunne ikke gemme menuen" + e.getMessage());
        }
    }



}
