package vue;

import ComposantGraphique.Scroll.SrollPaneCli;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.*;


import java.io.File;
import java.io.IOException;
import java.util.*;

import static modele.LectureEcriture.recupVille;
import static modele.LectureEcriture.lectureScenario;
import static modele.VoisinEntrants.*;

public class HBoxRoot extends HBox {
    File fichier = new File("E:\\java\\SAé\\ClasseModele\\src\\main\\java\\fichier_txt\\scenario_0.txt");
    Scenario scenario = lectureScenario(fichier);


    public HBoxRoot() throws IOException {
        SrollPaneCli srollPaneCli = new SrollPaneCli(scenario);
        this.getChildren().add(srollPaneCli.getScrollPane());
    }



}
