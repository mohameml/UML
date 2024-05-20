import java.util.Scanner;

abstract class factoryJey {

    static String[] choixPoss = { "Car", "Vehicle", "Velo" };

    public static factoryJey getMoteurJeu(String choix) {

        if (choix.equals(choixPoss[0])) {
            return new Car();
        } else if (choix.equals(choixPoss[1])) {
            return new Vehicle();
        } else {
            return new Velo();
        }

    }
}

class Car extends factoryJey {

    public Car() {
        System.out.println("===  Car  ====");
    }
}

class Vehicle extends factoryJey {

    public Vehicle() {
        System.out.println("==== Vehicle =====");
    }
}

class Velo extends factoryJey {

    public Velo() {
        System.out.println("==== Velo =========");
    }
}

public class App {
    public static boolean estDansTableau(String[] tableau, String chaine) {
        for (String element : tableau) {
            if (element.equals(chaine)) {
                return true; // La chaîne est présente dans le tableau
            }
        }
        return false; // La chaîne n'est pas présente dans le tableau
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Le jeu commance  , choisir votre moteur : ");
        System.out.println("le choix possible sont : Car , Vehicle , Velo");

        String[] choixPoss = { "Car", "Vehicle", "Velo" };
        String choix;
        while (true) {

            choix = scanner.nextLine();
            if (estDansTableau(choixPoss, choix)) {
                break;
            } else {
                System.out.println("choix invalide");
            }

        }

        factoryJey jeu = factoryJey.getMoteurJeu(choix);

        scanner.close();
    }
}
