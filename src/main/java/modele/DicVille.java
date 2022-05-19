package modele;

import java.util.*;

import static Calcule.Calcul.doVoisinsEntrant;

public class DicVille {

    static TreeMap<String, List<String>> dicVille;
    static List<List<String>> listChemin;

    public DicVille(){
        dicVille = new TreeMap<>();
        listChemin = new ArrayList<>();
    }

    public void setDicVille(List<String> listVilleVend, List<String> listVilleAch){
        dicVille = doVoisinsEntrant(listVilleVend, listVilleAch);
    }

    public static void addChemin(List<String> chemin){
        listChemin.add(chemin);
    }

    public List<List<String>>getListChemin(){
        return listChemin;
    }

    public TreeMap<String, List<String>> getDicVille(){
        return dicVille;
    }

    public static void delet(){
        dicVille = new TreeMap<>();
        listChemin = new ArrayList<>();
    }

    public String toString(){
        return dicVille + "\n" + listChemin;
    }


}
