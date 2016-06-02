
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 */
/**
 * Une coupe est un descripteur. Elle décrit le sous-tableau que nous voulons extraire du tableau de base. Il y a
 * trois descripteurs qui hérite de la classe de base Coupe . CoupeA, CoupeDeA, CoupeDe
 */
public abstract class Coupe {

    private int _debut = 0;
    private int _fin = 0;

    public int getDebut() {
        return _debut;
    }

    public abstract int getFin(TableauPartiel Tableau);
}
