package vue;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;

public class VBoxRoot extends VBox implements ConstantesCalendrier {
    public VBoxRoot(){


        super(20);
        CalendrierDuMois dateCalendrier = new CalendrierDuMois(3,2022);
        int mois = dateCalendrier.getMois();
        int annee = dateCalendrier.getAnnee();
        /*Label labelTitle = new Label(MOIS[dateCalendrier.getMois()-1] + " " + dateCalendrier.getAnnee());

        VBox.setMargin(labelTitle, new Insets(14)); //Marge du Mois et Année*/

        //VBox boxDate = new VBox();
        //ScrollPane barre = new ScrollPane(); //Ajout de la barre de navigation.
        //barre.setContent(boxDate);
        //VBox.setMargin(barre, new Insets(4));





        Label labelMoisCourant = new Label(MOIS[mois-1] + " " + annee);

        HBox boxBouton = new HBox();
        Button bouton1 = new Button("<<");
        Button bouton2 = new Button("<");
        Button bouton3 = new Button(">");
        Button bouton4 = new Button(">>");
        boxBouton.getChildren().addAll(bouton1, bouton2, bouton3, bouton4);

        HBox boxEnsemble = new HBox();
        boxEnsemble.getChildren().addAll(labelMoisCourant, boxBouton);
        StackPane pageMois = new StackPane();

        for (int i=0; i < 12; i++){

            HBox boxDate_boutton = new HBox();
            Label labelDuMois = new Label(MOIS[i]);


            labelDuMois.setFont(new Font(30));
            labelDuMois.setId("labelMois");
            boxDate_boutton.setId("boxDate_boutton");
            boxDate_boutton.setMargin(labelDuMois, new Insets(20));
            boxDate_boutton.setMargin(boxBouton, new Insets(30));
            boxDate_boutton.getChildren().addAll(labelDuMois,boxBouton);


            pageMois.getChildren().add(boxDate_boutton);


        }
        this.getChildren().add(pageMois);




        //this.getChildren().add(boxEnsemble);


        /*for (DateCalendrier date : dateCalendrier.getDates()) {   //La méthode getDates retourne un TreeSet. On parcourt cette liste
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
        this.getChildren().addAll(labelTitle,barre);*/

        /*Label labelJourAujourdhuit = new Label(DateD.toString());
        Label labelJourLendemain = new Label(DateD.dateDuLendemain().toString());
        Label labelCalendrier = new Label(dateCalendrier.toString());

        this.getChildren().add(labelTitle);
        this.getChildren().add(labelJourAujourdhuit);
        this.getChildren().add(labelJourLendemain);
        this.getChildren().add(labelCalendrier);*/

    }



}
