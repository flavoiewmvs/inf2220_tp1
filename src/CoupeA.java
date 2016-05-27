
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 */
public class CoupeA extends Coupe {

    private int _fin;

    public CoupeA(int a_fin) {
        assert 0 <= a_fin;
        _fin = a_fin;
    }

    public int fin() {
        return _fin;
    }
}
