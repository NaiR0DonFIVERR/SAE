package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;

public class VBoxRoot extends VBox implements ConstantesCalendrier {
    public VBoxRoot(){

        CalendrierDuMois dateCalendrier = new CalendrierDuMois(3,2022);

        Label labelTitle = new Label(MOIS[dateCalendrier.getMois()-1] + " " + dateCalendrier.getAnnee());

        VBox.setMargin(labelTitle, new Insets(14)); //Marge du Mois et Année

        VBox boxDate = new VBox();
        ScrollPane barre = new ScrollPane(); //Ajout de la barre de navigation
        barre.setContent(boxDate);
        VBox.setMargin(barre, new Insets(4));

        for (DateCalendrier date : dateCalendrier.getDates()) {   //La méthode getDates retourne un TreeSet. On parcourt cette liste
            //On créer un objet TreeSet DateCalendrier nommé date
            Label labelDate = new Label(date.toString()); //Grâce au parcourt on récupère toute les dates en str

            if (date.getMois() != dateCalendrier.getMois()){
                labelDate.setId("dateHorsMois");
            }

            if (date.compareTo(new DateCalendrier()) == 0){
                labelDate.setId("Today");
            }

            VBox.setMargin(labelDate, new Insets(8));
            boxDate.getChildren().add(labelDate);
        }
        this.getChildren().addAll(labelTitle,barre);

        /*Label labelJourAujourdhuit = new Label(DateD.toString());
        Label labelJourLendemain = new Label(DateD.dateDuLendemain().toString());
        Label labelCalendrier = new Label(dateCalendrier.toString());

        this.getChildren().add(labelTitle);
        this.getChildren().add(labelJourAujourdhuit);
        this.getChildren().add(labelJourLendemain);
        this.getChildren().add(labelCalendrier);*/

    }



}
