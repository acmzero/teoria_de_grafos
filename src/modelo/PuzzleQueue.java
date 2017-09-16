package modelo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PuzzleQueue extends PriorityQueue<Puzzle> {
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

}
