package kuhnmunkres;

public class Arista {
	int v1;
	int v2;

	public Arista(int x, int y) {
		v1 = x;
		v2 = y;
	}

	public Arista(Vertice c, Vertice p) {
		v1 = c.id;
		v2 = p.id;
	}

}
