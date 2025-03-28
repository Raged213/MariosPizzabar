
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
        // Farver
        String coloredName = Farver.brown + name + Farver.reset;
        String coloredPrice = Farver.brown + price + Farver.reset;
        String coloredNyhed = isNyhed ? Farver.orangeMain + "NYHED " + Farver.reset : "";

        // Byg farvet linje uden prikker
        String coloredContent = pizzaNummer + ". " + coloredName + ": " + coloredNyhed + ingredients;
        String fullColoredLine = coloredContent + coloredPrice + ",-";

        // Fjern farvekoder for at beregne korrekt længde
        String plainContent = stripColors(pizzaNummer + ". " + name + ": " + (isNyhed ? "NYHED " : "") + ingredients);
        String plainPrice = price + ",-";

        int totalLength = 118;
        int dotsLength = totalLength - (plainContent.length() + plainPrice.length());

        String dots = dotsLength > 0 ? ".".repeat(dotsLength) : "";

        return coloredContent + dots + coloredPrice + ",-";


    }

    public static String stripColors(String input) {
        return input
                .replaceAll("\u001B\\[[;\\d]*m", "")
                .replaceAll("\033\\[[;\\d]*m", "");
    }

    public String toString() {
        return name + ingredients + price;
    }


}
