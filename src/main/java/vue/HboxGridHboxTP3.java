package vue;

import Controler.Controler;
import javafx.scene.layout.HBox;
import modele.Planning;

public class HboxGridHboxTP3 extends HBox {

    private static Controler controler = new Controler();
    private static Planning planning = new Planning();
    private static HboxTP3 calendrierPane = new HboxTP3();
    private static GridPaneFormulaireReservation reservationPane = new GridPaneFormulaireReservation();

    public  HboxGridHboxTP3(){


        getChildren().addAll(calendrierPane, reservationPane);
    }
    public static Planning getPlanning(){
        return planning;
    }
    public static GridPaneFormulaireReservation getReservationPane(){
        return reservationPane;
    }
}
