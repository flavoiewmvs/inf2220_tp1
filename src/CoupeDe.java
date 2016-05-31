
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 */
public class CoupeDe extends Coupe {

    private int _debut;
    private int _fin = 999;

    public CoupeDe(int a_debut) {
        assert 0 <= a_debut;
        _debut = a_debut;
    }

    public int debut() {
        return _debut;
    }

    public int getDebut() {
        return _debut;
    }

    public int getFin(TableauPartiel Tableau) {
        // je retourne la taille du tableau qui correcpond a tous les elements
        return Tableau.taille();
//        return _fin;
    }
}
