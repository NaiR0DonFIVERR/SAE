package modele;

import java.util.Calendar;

public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable<Date>{
    private int chJourSemaine;
    private int chNumSemaine;

    public DateCalendrier(){
        Calendar today = Calendar.getInstance();
        chAnnee = today.get (Calendar.YEAR);
        chMois = today.get (Calendar.MONTH) +1;
        chJour = today.get (Calendar.DAY_OF_MONTH);

        chNumSemaine = today.get (Calendar.WEEK_OF_YEAR); //Numéro de la semaine
        chJourSemaine = today.get (Calendar.DAY_OF_WEEK); //Jour de la semaine

        if (chJourSemaine == 1){
            chJourSemaine = 7;
        }
        else {
            chJourSemaine --;
        }
    }
    public DateCalendrier(int parJour, int parMois, int parAnnee){
        super(parJour, parMois, parAnnee);
        Calendar date = Calendar.getInstance();
        //Création d'un objet calendrier
        date.set(parAnnee, parMois-1, parJour);

        chNumSemaine = date.get (Calendar.WEEK_OF_YEAR);
        chJourSemaine = date.get (Calendar.DAY_OF_WEEK);

        if (chJourSemaine == 1){
            chJourSemaine = 7;
        }
        else {
            chJourSemaine --;
        }

    }
    public Integer getNumeroSemaine(){
        return chNumSemaine;
    }

    public String toString(){
        return super.toString() + " Jour : " + JOURS_SEMAINE[chJourSemaine-1];
    }

    public DateCalendrier dateDuLendemain(){

        Date date = super.dateDuLendemain();

        return new DateCalendrier(date.chJour,date.chMois,date.chAnnee);
    }




}
