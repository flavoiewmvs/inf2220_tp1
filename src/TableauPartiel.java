
/**
 *
 * @author flavo
 * Fabien Lavoie
 * Lavf27046702
 * @param <E>
 */
public class TableauPartiel<E> {

    public E[] _tableau;

    public TableauPartiel(E[] a_tableau) {
        _tableau = a_tableau.clone();
    }

    public TableauPartiel(TableauPartiel<E> a_tableauPartiel) {
        _tableau = a_tableauPartiel._tableau;
    }

 
    public int position(E a_element) throws ElementNonPresent {
//        Cette méthode retourne la position (l’index) d’un élément. Si l’élément est présent plus d’une fois,
//alors l’élément ayant la position la plus petite est retourné. Si l’élément n’est pas dans le tableau, une
//exception est lancée : ElementNonPresent .
//La méthode equals de la classe Object est utilisée pour les comparaisons dans les méthodes contient ,
//position et remplacer .
        return 1;
    }

    public boolean contient(E a_element) {
//        Cette méthode cherche un élément dans le tableau et retourne true si l’élément est présent, false
//sinon.
//La méthode equals de la classe Object est utilisée pour les comparaisons dans les méthodes contient ,
//position et remplacer .
        return true;
    }

//    public TableauPartiel<E> coupe(Coupe a_coupe)         throws IndexHorsPorte
//Finalement, la méthode coupe donne un nouveau TableauPartiel à partir de la coupe donnée.
//Ce nouveau tableau contient une référence sur le tableau d’origine. Donc, les cases modifiées dans ce
//nouveau tableau seront aussi modifiées dans l’ancien tableau. Le premier élément d’un
//TableauPartiel est adressé par l’indice zéro, même si son indice diffère dans le tableau d’origine.
//Si la Coupe contient un ou des indices non valides, l’exception IndexHorsPorte est lancée.
//    public E[] elements() {
////    Cette méthode retourne un nouveau tableau Java contenant les éléments du TableauPartiel .
////C’est une copie du tableau qui doit être retournée
//
//        return E[] tmp;
//    }

    public boolean estVide() {
        return true;
    }

    public E get(int a_position)             throws IndexHorsPorte {
//        Cette méthode retourne une référence sur l’élément situé à la position donnée. Si la position donnée
//n’est pas valide, vous devez lever une exception IndexHorsPorte . Vous devez aussi construire
//cette exception.
        E TEST=null;
        return TEST;
    }

    public void remplacer(E a_ancien, E a_nouveau) throws ElementNonPresent{
//        public void remplacer( E a_ancien , E a_nouveau ) .
//Cette méthode trouve les occurrences d’un élément et les remplaces par le nouvel élément.
//La méthode equals de la classe Object est utilisée pour les comparaisons dans les méthodes contient ,
//position et remplacer .
    }

    public void set(int a_position, E a_element) throws IndexHorsPorte {
//       public void set( int a_position , E a_element ) throws IndexHorsPorte.
//Cette méthode assigne une valeur à la position indiquée. Vérifiez la position pour qu’elle soit dans
//l’intervalle permise pour le tableau ( IndexHorsPorte ). 
    }

    public int taille() {
 //Cette méthode retourne le nombre de case que contient le tableau.
        return _tableau.length;
    }
}
