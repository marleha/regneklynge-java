import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Regneklynge {

    // Jeg representerer modellen av klassen Regneklynge. Variablene blir deklarert.
    private int noderPerRack;
    private ArrayList<Rack> rackListe;
    private String filnavn;

    // Her definerer jeg konstruktoren og initsialiserer instantvariablene.
    public Regneklynge(int noderPerRack) {
        this.noderPerRack = noderPerRack;
        this.rackListe = new ArrayList<Rack>();
    }

    // Jeg definerer konstruktoren. Her blir filnavn innlest og lagret i en variabel. 
    // En ny rack-liste blir laget.
    public Regneklynge(String filnavn) {
        this.filnavn = filnavn;
        this.rackListe = new ArrayList<Rack>();
    }

    // Metoden gjor forst klar til lesing.
    public void lesFil() throws Exception {
        File filen = new File(filnavn);
        Scanner filScanner = new Scanner(filen);
        
        // Leser inn noder per rack. Gjor om string i filen til tall. "12" -> 12
        String sNoderPerRack = filScanner.nextLine();
        int noderPerRack = Integer.parseInt(sNoderPerRack);
        this.noderPerRack = noderPerRack;

        // Les hver linje og opprett nodene med riktig
        // antall minne og riktig antall prosessorer.
        String linje;
        String[] ordene;
        while(filScanner.hasNextLine()) {
            linje = filScanner.nextLine(); // -> linje = "650 64 1"
            ordene = linje.split(" ");     // -> ordene = ["650", "64", "1"]
                              // Gjør om fra "1" til 1 f.eks.
            int antallNoder = Integer.parseInt(ordene[0]);
            int minnePerNode = Integer.parseInt(ordene[1]);
            int antallProsPerNode = Integer.parseInt(ordene[2]);
            for (int i = 0; i < antallNoder; i++) {
                Node node = new Node(minnePerNode, antallProsPerNode);
                settInnNode(node);
            }
        }
    } 

    // Hvis det er plass til en node i en av rackene
    // blir en ny node satt inn i forste ledige rack og vi returnerer. 
    // Hvis det ikke er plass til noden i noen av rackene blir en ny rack 
    // lagd og noden blir satt inn i racket.
    public void settInnNode(Node nyNode) {
        Rack rack;
        Rack skap;
        // Forsøk å finne ledig plass. 
        for (int i = 0;  i < rackListe.size(); i++) {
            rack = rackListe.get(i);
            if (rack.settInn(nyNode)) {
                // Hvis vi fant ledig plass, kom vi hit. 
                return;
            } else {
                // Det gikk ikke an å sette inn
                // i den racken vi prøvde,
                // nå prøver vi neste rack om 
                // det er flere racks.
            }
        }
        // Hvis ingen av rackene hadde en ledig plass, må vi opprette ny rack, og legge
        // noden inn i dette nye racket. 
        skap = new Rack(noderPerRack);
        rackListe.add(skap);
        skap.settInn(nyNode);
    }

    // For hver rack i rack-listen blir prosessorer plusset sammen og antall prosessorer tilsammen
    // returneres. 
    public int antProsessorer() {
        int prosessorerTilsammen;
        Rack rack;
        prosessorerTilsammen = 0;
        for (int i = 0; i < rackListe.size(); i++) {   
            rack = rackListe.get(i);
            prosessorerTilsammen += rack.antProsessorer();
        }
        return prosessorerTilsammen;     
    }

    // For enhver rack i rack-listen blir noder med nok minne eller paakrevd
    // minne plusset sammen. Antall noder med nok minne returneres. 
    public int noderMedNokMinne(int paakrevdMinne) {
        int antNoderNokMinne = 0;
        Rack rack;
        for (int i = 0; i < rackListe.size(); i++) {
            rack = rackListe.get(i);
            antNoderNokMinne += rack.noderMedNokMinne(paakrevdMinne);
        }
        return antNoderNokMinne;
    }

    // Antall rack i rack-listen returneres.
    public int antRacks() {
        return rackListe.size();
    }
}

