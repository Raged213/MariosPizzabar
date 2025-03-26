import java.util.ArrayList;

public class Pizza {
    private int pizzaNummer;
    private String name;
    private String ingredients;
    private int price;
    private boolean isNyhed;
    private int count;

    public Pizza(int pizzaNummer, String name, boolean isNyhed, String ingredients, int price) {
        this.pizzaNummer = pizzaNummer;
        this.name = name;
        this.isNyhed = isNyhed;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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


    public String menuString(boolean isNyhed, String dots) {
        // Apply orange to pizza name (using your exact color code)
        String coloredName = Farver.orangeMain + name + Farver.reset;

        if (isNyhed) {
            // Apply green to "NYHED" text (using your exact color code)
            String nyhedText = Farver.green + "NYHED" + Farver.reset;
            return pizzaNummer + ". " + coloredName + ": " + nyhedText + " " + ingredients + dots + price + ",-";
        } else {
            return pizzaNummer + ". " + coloredName + ": " + ingredients + dots + price + ",-";
        }
    }

    public String toString() {
        return name + ingredients + price;
    }

    public String visSalgsTa1() {
        return getCount() + " " + name;
    }
}
