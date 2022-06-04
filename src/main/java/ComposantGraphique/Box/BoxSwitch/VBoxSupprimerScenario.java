package ComposantGraphique.Box.BoxSwitch;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import vue.VBoxRoot;



public class VBoxSupprimerScenario extends VBox {

    ComboBox comboBox;

    public VBoxSupprimerScenario(){

        comboBox = new ComboBox<>();
        Label labelTitle = new Label("Choix du scenario a supprimer");
        Button buttonSupprimer = new Button("Supprimer");
        labelTitle.setId("lableTitle");
        buttonSupprimer.setOnAction(VBoxRoot.getControler());
        buttonSupprimer.setAccessibleText("SupprimerScenario");
        ObservableList<Node> list = (VBoxRoot.getBoxScenario().getBoxScenario().getChildren());
        for (int i=0;i<list.size();i++){
            Button button = (Button) list.get(i);
            String NOM = button.getText();
            comboBox.getItems().add(NOM);
        }
        comboBox.setValue(comboBox.getItems().get(0));

        this.getChildren().add(labelTitle);
        this.getChildren().add(comboBox);
        this.getChildren().add(buttonSupprimer);

    }

    public String getValeurChoisi(){
        return (String) comboBox.getValue();
    }

    public ComboBox getComboBox(){
        return comboBox;
    }

}
