/**
 * Klasse Nation:
 * Die Klasse Nation enthält die Variablen name, tore & punkte um eine Nation zu implementieren.
 * Die Getter-Methoden lieferen die Details aus den initalisierten Nationen-Variablen zurück.
 *
 * Prüfung Programmiersprachen2
 * @author Tobias Haag | HfG | IoT3
 * @version 30.06.2018
 */
public class Nation
{
    // Name der Nation.
    private String name;
    // Die geschossenen Tore.
    private int tore;
    // Die erreichten Punkte.
    private int punkte;
    /**
     * Konstruktor für Objekte der Klasse Nation.
     * @param name der Name der Nation.
     * @param tore die Anzahl der geschossenen Tore.
     * @param punkte die Anzahl der erreichten Punkte.
     */
    public Nation(String name, int tore, int punkte)
    {
        setzeDetails(name, tore, punkte);
    }

    /**
     * Lege die Details der Nation fest.
     * @param name der Name der Nation.
     * @param tore die Anzahl der Tore einer Nation.
     * @param punkte die Anzahl der Punkte einer Nation.
     */
    public void setzeDetails (String name, int tore, int punkte)
    {
        this.name = name; // Der Wert des Übergabeparameters name wird dem Attribut name zu gewiesen.
        this.tore = tore; // Der Wert des Übergabeparameters tore wird dem Attribut tore zu gewiesen.
        this.punkte = punkte; // Der Wert des Übergabeparameters punkte wird dem Attribut punkte zu gewiesen.
    }

    /**
     * Liefere den Namen.
     * @return der Name.
     */
    public String gibName ()
    {
        return name;
    }

    /**
     * Liefere die Anzahl der Tore.
     * @return die Tore.
     */
    public int gibTore()
    {
        return tore;
    }

    /**
     * Liefere die Anzahl der Punkte.
     * @return die Punkte.
     */
    public int gibPunkte()
    {
        return punkte;
    }

    /**
     * Liefere Details über die Nation: Name, Tore und Punkte.
     * Tore und Punkte werden in Stings umgewandelt.
     * @return die Nationen-Details mit String-Trennung
     */
    public String gibDetails ()
    {
        // String.valueOf - Gibt die Zeichenfolgendarstellung des int-Arguments von tore & punkte zurück.
        return name + "|" + String.valueOf(this.tore) + "|" + String.valueOf(this.punkte);
    }

    /**
     * Liefere Details über die Nation als Array mit Strings: Name, Tore und Punkte.
     * @return die Nationen-Details als Strings.
     */
    public String[] gibDetailsArray ()
    {
        String[] nationDetails = {"", "",""}; // Erzeugen eines lokalen Arrays mit drei leeren Zeichenketten.
        nationDetails[0] = this.name; // Der Wert des Übergabeparameters name wird dem ersten Array zugewiesen.
        // toString - Primitiver Datentyp z.B. Integer wird als String-Objekt zurückgegeben.
        nationDetails[1] = Integer.toString(this.tore); // Der Wert des Übergabeparameters tore wird dem zweiten Array zugewiesen.
        nationDetails[2] = Integer.toString(this.punkte); // Der Wert des Übergabeparameters punkte wird dem dritten Array zugewiesen.
        return nationDetails;
    }
    
    /**
     * Verändere die Variablen Tore und Punkte der Nation.
     * Keine void Methode verwendet, da sonst keine Rückgabeparameter.
     * @return rufe die Methode gibDetails() auf um die veränderten Nationen-Details zurückzugeben.
     */
    public String gibVeränderteDetails (int tore, int punkte)
    {
        // this - Schlüsselwort wird als Übergabeparameter verwendet um die Details wie Tore und Punkte zu überschreiben.
        this.tore += tore; // Addiert zu den vorhandenen Tore neue hinzu.
        this.punkte += punkte; // Addiert zu den vorhandenen Punkten neue hinzu.
        return gibDetails();
    }
}
