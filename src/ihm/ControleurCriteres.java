package ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import sae.Affectation;
import sae.Student;
/**
 * Classe qui gère le comportement de la page fxml critere
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com ">Mathéo D</a>
 * @author <a href="calmatthieu@yahoo.com ">Mathieu C</a>
 * @author <a href="aymericjacquey@gmail.com  ">Aymeric C</a>
 * @version 21.0.7
 */
public class ControleurCriteres {
    /**
     * Bouton permettant de retourner au menu principal.
     */
    @FXML
    Button buttonMenu;

    /**
     * Bouton permettant de revenir à la dernière scène visitée.
     */
    @FXML
    Button buttonRetour;

    /**
     * Liste des affectations à fixer.
     */
    @FXML
    ListView<HBox> listViewFixer;

    /**
     * Liste des affectations à éviter.
     */
    @FXML
    ListView<HBox> listViewEviter;
    /**
     * Cases à cocher pour activer/désactiver les critères de sélection de Hobbies.
     */
    @FXML
    CheckBox checkboxHobbies;
    /**
     * Cases à cocher pour activer/désactiver les critères de sélection de Genre.
     */
    @FXML
    CheckBox checkboxGender;
    /**
     * Cases à cocher pour activer/désactiver les critères de difference d'age.
     */
    @FXML
    CheckBox checkboxBirthDate;
    /**
     * Cases à cocher pour activer/désactiver les critères d'allergie.
     */
    @FXML
    CheckBox checkboxAnimalAllergy;
    /**
     * Cases à cocher pour activer/désactiver les critères de regime alimentaire.
     */
    @FXML
    CheckBox checkboxFood;
    @FXML
    Spinner<Integer> spinnerHobbies;
    @FXML
    Spinner<Integer> spinnerGender;
    @FXML
    Spinner<Integer> spinnerBirthDate;
    @FXML
    Spinner<Integer> spinnerAnimalAllergy;
    @FXML
    Spinner<Integer> spinnerFood;


    /**
     * methode permettant d'initialiser les ajout sur la page fxml Critere 
     */
    public void initialize(){
        ImageView imageMenu = null;//initialisation de l'image menu 
        //permet de gerer les exeption
        try{
            //essaye de recuperer l'image Menu.png
            imageMenu = new ImageView(new Image("file:doc/img/Menu.png"));//prend l'image
            imageMenu.setFitWidth(30);//modifie la largeur de l'image
            imageMenu.setFitHeight(30);//modifie la hauteur de l'image
        }catch(NullPointerException e){//recupere l'exeption NullPointerException afin de ne pas faire planter le programme si le chemin n'est pas bon (il ne s'affichera pas)
            e.printStackTrace();//affiche l'exeption
        }
        buttonMenu.setGraphic(imageMenu);//ajoute l'image du menu au bouton buttonMenue
        buttonMenu.setText("");//supprime le text present dans buttonMenue

        ImageView imageRetour = null;//initialisation de l'image retour 
        //permet de gerer les exeption
        try{
            //essaye de recuperer l'image Retour.png
            imageRetour = new ImageView(new Image("file:doc/img/retour.png"));//prend l'image
            imageRetour.setFitWidth(30);//modifie la largeur de l'image
            imageRetour.setFitHeight(30);//modifie la hauteur de l'image
        }catch(NullPointerException e){//recupere l'exeption NullPointerException afin de ne pas faire planter le programme si le chemin n'est pas bon (il ne s'affichera pas)
            e.printStackTrace();//affiche l'exeption
        }
        buttonRetour.setGraphic(imageRetour);//ajoute l'image du menu au bouton buttonRetour
        buttonRetour.setText("");//supprime le text present dans bouton

        // Activation par défaut des critères de sélection
        checkboxHobbies.setSelected(true); // Active le critère "hobbies"
        checkboxGender.setSelected(true); // Active le critère "gender"
        checkboxBirthDate.setSelected(true); // Active le critère "birthDate"
        checkboxAnimalAllergy.setSelected(true); // Active le critère "animalAllergy"
        checkboxFood.setSelected(true); // Active le critère "food"

        spinnerHobbies.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10));
        spinnerGender.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10));
        spinnerBirthDate.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10));
        spinnerAnimalAllergy.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10));
        spinnerFood.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10));
    }
    /**
 * Gère l'action du bouton de menu.
 * Ajoute la scène actuelle à l'historique et affiche le menu principal.
 * 
 * @param event L'événement déclenché lors du clic sur le bouton.
 */
public void pressedButtonMenu(ActionEvent event){
    AppIhm.lastScenes.add(AppIhm.sceneCriteres); // Sauvegarde la scène actuelle
    AppIhm.stageA.setScene(AppIhm.sceneMenu); // Affiche la scène du menu principal
}

/**
 * Gère l'action du bouton de retour.
 * Ramène l'utilisateur à la dernière scène enregistrée.
 * 
 * @param event L'événement déclenché lors du clic sur le bouton.
 */
public void pressedButtonRetour(ActionEvent event) {
        if (!AppIhm.lastScenes.isEmpty()) { // Vérifie si des scènes précédentes existent
            AppIhm.stageA.setScene(AppIhm.lastScenes.get(AppIhm.lastScenes.size()-1)); // Revient à la dernière scène enregistrée
            AppIhm.lastScenes.remove(AppIhm.lastScenes.size()-1); // Supprime la dernière scène de l'historique
        }
    }

/**
 * Ajoute une affectation fixée entre deux étudiants.
 * Permet à l'utilisateur de sélectionner deux étudiants et les associer.
 * 
 * @param event L'événement déclenché lors du clic sur le bouton "Ajouter".
 */
public void pressedFixerAjouter(ActionEvent event){
    HBox h = new HBox(); // Conteneur horizontal pour afficher les choix
    ChoiceBox<Student> choiceBox1 = new ChoiceBox<>(); // Sélection du premier étudiant
    ChoiceBox<Student> choiceBox2 = new ChoiceBox<>(); // Sélection du deuxième étudiant
    Button buttonPlus = new Button("+"); // Bouton de validation
    
    // Ajoute les étudiants aux listes déroulantes
    choiceBox1.getItems().addAll(AppIhm.students);
    choiceBox2.getItems().addAll(AppIhm.students);
    
    // Ajout des composants graphiques
    h.getChildren().addAll(choiceBox1, choiceBox2, buttonPlus);

    buttonPlus.setOnAction(e -> {
        Student student1 = choiceBox1.getValue();
        Student student2 = choiceBox2.getValue();

        Affectation affect = new Affectation(student1, student2);

        // Ajout de l'affectation aux listes concernées
        AppIhm.affectations.add(affect);
        AppIhm.affectationsFixer.add(affect);

        // Remplacement des choix par des labels affichant les étudiants sélectionnés
        h.getChildren().removeAll(choiceBox1, choiceBox2, buttonPlus);
        Label labelStudent1 = new Label(student1.toString());
        Label labelStudent2 = new Label(student2.toString());
        h.getChildren().addAll(labelStudent1, new Label("     "), labelStudent2);
    });

    listViewFixer.getItems().add(h); // Ajoute l'affectation à la liste graphique
}

/**
 * Ajoute une affectation à éviter entre deux étudiants.
 * Fonctionne de manière similaire à pressedFixerAjouter.
 * 
 * @param event L'événement déclenché lors du clic sur le bouton "Ajouter".
 */
public void pressedEviterAjouter(ActionEvent event){
    HBox h = new HBox();
    ChoiceBox<Student> choiceBox1 = new ChoiceBox<>();
    ChoiceBox<Student> choiceBox2 = new ChoiceBox<>();
    Button buttonPlus = new Button("+");
    
    choiceBox1.getItems().addAll(AppIhm.students);
    choiceBox2.getItems().addAll(AppIhm.students);
    
    h.getChildren().addAll(choiceBox1, choiceBox2, buttonPlus);

    buttonPlus.setOnAction(e -> {
        Student student1 = choiceBox1.getValue();
        Student student2 = choiceBox2.getValue();

        Affectation affect = new Affectation(student1, student2);

        // Ajoute à la liste des affectations à éviter
        AppIhm.affectationsEviter.add(affect);

        h.getChildren().removeAll(choiceBox1, choiceBox2, buttonPlus);
        Label labelStudent1 = new Label(student1.toString());
        Label labelStudent2 = new Label(student2.toString());
        h.getChildren().addAll(labelStudent1, new Label("     "), labelStudent2);
    });

    listViewEviter.getItems().add(h);
}

/**
 * Supprime la dernière affectation fixée.
 * 
 * @param event L'événement déclenché lors du clic sur le bouton "Supprimer".
 */
public void pressedFixerSupprimer(ActionEvent event){
    if (!listViewFixer.getItems().isEmpty()) { // Vérifie si la liste n'est pas vide
        listViewFixer.getItems().remove(listViewFixer.getItems().size()-1); // Supprime le dernier élément graphique
        if (!AppIhm.affectationsFixer.isEmpty()) { // Supprime l'affectation correspondante
            AppIhm.affectations.remove(AppIhm.affectationsFixer.get(AppIhm.affectationsFixer.size()-1));
            AppIhm.affectationsFixer.remove(AppIhm.affectationsFixer.size()-1);
        }
    }
}

/**
 * Supprime la dernière affectation à éviter.
 * Fonctionne de manière similaire à pressedFixerSupprimer.
 * 
 * @param event L'événement déclenché lors du clic sur le bouton "Supprimer".
 */
public void pressedEviterSupprimer(ActionEvent event){
    if (!listViewEviter.getItems().isEmpty()) {
        listViewEviter.getItems().remove(listViewEviter.getItems().size()-1);
        if (!AppIhm.affectationsEviter.isEmpty()) {
            AppIhm.affectationsEviter.remove(AppIhm.affectationsEviter.size()-1);
        }
    }
}

    /**
     * Affiche la liste des étudiants.
     * Ajoute la scène actuelle à l'historique avant de changer d'affichage.
     * 
     * @param event L'événement déclenché lors du clic sur le bouton "Voir Étudiants".
     */
    public void pressedEtudiants(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneCriteres);
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }

    /**
     * Affiche la liste des appariements.
     * Ajoute la scène actuelle à l'historique avant de changer d'affichage.
     * 
     * @param event L'événement déclenché lors du clic sur le bouton "Voir Appariements".
     */
    public void pressedListeAppariements(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneCriteres);
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
    }

    // Gestion de l'état des critères sélectionnés
    /**
     * Met à jour le statut du critère "hobbies".
     * 
     * @param event L'événement déclenché lors du clic sur la case à cocher.
     */
    public void pressedCheckboxHobbies(ActionEvent event){
        AppIhm.enableCriteres.put("hobbies", checkboxHobbies.isSelected());
    }

    /**
     * Met à jour le statut du critère "gender".
     * 
     * @param event L'événement déclenché lors du clic sur la case à cocher.
     */
    public void pressedCheckboxGender(ActionEvent event){
        AppIhm.enableCriteres.put("gender", checkboxGender.isSelected());
    }

    /**
     * Met à jour le statut du critère "birthDate".
     * 
     * @param event L'événement déclenché lors du clic sur la case à cocher.
     */
    public void pressedCheckboxBirthDate(ActionEvent event){
        AppIhm.enableCriteres.put("birthDate", checkboxBirthDate.isSelected());
    }

    /**
     * Met à jour le statut du critère "animalAllergy".
     * 
     * @param event L'événement déclenché lors du clic sur la case à cocher.
     */
    public void pressedCheckboxAnimalAllergy(ActionEvent event){
        AppIhm.enableCriteres.put("animalAllergy", checkboxAnimalAllergy.isSelected());
    }

    /**
     * Met à jour le statut du critère "food".
     * 
     * @param event L'événement déclenché lors du clic sur la case à cocher.
     */
    public void pressedCheckboxFood(ActionEvent event){
        AppIhm.enableCriteres.put("food", checkboxFood.isSelected());
    }

    public void pressedSpinnerHobbies(MouseEvent event){
        AppIhm.valuesCriteres.put("hobbies",spinnerHobbies.getValue());
    }

    public void pressedSpinnerGender(MouseEvent event){
        AppIhm.valuesCriteres.put("gender",spinnerGender.getValue());
    }

    public void pressedSpinnerBirthDate(MouseEvent event){
        AppIhm.valuesCriteres.put("birthDate",spinnerBirthDate.getValue());
    }

    public void pressedSpinnerAnimalAllergy(MouseEvent event){
        AppIhm.valuesCriteres.put("animalAllergy",spinnerAnimalAllergy.getValue());
    }

    public void pressedSpinnerFood(MouseEvent event){
        AppIhm.valuesCriteres.put("food",spinnerFood.getValue());
    }
}
