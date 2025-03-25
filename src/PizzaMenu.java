import java.util.ArrayList;
import java.util.List;
public class PizzaMenu {

     List<Pizza> pizzaList;
     List<String> dots;


    public  PizzaMenu() {
    pizzaList = new ArrayList<>();
    dots = new ArrayList<>();
    Pizzaer();
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

        this.dots.add("........................................");
        this.dots.add("............................");
        this.dots.add(".................................");
        this.dots.add("........");
        this.dots.add(".............");
        this.dots.add("...........................................");
        this.dots.add(".....................");
        this.dots.add("..................");
        this.dots.add("...................");
        this.dots.add("..........................");
        this.dots.add(".......................................");
        this.dots.add("....................................");
        this.dots.add("......................................");
        this.dots.add("..........................");
        printMenu();
    }

//Adder ny pizzaer til liste
    public void addPizza ( Pizza pizza){
        if (pizza != null){
            pizzaList.add(pizza);
            dots.add(".....................");
            System.out.println(pizza.getName());
        } else {
            System.out.println("Fejl! kunne ikke register pizzaen! ");
        }
    }


    public void printMenu() {
    System.out.println("----------------------------------------------------------------");
    System.out.println("|                                                              |");
    System.out.println("|                                 " + "PIZZAER" + "                                  |");
    System.out.println("|                                                                                     |");
        for (int i = 0; i < pizzaList.size(); i++) {
            Pizza pizza = pizzaList.get(i);
            String dotsStr = (i < dots.size()) ? dots.get(i) : "................"; // Undgå fejl

            System.out.println("| " + pizza.menuString(pizza.getIsNyhed(), dotsStr) + " |");
    }

    }


}
