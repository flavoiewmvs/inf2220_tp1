//package Tp1;

public class Principal_new {
	public static void main(String[] args) {
		double points = Principal_new.testerTableauPartiel();
		
		System.out.println( points + " / 4.5"  );
	}

	public static < T > double tester( T a_resultat, T a_attendu, double a_points, String a_message ){
		double gain = 0.0;
		
		if( a_resultat.equals( a_attendu ) ) {
			gain = a_points;
		} else {
			System.out.println( a_message );
		}
		
		return gain;
	}
	
	public static double testerTableauPartiel(){
		double points = 0.0;
		
		// *******************************************************
		// section 1

		Integer tab[] = { new Integer( 8 ), new Integer( 7 ), new Integer( 6 ), new Integer( 5 ) };
		TableauPartiel< Integer > tp = new TableauPartiel<>( tab );
		
		// construction simple d'un tableau.
		points += Principal_new.< Boolean >tester( tp.estVide(), false, 0.1, "1 estVide 1 : le tableau ne devrait pas etre vide." );
		try {
			points += Principal_new.< Integer >tester( tp.get( 1 ), 7, 0.1, "2 get 1 : devrait contenir l'element 1." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "3 get 1 : ne devrait pas lever d'exeption." );
		}
		points += Principal_new.< Integer >tester( tp.taille(), 4, 0.1, "4 taille 1 : devrait retourner une taille de 4." );
		
		try {
			tp.set( 1, new Integer( -1 ) );
		} catch( IndexHorsPorte e ) {
			System.out.println( "5 set 1 : ne devrait pas lever d'exeption." );
		}
		try {
			points += Principal_new.< Integer >tester( tp.get( 1 ), -1, 0.2, "6 set 1 : devrait contenir l'element -1." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "7 set 1 : ne devrait pas lever d'exeption." );
		}
		points += Principal_new.< Integer >tester( tab[1], 7, 0.2, "8 set 1 : ne devrait pas etre modifie par le set sur tp." );
		
		// coupeDeA( 1, 3 );
		TableauPartiel< Integer > tp_c1 = null;
		try {
			tp_c1 = tp.coupe( new CoupeDeA( 1, 3 ) );
		} catch( IndexHorsPorte e ) {
			System.out.println( "9 coupe1 : ne devrait pas lever d'exeption." );
		}
		points += Principal_new.< Integer >tester( tp_c1.taille(), 2, 0.2, "10 taille 2 : devrait retourner une taille de 2." );
		try {
			points += Principal_new.< Integer >tester( tp_c1.get( 1 ), 6, 0.2, "11 get 2 : devrait contenir l'element 6." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "12 get 2 : ne devrait pas lever d'exeption." );
		}

		try {
			tp_c1.set( 1, new Integer( -2 ) );
		} catch( IndexHorsPorte e ) {
			System.out.println( "13 set 2 : ne devrait pas lever d'exeption." );
		}

		try {
			points += Principal_new.< Integer >tester( tp_c1.get( 1 ), -2, 0.2, "14 set 2 : devrait contenir l'element -2." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "15 set 2 : ne devrait pas lever d'exeption." );
		}

		try {
			points += Principal_new.< Integer >tester( tp.get( 2 ), -2, 0.2, "16 set 2 : devrait contenir l'element -2, car modifier dans tp_c1." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "17 set 2 : ne devrait pas lever d'exeption." );
		}

		points += Principal_new.< Integer >tester( tab[2], 6, 0.2, "18 set 2 : ne devrait pas etre modifie par le set sur tp_c1." );
		
		// coupe( coupeDe );
		TableauPartiel< Integer > tp_c2 = null;
		try {
			tp_c2 = tp.coupe( new CoupeDe( 1 ) );
		} catch( IndexHorsPorte e ) {
			System.out.println( "19 p_c2 : ne devrait pas lever d'exeption." );
		}
		points += Principal_new.< Integer >tester( tp_c2.taille(), 3, 0.2, "20 taille 3 : devrait retourner une taille de 3." );
		try {
			points += Principal_new.< Integer >tester( tp_c2.get( 2 ), 5, 0.2, "21 get 3 : devrait contenir l'element 5." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "22 get 3 : ne devrait pas lever d'exeption." );
		}

		try {
			tp_c2.set( 2, new Integer( -3 ) );
		} catch( IndexHorsPorte e ) {
			System.out.println( "23 get 3 : ne devrait pas lever d'exeption." );
		}

		try {
			points += Principal_new.< Integer >tester( tp_c2.get( 2 ), -3, 0.2, "24 set 3 : devrait contenir l'element -3." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "25 set 3 : ne devrait pas lever d'exeption." );
		}

		try {
			points += Principal_new.< Integer >tester( tp.get( 3 ), -3, 0.2, "26 set 3 : devrait contenir l'element -3, car modifier dans tp_c2." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "27 set 3 : ne devrait pas lever d'exeption." );
		}

		points += Principal_new.< Integer >tester( tab[3], 5, 0.2, "28 set 3 : ne devrait pas etre modifie par le set sur tp_c2." );
		
		// 2iem constructeur.
		TableauPartiel< Integer > tp2 = new TableauPartiel<>( tp_c2 );
		points += Principal_new.< Integer >tester( tp2.taille(), 3, 0.1, "29 taille 4 : devrait retourner une taille de 3." );
		try {
			points += Principal_new.< Integer >tester( tp2.get( 2 ), -3, 0.2, "30 get 4 : devrait contenir l'element -3." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "31 get 4 : ne devrait pas lever d'exeption." );
		}

		try {
			tp2.set( 0, new Integer( -4 ) );
		} catch( IndexHorsPorte e ) {
			System.out.println( "32 set 4 : ne devrait pas lever d'exeption." );
		}

		try {
			points += Principal_new.< Integer >tester( tp2.get( 0 ), -4, 0.1, "33 set 4 : devrait contenir l'element -4." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "34 set 4 : ne devrait pas lever d'exeption." );
		}

		try {
			points += Principal_new.< Integer >tester( tp_c2.get( 0 ), -1, 0.1, "35 set 4 : ne devrait pas etre modifier par le set." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "36 set 4 : ne devrait pas lever d'exeption." );
		}

		// *******************************************************
		// section 2

		Integer tab2[] = { new Integer( 8 ), new Integer( 7 ), new Integer( 6 ), new Integer( 7 ) };
		TableauPartiel< Integer > tp3 = new TableauPartiel<>( tab2 );
		
		points += Principal_new.< Boolean >tester( tp3.contient( new Integer( 6 ) ), true, 0.1, "37 contient 1 : l'element devrait etre present." );
		points += Principal_new.< Boolean >tester( tp3.contient( new Integer( 4 ) ), false, 0.1, "38 contient 2 : l'element ne devrait pas etre present." );
		try {
			points += Principal_new.< Integer >tester( tp3.position( new Integer( 6 ) ), 2, 0.1, "39 position 1 : l'element devrait etre a la position 2." );
		} catch( ElementNonPresent e ) {
			System.out.println( "40 position 1 : ne devrait pas lever d'exeption." );
		}

		try {
			tp3.remplacer( new Integer( 7 ), new Integer( -5 ) );
		} catch( ElementNonPresent e ) {
			System.out.println( "41 remplacer 1 : ne devrait pas lever d'exeption." );
		}
		try {
			points += Principal_new.< Integer >tester( tp3.get( 0 ), 8, 0.1, "42 remplacer 1 : devrait contenir l'element 8." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "43 remplacer 1 : ne devrait pas lever d'exeption." );
		}
		try {
			points += Principal_new.< Integer >tester( tp3.get( 1 ), -5, 0.1, "44 remplacer 1 : devrait contenir l'element -5." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "45 remplacer 1 : ne devrait pas lever d'exeption." );
		}
		try {
			points += Principal_new.< Integer >tester( tp3.get( 2 ), 6, 0.1, "46 remplacer 1 : devrait contenir l'element 6." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "47 remplacer 1 : ne devrait pas lever d'exeption." );
		}
		try {
			points += Principal_new.< Integer >tester( tp3.get( 3 ), -5, 0.1, "48 remplacer 1 : devrait contenir l'element -5." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "49 remplacer 1 : ne devrait pas lever d'exeption." );
		}

		// coupe( coupeA );
		TableauPartiel< Integer > tp_c3 = null;
		try {
			tp_c3 = tp3.coupe( new CoupeA( 0 ) );
		} catch( IndexHorsPorte e ) {
			System.out.println( "50 tp_c3 : ne devrait pas lever d'exeption." );
		}
		points += Principal_new.< Integer >tester( tp_c3.taille(), 0, 0.1, "51 taille 4 : devrait retourner une taille de 0." );
		points += Principal_new.< Boolean >tester( tp_c3.estVide(), true, 0.1, "52 estVide 2 : le tableau devrait etre vide." );
		

		// *******************************************************
		// section 3

		Integer tab3[] = { new Integer( 1 ), new Integer( 2 ), new Integer( 3 ), new Integer( 4 ) };
		TableauPartiel< Integer > tp4 = new TableauPartiel<>( tab3 );
		

		Integer tab4[] = tp4.elements();

		points += Principal_new.< Integer >tester( tab4.length, 4, 0.1, "53 elements 1 : devrait avoir une taille de 4." );

		try {
			tp4.set( 1, new Integer( -6 ) );
		} catch( IndexHorsPorte e ) {
			System.out.println( "54 set 5 : ne devrait pas lever d'exeption." );
		}
		
		try {
			points += Principal_new.< Integer >tester( tp4.get( 1 ), -6, 0.1, "55 set 5 : devrait contenir l'element -6." );
		} catch( IndexHorsPorte e ) {
			System.out.println( "56 set 5 : ne devrait pas lever d'exeption." );
		}
		
		points += Principal_new.< Integer >tester( tab3[1], 2, 0.1, "57 set 5 : l'element ne devrait pas etre modifie." );
		points += Principal_new.< Integer >tester( tab4[1], 2, 0.1, "58 set 5 : l'element ne devrait pas etre modifie." );
		

		return points;
	}
}
