import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int ordreNummer;
    private String navn;
    public ArrayList<Integer> pizzaNumre = new ArrayList<>();
    private LocalTime afhentningsTidspunkt;
    private LocalDate dag;
    private ArrayList<Order> ordreListe;

    public Order(String navn, int pizzaNummer, LocalTime afhteningsTidspunkt, int ordreNummer) {
        this.ordreNummer = ordreNummer;
        this.navn = navn;
        this.pizzaNumre.add(pizzaNummer);
        this.afhentningsTidspunkt = afhentningsTidspunkt;
        this.dag = LocalDate.now();
    }

    public Order(){}

    public int getOrdreNummer() {
        return ordreNummer;
    }

    public String getNavn() {
        return navn;
    }
    /*
    public int getPizzaNumre() {
        return String.valueOf(pizzaNumre.get(pizzaNumre));
    }
    */
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

    public String getDato() {
        DateTimeFormatter dansk = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dagensDato = LocalDate.now();
        return dagensDato.format(dansk);
    }


    @Override
    public String toString() {
        return "\nOrdrenummer: " + ordreNummer + "\tDato: " + getDato() + "\n" +
                "Navn: " + navn + "\t" +
                "Pizzanummer: " + pizzaNumre + "\t" +
                "Afhentningstidspunkt: " + afhentningsTidspunkt + "\n";
    }
}
