
public class PizzaBarMain {

    public static void main(String[] args) {
        FileHandling.createFile("PizzaListe.txt");
        FileHandling.createFile("OrdreListe.txt");
        MenuController.mainMenu();
    }
}