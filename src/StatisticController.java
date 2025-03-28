import java.io.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class StatisticController {

    public static void mostSoldThisDay(){

        PizzaMenu menu = new PizzaMenu();

        LocalDate today = LocalDate.now();   //henter dagens dato
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //lavet et format til datoen dag - måden - år
        String todayString = today.format(formatter); //laver dagens dato til en string i det format vi har lavet

        findMostSold("OrdreListe.txt", todayString, todayString); //kalder findMostSold methoden for dagens dato

        double totalOmsaetning = omsaetningForDate("OrdreListe.txt", todayString);

        System.out.println("Total omsætning for idag (" + todayString + "): " + totalOmsaetning + " Kr. ");

        saveomsaetning(totalOmsaetning, todayString);
    }

    public static void mostSoldThisWeek(){
        LocalDate today = LocalDate.now(); //dagens dato
        LocalDate startOfWeek = today.minusDays(today.getDayOfWeek().getValue()-1); //finder starten af ugen, mandag.
        LocalDate endOfWeek = startOfWeek.plusDays(6); //finder slutningen på ugen, søndag.

        String startDateFormatted = startOfWeek.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); //formatterer
        String endDateFormatted = endOfWeek.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); //formatterer

        findMostSold("OrdreListe.txt", startDateFormatted, endDateFormatted); //kalder findMostSold methoden for ugens datoer

        double totalOmsaetning = 0;
        for (LocalDate date = startOfWeek; !date.isAfter(endOfWeek); date = date.plusDays(1)) {
            totalOmsaetning += omsaetningForDate("OrdreListe.txt", date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        System.out.println("Total omsætning for denne uge (" + startDateFormatted + " - " + endDateFormatted + "): " + totalOmsaetning + " Kr. ");
    }

    public static void mostSoldThisMonth(){
        LocalDate today = LocalDate.now(); //finder dagens dato
        LocalDate startOfMonth = today.withDayOfMonth(1); //finder første dag i måneden.
        LocalDate endOfMonth = today.withDayOfMonth(today.lengthOfMonth()); //finder sidste dag i måneden

        String startDateStr = startOfMonth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); //formatterer
        String endDateStr = endOfMonth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); //formatterer

        findMostSold("OrdreListe.txt", startDateStr, endDateStr); //kalder findMostSold for alle datoer i denne måned

        double totalOmsaetning = 0;
        for (LocalDate date = startOfMonth; !date.isAfter(endOfMonth); date = date.plusDays(1)) {
            totalOmsaetning += omsaetningForDate("OrdreListe.txt", date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        System.out.println("Total omsætning for denne måned (" + startDateStr + " - " + endDateStr + "): " + totalOmsaetning + " Kr. ");
    }

    public static void mostSoldThisYear(){
        LocalDate today = LocalDate.now(); //dagens dato
        LocalDate startOfYear = today.withDayOfYear(1); //årets første dag
        LocalDate endOfYear = today.withDayOfYear(today.lengthOfYear()); //årets sidste dag

        String startDateStr = startOfYear.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); //formatterer
        String endDateStr = endOfYear.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); //formatterer

        findMostSold("OrdreListe.txt", startDateStr, endDateStr); //kalder findMostSold på alle årets datoer

        double totalOmsaetning = 0;
        for (LocalDate date = startOfYear; !date.isAfter(endOfYear); date = date.plusDays(1)) {
            totalOmsaetning += omsaetningForDate("OrdreListe.txt", date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        System.out.println("Total omsætning for dette år (" +  startDateStr + " - " + endDateStr + "): " + totalOmsaetning + " Kr. ");
    }

    private static void findMostSold(String filePath, String startDate, String endDate) {
        int[] pizzaSales = new int[25]; //laver en array der kan holde 25 forskellige pizzaer (vi har 14)

        try { //Prøver at åbne filen OrdreListe
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            boolean isOrderRelevant = false; //vi bruger en boolean til at finde ud af om en ordre er inde for den ønskede dato periode.

            while (scanner.hasNextLine()) { //læser filen linje for linje (line for line)
                String line = scanner.nextLine().trim(); //fjerner mellemrum i starten og slutningen af linjerne

                if (line.contains("Dato:")) { //tjekker om linjen(ordren) indeholder en dato
                    String orderDateStr = line.substring(line.indexOf("Dato:") + 6, line.indexOf("Dato:") + 16).trim(); //tager datoen fra linjen
                    LocalDate orderDate = LocalDate.parse(orderDateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy")); //konverterer datoen fra tekst
                    LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")); //til at være et objekt
                    LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")); //som man kan bruge til at sammenligne
                    isOrderRelevant = !orderDate.isBefore(start) && !orderDate.isAfter(end); //sætter isOrderRelevant til at være true hvis den er inden for den ønskede dato periode
                }
                    if (isOrderRelevant && line.startsWith("Navn: ")) { //tjekker om linjen har en ordre og relevant dato
                        int startIndex = line.indexOf("["); //finder hvor pizzanumrene starter
                        int endIndex = line.indexOf("]"); //finder hvor pizzanumrene stopper

                        if (startIndex != -1 && endIndex != -1) { //tager pizzanumrene fra en ordre
                            String pizzaNumbers = line.substring(startIndex + 1, endIndex);
                            String[] numbers = pizzaNumbers.split(", "); //og deler dem op i arrays

                            for (String num : numbers) { //loop igennem hvert pizzanummer i ordren
                                int pizzaNum = Integer.parseInt(num.trim()); //lavet nummeret fra string til en int
                                if (pizzaNum > 0 && pizzaNum < pizzaSales.length) { //tjekker at pizzaen er mellem nummer 1-24 (max er jo sat til 25)
                                    pizzaSales[pizzaNum]++; //Øger [i] altså tælleren for den bestilte pizza(er)
                                }
                            }
                        }
                        isOrderRelevant = false; //nulstiller isOrderRelevant så den næste ordrer bliver tjekket fra start
                    }
                }
                scanner.close(); //lukker scanner
            } catch (FileNotFoundException e){ //hvis filen ikke kan findes
                System.out.println("Kunne ikke finde fil"); //bliver denne besked printet
            }
            printMostSold(pizzaSales, startDate + " - " + endDate); //sender pizzaSales (som er vores array) til printMostSold hvor den printer de mest solgte pizzaer
        } //start- og endDate er for at vise den valgte periode

    private static void printMostSold(int[] pizzaSales, String dateInfo){
        System.out.println("\nSalgsstatestik for: " + dateInfo); //udskriver en overskrift og dateInfo for hvilken tidsperiode det er

        boolean foundSales = false; //tjekker om der overhovedet er solgt noget i perioden
        int maxSold = 0; //højeste antal solgte af en pizza
        int mostSold = -1; //pizzanummeret for den mest solgte pizza

        for (int i = 0; i < pizzaSales.length; i++) { //loop igennem alle vores pizzanumre fra vores array (som er fra 0-24)
            if (pizzaSales[i] > maxSold) { //hvis [i] er blevet solgt mere end den nuværende maxSold så bliver den opdateret så den er den nye maxSold
                maxSold = pizzaSales[i]; //antallet af den mest solgte pizza
                mostSold = i; //pizzanummeret på den mest solgte pizza
            }
            if (pizzaSales[i] > 0) { //hvis en pizza bliver solgt mere end 0 gange altså mindst 1 gang
                foundSales = true; //bliver foundSales sat til true
            }
        }
        if (!foundSales) { //hvis foundSales stadig er false
            System.out.println("ingen salg fundet for denne periode"); //bliver denne besked printet
        } else { //ellers hvis foundSales er true
            System.out.println("den mest solgte pizza i perioden er nr. " + mostSold + " med " + maxSold + " salg"); //bliver denne besked printet samt pizzanummeret og salgsantal
            printSales(pizzaSales); //udskriver alle pizza salg
        }
    }

    private static void printSales(int[] pizzaSales) {
        System.out.println("Salgstal: "); //overskrift printes
        for (int i = 0; i < pizzaSales.length; i++) { //loop igennem alle vores pizzaer (igen vores array er sat til størrelse 25 så 0-24
            if (pizzaSales[i] > 0) { //tjekker om pizzaen er blevet solgt mindst 1 gang så kun de solgte pizzaer bliver printet
                System.out.println("Pizza " + i + ": " + pizzaSales[i] + " stk solgt"); //Udskriver antallet af solgte pizzaer for den tilhørende pizza
            }
        }
    }

    public static double omsaetningForDate(String filename, String targetDate) {
        PizzaMenu menu = new PizzaMenu();
        double totalOmsaetning = 0;

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //if (!line.contains("Dato:")) continue; // Spring linjer over uden dato

                String[] parts = line.split(";"); // Split ved tabulator
                if (parts.length > 5) continue; // Sikrer korrekt format

                String datePart = parts[1].replace("Dato: ", "").trim();
                String pizzaNumreString = parts[3].replace("Pizzanummer: ", "").trim();

                if (datePart.equals(targetDate)) {
                    pizzaNumreString = pizzaNumreString.replace("[", "").replace("]", ""); // Fjern klammer
                    String[] pizzaNumre = pizzaNumreString.split(",");

                    for (String num : pizzaNumre) {

                        int pizzaNummer = Integer.parseInt(num.trim()); // Konverter til int
                        int price = menu.pizzaPrice(pizzaNummer);
                        totalOmsaetning += price;
                        //System.out.println("Tilføjer pizza nr. " + pizzaNummer + " pris: " + price + " kr.");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen " + filename + " blev ikke fundet.");
        } catch (NumberFormatException e) {
            System.out.println("Fejl i format af pizzanummer.");
        }
        return totalOmsaetning;
    }



    public static void saveomsaetning(double omsaetning, String date){
        try (PrintWriter writer = new PrintWriter(new FileWriter("Omsætning.txt", true))) {
            writer.println(date + ";" + omsaetning);
            System.out.println("Dagens omsætning gemt i Omsætning.txt");
        } catch (IOException e) {
            System.out.println("Fejl ved lagring af omsætning: " + e.getMessage());
        }
    }
}