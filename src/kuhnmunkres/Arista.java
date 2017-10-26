package kuhnmunkres;

public class Arista {
	int v1;
	int v2;
	double peso;

	public Arista(int x, int y) {
		v1 = x;
		v2 = y;
	}

	public Arista(Vertice c, Vertice p) {
		v1 = c.id;
		v2 = p.id;
	}

	public Arista(int i, int j, double peso2) {
		this(i, j);
		peso = peso2;
	}

	public Arista(Vertice p, Vertice c, double d) {
		this(p,c);
		peso = d;
	}

}
