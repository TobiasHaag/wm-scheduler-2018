import java.util.HashMap;
/**
 * Beschreiben Sie hier die Klasse Gruppe.
 * 
 * @author Tobias Haag | HfG | IoT3
 * @version 11.06.2018
 */
public class Gruppe
{
    private HashMap<String, Nation> nationen;
    private int anzahlNationen;
    private EA ea;
    private HashMap<String, String> spiele;
    /**
     *
     */
    public Gruppe(String name)
    {
        nationen = new HashMap<>();
        spiele = new HashMap<>();
        ea = new EA();
        ladeGruppeninfo(name);
    }

    /**
     * 
     */
    public void erstelleNation(String name)
    {
        Nation nation = new Nation(name, 0, 0);
        nationen.put(name, nation);
        anzahlNationen += 1;
    }

    /**
     * 
     */
    public void ladeNation(String name)
    {
        String[] teile = gibDatenTeile("Nationen", name);

        String nameNation = teile[0];
        int tore = Integer.valueOf(teile[1]);
        int punkte = Integer.valueOf(teile[2]);

        nationen.put(nameNation, new Nation(nameNation, tore, punkte));

    }

    /**
     * 
     */
    public void ladeGruppeninfo(String name)
    {
        String[] teile = gibDatenTeile("Gruppen", name);

        anzahlNationen = Integer.valueOf(teile[0]);
        for (int i = 1; i <= anzahlNationen; i++) {
            ladeNation(teile[i]);
        }

        if(teile.length >= anzahlNationen+2){
            for (int i = anzahlNationen+1; i < teile.length; i++) {
                String[] daten = teile[i].split("-");
                spiele.put(daten[0], daten[1]);
            }
        }
    }

    /**
     * 
     */
    public String[] gibDatenTeile(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = ea.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] teile = daten.split("|");
        return teile;
    }

    /**
     * 
     */
    public String gibDaten(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = ea.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return daten; 
    }

    /**
     *
     */
    public boolean nationenPrüfen(String name)
    {
        if(nationen.containsKey(name)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     */
    public String verändereDetailsNation(String name, int tore, int punkte)
    {
        Nation nation = nationen.get(name);
        return nation.verändereDetails(tore, punkte);
    }
}