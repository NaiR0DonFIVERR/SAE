package modele_Prof;

import modele.DateCalendrier;

import java.util.TreeSet;
import java.util.Collection;

public class CalendrierDuMoisProf {

    private int mois;
    private int annee;
    private Collection <DateCalendrierProf> treeSetDate;

    public CalendrierDuMoisProf ( int mois, int annee) {
        this.mois = mois;
        this.annee = annee;
        treeSetDate = new TreeSet <DateCalendrierProf> ();
        DateCalendrierProf date = new DateCalendrierProf (1,mois,annee);
        int indiceJour = date.getNumeroSemaine() ;
        for (int x = indiceJour ; x!=0 ; x--) {
            treeSetDate.add(date);
            date = date.dateDuLendemain();
        }
        date = new DateCalendrierProf (2,mois,annee);
        indiceJour = indiceJour % 7 ;
        while (date.getMois () == mois) {
            while(indiceJour<7) {
                treeSetDate.add(date);
                date = date.dateDuLendemain();
                indiceJour++ ;
            }
            indiceJour=0;
        }
    }

    public Collection <DateCalendrierProf> getDates() {
        return treeSetDate;
    }

    public String toString () {
        return treeSetDate.size() + " " +treeSetDate.toString();
    }

    public int getMois () {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public static void main(String[]arg){
        CalendrierDuMoisProf calend = new CalendrierDuMoisProf(4,2022);
        System.out.println(calend);
    }

}