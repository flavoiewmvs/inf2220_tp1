
import sun.font.EAttribute;

/**
 *
 * @author flavo Fabien Lavoie Lavf27046702
 * @param <E>
 */
public class TableauPartiel<E> {

//    private E[] _tableau;
    private E[] _tableau;

    private class Item<E> {

        @Override
        public String toString() {
            return "Item{" + "element=" + valeur + '}';
        }

        private E valeur;

        public Item(E a_valeur) {
            valeur = a_valeur;
        }
    }

    public TableauPartiel(E[] a_tableau) {
        _tableau = (E[]) new Object[(a_tableau.length)];

        for (int indice = 0; indice <= a_tableau.length - 1; ++indice) {
            _tableau[indice] = a_tableau[indice];
        }
    }

    public TableauPartiel(TableauPartiel<E> a_tableauPartiel) {
        _tableau = (E[]) new Object[a_tableauPartiel.taille()];
        for (int indice = 0; indice <= a_tableauPartiel.taille() - 1; ++indice) {
            _tableau[indice] = a_tableauPartiel._tableau[indice];
        }
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
            E item = _tableau[pos];
            if (item.equals(a_element)) {
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
            E item = _tableau[pos];
            if (item.equals(a_element)) {
                trouvé = true;
            }
        }
        return trouvé;
    }

    public void coupe(Coupe a_coupe) throws IndexHorsPorte {
        //TableauPartiel<E> type de retour
//Finalement, la méthode coupe donne un nouveau TableauPartiel à partir de la coupe donnée.
//Ce nouveau tableau contient une référence sur le tableau d’origine. Donc, les cases modifiées dans ce
//nouveau tableau seront aussi modifiées dans l’ancien tableau. Le premier élément d’un
//TableauPartiel est adressé par l’indice zéro, même si son indice diffère dans le tableau d’origine.
//Si la Coupe contient un ou des indices non valides, l’exception IndexHorsPorte est lancée.
     }

    public E[] elements() {
//    Cette méthode retourne un nouveau tableau Java contenant les éléments du TableauPartiel .
//C’est une copie du tableau qui doit être retournée

         E[] tableaujava;
        tableaujava = (E[]) new Object[(taille())];
        for (int indice = 0; indice <= taille() - 1; ++indice) {
            tableaujava[indice] = _tableau[indice];
        }       
        return tableaujava;
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
        return _tableau[a_position];
    }

    public void remplacer(E a_ancien, E a_nouveau) throws ElementNonPresent {
//        public void remplacer( E a_ancien , E a_nouveau ) .
//Cette méthode trouve les occurrences d’un élément et les remplaces par le nouvel élément.
//La méthode equals de la classe Object est utilisée pour les comparaisons dans les méthodes contient ,
//position et remplacer .
        boolean trouvé = false;
        for (int pos = 0; pos < _tableau.length; pos++) {
            E item = _tableau[pos];
            if (item.equals(a_ancien)) {
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
//       public void set( int a_position , E a_element ) throws IndexHorsPorte.
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
}
