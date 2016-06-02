
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 */
/**
 * *nous donne un indice de départ et nous prenons tout jusqu’à la fin du tableau.
 */
public class CoupeDe extends Coupe {

    private int _debut;
    private int _fin = 999;

    public CoupeDe(int a_debut) throws IndexHorsPorte {
        if (a_debut < 0) {
            throw new IndexHorsPorte();
        }
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
        return Tableau.taille();
    }
}
