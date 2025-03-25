import java.util.ArrayList;
import java.util.Scanner;

public class PizzaBarController {


public static void createOrder(){
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
    sc.nextLine();
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
/*
    public static Pizza createPizza() {
        Scanner scanner = new Scanner(System.in);
        //Enter Pizzas navn
        System.out.print("Enter pizza name: ");
        String name = scanner.nextLine();

        //Enter Pizzas ingredients
        System.out.print("Enter ingredients: ");
        String ingredients = scanner.nextLine();

        //Enter prisen på pizza
        int price;
        while(true) {
            System.out.print("Enter prisen på pizza, hele nummer!: ");
            if (scanner.hasNextInt()){
                scanner.nextLine();
                break;
            }else {
                System.out.println("Kan ikke register øre, prøve igen med hele nummer! ");
                scanner.nextLine();
            }
        }

        Pizza newPizza = new Pizza(name, ingredients, price);
        System.out.println("Pizza created: " + newPizza);

        return newPizza;
        }
*/
public static void editPizza(){

}





}
