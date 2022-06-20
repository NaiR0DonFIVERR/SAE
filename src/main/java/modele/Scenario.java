package modele;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Scenario {

    List<String> vendeur;
    List<String> acheteur;

    public Scenario(){
        vendeur = new ArrayList<>();
        acheteur = new ArrayList<>();
    }

    public Scenario(List<String> parListVend, List<String> parListAch){
        vendeur = new ArrayList<>(new ArrayList<>(parListVend));
        acheteur = new ArrayList<>(new ArrayList<>(parListAch));
    }

    public void ajoutVendeurAcheteur(String parVendeur, String parAcheteur){
        vendeur.add(parVendeur);
        acheteur.add(parAcheteur);
    }


    public List<String> getVendAch(int i){
        List<String> list = new ArrayList<>();
        list.add(getVendeur().get(i));
        list.add(getAcheteur().get(i));
        return list;
    }

    public List<String> getVendeur() {
        return vendeur;
    }

    public List<String> getAcheteur() {
        return acheteur;
    }

    public String toString() {
        return vendeur + "\n" + acheteur;
    }
}
