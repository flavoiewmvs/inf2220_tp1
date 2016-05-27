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

    public static void main(String[] args) {
        System.out.println("Tp1.Principale.main()");
        Integer [] monTab = {0,1,2,3,4,5,6,7,8,9};
//       Legume monLegume = new Legume(10);
        TableauPartiel tp = new TableauPartiel(monTab);
        TableauPartiel tp99 = tp;
        System.out.println("Tableau tp "+tp.taille());
        monTab[1] = 999;
    }
    public static int faireTotal (Integer [] Tab_par) {
        int tot = 0;
        for (int item : Tab_par) {
            tot+=item;
        }
        return tot;
    }
}
