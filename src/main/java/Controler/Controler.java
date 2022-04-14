package Controler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.Planning;
import vue.GridPaneFormulaireReservation;
import vue.HboxGridHboxTP3;

public class Controler implements EventHandler {
    @Override
    public void handle(Event event) {
        Planning planning = HboxGridHboxTP3.getPlanning();
        GridPaneFormulaireReservation reservationPane = HboxGridHboxTP3.getReservationPane();
// la source de event est une date du calendrier du formulaire de réservation
        if (event.getSource() instanceof ToggleButton) {
// à compléter
        }
// la source de event est le bouton "Enregistrer"
        if (event.getSource() instanceof Button) {

        }
    }
}

