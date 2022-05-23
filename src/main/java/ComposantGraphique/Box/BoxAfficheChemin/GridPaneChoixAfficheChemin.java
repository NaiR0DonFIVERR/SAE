package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

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

        gridPane.add(new Label("CHOIS"), 1, 0, 2,1);

        for (int i=0;i<CHOIX_CHEMIN.length;i++){
            RadioButton button = new RadioButton(CHOIX_CHEMIN[i]);
            button.setUserData(i);
            button.setToggleGroup(toggleGroup);
            gridPane.add(button, i,1+i%2,1,1);
        }
    }

    public GridPane getGridPane(){
        return gridPane;
    }

}

