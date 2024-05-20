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
