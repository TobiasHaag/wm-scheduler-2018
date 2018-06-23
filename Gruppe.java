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
    private HashMap<String, Nation>nationen; // HashMap mit String als key und Nationen-Objekten als Value.
    private HashMap<String, String>spielphasen;
    private ArrayList <String> elemente; // Globale ArrayList für die Ermittlung der SpielPaarungen.
    private ArrayList <String> alleNationen; // Globale ArrayList für das Ausgeben aller Nationen in der HashMap.
    /**
     * Konstruktor für Objekte der Klasse Gruppe.
     */
    public Gruppe(String name)
    {
        this.gruppenname = name; // Der Wert des Übergabeparameters name wird dem Attribut gruppenname zu gewiesen.
        nationen = new HashMap<>(); // Erzeugen der HashMap mit Nationen-Objekten.
        erstelleNationenMap(); // Methodenaufruf, um die darin befindlichen Nationeninformationen der HashMap nationen zu übergeben.
        anzahlNationen = nationen.size(); // Setzt die Anzahl der Nationen in einer Gruppe auf die Anzahl der befindlichen Objekte in der Hashmap.
        spielphasen = new HashMap<>();
        elemente = new ArrayList<>();
        alleNationen = new ArrayList<>();
    }

    /**
     * Die Methode 
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
        System.out.println("Die Nationen der Gruppe " + gruppenname + " wurden hinzugefügt!");
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
        anzahlNationen = nationen.size(); // size - Wird verwendet, um die Anzahl der Schlüssel/Wert-Zuordnung in der Map zurückzugeben.
        return anzahlNationen;
    }
    
    /**
     * Erstelle ein neues Objekt vom Typ Nation, speichere es in die HashMap nationen und aktualisiere die Nationenanzahl.
     */
    public void erstelleNeueNation(String name)
    {
        Nation nation = new Nation(name, 0, 0); // new - Über den Konstruktor der Klasse Nation wird ein neues Nationen-Objekt erzeugt.
        nationen.put(name, nation); // put - Fügt in die HashMap ein neues Objekt hinzu.
        anzahlNationen();
    }

    /**
     * In die HashMap wird ein neues Objekt Nation mit Name, Tore und Punkte hinzugefügt.
     */
    public void fügeNationInGruppe(String name, int tore, int punkte)
    {
        nationen.put(name, new Nation(name, tore, punkte)); //  Über den Konstruktor der Klasse Nation wird ein neues Nationen-Objekt erzeugt.
        anzahlNationen();
    }
    
    /**
     * Methode mit einer Boolean-Abfrage, die Nationen in der HashMap nach Namen überprüft.
     * Dabei wird der Key (Name der Nation als String) mit der Eingabe verglichen.
     */
    public boolean prüfeNation(String name)
    {
        // containsKey - Überprüft, die Zuordnung für den angegebenen Schlüssel.
        if(nationen.containsKey(name)){
            return true; // Namen stimmen überein - Nation befindet sich bereits in der Hashmap.
        }
        else{
            return false; // Namen stimmen nicht überein - Nation befindet sich noch nicht in der Hashmap.
        }
    }
    
    /**
     * Über eine lokale ArrayList werden die Keys der in der HashMap befindlichen Nationen ausgegeben.
     */
    public ArrayList<String> gibNationen()
    {
        ArrayList <String> elementdaten = new ArrayList<>(); // Erzeugen der lokalen ArrayList mit Strings
        // Iteration mit for-each Schleife durch die Nation-Objekte um die Menge an Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        for (String key : nationen.keySet()) {
            elementdaten.add(key);
        }
        return elementdaten; // Die Keys werden als Strings in der ArrayList zurückgegeben.
    }
    
    /**
     * Ermitteln der Spiel-Paarungen durch zwei Array-Listen und zwei verschachtelten for-Schleifen.
     */
    public void ermittleSpielPaarungen()
    {
        // Lokale ArrayList speichert über die Methode gibNationen() die Keys der Nationen-Objekte.
        ArrayList <String> schlüssel = gibNationen();
        // Erzeugen einer globalen Array-List von Strings
        ArrayList <String> elemente = new ArrayList<String>();
        // Erste for-Schleie: Start der Zählvariablen 0, Druchlaufbedinung kleiner Anzahl der Nationen, Zählvariable um eins hochzählen.
        // Zweite for-Schleife: Der neuen Zählvaribale wird der Startwert der Ersten dazu addiert, Druchlaufbedinung kleiner Anzahl der Nationen, Zählvariable um eins hochzählen.
        // Die berechneten Integer-Werte der Schleife werden durch die in der Array-List befindlichen Strings ersetzt und am Ende auf der Konsole ausgegebn.
        for (int i = 0; i < anzahlNationen; i++) {
            for (int j = i+1; j < anzahlNationen; j++) {
                elemente.add((schlüssel.get(i)) + " gegen " + (schlüssel.get(j)));
            }
        }
        System.out.println(elemente);
    }
    
    /**
     * Globale ArrayList - gleich wie "public ArrayList<String> gibNationen()"
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
     * Liefere die Details der Nationen, die sich in der HashMap nationen befinden.
     * @return die Werte der Nation als String.
     */
    public String gibDetailsNation(String name)
    {
        // get - Wird verwendet, um den Wert (Strings Nationen-Objekt) zurückzugeben, dem der angegebene Schlüssel (name Nation) zugeordnet wurde.
        Nation nation = nationen.get(name);
        return nation.gibDetails();
    }
    
    /**
     * Verändere die Details der Nationen, die sich in der HashMap nationen befinden.
     * @return die veränderten Werte der Nation als String.
     */
    public String gibVeränderteDetailsNation(String name, int tore, int punkte)
    {
        // get - Wird verwendet, um den Wert (Strings Nationen-Objekt) zurückzugeben, dem der angegebene Schlüssel (name Nation) zugeordnet wurde.
        Nation nation = nationen.get(name);
        return nation.gibVeränderteDetails(tore, punkte);
    }
    
    /**
     * Entfernt alle Spielphasen in der HashMap.
     */
    public void entferneSpielphasen()
    {
        spielphasen.clear(); // clear - Wird verwendet, um alle Zuordnungen der Nationen-Objekte zu entfernen.
    }
    
    /**
     * Entfernt alle Nationen in der HashMap.
     */
    public void entferneNationen()
    {
        nationen.clear(); // clear - Wird verwendet, um alle Zuordnungen der Nationen-Objekte zu entfernen.
        anzahlNationen(); // Aktualisiert die Anzahl der Nationen in der HashMap
    }
}
