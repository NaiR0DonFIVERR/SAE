package vue;

import ComposantGraphique.Box.*;
import ComposantGraphique.Box.BoxAfficheChemin.*;
import ComposantGraphique.Box.BoxSwitch.StackPaneChoixUtilisateur;
import ComposantGraphique.Scroll.ScrollPaneVille;
import ComposantGraphique.Scroll.ScrollPaneCli;
import Controler.Controler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.*;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static modele.LectureEcriture.lectureScenario;
import static modele.VariableLoc.getListVilleAch;
import static modele.VariableLoc.getListVilleVend;

public class VBoxRoot extends VBox {


    static ScrollPaneVille scrollPaneVille = new ScrollPaneVille();
    static ScrollPaneCli srollPaneCli = new ScrollPaneCli();
    static BoxScenario boxScenario = new BoxScenario();
    static Controler controler = new Controler();
    //static VariableLoc variableLoc = new VariableLoc();
    static DicVille dicVille = new DicVille();
    static StackPaneAfficheChemin stackPaneAfficheChemin = new StackPaneAfficheChemin();
    static StackPaneChoixChemins stackPaneChoixChemins = new StackPaneChoixChemins();
    static MenuBarChoixUtilisateur boxMenu = new MenuBarChoixUtilisateur();
    static HBox box_boxMenu_stackPane = new HBox();
    static StackPaneChoixUtilisateur stackPaneChoixUtilisateur = new StackPaneChoixUtilisateur();


    public VBoxRoot() throws IOException {
        File[] fichierScenario = new File("src/main/java/fichier_txt").listFiles();
        for (File fichier : fichierScenario){
            Scenario scenario = lectureScenario(fichier);

            boxScenario.addScenario(scenario);
        }
        dicVille.setDicVille(boxScenario.getScenarioList().get(0).getVendeur(), boxScenario.getScenarioList().get(0).getAcheteur());
        dicVille.doChemin(dicVille.getDicVille(), new ArrayList<>());
        //System.out.println(dicVille.getListChemin());
        //vBoxChemin.setAllChemin(dicVille.getListChemin());
        //vBoxTroisChemins.setBoxAll();
        stackPaneAfficheChemin.setStackPane(dicVille.getListChemin());
        stackPaneChoixUtilisateur.setStackPane();


        System.out.println(boxScenario.getScenarioList().get(2));
        scrollPaneVille.setScollVille(boxScenario.getScenarioList().get(2));
        srollPaneCli.setScoll(boxScenario.getScenarioList().get(2));
        HBox boxRegroup = new HBox();
        boxRegroup.getChildren().add(boxScenario);
        HBox boxScroll = new HBox(srollPaneCli,scrollPaneVille);boxScroll.setId("boxScroll");
        boxRegroup.getChildren().add(boxScroll);
        boxRegroup.setId("boxRegroup");
        boxRegroup.setMaxSize(500,200);

        //stackPaneChoixChemins.setStackPane();
        //box_boxMenu_stackPane.getChildren().addAll(gridPaneChoixAfficheChemin.getGridPane(),stackPaneChoixChemins.getStackPane());
        /*StackPane stackPane = (StackPane) stackPaneChoixChemins.getStackPane().getChildren().get(2);
        System.out.println(stackPane.getChildren());
        System.out.println(stackPaneChoixChemins.getStackPane().getChildren());
*/
        this.getChildren().add(boxMenu.getMenuBar());
        this.getChildren().add(boxRegroup);
        this.getChildren().add(stackPaneChoixUtilisateur.getStackPane());
        this.setId("boxRoot");
        //this.getChildren().add(box_boxMenu_stackPane);
        //this.getChildren().add(vBoxChemin.getBoxAll());
        //this.getChildren().add(vBoxTroisChemins.getBoxAll());
        //this.getChildren().add(gridPaneChoixAfficheChemin.getGridPane());
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
    /*public static VariableLoc getVariableLoc(){
        return variableLoc;
    }*/
    public static DicVille getDicVille(){
        return dicVille;
    }
    public static HBox getBox_boxMenu_stackPane(){
        return box_boxMenu_stackPane;
    }
    public static StackPaneAfficheChemin getStackPaneAfficheChemin(){
        return stackPaneAfficheChemin;
    }
    public static StackPaneChoixChemins getStackPaneChoixChemins(){ return stackPaneChoixChemins; }
    public static StackPaneChoixUtilisateur getStackPaneChoixUtilisateur(){ return stackPaneChoixUtilisateur;}



}
