package kuhnmunkres;

import java.util.LinkedList;
import java.util.List;

public class Vertice {

	public List<Vertice> hijos = new LinkedList<Vertice>();
	public List<Arista> hijosArista = new LinkedList<Arista>();
	public int id;
	char set;

	public Vertice(int i, char c) {
		id = i;
		set = c;
	}

	public void addChildren(Vertice vertice, double p) {
		hijos.add(vertice);
		if (set == 'Y') {
			hijosArista.add(new Arista(vertice, this, p));
		} else {
			hijosArista.add(new Arista(this, vertice, p));
		}
	}

	public List<Arista> hijosNotIn(List<Arista> aristas, boolean notIn) {
		List<Arista> list = new LinkedList<Arista>();
		boolean cont;
		for (Arista a : hijosArista) {
			cont = aristas.contains(a);
			if (!cont && notIn) {
				list.add(a);
			} else if (cont && !notIn) {
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
		return "" + set + id;
	}

	public List<Arista> hijosNotIn(List<Arista> aristas) {
		return hijosNotIn(aristas, true);
	}

	public List<Arista> hijosIn(List<Arista> aristas) {
		return hijosNotIn(aristas, false);
	}
}
