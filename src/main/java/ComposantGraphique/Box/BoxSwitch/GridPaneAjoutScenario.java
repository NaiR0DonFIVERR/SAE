package ComposantGraphique.Box.BoxSwitch;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class GridPaneAjoutScenario extends GridPane {

    GridPane gridPane;
    ComboBox comboBoxVendeur;
    ComboBox comboBoxAcheteur;


    public GridPaneAjoutScenario(){

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setGridLinesVisible(true);

    }

    public GridPane getGridPane(){
        return gridPane;
    }

}
