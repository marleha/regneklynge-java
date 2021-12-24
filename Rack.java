import java.util.ArrayList; 


public class Rack {

    // Jeg representerer modellen av klassen Rack. Variablene blir deklarert.
    private int noderPerRack;
    private ArrayList<Node> noder; 

    // Her definerer jeg konstruktoren og initsialiserer instantvariablene.
    public Rack(int noderPerRack) {
        this.noderPerRack = noderPerRack;
        this.noder = new ArrayList<Node>();
    }

    // Hvis antall noder i racket er mindre enn onsket noder per rack, blir 
    // noden satt inn i racket eller noder-listen og true returneres. Hvis antall 
    // noder i racket er over onsket noder per rack blir false returnert.
    public boolean settInn(Node nyNode) {
        if (noder.size() < noderPerRack) {
            // Hvis vi kommer hit, vet vi at vi har
            // ledig plass. Da returnerer vi bare,
            noder.add(nyNode);
            return true;
        } else {
            return false;
        }
    }

    // Antall noder i noder-listen eller i racket blir returnert.
    public int getAntNoder() {
        return noder.size();
    }

    // Her faar man tak i prosessoren eller prosessorene til hver node i 
    // noder-listen ved hjelp av en lokke. Til slutt returneres antall 
    // prosessorer til alle nodene i racket. 
    public int antProsessorer() {
        int prosessorerTilsammen = 0;
        Node node;
        for (int i = 0; i < noder.size(); i ++) {
            node = noder.get(i);
            prosessorerTilsammen += node.antPros();
        }
        return prosessorerTilsammen;    
    }

    // Her faar man tak i noder i noder-listen eller racket som har paakrevd 
    // minne. For hver node med nok minne adderes det med 1 og antall noder 
    // med nok minne i racket blir til slutt returnert. 
    public int noderMedNokMinne(int paakrevdMinne){
        int antallNoder = 0;
        Node node;
        for (int i = 0; i < noder.size(); i++){
            node = noder.get(i);
            if (node.nokMinne(paakrevdMinne)) {
                antallNoder += 1;
            }
        }
        return antallNoder;
    } 
}