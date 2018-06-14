import java.util.HashMap;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 12.06.2018
 */
public class Gruppe
{
    private HashMap<String, Nation> nationen;
    private int gruppenGroesse;
    private RW rw;
    private HashMap<String, String> spiele;
    /**
     * Konstructor
     */
    public Gruppe(String name)
    {
        nationen = new HashMap<>();
        spiele = new HashMap<>();
        rw = new RW();
        ladeGruppeninfo(name);
    }

    /**
     *
     */
    public void erstelleNation(String name)
    {
        Nation nation = new Nation(name, 0, 0);
        nationen.put(name, nation);
        gruppenGroesse += 1;
    }

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

        gruppenGroesse = Integer.valueOf(teile[0]);
        for (int i = 1; i <= gruppenGroesse; i++) {
            ladeNation(teile[i]);
        }

        if(teile.length >= gruppenGroesse+2){
            for (int i = gruppenGroesse+1; i < teile.length; i++) {
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
            daten = rw.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] teile = daten.split("/");
        return teile;
    }

    public String gibDaten(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = rw.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return daten;
    }

    /**
     *
     */
    public boolean prüfeNation(String name)
    {
        if(nationen.containsKey(name)){
            return true;
        }
        else{return false;}
    }

    /**
     *
     */
    public String gibVeränderteDetailsNation(String name, int tore, int punkte)
    {
        Nation nation = nationen.get(name);
        return nation.gibVeränderteDetails(tore, punkte);
    }
}
