package ComposantGraphique.Box.BoxAfficheChemin;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import static Constantes.ConstantesMenu.CHOIX_CHEMIN;

public class GridPaneChoixAfficheChemin extends GridPane {

    GridPane gridPane;
    ToggleGroup toggleGroup;

    public GridPaneChoixAfficheChemin(){
        gridPane = new GridPane();
        toggleGroup = new ToggleGroup();



    }

}

