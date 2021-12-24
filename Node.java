public class Node {

    // Jeg representerer modellen av klassen Node. Variablene blir deklarert.
    private int minne;
    private int antPros;

    // Her definerer jeg konstruktoren og initsialiserer instantvariablene.
    public Node(int minne, int antPros) {
        this.minne = minne;
        this.antPros = antPros;
    }

    // Jeg lager metoden antPros som returnerer antall prosessorer.
    public int antPros() {
        return antPros;
    }

    // Jeg lager metoden som returnerer true hvis minnet er mindre enn paakrevd 
    // minne eller false hvis minne er over paakrevd minne.
    public boolean nokMinne(int paakrevdMinne) {
        if (minne >= paakrevdMinne){
            return true;
        } else {
            return false;
        }
    }
}