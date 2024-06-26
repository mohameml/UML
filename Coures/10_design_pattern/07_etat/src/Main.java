// Interface représentant un état
interface EtatDistributeur {
    void insererPiece();

    void ejecterPiece();

    void choisirBoisson();

    void distribuerBoisson();
}

// Implémentation de l'état "En attente"
class EtatEnAttente implements EtatDistributeur {
    public void insererPiece() {
        System.out.println("Pièce insérée. Veuillez choisir une boisson.");
    }

    public void ejecterPiece() {
        System.out.println("Aucune pièce insérée.");
    }

    public void choisirBoisson() {
        System.out.println("Boisson choisie. En cours de distribution.");
    }

    public void distribuerBoisson() {
        System.out.println("Veuillez d'abord choisir une boisson.");
    }
}

// Implémentation de l'état "Distribution en cours"
class EtatDistributionEnCours implements EtatDistributeur {
    public void insererPiece() {
        System.out.println("Impossible d'insérer une pièce pendant la distribution.");
    }

    public void ejecterPiece() {
        System.out.println("Impossible d'éjecter une pièce pendant la distribution.");
    }

    public void choisirBoisson() {
        System.out.println("Boisson déjà en cours de distribution.");
    }

    public void distribuerBoisson() {
        System.out.println("Distribution en cours...");
    }
}

// Classe représentant le distributeur automatique
class DistributeurAutomatique {
    private EtatDistributeur etat;

    public DistributeurAutomatique() {
        etat = new EtatEnAttente();
    }

    public void setEtat(EtatDistributeur etat) {
        this.etat = etat;
    }

    public void insererPiece() {
        etat.insererPiece();
    }

    public void ejecterPiece() {
        etat.ejecterPiece();
    }

    public void choisirBoisson() {
        etat.choisirBoisson();
    }

    public void distribuerBoisson() {
        etat.distribuerBoisson();
    }
}

// Exemple d'utilisation
public class Main {
    public static void main(String[] args) {
        DistributeurAutomatique distributeur = new DistributeurAutomatique();

        distributeur.insererPiece();
        distributeur.choisirBoisson();
        distributeur.distribuerBoisson();

        distributeur.ejecterPiece();
        distributeur.choisirBoisson();
        distributeur.distribuerBoisson();

        distributeur.insererPiece();
        distributeur.choisirBoisson();
        distributeur.distribuerBoisson();
    }
}
