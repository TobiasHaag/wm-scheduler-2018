import java.io.*;
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

    public String ladeDatei(String ordner, String dateiname) throws IOException
    {
        String datei = ordner + "|" + dateiname + ".txt";
        FileReader fr = new FileReader(datei);
        BufferedReader br = new BufferedReader(fr);

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
    public  void speichereLand(String daten) throws IOException
    {
        String[] teil = daten.split("|");
        
        String datei = "Länder/" + teil[0] + ".txt";
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
    public  void appendGruppe(String daten) throws IOException
    {
        //hier brauche ich die Info welche Gruppe es ist
        
        String[] teile = daten.split("|");
        
        String datei = "Gruppe|" + teile[0] + ".txt";
        FileWriter fw = new FileWriter(datei);
        BufferedWriter bw = new BufferedWriter(fw);

        

        for (int x = 0; x < teile.length; x++) {
            bw.write(teile[x]);
            if(x<teile.length){bw.newLine();};
        }
        
        bw.close();
    }
}