package sae;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/**
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Classe représentant une liste d'affectations entre étudiants.
 * Elle gère les étudiants, les affectations et fournit des méthodes pour les manipuler.
 * 
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com">Mathéo D</a>
 * @author <a href="mailto:calmatthieu@yahoo.com">Mathieu C</a>
 * @author <a href="mailto:aymericjacquey@gmail.com">Aymeric C</a>
 * @version 21.0.7
 */
public class ListAffectation implements Serializable, Iterable<Affectation> {

    /** Liste des étudiants inscrits. */
    private ArrayList<Student> students;

    /** Liste des affectations entre étudiants. */
    private ArrayList<Affectation> affectations;

    /** Nombre total de visiteurs. */
    private int nbVisiteur = 0;

    /** Nombre total d'hôtes. */
    private int nbHote = 0;

    /** Pays des visiteurs. */
    private final static String PAYSVISITEUR = "France";

    /** Pays des hôtes. */
    private final static String PAYSHOTE = "Italie";

    /**
     * Constructeur principal qui initialise les listes d'étudiants et d'affectations.
     */
    public ListAffectation() {
        this.students = new ArrayList<>();
        this.affectations = new ArrayList<>();
    }

    /**
     * Retourne la liste des étudiants.
     *
     * @return Liste des étudiants.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Retourne la liste des affectations.
     *
     * @return Liste des affectations.
     */
    public ArrayList<Affectation> getAffectations() {
        return affectations;
    }

    /**
     * Retourne le nombre d'hôtes.
     *
     * @return Nombre d'hôtes.
     */
    public int getNbHote() {
        return nbHote;
    }

    /**
     * Retourne le nombre de visiteurs.
     *
     * @return Nombre de visiteurs.
     */
    public int getNbVisiteur() {
        return nbVisiteur;
    }

    /**
     * Ajoute un étudiant à la liste des étudiants.
     *
     * @param student Étudiant à ajouter.
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Ajoute une affectation à la liste des affectations.
     *
     * @param affectation Affectation à ajouter.
     */
    public void addAffectations(Affectation affectation) {
        this.affectations.add(affectation);
    }

    /**
     * Effectue l'affectation automatique des étudiants visiteurs et hôtes.
     */
    public void affectationStudents() {
        for (Student visiteur : students) {
            for (Student hote : students) {
                if (visiteur.getPays().equals(PAYSVISITEUR) && hote.getPays().equals(PAYSHOTE)) {
                    Affectation aff = new Affectation(visiteur, hote);
                    this.affectations.add(aff);
                }
            }
        }
    }

    /**
     * Génère le chemin du fichier CSV.
     *
     * @param fichiercsv Nom du fichier CSV.
     * @return Chemin du fichier CSV.
     */
    public StringBuilder chemin(String fichiercsv) {
        return new StringBuilder(System.getProperty("user.dir"))
                .append(File.separator).append("doc").append(File.separator).append(fichiercsv);
    }

    /**
     * Charge les étudiants depuis un fichier CSV.
     *
     * @param fichiercsv Nom du fichier CSV contenant les étudiants.
     */
    public void chargerCSV(String fichiercsv) {
        File csvFile = new File(chemin(fichiercsv).toString());

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] student = ligne.split(";");
                if (verifierValiditeCritere(student)) {
                    students.add(new Student(student[0], student[1], student[2], student[3], student[4], 
                                             student[5], student[6], student[7], student[8], 
                                             student[9], student[10], student[11]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Vérifie la validité des critères d'un étudiant.
     *
     * @param st Tableau contenant les informations de l'étudiant.
     * @return `true` si l'étudiant est valide, sinon `false`.
     */
    private boolean verifierValiditeCritere(String[] st) {
        if (st.length != 12) {
            System.out.println("Il manque des valeurs pour " + st[1]);
            return false;
        }
        for (int i = 4; i < 7; i++) {
            if (!(st[i].equals("true") || st[i].equals("false"))) {
                System.out.println("Erreur valeur booléenne pour " + st[1]);
                return false;
            }
        }
        return true;
    }

    /**
     * Exporte la liste des affectations vers un fichier CSV.
     *
     * @param fichiercsv Nom du fichier CSV de destination.
     */
    public void exportLisAffectation(String fichiercsv) {
        StringBuilder sb = chemin(fichiercsv);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sb.toString()))) {
            for (Affectation aff : affectations) {
                bw.write(aff.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Rééquilibre le nombre d'étudiants entre visiteurs et hôtes.
     */
    public void selectionStudents() {
        int quantite = Math.abs(nbVisiteur - nbHote);
        String paysTrop = nbVisiteur > nbHote ? PAYSVISITEUR : PAYSHOTE;

        Random rand = new Random();
        while (quantite > 0 && !students.isEmpty()) {
            int index = rand.nextInt(students.size());
            if (students.get(index).getPays().equals(paysTrop)) {
                students.remove(index);
                quantite--;
            }
        }
    }

    /**
     * Calcule le nombre total d'étudiants visiteurs et hôtes.
     */
    public void calculerNbStudent() {
        nbVisiteur = 0;
        nbHote = 0;
        for (Student stu : students) {
            if (stu.getPays().equals(PAYSVISITEUR)) {
                nbVisiteur++;
            } else if (stu.getPays().equals(PAYSHOTE)) {
                nbHote++;
            }
        }
    }

    /**
     * Retourne une représentation textuelle des étudiants.
     *
     * @return Chaîne de caractères représentant les étudiants.
     */
    public String toStringStudents() {
        StringBuilder txt = new StringBuilder();
        for (Student student : students) {
            txt.append(student.toString()).append("\n");
        }
        return txt.toString();
    }

    /**
     * Retourne une représentation textuelle des affectations.
     *
     * @return Chaîne de caractères représentant les affectations.
     */
    public String toStringAffectation() {
        StringBuilder txt = new StringBuilder();
        for (Affectation affectation : affectations) {
            txt.append(affectation.toString()).append("\n");
        }
        return txt.toString();
    }

    /**
     * Renvoie un itérateur sur les affectations.
     *
     * @return Itérateur permettant de parcourir les affectations.
     */
    @Override
    public Iterator<Affectation> iterator() {
        return affectations.iterator();
    }
/**
     * Génère la meilleure affectation possible en traitant un fichier CSV.
     *
     * @param fichiercsvEntré Nom du fichier CSV d'entrée contenant les relations entre visiteurs et hôtes.
     * @param fichiercsvSortie Nom du fichier CSV de sortie contenant la meilleure affectation calculée.
     */
    public void meilleurAffectation(String fichiercsvEntré, String fichiercsvSortie) {
        // Création du chemin pour le fichier de sortie
        StringBuilder sbS = chemin(fichiercsvSortie);
        File csvSortie = new File(sbS.toString());

        // Création du chemin pour le fichier d'entrée
        StringBuilder sbE = chemin(fichiercsvEntré); // Correction : fichier d'entrée, pas de sortie
        File csvEntre = new File(sbE.toString());

        // Initialisation des structures de données pour le traitement
        ArrayList<String> hote = new ArrayList<>(); // Liste des hôtes
        ArrayList<String> visiteur = new ArrayList<>(); // Liste des visiteurs
        double[][] relationVH = new double[nbHote][nbHote]; // Matrice contenant les affinités

        int numeroLigne = 0; // Indice pour parcourir les lignes du fichier

        try (BufferedReader br = new BufferedReader(new FileReader(csvEntre.toString()))) {
            // Lecture de la première ligne pour récupérer les hôtes
            for (String elem : br.readLine().split(";")) {
                hote.add(elem);
            }

            // Lecture des lignes restantes pour récupérer les visiteurs et les affinités
            while (br.readLine() != null) {
                String[] ligne = br.readLine().split(";");
                visiteur.add(ligne[0]); // Premier élément = visiteur

                // Remplissage de la matrice des relations entre visiteurs et hôtes
                for (int i = 1; i < ligne.length; i++) {
                    relationVH[numeroLigne][i] = Double.parseDouble(ligne[i]);
                }
                numeroLigne++; // Incrémentation de l'indice de ligne
            }

            // Application de l'algorithme d'optimisation sur la matrice relationVH
            relationVH = algoH(relationVH);

        } catch (Exception e) {
            System.out.println(e); // Affichage des erreurs potentielles
        }
    }

    /**
     * Algorithme d'optimisation pour améliorer l'affectation des étudiants.
     *
     * @param tabl Matrice contenant les relations entre visiteurs et hôtes.
     * @return Matrice optimisée après réduction.
     */
    public double[][] algoH(double[][] tabl) {
        while (!isFinish(tabl)) { // Vérifie si la matrice peut encore être optimisée
            int taille = tabl.length; // Taille de la matrice

            // Réduction des lignes
            for (int i = 0; i < taille; i++) {
                double minil = Double.MAX_VALUE; // Initialisation avec une valeur maximale

                // Recherche de la plus petite valeur dans la ligne
                for (int j = 0; j < taille; j++) {
                    if (tabl[i][j] < minil) {
                        minil = tabl[i][j];
                    }
                }

                // Soustraction du minimum trouvé à tous les éléments de la ligne
                if (minil > 0.0) {
                    for (int k = 0; k < taille; k++) {
                        tabl[i][k] -= minil;
                    }
                }
            }

            // Réduction des colonnes
            for (int j = 0; j < taille; j++) {
                double minic = Double.MAX_VALUE; // Initialisation avec une valeur maximale

                // Recherche du minimum dans la colonne
                for (int i = 0; i < taille; i++) {
                    if (tabl[i][j] < minic) {
                        minic = tabl[i][j];
                    }
                }

                // Soustraction du minimum trouvé à tous les éléments de la colonne
                if (minic > 0.0) {
                    for (int k = 0; k < taille; k++) {
                        tabl[k][j] -= minic;
                    }
                }
            }
        }
        return tabl; // Retourne la matrice optimisée
    }

    /**
     * Vérifie si l'optimisation est terminée.
     * 
     * @param tabl tableau de deux dimension contenant les relations entre visiteurs et hôtes.
     * @return `true` si toutes les lignes contiennent un 0.0, sinon `false`.
     */
    public boolean isFinish(double[][] tabl) {
        boolean zerotrouve;

        // Parcours des lignes de la matrice
        for (int ligne = 0; ligne < tabl.length; ligne++) {
            zerotrouve = false; // Initialisation du drapeau

            // Recherche d'un zéro dans chaque ligne
            for (int colonne = 0; colonne < tabl[ligne].length; colonne++) {
                if (tabl[ligne][colonne] == 0.0) {
                    zerotrouve = true; // Indique qu'un zéro a été trouvé
                    break;
                }
            }

            // Si une ligne ne contient pas de 0.0, l'optimisation n'est pas terminée
            if (!zerotrouve) {
                return false;
            }
        }

        return true; // Retourne `true` si toutes les lignes contiennent au moins un 0.0
    }
}