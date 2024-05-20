Imaginons un système de gestion de documents où vous pouvez effectuer différentes opérations sur un document, telles que l'ouverture, la fermeture, l'enregistrement, etc. Le design pattern Commande peut être utilisé pour encapsuler chaque opération dans un objet distinct, permettant ainsi de les exécuter de manière flexible et de les annuler si nécessaire.

Voici un exemple concret :

```java
// Interface Commande
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
```

Dans cet exemple, nous avons les classes `CommandeOuvrir`, `CommandeEnregistrer` et `CommandeFermer`, chacune implémentant l'interface `Commande` avec leurs propres méthodes `executer` et `annuler`. La classe `Document` représente le document sur lequel nous effectuons des opérations. La classe `GestionnaireCommandes` est l'invocateur qui exécute les commandes.

Nous créons un document, puis des instances des différentes commandes pour effectuer des opérations sur ce document. Le gestionnaire de commandes exécute ensuite ces commandes. Cela permet une séparation claire des responsabilités et une flexibilité dans l'exécution des opérations sur les documents.
