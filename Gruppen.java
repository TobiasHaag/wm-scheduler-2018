import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Gruppen.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 02.06.2018
 */
public class Gruppen
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList<Land> gruppe;

    /**
     * Konstruktor für Objekte der Klasse Gruppen
     */
    public Gruppen()
    {
        // Instanzvariable initialisieren
        gruppe = new ArrayList<>();
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void landHinzufügen(Land name)
    {
        gruppe.add(name);
    }
}
