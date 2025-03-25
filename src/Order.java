import java.util.ArrayList;

public class Order {
    private int ordreNummer;
    private String navn;
    private ArrayList<Integer> pizzaNumre = new ArrayList<>();
    private String afhentningsTidspunkt;
    private ArrayList<Order> ordreListe;

    public Order(String navn, int pizzaNummer, String afhteningsTidspunkt, int ordreNummer) {
        this.ordreNummer = ordreNummer;
        this.navn = navn;
        this.pizzaNumre.add(pizzaNummer);
        this.afhentningsTidspunkt = afhentningsTidspunkt;
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
    public String getAfhentningsTidspunkt() {
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

    public void setAfhentningsTidspunkt(String afhentningsTidspunkt) {
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }

    @Override
    public String toString() {
        return "\nOrdrenummer: " + ordreNummer + "\n" +
                "Navn: " + navn + "\t" +
                "Pizzanummer: " + pizzaNumre + "\t" +
                "Afhentningstidspunkt: " + afhentningsTidspunkt + "\n";
    }
}
