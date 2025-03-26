import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class StatisticController {

    public static void mostSoldThisDay(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String todayString = today.format(formatter);

        findMostSold("OrdreListe.txt", todayString);
    }

    public static void mostSoldThisWeek(){
    }

    public static void mostSoldThisMonth(){
    }

    public static void mostSoldThisYear(){
    }

    private static int[] countSales(String filePath, String dateFilter) {
        int[] pizzaSales = new int[25]; // Antager max 25 forskellige pizzaer

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length >= 3) {
                    String date = parts[2];
                    if (date.startsWith(dateFilter)) {
                        int pizzaNum = Integer.parseInt(parts[1]);
                        if (pizzaNum > 0 && pizzaNum < pizzaSales.length) {
                            pizzaSales[pizzaNum]++;
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fejl: Filen kunne ikke findes.");
        }

        return pizzaSales;
    }
    private static void findMostSold(String filePath, String dateFilter) {
        int[] pizzaSales = countSales(filePath, dateFilter);

        System.out.println("\n Salgsstatistik for " + dateFilter + ":");
        boolean foundSales = false;
        int maxSold = 0;

        for (int i = 0; i < pizzaSales.length; i++) {
            if (pizzaSales[i] > maxSold) {
                maxSold = pizzaSales[i];
            }
        }

        if (!foundSales) {
            System.out.println("Ingen salg fundet for denne periode");
        }
    }
    private static void printSales(int[] pizzaSales) {
        System.out.println("Salgstal:");
        for (int i = 0; i < pizzaSales.length; i++) {
            if (pizzaSales[i] > 0) {
                System.out.println("Pizza " + i + ": " + pizzaSales[i] + " stk solgt");
            }
        }
    }
}
