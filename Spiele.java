import java.util.HashMap;
/**
 * @author Tobias Haag | HfG | IoT3
 * @version 16.06.2018
 */
public class Spiele
{
    private HashMap<String, Nation> spielPartien;
    private RW rw;
    /**
     * Konstruktor für Objekte der Klasse Spiele
     */
    public Spiele()
    {
        spielPartien = new HashMap<>();
        ladeSpiele();
        rw = new RW();
    }

    /**
     *
     */
    public void ladeSpiele()
    {
        spielPartien.put("A", new Gruppe("A"));
        spielPartien.put("B", new Gruppe("B"));
        spielPartien.put("C", new Gruppe("C"));
        spielPartien.put("D", new Gruppe("D"));
        spielPartien.put("E", new Gruppe("E"));
        spielPartien.put("F", new Gruppe("F"));
        spielPartien.put("G", new Gruppe("G"));
        spielPartien.put("H", new Gruppe("H"));
    }
    
    /**
     *
     */
    public String[] gibDatenElemente(String ordner, String datei)
    {
        String daten = "";
        try{
            daten = rw.ladeDatei(ordner, datei);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String[] element = daten.split("/");
        return element;
    }
    
    
    
    /**
     *
     */
    public void ladeGruppeninfo(String name)
    {
        String[] element = gruppe.gibDatenElemente("Gruppen", name);

        anzahlGruppen = Integer.valueOf(element[0]);
        for (int i = 1; i <= anzahlGruppen; i++) {
            ladeNation(element[i]);
        }

        if(element.length >= anzahlGruppen+2){
            for (int i = anzahlGruppen+1; i < element.length; i++) {
                String[] daten = element[i].split("-");
                spielpartien.put(daten[0], daten[1]);
            }
        }
    }
    
    public void updateSpielergebnis(String nation1, int tore1, String nation2, int tore2)
    {
        int punkte1 = 0;
        int punkte2 = 0;

        if(tore1 > tore2){
            punkte1 = 3;
        }
        if(tore1 < tore2){
            punkte2 = 3;
        }
        if(tore1 == tore2){
            punkte1 = 1; punkte2 = 1;
        }

        String daten = nation1 + ":" + nation2 + "-" + tore1 + ":" + tore2;
        String datenSpieler = nation1 + ":" + nation2;
        String datenSpielerRück = nation2 + ":" + nation1;
        String gruppe = prüfeNationenInGruppe(nation1, nation2);

        if(prüfeNationenInGruppe(nation1, nation2) != null){
            Gruppe gruppeEins = turnierGruppen.get(gruppe);
            if(gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpieler) == false
                && gruppeEins.gibDaten("Gruppen", gruppe).contains(datenSpielerRück) == false){

                if(speichereNation(nation1, tore1, punkte1) && speichereNation(nation2, tore2, punkte2)== true){
                    try{
                        rw.hinzufügenGruppe(gruppe, daten);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    gruppeEins.ladeGruppeninfo(gruppe);
                }
            }
            else{System.out.println("Das Ergebnis wurde bereits eingegeben!");}
        }
        else{System.out.println("Die Nationen sind nicht in einer Gruppe!");}
    }
}
