/*
 * author: Stefan Daniel Motoc
 * November 2015
*/

import java.util.List;
import java.util.Random;

public class TestSet2 {
	//definisco i colori utilizzati
	private static final String RESET 	= "\u001B[0m";
	private static final String RED 	= "\u001B[31m";
	private static final String GREEN 	= "\u001B[32m";
	private static final String YELLOW 	= "\u001B[33m";

	public static void main(String[] args) throws EmptyCollectionException {
		// creo una nuova collezione
		MyElasticSet<Integer> collez = new MyElasticSet<Integer>();

		//inizio test
		System.out.println();
		System.out.println();
		System.out.println(YELLOW + "--------------------> INIZIO TEST 2 <--------------------" + RESET);
		System.out.println(YELLOW + "La seconda batteria di test riguarda un insieme di Interi." + RESET);
		System.out.println();

		/*-------------------------IS_EMPTY-------------------------*/
		//controllo che la collezione sia vuota
		System.out.println("Elementi inseriti: " + collez.size);
		if(collez.isEmpty()) System.out.println("isEmpty = True");
		else System.out.println("isEmpty = False");
			
		/*-------------------------REMOVE--------------------------*/
		//provo a rimuovere un elemento dalla collezione vuota
		Integer i;
		try{
			collez.remove(i = new Integer(23));
		}catch(EmptyCollectionException e){
			System.out.println(RED + "Exception Caught: EmptyCollectionException");
			System.out.println("\tcaused by remove(23)" + RESET);			
		}
		String str;
		/*-------------------------ADD(int)-------------------------*/
		System.out.println("Inserisco interi nella collezione...");
		if(collez.add(i = new Integer(52))) System.out.println("add(52) = True");
		else System.out.println("add(52) = False");
		if(collez.add(i = new Integer(3))) 	System.out.println("add(3)  = True");
		else System.out.println("add(3)  = False");
		if(collez.add(i = new Integer(24))) System.out.println("add(24) = True");
		else System.out.println("add(24) = False");
		if(collez.add(i = new Integer(19))) System.out.println("add(19) = True");
		else System.out.println("add(19) = False");
		if(collez.add(i = new Integer(6))) 	System.out.println("add(6)  = True");
		else System.out.println("add(6)  = False");
		if(collez.add(i = new Integer(42))) System.out.println("add(42) = True");
		else System.out.println("add(42) = False");
		if(collez.add(i = new Integer(24))) System.out.println("add(24) = True");
		else System.out.println("add(24) = False");
		try{
			collez.add(null);
		}catch(NullPointerException e){
			System.out.println(RED + "Exception Caught: EmptyCollectionException");
			System.out.println("\tcaused by add(null)" + RESET);
		}
		
		
		/*-------------------------PRINT-------------------------*/
		System.out.println();
		System.out.println("Collezione formata da: ");
		collez.print();
		
		
		/*-------------------------SIZE-------------------------*/
		System.out.println("Elementi inseriti: " + collez.size);
		System.out.println();
		
		/*-------------------------GREATEST_LOWER_BOUND/LEAST_UPPER_BOUND-------------------------*/
		System.out.println("glb(2)	= " + collez.glb(i = new Integer(2)));
		System.out.println("lub(2)	= " + collez.lub(i = new Integer(2)));
		System.out.println("glb(3)	= " + collez.glb(i = new Integer(3)));
		System.out.println("lub(3)	= " + collez.lub(i = new Integer(3)));
		System.out.println("glb(29)	= " + collez.glb(i = new Integer(29)));
		System.out.println("lub(29)	= " + collez.lub(i = new Integer(29)));
		System.out.println("glb(52)	= " + collez.glb(i = new Integer(52)));
		System.out.println("lub(52)	= " + collez.lub(i = new Integer(52)));
		System.out.println("glb(69)	= " + collez.glb(i = new Integer(69)));
		System.out.println("lub(69)	= " + collez.lub(i = new Integer(69)));
		System.out.println();
		
		
		/*-------------------------VIEW-------------------------*/
		Integer start = new Integer(8);
		Integer end = new Integer(39);
		System.out.println("view(8, 39) = " + collez.view(start, end));
		System.out.println();

		/*-------------------------RM_FIRST/RM_LAST-------------------------*/
		System.out.println("Collezione formata da: ");
		collez.print();
		System.out.println("Elementi inseriti: " + collez.size);
		System.out.println("Primo  elemento: " + collez.min());
		System.out.println("Ultimo elemento: " + collez.max());
		collez.rmFirst();
		System.out.println("rmFirst() = True");
		System.out.println();
		
		System.out.println("Collezione formata da: ");
		collez.print();
		System.out.println("Elementi inseriti: " + collez.size);
		System.out.println("Primo  elemento: " + collez.min());
		System.out.println("Ultimo elemento: " + collez.max());
		collez.rmLast();
		System.out.println("rmLast() = True");
		System.out.println();
		
		/*-------------------------EXIST-------------------------*/
		System.out.println("Collezione formata da: ");
		collez.print();
		System.out.println("Elementi inseriti: " + collez.size);
		Integer bot = new Integer(15);
		Integer top = new Integer(78);
		Integer ris = collez.exist(bot, top);
		System.out.println("exist(" + bot + "," + top + "): " + ris);
		
		bot = i = new Integer(-23);
		top = i = new Integer(0);
		ris = collez.exist(bot, top);
		System.out.println("exist(" + bot + "," + top + "): " + ris);

		//stampo la riuscita del test 
		System.out.println();
        System.out.println(GREEN + "--------------------> TEST INTERI: OK <--------------------" + RESET);
		System.out.println();
		System.out.println();
	}

}
