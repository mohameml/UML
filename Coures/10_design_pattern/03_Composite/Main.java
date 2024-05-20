import java.util.ArrayList;
import java.util.List;

// Composant de base
interface Employe {
    void afficherDetails();
}

// Implémentation de l'employé individuel
class Individu implements Employe {
    private String nom;

    public Individu(String nom) {
        this.nom = nom;
    }

    public void afficherDetails() {
        System.out.println("Individu : " + nom);
    }
}

// Implémentation de l'équipe
class Equipe implements Employe {
    private String nom;
    private List<Employe> membres = new ArrayList<>();

    public Equipe(String nom) {
        this.nom = nom;
    }

    public void ajouterMembre(Employe membre) {
        membres.add(membre);
    }

    public void afficherDetails() {
        System.out.println("Equipe : " + nom);
        for (Employe membre : membres) {
            membre.afficherDetails();
        }
    }
}

// Utilisation
public class Main {
    public static void main(String[] args) {
        // Création des individus
        Employe indiv1 = new Individu("Alice");
        Employe indiv2 = new Individu("Bob");
        Employe indiv3 = new Individu("Charlie");

        // Création des équipes
        Employe equipe1 = new Equipe("Equipe 1");
        ((Equipe) equipe1).ajouterMembre(indiv1);
        ((Equipe) equipe1).ajouterMembre(indiv2);

        Employe equipe2 = new Equipe("Equipe 2");
        ((Equipe) equipe2).ajouterMembre(indiv3);

        // Création d'une équipe globale
        Employe equipeGlobale = new Equipe("Equipe Globale");
        ((Equipe) equipeGlobale).ajouterMembre(equipe1);
        ((Equipe) equipeGlobale).ajouterMembre(equipe2);

        // Affichage des détails de l'équipe globale
        equipeGlobale.afficherDetails();
    }
}
