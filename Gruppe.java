import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 18.06.2018
 */
public class Gruppe
{
    private int anzahlNationen;
    private String name;
    private HashMap<String, Nation>nationenliste;
    /**
     * 
     */
    public Gruppe(String name)
    {
        this.name = name;
        nationenliste = new HashMap<String, Nation>();
        erstelleNationenListe();
    }

    /**
     * 
     */
    public void erstelleNationenListe()
    {
        //GruppeA
        if (name == "A"){
            nationenliste.put("Russland", new Nation("Russland", 0, 0));
            nationenliste.put("Saudi-Arabien", new Nation("Saudi-Arabien", 0, 0));
            nationenliste.put("Ägypten", new Nation("Ägypten", 0, 0));
            nationenliste.put("Uruguay", new Nation("Uruguay", 0, 0));
        }
        //Gruppe B
        if (name == "B"){
            nationenliste.put("Marokko", new Nation("Marokko", 0, 0));
            nationenliste.put("Iran", new Nation("Iran", 0, 0));
            nationenliste.put("Portugal", new Nation("Portugal", 0, 0));
            nationenliste.put("Spanien", new Nation("Spanien", 0, 0));
        }
        //Gruppe C
        if (name == "C"){
            nationenliste.put("Frankreich", new Nation("Frankreich", 0, 0));
            nationenliste.put("Australien", new Nation("Australien", 0, 0));
            nationenliste.put("Peru", new Nation("Peru", 0, 0));
            nationenliste.put("Dänemark", new Nation("Dänemark", 0, 0));
        }
        //Gruppe D
        if (name == "D"){
            nationenliste.put("Argentinien", new Nation("Argentinien", 0, 0));
            nationenliste.put("Island", new Nation("Island", 0, 0));
            nationenliste.put("Kroatien", new Nation("Kroatien", 0, 0));
            nationenliste.put("Nigeria", new Nation("Nigeria", 0, 0));
        }
        //Gruppe E
        if (name == "E"){
            nationenliste.put("Costa Rica", new Nation("Costa Rica", 0, 0));
            nationenliste.put("Serbien", new Nation("Serbien", 0, 0));
            nationenliste.put("Brasilien", new Nation("Brasilien", 0, 0));
            nationenliste.put("Schweiz", new Nation("Schweiz", 0, 0));
        }
        //Gruppe F
        if (name == "F") {
            nationenliste.put("Deutschland", new Nation("Deutschland", 0, 0));
            nationenliste.put("Mexiko", new Nation("Mexiko", 0, 0));
            nationenliste.put("Schweden", new Nation("Schweden", 0, 0));
            nationenliste.put("Südkorea", new Nation("Südkorea", 0, 0));
        }
        //Gruppe G
        if (name == "G") {
            nationenliste.put("Belgien", new Nation("Belgien", 0, 0));
            nationenliste.put("Panama", new Nation("Panama", 0, 0));
            nationenliste.put("Tunesien", new Nation("Tunesien", 0, 0));
            nationenliste.put("England", new Nation("England", 0, 0));
        }
        //Gruppe H
        if (name == "H") {
            nationenliste.put("Polen", new Nation("Polen", 0, 0));
            nationenliste.put("Senegal", new Nation("Senegal", 0, 0));
            nationenliste.put("Kolumbien", new Nation("Kolumbien", 0, 0));
            nationenliste.put("Japan", new Nation("Japan", 0, 0));
        }
    }

    /**
     *
     */
    public void erstelleNation(String name)
    {
        Nation nation = new Nation(name, 0, 0);
        nationenliste.put(name, nation);
        anzahlNationen();
    }

    /**
     *
     */
    public int anzahlNationen()
    {
        anzahlNationen = nationenliste.size();
        return anzahlNationen;
    }

    /**
     *
     */
    public boolean prüfeNation(String name)
    {
        if(nationenliste.containsKey(name)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     */
    public void paarungenNationen()
    {
        ArrayList elemente = new ArrayList<String>();
        String[] nationen = gibNationen();
        for (int i = 0; i < anzahlNationen; i++) {
            for (int j = i+1; j < anzahlNationen; j++) {
                elemente.add(nationen[i] + ":" + nationen[j]);
                //speichern in ArrayList oder HashMap
            }
        }
    }

    /**
     * 
     */
    public String[] gibNationen()
    {
        for (String key : nationen.keySet()) {
            String daten;
        }
        return elemente;
    }
    
    /**
     *
     */
    public String gibVeränderteDetailsNation(String name, int tore, int punkte)
    {
        Nation nation = nationenliste.get(name);
        return nation.gibVeränderteDetails(tore, punkte);
    }
}
