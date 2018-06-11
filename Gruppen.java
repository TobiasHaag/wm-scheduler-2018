import java.util.HashMap;
/**
 * Beschreiben Sie hier die Klasse Gruppen.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 04.06.2018
 */
public class Gruppen
{
    // Sammlung der Länder.
    private HashMap<String, Land> länder;
    private HashMap<String, String> spiele;
    private int gruppenGroesse;
    private EA ea;
    /**
     * Konstruktor für Objekte der Klasse Gruppen.
     */
    public Gruppen(String identifikation)
    {
        länder = new HashMap<>();
        spiele = new HashMap<>();
        ea = new EA();
        ladeGruppeninfo(identifikation);
    }
    
    /**
     * 
     */
    public void erstelleLand(String name)
    {
        Land land = new Land(name, 0, 0);
        länder.put(name, land);
        gruppenGroesse += 1;
    }
    
    public void ladeLand(String name)
    {
        String daten = "";
        try{
            daten = ea.ladeDatei("Länder", name);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        String[] teil = daten.split("|");
        String nameLand = teil[0];
        int tore = Integer.valueOf(teil[1]);
        int punkte = Integer.valueOf(teil[2]);
        
        länder.put(nameLand, new Land(nameLand, tore, punkte));
    }
    
    /**
     * 
     */
    public void ladeGruppeninfo(String identifikation)
    {
        String daten = "";
        try{
            daten = ea.ladeDatei("Gruppen", identifikation);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] teil = daten.split("|");
        gruppenGroesse = Integer.valueOf(teil[0]);
        for (int i = 1; i < teil.length; i++) {
            ladeLand(teil[i]);
        }
    }
    
    /**
     *
     */
    public boolean prüfeLand(String name)
    {
        if(länder.containsKey(name)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     *
     */
    public String gibInfoLand(String name, int tore, int punkte)
    {
        Land land = länder.get(name);
        return land.gibInfo(tore, punkte);
    }
    
    /**
     *
     */
    public String speichereErgebnis(String landX, String landY, int toreX, int toreY)
    {
        String spieler = landX + ":" + landY;
        String ergebnis = toreX + ":" + toreY;
        spiele.put(spieler, ergebnis);
        String daten = spieler + "|" + ergebnis;
        return daten;
    }
}
