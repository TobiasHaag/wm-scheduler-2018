/**
 * Klasse Nation:
 * Die Klasse Nation enthält die Variablen name, tore & punkte um eine Nation zu implementieren.
 * Die Getter-Methoden lieferen die Details aus den initalisierten Nationen-Variablen zurück.
 *
 * @author Tobias Haag | HfG | IoT3
 * @version 19.06.2018
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
        this.name = name;
        this.tore = tore;
        this.punkte = punkte;
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
     * Verändere die Variablen Tore und Punkte der Nation.
     * Keine void Methode verwendet, da sonst keine Rückgabeparameter.
     * @return rufe die Methode gibDetails() auf um die veränderten Nationen-Details zurückzugeben.
     */
    public String gibVeränderteDetails (int tore, int punkte)
    {
        // this - Schlüsselwort wird als Übergabeparameter verwendet um die Details zu überschreiben.
        this.tore = tore;
        this.punkte = punkte;
        return gibDetails();
    }

}
