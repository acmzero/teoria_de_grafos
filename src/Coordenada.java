public class Coordenada implements Comparable<Coordenada> {
	public Coordenada(Coordenada vacio) {
		this.x = vacio.x;
		this.y = vacio.y;
	}

	public Coordenada(int i, int j) {
		this.x = i;
		this.y = j;
	}

	int x, y;

	@Override
	public int compareTo(Coordenada o) {
		return Math.abs(x - o.x) + Math.abs(y - o.y);
	}

}
