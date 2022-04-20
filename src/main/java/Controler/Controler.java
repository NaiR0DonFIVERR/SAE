package Controler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.Planning;
import modele.Reservation;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;

public class Controler implements EventHandler {
    @Override
    public void handle(Event event) {
        Planning planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();
// la source de event est une date du calendrier du formulaire de réservation
        if (event.getSource() instanceof ToggleButton) {
            System.out.println(((ToggleButton) event.getSource()).getUserData());
            reservationPane.setDate (((ToggleButton) event.getSource()).getUserData());
        }
// la source de event est le bouton "Enregistrer"
        if (event.getSource() instanceof Button) {

        }
    }
}

