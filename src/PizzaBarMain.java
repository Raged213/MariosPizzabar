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
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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
                2. Rediger eller annullér ordre
                3. Vis statistik
                
                4. Se lagerbeholdning 
                5. Opret ny pizza
                6. ændre pizzapris
                """ + red +
                "7. Slut system" + reset;
    }
}