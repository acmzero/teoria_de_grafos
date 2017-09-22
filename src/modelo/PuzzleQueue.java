package modelo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * @author heli
 * Esta clase agrega ala clase PriorityQueue un set para calcular de manera rapida
 * si un objeto X esta dentro de la coleccion.
 * Lo malo es que ocupamos el doble de memoria pero la ejecucion es mucho mas rapida
 *
 */
public class PuzzleQueue extends PriorityQueue<Puzzle> {
	private static final long serialVersionUID = -2039248186034430904L;
	Set<Puzzle> set = new HashSet<Puzzle>();
	
	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}
	
	@Override
	public boolean add(Puzzle e) {
		if(set.contains(e)){
			return false;
		}
		set.add(e);
		return super.add(e);
	}
	
	@Override
	public Puzzle poll() {
		Puzzle e = super.poll();
		set.remove(e);
		return e;
	}
	
	public Puzzle get(Puzzle p){
		Iterator<Puzzle> it = this.iterator();
		Puzzle e; 
		while(it.hasNext()){
			e = it.next();
			if(e.equals(p)){
				return e;
			}
		}
		return null;
	}

}
