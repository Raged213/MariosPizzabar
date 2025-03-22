import java.util.ArrayList;
import java.util.Arrays;

public class Bestilling {
    private String navn;
    private int pizzaNummer;
    private boolean afhentningsTidspunkt;
private ArrayList<Pizza> ordreListe;

    public Bestilling(String navn, int pizzaNummer, boolean afhteningsTidspunkt){
this.navn = navn;
this.pizzaNummer = pizzaNummer;
this.afhentningsTidspunkt = afhentningsTidspunkt;
    }

public String getNavn(){
        return navn;
}
public int getPizzaNummer(){
        return pizzaNummer;
}
public boolean getAfhentingsTidspunkt(){
        return afhentningsTidspunkt;
}
public void setNavn(String navn){
this.navn = navn;
}
public void setPizzaNummer(int pizzaNummer){
        this.pizzaNummer = pizzaNummer;
}
public void setAfhentningsTidspunkt(boolean afhentningsTidspunkt){
        this.afhentningsTidspunkt = afhentningsTidspunkt;
}
}
