
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 */
/**nous donne une coupe entre deux indices. Le tableau utilisé dans ce cas va inclure les
*éléments du premier indice inclus jusqu’au deuxième. L’élément du deuxième indice est exclu du nouveau
*tableau.
*/
public class CoupeDeA extends Coupe {

    private int _debut;
    private int _fin;

    public CoupeDeA(int a_debut, int a_fin) throws IndexHorsPorte {
        if (a_debut < 0 || a_debut > a_fin) {
            throw new IndexHorsPorte();
        }
        assert 0 <= a_debut;
        assert a_debut <= a_fin;
        _debut = a_debut;
        _fin = a_fin;
    }

    public int debut() {
        return _debut;
    }

    public int fin() {
        return _fin;
    }

    public int getDebut() {
        return _debut;
    }

    public int getFin(TableauPartiel Tableau) {
        return Tableau.taille() - 1;
    }
}
