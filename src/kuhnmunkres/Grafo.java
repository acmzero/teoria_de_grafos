package kuhnmunkres;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Grafo {
	double mAdj[][], mInicial[][];
	int N;
	double XG[], YG[];
	HashSet<Arista> aristas;
	HashSet<Vertice> vertices;
	Vertice[] verticesX, verticesY;

	public Grafo(double[][] matriz, int N) {
		mAdj = matriz;
		mInicial = matriz;
		this.N = N;
		procesaVertices();
	}

	public Grafo(double[][] mInicial, double[] X, double[] Y, int n) {
		this.N = n;
		this.XG = X;
		this.YG = Y;
		mAdj = new double[N][N];
		this.mInicial = mInicial;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (((Double) mInicial[i][j]).compareTo((Double) (X[i] + Y[j])) == 0) {
					mAdj[i][j] = mInicial[i][j];
				} else {
					mAdj[i][j] = -1;
				}
			}
		}
		procesaVertices();
	}

	void procesaVertices() {
		aristas = new HashSet<Arista>();
		verticesX = new Vertice[N];
		verticesY = new Vertice[N];
		vertices = new HashSet<Vertice>();
		for (int i = 0; i < N; i++) {
			verticesX[i] = new Vertice(i, 'X');
			verticesY[i] = new Vertice(i, 'Y');
			vertices.add(verticesX[i]);
			vertices.add(verticesY[i]);
		}
		double p;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				p = mAdj[i][j];
				if (p >= 0) {
					aristas.add(new Arista(i, j, p));
					verticesX[i].addChildren(verticesY[j], p);
					verticesY[j].addChildren(verticesX[i], p);
				}
			}
		}

	}

	double[][] etiquetadoInicial() {
		double[] X = new double[N];
		double[] Y = new double[N];
		double max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mAdj[i][j] > max) {
					max = mAdj[i][j];
				}
			}
			X[i] = max;
			Y[i] = 0;
			max = 0;
		}
		double[][] r = new double[2][N];
		r[0] = X;
		r[1] = Y;
		return r;
	}

	Matching matching() {
		Matching m = new Matching(N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mAdj[i][j] >= 0 && !m.isYSaturated(j) && !m.isXSaturated(i)) {
					m.addEdge(i, j, mAdj[i][j]);
				}
			}
		}

		return m;
	}

	public List<Matching> solve() {
		double[][] etInicial = etiquetadoInicial();
		System.out.println("Et inicial X " + Arrays.toString(etInicial[0]));
		System.out.println("Et inicial Y " + Arrays.toString(etInicial[1]));
		XG = etInicial[0];
		YG = etInicial[1];
		Grafo gl = new Grafo(mInicial, etInicial[0], etInicial[1], N);
		Matching mi = gl.matching();
		imprimeAristas(mi.aristas);
		List<Matching> matchings = new LinkedList<Matching>();
		matchings.add(mi);
		do {
			int idxU = mi.isXSaturated();
			if (idxU < 0) {
				// yasta
				break;
			}
			Set<Integer> S = new HashSet<Integer>();
			Set<Integer> T = new HashSet<Integer>();
			S.add(idxU);

			boolean ySat = true;
			do {
				Set<Integer> vecinosS = gl.vecinos(S);

				if (sameSet(T, vecinosS)) {
					double minAlpha = Integer.MAX_VALUE, aux;
					for (int s : S) {
						for (int t = 0; t < N; t++) {
							if (!T.contains(t)) {
								aux = gl.XG[s] + gl.YG[t] - mInicial[s][t];
								if (aux < minAlpha) {
									minAlpha = aux;
								}
							}
						}
					}
					double[][] etAum = etiquetado(gl.XG, gl.YG, minAlpha, S, T);
					System.out.println("Et X " + Arrays.toString(etAum[0]));
					System.out.println("Et Y " + Arrays.toString(etAum[1]));
					gl = new Grafo(mInicial, etAum[0], etAum[1], N);
					vecinosS = gl.vecinos(S);
				}

				int y = -1;
				for (int vecino : gl.vecinos(S)) {
					if (!T.contains(vecino)) {
						y = vecino;
						break;
					}
				}
				ySat = mi.isYSaturated(y);

				if (ySat) {
					S.add(mi.getAdjacentVertex(y));
					T.add(y);
				} else {
					// obten Path de idxU-> y con BFS este es el camino M
					// aumentante
					List<Arista> path = gl.BFSPath(idxU, y, mi);
					matchings.add(new Matching(path, N));
					// reemplaza M con la diff simetrica de M y Aristas del path
					Set<Arista> diffM = new HashSet<Arista>();

					for (Arista a : path) {
						if (!mi.contains(a)) {
							diffM.add(a);
						}
					}
					diffM.addAll(mi.notIn(path));
					mi = new Matching(diffM, N);
					imprimeAristas(mi.aristas);
				}
			} while (ySat);
		} while (true);
		// mi es nuestro matching optimo
		imprimeAristas(mi.aristas);
		matchings.add(mi);
		return matchings;
	}

	private void imprimeAristas(List<Arista> aristas) {
		System.out.println("Matching:");
		for (Arista a : aristas) {
			System.out.println(String.format("(%d, %d)", a.v1, a.v2));
		}
	}

	private List<Arista> BFSPath(int u, int y, Matching m) {
		procesaVertices();
		Vertice verticeU = verticesX[u];
		boolean buscarSaturados = false;
		List<Arista> hijos = verticeU.hijosNotIn(m.aristas);
		Map<Arista, Arista> padres = new HashMap<Arista, Arista>();
		LinkedList<Arista> q = new LinkedList<Arista>();
		Arista aristaY = null;
		for (Arista a : hijos) {
			padres.put(a, null);
			q.add(a);
			if(a.v2==y){
				aristaY = a;
				break;
			}
		}
		buscarSaturados = true;
		Arista a;

		while (!q.isEmpty() && aristaY==null) {
			a = q.poll();
			buscarSaturados = !m.aristas.contains(a);
			if (buscarSaturados) {
				// meaning from Y->X in matching
				hijos = verticesY[a.v2].hijosIn(m.aristas);
			} else {
				// meaning from X->Y not in the matching
				hijos = verticesX[a.v1].hijosNotIn(m.aristas);
			}
			for (Arista h : hijos) {
				if (!padres.containsKey(h)) {
					padres.put(h, a);
					q.add(h);
					if (!buscarSaturados && h.v2 == y) {
						aristaY = h;
						break;
					}
				}
			}
		}
		List<Arista> path = new LinkedList<Arista>();
		if (aristaY != null) {
			a = aristaY;
			Arista padre;
			while (a != null) {
				padre = padres.get(a);
				path.add(a);
				a = padre;
			}
		}

		return path;
	}


	private double[][] etiquetado(double[] xG2, double[] yG2, double minAlpha,
			Set<Integer> s, Set<Integer> t) {
		double[] X = new double[N];
		double[] Y = new double[N];
		for (int i = 0; i < N; i++) {
			if (s.contains(i)) {
				X[i] = xG2[i] - minAlpha;
			} else {
				X[i] = xG2[i];
			}
		}
		for (int i = 0; i < N; i++) {
			if (t.contains(i)) {
				Y[i] = yG2[i] + minAlpha;
			} else {
				Y[i] = yG2[i];
			}
		}
		double[][] r = new double[2][N];
		r[0] = X;
		r[1] = Y;
		return r;
	}

	private Set<Integer> vecinos(Set<Integer> s) {
		Set<Integer> vecinos = new HashSet<Integer>();
		for (int i : s) {
			for (int j = 0; j < N; j++) {
				if (mAdj[i][j] >= 0) {
					vecinos.add(j);
				}
			}
		}
		return vecinos;
	}

	@Override
	public String toString() {
		return mAdj.toString();
	}

	public boolean sameSet(Collection<?> a, Collection<?> b) {
		return a.containsAll(b) && b.containsAll(a);
	}
}
