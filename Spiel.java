
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 03.06.2018
 */
public class Spiel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String landX;
    private String landY;
    private int torX;
    private int torY;
    private String beschreibung;

    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel(String landX, String landY, int torX, int torY, String beschreibung)
    {
        setzeDetails(landX, landY, torX, torY, beschreibung);
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void setzeDetails(String landX, String landY, int torX, int torY, String beschreibung)
    {
        this.landX = landX;
        this.landY = landY;
        this.torX = torX;
        this.torY = torY;
        this.beschreibung = beschreibung;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public String gibDetails()
    {
        return landX + " - " + torX + " : " + torY + " - " + landY;
    }
}