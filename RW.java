import java.io.*; //java.io - Das Package enthält eine Sammlung von Klassen, die die Ein- und Ausgabe sowie Dateiverwaltung unterstützen.
/**
 * Klasse RW:
 * Die Klasse Read&Write ...
 *
 * @author Tobias Haag | HfG | IoT3
 * @version 12.06.2018
 */
public class RW
{
    /**
     * Konstruktor für Klasse RW.
     * Keine Übergabeparameter beim Anlegen von Objekten.
     */
    public RW()
    {

    }
    //throws IOException - Diese checked Exception muss entweder gefangen oder deklariert werden.
    public String ladeDatei(String ordner, String dateiname) throws IOException
    {
        String datei = ordner + "/" + dateiname + ".txt";
        FileReader fr = new FileReader(datei); // Klasse FileReader - Übergabe des Lesers die Dateinamen als String
        BufferedReader br = new BufferedReader(fr); //Klasse BufferedReader - Liest und puffert ganze Zeilen

        String daten = "";

        String zeile = "";

        while( (zeile = br.readLine()) != null )
        {
            daten += zeile;
            daten += "/";
        }

        br.close(); // InputStreams und Reader schließen

        return daten;
    }

}
