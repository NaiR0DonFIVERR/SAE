package vue;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import modele_Prof.CalendrierDuMoisProf;
import modele_Prof.ConstantesCalendrier;
import modele_Prof.DateCalendrierProf;

public class HboxTP3 extends HBox implements ConstantesCalendrier {
    public HboxTP3(){
        StackPane stackMois = new StackPane();
        ToggleGroup boutonGroup = new ToggleGroup();

        for(int i = 1; i<=12; i++){
            CalendrierDuMoisProf moisCalendrier = new CalendrierDuMoisProf(i, 2022);

            TilePane titledPane = new TilePane();
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
    }

}
