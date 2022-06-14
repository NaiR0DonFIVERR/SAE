package ComposantGraphique.Box;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.Scenario;
import vue.VBoxRoot;

import java.util.ArrayList;
import java.util.List;


public class BoxScenario extends VBox {

    VBox boxScenario;
    ScrollPane scrollPane;
    List<Scenario> scenarioList;

    public BoxScenario(){
        boxScenario = new VBox();
        scrollPane = new ScrollPane();
        scenarioList = new ArrayList<>();
        Label labelTilte = new Label("Liste des Scenarios");
        labelTilte.setId("labelTilte");
        scrollPane.setContent(boxScenario);
        this.getChildren().addAll(labelTilte, scrollPane);
        this.setId("boxScenario");
        this.setMinWidth(150);
    }

    public void addScenario(Scenario scenario){
        Button button = new Button("Scenario : " + scenarioList.size());
        scenarioList.add(scenario);
        button.setUserData(scenario);
        button.setAccessibleText("ChangeScenario");
        button.setOnAction(VBoxRoot.getControler());
        boxScenario.getChildren().add(button);
    }

    public ScrollPane getScrollPane(){
        return scrollPane;
    }

    public List<Scenario> getScenarioList(){
        return scenarioList;
    }
    public VBox getBoxScenario(){ return boxScenario; }
}
