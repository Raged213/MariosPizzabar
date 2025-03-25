import java.awt.*;
import java.util.Scanner;
public class PizzaBarMain {

    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[1;31m";
    public static final String green = "\u001B[32m";
    public static final String orangeMain = "\033[38;2;255;165;0m";

    public static void main(String[] args) {

        FileHandling.createFile("PizzaListe.txt");
        FileHandling.createFile("OrdreListe.txt");
        PizzaMenu menuKort = new PizzaMenu();
        run();
    }


    public static void run() {
        PizzaMenu menuKort = new PizzaMenu();

        Scanner scanner = new Scanner(System.in);
        boolean y = true;

        while (y) {
            //System.out.println(orderList());
            System.out.println(mainMenu());
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:                  // 1. Opret ordre
                    PizzaBarController.createOrder();
                    break;
                case 2:                  // 2. Gem ordre (marker som færdig)
                    PizzaBarController.saveOrder();
                    break;
                case 3:                  // 3. Slet ordre
                    break;
                case 4:                  // 4. Vis statistik
                    MenuController.statisticMenu();
                    break;
                case 5:                  // 5. Opret ny pizza
                    Pizza newPizza = PizzaBarController.createPizza();
                    menuKort.addPizza(newPizza);
                    break;
                case 6:                  // 6. ændre pizzapris
                    break;
                case 7:                  // 7. Slut system
                    y = false;
                    System.out.println(red + "\nSystemet sluttes" + reset);
                    break;
            }
        }
    }

    public static String mainMenu() {
        return orangeMain + "\nMain Menu:" + reset + "\n" +
                """
                1. Opret ordre
                2. Gem ordre (marker som færdig)
                3. Slet ordre
                4. Vis statistik
                
                5. Opret ny pizza
                6. ændre pizzapris
                """ + red +
                "7. Slut system" + reset;
    }
}