package ComposantGraphique.GridPane;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import modele.Scenario;

import java.io.IOException;

public class GridPaneAffichageChemin extends GridPane {

    GridPane gridPane;

    VBoxGridPaneChemin boxChemin ;

    public GridPaneAffichageChemin(){


        gridPane = new GridPane();
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setGridLinesVisible(true);
        boxChemin = new VBoxGridPaneChemin();
        gridPane.add(boxChemin.getBox(), 1,1, 1,1);

    }

    public GridPane getGridPane(){

        return gridPane;
    }

    public VBoxGridPaneChemin getBoxChemin(){

        return boxChemin;
    }

    public void MAJ_BoxChemin(Scenario scenario) throws IOException {



        //System.out.println(gridPane.getChildren());
        boxChemin.setGridPaneChemin(scenario);

    }


}
