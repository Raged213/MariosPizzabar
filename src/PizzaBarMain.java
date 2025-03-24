import java.util.Scanner;
public class PizzaBarMain {

    private static final String reset = "\u001B[0m";
    private static final String red = "\u001B[1;31m";
    private static final String green = "\u001B[32m";
    private static final String orangeMain = "\033[38;1;255;165;0m";

    public static void main(String[] args) {

        FileHandling.createFile();
        PizzaMenu menuKort = new PizzaMenu();
        run();
    }


    public static void run() {

        Scanner scanner = new Scanner(System.in);
        boolean y = true;

        while (y) {
            //System.out.println(OrderList());
            System.out.println(mainMenu());
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:                  // 1. Opret ordre
                    PizzaBarController.createOrder();
                    break;
                case 2:                  // 2. Slet ordre
                    break;
                case 3:                  // 3. Vis statistik
                    break;
                case 4:                  // 4. Opret ny pizza
                    break;
                case 5:                  // 5. ændre pizzapris
                    break;
                case 6:                  // 6. Slut system
                    y = false;
                    System.out.println(red + "\nSystemet sluttes" + reset);
                    break;
            }
        }
    }

    public static String mainMenu() {
        return orangeMain + "Main Menu" + reset + ":" +
                """
                1. Opret ordre
                2. Slet ordre
                3. Vis statistik
                
                4. Opret ny pizza
                5. ændre pizzapris
                """ + red +
                "6. Slut system" + reset;
    }
}