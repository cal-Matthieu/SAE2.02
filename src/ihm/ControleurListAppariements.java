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
import sae.Affectation;
/**
 * Contrôleur de la page FXML "ListAppariements".
 * Gère l'affichage des appariements entre étudiants et permet la navigation entre différentes scènes.
 * 
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com">Mathéo D</a>
 * @author <a href="mailto:calmatthieu@yahoo.com">Mathieu C</a>
 * @author <a href="mailto:aymericjacquey@gmail.com">Aymeric C</a>
 * @version 21.0.7
 */
public class ControleurListAppariements {

    /** Bouton permettant de retourner au menu principal. */
    @FXML
    Button buttonMenu;

    /** Bouton permettant de revenir à la scène précédente. */
    @FXML
    Button buttonRetour;

    /** Liste affichant les appariements sous forme de BorderPane. */
    @FXML
    ListView<BorderPane> appariements;

    /**
     * Initialise la liste des appariements et configure les boutons avec des icônes.
     */
    public void initialize() {
        ImageView imageMenu = new ImageView(new Image("file:doc/img/Menu.png"));
        imageMenu.setFitWidth(30);
        imageMenu.setFitHeight(30);
        buttonMenu.setGraphic(imageMenu);
        buttonMenu.setText("");

        ImageView imageRetour = new ImageView(new Image("file:doc/img/retour.png"));
        imageRetour.setFitWidth(30);
        imageRetour.setFitHeight(30);
        buttonRetour.setGraphic(imageRetour);
        buttonRetour.setText("");

        // Ajout des appariements existants à la liste
        for (Affectation a : AppIhm.affectations) {
            addAppariements(a);
        }
    }

    /**
     * Gère l'action du bouton menu.
     * Ajoute la scène actuelle à l'historique et affiche la scène du menu principal.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedButtonMenu(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneListAppariements);
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    /**
     * Gère l'action du bouton retour.
     * Revient à la dernière scène enregistrée si elle existe.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedButtonRetour(ActionEvent event) {
        if (!AppIhm.lastScenes.isEmpty()) { // Vérifie si des scènes précédentes existent
            AppIhm.stageA.setScene(AppIhm.lastScenes.get(AppIhm.lastScenes.size()-1)); // Revient à la dernière scène enregistrée
            AppIhm.lastScenes.remove(AppIhm.lastScenes.size()-1); // Supprime la dernière scène de l'historique
        }
    }

    /**
     * Recharge la scène "ListAppariements" depuis le fichier FXML.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedButtonReload(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        URL fxmlFileUrl = getClass().getResource("fxml/listAppariements.fxml");
        if (fxmlFileUrl == null) {
            System.out.println("Impossible de charger le fichier fxml");
            System.exit(-1);
        }
        loader.setLocation(fxmlFileUrl);
        try {
            Parent root = loader.load();
            AppIhm.sceneListAppariements = new Scene(root);
            AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ajoute un appariement à la liste des affichages.
     * 
     * @param a L'affectation à ajouter.
     */
    public void addAppariements(Affectation a) {
        BorderPane bp = new BorderPane();
        Label nomHote = new Label(a.getHote().toString());
        Label nomVisiteur = new Label(a.getVisiteur().toString());
        Label affinite = new Label("" + a.getAffinite());

        bp.setLeft(nomHote);
        bp.setCenter(nomVisiteur);
        bp.setRight(affinite);

        appariements.getItems().add(bp);
    }

    /**
     * Redirige l'utilisateur vers la liste des étudiants.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedEtudiants(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneListAppariements);
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }

    /**
     * Redirige l'utilisateur vers la scène des critères de sélection.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedCriteres(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneListAppariements);
        AppIhm.stageA.setScene(AppIhm.sceneCriteres);
    }
}

