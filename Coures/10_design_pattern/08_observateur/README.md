Prenons un exemple concret d'utilisation du design pattern Observateur dans le cadre d'une application de météo. Imaginons que nous voulons développer une application qui affiche les prévisions météorologiques en temps réel et qui permet aux utilisateurs de s'abonner pour recevoir des notifications lorsque les prévisions changent.

Voici comment cela pourrait être mis en œuvre :

```java
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
        AffichagePrevisions affichage1 = new AffichagePrevisions(stationMeteo);
        AffichagePrevisions affichage2 = new AffichagePrevisions(stationMeteo);

        // Mise à jour des mesures
        stationMeteo.setMesures(25, 65, 1013);
    }
}
```

Dans cet exemple, la classe `StationMeteo` représente le sujet observé. Elle permet aux observateurs de s'enregistrer, de se désenregistrer et de recevoir des notifications lorsque les mesures météorologiques changent.

La classe `AffichagePrevisions` représente un observateur qui affiche les prévisions météorologiques. Elle s'enregistre auprès de la station météo pour recevoir les mises à jour et affiche les prévisions lorsqu'elle est notifiée.

Lorsque les mesures météorologiques sont mises à jour à l'aide de la méthode `setMesures` de la station météo, celle-ci notifie tous les observateurs en appelant leur méthode `actualiser`, ce qui met à jour les affichages des prévisions. Cela permet une communication efficace et décentralisée entre le sujet observé et ses observateurs.
