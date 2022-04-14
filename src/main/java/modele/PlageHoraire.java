package modele;

public class PlageHoraire implements Comparable<PlageHoraire> {
    private Horaire chDebut;
    private Horaire chFin;
    private final static int DUREE_MIN = 60;

    //*Initialisation d'un champ final statique*//
    public PlageHoraire(Horaire parDebut, Horaire parFin) {
        chDebut = parDebut;
        chFin = parFin;
    }

    public Horaire duree() {
        int lMiniDebut = chDebut.toMinutes();
        int lMiniFin = chFin.toMinutes();
        int lDureeMinu = lMiniFin - lMiniDebut;
        int lDureeHeure = lDureeMinu / 60;
        int lDureeQuart = lDureeMinu % 60;
        return new Horaire(lDureeHeure, lDureeQuart);
    }

    public boolean coursEstValide() {
        int lMiniDebut = chDebut.toMinutes();
        int lMiniFin = chFin.toMinutes();

        if (lMiniFin > lMiniDebut) {
            if (lMiniFin - lMiniDebut >= DUREE_MIN) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int compareTo(PlageHoraire parPH) {
        if (chFin.toMinutes() < parPH.chDebut.toMinutes()) {
            return -1;
        }
        if (parPH.chFin.toMinutes() < chDebut.toMinutes()) {
            return 1;
        }
        return 0;
    }

    public String toString() {

        return ("Commence à " + chDebut + " et fini à " + chFin + " durée :" + duree() + "mn");
    }
}
