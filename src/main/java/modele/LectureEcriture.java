package modele;

import javafx.application.Application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class LectureEcriture {
    File fichierMembre = new File("src/main/java/Données/membres_APLI.txt");
    BufferedReader bufferedReaderMembre = new BufferedReader(new FileReader(fichierMembre));

    static File fichierDistance = new File("src/main/java/Données/distances.txt");
    static BufferedReader bufferedReaderDistance;

    static {
        try {
            bufferedReaderDistance = new BufferedReader(new FileReader(fichierDistance));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LectureEcriture() throws FileNotFoundException {
    }

    public static Scenario lectureScenario (File fichier) throws IOException {
        Scenario scenario = new Scenario();
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        String ligne ;

        StringTokenizer tokenizer;
        do{
            ligne = bufferEntree.readLine();
            if (ligne != null){
                tokenizer = new StringTokenizer(ligne," ->");
                String tokenV = tokenizer.nextToken();
                String tokenA = tokenizer.nextToken();
                scenario.ajoutVendeurAcheteur(tokenV, tokenA);
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return scenario;
    }
    //Retourn une ville qui correspond au client
    public static String recupVille(String acheteur_vendeur) throws IOException{
        File fichier = new File("src/main/java/Données/membres_APLI.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fichier));
        String ligne ;
        String ville = "";

        StringTokenizer tokenizer;
        do{
            ligne = bufferedReader.readLine();
            if (ligne != null){
                tokenizer = new StringTokenizer(ligne," ");
                String tokenCli = tokenizer.nextToken();
                String tokenVille = tokenizer.nextToken();
                if (Objects.equals(acheteur_vendeur, tokenCli)){
                    ville = tokenVille;
                    break;
                }
            }
        }
        while (ligne != null);
        bufferedReader.close();
        return ville;
    }

    public static List<String> recupVilleIndice(List<String> villeIndice) throws IOException{

        List<String> ville_indice = new ArrayList<>();

        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(villeIndice.get(0), " : ");
        String tokenVille = tokenizer.nextToken();
        String tokentIndice = tokenizer.nextToken();

        ville_indice.add(tokenVille);
        ville_indice.add(tokentIndice);
        return ville_indice;

    }
    public static int getIndiceDistance(String ville) throws IOException {
        int Indice = 0;
        int compte = 0;
        String ligne ;
        StringTokenizer tokenizer;
        do{
            ligne = bufferedReaderDistance.readLine();
            if (ligne != null){
                tokenizer = new StringTokenizer(ligne," ");
                String tokenVille = tokenizer.nextToken();
                if (tokenVille.equals(ville)){
                    System.out.println(ville + " " +compte);
                    Indice = compte;
                    break;
                }
                compte ++;
            }
        }
        while (ligne != null);
        bufferedReaderDistance.close();
        return Indice;
    }



    public static List<String> lectureDistance(String villeDepart, String villeArr) throws IOException{
        File fichier = new File("src/main/java/Données/distances.txt");
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        String ligne ;
        int indiceVilleA = -1;
        StringTokenizer tokenizer;
        List<String> villeIndice = new ArrayList<>();
        int i = 0;
        //System.out.println("ville a rec" + villeDepart + " " + villeArr);
        do{
            i++ ;
            ligne = bufferEntree.readLine();
            if (ligne != null){

                tokenizer = new StringTokenizer(ligne," ");
                String tokenD = tokenizer.nextToken();

                if (tokenD.equals(villeArr)){
                    indiceVilleA = i;
                }

                //System.out.println(tokenD +" "+ i);

            }
        }
        while (ligne != null);
        bufferEntree.close();
        //System.out.println(villeDepart + " " + indiceVilleA);
        villeIndice.add(villeDepart);
        villeIndice.add(String.valueOf(indiceVilleA));
        return villeIndice;
    }
    public static String recupDistance(List<String> indices) throws IOException{
        File fichier = new File("src/main/java/Données/distances.txt");
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        String ligne ;
        StringTokenizer tokenizer;

        int i = Integer.parseInt(indices.get(1));

        String tokenR = null;
        do{

            ligne = bufferEntree.readLine();
            tokenizer = new StringTokenizer(ligne," ");
            String tokenVille = tokenizer.nextToken();
            //System.out.println(tokenVille);
            if (tokenVille.equals(indices.get(0))) {

                for (int y = 0; y< i; y++) {
                    //System.out.println(i + " " + y);
                    tokenR = tokenizer.nextToken();
                    //System.out.println(tokenR);
                }

                break;
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return tokenR;
    }

    public static List<String> getMembres() throws IOException {
        File fichier = new File("src/main/java/Données/membres_APLI.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fichier));
        String ligne ;
        StringTokenizer tokenizer;
        List<String> listCli = new ArrayList<>();

        do{
            ligne = bufferedReader.readLine();
            if (ligne != null){
                tokenizer = new StringTokenizer(ligne," ");
                String tokenCli = tokenizer.nextToken();
                listCli.add(tokenCli);

            }
        }
        while (ligne != null);
        bufferedReader.close();
        return listCli;

    }


    public static void ecritureScenario(String nomFichier, Scenario scenario) throws IOException{

        PrintWriter sortie = new PrintWriter(new BufferedWriter(new FileWriter(nomFichier)));
        int i = 0;
        for (String vendeur : scenario.getVendeur()){
            sortie.println(vendeur + "->" + scenario.getAcheteur().get(i));
            i++;
        }
        sortie.close();
    }

}
