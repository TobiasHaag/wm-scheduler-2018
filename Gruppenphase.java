import java.util.HashMap;
import java.lang.*;
import java.io.*;
/**
 * Beschreiben Sie hier die Klasse Gruppenphase.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 11.06.2018
 */
public class Gruppenphase
{
    private HashMap<String, Gruppe> gruppenHash; // das muss zur Hashmap gemacht werden oder in die txt geschrieben werden
    private RW rw;
    /**
     * Konstruktor für Objekte der Klasse Land.
     * @param name der Name der Nation.
     * @param tore die Anzahl der geschossenen Tore.
     * @param punkte die Anzahl der erreichten Punkte.
     */
    public Gruppenphase()
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
        String daten = gruppe.gibInfoNation(nation, tore, punkte);
        return daten;
    }
    
    /**
     * 
     */
    private String prüfeLänderInGruppe(String nationX, String nationY)
    {
        String gruppeX = "";
        String gruppeY = "";
        
        for (String key : gruppenHash.keySet()) {
            Gruppe gruppe = gruppenHash.get(key);

            if(gruppe.prüfeNation(nationX) == true){
                gruppeX = key;
            }
            if(gruppe.prüfeNation(nationY) == true){
                gruppeY = key;
            }
        }
        
        if(gruppeX == gruppeY){
            return gruppeX;
        }
        else{return null;}
        
    }

    public void updateSpielergebnis(String nationXklein, int toreX, String nationYklein, int toreY)
    {
        int punkteX = 0;
        int punkteY = 0;
        String nationX = schreibeGroß(nationXklein);
        String nationY = schreibeGroß(nationYklein);
        
        if(toreX > toreY){punkteX = 3;}
        if(toreX < toreY){punkteY = 3;}
        if(toreX == toreY){punkteX = 1; punkteY = 1;}

        String daten = nationX + ":" + nationY + "-" + toreX + ":" + toreY;
        String datenSpieler = nationX + ":" + nationY;
        String datenSpielerRück = nationY + ":" + nationX;
        String gruppe = prüfeLänderInGruppe(nationX, nationY);

        if(prüfeLänderInGruppe(nationX, nationY) != null){
            Gruppe gruppeEins = gruppenHash.get(gruppe);
            if(gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpieler) == false
                && gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpielerRück) == false){
                
                if(speichereNation(nationX, toreX, punkteX) && speichereNation(nationY, toreY, punkteY)== true){
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
        else{System.out.println("Die Länder sind nicht in einer Gruppe!");}
    }
    
    /**
     * 
     */
    public boolean speichereNation(String nation, int tore, int punkte)
    {
        if(gibGruppeWennNation(nation) == null){
            System.out.println("Die Nation " + nation + " existiert nicht");
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
