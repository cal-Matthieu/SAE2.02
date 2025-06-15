package sae;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * class representant l'historique des affectation
 *  Elle permet d'enregistrer et de récupérer des affectations d'une année spécifique.
 * 
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com">Mathéo D</a>
 * @author <a href="mailto:calmatthieu@yahoo.com">Mathieu C</a>
 * @author <a href="mailto:aymericjacquey@gmail.com">Aymeric C</a>
 * @version 21.0.7
 */
public class HistoriqueAffectation {

    /**
     * Enregistre l'historique des affectations dans un fichier.
     * 
     * @param year L'année de l'affectation à enregistrer.
     * @param affectations Liste des affectations à sauvegarder.
     */
    public static void makeHistorique(String year, ListAffectation affectations) {
        // Création du chemin d'accès pour stocker l'historique
        StringBuilder chemin = new StringBuilder();
        chemin.append(System.getProperty("user.dir")) // Obtient le répertoire de travail actuel
              .append(File.separator) // Ajoute le séparateur de fichier
              .append("doc") // Ajoute le dossier "doc"
              .append(File.separator) // Ajoute un autre séparateur
              .append(year); // Ajoute l'année pour organiser les fichiers

        try {
            // Création d'un flux de sortie pour écrire l'objet affectations
            FileOutputStream fos = new FileOutputStream(chemin.toString());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(affectations); // Écrit l'objet affectations dans le fichier
            oos.close(); // Ferme le flux pour éviter les fuites de mémoire
        } catch (final java.io.IOException e) {
            e.printStackTrace(); // Affiche les erreurs liées à l'écriture du fichier
        }
    }

    /**
     * Récupère l'historique des affectations depuis un fichier.
     * 
     * @param year L'année dont on veut récupérer les affectations.
     * @return La liste des affectations récupérée depuis le fichier.
     */
    public static ListAffectation getHistorique(String year) {
        // Déclaration de l'objet qui contiendra les affectations récupérées
        ListAffectation affectations = null;
        
        // Création du chemin d'accès pour récupérer le fichier de l'année spécifiée
        StringBuilder chemin = new StringBuilder();
        chemin.append(System.getProperty("user.dir")) // Obtient le répertoire de travail actuel
              .append(File.separator) // Ajoute le séparateur de fichier
              .append("doc") // Indique le dossier "doc" où sont stockés les fichiers
              .append(File.separator) // Ajoute un autre séparateur
              .append(year); // Ajoute l'année pour cibler le bon fichier

        try {
            // Création d'un flux de lecture pour récupérer l'objet affectations
            FileInputStream fis = new FileInputStream(chemin.toString());
            ObjectInputStream ois = new ObjectInputStream(fis);
            affectations = (ListAffectation) ois.readObject(); // Désérialise l'objet affectations
            ois.close(); // Ferme le flux pour éviter les fuites de mémoire
        } catch (final java.io.IOException e) {
            e.printStackTrace(); // Gère les erreurs liées à la lecture du fichier
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException"); // Gestion d'erreur si la classe n'est pas trouvée
        }
        
        return affectations; // Retourne la liste des affectations récupérée
    }
}