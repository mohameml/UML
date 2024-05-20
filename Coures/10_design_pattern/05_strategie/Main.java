import java.util.List;
import java.util.ArrayList;

// Interface pour les stratégies de tri
interface TriStrategy {
    void trier(List<Integer> liste);
}

// Stratégie de tri croissant
class TriCroissant implements TriStrategy {
    public void trier(List<Integer> liste) {
        liste.sort(Integer::compareTo);
    }
}

// Stratégie de tri décroissant
class TriDecroissant implements TriStrategy {
    public void trier(List<Integer> liste) {
        liste.sort((a, b) -> b.compareTo(a));
    }
}

// Classe principale utilisant le pattern Stratégie
class TriDeListe {
    private TriStrategy triStrategy;

    public void setTriStrategy(TriStrategy triStrategy) {
        this.triStrategy = triStrategy;
    }

    public void trierListe(List<Integer> liste) {
        triStrategy.trier(liste);
    }

    // Autres méthodes de tri de liste
}

public class Main {
    public static void main(String[] args) {
        // Création de quelques entiers pour notre liste
        List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(5);
        listeEntiers.add(2);
        listeEntiers.add(8);
        listeEntiers.add(3);
        listeEntiers.add(1);

        // Création de notre objet pour le tri
        TriDeListe triDeListe = new TriDeListe();

        // Utilisation de la stratégie de tri croissant
        triDeListe.setTriStrategy(new TriCroissant());
        triDeListe.trierListe(listeEntiers);
        System.out.println("Tri croissant : " + listeEntiers);

        // Utilisation de la stratégie de tri décroissant
        triDeListe.setTriStrategy(new TriDecroissant());
        triDeListe.trierListe(listeEntiers);
        System.out.println("Tri décroissant : " + listeEntiers);
    }
}
