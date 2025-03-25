import java.util.ArrayList;
import java.util.Scanner;

public class PizzaBarController {


public static void creatOrder(){
    int ordNr = 0;
    //int X =+ X + 1;
    Scanner sc = new Scanner(System.in);
    Order x = new Order();
    ordNr =+ ordNr + 1;
    x.setOrdreNummer(ordNr);
    System.out.print("Kunde navn:");
    String navn = sc.nextLine();
    x.setNavn(navn);
    System.out.print("Pizzanummer:");
    int PizzaNummer = sc.nextInt();
    x.setPizzaNummer(PizzaNummer);
    System.out.print("Afhentnings Tidspunkt:");
    String AfhentningsTidspunkt = sc.nextLine();
    x.setAfhentningsTidspunkt(AfhentningsTidspunkt);
    addToList(x);
}

public static void addToList(Order ordre){
    ArrayList<Order> orderList = new ArrayList<>();
    orderList.add(ordre);
    System.out.println(orderList);

}

public static void removeOrder(){

}

public static void saveOrder(){

}

    public static Pizza createPizza() {
        Scanner scanner = new Scanner(System.in);
        //Enter Pizza number
        System.out.print("Indtast Pizza Number");
        int pizzaNumber = scanner.nextInt();

        //Enter Pizzas navn
        System.out.print("Indtast pizza name: ");
        String name = scanner.nextLine();

        //er det en Nyhed?
        System.out.print("Er det en nyhed? (True/false)");
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
                scanner.nextLine();
                break;
            } else {
                System.out.println("Fejl! Indtast gerne et heltal.");
                scanner.nextLine();
            }
        }

        Pizza newPizza = new Pizza(pizzaNumber, name, isNyhed, ingredients, price);
        System.out.println("✅ Ny pizza oprettet: " + newPizza);
        return newPizza;
    }

public static void editPizza(){

}





}
