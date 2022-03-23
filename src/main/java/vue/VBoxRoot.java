package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.Date;
import modele.DateCalendrier;

public class VBoxRoot extends VBox {
    public VBoxRoot(){

        DateCalendrier DateD = new DateCalendrier();
        Label labelJourAujourdhuit = new Label(DateD.toString());
        Label labelJourLendemain = new Label(DateD.dateDuLendemain().toString());
        this.getChildren().add(labelJourAujourdhuit);
        this.getChildren().add(labelJourLendemain);


    }



}
