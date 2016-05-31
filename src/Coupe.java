
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 */
public abstract class Coupe {

    private int _debut = 0;
    private int _fin = 0;

    public int getDebut() {
        return _debut;
    }
    public abstract int getFin(TableauPartiel Tableau);
}
