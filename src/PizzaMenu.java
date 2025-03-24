import java.util.ArrayList;
import java.util.List;
public class PizzaMenu {

    static List<Pizza> pizzaList;

public static void menu() {
    pizzaList = new ArrayList<>();
    Pizzaer();
}

    public void Pizzaer() {
        pizzaList.add(new Pizza(1, "Vesuvio", "tomatsauce, ost, skinke og oregano", 57));
        pizzaList.add(new Pizza(2, "Amerikaner",  "tomatsauce, ost, oksefars og oregano", 53));
        pizzaList.add(new Pizza(3, "Cacciator", "tomatsauce, ost, pepperoni og oregano", 57));
        pizzaList.add(new Pizza(4, "Carbona", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63));
        pizzaList.add(new Pizza(5, "Dennis", "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65));
        pizzaList.add(new Pizza(6, "Bertil", "tomatsauce, ost, bacon og oregano", 57));
        pizzaList.add(new Pizza(7, "Silvia", "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61));
        pizzaList.add(new Pizza(8, "Victoria", "tomatsauce, ost, skinke, ananas, champignon, løg, og oregano", 61));
        pizzaList.add(new Pizza(9, "Toronfo", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61));
        pizzaList.add(new Pizza(10, "Capricciosa", "tomatsauce, ost, skinke, champignon og oregano", 61));
        pizzaList.add(new Pizza(11, "Hawai", "tomatsauce, ost, skinke, ananas og oregano", 61));
        pizzaList.add(new Pizza(12, "Le Blissola", "tomatsauce, ost, skinke, rejer og oregano", 61));
        pizzaList.add(new Pizza(13, "Venezia", "tomatsauce, ost, skinke, bacon og oregano", 61));
        pizzaList.add(new Pizza(14, "Mafia", "tomatsauce, ost, pepperoni, bacon, løg og oregano", 61));
        printMenu();
    }

    public static void printMenu() {
    System.out.println("---------------------------------------------------------------------------");
    System.out.println("|                                                                         |");
    System.out.println("|                       " + "MARIOS PIZZA BAR" + "                        |");
    System.out.println("|                                                                         |");

    }
}
