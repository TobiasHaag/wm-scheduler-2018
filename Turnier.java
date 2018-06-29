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
     * @return true oder false des Nationen-Namen.
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
     * Methode um auf der Konsole alle Gruppennamen des Turniers anzuzeigen.
     * Dazu wird durch alle Keys in der HashMap Gruppe iteriert, die Keys in eine ArrayList überführt und ausgegeben. 
     */
    public void zeigeAlleGruppen()
    {
        // Erzeugen einer lokalen ArrayList von Strings.
        ArrayList <String> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Gruppen um die Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        for (String key : gruppen.keySet()) {
            elementdaten.add(key); // add - Der ArrayList elementdaten werden alle Keys zugeordnet.
        }
        System.out.println();
        System.out.println("Die Gruppen des Turniers:");
        System.out.println(elementdaten);
    }

    /**
     * Es werden alle Nationen die bei diesem Turnier beteiligt sind dargestellt.
     * Anhand der Iteration der Keys der Gruppe und einer for-Schleife die auf die Methode gibAlleNationen
     * in der Klasse Gruppe zugreift werden alle Nationen in der Konsole angezeigt.
     */
    public void zeigeAlleNationenSchlüssel()
    {   
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
        System.out.println("Alle beteiligten Nationen des Turniers:");
        for (int i = 0; i <elementdaten.size(); i++) {
            Gruppe gruppe = elementdaten.get(i);
            System.out.println(gruppe.gibAlleNationen());
        }
    }

    /**
     * Diese Methode wird im Konstruktor aufgerufen, damit man den aktuellen Stand des Turniers betrachten kann.
     * Es werden alle Nationen mit Toren & Punkten, die bei diesem Turnier beteiligt sind dargestellt.
     * Anhand der Iteration der Keys der Gruppe und einer for-Schleife die auf die Methode gibDetailsNationen
     * in der Klasse Gruppe zugreift werden alle Informationen in der Konsole angezeigt.
     */
    public void zeigeAlleNationenWerte(){   
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
        // Dabei wird für jede Zählvariable in die Klasse Gruppe gegangen und die Methode gibDetailsNationen() aufgerufen und in der Konsole ausgegeben.
        System.out.println("Der aktuelle Spielplan mit allen Nationen, Toren & Punkten:");
        for (int i = 0; i <elementdaten.size(); i++) {
            Gruppe gruppe = elementdaten.get(i);
            System.out.println(gruppe.gibDetailsNationen());
        }
    }

    /**
     * Diese Methode ermöglicht es dem Nutzer über die Nation die dazugehörige Gruppe erhauszufinden.
     * Mit der Iteration über den Key der Gruppe in der HashMap und einer If-Bedinung wird der Key
     * mit der Eingabe verglichen und das Objekt der Klasse Gruppe zurückgegeben.
     * @return das Gruppen-Objekt in der sich die Nation befindet.
     */
    public Gruppe gibGruppeÜberNation(String nation)
    {
        // Iteration mit for-each Schleife durch die Gruppen-Objekte um die Menge an Gruppen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Gruppen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        for (String key : gruppen.keySet()) {
            Gruppe gruppe = gruppen.get(key);
            // If-Bedingung prüft über die Methode prüfeNation in der Klasse Gruppe ob die Nation true ist.
            // Falls die Bedinung true ist wird das Gruppen-Objekt zurückgegeben, falls nicht der Returnwert null.
            if(gruppe.prüfeNation(nation) == true){
                return gruppe;
            }
        }
        return null;
    }

    /**
     * Diese Methode ermöglicht es dem Nutzer über die Eingabe zweier Nationen die Gruppe zu ermitteln.
     * Mit der Iteration über die Keys der Gruppe in der HashMap und einer If-Bedinung werden die Keys
     * mit den Eingaben verglichen.
     * Sind diese true werden die zwei Gruppen-Keys untereinander verglichen und liefern die Gruppe zurück oder null. 
     * @return der Gruppenname als String oder null.
     */
    public String prüfeNationenInGruppe(String nation1, String nation2)
    {
        // Variablen vom Typ String mit leeren Zeichenketten.
        String gruppe1 = "";
        String gruppe2 = "";
        // Iteration mit for-each Schleife durch die Gruppen-Objekte um die Menge an Gruppen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Gruppen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        for (String key : gruppen.keySet()) {
            Gruppe gruppe = gruppen.get(key);
            // If-Bedingung prüft über die Methode prüfeNation in der Klasse Gruppe ob die Nation true ist.
            // Falls die Bedinung true ist wird der Variablen gruppe1/2 der Key der Gruppe übertragen.
            if(gruppe.prüfeNation(nation1) == true){
                gruppe1 = key;
            }
            if(gruppe.prüfeNation(nation2) == true){
                gruppe2 = key;
            }
        }
        // Die Gruppen-Keys werden verglichen und falls diese gleich sind wird die Gruppe ausgegeben oder nichts. 
        if(gruppe1 == gruppe2){
            return gruppe1;
        }
        else{
            return null;
        }
    }

    /**
     * Methode zeigt die Tore der eingegebenen Nation an.
     */
    public void zeigeNationTore(String gruppenname, String nationname)
    {
        // get - Wird verwendet, um den Wert (Gruppen-Objekt) zurückzugeben, dem der angegebene Gruppenname zugeordnet wurde.
        Gruppe gruppe = gruppen.get(gruppenname);
        // In der Klasse Gruppe wird die Methode gibToreNation mit dem Parameter nationname aufgerufen. 
        System.out.println (gruppe.gibToreNation(nationname));
    }

    /**
     * Methode zeigt die Punkte der eingegebenen Nation an.
     */
    public void zeigeNationPunkte(String gruppenname, String nationname)
    {
        // get - Wird verwendet, um den Wert (Gruppen-Objekt) zurückzugeben, dem der angegebene Gruppenname zugeordnet wurde.   
        Gruppe gruppe = gruppen.get(gruppenname);
        // In der Klasse Gruppe wird die Methode gibPunkteNation mit dem Parameter nationname aufgerufen. 
        System.out.println (gruppe.gibPunkteNation(nationname));
    }

    /**
     * Methode zeigt die Details (Name,Tore,Punkte) der eingegebenen Nation an.
     */
    public void zeigeNationDetails(String gruppenname, String nationname)
    {
        // get - Wird verwendet, um den Wert (Gruppen-Objekt) zurückzugeben, dem der angegebene Gruppenname zugeordnet wurde. 
        Gruppe gruppe = gruppen.get(gruppenname);
        // In der Klasse Gruppe wird die Methode gibDetailsNation mit dem Parameter nationname aufgerufen.
        System.out.println (gruppe.gibDetailsNation(nationname));
    }

    /**
     * Methode um einer Nation Tore oder Punkte zuzuweisen.
     * Über die Methode gibGruppeÜberNation wird zu der dazugehörigen Nation die Gruppe herausgefunden und dem Objekt übergeben.
     * In der richtigen Gruppe der Klasse, wird über die Methode gibVeränderteDetailsNation die Werte für die Nation geändert
     * und der Variablen elementdaten übergeben.
     * @return die Information, das die Nation veränderte Werte bekommen hat.
     */
    public String gibVeränderteDetailsSpielergebnis(String nation, int tore, int punkte)
    {
        // Übergibt dem Objekt aus Gruppe die Methode gibGruppeÜberNation mit dem Parameter Nation.
        Gruppe gruppe = gibGruppeÜberNation(nation);
        // In der Klasse Gruppe wird die Methdode gibVeränderteDetailsNation aufgerufen und auf die Variable referenziert.
        String elementdaten = gruppe.gibVeränderteDetailsNation(nation, tore, punkte);
        return elementdaten;
    }

    /**
     * Mit dieser Methode werden alle Turnierpaarungen ausgegeben.
     * Anhand der Iteration der Keys der Gruppe und einer for-Schleife die auf die Methode gibSpielPaarungen
     * in der Klasse Gruppe zugreift werden alle Spielpaarungen in der Konsole angezeigt.
     */
    public void zeigeAlleTurnierPaarungen(){   
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
        // Dabei wird für jede Zählvariable in die Klasse Gruppe gegangen und die Methode gibDetailsNationen() aufgerufen und in der Konsole ausgegeben.
        System.out.println("Alle Spielpaarungen im Überblick:");
        for (int i = 0; i <elementdaten.size(); i++) {
            Gruppe gruppe = elementdaten.get(i);
            System.out.println(gruppe.gibSpielPaarungen());
        }
    }

    /**
     * Mit dieser Methode werden Turnierpaarungen der Gruppe ausgegeben.
     * Anhand der Iteration der Keys der Gruppe und einer for-Schleife die auf die Methode gibSpielPaarungen
     * in der Klasse Gruppe zugreift werden alle Spielpaarungen der Gruppe in der Konsole angezeigt.
     */
    public void zeigeTurnierPaarungenFürGruppe(String gruppenname){   
        // Erzeugen einer lokalen ArrayList von Gruppen-Objekten.
        ArrayList <Gruppe> elementdaten = new ArrayList<>();
        // Iteration mit for-each Schleife durch die Gruppen-Objekte um die Menge an Gruppen-Keys zu erhalten.
        // keySet - Wird verwendet, um in der Map die enthaltenen Schlüssel zu erhalten.
        // get - Wird verwendet, um den Wert (Strings Gruppen-Objekt) zurückzugeben, dem der angegebene Schlüssel zugeordnet wurde.
        System.out.println();
        System.out.println("Spielpaarung der Gruppe " + gruppenname +  " im Überblick:");
        for (String key : gruppen.keySet()) {
            elementdaten.add(gruppen.get(key));
        }
        // get - Wird verwendet, um den Wert (Gruppen-Objekt) zurückzugeben, dem der angegebene Gruppenname zugeordnet wurde.
        Gruppe gruppe = gruppen.get(gruppenname);
        // In der Klasse Gruppe wird die Methode gibSpielPaarungen aufgerufen.
        System.out.println (gruppe.gibSpielPaarungen());
    }

    /**
     * In die HashMap gruppen wird ein neues Objekt Gruppe über den Gruppennamen hinzugefügt.
     */
    public void fügeGruppeHinzu(String gruppenname)
    {
        // Über den Konstruktor der Klasse Turnier wird ein neues Gruppen-Objekt erzeugt.
        // put - Fügt in die HashMap ein neues Objekt der Klasse Gruppe hinzu.
        // Der Key vom Typ String ist gleich der Name der Gruppe.
        // Für den Value wird ein neues Gruppen-Objekt angelegt, das den Namen der Gruppe beinhaltet.
        gruppen.put(gruppenname, new Gruppe(gruppenname));
    }

    /**
     * In die HashMap gruppen wird ein neues Objekt Nation über den Gruppennamen & Nationname hinzugefügt.
     */
    public void fügeNeueNationInGruppeHinzu(String gruppenname, String nationname)
    {
        // Über den Konstruktor der Klasse Turnier wird ein neues Gruppen-Objekt erzeugt.
        // put - Fügt in die HashMap ein neues Objekt der Klasse Gruppe hinzu.
        // Der Key vom Typ String ist gleich der Name der Gruppe.
        // Für den Value wird ein neues Gruppen-Objekt angelegt, das den Namen der Gruppe beinhaltet.
        gruppen.put(gruppenname, new Gruppe(gruppenname));
        // get - Wird verwendet, um den Wert (Gruppen-Objekt) zurückzugeben, dem der angegebene Gruppenname zugeordnet wurde.
        Gruppe gruppe = gruppen.get(gruppenname);
        // In der Klasse Gruppe wird die Methode erstelleNeueNation mit dem Parameter nationname aufgerufen.
        System.out.println (gruppe.erstelleNeueNation(nationname));
    }

    /**
     * In die HashMap gruppen wird ein neues Objekt Nation über den gruppenname, nationname, nationtore, nationpunkte hinzugefügt.
     */
    public void fügeNationMitWertenInGruppeHinzu(String gruppenname, String nationname, int nationtore, int nationpunkte)
    {
        // Über den Konstruktor der Klasse Turnier wird ein neues Gruppen-Objekt erzeugt.
        // put - Fügt in die HashMap ein neues Objekt der Klasse Gruppe hinzu.
        // Der Key vom Typ String ist gleich der Name der Gruppe.
        // Für den Value wird ein neues Gruppen-Objekt angelegt, das den Namen der Gruppe beinhaltet.
        gruppen.put(gruppenname, new Gruppe(gruppenname));
        // get - Wird verwendet, um den Wert (Gruppen-Objekt) zurückzugeben, dem der angegebene Gruppenname zugeordnet wurde.
        Gruppe gruppe = gruppen.get(gruppenname);
        // In der Klasse Gruppe wird die Methode erstelleNationMitWerten mit dem Parameter nationname, nationtore, nationpunkte aufgerufen.
        System.out.println (gruppe.erstelleNationMitWerten(nationname, nationtore, nationpunkte));
    }

    /**
     * In der Methode werden die Spielergebnisse 
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
