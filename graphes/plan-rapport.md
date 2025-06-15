---
title: SAE S2.02 -- Rapport graphes
subtitle: Équipe NOM_EQUIPE
author: Mathéo Lelong, Matthieu Calesse, Aubin Cambier, Aymeric Jacquey
date: 2025
---

# Version 1

## Choix pour la modélisation

_Ci-dessous, H1, H2, etc. désignent des noms d'hôtes ; V1, V2, etc. désignent des noms de visiteurs. Pour chacun et chacune d'entre elles, vous devrez donner des valeurs pour les colonnes HOBBIES, GENDER, PAIR_GENDER et BIRTH_DATE. Vous pouvez réutiliser les mêmes valeurs plusieurs fois. La présentation des données doit être **lisible** (par ex. tableau, capture d'écran de tableur avec résolution suffisante)._

### Forte affinité

||Hobbies|Gender|Pair_Gender|Birth_Date|
|:-:|:-:|:-:|:-:|:-:|
|H1|Video_Games,Reading,Chess|M|F|2006-02-04|
|V1|Chess,Reading,Sports|F|M|2006-10-17|

H1 et V1 ont une forte affinité car ils ont deux activitées en commun, des dates de naissances de moins d'un an et demi d'écart et leur affinité de genre correspondent.

### Faible affinité

||Hobbies|Gender|Pair_Gender|Birth_Date|
|:-:|:-:|:-:|:-:|:-:|
|H2|Swimming,Cooking|M|M|2006-04-25|
|V2|Dancing,Sport,Culture|F|F|2008-12-19|

H2 et V2 ont une faible affinité car ils n'ont pas d'activité en commun, ils ont plus d'un an et demi d'écart et leur affinité de genre ne correspondent pas.

### Arbitrage entre les critères d'affinité

||Hobbies|Gender|Pair_Gender|Birth_Date|
|:-:|:-:|:-:|:-:|:-:|
|H3|Science,Culture,Cinema|F|F|2005-03-22|
|V3|Cinema,Sport,Science|M|M|2005-05-11|
|H4|Swimming,Reading|M|M|2007-04-25|
|V4|Video Games,Technology,Culture|M|M|2007-12-19|
|H5|Horse riding,Cooking,Dancing|M|F|2008-11-29|
|V5|Dancing,Music|F|M|2006-01-15|

## Exemple complet
_Donnez un exemple de quatre hôtes A, B, C, D et quatre visiteurs W, X, Y, Z. Puis, donnez l'appariement que vous considérez le meilleur entre ces hôtes et visiteurs._

||Hobbies|Gender|Pair_Gender|Birth_Date|
|:-:|:-:|:-:|:-:|:-:|
|A|Video_Games,Reading,Chess|M|F|2006-02-04|
|B|Science,Culture,Cinema|F|F|2005-03-22|
|C|Swimming,Reading|M|M|2007-04-25|
|D|Horse riding,Cooking,Dancing|M|F|2008-11-29|
|W|Dancing,Music|F|M|2006-01-15|
|X|Chess,Reading,Sports|F|M|2006-10-17|
|Y|Cinema,Sport,Science|M|M|2005-05-11|
|Z|Video Games,Technology,Culture|M|M|2007-12-19|

Nous pensons que cet appariement est le meilleur.

A -> X
B -> Y
C -> Z
D -> W

## Score d'affinité

_**Lisez les conseils pour l'écriture de pseudo-code se trouvant sur Moodle**._

_Donner le pseudo-code de la fonction `score_affinité_1(hôte, visiteur)` qui retourne un nombre représentant le degré d'affinité entre un hôte et un visiteur._

genre = +3 
  deux pareil : +3
  1 mais pas l'autre : +1.5
  aucun : +0

hobbies = +2
  1 activité en commun : +1
  2 ou plus : +2
  0 : +0

date = +1
  -1,5 ans d'écart : +1
  +1,5 ans d'écart : +0

```
double score_affinité_1(hôte, visiteur) 
    scoreMax = 6 //Correspond à la valeur maximal qu'un couple hôte visiteur peut obtenir

    score = 0; //Variable qui va contenir le score d'un couple

    // calcul le score en fonction des différentes conditions
    Si valeurAbsolue(hôte.anniversaire - visiteur.anniversaire) < 1.5 ans
        score = score + 1

    Si nombreHobbieCommun(hôte,visiteur) >= 2
        score = score + 2
    Sinon si nombreHobbieCommun(hôte,visiteur) == 1
        score = score + 1

    Si hôte.gender == visiteur.pair_gender
        score = score + 1.5

    Si visiteur.gender == hôte.pair_gender
        score = score + 1.5

    // score final obtenu 
    retourner scoreMax - score
```

## Retour sur l'exemple

_Donnez la matrice d'adjacence du graphe biparti complet entre les hôtes A, B, C, D et les visiteurs W, X, Y, Z que vous avez introduit plus haut. Les poids des arêtes sont donnés par la fonction `score_affinité_1`._

_Calculez l'appariement de poids minimal pour ce graphe. Obtenez-vous l'appariement que vous aviez identifié comme le meilleur ?_

||W|X|Y|Z|
|:-:|:-:|:-:|:-:|:-:|
|A|4|6|2.5|2.5|
|B|2.5|1.5|3|1|
|C|2.5|3.5|3|4|
|D|4|3|1.5|2.5|

On soustrait la plus grand valeur (soit 6) pour que plus le score est faible plus le degrès d'affinité est élevé.

||W|X|Y|Z|
|:-:|:-:|:-:|:-:|:-:|
|A|2|0|3.5|3.5|
|B|3.5|4.5|3|5|
|C|3.5|2.5|3|2|
|D|2|3|4.5|3.5|

En utilisant le programme de calcul d'affectation on obtient: 

A -> X
B -> Y
C -> Z
D -> W

Cela correspond bien l'appariement que l'on avait trouvé.

# Version 2

_Ci-dessous, vous définirez des hôtes ayant des noms A1, A2, B1, B2, etc., et des visiteurs ayant des noms W1, W2, X1, X2, etc. Pour chacun et chacune d'entre iels, vous devrez donner :_

- _la valeur pour la coronne NAME parmi A1, A2, B1, ..., W1, W2, X1, ... ;_
- _des valeurs pour les colonnes HOBBIES, GENDER, PAIR_GENDER, BIRTH_DATE pour tout le monde ;_
- _des valeurs pour les colonnes HOST_HAS_ANIMAL, HOST_FOOD pour les hôtes ;_
- _des valeurs pour les colonnes GUEST_ANIMAL_ALLERGY, GUEST_FOOD_CONSTRAINT pour les visiteurs._

## Exemple avec appariement total

_Donnez un exemple de quatre hôtes A1, B1, C1, D1 et quatre visiteurs W1, X1, Y1, Z1 pour lesquels il existe des incompatibilités entre certains hôtes et certains visiteurs, mais il est possible de trouver un appariement qui respecte les contraintes rédhibitoires._

_Donnez également l'appariement que vous considérez le meilleur pour cet exemple. Expliquez pourquoi._

**Hôtes**

|Name|Hobbies|Gender|Pair_Gender|Birth_Date|Host_Has_Animal|Host_Food|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|A1|Video_Games,Reading,Chess|M|F|2006-02-04|yes|_|
|B1|Science,Culture,Cinema|F|F|2005-03-22|no|_|
|C1|Swimming,Reading|M|M|2007-04-25|no|vegetarian|
|D1|Horse riding,Cooking,Dancing|M|F|2008-11-29|yes|nonuts|

**Visiteurs**

|Name|Hobbies|Gender|Pair_Gender|Birth_Date|Guest_Animal_Allergy|Guest_Food_Constraint|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|W1|Dancing,Music|F|M|2006-01-15|no|nonuts|
|X1|Chess,Reading,Sports|F|M|2006-10-17|yes|_|
|Y1|Cinema,Sport,Science|M|M|2005-05-11|no|_|
|Z1|Video Games,Technology,Culture|M|M|2007-12-19|yes|vegetarian|

Le meilleur appariement serait :

A1 -> Y1
B1 -> X1
C1 -> Z1
D1 -> W1

Car les contraintes rédhibitoires sont respecter et les préférences sont aussi optimisée.

## Exemple sans appariement total

_Donnez un exemple de quatre hôtes A2, B2, C2, D2 et quatre visiteurs W2, X2, Y2, Z2 pour lesquels il n'est pas possible de former quatre paires hôte-visiteur à cause d'incompatibilités._

_Pour cet exemple, quel est le plus grand nombre de paires qu'on peut former ?_

_Donnez l'appariement que vous considérez le meilleur. Expliquez pourquoi._

**Hôtes**

|Name|Hobbies|Gender|Pair_Gender|Birth_Date|Host_Has_Animal|Host_Food|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|A2|Video_Games,Reading,Chess|M|F|2006-02-04|no|_|
|B2|Science,Culture,Cinema|F|F|2005-03-22|yes|_|
|C2|Swimming,Reading|M|M|2007-04-25|yes|vegetarian|
|D2|Horse riding,Cooking,Dancing|M|F|2008-11-29|yes|nonuts|

**Visiteurs**

|Name|Hobbies|Gender|Pair_Gender|Birth_Date|Guest_Animal_Allergy|Guest_Food_Constraint|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|W2|Dancing,Music|F|M|2006-01-15|yes|nonuts|
|X2|Chess,Reading,Sports|F|M|2006-10-17|yes|vegetarian|
|Y2|Cinema,Sport,Science|M|M|2005-05-11|no|_|
|Z2|Video Games,Technology,Culture|M|M|2007-12-19|no|vegetarian|

On ne peux former que 2 pairs.

Le meilleur appariement serait :

B2 -> Y2
C2 -> Z2

Les visiteurs W2 et X2 ne peuvent n'ont pas d'hôtes qui leur convient à cause des contraintes rédhibitoires.

## Score d'affinité

_Donner le pseudo-code de la fonction `score_affinité_2(hôte, visiteur)` qui retourne un nombre représentant le degré d'affinité entre un hôte et un visiteur. Vous pouvez réutiliser la fonction `score_affinité_1` (l'appeler ou copier du code)._

```
double score_affinité_2(hote, visiteur)

    si hote.host_has_animal == visiteur.guest_animal_allergy
        retourner null;

    si visiteur.guest_food_constraint n'appartiennent pas à host.host_food
        retourner null;

    retourner score_affinité(hote,visiteur)

```

## Retour sur l'exemple

_Donnez les matrices d'adjacence pour les deux exemples de la Version 2 (A1,B1,C1,D1/W1,X1,Y1,Z1 et A2,B2,C2,D2/W2,X2,Y2,Z2). Les poids des arêtes sont déterminés par la fonction `score_affinité_2`. Pensez à nommer les lignes et les colonnes._

_Calculez l'appariement de poids minimal pour chacun des graphes. Obtenez-vous l'appariement que vous aviez identifié comme le meilleur ?_

||W1|X1|Y1|Z1|
|:-:|:-:|:-:|:-:|:-:|
|A1|null|null|3.5|null|
|B1|null|4.5|3|null|
|C1|null|null|null|2|
|D1|2|null|null|null|

Le meilleur appariement est :

A1 -> Y1
B1 -> X1
C1 -> Z1
D1 -> W1

||W2|X2|Y2|Z2|
|:-:|:-:|:-:|:-:|:-:|
|A2|null|null|3.5|null|
|B2|null|null|3|null|
|C2|null|null|null|2|
|D2|null|null|null|null|

Le meilleur appariement est :

A2 ou B2 -> Y2
C2 -> Z2

Ces appariements correspondent bien à ce que l'on avait trouvé.

## Robustesse de la modélisation (question difficile)

_Est-ce que votre fonction `score_affinité_2` garantit que les contraintes rédhibitoires seront toujours respectées, quel que soit le jeu de données ? Justifiez votre réponse._

_**Indications** : Cherchez un exemple de **grande taille** pour lequel la fonction `score_affinité_2` pourrait ne pas garantir le respect des contraintes. Dans cet exemple, vous auriez beaucoup d'adolescents compatibles sans affinité, et quelques adolescents incompatibles avec beaucoup d'affinité._

_Il est possible que votre fonction garantisse le respect des contraintes quel que soit l'exemple. Si vous pensez que c'est le cas, donnez des arguments pour convaincre._ 

Notre fonction garantie le respect des contraintes car en renvoyant null comme score d'affinité lorsqu'une contraintes rédhibitoires n'est pas respecter il est impossible qu'un appariement entre 2 personnes incompatibles soie renvoyé.

# Version 3

_Ci-dessous, H1, H2, etc. désignent des noms d'hôtes et V1, V2, etc désignent des noms de visiteurs. Pour chacun et chacune d'entre iels, vous devrez donner des valeurs pour toutes les colonnes pertinentes en fonction de leur rôle, hôte ou visiteur._

## Équilibrage entre affinité / incompatibilité

_Donnez au moins quatre paires hôte-visiteur (H1, V1), (H2, V2), (H3, V3), (H4, V4), ... que vous considérez quasi équivalents pour l'affectation. Certaines de ces paires doivent ne pas respecter les contraintes considérées rédhibitoires dans la Version 2, d'autres doivent les respecter. Ces exemples doivent illustrer l'équilibrage que vous faites entre l'incompatibilité d'une part et l'affinité d'autre part : combien et quel type d'affinité permet de compenser combien et quel type d'incompatibilité. Les exemples seront accompagnés de commentaires expliquant vos choix._

**Hôtes**

|Name|Hobbies|Gender|Pair_Gender|Birth_Date|Host_Has_Animal|Host_Food|history|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|H1|Music,Cinema,Reading|F|M|2006-03-21|Yes|no pork|_|
|H2|Video Games,Chess,Culture|M|F|2007-08-15|No|Vegetarian|_|
|H3|Swimming,Science,Cooking|M|M|2005-11-30|Yes|_|_|
|H4|Art,Cooking,Nature|F|F|2008-04-12|No|Vegan|_|

**Visiteurs**

|Name|Hobbies|Gender|Pair_Gender|Birth_Date|Guest_Animal_Allergy|Guest_Food_Constraint|history|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|V1|Reading,Music,History|M|F|2006-04-01|Yes|No Pork|_|
|V2|Chess,Culture,Cinema|F|M|2007-09-10|No|Vegetarian|_|
|V3|Cooking,Swimming,Tech|M|M|2005-10-22|No|_|_|
|V4|Nature,Drawing,Animals|F|F|2008-02-05|No|Vegan|_|

(H1, V1) 
Ce couple respecte toutes les contraintes et présente une excellente affinité sur les loisirs. Cas idéal.

(H2, V2)
L’allergie est une contrainte importante, mais dans des cas très spécifiques (animal pouvant être isolé + affinités et régime compatibles), elle peut être compensée si toutes les autres conditions sont très favorables.

(H3, V3)
Un bon exemple d’appariement équilibré : pas de contraintes violées, affinité suffisante (2 hobbies communs).

(H4, V4)
Ici, la contrainte alimentaire de l’hôte est exigeante, mais le visiteur étant également vegan, cela devient un point d’affinité et non un obstacle.

## Score d'affinité

_Donner le pseudo-code de la fonction `score_affinité_3(hôte, visiteur)` qui retourne un nombre représentant le degré d'affinité entre un hôte et un visiteur. Vous pouvez réutiliser les fonctions `score_affinité_1` et `score_affinité_2`._

```
double score_affinité_3(hôte, visiteur)

    score = score_affinité_1(hôte, visiteur)

    si visiteur.history = other
        retourner null

    si nombre_contrainte_redhibitoire >= 2
        retourner null

    si score_affinité_2(hôte, visiteur) = null
        score = score + 2

    si score_affinité_1(hôte, visiteur) <= 2
        score = score - 2

    retourner score_affinité_1(hôte, visiteur)
```



## Retour sur l'exemple

_Donnez le résultat de la fonction `score_affinité_3` pour les exemples d'équilibrage (H1, V1), (H2, V2), etc. ci-dessus. Est-ce que vous obtenez des scores proches ?_ 

(H1, V1) -> 0
(H2, V2) -> -0.5
(H3, V3) -> -2
(H4, V4) -> -1

_**Remarque**: Deux scores ne sont pas proches ou éloignés dans l'absolu ; cela dépend de la valeur minimale et la valeur maximale que peut prendre le score. Par exemple, les nombres 10 et 20 sont "proches" à l'échelle de l'intervalle de 0 à 1000, mais ne sont pas "proches" à l'échelle de l'intervalle 0 à 30._


