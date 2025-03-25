import java.util.ArrayList;
import java.util.Scanner;

public class PizzaBarController {

    public static ArrayList<Order> orderList = new ArrayList<>();

    public static void createOrder() {
        int ordNr = 0;
        //int X =+ X + 1;
        Scanner sc = new Scanner(System.in);
        Order x = new Order();
        ordNr = +ordNr + 1;
        x.setOrdreNummer(ordNr);
        System.out.print("Kunde navn:");
        String navn = sc.nextLine();
        x.setNavn(navn);
        System.out.print("Pizzanummer:");
        int PizzaNummer = sc.nextInt();
        x.setPizzaNummer(PizzaNummer);
        sc.nextLine();
        System.out.print("Afhentnings Tidspunkt:");
        String AfhentningsTidspunkt = sc.nextLine();
        x.setAfhentningsTidspunkt(AfhentningsTidspunkt);
        addToList(x);
    }

    public static void addToList(Order ordre) {
        orderList.add(ordre);
        System.out.println(orderList);

    }

    public static void removeOrder() {

    }

    public static void saveOrder() {
        boolean y = true;
        Scanner scan = new Scanner(System.in);

        while (y) {
            System.out.println("Hvilken ordre vil du gerne slette: \n" + orderList);
            int save = scan.nextInt();
            scan.nextLine();
            System.out.println("Er du sikker på at du vil gemme: (" + save + ")" + " (y/s)");
            String accept = scan.nextLine();

            if (accept.equalsIgnoreCase("y")) {
                String saveOrder = String.valueOf(orderList.get(save));
                FileHandling.writeToFile(saveOrder, "OrdreListe.txt");
                y = false;
                System.out.println(PizzaBarMain.green + "Ordre: " + save + " er nu markeret som færdig!" + PizzaBarMain.reset);
            } else {
                continue;
            }
        }
    }


    public static Pizza createPizza() {
        Scanner scanner = new Scanner(System.in);
        //Enter pizzas number
        System.out.print("Indtast pizza nummer: ");
        int pizzaNummer = scanner.nextInt();

        //Enter Pizzas navn
        System.out.print("Indtast pizza navn: ");
        String name = scanner.nextLine();
        scanner.nextLine();

        //Er det en nyhed
        System.out.print("Er det en nyhed?: (True/false) ");
        boolean isNyhed = scanner.nextBoolean();
        scanner.nextLine();

        //Enter Pizzas ingredients
        System.out.print("Indtast ingredients: ");
        String ingredients = scanner.nextLine();

        //Enter prisen på pizza
        int price;
        while (true) {
            System.out.print("Indtast pris (heltal): ");
            if (scanner.hasNextInt()) {
                price = scanner.nextInt();
                scanner.nextLine(); // Fjerner newline
                break;
            } else {
                System.out.println("Kan ikke register øre, prøve igen med hele nummer! ");
                scanner.nextLine();
            }
        }

        Pizza newPizza = new Pizza(pizzaNummer, name, isNyhed, ingredients, price);
        System.out.println("Pizza Tilføjet: " + newPizza);

        return newPizza;
    }

    public static void editPizza() {

    }


}
