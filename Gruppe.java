import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Klasse Gruppe:
 * Die Klasse Gruppe 
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 22.06.2018
 */
public class Gruppe
{
    private String gruppenname;
    private int anzahlNationen;
    private HashMap<String, Nation>nationen;
    private HashMap<String, String>spielphasen;
    private ArrayList <String> elemente;
    private ArrayList <String> alleNationen;
    /**
     * Konstruktor für Objekte der Klasse Gruppe.
     */
    public Gruppe(String name)
    {
        erstelleNationenMap(); //Erzeugung der Hashmap mit den vorhandenen Nationen-Objekten.
        this.gruppenname = name; // Der Wert des Übergabeparameters name wird dem Attribut gruppenname zu gewiesen.
        anzahlNationen = 4; // Setzt die Anzahl der Nationen in einer Gruppe statisch auf vier. Könnte auch dynamisch durch eine Variable definiert werden, anhand der Anzahl der Gruppen.
        nationen = new HashMap<>();
        spielphasen = new HashMap<>();
        elemente = new ArrayList<>();
        alleNationen = new ArrayList<>();
    }

    /**
     * 
     */
    private void erstelleNationenMap()
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
     * Liefere den Namen der Gruppe.
     * @return der Gruppenname.
     */
    public String gibName()
    {
        return gruppenname;
    }
    
    /**
     * Liefere die Anzahl der Nationen, die sich in der HashMap nationen befinden.
     * @return die Anzahl der Nationen als Integer-Wert.
     */
    public int anzahlNationen()
    {
        anzahlNationen = nationen.size(); // size - Wird verwendet, um die Anzhal der Schlüssel/Wert-Zuordnung in der Map zurückzugeben.
        return anzahlNationen;
    }
    
    /**
     * Set-Methode, die .
     * @return die Anzahl der Nationen als Integer-Wert.
     */
    public void erstelleNation(String name)
    {
        Nation nation = new Nation(name, 0, 0);
        nationen.put(name, nation);
        anzahlNationen();
    }

    public void fügeNationInGruppe(String name, int tore, int punkte)
    {
        nationen.put(name, new Nation(name, tore, punkte));
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
    public ArrayList<String> gibNationen()
    {
        ArrayList <String> daten = new ArrayList<>();
        for (String key : nationen.keySet()) {
            daten.add(key);
        }
        return daten;
    }
    
    /**
     *
     */
    public void paarungen()
    {
        ArrayList <String> schlüssel = gibNationen();
        ArrayList <String> elemente = new ArrayList<String>();
        for (int i = 0; i < anzahlNationen; i++) {
            for (int j = i+1; j < anzahlNationen; j++) {
                elemente.add((schlüssel.get(i)) + " gegen " + (schlüssel.get(j)));
            }
        }
        System.out.println(elemente);
    }
    
    /**
     *
     */
    public ArrayList<String> gibAlleNationen()
    {
        for (String key : nationen.keySet())
        {
            alleNationen.add(key);
        }
        return alleNationen;
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
