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
        int[] pizzaSales = new int[25]; // Hvor mange af samme pizza der kan blive solgt

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            boolean isOrderRelevant = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.startsWith("Ordrenummer: ")) {
                    isOrderRelevant = line.contains(dateFilter);
                }

                if (isOrderRelevant && line.startsWith("Navn: ")) {
                    int startIndex = line.indexOf("[");
                    int endIndex = line.indexOf("]");

                    if (startIndex != -1 && endIndex != -1) {
                        String pizzaNumbers = line.substring(startIndex + 1, endIndex);
                        String[] numbers = pizzaNumbers.split(", ");

                        for (String num : numbers) {
                            int pizzaNum = Integer.parseInt(num.trim());
                            if (pizzaNum > 0 && pizzaNum < pizzaSales.length) {
                                pizzaSales[pizzaNum]++;
                            }
                        }
                    }
                    isOrderRelevant = false;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fejl: Filen kunne ikke findes.");
        }

        return pizzaSales;
    }

    private static void findMostSold(String filePath, String dateFilter) {
        int[] pizzaSales;
        pizzaSales = countSales(filePath, dateFilter);

        System.out.println("\n Salgsstatistik for " + dateFilter + ":");

        boolean foundSales = false;
        int maxSold = 0;
        int mostSold = -1;

        for (int i = 0; i < pizzaSales.length; i++) {
            if (pizzaSales[i] > maxSold) {
                maxSold = pizzaSales[i];
                mostSold = i;
            }
            if (pizzaSales[i] > 0) {
                foundSales = true;
            }
        }

        if (!foundSales) {
            System.out.println("Ingen salg fundet for denne periode");
        } else {
            System.out.println("Den mest solgte pizza er " + mostSold + " med " + maxSold + "salg");
            printSales(pizzaSales);
        }
    }


    private static void printSales(int[] pizzaSales) {
        System.out.println("Salgstal: ");
        for (int i = 0; i < pizzaSales.length; i++) {
            if (pizzaSales[i] > 0) {
                System.out.println("Pizza " + i + ": " + pizzaSales[i] + " stk solgt");
            }
        }
    }
}