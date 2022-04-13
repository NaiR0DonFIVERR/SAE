package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.DateCalendrier;


public class GridPaneFormulaireReservation extends GridPane {
    public GridPaneFormulaireReservation(){
        int ligne = 0;

        DateCalendrier dateJ = new DateCalendrier();

        Label labelDate = new Label(dateJ.toString());
        this.setPadding(new Insets(40));
        this.setHgap(20);
        this.setVgap(20);
        GridPane.setHalignment(labelDate, HPos.CENTER);
        this.add(labelDate,0,0,5,1);










        this.setGridLinesVisible(true);

    }

}
