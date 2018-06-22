import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Klasse Turnier:
 * 
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 22.06.2018
 */
public class Turnier
{
    private HashMap<String, Gruppe> gruppen;
    private HashMap<String, Nation> nationen;
    private ArrayList<Gruppe> alleGruppen;
    private ArrayList<Nation> alleNationen;
    /**
     * 
     */
    public Turnier()
    {
        gruppen = new HashMap<>();
        alleGruppen = new ArrayList<>();
        alleNationen = new ArrayList<>();
        erstelleGruppenMap();
    }

    /**
     *
     */
    private void erstelleGruppenMap()
    {
        gruppen.put("A", new Gruppe("A"));
        gruppen.put("B", new Gruppe("B"));
        gruppen.put("C", new Gruppe("C"));
        gruppen.put("D", new Gruppe("D"));
        gruppen.put("E", new Gruppe("E"));
        gruppen.put("F", new Gruppe("F"));
        gruppen.put("G", new Gruppe("G"));
        gruppen.put("H", new Gruppe("H"));
    }
    
    /**
     * 
     */
    public ArrayList<String> gibGruppen()
    {
        ArrayList <String> daten = new ArrayList<>();
        for (String key : gruppen.keySet()) {
            daten.add(key);
        }
        return daten;
    }
    
    /**
     * 
     */
    public Gruppe gibGruppe (String nation)
    {
        for (String key : gruppen.keySet()) {
            Gruppe gruppe = gruppen.get(key);
            if(gruppe.prüfeNation(nation) == true){
                return gruppe;
            }
        }
        return null;
    }
    
    /**
     * 
     */
    public String prüfeNationenInGruppe(String nation1, String nation2)
    {
        String gruppe1 = "";
        String gruppe2 = "";
        for (String key : gruppen.keySet()) {
            Gruppe gruppe = gruppen.get(key);
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
        else{
            return null;
        }
    }
    
    /**
     * 
     */
    public ArrayList<String> gibAlleNationenSchlüssel (String name)
    {
        Gruppe gruppe = gruppen.get(name);
        return gruppe.gibAlleNationen();
    }
    
    
    /**
     * 
     */
    private String großSchreibung(String eingabe)
    {
        String ausgabe = eingabe.substring(0, 1).toUpperCase() + eingabe.substring(1);
        return ausgabe;
    }
    
    /**
     * 
     *
    private ArrayList<String> gibAlleNationenWerte (String name)
    {
        Gruppe gruppe = gruppen.get(name);
        return gruppe.gibAlleNationen();
        gruppe.get
    }
    */
    
    /**
     * 
     */
    public String gibDatenSpielergebnis(String nation, int tore, int punkte)
    {
        Gruppe gruppe = gibGruppe(nation);
        String daten = gruppe.gibVeränderteDetailsNation(nation, tore, punkte);
        return daten;
    }
    
    
    /**
     * 
     */
    public int[] berechnePunkte(int tore1, int tore2)
    {
        int[] punkte = {0, 0};
        if(tore1 > tore2){
            punkte[0] = 3;
        }
        if(tore1 < tore2){
            punkte[1] = 3;
        }
        if(tore1 == tore2){
            punkte[0] = 1; punkte[1] = 1;
        }
        return punkte;
    }
    
    /**
     * 
    public void updateSpielergebnis(String nation1, int tore1, String nation2, int tore2)
    {
        int punkte1 = 0;
        int punkte2 = 0;
        String nationA = großSchreibung(nation1);
        String nationB = großSchreibung(nation2);
        
        if(tore1 > tore2){
            punkte1 = 3;
        }
        if(tore1 < tore2){
            punkte2 = 3;
        }
        if(tore1 == tore2){
            punkte1 = 1; punkte2 = 1;
        }
        
        String daten = nation1 + ":" + nation2 + "-" + tore1 + ":" + tore2;
        String datenSpieler = nation1 + ":" + nation2;
        String datenSpielerRück = nation2 + ":" + nation1;
        String gruppe = prüfeNationenInGruppe(nation1, nation2);

        if(prüfeNationenInGruppe(nation1, nation2) != null){
            Gruppe gruppeEins = gruppen.get(gruppe);
            if(gruppeEins.gibDetailsNation(gruppe).contains(datenSpieler) == false
                && gruppeEins.gibDetailsNation(gruppe).contains(datenSpielerRück) == false){
                if(speichereNation(nation1, tore1, punkte1) && speichereNation(nation2, tore2, punkte2)== true){
                    try{
                        rw.hinzufügenGruppe(gruppe, daten);
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
    }*/
}
