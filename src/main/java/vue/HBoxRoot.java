package vue;

import ComposantGraphique.Box.BoxScenario;
import ComposantGraphique.Box.MenuBarChoixUtilisateur;
import ComposantGraphique.Scroll.ScrollPaneVille;
import ComposantGraphique.Scroll.SrollPaneCli;
import javafx.scene.layout.HBox;
import modele.*;


import java.io.File;
import java.io.IOException;

import static modele.LectureEcriture.lectureScenario;

public class HBoxRoot extends HBox {
    File fichier = new File("E:\\java\\SAé\\ClasseModele\\src\\main\\java\\fichier_txt\\scenario_0.txt");
    Scenario scenario = lectureScenario(fichier);

    static ScrollPaneVille scrollPaneVille = new ScrollPaneVille();
    static SrollPaneCli srollPaneCli = new SrollPaneCli();
    static BoxScenario boxScenario = new BoxScenario();

    MenuBarChoixUtilisateur boxMenu = new MenuBarChoixUtilisateur();

    public HBoxRoot() throws IOException {


        boxScenario.addScenario(scenario);

        scrollPaneVille.setScollVille(scenario);
        srollPaneCli.setScoll(scenario);

        this.getChildren().add(boxMenu.getMenuBar());
        this.getChildren().add(boxScenario.getBox());
        this.getChildren().add(srollPaneCli.getScrollPane());
        this.getChildren().add(scrollPaneVille.getScrollPane());
    }

    public static ScrollPaneVille getScrollPaneVille(){
        return scrollPaneVille;
    }
    public static SrollPaneCli getSrollPaneCli(){
        return srollPaneCli;
    }
    public BoxScenario getBoxScenario(){
        return boxScenario;
    }


}
