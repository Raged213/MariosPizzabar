import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PizzaBarController {

    public static ArrayList<Order> orderList = new ArrayList<>();
    public static int ordreNr = -1;

    public static void createOrder() {
        PizzaMenu.printMenu();
        Scanner sc = new Scanner(System.in);

        System.out.print("KundeNavn:");
        // Tjekker om inputtet er en String
        if (sc.hasNextInt()) {
            System.out.println(Farver.red + "Ugyldigt input! Du skal skrive et navn!" + Farver.reset);
            sc.nextLine();
        } else {
            // Opretter ny ordre
            Order x = new Order();
            ordreNr++;                  // Tager det forhenværende ordreNr og lægger en til
            x.setOrdreNummer(ordreNr);  // Tillægger den nyoprettede ordre (x) et ordreNr

            String navn = sc.nextLine();
            x.setNavn(navn);            // Tillægger KundeNavn til den nyoprettede ordre


            System.out.println(Farver.green + "Skriv \"x\" når du ikke vil tilføje flere pizzanumre!)" + Farver.reset);
            while (true) {
                System.out.print("Pizzanummer: ");

                String input = sc.nextLine();

                if (input.equalsIgnoreCase("x")) break;

                try {
                    int PizzaNummer = Integer.parseInt(input);
                    if (PizzaNummer <= 0) {
                        System.out.println(Farver.red + "Ugyldig pizza! du skal skrive et pizzanummer" + Farver.reset + "\n");
                    }

                    x.setPizzaNummer(PizzaNummer);
                } catch (NumberFormatException e) {
                    System.out.println(Farver.red + "Ugyldig pizza! du skal skrive et pizzanummer" + Farver.reset + "\n");
                }
            }

            System.out.println("Afhentnings Tidspunkt: (TT:MM)");
            String AfhentningsTidspunkt = sc.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime tid = LocalTime.parse(AfhentningsTidspunkt, formatter);
            x.setAfhentningsTidspunkt(tid);

            System.out.println("Tilføj bemærkning, eller tryk \"x\" for ingen bemærkning:");
            String bemærkning = sc.nextLine();

            if (!bemærkning.equalsIgnoreCase("x")) {
                System.out.println("Bemærkning:" + bemærkning);
                x.setBemærkning(bemærkning);
            } else {System.out.println("");}


            addToList(x);

            System.out.println("Ordre oprettet med ordrenummer: " + ordreNr);
        }
    }

    public static void addToList(Order ordre) {
        orderList.add(ordre);

    }

    public static void removeOrder() {
        Scanner scan = new Scanner(System.in);

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


        System.out.print("Indtast pizzanavn: ");
        String navn = scanner.nextLine();


        System.out.print("Indtast ingredienser (separeret med komma): ");
        String ingredienser = scanner.nextLine();

        System.out.print("Indtast pris: ");
        int pris = scanner.nextInt();
        scanner.nextLine(); // For at undgå scanner-bug

        System.out.print("Er det en nyhed? (true/false): ");
        boolean isNyhed = scanner.nextBoolean();
        scanner.nextLine(); // For at undgå scanner-bug

        int newPizzaNummer = PizzaMenu.getPizzaList().isEmpty() ? 1 : PizzaMenu.getPizzaList().get(PizzaMenu.getPizzaList().size() - 1).getPizzaNummer() + 1;

        // Opret ny pizza
        Pizza newPizza = new Pizza(newPizzaNummer, navn, isNyhed, ingredienser, pris);

        // Tilføj pizzaen til den originale liste i PizzaMenu
        PizzaMenu.getPizzaList().add(newPizza);

        // Gem den nye pizza i filen
        PizzaMenu.savePizzaToFiles();

        // Print den opdaterede menu
        PizzaMenu.printMenu();

        System.out.println("Ny pizza tilføjet og menuen opdateret!");

        return newPizza;
    }

    public static void editPizza() {

        Scanner scanner = new Scanner(System.in);
        PizzaMenu pizzaMenu = new PizzaMenu();

        //System.out.println("pizzaer:");
        //for (Pizza pizza : PizzaMenu.getPizzaList()) {
        //    System.out.println(pizza.getPizzaNummer() + ": " + pizza.getName() + " - " + pizza.getPrice() + " kr");
        //}

        System.out.print("Indtast nummeret på den pizza, du vil redigere: ");
        int pizzaNummer = scanner.nextInt();
        scanner.nextLine();

        Pizza pizzaToEdit = null; //leder efter den valgte pizza i listen
        for (Pizza pizza : pizzaMenu.getPizzaList()) {
            if (pizza.getPizzaNummer() == pizzaNummer) {
                pizzaToEdit = pizza;
                break; //hvis den findes breaker vi
            }
        }

        if (pizzaToEdit == null) { //hvis der bliver indtastet et ugyldigt pizzanummer
            System.out.println("Pizzaen blev ikke fundet."); //bliver denne besked printet
            return; //return så den ikke prøver at redigerer en pizza der ikke eksisterer
        }

        System.out.print("Indtast nyt navn (eller tryk Enter for at beholde det gamle): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) { //hvis man trykker enter går man til det næste
            pizzaToEdit.setName(newName); //skriv et nyt navn til den valgte pizza
        }

        System.out.print("Indtast nye ingredienser (eller tryk Enter for at beholde de gamle): ");
        String newIngredients = scanner.nextLine();
        if (!newIngredients.isEmpty()) { //og tryk enter for at gå til det næste
            pizzaToEdit.setIngredients(newIngredients); //skriv de nye ingredienser til pizzaen
        }

        System.out.print("Indtast ny pris (eller tryk Enter for at beholde den gamle): ");
        String newPriceInput = scanner.nextLine();
        if (!newPriceInput.isEmpty()) { //igen tryk enter for at gå viderer
            int newPrice = Integer.parseInt(newPriceInput); //hvis der bliver indtastet en ny pris bliver det lavet om til en Int og prisen opdateres
            pizzaToEdit.setPrice(newPrice); //prisen opdateres
        }
        PizzaMenu.savePizzaToFiles();

        System.out.println(Farver.green + "Pizzaen er blevet opdateret!" + Farver.reset);
        PizzaMenu.printMenu();
    }

}

