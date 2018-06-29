import java.util.HashMap; // Import-Anweisung um die Bibliotheksklasse HashMap in dieser Klasse verfügbar zu machen.
import java.util.ArrayList; // Import-Anweisung um die Bibliotheksklasse ArrayList in dieser Klasse verfügbar zu machen.
/**
 * Klasse Turnier:
 * Die Klasse Turnier ist für das Anlegen der 8 Gruppen mit jeweils 4 Nationen zuständig.
 * Des Weiteren wird d
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 30.06.2018
 */
public class Turnier
{
    private HashMap<String, Gruppe> gruppen; // HashMap mit String als Key und Gruppen-Objekten als Value.
    /**
     * Konstruktor für Objekte der Klasse Turnier.
     * Erzeugt werden die HashMap mit Gruppen-Objekten und eine Methode um die Hashmap mit Schlüssel/Wert-Paaren der Gruppen zu füllen.
     */
    public Turnier()
    {
        gruppen = new HashMap<>(); // Erzeugen der HashMap mit Gruppen-Objekten.
        erstelleGruppenMap(); // Methodenaufruf, um die darin befindlichen Gruppeninformationen der HashMap gruppen zu übergeben.
        zeigeAlleNationenWerte(); // Methodenaufruf, um alle Nationen mit Toren und Punkten anzuzeigen.
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
        System.out.println("Speicherung der Gruppen:");
        gruppen.put("A", new Gruppe("A"));
        gruppen.put("B", new Gruppe("B"));
        gruppen.put("C", new Gruppe("C"));
        gruppen.put("D", new Gruppe("D"));
        gruppen.put("E", new Gruppe("E"));
        gruppen.put("F", new Gruppe("F"));
        gruppen.put("G", new Gruppe("G"));
        gruppen.put("H", new Gruppe("H"));
        System.out.println();
    }
    
    /**
     * Methode mit einer Boolean-Abfrage, die Nationen in der HashMap nach Namen überprüft.
     * Dabei wird der Key (Name der Nation als String) mit der Eingabe verglichen.
     */
    public boolean prüfeNation(String name)
    {
        // containsKey - Überprüft, die Zuordnung für den angegebenen Schlüssel.
        if(gruppen.containsKey(name)){
            return true; // Namen stimmen überein - Nation befindet sich bereits in der Hashmap.
        }
        else{
            return false; // Namen stimmen nicht überein - Nation befindet sich noch nicht in der Hashmap.
        }
    }
    
    /**
     * OK
     */
    public void zeigeAlleNationenSchlüssel(){   
        // Erzeugen einer lokalen ArrayList von Gruppen-Objekten.
        ArrayList <Gruppe> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Gruppen-Objekte um die Menge an Gruppen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Gruppen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        for (String key : gruppen.keySet()) {
            elementdaten.add(gruppen.get(key));
        }
        // for-Schleife: Start der Zählvariablen 0, Druchlaufbedinung kleiner Anzahl der Gruppe-Keys (Strings), Zählvariable um eins hochzählen.
        // In der Schleife findet über die Zählvariable eine Objekt-Referenz statt.
        // Dabei wird für jede Zählvariable in die Klasse Gruppe gegangen und die Methode gibAlleNationen() aufgerufen und in der Konsole ausgegeben.
        for (int i = 0; i <elementdaten.size(); i++) {
            Gruppe gruppe = elementdaten.get(i);
            System.out.println(gruppe.gibAlleNationen());
        }
    }
    
    /**
     * OK
     */
    public void zeigeAlleNationenWerte(){   
        // Erzeugen einer lokalen ArrayList von Gruppen-Objekten. Kann nur innerhalb dieser Methode verwendet werden.
        ArrayList <Gruppe> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Gruppen-Objekte um die Menge an Gruppen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Gruppen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        for (String key : gruppen.keySet()) {
            elementdaten.add(gruppen.get(key));
        }
        // for-Schleife: Start der Zählvariablen 0, Druchlaufbedinung kleiner Anzahl der Gruppe-Keys (Strings), Zählvariable um eins hochzählen.
        // In der Schleife findet über die Zählvariable eine Objekt-Referenz statt.
        // Dabei wird für jede Zählvariable in die Klasse Gruppe gegangen und die Methode gibDetailsNationen() aufgerufen und in der Konsole ausgegeben.
        System.out.println("Der aktuelle Spielplan mit allen Nationen, Toren & Punkten:");
        for (int i = 0; i <elementdaten.size(); i++) {
            Gruppe gruppe = elementdaten.get(i);
            System.out.println(gruppe.gibDetailsNationen());
        }
    }
    
    /**
     * OK
     */
    public void zeigeAlleGruppen()
    {
        // Erzeugen einer lokalen ArrayList von Gruppen-Objekten. Kann nur innerhalb dieser Methode verwendet werden.
        ArrayList <String> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Gruppen-Objekte um die Menge an Gruppen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Gruppen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        for (String key : gruppen.keySet()) {
            elementdaten.add(key);
        }
        System.out.println(elementdaten);
    }
    
    /**
     * OK
     */
    public Gruppe gibGruppeÜberNation(String nation)
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
     * OK
     */
    public void zeigeNationTore(String gruppenname, String nationname)
    {
           Gruppe gruppe = gruppen.get(gruppenname);
           System.out.println (gruppe.gibToreNation(nationname));
    }
    
    /**
     * OK
     */
    public void zeigeNationPunkte(String gruppenname, String nationname)
    {
           Gruppe gruppe = gruppen.get(gruppenname);
           System.out.println (gruppe.gibPunkteNation(nationname));
    }
    
    /**
     * OK
     */
    public void zeigeNationDetails(String gruppenname, String nationname)
    {
           Gruppe gruppe = gruppen.get(gruppenname);
           System.out.println (gruppe.gibDetailsNation(nationname));
    }
    
    /**
     * OK
     */
    public String gibDetailsSpielergebnis(String nation, int tore, int punkte)
    {
        Gruppe gruppe = gibGruppeÜberNation(nation);
        String daten = gruppe.gibVeränderteDetailsNation(nation, tore, punkte);
        return daten;
    }
    
    /**
     * OK
     */
    public void zeigeAlleTurnierPaarungen(){   
        // Erzeugen einer lokalen ArrayList von Gruppen-Objekten. Kann nur innerhalb dieser Methode verwendet werden.
        ArrayList <Gruppe> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Gruppen-Objekte um die Menge an Gruppen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Gruppen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        for (String key : gruppen.keySet()) {
            elementdaten.add(gruppen.get(key));
        }
        // for-Schleife: Start der Zählvariablen 0, Druchlaufbedinung kleiner Anzahl der Gruppe-Keys (Strings), Zählvariable um eins hochzählen.
        // In der Schleife findet über die Zählvariable eine Objekt-Referenz statt.
        // Dabei wird für jede Zählvariable in die Klasse Gruppe gegangen und die Methode gibDetailsNationen() aufgerufen und in der Konsole ausgegeben.
        System.out.println("Alle Spielpaarungen im Überblick:");
        for (int i = 0; i <elementdaten.size(); i++) {
            Gruppe gruppe = elementdaten.get(i);
            System.out.println(gruppe.gibSpielPaarungen());
        }
    }
    
    /**
     * OK
     */
    public void zeigeTurnierPaarungenFürGruppe(String gruppenname){   
        // Erzeugen einer lokalen ArrayList von Gruppen-Objekten. Kann nur innerhalb dieser Methode verwendet werden.
        ArrayList <Gruppe> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Gruppen-Objekte um die Menge an Gruppen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Gruppen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        System.out.println();
        System.out.println("Spielpaarung der Gruppe " + gruppenname +  " im Überblick:");
        for (String key : gruppen.keySet()) {
            elementdaten.add(gruppen.get(key));
        }
        Gruppe gruppe = gruppen.get(gruppenname);
        System.out.println (gruppe.gibSpielPaarungen());
    }
    
    /**
     * OK
     */
    public void fügeGruppeHinzu(String gruppenname)
    {
           gruppen.put(gruppenname, new Gruppe(gruppenname));
    }
    
    /**
     * OK
     */
    public void fügeNeueNationInGruppeHinzu(String gruppenname, String nationname)
    {
        gruppen.put(gruppenname, new Gruppe(gruppenname));
        Gruppe gruppe = gruppen.get(gruppenname);
        System.out.println (gruppe.erstelleNeueNation(nationname));
    }
    
    /**
     * OK
     */
    public void fügeNationMitWertenInGruppeHinzu(String gruppenname, String nationname, int nationtore, int nationpunkte)
    {
        gruppen.put(gruppenname, new Gruppe(gruppenname));
        Gruppe gruppe = gruppen.get(gruppenname);
        System.out.println (gruppe.erstelleNationMitWerten(nationname, nationtore, nationpunkte));
    }
    
    /**
     * OK
     */
    public void Spielergebnis (String gruppenname, String nation1, int tore1, String nation2, int tore2)
    {
        int punkte1 = 0;
        int punkte2 = 0;
        ArrayList<String> nation1Ergebnis = new ArrayList <>();
        ArrayList<String> nation2Ergebnis = new ArrayList <>();
        if(tore1 > tore2){
            punkte1 = 3;
        }
        if(tore1 < tore2){
            punkte2 = 3;
        }
        if(tore1 == tore2){
            punkte1 = 1;
            punkte2 = 1;
        }
        Gruppe gruppe = gruppen.get(gruppenname);
        nation1Ergebnis.add(gruppe.gibVeränderteDetailsNation(nation1, tore1, punkte1));
        nation2Ergebnis.add(gruppe.gibVeränderteDetailsNation(nation2, tore2, punkte2));
    } 
}
