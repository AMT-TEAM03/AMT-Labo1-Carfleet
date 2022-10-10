# AMT-Labo1-Carfleet

## Développement

Notre projet ayant été fait avec maven, il est donc nécessaire d'installer maven pour faire les tests et utiliser les dépendances.

Lors du clone du repo il faut lancer `mvn clean install` afin d'installer les dépendances. 

Pour les tests, `mvn clean test` peut être utilisé

## Choix de technologie

### Gestion de fichier JSON

Librairie Json de base de java

- Pas très flexible
- Complexité accès aux données dès que les fichier JSON deviennent un peu plus complexes

Librairie GSON

- Simplicité pour sérialiser/désérialiser les Json simples
- Très simple de désérialiser un Json dans un objet (data binding)
- Nécessite une structure de classe spécifique au Json traité pour faire du data binding

Librairie Jackson

- Très simple de désérialiser un Json dans un objet (data binding)
- Nécessite une structure de classe spécifique au Json traité pour faire du data binding
- Nécessite l'utilisation de la librairie Json de base pour accéder à une donnée spécifique

Nous avons donc choisi GSON pour sérialiser/désérialiser les fichier json.