import java.util.HashMap;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 14
 * 16.06.2018
 */
public class Gruppe
{
    private HashMap<String, Nation> nationen;
    private int anzahlGruppen;
    private RW rw;
    private HashMap<String, String> spielpartien;
    /**
     * Konstructor
     */
    public Gruppe(String name)
    {
        nationen = new HashMap<>();
        spielpartien = new HashMap<>();
        rw = new RW();
        ladeGruppeninfo(name);
    }

    public void ladeNation(String name)
    {
        String[] element = gibDatenElemente("Nationen", name);

        String nameNation = element[0];
        int tore = Integer.valueOf(element[1]);
        int punkte = Integer.valueOf(element[2]);

        nationen.put(nameNation, new Nation(nameNation, tore, punkte));

    }

    /**
     *
     */
    public void ladeGruppeninfo(String name)
    {
        String[] element = gibDatenElemente("Gruppen", name);

        anzahlGruppen = Integer.valueOf(element[0]);
        for (int i = 1; i <= anzahlGruppen; i++) {
            ladeNation(element[i]);
        }

        if(element.length >= anzahlGruppen+2){
            for (int i = anzahlGruppen+1; i < element.length; i++) {
                String[] daten = element[i].split("-");
                spielpartien.put(daten[0], daten[1]);
            }
        }
    }

    /**
     *
     */
    public String[] gibDatenElemente(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = rw.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] element = daten.split("/");
        return element;
    }

    public String gibDaten(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = rw.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return daten;
    }

    /**
     *
     */
    public boolean prüfeNation(String name)
    {
        if(nationen.containsKey(name)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     */
    public String gibVeränderteDetailsNation(String name, int tore, int punkte)
    {
        Nation nation = nationen.get(name);
        return nation.gibVeränderteDetails(tore, punkte);
    }
}
