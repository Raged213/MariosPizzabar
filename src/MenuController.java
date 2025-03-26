import java.util.Scanner;

public class MenuController {

    public static void mainMenu() {
        PizzaMenu menuKort = new PizzaMenu();

        Scanner scanner = new Scanner(System.in);
        boolean y = true;

        while (y) {
            System.out.print("\n" + Farver.green + "ORDRELISTE:\n" + Farver.reset + PizzaBarController.orderList + "\n");
            System.out.println(mainMenuTekst());

            // Tjekker om inputtet er en int
            if (!scanner.hasNextInt()) {
                System.out.println("Ugyldigt input!");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:                  // 1. Opret ordre
                    PizzaBarController.createOrder();
                    break;
                case 2:                  // 2. Gem ordre (marker som færdig)
                    PizzaBarController.saveOrder();
                    break;
                case 3:                  // 3. Slet ordre
                    PizzaBarController.removeOrder();
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
                    System.out.println(Farver.red + "\nSystemet sluttes" + Farver.reset);
                    break;
            }
        }
    }

    public static String mainMenuTekst() {
        return Farver.orangeMain + "\nMain Menu:" + Farver.reset + "\n" +
                """
                        1. Opret ordre
                        2. Gem ordre (marker som færdig)
                        3. Slet ordre
                        4. Vis statistik
                        
                        5. Opret ny pizza
                        6. ændre pizzapris
                        """ + Farver.red +
                "7. Slut system" + Farver.reset;
    }


    public static void orderMenu() {

    }

    public static void statisticMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            System.out.println("1. Vis statistik for mest sold i dag ");
            System.out.println("2. Vis statistik for mest sold uge ");
            System.out.println("3. Vis statistik for mest sold måned ");
            System.out.println("4. Vis statistik for mest sold år");

            if (!scanner.hasNextInt()) {
                System.out.println("Ugyldigt input!");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    StatisticController.mostSoldThisDay();
                    break;
                case 2:
                    StatisticController.mostSoldThisWeek();
                    break;
                case 3:
                    StatisticController.mostSoldThisMonth();
                    break;
                case 4:
                    StatisticController.mostSoldThisYear();
                    break;
                case 5:
                    running = false;
                    System.out.println("Vis statistik afslutes! ");
                    break;

            }
        }
        //statistik methods er i "StatisticController"
    }
}
