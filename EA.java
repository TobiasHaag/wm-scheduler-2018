import java.io.*;
import java.lang.*;
/**
 * 
 */
public class EA
{
    /**
     * 
     */
    public EA()
    {
        
    }

    public String ladeDatei(String nameordner, String namedatei) throws IOException
    {
        String datei = nameordner + "|" + namedatei + ".txt";
        FileReader fr = new FileReader(datei); // Übergabe des Dateinamens als String 
        BufferedReader br = new BufferedReader(fr); //Liest und puffert ganze Zeilen 

        String daten = "";
        String zeile = "";

        while( (zeile = br.readLine()) != null )
        {
            daten += zeile;
            daten += "|";
        }

        br.close();

        return daten;
    }

    /**
     * 
     */
    public  void speichereNation(String datennation) throws IOException
    {
        String[] nationenteilung = datennation.split("|");
        
        String datei = "Nationen|" + nationenteilung[0] + ".txt";
        FileWriter fw = new FileWriter(datei);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int x = 0; x < nationenteilung.length; x++) {
            bw.write(nationenteilung[x]);
            if(x<nationenteilung.length){bw.newLine();};
        }
        
        bw.close();
    }
    
    /**
     * 
     */
    public  void speichereGruppe1(String datengruppe) throws IOException
    {
        String[] gruppenteilung = datengruppe.split("|");
        
        String datei = "Nationen|" + gruppenteilung[0] + ".txt";
        FileWriter fw = new FileWriter(datei);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int x = 0; x < gruppenteilung.length; x++) {
            bw.write(gruppenteilung[x]);
            if(x<gruppenteilung.length){bw.newLine();};
        }
        
        bw.close();
    }
    
    /**
     * 
     */
    public  void speichereGruppe2(String gruppenname, String daten) throws IOException
    {
        String datei = "Gruppen|" + gruppenname + ".txt";
        FileWriter fw = new FileWriter(datei, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.newLine();
        bw.write(daten);
        
        bw.close();
    }
}