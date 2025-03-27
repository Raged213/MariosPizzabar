import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        int pizzaNummer; //Så at jeg kalder pizzaNummer i loopet og ved print af newPizza
        //Enter pizzas number
       while (true) {
           System.out.print("Indtast pizza nummer: ");
           if (scanner.hasNextInt()) {
               pizzaNummer = scanner.nextInt();
               scanner.nextLine();
               break;
           } else {
               System.out.println("Prøve igen med nummer istedet: ");
               scanner.nextLine();
           }
       }

        //Enter Pizzas navn
        System.out.print("Indtast pizza navn: ");
        String name = scanner.nextLine();

        //Er det en nyhed

        boolean isNyhed; //For at bruge isNyhed i vores while loop.
        while (true){
        System.out.print("Er det en nyhed?: (true/false) ");
        String nyhedInput = scanner.next().trim().toLowerCase();

        if (nyhedInput.equals("true")){
            isNyhed = true;
            break;
        } else if (nyhedInput.equals("false")){
            isNyhed = false;
            break;
        } else {
            System.out.println("Ugyldigt input, prøve igen med enten ´true´ eller ´false´");
        }
        }
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

        Scanner scanner = new Scanner(System.in);
        PizzaMenu pizzaMenu = new PizzaMenu();

        System.out.println("pizzaer:");
        for (Pizza pizza : pizzaMenu.pizzaList) {
            System.out.println(pizza.getPizzaNummer() + ": " + pizza.getName() + " - " + pizza.getPrice() + " kr");
        }

        System.out.print("Indtast nummeret på den pizza, du vil redigere: ");
        int pizzaNummer = scanner.nextInt();
        scanner.nextLine();

        Pizza pizzaToEdit = null; //leder efter den valgte pizza i listen
        for (Pizza pizza : pizzaMenu.pizzaList) {
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
        if (!newName.isEmpty()) { //hvis man tryjjer enter går man til det næste
            pizzaToEdit.setName(newName); //skriv et nyt navn til den valgte pizza
        }

        System.out.print("Indtast nye ingredienser (eller tryk Enter for at beholde de gamle): ");
        String newIngredients = scanner.nextLine();
        if (!newIngredients.isEmpty()) { //ogem tryl enter for at gå til det næste
            pizzaToEdit.setIngredients(newIngredients); //skriv de nye ingredienser til pizzaen
        }

        System.out.print("Indtast ny pris (eller tryk Enter for at beholde den gamle): ");
        String newPriceInput = scanner.nextLine();
        if (!newPriceInput.isEmpty()) { //igen tryk enter for at gå viderer
            int newPrice = Integer.parseInt(newPriceInput); //hvis der bliver indtastet en ny pris bliver det lavet om til en Int og prisen opdateres
            pizzaToEdit.setPrice(newPrice); //prisen opdateres
        }
        pizzaMenu.savePizzaToFiles();

        System.out.println(Farver.green + "Pizzaen er blevet opdateret!" + Farver.reset);
    }

}

