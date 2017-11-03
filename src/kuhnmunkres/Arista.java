package kuhnmunkres;

public class Arista {
	int v1;
	int v2;
	double peso;
	boolean inMatching = false;

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
		this(p, c);
		peso = d;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Arista) {
			Arista a = (Arista) arg0;
			return a.v1 == v1 && a.v2 == v2;
		}
		return super.equals(arg0);
	}

	@Override
	public String toString() {
		return String.format("(X%d Y%d, w=%.2f)", v1, v2, peso);
	}

    public double getPeso() {
        return peso;
    }

}
