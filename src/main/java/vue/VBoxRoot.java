package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.Date;
import modele.DateCalendrier;

public class VBoxRoot extends VBox {
    public VBoxRoot(){

        DateCalendrier DateD = new DateCalendrier();
        CalendrierDuMois dateCalendrier = new CalendrierDuMois(3,2022);


        Label labelJourAujourdhuit = new Label(DateD.toString());
        Label labelJourLendemain = new Label(DateD.dateDuLendemain().toString());
        Label labelCalendrier = new Label(dateCalendrier.toString());

        this.getChildren().add(labelJourAujourdhuit);
        this.getChildren().add(labelJourLendemain);
        this.getChildren().add(labelCalendrier);

    }



}
