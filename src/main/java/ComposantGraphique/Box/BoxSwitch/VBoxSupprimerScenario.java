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
        Label labelTilte = new Label("Choix du scenario a supprimer");
        Button buttonSupprimer = new Button("Supprimer");
        labelTilte.setId("labelTilte");
        buttonSupprimer.setOnAction(VBoxRoot.getControler());
        buttonSupprimer.setAccessibleText("SupprimerScenario");
        buttonSupprimer.setId("buttonSupprimer");
        ObservableList<Node> list = (VBoxRoot.getBoxScenario().getBoxScenario().getChildren());
        for (int i=0;i<list.size();i++){
            Button button = (Button) list.get(i);
            String NOM = button.getText();
            comboBox.getItems().add(NOM);
        }
        comboBox.setValue(comboBox.getItems().get(0));
        comboBox.setId("comboBoxSuppr");
        this.setMaxSize(400,500);
        this.getChildren().add(labelTilte);
        this.getChildren().add(comboBox);
        this.getChildren().add(buttonSupprimer);
        this.setId("boxSuppr");
    }

    public String getValeurChoisi(){
        return (String) comboBox.getValue();
    }

    public ComboBox getComboBox(){
        return comboBox;
    }

}
