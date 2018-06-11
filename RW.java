import java.io.*;
import java.lang.*;
/**
 * 
 */
public class RW
{
    /**
     * 
     */
    public RW()
    {
        
    }

    public String ladeDatei(String ordner, String dateiname) throws IOException
    {
        String datei = ordner + "|" + dateiname + ".txt";
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
    public  void speichereNation(String daten) throws IOException
    {
        String[] teil = daten.split("|");
        
        String datei = "Nationen|" + teil[0] + ".txt";
        FileWriter fw = new FileWriter(datei);
        BufferedWriter bw = new BufferedWriter(fw);

        

        for (int x = 0; x < teil.length; x++) {
            bw.write(teil[x]);
            if(x<teil.length){bw.newLine();};
        }
        
        bw.close();
    }
    
    /**
     * 
     */
    public  void appendGruppe(String dateiName, String daten) throws IOException
    {
        //hier brauche ich die Info welche Gruppe es ist
        
        String datenAlt = ladeDatei("Gruppen", dateiName);
        
        String datei = "Gruppe|" + dateiName + ".txt";
        FileWriter fw = new FileWriter(datei, true);
        BufferedWriter bw = new BufferedWriter(fw);

        if(datenAlt.contains(daten) == false){
            bw.newLine();
            bw.write(daten);
        }
        
        bw.close();
    }
}