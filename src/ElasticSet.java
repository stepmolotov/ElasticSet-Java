/*
 * author: Stefan Daniel Motoc
 * November 2015
*/

import java.util.List;

public interface ElasticSet<E extends Comparable<E>>{
	/*	OVERVIEW:			ElasticSet e' una collezione di oggetti omogenei generici, confrontabili,
	 * 						in cui non sono presenti elementi duplicati.
	 *
	 *	Typical Element:	{el0, el1, ..... , elk}
	 * 	
	 */	
	
	
	public boolean add(E e);
	/*	REQUIRES:	-
	 *	MODIFY:		this 
	 *	EFFECTS:	Aggiunge alla collezione l'elemento e, restituendo true
					in caso di successo, false altrimenti.
					Se e==null, lancia un'eccezione unchecked, NullPointerException.
	 */	

	
	public boolean remove(E e) throws EmptyCollectionException;
	/*	REQUIRES:	-
	 *	MODIFY:		this 
	 *	EFFECTS:	Rimuove dalla collezione, se presente, l'elemento e, restituendo true
					in caso di successo, false se l'elemento e non fa parte della collezione.
					Se e==null, lancia un'eccezione unchecked, NullPointerException.
					Se la collezione e' vuota, lancia un'eccezione checked, EmptyCollectionException. 
	 */
	
	
	public boolean contains(E e);
	/*	REQUIRES:	-
	 *	MODIFY:		- 
	 *	EFFECTS:	Restituisce true se l'elemento e e' presente all'interno della collezione,
					false se l'elemento e non fa parte della collezione.
					Se e==null, lancia un'eccezione unchecked, NullPointerException.
	 */
	
	
	public boolean isEmpty();
	/*	REQUIRES:	-
	 * 	MODIFY:		-
	 *	EFFECTS:	Restituisce true se la collezione e' vuota, false altrimenti. 
	 */
	
	
	//greatest lower bound
	public E glb(E e);
	/*	REQUIRES:	-
	 *	MODIFY: 	- 
	 *	EFFECTS:	Restituisce l'elemento piu' grande della collezione
					che e' minore o uguale all'elemento e. Se tale elemento non esiste,
					restituisce null.
					Se e==null, lancia un'eccezione unchecked, NullPointerException.
	 */
	
	
	//least upper bound
	public E lub(E e);
	/*	REQUIRES:	-
	 *	MODIFY:		- 
	 *	EFFECTS:	Restituisce l'elemento piu' piccolo della collezione
					che e' maggiore o uguale all'elemento e. Se tale elemento non esiste, 
					restituisce null.
					Se e==null, lancia un'eccezione unchecked, NullPointerException. 
	 */
	
	
	public List<E> view(E f, E t) throws EmptyCollectionException;
	/*	REQUIRES:	-
	 *	MODIFY:		- 
	 *	EFFECTS:	Restituisce un insieme di elementi che sono maggiori o uguali a f
					e minori o uguali a t.
					Se f==null oppure t==null, lancia un'eccezione unchecked NullPointerException.
					Se la collezione e' vuota, lancia un'eccezione checked, EmptyCollectionException. 
	 */
	
	
	public E max();
	/*	REQUIRES:	-
	 *	MODIFY:		- 
	 *	EFFECTS:	Restituisce l'elemento piu' grande della collezione.
					Se la collezione e' vuota, restituisce null. 
	 */
	
	
	public E min();
	/*	REQUIRES:	-
	 *	MODIFY:		- 
	 *	EFFECTS:	Restituisce l'elemento piu' piccolo della collezione.
					Se la collezione e' vuota, restituisce null.
	 */
	
	
	public boolean rmFirst() throws EmptyCollectionException;
	/*	REQUIRES:	-
	 *	MODIFY:		this 
	 *	EFFECTS:	Rimuove il piu' piccolo elemento della collezione,
					restituendo true in caso di successo, false altrimenti.
					Se la collezione e' vuota, lancia un'eccezione checked, EmptyCollectionException.	 
	 */
	
	
	public boolean rmLast() throws EmptyCollectionException;
	/*	REQUIRES: 	-
	 *	MODIFY:		this 
	 *	EFFECTS:	Rimuove il piu' grande elemento della collezione,
					restituend true in caso di successo, false altrimenti.
					Se la collezione e' vuota, lancia un'eccezione checked, EmptyCollectionException.
	 */
	
	
	public E exist(E f, E t) throws EmptyCollectionException;
	/*	REQUIRES:	-
	 *	MODIFY:		- 
	 *	EFFECTS:	Restituisce uno tra gli elementi il cui valore e' maggiore di f e minore di t,
					elementi della collezione. Restituisce null se tale elemento non esiste.
					Se f==null oppure t==null, lancia un'eccezione unchecked, NullPointerException.
					Se la collezione e' vuota, lancia un'eccezione checked, EmptyCollectionException.
	 */
	
	/*-------------------------AUSILIARI-------------------------*/
	public void print();
	/*	REQUIRES:	-
	 *	MODIFY:		- 
	 *	EFFECTS:	Stampa su schermo la lista degli elementi presenti all'interno della collezione.
	 */
	
	
	public int ricercaBin(E key);
	/*	REQUIRES:	-
	 *	MODIFY:		- 
	 *	EFFECTS:	Restituisce l'indice dell'elemento key all'interno della lista list.
	 				Se l'elemento non e' presente nella lista, restituisce -1-pos, dove pos rappresenta l'indice che l'elemento
	 				key avrebbe se fosse presente all'interno della collezione.
	 				Se list==null oppure key==null, lancia un'eccezione unchecked, NullPointerException.
	 */
	
}
