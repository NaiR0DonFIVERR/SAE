package vue;

import Controler.Controler;
import javafx.scene.layout.HBox;
import modele.Planning;

public class HBoxRoot extends HBox {

    private static Controler controler = new Controler();
    private static Planning planning = new Planning();
    private static BoxCalendrier calendrierPane = new BoxCalendrier();
    private static GridPaneFormulaireReservation reservationPane = new GridPaneFormulaireReservation();

    public HBoxRoot(){

        getChildren().addAll(calendrierPane, reservationPane);
    }
    public static Planning getPlanning(){

        return planning;
    }
    public static Controler getControler(){

        return controler;
    }
    public static GridPaneFormulaireReservation getReservationPane(){

        return reservationPane;
    }
}
