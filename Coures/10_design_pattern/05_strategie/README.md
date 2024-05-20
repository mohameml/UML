Bien sûr, voici un exemple plus simple où nous supposons que nous travaillons avec une liste d'entiers à trier :

```java
import java.util.List;

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
public class TriDeListe {
    private TriStrategy triStrategy;

    public void setTriStrategy(TriStrategy triStrategy) {
        this.triStrategy = triStrategy;
    }

    public void trierListe(List<Integer> liste) {
        triStrategy.trier(liste);
    }

    // Autres méthodes de tri de liste
}
```

Dans cet exemple simplifié, nous avons une interface `TriStrategy` avec une méthode `trier`, ainsi que deux classes concrètes `TriCroissant` et `TriDecroissant` implémentant cette interface avec leur propre façon de trier la liste d'entiers.

La classe `TriDeListe` utilise le pattern Stratégie en ayant un attribut `triStrategy` pouvant être défini avec l'une des deux stratégies de tri. La méthode `trierListe` utilise ensuite cette stratégie pour trier la liste d'entiers.

Cette approche offre la flexibilité de changer la stratégie de tri à la volée sans modifier le code de la classe principale.
