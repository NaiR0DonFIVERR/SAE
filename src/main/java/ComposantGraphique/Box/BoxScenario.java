package ComposantGraphique.Box;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.Scenario;
import vue.HBoxRoot;

import java.util.ArrayList;
import java.util.List;


public class BoxScenario extends VBox {

    VBox box;
    VBox boxScenario;
    ScrollPane scrollPane;
    List<Scenario> scenarioList;

    public BoxScenario(){
        box = new VBox();
        boxScenario = new VBox();
        scrollPane = new ScrollPane();
        scenarioList = new ArrayList<>();
        scrollPane.setContent(boxScenario);
        box.getChildren().addAll(new Label("Liste des Scenarios"), scrollPane);
    }

    public void addScenario(Scenario scenario){
        Button button = new Button("Scenario : " + scenarioList.size());
        scenarioList.add(scenario);
        button.setUserData(scenario);
        button.setAccessibleText("ChangeScenario");
        button.setOnAction(HBoxRoot.getControler());
        boxScenario.getChildren().add(button);
    }

    public ScrollPane getScrollPane(){
        return scrollPane;
    }

    public VBox getBox(){
        return box;
    }

}
