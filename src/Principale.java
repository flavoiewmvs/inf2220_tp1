/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author je891149
 */
public class Principale {

    public static void main_fab(String[] args) {
        System.out.println("Tp1.Principale.main()\n\n");
        Integer[] monTab = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        TableauPartiel<Integer> tp = new TableauPartiel<Integer>(monTab);
//        TableauPartiel<Integer> tp2 = new TableauPartiel<Integer>(tp);
//        TableauPartiel tp99 = tp;
        System.out.println(monTab[5]);
        System.out.println("Tableau contient 99 " + tp.contient(99));
        System.out.println("Tableau contient 5 " + tp.contient(5));
        System.out.println("--->>>");

        Integer[] monTabRetour = tp.elements();

        TableauPartiel tpN = null;
        TableauPartiel tpN2 = null;

        try {
//            Coupe test = new CoupeA(5);
//            Coupe test = new CoupeDeA(4,7);
            Coupe testCoupe1 = new CoupeA(2);
            Coupe testCoupe2 = new CoupeDeA(2,3);

            tpN = tp.coupe(testCoupe1);
            tpN2 = tpN.coupe(testCoupe2);
        } catch (IndexHorsPorte H) {
            System.out.println("Hors Porte arret du programme");
            System.exit(0);
        }

        try {
            tp.set(7, 88);
            System.out.println("tp ref Tableau position 4 " + tp.get(4));
            System.out.println("tpN apres coupe  ref Tableau position 4 " + tpN.get(4));
        } catch (IndexHorsPorte E) {
            System.out.println("Element 4 hors porté");
        }

        try {
            System.out.println("Tableau position 5 " + tp.position((Integer) 5));
        } catch (ElementNonPresent E) {
            System.out.println("Element non trouve");
        }

        try {
            System.out.println("ref Tableau position 5 " + tp.get(5));
        } catch (IndexHorsPorte E) {
            System.out.println("Element 5 hors porté");
        }
        try {
            tp.set(7, 999);
            System.out.println("tp ref Tableau position 4 " + tp.get(4));
            System.out.println("tpN apres coupe  ref Tableau position 4 " + tpN.get(4));
        } catch (IndexHorsPorte E) {
            System.out.println("Element 4 hors porté");
        }
    }

}
