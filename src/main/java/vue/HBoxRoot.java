package vue;

import ComposantGraphique.Box.BoxScenario;
import ComposantGraphique.Box.MenuBarChoixUtilisateur;
import ComposantGraphique.Scroll.ScrollPaneVille;
import ComposantGraphique.Scroll.ScrollPaneCli;
import Controler.Controler;
import javafx.scene.layout.HBox;
import modele.*;


import java.io.File;
import java.io.IOException;

import static modele.LectureEcriture.lectureScenario;

public class HBoxRoot extends HBox {
    File fichier = new File("E:\\java\\SAé\\ClasseModele\\src\\main\\java\\fichier_txt\\scenario_0.txt");
    File fichier1 = new File("E:\\java\\SAé\\ClasseModele\\src\\main\\java\\fichier_txt\\scenario_1_1.txt");
    Scenario scenario = lectureScenario(fichier);
    Scenario scenario1 = lectureScenario(fichier1);

    static ScrollPaneVille scrollPaneVille = new ScrollPaneVille();
    static ScrollPaneCli srollPaneCli = new ScrollPaneCli();
    static BoxScenario boxScenario = new BoxScenario();
    static Controler controler = new Controler();

    MenuBarChoixUtilisateur boxMenu = new MenuBarChoixUtilisateur();

    public HBoxRoot() throws IOException {


        boxScenario.addScenario(scenario);
        boxScenario.addScenario(scenario1);

        scrollPaneVille.setScollVille(scenario);
        srollPaneCli.setScoll(scenario);


        this.getChildren().add(boxMenu.getMenuBar());
        this.getChildren().add(boxScenario.getBox());
        this.getChildren().add(srollPaneCli.getBoxAll());
        this.getChildren().add(scrollPaneVille.getBoxAll());
    }

    public static ScrollPaneVille getScrollPaneVille(){
        return scrollPaneVille;
    }
    public static ScrollPaneCli getSrollPaneCli(){
        return srollPaneCli;
    }
    public static BoxScenario getBoxScenario(){
        return boxScenario;
    }
    public static Controler getControler(){
        return controler;
    }


}
