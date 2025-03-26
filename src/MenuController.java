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
    System.out.println("1. Vis statistik for mest sold i dag ");
    System.out.println("2. Vis statistik for mest sold uge ");
    System.out.println("3. Vis statistik for mest sold måned ");
    System.out.println("4. Vis statistik for mest sold år");

    if (!scanner.hasNextInt()){
        System.out.println("Ugyldigt input!");
        scanner.nextLine();
        continue;
    }

    int choice = scanner.nextInt();
    switch (choice){
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
