package sae;

public class UseListeAffectation {
    public static void main(String[] args) {
        System.out.println("--On charge le fichier des étudiants--");
        ListAffectation list = new ListAffectation();
        list.chargerCSV("infoetu.csv");

        System.out.println("--On peut affichier les étudiants--");
        System.out.println(list.toStringStudents());
        System.out.println("------\n");

        System.out.println("--On calcul le nombre d'étudiant hote et visiteur--");
        list.calculerNbStudent();
        System.out.println("le nombre de visiteur = "+list.getNbVisiteur() + "\nLe nombre de Hote = "+list.getNbHote());

        System.out.println("--retirer des étudiants si besoins pour avoir le même nombre de hote et visiteurs--");
        list.selectionStudents();
        
        System.out.println("--On créé toutes les affectation entre les étudiants puis on les affiches--");
        list.affectationStudents();
        System.out.println(list.toStringAffectation());
        System.out.println("------\n");

        System.out.println("--créé un fichier csv bi-partie des affectation entre les étudiants visiteurs et hotes--");
        list.exportLisAffectation("affectation.csv");

        System.out.println("--on réalise les meilleurs affectations entre les étudiants--");
        // a finir trouver la meilleur affectation possible avec l'aide du parcour de graphe CalculAffectation<S> du .jar dans graphe        
        System.out.println(list.toStringAffectation());

        list.meilleurAffectation("affectation.csv","affectionM.csv");

        

        // apres chaques modifications, faut refaire les affectations


        // — Afficher les contraintes rédhibitoires non satisfaites.        a faire


        System.out.println(list.toStringStudents());
    }
}
