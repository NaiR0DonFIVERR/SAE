package ComposantGraphique.boxScenario;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BoxScenarioAjout_Supp extends HBox{

    HBox box ;
    Button buttonAjout;
    Button buttonSupp;

    public BoxScenarioAjout_Supp(){
        box = new HBox();
        buttonAjout = new Button("Ajouter Scenario");
        buttonSupp = new Button("Supprimer Scenario");
        System.out.println(buttonAjout.getClass());
        buttonAjout.setAccessibleText("test");
        buttonAjout.setOnAction(HBoxRoot2.getControler());
        box.getChildren().addAll(buttonAjout, buttonSupp);
    }



    public HBox getBox(){

        return box;
    }

    public Button getButtonAjout(){

        return buttonAjout;
    }


}
