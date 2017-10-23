package kuhnmunkres;

import java.util.LinkedList;
import java.util.List;

public class Vertice {

	public List<Vertice> hijos = new LinkedList<Vertice>();
	public int id;

	public Vertice(int i) {
		id = i;
	}

	public void addChildren(Vertice vertice) {
		hijos.add(vertice);
	}

}
