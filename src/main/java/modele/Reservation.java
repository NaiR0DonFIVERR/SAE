package modele;

public class Reservation implements Comparable<Reservation> { //indique que c'est se comparTo à utilisé
    private String chTitre;
    private DateCalendrier chDate;
    private PlageHoraire chPH;


    public Reservation(String parTitre, DateCalendrier parDate, PlageHoraire parPH) {
        chTitre = parTitre;
        chDate = parDate;
        chPH = parPH;
    }

    public int compareTo(Reservation parReserv) {
        if (chDate.compareTo(parReserv.chDate) != 0) {
            return chDate.compareTo(parReserv.chDate);
        }

        return (chPH.compareTo(parReserv.chPH));
    }


    public DateCalendrier getDate() {
        return chDate;
    }

    public String getTitre() {
        return chTitre;
    }

    public String toString() {
        return ("Nom de cours : " + chTitre + " le " + chDate + " " + chPH);
    }

    /**public String toStringTab(Reservation [] parTab){
     String lStr = new String();

     for (int i = 0; i < parTab.lenght() ; i++){
     if (parTab[i] != null){
     lStr += parTab[i].toString() + "\n";
     }
     }

     return lStr;
     }
     **/
}
