import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PizzaMenu {

    private static ArrayList<Pizza> pizzaList = new ArrayList<>();
    List<String> dots;


    public PizzaMenu() {
        this.pizzaList = new ArrayList<>();
        this.dots = new ArrayList<>();

        loadPizzaFromFiles();
        Pizzaer();
        printMenu();
    }

    public static List<Pizza> getPizzaList() {
        return pizzaList;
    }
    public static void setPizzaList(List<Pizza> newPizzaList) {
        pizzaList = (ArrayList<Pizza>) newPizzaList;
    }

    public void Pizzaer() {
        pizzaList.add(new Pizza(1, "Vesuvio", false, "tomatsauce, ost, skinke og oregano", 57));
        pizzaList.add(new Pizza(2, "Amerikaner", true, "tomatsauce, ost, oksefars og oregano", 53));
        pizzaList.add(new Pizza(3, "Cacciator", false, "tomatsauce, ost, pepperoni og oregano", 57));
        pizzaList.add(new Pizza(4, "Carbona", true, "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63));
        pizzaList.add(new Pizza(5, "Dennis", true, "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65));
        pizzaList.add(new Pizza(6, "Bertil", false, "tomatsauce, ost, bacon og oregano", 57));
        pizzaList.add(new Pizza(7, "Silvia", false, "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61));
        pizzaList.add(new Pizza(8, "Victoria", false, "tomatsauce, ost, skinke, ananas, champignon, løg, og oregano", 61));
        pizzaList.add(new Pizza(9, "Toronfo", true, "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61));
        pizzaList.add(new Pizza(10, "Capricciosa", false, "tomatsauce, ost, skinke, champignon og oregano", 61));
        pizzaList.add(new Pizza(11, "Hawai", false, "tomatsauce, ost, skinke, ananas og oregano", 61));
        pizzaList.add(new Pizza(12, "Le Blissola", false, "tomatsauce, ost, skinke, rejer og oregano", 61));
        pizzaList.add(new Pizza(13, "Venezia", false, "tomatsauce, ost, skinke, bacon og oregano", 61));
        pizzaList.add(new Pizza(14, "Mafia", true, "tomatsauce, ost, pepperoni, bacon, løg og oregano", 61));

        this.dots.add("...................................................");
        this.dots.add("........................................");
        this.dots.add("..............................................");
        this.dots.add("................");
        this.dots.add("...................");
        this.dots.add(".....................................................");
        this.dots.add(".........................");
        this.dots.add("........................");
        this.dots.add("........................");
        this.dots.add("..................................");
        this.dots.add("............................................");
        this.dots.add(".......................................");
        this.dots.add("...........................................");
        this.dots.add("...............................");
    }

    //Adder ny pizzaer til liste
    public void addPizza ( Pizza pizza){
        System.out.println("add pizza fil...");

        if (pizza != null){
            pizzaList.add(pizza);
            dots.add(".....................");
            System.out.println(pizzaList.size());
            printMenu();
        } else {
            System.out.println("Fejl! kunne ikke register pizzaen! ");
        }
    }

    public static void savePizzaToFiles() {

        try (PrintWriter writer = new PrintWriter(new File("pizzaList.txt"))) {
            for (Pizza pizza : pizzaList) {
                writer.println(pizza.getPizzaNummer() + ";" + pizza.getName() + ";" + pizza.getIngredients() + ";" + pizza.getPrice() + ";" + pizza.getIsNyhed());
            }
            System.out.println("Pizza menuen er blevet gemt");
        } catch (FileNotFoundException e) {
            System.out.println("fejl ved lagring af pizza menuen");
        }
    }

    public void loadPizzaFromFiles() {
        File file = new File("pizzaList.txt");

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(";");

                    if (parts.length == 4) {
                        int nummer = Integer.parseInt(parts[0]);
                        String navn = parts[1];
                        String ingredienser = parts[2];
                        int pris = Integer.parseInt(parts[3]);
                        boolean isNyhed = false;
                        pizzaList.add(new Pizza(nummer, navn, false, ingredienser,pris));
                    }
                }
                System.out.println("Menuen er indlæst fra fil");
            } catch (FileNotFoundException e) {
                System.out.println("Filen kunne ikke findes");
            }
        } else {
            System.out.println("Fil ikke fundet, bruger standard menuen");
            Pizzaer();
        }
    }
    //til omsætning
    public int pizzaPrice(int pizzaNummer){
        for (Pizza pizza : pizzaList){
            if (pizza.getPizzaNummer() == pizzaNummer){
                return pizza.getPrice();

            }
        }
        System.out.println("Pizza ikke fundet: " + pizzaNummer);
        return 0;
    }

    public static void printMenu() {
        System.out.println(Farver.orangeMain + " _______________________________________________________________________________________________________" + Farver.reset);
        System.out.println(Farver.orangeMain + "|                                                                                                       |" + Farver.reset);
        System.out.println(Farver.orangeMain + "|                                               " + " PIZZAER " + "                                               |" + Farver.reset);
        System.out.println(Farver.orangeMain + "|                                                                                                       |" + Farver.reset);
        for (int i = 0; i < pizzaList.size(); i++) {
            Pizza pizza = pizzaList.get(i);
            // String dotsStr = (i < dots.size()) ? dots.get(i) : "................"; // Undgå fejl

            System.out.println(Farver.orangeMain + "| " + Farver.reset + pizza.menuString(pizza.getIsNyhed()) + Farver.orangeMain + " |" + Farver.orangeMain);
        }
        System.out.println(Farver.orangeMain + "|                                                                                                       |" + Farver.reset);
        System.out.println(Farver.orangeMain + " _______________________________________________________________________________________________________" + Farver.reset);

    }
}



