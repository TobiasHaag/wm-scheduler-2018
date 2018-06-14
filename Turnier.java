import java.util.HashMap;
import java.lang.*;
import java.io.*;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 12.06.2018
 */
public class Turnier
{
    private HashMap<String, Gruppe> gruppenHash; // das muss zur Hashmap gemacht werden oder in die txt geschrieben werden
    private RW rw;

    /**
     * Constructor for objects of class Gruppen
     */
    public Turnier()
    {
        gruppenHash = new HashMap<>();
        ladeGruppen();
        rw = new RW();
    }

    /**
     *
     */
    public void ladeGruppen()
    {
        gruppenHash.put("A", new Gruppe("A"));
        gruppenHash.put("B", new Gruppe("B"));
        gruppenHash.put("C", new Gruppe("C"));
        gruppenHash.put("D", new Gruppe("D"));
        gruppenHash.put("E", new Gruppe("E"));
        gruppenHash.put("F", new Gruppe("F"));
        gruppenHash.put("G", new Gruppe("G"));
        gruppenHash.put("H", new Gruppe("H"));
    }

    /**
     *
     */
    private Gruppe gibGruppeWennNation(String nation)
    {
        String daten = "";

        for (String key : gruppenHash.keySet()) {
            Gruppe gruppe = gruppenHash.get(key);

            if(gruppe.prüfeNation(nation) == true){
                return gruppe;
            }
        }

        return null;
    }

    private String gibDatenSpielergebnis(String nation, int tore, int punkte)
    {
        Gruppe gruppe = gibGruppeWennNation(nation);
        String daten = gruppe.gibUpdatedInfoNation(nation, tore, punkte);
        return daten;
    }

    /**
     *
     */
    private String prüfeNationenInGruppe(String nation1, String nation2)
    {
        String gruppe1 = "";
        String gruppe2 = "";

        for (String key : gruppenHash.keySet()) {
            Gruppe gruppe = gruppenHash.get(key);

            if(gruppe.prüfeNation(nation1) == true){
                gruppe1 = key;
            }
            if(gruppe.prüfeNation(nation2) == true){
                gruppe2 = key;
            }
        }

        if(gruppe1 == gruppe2){
            return gruppe1;
        }
        else{return null;}

    }


    public void updateSpielergebnis(String nation1klein, int tore1, String nation2klein, int tore2)
    {
        int punkte1 = 0;
        int punkte2 = 0;
        String nation1 = schreibeGroß(nation1klein);
        String nation2 = schreibeGroß(nation2klein);

        if(tore1 > tore2){punkte1 = 3;}
        if(tore1 < tore2){punkte2 = 3;}
        if(tore1 == tore2){punkte1 = 1; punkte2 = 1;}

        String daten = nation1 + ":" + nation2 + "-" + tore1 + ":" + tore2;
        String datenSpieler = nation1 + ":" + nation2;
        String datenSpielerRück = nation2 + ":" + nation1;
        String gruppe = prüfeNationenInGruppe(nation1, nation2);

        if(prüfeNationenInGruppe(nation1, nation2) != null){
            Gruppe gruppeEins = gruppenHash.get(gruppe);
            if(gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpieler) == false
                && gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpielerRück) == false){

                if(speichereNation(nation1, tore1, punkte1) && speichereNation(nation2, tore2, punkte2)== true){
                    try{
                        rw.appendGruppe(gruppe, daten);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    gruppeEins.ladeGruppeninfo(gruppe);
                }
            }
            else{System.out.println("Das Ergebnis wurde bereits eingegeben!");}
        }
        else{System.out.println("Die Nationen sind nicht in einer Gruppe!");}
    }

    /**
     *
     */
    public boolean speichereNation(String nation, int tore, int punkte)
    {
        if(gibGruppeWennNation(nation) == null){
            System.out.println("Das Nation " + nation + " existiert nicht");
            return false;
        }
        else{
            try{
                rw.speichereNation(gibDatenSpielergebnis(nation, tore, punkte));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    /**
     *
     */
    private String schreibeGroß(String eingabe)
    {
        String ausgabe = eingabe.substring(0, 1).toUpperCase() + eingabe.substring(1);
        return ausgabe;
    }

}
