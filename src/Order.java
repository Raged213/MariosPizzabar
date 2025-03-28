import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int ordreNummer;
    private String navn;
    public ArrayList<Integer> pizzaNumre = new ArrayList<>();
    private LocalTime afhentningsTidspunkt;
    private String bemærkning;


    public Order(){}

    public int getOrdreNummer() {
        return ordreNummer;
    }


    public LocalTime getAfhentningsTidspunkt() {
        return afhentningsTidspunkt;
    }

    public void setOrdreNummer(int ordreNummer) {
        this.ordreNummer = ordreNummer;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setPizzaNummer(int pizzaNummer) {
        this.pizzaNumre.add(pizzaNummer);
    }

    public void setAfhentningsTidspunkt(LocalTime afhentningsTidspunkt) {
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }
    public void setBemærkning(String bemærkning) {
        this.bemærkning = bemærkning;
    }

    public String getDato() {
        DateTimeFormatter dansk = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dagensDato = LocalDate.now();
        return dagensDato.format(dansk);
    }


    public String kundeOrdrer() {
        return toString().replaceAll(";","\t");
    }


    @Override
    public String toString() {
        return "\nOrdrenummer: " + ordreNummer + ";Dato: " + getDato() + ";" +
                "Navn: " + navn + ";" +
                "Pizzanummer: " + pizzaNumre + ";" +
                "Afhentningstidspunkt: " + afhentningsTidspunkt + "\n";
    }
}
