package ComposantGraphique.boxScenario;

import javafx.scene.control.Button;
import modele.Scenario;

public class BoutonScenario extends Button {

    Button boutonScenario;

    public BoutonScenario(Scenario scenario, BoxBoutonScenario boxBoutonScenario){

        boutonScenario = new Button("Scenario " + boxBoutonScenario.getListBouton().size());

        boutonScenario.setUserData(scenario);

        boutonScenario.setId("boutonScenario");

        boutonScenario.setAccessibleText("changeScenario");

        boutonScenario.setOnAction(HBoxRoot2.getControler());

        boxBoutonScenario.ajoutBouton(boutonScenario);

    }

    public void deleteBoutonScenario(){
        boutonScenario = null;
    }


}
