package ComposantGraphique.GridPane;

import modele.Scenario;
import modele.VoisinEntrants;

import java.io.IOException;
import java.util.*;

import static modele.Methode.*;
import static modele.VoisinEntrants.tableau;

public class RecupDonnees {

    public static TreeMap<Integer, List<String>> doDic(Scenario scenario) throws IOException {


        TreeMap<String, List<String>> voisinEntrants = doVoisinsEntrant(recupVille_Cli(scenario.getVendeur()), recupVille_Cli(scenario.getAcheteur()));

        VoisinEntrants listEtape = new VoisinEntrants();
        listEtape.conversionTreeMap_List(voisinEntrants);
        tableau(listEtape, 0);
        ListeBlock chemin = new ListeBlock();
        chemin.ajoutEtape(listEtape.getOrdre());
        System.out.println(listEtape);

        List<List<String>> allEtape = new ArrayList<>();
        for (int i=0; i<chemin.get_list().size();i++){
            System.out.println(chemin.get_list().get(i));
            allEtape.add(chemin.get_list().get(i).getVille());
        }

        List<Integer> listDistance =getTrajet(allEtape);
        TreeMap<Integer, List<String>> dictDistance = new TreeMap<>();
        for (int i=0; i<listDistance.size(); i++){
            dictDistance.put(listDistance.get(i), allEtape.get(i));
        }
        System.out.println(dictDistance);

        return dictDistance;
    }

}
