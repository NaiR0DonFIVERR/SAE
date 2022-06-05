package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import vue.VBoxRoot;

import static Constantes.ConstantesMenu.CHOIX_CHEMIN;

public class GridPaneChoixAfficheChemin extends GridPane {

    GridPane gridPane;
    ToggleGroup toggleGroup;

    public GridPaneChoixAfficheChemin(){
        gridPane = new GridPane();
        toggleGroup = new ToggleGroup();

        gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setId("backGroudWhite");

        gridPane.add(new Label("CHOIS"), 1, 0, 2,1);

        for (int i=0;i<CHOIX_CHEMIN.length;i++){
            RadioButton button = new RadioButton(CHOIX_CHEMIN[i]);
            button.setUserData(i);
            button.setToggleGroup(toggleGroup);
            button.setAccessibleText("ChangeAffichageChemin");
            button.setOnAction(VBoxRoot.getControler());
            gridPane.add(button, i,1+i%2,1,1);
        }
        toggleGroup.selectToggle(toggleGroup.getToggles().get(0));

    }

    public GridPane getGridPane(){
        return gridPane;
    }

}

