package modele_Prof;
import java.util.Calendar;

public class DateCalendrierProf extends DateProf implements Comparable <DateProf> ,ConstantesCalendrier {

    private int jourSemaine;
    private int weekOfYear ;

    /** retourne la date d'aujourd'hui
     *
     */
    public DateCalendrierProf ()   {
        // GregorianCalendar dateAuj = new GregorianCalendar ();
        Calendar dateAuj = Calendar.getInstance();
        chAnnee = dateAuj.get (Calendar.YEAR);
        chMois = dateAuj.get (Calendar.MONTH) + 1;
        chJour = dateAuj.get (Calendar.DAY_OF_MONTH);
        jourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
        if (jourSemaine == 1)
            jourSemaine = 7;
        else jourSemaine -= 1;
        weekOfYear = dateAuj.get (Calendar.WEEK_OF_YEAR);
    }

    public DateCalendrierProf (int parJour, int parMois, int parAnnee)   {
        super(parJour, parMois, parAnnee);
        Calendar date = Calendar.getInstance();
        date.set(chAnnee,chMois-1,chJour);
        jourSemaine = date.get (Calendar.DAY_OF_WEEK);
        if (jourSemaine == 1)
            jourSemaine = 7;
        else jourSemaine -= 1;
        weekOfYear = date.get (Calendar.WEEK_OF_YEAR);
    }

    public String toString () {
        return  JOURS_SEMAINE [jourSemaine -1] + " " + chJour + " " + MOIS [chMois-1];
    }
    public Integer getNumeroSemaine(){
        return weekOfYear;
    }



    public int getJourSemaine () {
        return jourSemaine;
    }

    public boolean isToday() {
        return this.compareTo(new DateCalendrierProf()) == 0;
    }

    public int getWeekOfYear() {
        return weekOfYear;
    }

    public DateCalendrierProf dateDuLendemain ()   {
        DateProf dateLendemain =  super.dateDuLendemain();
        return new DateCalendrierProf (dateLendemain.chJour,dateLendemain.chMois,dateLendemain.chAnnee);
    }

    public DateCalendrierProf dateDeLaVeille ()  {
        DateProf dateVeille =  super.dateDeLaVeille();
        return new DateCalendrierProf (dateVeille.chJour,dateVeille.chMois,dateVeille.chAnnee);
    }
}