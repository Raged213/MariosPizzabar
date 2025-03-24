import java.util.ArrayList;

public class Order {
    private int ordreNummer;
    private String navn;
    private int pizzaNummer;
    private String afhentningsTidspunkt;
    private ArrayList<Order> ordreListe;

    public Order(String navn, int pizzaNummer, boolean afhteningsTidspunkt, int ordreNummer) {
        this.ordreNummer = ordreNummer;
        this.navn = navn;
        this.pizzaNummer = pizzaNummer;
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }

    public Order(){}

    public int getOrdreNummer() {
        return ordreNummer;
    }

    public String getNavn() {
        return navn;
    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

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
        this.pizzaNummer = pizzaNummer;
    }

    public void setAfhentningsTidspunkt(String afhentningsTidspunkt) {
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }
}
