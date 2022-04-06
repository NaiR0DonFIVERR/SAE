package vue;


import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;


public class BoxTP3 extends HBox implements ConstantesCalendrier {
    public BoxTP3() {

        StackPane stackPane = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();
        for (int i=1; i<=12; i++){
            CalendrierDuMois moisCalendrier = new CalendrierDuMois(i,2022);

            TilePane titre = new TilePane();
            titre.setMaxWidth(400);
            titre.setMinWidth(400);

            titre.setId("opaque");

            for (String jourAb : JOURS_SEMAINE){
                Label labelJour = new Label(jourAb);
                titre.getChildren().add(labelJour);
            }
            if (i == 12){
                System.out.println(new CalendrierDuMois(12,2022));
            }
            for (DateCalendrier date : moisCalendrier.getDates()){

                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));
                //Créer un bouton pour chaque jour du mois i
                boutonDate.setToggleGroup(buttonGroup);

                titre.getChildren().add(boutonDate);

                boutonDate.setUserData(date);

                boutonDate.setOnAction(evt ->{
                    System.out.println("Test");
                });

                if (date.getMois() != moisCalendrier.getMois()){
                    boutonDate.setId("hors_Mois");
                }

                if (date.equals(new DateCalendrier())){
                    boutonDate.setId("aujourd");
                }
            }
            titre.setAccessibleText(MOIS[i-1]);
            stackPane.getChildren().add(titre);
        }
        getChildren().add(stackPane);
    }
}
