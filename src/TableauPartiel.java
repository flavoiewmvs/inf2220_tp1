
import java.lang.reflect.Array;

/**
 *
 * @author flavo Fabien Lavoie Lavf27046702
 * @param <E>
 *
 * Le premier constructeur prend un tableau Java et le transforme en
 * TableauPartiel . Cette transformation va demander de construire une copie du
 * tableau reçu en argument, ne prenez pas seulement la référence. Nous ne
 * voulons pas qu’il y ait de lien entre notre tableau et celui qui est utilisé
 * pour le construire. Le deuxième constructeur fait une copie d’un
 * TableauPartiel . Cette copie n’est pas une référence vers le tableau
 * original. C’est une version sans lien. Nous allons maintenant décrire les
 * méthodes que vous devez coder dans cette classe.
 */
public class TableauPartiel<E> {

    private Item[] _tableau;

    public TableauPartiel(E[] a_tableau) {
        _tableau = (Item[]) new Item[(a_tableau.length)];

        for (int indice = 0; indice <= a_tableau.length - 1; ++indice) {
            _tableau[indice] = new Item<E>(a_tableau[indice]);
        }
    }

    public TableauPartiel(TableauPartiel<E> a_tableauPartiel) {
        _tableau = (Item[]) new Item[a_tableauPartiel.taille()];
        for (int indice = 0; indice <= a_tableauPartiel.taille() - 1; ++indice) {
            _tableau[indice] = new Item<E>((E) a_tableauPartiel._tableau[indice].getValeur());
        }
    }

    public TableauPartiel(int nb) {
        //creation d<un tableau vide de la longueur nb
        _tableau = (Item[]) new Item[nb];
    }

    public int position(E a_element) throws ElementNonPresent {
//Cette méthode retourne la position (l’index) d’un élément. Si l’élément est présent plus d’une fois,
//alors l’élément ayant la position la plus petite est retourné. 
//exception est lancée : ElementNonPresent Si l’élément n’est pas dans le tableau
//La méthode equals de la classe Object est utilisée pour les comparaisons dans les méthodes contient ,
//position et remplacer .
        boolean trouvé = false;
        int pos;
        for (pos = 0; pos < _tableau.length && !trouvé; pos++) {
            E test = (E) _tableau[pos].getValeur();
            if (test.equals(a_element)) {
                trouvé = true;
            }
        }
        if (!trouvé) {
            throw new ElementNonPresent();
        }
        return pos - 1;
    }

    public boolean contient(E a_element) {
//Cette méthode cherche un élément dans le tableau et retourne true si l’élément est présent
//La méthode equals de la classe Object est utilisée pour les comparaisons dans les méthodes contient ,
//position et remplacer .
        boolean trouvé = false;
        for (int pos = 0; pos < _tableau.length && !trouvé; pos++) {
            E test = (E) _tableau[pos].getValeur();
            if (test.equals(a_element)) {
                trouvé = true;
            }
        }
        return trouvé;
    }

    public TableauPartiel<E> coupe(Coupe a_coupe) throws IndexHorsPorte {
//Finalement, la méthode coupe donne un nouveau TableauPartiel à partir de la coupe donnée.
//Ce nouveau tableau contient une référence sur le tableau d’origine. Donc, les cases modifiées dans ce
//nouveau tableau seront aussi modifiées dans l’ancien tableau. Le premier élément d’un
//TableauPartiel est adressé par l’indice zéro, même si son indice diffère dans le tableau d’origine.
//Si la Coupe contient un ou des indices non valides, l’exception IndexHorsPorte est lancée.

        int nIndice = 0;
        int debut = a_coupe.getDebut();
        int fin = a_coupe.getFin(this);
        if (fin > taille() || debut < 0 || debut > fin) {
            throw new IndexHorsPorte();
        }
        TableauPartiel<E> ntp = new TableauPartiel<E>(fin - debut);
        for (int indice = debut; indice < fin; ++indice) {
            try {
                ntp.setItem(nIndice, _tableau[indice]);
                ++nIndice;
            } catch (IndexHorsPorte IHP) {
                System.out.println("Element  hors porté");
            }
        }

        return ntp;
    }

    public E[] elements() {
//    Cette méthode retourne un nouveau tableau Java contenant les éléments du TableauPartiel .
        E[] tableau = (E[]) Array.newInstance(_tableau[0].getValeur().getClass(), taille());

        for (int indice = 0; indice <= taille() - 1; ++indice) {
            tableau[indice] = (E) _tableau[indice].getValeur();
        }

        return tableau;
    }

    public boolean estVide() {
        return taille() == 0;
    }

    public E get(int a_position) throws IndexHorsPorte {
//Cette méthode retourne une référence sur l’élément situé à la position donnée. Si la position donnée
//n’est pas valide, vous devez lever une exception IndexHorsPorte . Vous devez aussi construire
//cette exception.
        if (a_position > taille() || a_position < 0) {
            throw new IndexHorsPorte();
        }
        return (E) _tableau[a_position].getValeur();
    }

    public void remplacer(E a_ancien, E a_nouveau) throws ElementNonPresent {
//Cette méthode trouve les occurrences d’un élément et les remplaces par le nouvel élément.
//La méthode equals de la classe Object est utilisée pour les comparaisons dans les méthodes contient ,
//position et remplacer .
        boolean trouvé = false;
        for (int pos = 0; pos < _tableau.length; pos++) {
            if (_tableau[pos].getValeur().equals(a_ancien)) {
                trouvé = true;
                try {
                    set(pos, a_nouveau);
                } catch (IndexHorsPorte IE) {
                    System.out.println("Element non trouve");
                }

            }
        }
        if (!trouvé) {
            throw new ElementNonPresent();
        };
    }

    public void set(int a_position, E a_element) throws IndexHorsPorte {
//Cette méthode assigne une valeur à la position indiquée. Vérifiez la position pour qu’elle soit dans
//l’intervalle permise pour le tableau ( IndexHorsPorte ). 
        if (a_position > taille() || a_position < 0) {
            throw new IndexHorsPorte();
        }
        //        _tableau[a_position] = new Item<E>(a_element);
        _tableau[a_position].setValeur(a_element);
    }

    public void setItem(int a_position, Item a_element) throws IndexHorsPorte {
//Cette méthode assigne une valeur à la position indiquée. Vérifiez la position pour qu’elle soit dans
//l’intervalle permise pour le tableau ( IndexHorsPorte ). 
        if (a_position > taille() || a_position < 0) {
            throw new IndexHorsPorte();
        }
        _tableau[a_position] = a_element;
    }

    public int taille() {
//Cette méthode retourne le nombre de case que contient le tableau.
        return _tableau.length;
    }

    private class Item<I> {
// cette class contient notre reférence a notre objet contenue dans le tableau

        private I valeur;

        public Item(I a_valeur) {
            valeur = a_valeur;
        }

        public void setValeur(I valeur) {
            this.valeur = valeur;
        }

        public I getValeur() {
            return valeur;
        }
    }
}
