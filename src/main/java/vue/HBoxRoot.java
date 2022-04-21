package vue;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.*;


import java.io.File;
import java.io.IOException;
import java.util.*;

import static modele.LectureEcriture.*;
import static modele.Methode.*;
import static modele.VoisinEntrants.*;

public class HBoxRoot extends HBox {
    File fichier = new File("E:\\java\\SAé\\ClasseModele\\src\\main\\java\\fichier_txt\\scenario_0.txt");
    Scenario scenario = lectureScenario(fichier);

    List listeVilleAcheteur = recupVille_Cli(scenario.getAcheteur());
    List listeVilleVendeur = recupVille_Cli(scenario.getVendeur());

    TreeMap <String, List<String>> voisinEntrants = doVoisinsEntrant(listeVilleVendeur, listeVilleAcheteur);
    TreeMap <String, List<String>> voisinSortants = doVoisinsEntrant(listeVilleAcheteur, listeVilleVendeur);


    HBox boxVend_Ach = new HBox();
    HBox boxVille = new HBox();
    HBox boxBouton = new HBox();

    Button boutonMont = new Button("Monter");
    Button boutonBas = new Button("Descendre");
    Button boutonAligner = new Button("Aligner");


    //ScrollPane scrollCli_Ville = doScrollValeurMultiple(scenario.getVendeur(), scenario.getAcheteur(), listeVilleVendeur, listeVilleAcheteur);
    ScrollPane scrollVend_ach = doDoubleScrool(scenario.getVendeur(), scenario.getAcheteur());
    ScrollPane scrollVill = doDoubleScrool(listeVilleVendeur, listeVilleAcheteur);
    public HBoxRoot() throws IOException {


        System.out.println(voisinEntrants);
        //System.out.println(voisinSortants);
        //System.out.println(doEtape(voisinEntrants, new ArrayList<>()));
        //System.out.println(doEtape(voisinEntrants, new ArrayList<>()));
        //List<String> sansVoisin = getVilleSansVoisinENtrant(voisinEntrants);
        //List<List<String>> test = new ArrayList<>();

        VoisinEntrants voisinTest = new VoisinEntrants();
        voisinTest.conversionTreeMap_List(voisinEntrants);
        System.out.println(voisinTest);

        tableau(voisinTest, 0);
        System.out.println(voisinTest);
        ///List<List<String>> etape = voisinTest.recupOrdreTableau();
        //List<List<String>> etape = voisinTest.parcourTableauLenvers();
        /*Matrice matrice = new Matrice();
        matrice.initialisationMatrice(voisinTest.getOrdre().get(voisinTest.getOrdre().size()-1).size());
        matrice.setMatrice(voisinTest.getOrdre());
        matrice.getVoisinSortant(voisinTest.getOrdre().get(4), voisinTest.getOrdre().get(5));*/

        ListeBlock chemin = new ListeBlock();
        chemin.ajoutEtape(voisinTest.getOrdre());
        System.out.println(chemin.get_list());
        List<List<String>> allEtape = new ArrayList<>();


        for (int i=0; i<chemin.get_list().size();i++){
            System.out.println(chemin.get_list().get(i));
            allEtape.add(chemin.get_list().get(i).getVille());
        }
        //VBox boxEtape = getBoxOrdre(allEtape);
        List<Integer> listDistance =getTrajet(allEtape);
        TreeMap<Integer, List<String>> dictDistance = new TreeMap<>();
        for (int i=0; i<listDistance.size(); i++){
            dictDistance.put(listDistance.get(i), allEtape.get(i));
        }
        VBox boxEtape = getBoxOrdreDic(dictDistance);
        //lectureTableau(etape);
        //System.out.println(getOrdre_List3(voisinTest, VoisinEntrants.getVoisinNull(voisinTest.getVille(), voisinTest.getListeVoisinEntrant()),0));
        //System.out.println(getOrdre_List2(voisinTest, voisinTest.getVoisinNull(voisinTest.getVille(), voisinTest.getListeVoisinEntrant()), 0));
        //System.out.println(getOrdre(voisinEntrants, sansVoisin, test, 0));

        /*
        VBox boxAcheteur = new VBox();
        VBox boxVendeur = new VBox();
        VBox boxComboAcheteur = new VBox();
        VBox boxVilleAcheteur = new VBox();
        VBox boxVilleVendeur = new VBox();
        */
        /*
        ScrollPane scrollAcheteur = doScroll(scenario.getAcheteur());
        ScrollPane scrollVendeur = doScroll(scenario.getVendeur());
        ScrollPane scrollVilleAch = doScroll(listeVilleAcheteur);
        ScrollPane scrollVilleVend = doScroll(listeVilleVendeur);
        */

        //ComboBox comboBox = setCombo(scenario.getAcheteur());

        /*
        boxVilleAcheteur.getChildren().addAll(new Label("Ville des acheteur "),scrollVilleAch);
        boxVilleVendeur.getChildren().addAll(new Label("Ville des vendeurs "), scrollVilleVend);
        boxVendeur.getChildren().addAll(new Label("Liste des vendeurs "), scrollVendeur);
        boxAcheteur.getChildren().addAll(new Label("Ville des acheteur "), scrollAcheteur);
        */



        boutonMont.setOnAction(evt ->{
            moveScrollPaneHaut();
        });
        boutonBas.setOnAction(evt ->{
            moveScrollPaneBas();
        });
        boutonAligner.setOnAction(evt ->{
            alignerScroll();
        });


        ScrollPane scrollEtape = new ScrollPane();
        //scrollEtape.setContent(boxEtape);
        //boxEtape = getBoxOrdre(etape);

        //List<String> indice = lectureDistance("Amiens", "Velizy");
        //recupDistance(indice);
        //getTrajet(etape);


        boxBouton.getChildren().addAll(boutonBas, boutonAligner, boutonMont);
        boutonBas.setId("BoutonBas");
        boutonMont.setId("BoutonHaut");
        boutonAligner.setId("BoutonAligner");

        boxVend_Ach.getChildren().add(scrollVend_ach);
        boxVille.getChildren().add(scrollVill);
        this.getChildren().add(boxVend_Ach);
        this.getChildren().add(boxBouton);
        this.getChildren().add(boxVille);
        this.getChildren().add(boxEtape);


    }
    public void moveScrollPaneHaut(){

        double objet = scrollVend_ach.getVvalue()-0.1;
        scrollVend_ach.setVvalue(objet);
        scrollVill.setVvalue(objet);
    }
    public void moveScrollPaneBas(){

        double objet = scrollVend_ach.getVvalue()+0.1;
        scrollVend_ach.setVvalue(objet);
        scrollVill.setVvalue(objet);
    }
    public void alignerScroll(){
        scrollVill.setVvalue(scrollVend_ach.getVvalue());
    }


    /*
    public TreeMap<String, List<String>> doVoisinsEntrant(List<String> listVend, List<String> listAch){
        TreeMap<String, List<String>> listVoisinSortant = new TreeMap<>();
        for (int i = 0; i< listVend.size(); i++){

            //On récupère les cles et valeurs de notre dictionnaire
            Set set = listVoisinSortant.entrySet();
            Iterator iterator = set.iterator();
            //On les parcours
            while (iterator.hasNext()){
                Map.Entry mentry = (Map.Entry)iterator.next();
                //Si on a déjà un voisin entrant, on récupère la valeur du dictionnaire pour ajouter le nouveau voisin
                if (mentry.getKey().equals(listAch.get(i))){
                    listVoisinSortant.get(mentry.getKey()).add(listVend.get(i));
                }
            }
            //Ajout d'une valeur si le dictionnaire ne possède pas la clef
            if (listVoisinSortant.get(listAch.get(i)) == null){
                listVoisinSortant.put(listAch.get(i), new ArrayList<String>(Collections.singleton(listVend.get(i))));
            }
            if (listVoisinSortant.get(listVend.get(i)) == null){
                listVoisinSortant.put(listVend.get(i), new ArrayList<>());
            }

        }
        return listVoisinSortant;
    }
    */

    //Retourn une liste de ville avec leurs nombres de voisins entrant -> Paris:2
    /*
    public List<Object> doNombreVoisinEntrant(TreeMap<String, List<String>> parVoisinEntrant){
        List<Object> nbVoisinEntrant = new ArrayList<>();
        Set<String> keys = parVoisinEntrant.keySet();
        for (String key : keys){
            nbVoisinEntrant.add(key + ":" + parVoisinEntrant.get(key).size());
        }
        return  nbVoisinEntrant;
    }
    */

    /*
    public List<String> doEtapee (TreeMap<String, List<String>> parVoisinEntrant, List<String> ordre){
        Integer ETAPES = 0;
        Set set = parVoisinEntrant.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            ETAPES ++;
            System.out.println(ETAPES);
            if (parVoisinEntrant.get(mentry.getKey()).size() == 0){
                System.out.println("Taille null pour " + mentry.getKey());
                System.out.println("Avant " + parVoisinEntrant);
                parVoisinEntrant.remove(mentry.getKey());
                System.out.println("Apres " + parVoisinEntrant);
                ordre.add((String) mentry.getKey());
                System.out.println(ordre);
                Set<String> keys = parVoisinEntrant.keySet();
                for (String key : keys){
                    for (String ville : parVoisinEntrant.get(key)){
                        if (ville.equals(mentry.getKey())){
                            System.out.println("Avant supp " + parVoisinEntrant);
                            parVoisinEntrant.get(key).remove(ville);
                            System.out.println("Apres suppr " + parVoisinEntrant);
                            doEtape(parVoisinEntrant, ordre);
                            break;
                        }

                    }

                }
                break;
            }
        }


        return null;
    }
    */
    /*public List<String> doEtape(TreeMap<String, List<String>> parVoisinEntrant, List<String> ordre){
        Set set = parVoisinEntrant.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (parVoisinEntrant.get(mentry.getKey()).size() == 0){
                //System.out.println("Sans Voisin pour " + mentry.getKey());
                //System.out.println("avant suppr" + parVoisinEntrant);
                ordre.add((String) mentry.getKey());
                parVoisinEntrant.remove(mentry.getKey());
                //System.out.println("apres suppr" + parVoisinEntrant);
                parVoisinEntrant = removeVille(parVoisinEntrant, (String) mentry.getKey());
                //System.out.println("appre appres " + parVoisinEntrant);
                break;
            }
        }
        if (parVoisinEntrant.size() != 0){
            doEtape(parVoisinEntrant, ordre);
        }
        return ordre;
    }*/
    /*
    public TreeMap<String, List<String>> removeVille(TreeMap<String, List<String>> dicVille, String villeRemove){
        Set <String> keys = dicVille.keySet();
        for (String key : keys){
            for (String ville : dicVille.get(key)){
                if (ville.equals(villeRemove)){
                    dicVille.get(key).remove(ville);
                    break;
                }
            }
        }
        return dicVille;
    }

     */
    /*public List<String> getVilleSansVoisinENtrant(TreeMap<String, List<String>> parVoisinEntrant){
        List<String> cleVille = new ArrayList<>();
        Set<String> keys = parVoisinEntrant.keySet();
        for (String key : keys){
            if (parVoisinEntrant.get(key).size() == 0){
                cleVille.add(key);
            }
        }
        return cleVille;
    }

     */
    /*
    public List<List<String>> getOrdre(TreeMap<String, List<String>> parVoisinEntrant, List<String> clesVille, List<List<String>> ordre, Integer i){

        for (String cleVille : clesVille){
            TreeMap<String, List<String>> dicLocal = new TreeMap<>();
            Set <String> keys = parVoisinEntrant.keySet();
            //Cette etape est obligatoir pour créer un dictionnaire indépendant
            //Mettre dicLocal = parVoisinEntrant signifirai de modifier les deux dictionnaire en même temps
            for (String key : keys) {
                dicLocal.put(key, new ArrayList<>());
                for (String ville : parVoisinEntrant.get(key)) {
                    dicLocal.get(key).add(ville);
                }
            }
            //System.out.println("Etape " + i +ordre);
            //System.out.println(dicLocal);
            //System.out.println("vill supr " + cleVille);
            dicLocal.remove(cleVille);
            dicLocal = removeVille(dicLocal, cleVille);
            //System.out.println(dicLocal);
            if (clesVille.size()>1 || ordre.size() == 0 ) {
                ordre.add(new ArrayList<>());
                //System.out.println("Sauuuuv " + dicLocal);
            }
            ordre.get(i).add(cleVille);
            System.out.println("Etape "+ordre);
            List<String> listVille = getVilleSansVoisinENtrant(dicLocal);
            System.out.println("Ville restante sans voisins "+listVille);
            ordre  = getOrdre(dicLocal, listVille, ordre, i);
            System.out.println(i);
            i++;
        }
        return ordre;
    }*/


}
