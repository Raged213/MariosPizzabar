
public class Pizza {
    private int pizzaNummer;
    private String name;
    private String ingredients;
    private int price;
    private final boolean isNyhed;


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



    public String menuString(boolean isNyhed) {
        // Apply orange to pizza name (using your exact color code)
        String coloredName = Farver.brown + name + Farver.reset;
        String priceText = Farver.brown + price + Farver.reset;
        String nyhedText = isNyhed ? Farver.orangeMain + " NYHED " + Farver.reset : " ";

        String nameAndIngredients = pizzaNummer + ". " + coloredName + ": " + nyhedText + ingredients;

        int totalLength = 118;
        int dotsLength = totalLength - nameAndIngredients.length();

        String dots = dotsLength > 0 ? ".".repeat(dotsLength) : "";

        return nameAndIngredients + dots + priceText + ",-";

    }

    public String toString() {
        return name + ingredients + price;
    }


}
