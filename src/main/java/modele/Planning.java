package modele;

public class Planning {
    private final int SIZE;
    private Reservation[] chTabReserv;

    public Planning(int parSize) {
        SIZE = parSize;
        chTabReserv = new Reservation[SIZE];
    }

    public Boolean ajout(Reservation parReserv) {

        if (parReserv.getDate().estValide()) {
            for (int i = 0; i < SIZE; i++) {
                if (chTabReserv[i] == null) {
                    chTabReserv[i] = parReserv;
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public Reservation[] getReservations(Date parDate) {
        Reservation[] tab = new Reservation[SIZE];
        int i_tab = 0;
        for (int i = 0; i < SIZE; i++) {
            if (chTabReserv[i] != null) {
                if (chTabReserv[i].getDate().compareTo(parDate) == 0) {
                    tab[i_tab++] = chTabReserv[i];
                }
            }
        }
        return tab;
    }


    public Reservation getReservation(Date parDate) {
        for (int i = 0; i < SIZE; i++) {
            if (chTabReserv[i] != null) {
                if (chTabReserv[i].getDate().compareTo(parDate) == 0) {
                    System.out.println("trouvé " + "\n");
                    return chTabReserv[i];
                }
            }
        }
        return null;
    }

    public int plusAncienneReservation(int parDebut, int parFin) {
        int i_mini = parDebut;
        for (int i = parDebut; i < parFin; i++) {
            if (chTabReserv[i] != null) {
                if (chTabReserv[i].compareTo(chTabReserv[i_mini]) < 0) {
                    i_mini = i;
                }
            }
        }
        return i_mini;

    }

    public String toString() {
        String lStr = new String();
        for (int i = 0; i < SIZE; i++) {
            if (chTabReserv[i] != null) {
                lStr += chTabReserv[i].toString() + "\n";
            }
        }

        return lStr;
    }


}
