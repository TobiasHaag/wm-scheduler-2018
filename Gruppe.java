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
    private HashMap<String, String> spiele;
    private int gruppenGroesse;
    private RW rw;
    /**
     * Konstruktor für Objekte der Klasse Gruppe.
     */
    public Gruppe(String name)
    {
        nationen = new HashMap<>();
        spiele = new HashMap<>();
        rw = new RW();
        ladeGruppeninfo(name);
    }
    
    /**
     * 
     */
    public void erstelleNation(String name)
    {
        Nation nation = new Nation(name, 0, 0);
        nationen.put(name, nation);
        gruppenGroesse += 1;
    }
    
    public void ladeNation(String name)
    {
        String[] teil = gibDatenTeil("Nationen", name);
        
        String nameNation = teil[0];
        int tore = Integer.valueOf(teil[1]);
        int punkte = Integer.valueOf(teil[2]);
        
        nationen.put(nameNation, new Nation(nameNation, tore, punkte));
    }
    
    /**
     * 
     */
    public void ladeGruppeninfo(String name)
    {
        String[] teil = gibDatenTeil("Gruppen", name);

        gruppenGroesse = Integer.valueOf(teil[0]);
        for (int i = 1; i <= gruppenGroesse; i++) {
            ladeNation(teil[i]);
        }

        if(teil.length >= gruppenGroesse+2){
            for (int i = gruppenGroesse+1; i < teil.length; i++) {
                String[] daten = teil[i].split("-");
                spiele.put(daten[0], daten[1]);
            }
        }
    }
    
    /**
     * 
     */
    public String[] gibDatenTeil(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = rw.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] teil = daten.split("|");
        return teil;
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
        else{return false;}
    }

    /**
     *
     */
    public String gibInfoNation(String name, int tore, int punkte)
    {
        Nation nation = nationen.get(name);
        return nation.gibInfo(tore, punkte);
    }
}
