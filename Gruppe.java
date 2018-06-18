import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 19.06.2018
 */
public class Gruppe
{
    private HashMap<String, Nation>nationen;
    private int anzahlNationen;
    private String gruppenname;
    private HashMap<String, String>spielphasen;
    /**
     * 
     */
    public Gruppe(String name)
    {
        this.gruppenname = name;
        nationen = new HashMap<>();
        spielphasen = new HashMap<>();
        erstelleNationenMap();
    }

    /**
     * 
     */
    public void erstelleNationenMap()
    {
        //GruppeA
        if (gruppenname == "A"){
            nationen.put("Russland", new Nation("Russland", 0, 0));
            nationen.put("Saudi-Arabien", new Nation("Saudi-Arabien", 0, 0));
            nationen.put("Ägypten", new Nation("Ägypten", 0, 0));
            nationen.put("Uruguay", new Nation("Uruguay", 0, 0));
        }
        //Gruppe B
        if (gruppenname == "B"){
            nationen.put("Marokko", new Nation("Marokko", 0, 0));
            nationen.put("Iran", new Nation("Iran", 0, 0));
            nationen.put("Portugal", new Nation("Portugal", 0, 0));
            nationen.put("Spanien", new Nation("Spanien", 0, 0));
        }
        //Gruppe C
        if (gruppenname == "C"){
            nationen.put("Frankreich", new Nation("Frankreich", 0, 0));
            nationen.put("Australien", new Nation("Australien", 0, 0));
            nationen.put("Peru", new Nation("Peru", 0, 0));
            nationen.put("Dänemark", new Nation("Dänemark", 0, 0));
        }
        //Gruppe D
        if (gruppenname == "D"){
            nationen.put("Argentinien", new Nation("Argentinien", 0, 0));
            nationen.put("Island", new Nation("Island", 0, 0));
            nationen.put("Kroatien", new Nation("Kroatien", 0, 0));
            nationen.put("Nigeria", new Nation("Nigeria", 0, 0));
        }
        //Gruppe E
        if (gruppenname == "E"){
            nationen.put("Costa Rica", new Nation("Costa Rica", 0, 0));
            nationen.put("Serbien", new Nation("Serbien", 0, 0));
            nationen.put("Brasilien", new Nation("Brasilien", 0, 0));
            nationen.put("Schweiz", new Nation("Schweiz", 0, 0));
        }
        //Gruppe F
        if (gruppenname == "F") {
            nationen.put("Deutschland", new Nation("Deutschland", 0, 0));
            nationen.put("Mexiko", new Nation("Mexiko", 0, 0));
            nationen.put("Schweden", new Nation("Schweden", 0, 0));
            nationen.put("Südkorea", new Nation("Südkorea", 0, 0));
        }
        //Gruppe G
        if (gruppenname == "G") {
            nationen.put("Belgien", new Nation("Belgien", 0, 0));
            nationen.put("Panama", new Nation("Panama", 0, 0));
            nationen.put("Tunesien", new Nation("Tunesien", 0, 0));
            nationen.put("England", new Nation("England", 0, 0));
        }
        //Gruppe H
        if (gruppenname == "H") {
            nationen.put("Polen", new Nation("Polen", 0, 0));
            nationen.put("Senegal", new Nation("Senegal", 0, 0));
            nationen.put("Kolumbien", new Nation("Kolumbien", 0, 0));
            nationen.put("Japan", new Nation("Japan", 0, 0));
        }
    }

    /**
     *
     */
    public int anzahlNationen()
    {
        anzahlNationen = nationen.size();
        return anzahlNationen;
    }
    
    /**
     *
     */
    public void erstelleNation(String name)
    {
        Nation nation = new Nation(name, 0, 0);
        nationen.put(name, nation);
        anzahlNationen();
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
    public void paarungenAusgeben()
    {
        ArrayList elemente = new ArrayList<String>();
        String[] nationenArray = gibNationen();
        for (int i = 0; i < anzahlNationen; i++) {
            for (int j = i+1; j < anzahlNationen; j++) {
                elemente.add(nationen[i] + ":" + nationen[j]); //speichern in HashMap
            }
        }
    }

    /**
     * 
     */
    public String[] gibNationen()
    {
        String nationenvalues = "";
        for (String key : nationen.keySet()) {
            Nation nation = nationen.get(key);
        }
        return nationenvalues;
    }
    
    /**
     *
     */
    public String gibDetailsNation(String name)
    {
        Nation nation = nationen.get(name);
        return nation.gibDetails();
    }
    
    /**
     *
     */
    public String gibVeränderteDetailsNation(String name, int tore, int punkte)
    {
        Nation nation = nationen.get(name);
        return nation.gibVeränderteDetails(tore, punkte);
    }
    
    /**
     * 
     */
    public void entferneSpielphasen()
    {
        spielphasen.clear();
    }
    
    /**
     * 
     */
    public void entferneNationen()
    {
        nationen.clear();
    }
}
