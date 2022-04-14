package modele;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Planning  {

    private Map<Integer, Set<Reservation>> chTreeMapReservations ;

    public Planning() {
        chTreeMapReservations = new TreeMap<>();
    }

    /**  à compléter
     *
     *
     *
     */
    public boolean ajout (Reservation parReservation)   {

        int numSemaine = ((DateCalendrier)parReservation.getDate()).getWeekOfYear();
        Set <Reservation> set = chTreeMapReservations.get(numSemaine);
        if (set==null) {
            set = new TreeSet<>();
            set.add(parReservation);
            chTreeMapReservations.put(numSemaine, set);
        }
        else {
            set.add(parReservation);
        }
        return true;
    }


    /** retourne un ensemble contenant toutes les réservations de la semaine de numero parWeekOfYear
     *
     * @param parWeekOfYear le numéro de la semaine
     * @return le treeSet des réservations de la semaine de numéro parWeekOfYear
     */
    public Set <Reservation> getReservations (int parWeekOfYear) {
        return  chTreeMapReservations.get(parWeekOfYear);
    }

    public String toString() {
        return "treeMap " + chTreeMapReservations.size() + " - "+ chTreeMapReservations + "\n" ;
    }

}