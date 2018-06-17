import java.util.HashMap;
/**
 * Klasse Gruppe:
 *
 * @author Tobias Haag | HfG | IoT3
 * @version 17.06.2018
 */
public class Gruppe
{
    private String name;
    private HashMap<String, Nation> nationen;
    private RW rw;
    private int anzahlNationen;
    /**
     * 
     */
    public Gruppe(String name)
    {
        this.name = name;
        nationen = new HashMap<>();
        rw = new RW();
    }
    
    /**
     * 
     */
    public void erstelleNation(String name)
    {
        Nation nation = new Nation(name, 0, 0);
        nationen.put(name, nation);
        anzahlNationen = nationen.size();
    }
    
    /**
     * 
     */
    public int gibAnzahlNationen()
    {
        return anzahlNationen;
    }
    
    /**
     * 
     */
    public void ladeNation(String name)
    {
        String[] element = gibDatenElemente("Nationen", name);

        String nameNation = element[0];
        int tore = Integer.valueOf(element[1]);
        int punkte = Integer.valueOf(element[2]);

        nationen.put(nameNation, new Nation(nameNation, tore, punkte));
        anzahlNationen = nationen.size();
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
    
    /**
     * 
     */
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
