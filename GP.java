import java.util.HashMap;
import java.io.*;
/**
 * Beschreiben Sie hier die Klasse Gruppenphase.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 11.06.2018
 */
public class GP
{
    private HashMap<String, Gruppe> gruppenSpieler;
    private EA ea;
    
    /**
     * 
     */
    public GP()
    {
        gruppenSpieler = new HashMap<>();
        ladeGruppen();
        ea = new EA();
    }
    
    /**
     * 
     */
    public void ladeGruppen()
    {
        gruppenSpieler.put("A", new Gruppe("A"));
        gruppenSpieler.put("B", new Gruppe("B"));
        gruppenSpieler.put("C", new Gruppe("C"));
        gruppenSpieler.put("D", new Gruppe("D"));
        gruppenSpieler.put("E", new Gruppe("E"));
        gruppenSpieler.put("F", new Gruppe("F"));
        gruppenSpieler.put("G", new Gruppe("G"));
        gruppenSpieler.put("H", new Gruppe("H"));
    }
    
    /**
     * 
     */
    private Gruppe gibGruppeWennNation(String nation)
    {
        String daten = "";

        for (String key : gruppenSpieler.keySet()) {
            Gruppe gruppe = gruppenSpieler.get(key);

            if(gruppe.nationenPrüfen(nation) == true){
                return gruppe;
            }
        }

        return null;
    }

    private String gibDatenSpielergebnis(String nation, int tore, int punkte)
    {
        Gruppe gruppe = gibGruppeWennNation(nation);
        String daten = gruppe.verändereDetailsNation(nation, tore, punkte);
        return daten;
    }
    
    /**
     * 
     */
    private String prüfeLänderInGruppe(String nationX, String nationY)
    {
        String gruppeX = "";
        String gruppeY = "";
        
        for (String key : gruppenSpieler.keySet()) {
            Gruppe gruppe = gruppenSpieler.get(key);

            if(gruppe.nationenPrüfen(nationX) == true){
                gruppeX = key;
            }
            if(gruppe.nationenPrüfen(nationY) == true){
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
            Gruppe gruppeEins = gruppenSpieler.get(gruppe);
            if(gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpieler) == false
                && gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpielerRück) == false){
                
                if(speichereNation(nationX, toreX, punkteX) && speichereNation(nationY, toreY, punkteY)== true){
                    try{
                        ea.speichereGruppe(gruppe, daten);
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
                ea.speichereNation(gibDatenSpielergebnis(nation, tore, punkte));
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
