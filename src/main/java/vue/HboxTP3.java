package vue;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.util.List;

public class HboxTP3 extends VBox implements ConstantesCalendrier {
    public HboxTP3(){
        StackPane stackMois = new StackPane();
        ToggleGroup boutonGroup = new ToggleGroup();

        for(int i = 1; i<=12; i++){
            CalendrierDuMois moisCalendrier = new CalendrierDuMois(i, 2022);

            TilePane titledPane = new TilePane();
            titledPane.setMaxWidth(400);
            titledPane.setMinWidth(400);
            titledPane.setId("opaque");

            for (String jour : JOURS_SEMAINE){
                Label labelJour = new Label(jour);
                titledPane.getChildren().add(labelJour);
            }

            for (DateCalendrier date : moisCalendrier.getDates()){
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));

                boutonDate.setToggleGroup(boutonGroup);
                titledPane.getChildren().add(boutonDate);

                boutonDate.setUserData(date);
                boutonDate.setOnAction(evt ->{
                    System.out.println(date);
                });
                if (date.getMois() != moisCalendrier.getMois()){
                    boutonDate.setId("HorsMois");
                }
                if (date.compareTo(new DateCalendrier()) == 0){
                    boutonDate.setId("Today");
                }
            }
            titledPane.setAccessibleText(MOIS[i-1]);
            stackMois.getChildren().add(titledPane);
        }

        DateCalendrier jourAuj = new DateCalendrier();
        int MOIS_VAR = jourAuj.getMois();
        Label labelMoisCourant = new Label(MOIS[MOIS_VAR-1] + " " + jourAuj.getAnnee());

        HBox boxBouton = new HBox();
        Button bouton1erposi = new Button("<<");
        Button boutonPre = new Button("<");
        Button boutonSuiv = new Button(">");
        Button boutonDern = new Button(">>");
        boxBouton.getChildren().addAll(bouton1erposi, boutonPre, boutonSuiv, boutonDern);


        List<Node> listeDesMois = stackMois.getChildren();

        HBox boxTop = new HBox();
        boxTop.getChildren().addAll(labelMoisCourant, boxBouton);
        while (!listeDesMois.get(11).getAccessibleText().equals(MOIS[jourAuj.getMois()-1]) ){
            listeDesMois.get(0).toFront();
        }


        boutonPre.setOnAction(evt ->{
            listeDesMois.get(11).toBack();
            labelMoisCourant.setText(listeDesMois.get(11).getAccessibleText()+" "+ jourAuj.getAnnee());
        });

        boutonSuiv.setOnAction(evt ->{
            listeDesMois.get(0).toFront();
            labelMoisCourant.setText(listeDesMois.get(11).getAccessibleText()+" "+ jourAuj.getAnnee());
        });

        bouton1erposi.setOnAction(evt ->{
            while (!listeDesMois.get(11).getAccessibleText().equals(MOIS[0])){
                listeDesMois.get(0).toFront();
                labelMoisCourant.setText(listeDesMois.get(11).getAccessibleText()+" "+ jourAuj.getAnnee());
            }
        });

        boutonDern.setOnAction(evt ->{
            while (!listeDesMois.get(11).getAccessibleText().equals(MOIS[11])){
                listeDesMois.get(11).toBack();
                labelMoisCourant.setText(listeDesMois.get(11).getAccessibleText()+" "+ jourAuj.getAnnee());
            }
        });

        this.getChildren().addAll(stackMois, boxTop);

    }

}
