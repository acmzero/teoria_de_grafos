package kuhnmunkres;

import java.util.LinkedList;
import java.util.List;

public class Vertice {

	public List<Vertice> hijos = new LinkedList<Vertice>();
	public List<Arista> hijosArista = new LinkedList<Arista>();
	public int id;

	public Vertice(int i) {
		id = i;
	}

	public void addChildren(Vertice vertice, double p) {
		hijos.add(vertice);
		hijosArista.add(new Arista(this,vertice, p));
	}

}
