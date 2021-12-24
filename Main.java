
// Klasse for hovedprogrammet vaart. 
public class Main {
    public static void main(String[] args) throws Exception {
        String filnavn = "regneklynge.txt";
        Node node;
        Rack rack;
        int minst32;
        int minst64;
        int minst128;
        int antallProsessorer;
        int antallRacks;
        // En ny regneklynge lages. Filen til regneklyngen blir deretter lest. 
        // Datastrukturen blir opprettet iforhold til formatet til input-filen.  
        Regneklynge abel = new Regneklynge(filnavn);
        
        abel.lesFil();

        // Gjor testene fra oppgave D. Vi tester for 32, 64 og 128 GB paakrevd minne.
        // Vi faar tilbake antall noder med henholdsvis 32, 64 og 128 GB. 
        minst32 = abel.noderMedNokMinne(32);
        minst64 = abel.noderMedNokMinne(64);
        minst128 = abel.noderMedNokMinne(128);
        System.out.println("Noder med minst 32 GB: " + minst32);
        System.out.println("Noder med minst 64 GB: " + minst64);
        System.out.println("Noder med minst 128 GB: " + minst128);

        // Regneklyngens antall prosessorer blir funnet.
        antallProsessorer = abel.antProsessorer();
        System.out.println("Antall prosessorer: " + antallProsessorer);

        // Regneklyngens antall rack blir funnet.                   
        antallRacks = abel.antRacks();
        System.out.println("Antall rack: " + antallRacks);

    }
}