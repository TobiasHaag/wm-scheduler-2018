import java.util.HashMap; // Import-Anweisung um die Bibliotheksklasse HashMap in dieser Klasse verfügbar zu machen.
import java.util.ArrayList; // Import-Anweisung um die Bibliotheksklasse ArrayList in dieser Klasse verfügbar zu machen.
/**
 * Klasse Gruppe:
 * Die Klasse Gruppe enthält eine HashMap mt 8 Gruppen-Objekten, die jeweils 4 Nationen-Objekte als Value beinhalten.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 25.06.2018
 */
public class Gruppe
{
    private String gruppenname; // Gruppenname als String.
    private int anzahlNationen; // Anzahl der Nationen als Integer.
    private HashMap<String, Nation>nationen; // HashMap mit String als key und Nationen-Objekten als Value.
    /**
     * Konstruktor für Objekte der Klasse Gruppe.
     * Erzeugt werden die HashMap mit Nationen-Objekten und eine Methode um die Hashmap mit Schlüssel/Wert-Paaren der Nation zu füllen.
     */
    public Gruppe(String name)
    {
        this.gruppenname = name; // Der Wert des Übergabeparameters name wird dem Attribut gruppenname zu gewiesen.
        nationen = new HashMap<>(); // Erzeugen der HashMap mit Nationen-Objekten.
        erstelleNationenMap(); // Methodenaufruf, um die darin befindlichen Nationeninformationen der HashMap nationen zu übergeben.
        anzahlNationen = nationen.size(); // Setzt die Anzahl der Nationen in einer Gruppe auf die Anzahl der befindlichen Objekte in der Hashmap. 
    }

    /**
     * Die Methode fügt anhand der eingegebenen bzw. übereinstimmenden Gruppennamen die Schlüssel/Wert-Paare der Klasse Nation in die HashMap.
     * Dabei wird für jede Gruppe ein Objekt mit einer Hashmap angelegt und die dazugehörigen Nationen eingefügt.
     * Somit ergeben sich für 8 Objekt-Gruppen (A-H) jeweils 32 Nationen-Objekte. Dabei muss jedes Gruppen-Objekt einzeln angelegt werden.
     */
    private void erstelleNationenMap()
    {
        // If Bedinung die beim anlegen des Objekts prüft ob der eingegebene Name mit den Gruppenname übereinstimmt.
        // Ist dies der Fall dann werden die Schlüssel/Wert-Paare in die HashMap eingefügt.

        // GruppeA
        if (gruppenname == "A"){
            // put - Fügt in die HashMap ein neues Objekt der Klasse Nation hinzu.
            // Der Key vom Typ String und ist gleich der Name der Nation.
            // Für den Value wird ein neues Nationen-Objekt angelegt, das den Namen der Nation beinhaltet 
            // und die Tore bzw. Punkte werden standardmäßig auf die Werte 0 gesetzt.
            nationen.put("Russland", new Nation("Russland", 0, 0));
            nationen.put("Saudi-Arabien", new Nation("Saudi-Arabien", 0, 0));
            nationen.put("Ägypten", new Nation("Ägypten", 0, 0));
            nationen.put("Uruguay", new Nation("Uruguay", 0, 0));
        }
        // Gruppe B
        if (gruppenname == "B"){
            nationen.put("Marokko", new Nation("Marokko", 0, 0));
            nationen.put("Iran", new Nation("Iran", 0, 0));
            nationen.put("Portugal", new Nation("Portugal", 0, 0));
            nationen.put("Spanien", new Nation("Spanien", 0, 0));
        }
        // Gruppe C
        if (gruppenname == "C"){
            nationen.put("Frankreich", new Nation("Frankreich", 0, 0));
            nationen.put("Australien", new Nation("Australien", 0, 0));
            nationen.put("Peru", new Nation("Peru", 0, 0));
            nationen.put("Dänemark", new Nation("Dänemark", 0, 0));
        }
        // Gruppe D
        if (gruppenname == "D"){
            nationen.put("Argentinien", new Nation("Argentinien", 0, 0));
            nationen.put("Island", new Nation("Island", 0, 0));
            nationen.put("Kroatien", new Nation("Kroatien", 0, 0));
            nationen.put("Nigeria", new Nation("Nigeria", 0, 0));
        }
        // Gruppe E
        if (gruppenname == "E"){
            nationen.put("Costa Rica", new Nation("Costa Rica", 0, 0));
            nationen.put("Serbien", new Nation("Serbien", 0, 0));
            nationen.put("Brasilien", new Nation("Brasilien", 0, 0));
            nationen.put("Schweiz", new Nation("Schweiz", 0, 0));
        }
        // Gruppe F
        if (gruppenname == "F") {
            nationen.put("Deutschland", new Nation("Deutschland", 0, 0));
            nationen.put("Mexiko", new Nation("Mexiko", 0, 0));
            nationen.put("Schweden", new Nation("Schweden", 0, 0));
            nationen.put("Südkorea", new Nation("Südkorea", 0, 0));
        }
        // Gruppe G
        if (gruppenname == "G") {
            nationen.put("Belgien", new Nation("Belgien", 0, 0));
            nationen.put("Panama", new Nation("Panama", 0, 0));
            nationen.put("Tunesien", new Nation("Tunesien", 0, 0));
            nationen.put("England", new Nation("England", 0, 0));
        }
        // Gruppe H
        if (gruppenname == "H") {
            nationen.put("Polen", new Nation("Polen", 0, 0));
            nationen.put("Senegal", new Nation("Senegal", 0, 0));
            nationen.put("Kolumbien", new Nation("Kolumbien", 0, 0));
            nationen.put("Japan", new Nation("Japan", 0, 0));
        }
        // Damit der User auch ein Feedback bekommt das alle Gruppen erstellt wurden.
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
        anzahlNationen(); // Aktualisiert die Anzahl der Nationen in der HashMap.
    }

    /**
     * In die HashMap wird ein neues Objekt Nation mit Name, Tore und Punkte hinzugefügt.
     */
    public void fügeNationInGruppe(String name, int tore, int punkte)
    {
        nationen.put(name, new Nation(name, tore, punkte)); //  Über den Konstruktor der Klasse Nation wird ein neues Nationen-Objekt erzeugt.
        anzahlNationen(); // Aktualisiert die Anzahl der Nationen in der HashMap.
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
     * In dieser Klasse wird die ArrayList für die Ermittlung der Spielpaarungen verwendet.
     * @ return die Keys werden als Strings in der ArrayList zurückgegeben.
     */
    public ArrayList<String> gibAlleNationen()
    {
        ArrayList <String> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Nation-Objekte um die Menge an Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        for (String key : nationen.keySet()) {
            elementdaten.add(key); // add - Der ArrayList elementdaten werden alle Keys zugeordnet.
        }
        return elementdaten; 
    }
    
    /**
     * Ermitteln der Spiel-Paarungen durch zwei Array-Listen und zwei verschachtelten for-Schleifen.
     */
    public ArrayList <String> gibSpielPaarungen()
    {
        // ArrayList speichert über die Methode gibNationen() die Keys der Nationen-Objekte als Strings.
        ArrayList <String> schlüssel = gibAlleNationen();
        // Erzeugen einer lokalen ArrayList von Strings. Kann nur innerhalb dieser Methode verwendet werden.
        ArrayList <String> elementdaten = new ArrayList<String>();
        // Erste for-Schleie: Start der Zählvariablen 0, Druchlaufbedinung kleiner Anzahl der Nationen, Zählvariable um eins hochzählen.
        // Zweite for-Schleife: Der neuen Zählvariable wird der Startwert der Ersten dazu addiert, Druchlaufbedinung kleiner Anzahl der Nationen, Zählvariable um eins hochzählen.
        // Die berechneten Integer-Werte der Schleife werden durch die in der Array-List befindlichen Strings ersetzt und am Ende auf der Konsole ausgegebn.
        for (int i = 0; i < anzahlNationen; i++) {
            for (int j = i+1; j < anzahlNationen; j++) {
                elementdaten.add((schlüssel.get(i)) + " gegen " + (schlüssel.get(j)));
            }
        }
        return elementdaten; // Die Strings der Spielpaarungen werden auf der Konsole ausgegeben.
    }
    
    /**
     * String Methode, die den eingegebenen Namen mit den Namen der Klasse Nation abgleicht.
     * Stimmt der Name überein dann gibt die Nation-Methode die Tore der Nation zurück.
     * @return die Tore der Nation als Integer.
     */
    public int gibToreNation(String name)
    {
        // get - Wird verwendet, um den Wert (Strings Nationen-Objekt) zurückzugeben, dem der angegebene Schlüssel (name Nation) zugeordnet wurde.
        Nation nation = nationen.get(name); 
        return nation.gibTore();
    }

    /**
     * String Methode, die den eingegebenen Namen mit den Namen der Klasse Nation abgleicht.
     * Stimmt der Name überein dann gibt die Nation-Methode die Punkte der Nation zurück.
     * @return die Punkte der Nation als Integer.
     */
    public int gibPunkteNation(String name)
    {
        // get - Wird verwendet, um den Wert (Strings Nationen-Objekt) zurückzugeben, dem der angegebene Schlüssel (name Nation) zugeordnet wurde.
        Nation nation = nationen.get(name);
        return nation.gibPunkte();
    }

    /**
     * String Methode, die den eingegebenen Namen mit den Namen der Klasse Nation abgleicht.
     * Stimmt der Name überein dann gibt die Nation-Methode die Details der Nation zurück.
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
     * Entfernt alle Nationen in der HashMap.
     */
    public void entferneNationen()
    {
        nationen.clear(); // clear - Wird verwendet, um alle Zuordnungen der Nationen-Objekte zu entfernen.
        anzahlNationen(); // Aktualisiert die Anzahl der Nationen in der HashMap.
    }

    /**
     * Methode ohne Rückgabewerte, in der eine ArrayList mit Strings angelegt wird.
     * In der HashMap findet eine Iteration der Nationen-Keys durch eine for-each Schleife statt.
     * Die gefundenen Keys werden in die ArrayList übergeben und auf der Konsole ausgegeben.
     */
    public void zeigeNationen(){   
        // Erzeugen einer lokalen ArrayList von Strings. Kann nur innerhalb dieser Methode verwendet werden.
        ArrayList <String> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Nation-Objekte um die Menge an Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        for (String key : nationen.keySet()) {
            elementdaten.add(key); // add - Der ArrayList elementdaten werden alle Keys zugeordnet.
        }
        System.out.println(elementdaten); // Ausgabe der Nationen-Keys auf der Konsole.
    }
    
    /**
     * Methode, in der die erste ArrayList mit Nationen-Objekten und die Zweite mit Strings angelegt wird.
     * In der HashMap findet eine Iteration der Nationen-Keys durch eine for-each Schleife statt.
     * Die gefundenen Nationen-Keys vom Typ String durchlaufen danach eine for-Schleife mit der Schrittweite gleich der Anzahl der Keys.
     * Die Zählvariable verweist auf die Methode gibDetails() in der Klasse Nation und übergibt die Strings der Variable details.
     * @ return die Strings der Methode gibDetails() der Klasse Nation übergeben in die ArrayList details.
     */
    public ArrayList <String> gibDetailsNationen(){   
        // Erzeugen einer lokalen ArrayList von Nationen-Objekten. Kann nur innerhalb dieser Methode verwendet werden.
        ArrayList <Nation> elementdaten = new ArrayList<>();
        // Erzeugen einer lokalen ArrayList von Strings. Kann nur innerhalb dieser Methode verwendet werden.
        ArrayList <String> details = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Nation-Objekte um die Menge an Nationen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Nationen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        for (String key : nationen.keySet()) {
            elementdaten.add(nationen.get(key));
        }
        // for-Schleife: Start der Zählvariablen 0, Druchlaufbedinung kleiner Anzahl der Nationen-Keys (Strings), Zählvariable um eins hochzählen.
        // In der Schleife findet über die Zählvariable eine Objekt-Referenz statt.
        // Dabei wird für jede Zählvariable in die Klasse Nation gegangen und die Methode gibDetails() aufgerufen und der Variablen details die Strings übergeben.
        for (int i = 0; i <elementdaten.size(); i++) {
            Nation nation = elementdaten.get(i);
            details.add(nation.gibDetails());
        }
        return details;
    }
    
}
