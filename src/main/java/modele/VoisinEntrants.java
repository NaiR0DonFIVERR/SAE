package modele;

import javafx.scene.layout.HBox;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static modele.LectureEcriture.recupVilleIndice;


public class VoisinEntrants {
    List<List<String>> listeVoisinEntrant;
    List<String> ville;
    List<List<String>> ordre;


    public VoisinEntrants(){
        listeVoisinEntrant = new ArrayList<>();
        ville = new ArrayList<>();
        ordre = new ArrayList<>();
    }
    public void conversionTreeMap_List(TreeMap<String, List<String>> dic){
        Set set = dic.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();
            ville.add((String) mentry.getKey());
            listeVoisinEntrant.add((List<String>) mentry.getValue());
        }
    }

    public static VoisinEntrants tableau(VoisinEntrants voisinEntrants, int indiceX){
        VoisinEntrants voisLocal = new VoisinEntrants();

        for (int locVille = 0; locVille < voisinEntrants.getVille().size(); locVille++) {
            voisLocal.getVille().add(new String(voisinEntrants.getVille().get(locVille)));
            voisLocal.getListeVoisinEntrant().add(new ArrayList<>(voisinEntrants.getListeVoisinEntrant().get(locVille)));
        }
        voisLocal.getOrdre().addAll(voisinEntrants.getOrdre());
        for (int i=0; i<voisinEntrants.getListeVoisinEntrant().size(); i++){


            if (voisinEntrants.getListeVoisinEntrant().get(i).size() == 0){
                voisLocal.delete();
                for (int locVille = 0; locVille < voisinEntrants.getVille().size(); locVille++) {
                    voisLocal.getVille().add(voisinEntrants.getVille().get(locVille));
                    voisLocal.getListeVoisinEntrant().add(new ArrayList<>(voisinEntrants.getListeVoisinEntrant().get(locVille)));
                }
                voisLocal.getOrdre().addAll(voisinEntrants.getOrdre());

                //System.out.println("ville sans voisin " + voisinEntrants.getVille().get(i));

                suppString(voisLocal, voisinEntrants.getVille().get(i));
                voisinEntrants.ajoutEtapeTableau(voisinEntrants.getVille().get(i), indiceX,getVoisinNull(voisLocal.getVille(), voisLocal.getListeVoisinEntrant()).size());
                voisLocal.setOrdre(voisinEntrants);
                System.out.println("tests de la recup ordre " + voisLocal.getOrdre());
                tableau(voisLocal, indiceX+1);

            }
        }

        return voisinEntrants;
    }


    public void ajoutEtapeTableau(String ville, int IndiceX, int nombreVoisin){
        if (ordre.size()-1 < IndiceX){
            ordre.add(new ArrayList<>());
        }
        ordre.get(IndiceX).add(ville + " : " +nombreVoisin);
    }

    public static VoisinEntrants suppString(VoisinEntrants voisinEntrants, String ville){
        for (int villes=0; villes<voisinEntrants.getListeVoisinEntrant().size(); villes++){
            //System.out.println(villes);
            if (ville.equals(voisinEntrants.getVille().get(villes))){
                voisinEntrants.getVille().remove(villes);
                voisinEntrants.getListeVoisinEntrant().remove(villes);
            }
            if (villes != voisinEntrants.getListeVoisinEntrant().size()) {
                voisinEntrants.getListeVoisinEntrant().get(villes).remove(ville);
            }
        }
        //System.out.println("ville supprimee " + ville);
        //System.out.println(voisinEntrants.getVille() + "\n" + voisinEntrants.getListeVoisinEntrant());
        return voisinEntrants;
    }



    public static List<String> getVoisinNull(List<String> ville ,List<List<String>> villeVoisin){

        List<String> voisinNull = new ArrayList<>();
        for (int i=0; i<villeVoisin.size(); i++){
            if (villeVoisin.get(i).size()==0){
                voisinNull.add(ville.get(i));
            }
        }
        return voisinNull;
    }

    public void delete(){
        listeVoisinEntrant = new ArrayList<>();
        ville = new ArrayList<>();
        ordre = new ArrayList<>();

    }



    public static void parcourt2(TreeMap<String, List<String>> dic, List<String> chemin){
        if (dic.size() == 0){
            System.out.println(chemin);
            return;
        }
        Set set = dic.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();
            List<String> villeSortante = (List<String>) mentry.getValue();
            if (villeSortante.size() == 0){
                //System.out.println(chemin +" vrai version");
                String ville = (String) mentry.getKey();
                //System.out.println("vide");
                //System.out.println(ville);
                chemin.add(ville);
                TreeMap <String, List<String>> copyDic = copyDic(dic);
                removeDic(copyDic, ville);
                //System.out.println(copyDic);
                //System.out.println(chemin +" vrai version");
                //System.out.println(chemin);
                parcourt2(copyDic, chemin);
                chemin.remove(ville);
            }
        }
    }
    public static TreeMap copyDic(TreeMap<String, List<String>> dicAcpoier){
        TreeMap <String, List<String>> nouvDic = new TreeMap<>();
        Set set = dicAcpoier.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            List<String> villeEntrant= new ArrayList<>();
            List<String> cpoyMentry = (List<String>) mentry.getValue();
            for (String recupVille : cpoyMentry){
                villeEntrant.add(recupVille);
            }
            nouvDic.put((String) mentry.getKey(), villeEntrant);
        }
        return nouvDic;
    }
    public static void removeDic(TreeMap<String, List<String>> dic, String ville){
        dic.remove(ville);
        Set set = dic.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            dic.get(mentry.getKey()).remove(ville);
        }
    }




    /*
    public void setListeVoisinEntrant(List<String> listVen, List<String> listAch){

        for (int y=0; y< listAch.size(); y++) {
            Boolean ajout = true;
            if (ville.size() == 0) {
                ville.add(listAch.get(y));
                listeVoisinEntrant.add(new ArrayList<>());
                listeVoisinEntrant.get(y).add(listVen.get(y));
                ville.add(listVen.get(y));
                listeVoisinEntrant.add(new ArrayList<>());
            }
            else {
                for (int i = 0; i < ville.size(); i++) {
                    if (listVen.get(y).equals(ville.get(i))){
                        ajout = false;
                    }
                    if (listAch.get(y).equals(ville.get(i))) {   //Si la ville est déja stocké
                        listeVoisinEntrant.get(i).add(listVen.get(y));
                        if (ajout){
                            ville.add(listVen.get(y));
                            listeVoisinEntrant.add(new ArrayList<>());
                        }
                        break;
                    }

                    if (i == ville.size()-1 && ville.get(i).equals(listAch.get(y)) == false) {
                        ville.add(listAch.get(y));
                        listeVoisinEntrant.add(new ArrayList<String>());
                        listeVoisinEntrant.get(i+1).add(listVen.get(y));
                        if (ajout){
                            ville.add(listVen.get(y));
                            listeVoisinEntrant.add(new ArrayList<>());
                        }
                        break;
                    }
                }
            }
        }
    }*/

    public void setOrdre(VoisinEntrants voisinEntrants){
        ordre = voisinEntrants.getOrdre();
    }

    public void setVille(List<String> parVille){
        ville = parVille;
    }

    public void setListeVoisinEntrant(List<List<String>> parVoisin){
        listeVoisinEntrant = parVoisin;
    }

    public List<String> getVille(){
        return ville;
    }

    public List<List<String>> getListeVoisinEntrant(){
        return listeVoisinEntrant;
    }

    public List<List<String>> getOrdre(){
        return ordre;
    }

    public String toString() {
        return "Voisin entrant : "+listeVoisinEntrant + "\n" + "Ville : "+ville + "\n" + "Etape : " +ordre;
    }
}
