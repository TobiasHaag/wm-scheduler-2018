import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Paarungen.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 03.06.2018
 */
public class Paarungen
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList<Spiel> spiele;

    /**
     * Konstruktor für Objekte der Klasse Paarung
     */
    public Paarungen()
    {
        // Instanzvariable initialisieren
        spiele = new ArrayList<>();
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void spielHinzufügen(String landX, String landY, int torX, int torY, String beschreibung)
    {
        spiele.add(new Spiel(landX, landY, torX, torY, beschreibung));
    }

    public int gibAnzahlSpiele()
    {
        return spiele.size();
    }

    public String gibSpielDetails(int index)
    {
        Spiel spiel = spiele.get(index);
        return spiel.gibDetails();
    }
}
