package modele;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static modele.LectureEcriture.recupVille;

public class VariableLoc {

    static List<String> listVilleVend;
    static List<String> listVilleAch;

    public VariableLoc(){
        listVilleVend = new ArrayList<>();
        listVilleAch = new ArrayList<>();
    }

    public void setVariable(Scenario scenario) throws IOException {
        listVilleAch = new ArrayList<>();
        listVilleVend = new ArrayList<>();
        for (int i=0; i<scenario.getAcheteur().size(); i++) {
            listVilleAch.add(recupVille(scenario.getAcheteur().get(i)));
            listVilleVend.add(recupVille(scenario.getVendeur().get(i)));
        }
    }

    public static List<String> getListVilleVend(){
        return listVilleVend;
    }
    public static List<String> getListVilleAch(){
        return listVilleAch;
    }
    public String toString(){
        return listVilleVend + "\n" +listVilleAch;
    }

}
