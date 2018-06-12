/**
 * Beschreiben Sie hier die Klasse Nation.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 11.06.2018
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
    public void setzeDetails(String name, int tore, int punkte)
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
     * Liefere die Anzahl der Punkte.
     * @return die Punkte.
     */
    public int gibPunkte()
    {
        return punkte;
    }

     public String verändereDetails(int tore, int punkte)
    {
        this.tore = tore;
        this.punkte = punkte;
        return gibDetails();
    }
    
    /**
     * Liefere Details über die Nation: Name, Tore und Punkte.
     * @return die Nationen-Details.
     */
    public String gibDetails()
    {
        return name + "|" + String.valueOf(tore) + "|" + String.valueOf(punkte);
    }
    
}
