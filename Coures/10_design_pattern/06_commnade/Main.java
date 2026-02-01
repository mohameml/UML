
interface Commande {
    void executer();

    void annuler();
}

// Classe pour ouvrir un document
class CommandeOuvrir implements Commande {
    private Document document;

    public CommandeOuvrir(Document document) {
        this.document = document;
    }

    public void executer() {
        document.ouvrir();
    }

    public void annuler() {
        document.fermer();
    }
}

// Classe pour fermer un document
class CommandeFermer implements Commande {
    private Document document;

    public CommandeFermer(Document document) {
        this.document = document;
    }

    public void executer() {
        document.fermer();
    }

    public void annuler() {
        document.ouvrir();
    }
}

// Classe pour enregistrer un document
class CommandeEnregistrer implements Commande {
    private Document document;

    public CommandeEnregistrer(Document document) {
        this.document = document;
    }

    public void executer() {
        document.enregistrer();
    }

    public void annuler() {
        // Annulation non prise en charge pour l'exemple
    }
}

// Classe Document
class Document {
    private String nom;
    private Commande cm;

    public Document(String nom) {
        this.nom = nom;
    }

    public void ouvrir() {
        System.out.println("Le document '" + nom + "' est ouvert.");
    }

    public void fermer() {
        System.out.println("Le document '" + nom + "' est fermé.");
    }

    public void enregistrer() {
        System.out.println("Le document '" + nom + "' est enregistré.");
    }
}

// Invocateur
class GestionnaireCommandes {
    public void executerCommande(Commande commande) {
        commande.executer();
    }
}

// Exemple d'utilisation
public class Main {
    public static void main(String[] args) {
        // Création d'un document
        Document document = new Document("Document1");

        // Création des commandes
        Commande commandeOuvrir = new CommandeOuvrir(document);
        Commande commandeEnregistrer = new CommandeEnregistrer(document);
        Commande commandeFermer = new CommandeFermer(document);

        // Gestionnaire de commandes
        GestionnaireCommandes gestionnaire = new GestionnaireCommandes();

        // Exécution des commandes
        gestionnaire.executerCommande(commandeOuvrir);
        gestionnaire.executerCommande(commandeEnregistrer);
        gestionnaire.executerCommande(commandeFermer);
    }
}
