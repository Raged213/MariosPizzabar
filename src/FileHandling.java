import java.io.*;
import java.util.*;
import java.io.PrintWriter;

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
    public static ArrayList<String> readFile(String path) {
        ArrayList<String> linjer = new ArrayList<>();

        try {
            File fil = new File(path);
            Scanner myReader = new Scanner(fil);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                linjer.add(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return linjer;
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
