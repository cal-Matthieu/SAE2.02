# Projet Affectation Étudiants - BUT Informatique

---

## Présentation

Ce projet a été réalisé dans le cadre du BUT Informatique.  
Il consiste en une application Java permettant de gérer l’affectation d’étudiants selon leurs critères et préférences. L’objectif est d’automatiser et d’optimiser les appariements entre étudiants et affectations possibles, avec un suivi de l’historique.

---

## Objectifs pédagogiques

- Maîtriser la programmation orientée objet en Java.  
- Concevoir et gérer une application multi-classes avec interactions complexes.  
- Implémenter des contrôleurs pour gérer les différentes fonctionnalités (critères, listes, appariements).  
- Utiliser des concepts avancés comme les exceptions personnalisées pour la gestion d’erreurs.  
- Manipuler des collections et gestion des données (listes, affectations, étudiants).  
- Exploiter les diagrammes UML pour la conception fonctionnelle.

---

## Fonctionnalités principales

- Gestion des étudiants avec leurs informations et critères personnels.  
- Saisie et modification des critères d’affectation.  
- Appariement automatique des étudiants selon les critères définis.  
- Visualisation des listes d’appariements et gestion manuelle possible.  
- Gestion de l'historique des affectations pour suivi.  
- Interface utilisateur avec interaction via menu (console ou GUI selon implémentation).  
- Gestion des erreurs spécifiques via exceptions personnalisées.

---

## Architecture et fichiers clés

- `Student.java` : classe représentant l’étudiant, ses attributs et méthodes associées.  
- `Affectation.java` et `ListAffectation.java` : gestion des affectations individuelles et listes d’affectation.  
- `ControleurEtudiant.java`, `ControleurCriteres.java`, `ControleurListAppariements.java` : contrôleurs principaux orchestrant les fonctionnalités.  
- `AppIhm.java` : interface utilisateur principale.  
- `WrongInformationException.java` : exception personnalisée pour gestion d’erreurs spécifiques.  
- Autres classes de contrôleur pour menus, listes d’étudiants, etc.  

---

## Diagramme UML

Le diagramme UML (fichier UML.pdf fourni) illustre les relations entre les classes, leurs attributs et méthodes, ainsi que les interactions principales.

---

## Utilisation

1. Lancer l’application via la classe principale `AppIhm.java`.  
2. Utiliser le menu de navigation pour ajouter/modifier des étudiants et leurs critères.  
3. Effectuer les appariements automatiques.  
4. Consulter les appariements réalisés et l’historique.  
5. Gérer les erreurs ou informations manquantes grâce au système d’exceptions.

---

## Conclusion

Ce projet représente une bonne mise en pratique des concepts fondamentaux de la programmation orientée objet et de la gestion d’un projet logiciel en équipe.  
Il combine conception UML, développement Java et gestion d’erreurs pour construire une application fonctionnelle et modulable.


