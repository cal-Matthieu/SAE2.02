package ihm;

import javafx.event.ActionEvent;


public class ControleurMenu {
    
    public void buttonEtudiants(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneMenu);
        AppIhm.stageA.setScene(AppIhm.sceneListEtudiants);
    }

    public void buttonListAppariements(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneMenu);
        AppIhm.stageA.setScene(AppIhm.sceneListAppariements);
    }

    public void buttonCriteres(ActionEvent event){
        AppIhm.lastScenes.add(AppIhm.sceneMenu);
        AppIhm.stageA.setScene(AppIhm.sceneCriteres);
    }
}
