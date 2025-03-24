import java.util.ArrayList;

public class Pizza {
    private int pizzaNummer;
    private String name;
    private String ingredients;
    private int price;
    private boolean isNyhed;

    public Pizza(String name, String ingredients, int price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getPrice() {
return price;
    }

    public boolean getIsNyhed() {
        return isNyhed;
    }

    public void setPizzaNummer(int pizzaNummer) {
        this.pizzaNummer = pizzaNummer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(int price) {
this.price = price;
    }

    public void setIsNyhed(boolean isNyhed) {
        this.isNyhed = isNyhed;
    }


    public String toString() {
return name + ingredients + price;
    }
}
