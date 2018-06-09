
/**
 * Beschreiben Sie hier die Klasse Land.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 04.06.2018
 */
public class Land
{
    // Name des Landes.
    private String name;
    // Die geschossenen Tore.
    private int tore;
    // Die erreichten Punkte.
    private int punkte;

    /**
     * Konstruktor für Objekte der Klasse Land.
     * @param name der Name der Nation.
     * @param tore die Anzahl der geschossenen Tore.
     * @param punkte die Anzahl der erreichten Punkte.
     */
    public Land(String name, int tore, int punkte)
    {
        setzeDetails(name, tore, punkte);
    }

    /**
     * Lege die Details des Landes fest.
     * @param name der Name der Nation.
     * @param tore die Anzahl der Tore eines Landes.
     * @param punkte die Anzahl der Punkte eines Landes. 
     */
    private void setzeDetails(String name, int tore, int punkte)
    {
        this.name = name;
        this.tore = tore;
        this.punkte = punkte;
    }

    /**
     * Liefere den Namen.
     * @return der Name.
     */
    public String gibName()
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
     * Liefere die Anzahl der punkte.
     * @return die Punkte.
     */
    public int gibPunkte()
    {
        return punkte;
    }

    /**
     * Liefere Details über das Land: Name, Tore und Punkte.
     * @return die Länder-Details.
     */
    public String gibDetails()
    {
        return "Name: " + name + " Tore: " + tore + " Punkte: " + punkte;
    }
}
