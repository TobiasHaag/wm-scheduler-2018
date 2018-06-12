import java.util.HashMap;
/**
 * Beschreiben Sie hier die Klasse Gruppe.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 11.06.2018
 */
public class Gruppe
{
    private HashMap<String, Nation> nationen;
    private int anzahlGruppen;
    private EA ea;
    private HashMap<String, String> spiele;
    /**
     * Konstruktor für Objekte der Klasse Gruppe.
     */
    public Gruppe(String name)
    {
        nationen = new HashMap<>();
        spiele = new HashMap<>();
        ea = new EA();
        ladeGruppeninfo(name);
    }
    
    /**
     *
     */
    public boolean nationenPrüfen(String name)
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
    public void erstelleNation(String name)
    {
        Nation nation = new Nation(name, 0, 0);
        nationen.put(name, nation);
        anzahlGruppen +=1;
    }
    
    /**
     *
     */
    public int gibNationenAnzahl()
    {
        return nationen.size();
    }
    
    /**
     *
     */
    public String verändereDetailsNation(String name, int tore, int punkte)
    {
        Nation nation = nationen.get(name);
        return nation.verändereDetails(tore, punkte);
    }
    
    public void ladeNation(String name)
    {
        String[] teilung = gibDatenTeilung("Nationen", name);
        
        String nameNation = teilung[0];
        int tore = Integer.valueOf(teilung[1]);
        int punkte = Integer.valueOf(teilung[2]);
        
        nationen.put(nameNation, new Nation(nameNation, tore, punkte));
    }
    
    /**
     * 
     */
    public void ladeGruppeninfo(String name)
    {
        String[] teilung = gibDatenTeilung("Gruppen", name);

        anzahlGruppen = Integer.valueOf(teilung[0]);
        for (int i = 1; i <= anzahlGruppen; i++) {
            ladeNation(teilung[i]);
        }

        if(teilung.length >= anzahlGruppen+2){
            for (int i = anzahlGruppen+1; i < teilung.length; i++) {
                String[] daten = teilung[i].split("-");
                spiele.put(daten[0], daten[1]);
            }
        }
    }
    
    /**
     * 
     */
    public String[] gibDatenTeilung(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = ea.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] teilung = daten.split("|");
        return teilung;
    }
    
    public String gibDaten(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = ea.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return daten; 
    }
    
}
