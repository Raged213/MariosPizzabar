import java.util.ArrayList;

public class Pizza {
    private String name;
    private String ingredients;
    private int price;
    private ArrayList<Pizza> pizzas;

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getPrice() {
return price;
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

    public Pizza(String name, String ingredients, int price) {
this.name = name;
this.ingredients = ingredients;
this.price = price;
    }

    public String toString() {
return name + ingredients + price;
    }

    public void setPizza(ArrayList<Pizza> pizzas) {
this.pizzas = pizzas;
    }

    public void printNicely() {
        System.out.println(name + ": " + ingredients + "..............." + price);
        for (Pizza pizza : this.pizzas) {
            System.out.println(pizza);
        }
        System.out.println();
    }

}
