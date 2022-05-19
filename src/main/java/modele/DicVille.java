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


    public void doChemin(TreeMap<String, List<String>> dic, List<String> chemin){
        if (dic.size() == 0){
            listChemin.add(chemin);
            System.out.println(chemin);
            return;
        }
        Set set = dic.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();
            List<String> villeSortante = (List<String>) mentry.getValue();
            if (villeSortante.size() == 0){
                String ville = (String) mentry.getKey();
                chemin.add(ville);
                TreeMap <String, List<String>> copyDic = copyDic(dic);
                removeDic(copyDic, ville);
                doChemin(copyDic, chemin);
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
    public static void removeDic(TreeMap<String, List<String>> dic, String ville) {
        dic.remove(ville);
        Set set = dic.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            dic.get(mentry.getKey()).remove(ville);
        }
    }

    public static TreeMap<String, List<String>> doVoisinsEntrant(List<String> listVend, List<String> listAch){
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

    public static List<List<String>>getListChemin(){
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
