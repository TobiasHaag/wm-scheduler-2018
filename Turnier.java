import java.util.HashMap; // Import-Anweisung um die Bibliotheksklasse HashMap in dieser Klasse verfügbar zu machen.
import java.util.ArrayList; // Import-Anweisung um die Bibliotheksklasse ArrayList in dieser Klasse verfügbar zu machen.
import java.util.Arrays; // Import-Anweisung um die Bibliotheksklasse Arrays in dieser Klasse verfügbar zu machen.
/**
 * Klasse Turnier:
 * 
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 24.06.2018
 */
public class Turnier
{
    private HashMap<String, Gruppe> gruppen; // HashMap mit String als key und Gruppen-Objekten als Value.
    private HashMap<String, Nation> nationen;
    private ArrayList<String> alleNationen;
    /**
     * 
     */
    public Turnier()
    {
        gruppen = new HashMap<>(); // Erzeugen der HashMap mit Gruppen-Objekten.
        alleNationen = new ArrayList<>();
        erstelleGruppenMap(); // Methodenaufruf, um die darin befindlichen Gruppeninformationen der HashMap gruppen zu übergeben.
    }
    
    /**
     * Die Methode erzeugt eine HashMap in der sich wiederum alle HashMaps der Klasse Gruppen befinden.
     * Der Key in der Hashmap fügt alle Gruppen hinzu die mit dem String (z.B. "A") übereinstimmen.
     * Stimmt der Key überein dann wird der HashMap ein neues Objekt der Klasse Gruppe und die darin liegenden Nationen-Objekte übergeben.
     * Somit wird eine große HashMap mit 8 Gruppen-HashMaps angelegt, die 32 Nationen-Objekte beinhalten.
     */
    public void erstelleGruppenMap()
    {
        // Über den Key String werden alle 8 Gruppen-HashMaps auf ein Mal erstellt, da diese in der Klasse Gruppe angelegt wurden.
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
     * OK
     */
    public void zeigeAlleNationenSchlüssel(){   
        ArrayList <Gruppe> elementdaten = new ArrayList<>();
        for (String key : gruppen.keySet()) {
            elementdaten.add(gruppen.get(key));
        }
        for (int i = 0; i <elementdaten.size(); i++) {
            Gruppe gruppe = elementdaten.get(i);
            System.out.println(gruppe.gibAlleNationen());
        }
    }
    
    /**
     * OK
     */
    public void zeigeAlleNationenWerte(){   
        ArrayList <Gruppe> elementdaten = new ArrayList<>();
        for (String key : gruppen.keySet()) {
            elementdaten.add(gruppen.get(key));
        }
        for (int i = 0; i <elementdaten.size(); i++) {
            Gruppe gruppe = elementdaten.get(i);
            System.out.println(gruppe.gibAlleWerte());
        }
    }
    
    /**
     * OK
     */
    public ArrayList<String> gibGruppen()
    {
        ArrayList <String> elementdaten = new ArrayList<>();
        for (String key : gruppen.keySet()) {
            elementdaten.add(key);
        }
        return elementdaten;
    }
    
    /**
     * OK
     */
    public void zeigeAlleGruppen()
    {
        ArrayList <String> elementdaten = new ArrayList<>();
        for (String key : gruppen.keySet()) {
            elementdaten.add(key);
        }
        System.out.println(elementdaten);
    }
    
    /**
     * OK
     */
    public Gruppe gibGruppeÜberNation (String nation)
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
     * OK
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
     * Falsch
     */
    public void zeigeAlleNationenTore ()
    {
           Gruppe gruppe = gruppen.get("F");
           System.out.println (gruppe.gibToreNation("Deutschland"));
    }
    
    /**
     * OK
     */
    public String gibDatenSpielergebnis(String nation, int tore, int punkte)
    {
        Gruppe gruppe = gibGruppeÜberNation(nation);
        String daten = gruppe.gibVeränderteDetailsNation(nation, tore, punkte);
        return daten;
    }
    
    /**
     * OK
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
}
