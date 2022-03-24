package modele;

import java.util.TreeSet;
import java.util.Collection;

public class CalendrierDuMois {

    private int mois;
    private int annee;
    private Collection <DateCalendrier> treeSetDate;

    public CalendrierDuMois ( int mois, int annee) {
        this.mois = mois;
        this.annee = annee;
        treeSetDate = new TreeSet <DateCalendrier> ();
        DateCalendrier date = new DateCalendrier (1,mois,annee);
        int indiceJour = date.getNumeroSemaine() ;
        for (int x = indiceJour ; x!=0 ; x--) {
            treeSetDate.add(date);
            date = date.dateDuLendemain();
        }
        date = new DateCalendrier (2,mois,annee);
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

    public Collection <DateCalendrier> getDates() {
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

}
