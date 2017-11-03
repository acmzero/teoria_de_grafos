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
		hijosArista.add(new Arista(this, vertice, p));
	}

	public List<Arista> hijosNotIn(List<Arista> aristas, boolean notIn) {
		List<Arista> list = new LinkedList<Arista>();
		for (Arista a : aristas) {
			if (!aristas.contains(a) && notIn) {
				list.add(a);
			} else {
				list.add(a);
			}
		}
		return list;
	}

	public Arista getAristaTo(Vertice padre) {
		for (Arista a : hijosArista) {
			if (a.v1 == padre.id || a.v2 == padre.id) {
				return a;
			}
		}
		return null;

	}

	@Override
	public String toString() {
		return "" + id;
	}

}
