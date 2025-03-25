import java.util.Scanner;

public class MenuController {


    public static void mainMenu(){

    }

    public static void orderMenu(){

    }

    public static void statisticMenu(){
Scanner scanner = new Scanner(System.in);
boolean running = true;


while (running) {
    System.out.println("1. vis statistik for ´dag´: ");
    System.out.println("2. Vis statistik for ´måned´: ");
    System.out.println("3. Vis statistik for ´år´:");
    System.out.println("4. Vis statistik for mest sold i dag ");
    System.out.println("5. Vis statistik for mest sold uge ");
    System.out.println("6. Vis statistik for mest sold måned ");
    System.out.println("7. Vis statistik for mest sold år");
    System.out.println("8. Gå tilbage til main menu: ");

    if (!scanner.hasNextInt()){
        System.out.println("Ugyldigt input!");
        scanner.nextLine();
        continue;
    }

    int choice = scanner.nextInt();
    switch (choice){
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
            break;
        case 8:
            PizzaBarMain.run();
            break;

    }
}

    //statistik methods er i "StatisticController"
    }


}
