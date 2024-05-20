import java.util.ArrayList;
import java.util.List;

// Interface pour les observateurs
interface Observateur {
    void actualiser(float temperature, float humidite, float pression);
}

// Interface pour le sujet observé
interface Sujet {
    void enregistrerObservateur(Observateur observateur);

    void supprimerObservateur(Observateur observateur);

    void notifierObservateurs();
}

// Classe représentant le sujet observé (la station météo)
class StationMeteo implements Sujet {
    private List<Observateur> observateurs;
    private float temperature;
    private float humidite;
    private float pression;

    public StationMeteo() {
        observateurs = new ArrayList<>();
    }

    public void enregistrerObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }

    public void supprimerObservateur(Observateur observateur) {
        observateurs.remove(observateur);
    }

    public void notifierObservateurs() {
        for (Observateur observateur : observateurs) {
            observateur.actualiser(temperature, humidite, pression);
        }
    }

    public void setMesures(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        notifierObservateurs();
    }
}

// Classe représentant un affichage (observateur) des prévisions météorologiques
class AffichagePrevisions implements Observateur {
    private float temperature;
    private float humidite;
    private float pression;
    private Sujet sujet;

    public AffichagePrevisions(Sujet sujet) {
        this.sujet = sujet;
        sujet.enregistrerObservateur(this);
    }

    public void actualiser(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        afficher();
    }

    public void afficher() {
        System.out.println("Prévisions météorologiques : Température = " + temperature +
                "°C, Humidité = " + humidite + "%, Pression = " + pression + "hPa");
    }
}

// Exemple d'utilisation
public class Main {
    public static void main(String[] args) {
        // Création de la station météo
        StationMeteo stationMeteo = new StationMeteo();

        // Création des affichages de prévisions
        AffichagePrevisions affichage = new AffichagePrevisions(stationMeteo);
        affichage.afficher();

        // Mise à jour des mesures
        stationMeteo.setMesures(25, 65, 1013);
    }
}
