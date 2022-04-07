package vue;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import modele_Prof.CalendrierDuMoisProf;
import modele_Prof.ConstantesCalendrier;
import modele_Prof.DateCalendrierProf;

public class HboxTP3 extends VBox implements ConstantesCalendrier {
    public HboxTP3(){
        StackPane stackMois = new StackPane();
        ToggleGroup boutonGroup = new ToggleGroup();

        for(int i = 1; i<=12; i++){
            CalendrierDuMoisProf moisCalendrier = new CalendrierDuMoisProf(i, 2022);

            TilePane titledPane = new TilePane();
            titledPane.setMaxWidth(400);
            titledPane.setMinWidth(400);
            titledPane.setId("opaque");

            for (String jour : JOURS_SEMAINE){
                Label labelJour = new Label(jour);
                titledPane.getChildren().add(labelJour);
            }

            for (DateCalendrierProf date : moisCalendrier.getDates()){
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));

                boutonDate.setToggleGroup(boutonGroup);
                titledPane.getChildren().add(boutonDate);

                boutonDate.setUserData(date);
                boutonDate.setOnAction(evt ->{
                    System.out.println("Test");
                });
                if (date.getMois() != moisCalendrier.getMois()){
                    boutonDate.setId("HorsMois");
                }
                if (date.equals(new DateCalendrierProf())){
                    boutonDate.setId("Today");
                }
            }
            titledPane.setAccessibleText(MOIS[i-1]);
            stackMois.getChildren().add(titledPane);
        }

        DateCalendrierProf jourAuj = new DateCalendrierProf();
        int MOIS_VAR = jourAuj.getMois();
        Label labelMoisCourant = new Label(MOIS[MOIS_VAR-1] + " " + jourAuj.getAnnee());

        HBox boxBouton = new HBox();
        Button bouton1erposi = new Button("<<");
        Button boutonPre = new Button("<");
        Button boutonSuiv = new Button(">");
        Button boutonDern = new Button(">>");
        boxBouton.getChildren().addAll(bouton1erposi, boutonPre, boutonSuiv, boutonDern);


        HBox boxTop = new HBox();
        boxTop.getChildren().addAll(labelMoisCourant, boxBouton);


        this.getChildren().addAll(stackMois, boxTop);

    }

}
