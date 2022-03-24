package modele;

public class Date {
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    public Date(int parJour, int parMois, int parAnnee) {
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee;
    }

    //Question 4
    public Date(int parAnnee) {
        chJour = 1;
        chMois = 1;
        chAnnee = parAnnee;
    }

    public Date() {
        //System.out.println("entré le jour");
        //chJour = Clavier.lireInt();
        //System.out.println("entré le mois");
        //chMois = Clavier.lireInt();
        //System.out.println("entré l'année");
        //chAnnee = Clavier.lireInt();

    }

    public boolean estValide() {
        if (chAnnee > 1582) {
            if (chMois > 0 && chMois < 13) {
                if (chJour > 0 && chJour < dernierJourMois(chMois, chAnnee)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    private static boolean estBessextile(int parAnnee) {
        return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0;
    }

    public static int dernierJourMois(int parMois, int parAnnee) {
        switch (parMois) {
            case 2:
                if (estBessextile(parAnnee) == true) return 29;
                else return 28;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public int compareTo(Date parDate) {
        if (chAnnee > parDate.chAnnee) {
            return 1;
        }
        if (chAnnee < parDate.chAnnee) {
            return -1;
        }
        if (chMois > parDate.chMois) {
            return 1;
        }
        if (chMois < parDate.chMois) {
            return -1;
        }
        if (chJour > parDate.chJour) {
            return 1;
        }
        if (chJour < parDate.chJour) {
            return -1;
        } else {
            return 0;
        }
    }

    public Date dateDuLendemain() {
        int jour = chJour + 1;
        int mois = chMois;
        int annee = chAnnee;
        if (jour > dernierJourMois(chMois, chAnnee)) {
            jour = 1;
            mois++;
            if (mois > 13) {
                mois = 1;
                annee++;
            }
        }
        return new Date(jour, mois, annee);
    }

    public Date dateDeLaVeille() {
        int jour = chJour - 1;
        int mois = chMois;
        int annee = chAnnee;
        if (jour <= 0) {
            mois--;
            if (mois <= 0) {
                annee--;
                mois = 12;
                jour = 31;
            } else {
                jour = dernierJourMois(chMois, chAnnee);
            }
        }
        return new Date(jour, mois, annee);
    }

    /*public Date getJourMoisAnnee(){
        ArrayList <Date> jourMoisAnnee = new ArrayList <Date> ();
        jourMoisAnnee.add(chJour);
        jourMoisAnnee.add(chMois);
        jourMoisAnnee.add(chAnnee);
        return jourMoisAnnee;
    }*/

    public int getMois(){
        return chMois;
    }

    public String toString() {
        return chJour + "/" + chMois + "/" + chAnnee;
    }
}
