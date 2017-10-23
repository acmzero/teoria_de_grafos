package kuhnmunkres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Matching {
	List<Arista> aristas;
	boolean ySaturated[];
	boolean xSaturated[];
	int N;

	public Matching(int N) {
		aristas = new ArrayList<Arista>();
		this.N = N;
		inicializaSaturados();
	}

	private void inicializaSaturados() {
		ySaturated = new boolean[N];
		xSaturated = new boolean[N];
		Arrays.fill(xSaturated, false);
		Arrays.fill(ySaturated, false);

	}

	public Matching(Collection<Arista> diffM, int n2) {
		aristas = new LinkedList<Arista>(diffM);
		N = n2;
		inicializaSaturados();
		for (Arista a : aristas) {
			xSaturated[a.v1] = true;
			ySaturated[a.v2] = true;
		}
	}

	public boolean isYSaturated(int j) {
		return ySaturated[j];
	}

	public void addEdge(int i, int j) {
		Arista e = new Arista(i, j);
		aristas.add(e);
		ySaturated[j] = true;
		xSaturated[i] = true;
	}

	public int isXSaturated() {
		for (int i = 0; i < N; i++) {
			if (!xSaturated[i]) {
				return i;
			}
		}
		return -1;
	}

	public Integer getAdjacentVertex(int y) {
		for (Arista a : aristas) {
			if (a.v2 == y) {
				return a.v1;
			}
		}
		return -1;
	}

	public boolean contains(Arista a) {
		for (Arista b : aristas) {
			if (b.v1 == a.v1 && b.v2 == a.v2) {
				return true;
			}
		}
		return false;
	}

	public Collection<? extends Arista> notIn(List<Arista> path) {
		List<Arista> diff = new LinkedList<Arista>();
		boolean bFound;
		for (Arista b : aristas) {
			bFound = false;
			for (Arista a : path) {
				if (b.v1 == a.v1 && b.v2 == a.v2) {
					bFound = true;
					break;
				}
			}
			if (!bFound) {
				diff.add(b);
			}
		}
		return diff;
	}

	public boolean isXSaturated(int i) {
		return xSaturated[i];
	}
}
