
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 */
public class CoupeA extends Coupe {

    private int _fin;
    private int _debut = 0;

    public CoupeA(int a_fin) {
        assert 0 <= a_fin;
        _fin = a_fin;
    }

    public int fin() {
        return _fin;
    }

    public int getDebut() {
        return _debut;
    }

    public int getFin() {
        return _fin;
    }
}
