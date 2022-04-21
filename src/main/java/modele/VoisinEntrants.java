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

    /*public static List<List<String>> getOrdre_List(VoisinEntrants voisinEntrants){
        List<String> ville = voisinEntrants.getVille();
        List<List<String>> villeVoisin = voisinEntrants.getListeVoisinEntrant();

        for (int i=0; i<ville.size(); i++){
            if (villeVoisin.get(i).size() == 0){
                System.out.println(voisinEntrants.getVille().size() +" " + voisinEntrants.getListeVoisinEntrant().size());
                System.out.println("valeur null pour " + ville.get(i));
                System.out.println("On ajoute " + ville.get(i) + " en etape");
                //ajoutEtape(voisinEntrants, ville.get(i), 0);
                System.out.println(voisinEntrants.getOrdre() + " puis on le supprime de la liste");
                System.out.println(supp(voisinEntrants, i));
                System.out.println("fin suppr");
                System.out.println(getVoisinNull(voisinEntrants.getVille(), voisinEntrants.getListeVoisinEntrant()));
                break;
            }
        }
        return null;
    }*/
    public static List<List<String>> getOrdre_List2(VoisinEntrants voisinEntrants, List<String> villeSansVoisin, int INDICE){
        List<String> ville = voisinEntrants.getVille();
        List<List<String>> villeVoisin = voisinEntrants.getListeVoisinEntrant();
        if (villeSansVoisin.size()==0){
            return villeVoisin;
        }
        while (villeSansVoisin.size()!=0){
            String villeRec = villeSansVoisin.get(0);
            for (int i= 0; i<ville.size(); i++){
                if (villeRec.equals(ville.get(i))) {
                    System.out.println(voisinEntrants.getVille().size() + " " + voisinEntrants.getListeVoisinEntrant().size());
                    System.out.println("valeur null pour " + ville.get(i));
                    System.out.println("On ajoute " + ville.get(i) + " en etape");
                    ajoutEtape(voisinEntrants,new ArrayList<>(Collections.singleton(ville.get(i))) , INDICE);
                    System.out.println(voisinEntrants.getOrdre() + " puis on le supprime de la liste");
                    System.out.println(supp(voisinEntrants, i));
                    System.out.println("fin suppr");
                    villeSansVoisin.remove(villeRec);
                    if (villeSansVoisin.size()>1) {
                        INDICE = INDICE + villeSansVoisin.size()-1;
                    }
                    if (INDICE != 0){
                        System.out.println("testeeeeee");
                        ajoutEtape(voisinEntrants, voisinEntrants.getOrdre().get(INDICE-1), INDICE);
                        System.out.println(voisinEntrants);
                    }
                    System.out.println(INDICE);
                    System.out.println(villeSansVoisin = getVoisinNull(voisinEntrants.getVille(), voisinEntrants.getListeVoisinEntrant()));

                    break;
                }
            }
        }
        return null;
    }

    /*public static VoisinEntrants getOrdre_List3(VoisinEntrants voisinEntrants, List<String> villeSansVoisin, int ETAPE){

        VoisinEntrants voisinLoc = new VoisinEntrants();

        if (villeSansVoisin.size()==0){
            return voisinEntrants;
        }
        else {
            villeSansVoisin = getVoisinNull(voisinEntrants.getVille(), voisinEntrants.getListeVoisinEntrant());
            while (villeSansVoisin.size() != 0) {

                ETAPE = ETAPE + villeSansVoisin.size() - 1;
                System.out.println(ETAPE);
                System.out.println("ville sans voisin " + villeSansVoisin);
                String uneVille = villeSansVoisin.get(0);
                System.out.println("la 1er ville a suppr " + uneVille);
                //Recupère les valeurs
                for (int locVille = 0; locVille < voisinEntrants.getVille().size(); locVille++) {
                    voisinLoc.getVille().add(voisinEntrants.getVille().get(locVille));
                    voisinLoc.getListeVoisinEntrant().add(voisinEntrants.getListeVoisinEntrant().get(locVille));
                }
                voisinLoc.getOrdre().addAll(voisinEntrants.getOrdre());
                System.out.println("Verification des valeur " + "\n" + voisinLoc);
                for (int y = 0; y < voisinLoc.getVille().size(); y++) {

                    if (uneVille.equals(voisinLoc.getVille().get(y))) {
                        if (villeSansVoisin.size() >= 2) {
                            for (int taille = 0; taille < villeSansVoisin.size() - 1; taille++) {
                                System.out.println("plusieur ville sans voisin ");
                                if (voisinLoc.getOrdre().size()==0){
                                    voisinLoc.getOrdre().add(new ArrayList<>());
                                }
                                else {
                                    voisinLoc.getOrdre().add(new ArrayList<>(voisinLoc.getOrdre().get(ETAPE - 1)));
                                }
                                System.out.println(voisinLoc);
                            }
                        }
                        System.out.println("ville sans voisin " + voisinLoc.getVille().get(y));
                        ajoutEtape(voisinLoc, new ArrayList<>(Collections.singleton(uneVille)), ETAPE);
                        supp(voisinLoc, y);
                        System.out.println("valeur apres suppr " + voisinLoc);
                        villeSansVoisin.remove(0);

                        //System.out.println("Ville sans voisin " + villeSansVoisin);
                        voisinLoc = getOrdre_List3(voisinLoc, getVoisinNull(voisinLoc.getVille(), voisinLoc.getListeVoisinEntrant()), ETAPE);

                    }


                }


            }
        }

        return voisinLoc;
    }*/

    public static VoisinEntrants parcourtSimple(VoisinEntrants voisinEntrants, int INDICE){

        VoisinEntrants voisLocal = new VoisinEntrants();
        int supple = -1;
        for (int locVille = 0; locVille < voisinEntrants.getVille().size(); locVille++) {
            voisLocal.getVille().add(new String(voisinEntrants.getVille().get(locVille)));
            voisLocal.getListeVoisinEntrant().add(new ArrayList<>(voisinEntrants.getListeVoisinEntrant().get(locVille)));
        }
        voisLocal.getOrdre().addAll(voisinEntrants.getOrdre());
        for (int i=0; i<voisinEntrants.getListeVoisinEntrant().size(); i++){


            if (voisinEntrants.getListeVoisinEntrant().get(i).size() == 0){
                supple ++;
                System.out.println("etape " + INDICE);

                voisLocal.delete();
                for (int locVille = 0; locVille < voisinEntrants.getVille().size(); locVille++) {
                    voisLocal.getVille().add(voisinEntrants.getVille().get(locVille));
                    voisLocal.getListeVoisinEntrant().add(new ArrayList<>(voisinEntrants.getListeVoisinEntrant().get(locVille)));
                }
                voisLocal.getOrdre().addAll(voisinEntrants.getOrdre());
                System.out.println(INDICE);
                INDICE = INDICE + supple;
                System.out.println("ville sans voisin " + voisinEntrants.getVille().get(i) + INDICE);

                suppString(voisLocal, voisinEntrants.getVille().get(i));
                ajoutEtape(voisinEntrants, new ArrayList<>(Collections.singleton(voisinEntrants.getVille().get(i))), INDICE );
                voisLocal.setOrdre(voisinEntrants);
                System.out.println("tests de la recup ordre " + voisLocal.getOrdre());
                parcourtSimple(voisLocal, INDICE);





            }
        }
        return voisinEntrants;
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
                //System.out.println("tests de la recup ordre " + voisLocal.getOrdre());
                tableau(voisLocal, indiceX+1);

            }
        }

        return voisinEntrants;
    }

    public  List<List<String>> MAJ_Tableau() throws IOException {
        List<List<String>> etape = new ArrayList<>();
        for (int i=0;i< ordre.size();i++){
            List<String> recup = ordre.get(i);
            //System.out.println(i);

            for (int y=0; y< recup.size();y++){
                String ville = recupVilleIndice(Collections.singletonList(recup.get(y))).get(0);
                int nb_voisin = Integer.parseInt(recupVilleIndice(Collections.singletonList(recup.get(y))).get(1));
                //System.out.println(ville + " " + nb_voisin);
            }
        }

        return etape;
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



    public static VoisinEntrants supp(VoisinEntrants voisinEntrants, int i){
        String ville = voisinEntrants.getVille().get(i); //Récupère la ville qui doit être supprimé
        voisinEntrants.getVille().remove(i);    //Supprime la ville de la liste
        voisinEntrants.getListeVoisinEntrant().remove(i);   //Supprime la liste vide de cette liste
        for (int y =0; y< voisinEntrants.getListeVoisinEntrant().size(); y++){  //Parcourt des listes
            voisinEntrants.getListeVoisinEntrant().get(y).remove(ville);
        }
        //System.out.println("ville supprimee " + ville);
        //System.out.println(voisinEntrants.getVille() + "\n" + voisinEntrants.getOrdre());
        return voisinEntrants;
    }

    public static VoisinEntrants ajoutEtape(VoisinEntrants voisinEntrants, List<String> ville, int i){
        if (voisinEntrants.getOrdre().size() -1 <i || voisinEntrants.getOrdre().size() == 0){
            voisinEntrants.getOrdre().add(new ArrayList<>());
        }

        for (String villes : ville) {
            //System.out.println( "Ville ajout "+villes + " " + i);
            //System.out.println("avant ajout de la ville : "+voisinEntrants.getOrdre());
            voisinEntrants.getOrdre().get(i).add(villes);
        }
        //System.out.println(voisinEntrants.getOrdre());
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

    public List<List<String>> recupOrdreTableau() throws IOException {

        List<List<String>> etape = new ArrayList<>();

        for (int i=0; i<ordre.size();i++){

            List<String> recup = ordre.get(i);

            for (int y = 0; y < ordre.get(i).size(); y++) {

                if (etape.size()==0){
                    etape.add(new ArrayList<>());
                }
                String ville = recupVilleIndice(Collections.singletonList(recup.get(y))).get(0);
                int nb_voisin = Integer.parseInt(recupVilleIndice(Collections.singletonList(recup.get(y))).get(1));
                etape.get(y).add(ville);
                if (nb_voisin>1){
                    for (int z=0; z<nb_voisin-1;z++){
                        etape.add(new ArrayList<>(etape.get(y)));
                    }
                }
                //System.out.println("Chemin " + y);
                //System.out.println(recupVilleIndice(Collections.singletonList(recup.get(y))));
            }
        }
        //System.out.println(etape.size());
        return etape ;
    }

    public List<List<String>> parcourTableauLenvers() throws IOException {

        List<List<String>> etape = new ArrayList<>();

        for (int i=ordre.size()-1; i!=-1;i--){
            Boolean AJOUTDERNIEREVALEUR = false;
            if (etape.size()==0){
                AJOUTDERNIEREVALEUR = true;
            }
            List<String> recup = ordre.get(i);
            System.out.println(recup);
            int supple = 0;
            for (int y = 0; y < recup.size(); y++) {
                if (AJOUTDERNIEREVALEUR){
                    String ville = recupVilleIndice(Collections.singletonList(recup.get(y))).get(0);
                    etape.add(new ArrayList<String>(Collections.singleton(ville)));

                }
                else {

                    String ville = recupVilleIndice(Collections.singletonList(recup.get(y))).get(0);
                    int nb_voisin = Integer.parseInt(recupVilleIndice(Collections.singletonList(recup.get(y))).get(1));
                    int nb_voisinprec = Integer.parseInt(recupVilleIndice(Collections.singletonList(ordre.get(i+1).get(y))).get(1));
                    for (int z=1; z<nb_voisin+nb_voisinprec-1;z++){
                        etape.get(y+supple).add(ville);

                        supple++;
                    }
                    System.out.println(y + " "+ supple);
                    etape.get(y+supple).add(ville);
                    System.out.println(etape);

                    System.out.println("Chemin " + y);
                    //System.out.println(recupVilleIndice(Collections.singletonList(recup.get(y))));
                }
            }
            System.out.println(etape);

        }
        System.out.println(etape);
        return etape ;
    }


    public static void lectureTableau(List<List<String>> tableau){
        for (int i=0; i<tableau.size(); i++){
            System.out.println("Chemin " + i + "\n" +tableau.get(i)+"\n"+ "de taille : " + tableau.get(i).size());
        }
    }

    public static void nouvelVersion(VoisinEntrants voisinEntrants,List<String> chemin){

        if (voisinEntrants.getVille().size() == 0){
            return;
        }
        VoisinEntrants recupVoisin = new VoisinEntrants();
        recupVoisin.setListeVoisinEntrant(voisinEntrants.getListeVoisinEntrant());
        recupVoisin.setVille(voisinEntrants.getVille());
        for (int i=0; i<recupVoisin.getListeVoisinEntrant().size();i++){
            System.out.println(i);
            System.out.println(chemin);
            if (recupVoisin.getListeVoisinEntrant().get(i).size() == 0){
                System.out.println(recupVoisin.getVille().get(i));
                String ville = recupVoisin.getVille().get(i);
                chemin.add(ville);
                for (int y=0; y<recupVoisin.getListeVoisinEntrant().size(); y++){
                    recupVoisin.getListeVoisinEntrant().get(y).remove(ville);   //Supprimer la ville
                }
                recupVoisin.getVille().remove(i);
                recupVoisin.getListeVoisinEntrant().remove(i);
                nouvelVersion(recupVoisin, chemin);
            }
        }
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
