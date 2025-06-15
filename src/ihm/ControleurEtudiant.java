package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sae.Student;
/**
 * Contrôleur de la page FXML "Etudiant".
 * Gère l'affichage des informations d'un étudiant sélectionné et permet la navigation vers d'autres scènes.
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com ">Mathéo D</a>
 * @author <a href="calmatthieu@yahoo.com ">Mathieu C</a>
 * @author <a href="aymericjacquey@gmail.com  ">Aymeric C</a>
 * @version 21.0.7
 */
public class ControleurEtudiant {

    /** Bouton permettant de retourner au menu principal. */
    @FXML
    Button buttonMenu;

    /** Bouton permettant de revenir à la scène précédente. */
    @FXML
    Button buttonRetour;

    /** Labels affichant les informations de l'étudiant. */
    @FXML
    Label labelName;
    @FXML
    Label labelForename;
    @FXML
    Label labelCountry;
    @FXML
    Label labelBirthDate;
    @FXML
    Label labelGender;
    @FXML
    Label labelPairGender;
    @FXML
    Label labelFood;
    @FXML
    Label labelGuestFoodConstraint;
    @FXML
    Label labelHobbies;

    /** Cases à cocher indiquant la présence d'animaux et les allergies. */
    @FXML
    CheckBox boxHasAnimal;
    @FXML
    CheckBox boxGuestAnimalAllergy;

    /**
     * Initialise les informations affichées pour l'étudiant sélectionné.
     * Met en place les labels et désactive les cases à cocher.
     */
    public void initialize() {
        Student s = AppIhm.selectedEtudiant;
        
        labelName.setText(s.getNom());
        labelForename.setText(s.getPrenom());
        labelCountry.setText(s.getPays());
        labelBirthDate.setText(s.getDateNaissance().toString());

        labelGender.setText("true".equals(s.getGender()) ? "Male" : "Female");
        labelPairGender.setText("true".equals(s.getPairGender()) ? "Male" : "Female");

        labelFood.setText(s.getHostFood().toString());
        labelGuestFoodConstraint.setText(s.getHostFood().toString());
        labelHobbies.setText(s.getHobbies().toString());

        boxHasAnimal.setSelected(s.getHostHasAnimal());
        boxGuestAnimalAllergy.setSelected(s.getGuestAnimalAllergy());

        boxHasAnimal.setDisable(true);
        boxGuestAnimalAllergy.setDisable(true);

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
    }

    /**
     * Gère l'action du bouton de menu.
     * Sauvegarde la scène actuelle et affiche la scène du menu principal.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedButtonMenu(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneEtudiant);
        AppIhm.stageA.setScene(AppIhm.sceneMenu);
    }

    /**
     * Gère l'action du bouton de retour.
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
     * Affiche la liste des étudiants.
     * Sauvegarde la scène actuelle et affiche la scène de la liste des étudiants.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedEtudiants(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneEtudiant);
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }

    /**
     * Affiche la liste des appariements.
     * Sauvegarde la scène actuelle et affiche la scène des appariements.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedListeAppariements(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneEtudiant);
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
    }

    /**
     * Affiche la scène des critères.
     * Sauvegarde la scène actuelle et affiche la scène des critères.
     * 
     * @param event L'événement déclenché lors du clic.
     */
    public void pressedCriteres(ActionEvent event) {
        AppIhm.lastScenes.add(AppIhm.sceneEtudiant);
        AppIhm.stageA.setScene(AppIhm.sceneCriteres);
    }
}