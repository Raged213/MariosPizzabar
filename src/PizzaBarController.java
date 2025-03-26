import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PizzaBarController {

    public static ArrayList<Order> orderList = new ArrayList<>();
    public static int ordreNr = -1;
    public static LocalTime tid;

    public static void createOrder() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Kunde navn:");
        if (sc.hasNextInt()) {
            System.out.println(Farver.red + "Ugyldigt input! Du skal skrive et navn!" + Farver.reset);
            sc.nextLine();
        } else {

            Order x = new Order();
            ordreNr++;
            x.setOrdreNummer(ordreNr);

            String navn = sc.nextLine();
            x.setNavn(navn);

            while (true) {
                System.out.print("Pizzanummer: " + Farver.green + "(tryk \"-1\" når du ikke vil tilføje flere pizzanumre!) " + Farver.reset);
                int PizzaNummer = sc.nextInt();
                if (PizzaNummer == -1) break;
                x.setPizzaNummer(PizzaNummer);
            }
            sc.nextLine();      // rydder linjen

            System.out.print("Afhentnings Tidspunkt: (TT:MM)");
            String AfhentningsTidspunkt = sc.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime tid = LocalTime.parse(AfhentningsTidspunkt, formatter);
            x.setAfhentningsTidspunkt(tid);

            addToList(x);

            System.out.println("Ordre oprettet med ordrenummer: " + ordreNr);
        }
    }

    public static void addToList(Order ordre) {
        orderList.add(ordre);

    }

    public static void removeOrder() {
        Scanner scan = new Scanner(System.in);
        boolean found = false;

        System.out.println("Hvilken ordre vil du gerne slette: \n" + orderList);
        int valg = scan.nextInt();
        scan.nextLine();

        // Finder indeks for ordrenummeret
        Order orderToRemove = null;
        for (Order o : orderList) {
            if (o.getOrdreNummer() == valg) { // Finder den rigtige ordre
                orderToRemove = o;
                break;
            }
        }

        // Hvis ordrenummeret er fundet
        if (orderToRemove != null) {
            System.out.println(Farver.red + "Er du sikker på at du vil slette ordre: (" + valg + ")" + " (y/s)" + Farver.reset);
            String accept = scan.nextLine();

            if (accept.equalsIgnoreCase("y")) {
                orderList.remove(orderToRemove);
                System.out.println(Farver.green + "Ordre: " + valg + " er nu slettet" + Farver.reset);
            }
        } else {
            System.out.println(Farver.red + "Ordrenummeret findes ikke!" + Farver.reset);
        }
    }

    public static void saveOrder() {
        Scanner scan = new Scanner(System.in);
        boolean found = false;

        System.out.println("Hvilken ordre vil du gerne markere som færdig: \n" + orderList);
        int save = scan.nextInt();
        scan.nextLine();

        // Finder indeks for ordrenummeret
        Order orderToSave = null;
        for (Order o : orderList) {
            if (o.getOrdreNummer() == save) { // Finder den rigtige ordre
                orderToSave = o;
                break;
            }
        }

        // Hvis ordrenummeret er fundet
        if (orderToSave != null) {
            System.out.println(Farver.red + "Er du sikker på at du vil markere ordre: (" + save + ")" + " som færdig (y/s)" + Farver.reset);
            String accept = scan.nextLine();

            if (accept.equalsIgnoreCase("y")) {
                String saveOrder = String.valueOf(orderToSave.toString());

                FileHandling.writeToFile(saveOrder, "OrdreListe.txt");
                orderList.remove(orderToSave);
                System.out.println(Farver.green + "Ordre: " + save + " er nu gemt" + Farver.reset);
            }
        } else {
            System.out.println(Farver.red + "Ordrenummeret findes ikke!" + Farver.reset);
        }

    }

    public static StringBuilder showSortedOrderList() {
        orderList.sort(Comparator.comparing(Order::getAfhentningsTidspunkt));

        StringBuilder resultat = new StringBuilder();
        for (Order o : orderList) {
            resultat.append(o.toString());
        }
        return resultat;
    }

    public static Pizza createPizza() {
        Scanner scanner = new Scanner(System.in);
        //Enter pizzas number
        System.out.print("Indtast pizza nummer: ");
        int pizzaNummer = scanner.nextInt();
        scanner.nextLine();

        //Enter Pizzas navn
        System.out.print("Indtast pizza navn: ");
        String name = scanner.nextLine();

        //Er det en nyhed
        System.out.print("Er det en nyhed?: (true/false) ");
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
        System.out.println(Farver.green + "Pizza Tilføjet: " + newPizza.getName() + Farver.reset);
        FileHandling.writeToFile(String.valueOf(newPizza), "PizzaListe.txt");

        return newPizza;
    }

    public static void editPizza() {

    }

}

