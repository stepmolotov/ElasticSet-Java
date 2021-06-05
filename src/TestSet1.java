/*
 * author: Stefan Daniel Motoc
 * November 2015
*/

import java.util.List;
import java.util.Random;

public class TestSet1 {
	//definisco i colori utilizzati
	private static final String RESET 	= "\u001B[0m";
	private static final String RED 	= "\u001B[31m";
	private static final String GREEN 	= "\u001B[32m";
	private static final String YELLOW 	= "\u001B[33m";

	public static void main(String[] args) throws EmptyCollectionException {		
		// creo una nuova collezione
		MyElasticSet<String> collez = new MyElasticSet<String>();

		//inizio test
		System.out.println();
		System.out.println();
		System.out.println(YELLOW + "--------------------> INIZIO TEST 1 <--------------------" + RESET);
		System.out.println(YELLOW + "La prima batteria di test riguarda un insieme di Stringhe." + RESET);
		System.out.println();

		/*-------------------------IS_EMPTY-------------------------*/
		//controllo che la collezione sia vuota
		System.out.println("Elementi inseriti: " + collez.size);
		if(collez.isEmpty()) System.out.println("isEmpty = True");
		else System.out.println("isEmpty = False");
		System.out.println();

		
		/*-------------------------REMOVE--------------------------*/
		//provo a rimuovere un elemento dalla collezione vuota
		String s;
		try{
			s = new String("Padova");
			collez.remove(s);
		}catch(EmptyCollectionException e){
			System.out.println(RED + "Exception Caught: EmptyCollectionException");
			System.out.println("\tcaused by remove(Padova)" + RESET);
			
		}
		
		
		/*-------------------------ADD(String)-------------------------*/
		System.out.println("Inserisco stringhe nella collezione...");
		if(collez.add(s = new String("Pisa"))) 		System.out.println("add(Pisa)    = True");
		else System.out.println("add(Pisa) 	  = False");
		if(collez.add(s = new String("Firenze"))) 	System.out.println("add(Firenze) = True");
		else System.out.println("add(Firenze) = False");
		if(collez.add(s = new String("Roma"))) 		System.out.println("add(Roma)    = True");
		else System.out.println("add(Roma)    = False");
		if(collez.add(s = new String("Torino"))) 	System.out.println("add(Torino)  = True");
		else System.out.println("add(Torino)  = False");
		if(collez.add(s = new String("Milano"))) 	System.out.println("add(Milano)  = True");
		else System.out.println("add(Milano)  = False");
		if(collez.add(s = new String("Pisa"))) 		System.out.println("add(Pisa)    = True");
		else System.out.println("add(Pisa)    = False");
		try{
			collez.add(null);
		}catch(NullPointerException e){
			System.out.println(RED + "Exception Caught: NullPointerException");
			System.out.println("\tcaused by add(null)" + RESET);
		}
	
		
		/*-------------------------PRINT-------------------------*/
		System.out.println("Collezione formata da: ");
		collez.print();
		
		
		/*-------------------------SIZE-------------------------*/
		System.out.println("Elementi inseriti: " + collez.size);
		
		
		/*-------------------------IS_EMPTY-------------------------*/
		//controllo se la collezione e' vuota
		if(collez.isEmpty()) System.out.println("isEmpty = True");
		else System.out.println("isEmpty = False");
		
				
		/*-------------------------CONTAINS-------------------------*/
		//controllo se la collezione contiene alcuni elementi
		System.out.println();
		if(collez.contains(s = new String("Pisa"))) 	System.out.println("contains(Pisa)    = True");
		else System.out.println("contains(Pisa)    = False");
		if(collez.contains(s = new String("Pistoia"))) 	System.out.println("contains(Pistoia) = True");
		else System.out.println("contains(Pistoia) = False");
		try{
			collez.contains(null);
		}catch(NullPointerException e){
			System.out.println(RED + "Exception Caught: NullPointerException");
			System.out.println("\tcaused by contains(null)" + RESET);
		}


		/*-------------------------GREATEST_LOWER_BOUND/LEAST_UPPER_BOUND-------------------------*/
		System.out.println();
		System.out.println("glb(Catania)	= " + collez.glb(s = new String("Catania")));
		System.out.println("lub(Catania)	= " + collez.lub(s = new String("Catania")));
		System.out.println("glb(Roma)	= " + collez.glb(s = new String("Roma")));
		System.out.println("lub(Roma)	= " + collez.lub(s = new String("Roma")));
		System.out.println("glb(Zanarkand)	= " + collez.glb(s = new String("Zanarkand")));
		System.out.println("lub(Zanarkand)	= " + collez.lub(s = new String("Zanarkand")));
		System.out.println();

		
		/*-------------------------EXIST-------------------------*/
		String s1;
		String s2;
		System.out.println("exist(Firenze, Pisa) = " + collez.exist(s1 = new String("Firenze"), s2 = new String("Pisa")));
		System.out.println("exist(Bologna, Padova) = " + collez.exist(s1 = new String("Bologna"), s2 = new String("Padova")));
		System.out.println();


		/*-------------------------VIEW-------------------------*/
		System.out.println("view(Bologna, Padova) = " + collez.view(s1 = new String("Bologna"), s2 = new String("Padova")));
		System.out.println();


		/*-------------------------REMOVE-------------------------*/
		//provo a rimuovere alcuni elementi dalla collezione
		if(collez.remove(s = new String("Roma"))) 		System.out.println("remove(Roma)    = True");
		else System.out.println("remove(Roma)    = False");
		if(collez.remove(s = new String("Milano")))		System.out.println("remove(Milano)  = True");
		else System.out.println("remove(Milano)  = False");
		if(collez.remove(s = new String("Bologna")))	System.out.println("remove(Bologna) = True");
		else System.out.println("remove(Bologna) = False");
		System.out.println();
		
		
		/*-------------------------RM_FIRST/RM_LAST-------------------------*/
		//provo a cancellare elementi usando le funzioni rmFirst() e rmLast()
		System.out.println("Elementi rimasti: " + collez.size);
		collez.print();
		System.out.println("Primo  elemento: " + collez.min());
		System.out.println("Ultimo elemento: " + collez.max());
		if(collez.rmFirst()) System.out.println("rmFirst() = True");
		else System.out.println("rmFirst() = False");
		System.out.println();
		
		System.out.println("Elementi rimasti: " + collez.size);
		collez.print();
		System.out.println("Primo  elemento: " + collez.min());
		System.out.println("Ultimo elemento: " + collez.max());
		if(collez.rmLast()) System.out.println("rmLast()  = True");
		else System.out.println("rmLast()  = False");
		System.out.println();
		
		System.out.println("Elementi rimasti: " + collez.size);
		collez.print();
		System.out.println("Primo  elemento: " + collez.min());
		System.out.println("Ultimo elemento: " + collez.max());
		if(collez.rmLast()) System.out.println("rmLast()  = True");
		else System.out.println("rmLast()  = False");
		System.out.println("Elementi rimasti: " + collez.size);
		//provo a rimuovere l'ultimo elemento di una collezione vuota
		try{
			collez.rmLast();
		}catch(EmptyCollectionException e){
			System.out.println(RED + "Exception Caught: EmptyCollectionException");
			System.out.println("\tcaused by rmLast()" + RESET);
		}
		System.out.println("Elementi inseriti: " + collez.size);
		if(collez.isEmpty()) System.out.println("isEmpty = True");
		else System.out.println("isEmpty = False");
       
		//stampo la riuscita del test
		System.out.println();
        System.out.println(GREEN + "--------------------> TEST STRINGHE: OK <--------------------" + RESET);
		System.out.println();
		System.out.println();

		
	}

}
