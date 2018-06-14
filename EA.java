import java.io.*; //java.io - Das Package enthält eine Sammlung von Klassen, die die Ein- und Ausgabe sowie Dateiverwaltung unterstützen.
/**
 * Klasse EA:
 * Die Klasse Ein&Ausgabe ...
 * @author Tobias Haag | HfG | IoT3
 * @version 12.06.2018
 */
public class EA
{
    /**
     * Konstruktor für Klasse EA.
     * Keine Übergabeparameter beim Anlegen von Objekten.
     */
    public EA()
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

    /**
     * 
     */
    public  void speichereNation(String daten) throws IOException
    {
        String[] teile = daten.split("|");

        String datei = "Nationen|" + teile[0] + ".txt";
        FileWriter fw = new FileWriter(datei);
        BufferedWriter bw = new BufferedWriter(fw);


        for (int x = 0; x < teile.length; x++) {
            bw.write(teile[x]);
            if(x<teile.length){bw.newLine();};
        }

        bw.close();
    }

    /**
     * 
     */
    public  void speichereGruppe(String dateiName, String daten) throws IOException
    {
        String datei = "Gruppen|" + dateiName + ".txt";
        FileWriter fw = new FileWriter(datei, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.newLine();
        bw.write(daten);

        
        bw.close();
    }
}
