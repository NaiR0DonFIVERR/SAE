package vue;

import javafx.scene.layout.HBox;

public class HboxGridHboxTP3 extends HBox {
    public  HboxGridHboxTP3(){
        GridPaneFormulaireReservation gridRoot = new GridPaneFormulaireReservation();
        HboxTP3 boxRoot = new HboxTP3();
        getChildren().addAll(boxRoot, gridRoot);
    }

}
