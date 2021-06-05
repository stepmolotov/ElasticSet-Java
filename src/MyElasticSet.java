/*
 * author: Stefan Daniel Motoc
 * November 2015
*/

import java.util.ArrayList;
import java.util.List;

public class MyElasticSet<E extends Comparable<E>> implements ElasticSet<E>{
	/*	OVERVIEW:	ElasticSet e' una collezione di oggetti omogenei generici, confrontabili,
	 * 				in cui non sono presenti elementi duplicati.
	 *
	 *	FA:			FA(collection) = {collection.get(0), collection.get(1), .......... , collection.get(size)}
	 * 	
	 * 	IR:			- collection != null
	 * 				- forall i.		0 <= i < collection.size()	=>	collection.get(i) != null
	 * 				- forall i,j.	0 <= i,j < collection.size()  &&	i!=j => collection.get(i)!=collection.get(j); 
	 *				- forall i,j,   0 <= i,j < collection.size() j>i => collection.get(j)>collection.get(i)
	 *				- tutti gli elementi devono essere dello stesso tipo
	 */			
	
	private List<E> collection;
	protected int size;
	
	
	/*-------------------------COSTRUTTORE-------------------------*/
	public MyElasticSet(){
		collection = new ArrayList<E>();
		size = 0;
	}
	
	/*-------------------------ADD-------------------------*/
	public boolean add(E e){
		if(e == null) throw new NullPointerException("add: argomento nullo");
		//trovo l'indice che corrisponderebbe all'elemento e se fosse presente nella collezione
		int pos = ricercaBin(e);
		//se l'elemento e non era gia' presente, lo inserisco nella posizione attesa (-pos-1)
		if(pos < 0){
			collection.add(-pos-1, e);
			//aggiorno size
			size++;
			return true;
		}
		else
			return false;
	}
	
	/*-------------------------REMOVE-------------------------*/
	public boolean remove(E e) throws EmptyCollectionException{
		if(e == null) throw new NullPointerException("remove: argomento nullo");
		if(collection.isEmpty()) throw new EmptyCollectionException("remove: collezione vuota");
		//trovo l'indice dell'elemento e all'intenro della collezione
		int pos = ricercaBin(e);
		if(pos >= 0){
			collection.remove(pos);
			size--;
			return true;
		}
		return false;
	}
	
	/*-------------------------CONTAINS-------------------------*/
	public boolean contains(E e){
		if(e == null) throw new NullPointerException("contains: argomento nullo");
		int pos = ricercaBin(e);
		if(pos < 0)
			return false;
		else
			return true;
	}
	
	/*-------------------------IS_EMPTY-------------------------*/
	public boolean isEmpty(){
		return (size == 0);
	}
	
	/*-------------------------GREATEST_LOWER_BOUND-------------------------*/
	public E glb(E e){
		if(e == null) throw new NullPointerException("glb: argomento nullo");
		if(collection.isEmpty())
			return null;
		//controllo se l'elemento inserito e' minore del minimo della collezione
		if(min().compareTo(e) > 0)
			return null;
		//controllo se l'elemento inserito e' maggiore del massimo della collezione
		else if(max().compareTo(e) < 0)
			return max();
		//se l'elemento e ha un valore incluso tra il minimo e il massimo della collezione,
		//cerco la sua posizione
		int pos = ricercaBin(e);
		if(pos >= 0)
			return collection.get(pos);
		//altrimenti restituisco 
		else
			return collection.get(-pos-2);
	}
	
	/*-------------------------LEAST_UPPER_BOUND-------------------------*/
	public E lub(E e){
		if(e == null) throw new NullPointerException("lub: argomento nullo");
		if(collection.isEmpty())
			return null;
		
		if(min().compareTo(e) > 0)
			return min();
		else if(max().compareTo(e) < 0)
			return null;
		int pos = ricercaBin(e);
		if(pos >= 0)
			return collection.get(pos);
		else
			return collection.get(-pos-1);
	}
	
	/*-------------------------VIEW-------------------------*/
	public List<E> view(E f, E t) throws EmptyCollectionException{
		if(f == null || t == null) throw new NullPointerException("view: argomento nullo");
		try{
			if(collection.isEmpty()) throw new EmptyCollectionException("view: collezione vuota");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<E> part = new ArrayList<E>();
		//implementa con start(lub) e end(glb) 
		for(int i=0; i<size; i++){
			E elem = collection.get(i);
			if(f.compareTo(elem) <= 0 && t.compareTo(elem) >= 0)
				part.add(elem);
		}
		//aliasing?
		return part;			
	}
	
	/*-------------------------MAX-------------------------*/
	public E max(){
		return collection.get(size-1);
	}
	
	/*-------------------------MIN-------------------------*/
	public E min(){
		return collection.get(0);
	}
	
	/*-------------------------RM_FIRST-------------------------*/
	public boolean rmFirst() throws EmptyCollectionException{
		if(collection.isEmpty()) throw new EmptyCollectionException("rmFirst: collezione vuota");
		//rimuovi minimo
		if(collection.remove(min())){
			size--;
			return true;
		}
		return false;
	}
	
	/*-------------------------RM_LAST-------------------------*/
	public boolean rmLast() throws EmptyCollectionException{
		if(collection.isEmpty()) throw new EmptyCollectionException("rmLast: collezione vuota");
		//rimuovi massimo
		if(collection.remove(max())){
			size--;
			return true;
		}
		return false;
	}
	
	/*-------------------------EXIST-------------------------*/
	public E exist(E f, E t) throws EmptyCollectionException{
		if(f == null || t == null) throw new NullPointerException("exist: argomento nullo");
		if(collection.isEmpty()) throw new EmptyCollectionException("exist: collezione vuota");
		for(int i=0; i<size; i++){
			E elem = collection.get(i);
			if(f.compareTo(elem) < 0 && t.compareTo(elem) > 0)
				return elem;			
		}
		return null;
	}
	
	/*-------------------------AUSILIARI-------------------------*/
	public void print(){
		for(int i=0; i<collection.size(); i++)
			System.out.println("\t" + collection.get(i));
	}


	public int ricercaBin(E key){
		int a = 0;
		int b = size-1;

		while(a <= b){
			int mid = a + (b - a)/2;
			E el = collection.get(mid);
			int result = key.compareTo(el);
			if(result < 0) b = mid-1;
			else if(result > 0) a = mid+1;
			else return mid;
		}
		/* Se il valore non e' stato trovato, ritorno un numero sicuramente negativo,
		 * che rappresenta l'indice che sarebbe associato all'elemento key se fosse presente
		 * all'interno della collezione.
		*/
		return (-a-1);
	}
	
}
