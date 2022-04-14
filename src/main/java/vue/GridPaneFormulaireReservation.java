package vue;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.ConstantesHeures;
import modele.DateCalendrier;


public class GridPaneFormulaireReservation extends GridPane implements ConstantesHeures {
    ComboBox <String> comboHeurDebut = new ComboBox<>();
    ComboBox <String> comboHeurFin = new ComboBox<>();

    ComboBox <String> comboMinuteDebut = new ComboBox<>();
    ComboBox <String> comboMinuteFin = new ComboBox<>();



    public GridPaneFormulaireReservation(){
        int ligne = 0;

        DateCalendrier dateJ = new DateCalendrier();

        Label labelDate = new Label(dateJ.toString());
        Label labelStrCour = new Label("Cours");
        TextField textCour = new TextField();
        Label labelNiveau = new Label("Niveau");
        Label labelNvDebu = new Label("Debutant");
        Label labelNvNor = new Label("Normal");
        Label labelConfirme = new Label("Confirmé");
        Label labelNvExp = new Label("Expert");

        Label labelHeur = new Label("Heur");
        Label labelHeureCommence = new Label("Commence à :");
        Label labelFini = new Label("Fini à :");
        Label labelHD = new Label("h");
        Label labelHF= new Label("h");
        Label labelMD = new Label("m");
        Label labelMF = new Label("m");


        RadioButton buttonDebut = new RadioButton();
        RadioButton buttonNor = new RadioButton();
        RadioButton buttonConf = new RadioButton();
        RadioButton buttonExp = new RadioButton();

        Button boutonAnnule = new Button("Annuler");
        Button boutonEnregistrer = new Button("Enregistrer");

        labelStrCour.setLabelFor(textCour);
        labelStrCour.setMnemonicParsing(true);
        String texteCours = textCour.getText();

        for (String heure : HEURE){
            comboHeurDebut.getItems().add(heure);
            comboHeurFin.getItems().add(heure);
        }
        for (String minute : MINUTES){
            comboMinuteDebut.getItems().add(minute);
            comboMinuteFin.getItems().add(minute);
        }






        this.setPadding(new Insets(40));
        this.setHgap(20);
        this.setVgap(20);
        GridPane.setHalignment(labelDate, HPos.CENTER);
        this.add(labelDate,0,0,5,1);
        this.add(labelStrCour, 0, 1, 1,1);
        this.add(textCour, 1,1, 4,1);
        this.add(labelNiveau, 0,2, 1,1);
        this.add(buttonDebut, 1,2,1,1);
        this.add(labelNvDebu, 2,2,1,1);
        this.add(buttonNor, 3,2,1,1);
        this.add(labelNvNor, 4,2,1,1);
        this.add(buttonConf, 1, 3, 1,1);
        this.add(labelConfirme, 2, 3, 1,1);
        this.add(buttonExp, 3, 3, 1,1);
        this.add(labelNvExp, 4, 3, 1,1);


        this.add(labelHeur, 0,4,1,1);
        this.add(labelHeureCommence,1,4,1,1);
        this.add(comboHeurDebut, 2,4,2,1);
        this.add(labelHD,3,4,1,1);
        this.add(comboMinuteDebut,4,4,2,1);
        this.add(labelMD,5,4,1,1);

        this.add(labelFini,1,5,1,1);
        this.add(comboHeurFin,2,5,2,1);
        this.add(labelHF,3,5,1,1);
        this.add(comboMinuteFin,4,5,2,1);
        this.add(labelMF,5,5,1,1);

        this.add(boutonAnnule,1,6,2,1);
        this.add(boutonEnregistrer,2,6,2,1);

        this.setGridLinesVisible(true);

    }

}
