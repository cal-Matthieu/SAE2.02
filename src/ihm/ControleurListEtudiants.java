package ihm;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import sae.Student;
/**
 * Contrôleur de la page FXML "ListEtudiant".
 * Gère l'affichage des appariements entre étudiants et permet la navigation entre différentes scènes.
 * 
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com">Mathéo D</a>
 * @author <a href="mailto:calmatthieu@yahoo.com">Mathieu C</a>
 * @author <a href="mailto:aymericjacquey@gmail.com">Aymeric C</a>
 * @version 21.0.7
 */
public class ControleurListEtudiants {

    /** Bouton permettant d'accéder au menu principal. */
    @FXML
    Button buttonMenu;

    /** Bouton permettant de revenir à l'écran précédent. */
    @FXML
    Button buttonRetour;

    /** Liste affichant les étudiants sous forme de BorderPane. */
    @FXML
    ListView<BorderPane> etudiants;

    /** Conteneur HBox pour organiser la liste des étudiants. */
    @FXML
    HBox boxListEtudiants;

    /**
     * Initialise le contrôleur en chargeant la liste des étudiants et en configurant les boutons.
     */
    public void initialize() {
        // Parcourt la liste des étudiants pour les ajouter à la vue
        for (Student s : AppIhm.students) {
            addListStudent(s); // Ajoute l'étudiant à la liste visuelle
        }

        // Déclaration de l'ImageView qui servira d'icône pour le menu
        ImageView imageMenu = null;
        try {
            // Charge l'image du menu depuis un fichier
            imageMenu = new ImageView(new Image("file:doc/img/Menu.png"));
            imageMenu.setFitWidth(30); // Définit la largeur de l'image
            imageMenu.setFitHeight(30); // Définit la hauteur de l'image
        } catch (NullPointerException e) {
            e.printStackTrace(); // Affiche une erreur si l'image est introuvable
        }
        buttonMenu.setGraphic(imageMenu); // Ajoute l'image au bouton Menu
        buttonMenu.setText(""); // Supprime le texte du bouton Menu

        // Déclaration de l'ImageView qui servira d'icône pour le bouton Retour
        ImageView imageRetour = null;
        try {
            // Charge l'image de retour depuis un fichier
            imageRetour = new ImageView(new Image("file:doc/img/retour.png"));
            imageRetour.setFitWidth(30); // Définit la largeur de l'image
            imageRetour.setFitHeight(30); // Définit la hauteur de l'image
        } catch (NullPointerException e) {
            e.printStackTrace(); // Affiche une erreur si l'image est introuvable
        }
        buttonRetour.setGraphic(imageRetour); // Ajoute l'image au bouton Retour
        buttonRetour.setText(""); // Supprime le texte du bouton Retour
    }

    /**
     * Ajoute un étudiant à la liste affichée sous forme de BorderPane.
     *
     * @param student L'étudiant à ajouter à la liste.
     */
    public void addListStudent(Student student) {
        // Crée un conteneur pour l'affichage d'un étudiant
        BorderPane bp = new BorderPane();
        
        // Crée un label contenant le nom et prénom de l'étudiant
        Label nom = new Label(student.getNom() + " " + student.getPrenom());

        // Déclaration de l'image associée à l'étudiant
        ImageView image = null;
        try {
            // Charge une image d'icône représentant une personne
            image = new ImageView(new Image("file:doc/img/icone_personne.jpg"));
        } catch (NullPointerException e) {
            e.printStackTrace(); // Affiche une erreur si l'image est introuvable
        }
        image.setFitWidth(50); // Définit la largeur de l'image
        image.setFitHeight(50); // Définit la hauteur de l'image

        bp.setCenter(nom); // Place le label au centre du BorderPane
        bp.setRight(image); // Place l'image à droite du BorderPane

        // Ajoute un événement au clic pour afficher les détails de l'étudiant
        bp.setOnMouseClicked(e -> {
            // Récupère l'indice de l'étudiant sélectionné dans la liste
            int i = etudiants.getSelectionModel().getSelectedIndices().get(0);
            AppIhm.selectedEtudiant = AppIhm.students.get(i); // Définit l'étudiant sélectionné

            // Chargement du fichier FXML pour l'affichage des détails de l'étudiant
            FXMLLoader loader = new FXMLLoader();
            URL fxmlFileUrl = getClass().getResource("fxml/etudiant.fxml");
            if (fxmlFileUrl == null) {
                System.out.println("Impossible de charger le fichier fxml");
                System.exit(-1); // Arrête le programme si le fichier est introuvable
            }
            loader.setLocation(fxmlFileUrl);
            Parent root = null;
            try {
                root = loader.load(); // Charge la nouvelle scène
            } catch (IOException io) {
                io.printStackTrace(); // Affiche une erreur en cas d'échec du chargement
            }

            // Définit la nouvelle scène pour afficher l'étudiant
            AppIhm.sceneEtudiant = new Scene(root);

            // Ajoute la scène actuelle à l'historique pour permettre le retour
            AppIhm.lastScenes.add(AppIhm.sceneListEtudiants);
            AppIhm.stageA.setScene(AppIhm.sceneEtudiant); // Change la scène affichée
        });

        etudiants.getItems().add(bp); // Ajoute l'étudiant à la liste affichée
    }

    /**
     * Action déclenchée lors du clic sur le bouton Menu.
     * Permet de naviguer vers la scène du menu principal.
     *
     * @param event L'événement de clic.
     */
    public void pressedButtonMenu(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneListEtudiants); // Ajoute la scène actuelle à l'historique
        AppIhm.stageA.setScene(AppIhm.sceneMenu); // Change la scène affichée vers le menu
    }

    /**
     * Action déclenchée lors du clic sur le bouton Retour.
     * Permet de revenir à la scène précédente.
     *
     * @param event L'événement de clic.
     */
    public void pressedButtonRetour(ActionEvent event) {
        if (!AppIhm.lastScenes.isEmpty()) { // Vérifie si des scènes précédentes existent
            AppIhm.stageA.setScene(AppIhm.lastScenes.get(AppIhm.lastScenes.size()-1)); // Revient à la dernière scène enregistrée
            AppIhm.lastScenes.remove(AppIhm.lastScenes.size()-1); // Supprime la dernière scène de l'historique
        }
    }

    /**
     * Action déclenchée lors du clic sur le bouton Liste des appariements.
     * Permet de naviguer vers la scène affichant les appariements des étudiants.
     *
     * @param event L'événement de clic.
     */
    public void pressedListeAppariements(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneListEtudiants); // Ajoute la scène actuelle à l'historique
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements); // Affiche la scène des appariements
    }

    /**
     * Action déclenchée lors du clic sur le bouton Critères.
     * Permet de naviguer vers la scène affichant les critères de sélection des étudiants.
     *
     * @param event L'événement de clic.
     */
    public void pressedCriteres(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneListEtudiants); // Ajoute la scène actuelle à l'historique
        AppIhm.stageA.setScene(AppIhm.sceneCriteres); // Affiche la scène des critères
    }
}