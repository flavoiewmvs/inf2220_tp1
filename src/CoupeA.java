
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 */
/**
 * nous donne un tableau à partir du premier élément jusqu’à l’élément indiqué, qui
 * sera exclu
 *
 */
public class CoupeA extends Coupe {

    private int _fin;
    private int _debut = 0;

    public CoupeA(int a_fin) throws IndexHorsPorte {
        if (a_fin < 0) {
            throw new IndexHorsPorte();
        }

        assert 0 <= a_fin;
        _fin = a_fin;
    }

    public int fin() {
        return _fin;
    }

    public int getDebut() {
        return _debut;
    }

    public int getFin(TableauPartiel Tableau) {
        return _fin;
    }
}
