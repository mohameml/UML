
// Interface représentant une image
interface Image {
    void afficher();
}

// Classe qui sait afficher une image JPEG
class ImageJPEG implements Image {
    public void afficher() {
        System.out.println("Affichage de l'image JPEG.");
    }
}

// Classe représentant une image PNG (à adapter)
class ImagePNG {
    public void afficherPNG() {
        System.out.println("Affichage de l'image PNG.");
    }
}

// Adaptateur pour rendre la classe ImagePNG compatible avec l'interface Image
class AdaptateurImagePNG implements Image {
    private ImagePNG imagePNG;

    public AdaptateurImagePNG(ImagePNG imagePNG) {
        this.imagePNG = imagePNG;
    }

    public void afficher() {
        imagePNG.afficherPNG();
    }
}

// Utilisation de l'adaptateur
public class Main {
    public static void main(String[] args) {
        // Utilisation de l'image JPEG
        Image imageJPEG = new ImageJPEG();
        imageJPEG.afficher(); // Output: Affichage de l'image JPEG.

        // Utilisation de l'image PNG via l'adaptateur
        ImagePNG imagePNG = new ImagePNG();
        Image adaptateurImagePNG = new AdaptateurImagePNG(imagePNG);
        adaptateurImagePNG.afficher(); // Output: Affichage de l'image PNG.
    }
}
