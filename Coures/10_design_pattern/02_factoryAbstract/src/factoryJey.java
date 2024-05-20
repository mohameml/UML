
public abstract class factoryJey {

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