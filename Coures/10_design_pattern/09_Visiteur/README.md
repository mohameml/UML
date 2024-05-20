Prenons un exemple concret où nous avons une application de traitement de documents texte. Supposons que nous ayons différents types de documents, tels que des documents Word, des documents PDF et des documents texte brut. Nous voulons implémenter une fonctionnalité qui compte le nombre de mots dans chaque document, mais chaque type de document nécessite une logique de comptage différente en raison de sa structure interne.

Le design pattern Visiteur peut être utilisé pour implémenter cette fonctionnalité de manière flexible et extensible. Voici comment cela pourrait être mis en œuvre :

```java
// Interface Visiteur
interface Visiteur {
    void visiterDocumentWord(DocumentWord documentWord);
    void visiterDocumentPDF(DocumentPDF documentPDF);
    void visiterDocumentTexte(DocumentTexte documentTexte);
}

// Interface Visitable
interface Visitable {
    void accepter(Visiteur visiteur);
}

// Classe abstraite pour les documents
abstract class Document implements Visitable {
    private String contenu;

    public Document(String contenu) {
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }
}

// Classe pour les documents Word
class DocumentWord extends Document {
    public DocumentWord(String contenu) {
        super(contenu);
    }

    public void accepter(Visiteur visiteur) {
        visiteur.visiterDocumentWord(this);
    }
}

// Classe pour les documents PDF
class DocumentPDF extends Document {
    public DocumentPDF(String contenu) {
        super(contenu);
    }

    public void accepter(Visiteur visiteur) {
        visiteur.visiterDocumentPDF(this);
    }
}

// Classe pour les documents texte brut
class DocumentTexte extends Document {
    public DocumentTexte(String contenu) {
        super(contenu);
    }

    public void accepter(Visiteur visiteur) {
        visiteur.visiterDocumentTexte(this);
    }
}

// Implémentation du visiteur pour compter les mots dans les documents
class CompteurMotsVisiteur implements Visiteur {
    public void visiterDocumentWord(DocumentWord documentWord) {
        String contenu = documentWord.getContenu();
        int nombreMots = contenu.split("\\s+").length;
        System.out.println("Nombre de mots dans le document Word : " + nombreMots);
    }

    public void visiterDocumentPDF(DocumentPDF documentPDF) {
        // Implémentation spécifique pour les documents PDF
        System.out.println("Impossible de compter les mots dans un document PDF.");
    }

    public void visiterDocumentTexte(DocumentTexte documentTexte) {
        String contenu = documentTexte.getContenu();
        int nombreMots = contenu.split("\\s+").length;
        System.out.println("Nombre de mots dans le document texte brut : " + nombreMots);
    }
}

// Exemple d'utilisation
public class Main {
    public static void main(String[] args) {
        // Création des documents
        DocumentWord documentWord = new DocumentWord("Ceci est un document Word.");
        DocumentPDF documentPDF = new DocumentPDF("Ceci est un document PDF.");
        DocumentTexte documentTexte = new DocumentTexte("Ceci est un document texte brut.");

        // Création du visiteur
        CompteurMotsVisiteur compteurMotsVisiteur = new CompteurMotsVisiteur();

        // Utilisation du visiteur pour compter les mots dans chaque document
        documentWord.accepter(compteurMotsVisiteur);
        documentPDF.accepter(compteurMotsVisiteur);
        documentTexte.accepter(compteurMotsVisiteur);
    }
}
```

Dans cet exemple, nous avons utilisé le pattern Visiteur pour compter le nombre de mots dans chaque type de document. La classe `CompteurMotsVisiteur` implémente l'interface `Visiteur` avec des méthodes pour visiter chaque type de document et effectuer le comptage des mots spécifique à chaque type.

L'avantage de cette approche est que si nous voulons ajouter une nouvelle fonctionnalité de traitement de documents, nous pouvons simplement créer un nouveau visiteur sans avoir à modifier les classes de document existantes. Cela rend le code plus modulaire, extensible et facile à maintenir.
