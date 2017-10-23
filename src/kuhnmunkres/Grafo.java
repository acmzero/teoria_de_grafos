package kuhnmunkres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Grafo {
	int mAdj[][];
	int N = 5;
	int XG[], YG[];

	public static void main(String[] args) {
		Grafo g = new Grafo();
		g.solve();
	}

	public Grafo() {
		mAdj = new int[N][N];
		int[][] mat = { { 4, 5, 5, 4, 1 }, { 2, 2, 0, 2, 2 },
				{ 2, 4, 4, 1, 0 }, { 0, 1, 1, 0, 0 }, { 1, 2, 1, 3, 3 } };
		mAdj = mat;
	}

	public Grafo(int[][] mAdj2, int[] X, int[] Y, int n) {
		this.N = n;
		this.XG = X;
		this.YG = Y;
		mAdj = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mAdj2[i][j] == X[i] + Y[j]) {
					mAdj[i][j] = mAdj2[i][j];
				} else {
					mAdj[i][j] = 0;
				}
			}
		}
	}

	List<Vertice> verticesG;
	Vertice[] verticesX, verticesY;

	void procesaVertices() {
		verticesG = new ArrayList<Vertice>(2 * N);
		verticesX = new Vertice[N];
		verticesY = new Vertice[N];
		for (int i = 0; i < N; i++) {
			verticesX[i] = new Vertice(i);
			verticesY[i] = new Vertice(i);
		}
		// Arrays.fill(verticesX, new Vertice());
		// Arrays.fill(verticesY, new Vertice());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				verticesX[i].addChildren(verticesY[j]);
				verticesY[j].addChildren(verticesX[i]);
			}
		}
	}

	int[][] etiquetadoInicial() {
		int[] X = new int[N];
		int[] Y = new int[N];
		int max = 0;
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
		int[][] r = new int[2][N];
		r[0] = X;
		r[1] = Y;
		return r;
	}

	Matching matching() {
		Matching m = new Matching(N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mAdj[i][j] > 0 && !m.isYSaturated(j)) {
					m.addEdge(i, j);
				}
			}
		}

		return m;
	}

	void solve() {
		int[][] etInicial = etiquetadoInicial();
		System.out.println("Et inicial X " + Arrays.toString(etInicial[0]));
		System.out.println("Et inicial Y " + Arrays.toString(etInicial[1]));
		XG = etInicial[0];
		YG = etInicial[1];
		Grafo gl = new Grafo(mAdj, etInicial[0], etInicial[1], N);
		Matching mi = gl.matching();
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
				imprimeAristas(mi.aristas);

				boolean tSubN = (T.isEmpty() && !vecinosS.isEmpty())
						|| vecinosS.containsAll(T);
				tSubN = tSubN && !T.containsAll(vecinosS);
				if (!tSubN) {
					// si !tSubN entonces T == Vecinos
					int minAlpha = Integer.MAX_VALUE, aux;
					for (int s : S) {
						for (int t = 0; t < N; t++) {
							if (!T.contains(t)) {
								aux = gl.XG[s] + gl.YG[t] - mAdj[s][t];
								if (aux < minAlpha) {
									minAlpha = aux;
								}
							}
						}
					}
					int[][] etAum = etiquetado(XG, YG, minAlpha, S, T);
					System.out.println("Et X " + Arrays.toString(etAum[0]));
					System.out.println("Et Y " + Arrays.toString(etAum[1]));
					gl = new Grafo(mAdj, etAum[0], etAum[1], N);
					vecinosS = gl.vecinos(S);
				}

				int y = -1;
				for (int vecino : vecinosS) {
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
					// obten Path de idxU-> y con BFS
					List<Arista> path = gl.BFSPath(idxU, y);
					// reemplaza M con la diff simetrica de M y Aristas del path
					Set<Arista> diffM = new HashSet<Arista>();
					for (Arista a : path) {
						if (!mi.contains(a)) {
							diffM.add(a);
						}
					}
					diffM.addAll(mi.notIn(path));
					mi = new Matching(diffM, N);
				}
			} while (ySat);
		} while (true);
		// mi es nuestro matching optimo
		imprimeAristas(mi.aristas);
	}

	private void imprimeAristas(List<Arista> aristas) {
		System.out.println("Matching:");
		for (Arista a : aristas) {
			System.out.println(String.format("(%d, %d)", a.v1, a.v2));
		}
	}

	private List<Arista> BFSPath(int idxU, int y) {
		procesaVertices();
		Queue<Vertice> q = new LinkedList<Vertice>();
		Map<Vertice, Vertice> padres = new HashMap<Vertice, Vertice>();
		q.add(verticesX[idxU]);
		padres.put(verticesX[idxU], null);
		Vertice c;
		boolean yFound = false;
		while (!q.isEmpty() && !yFound) {
			c = q.poll();
			for (Vertice h : c.hijos) {
				if (!padres.containsKey(h)) {
					q.add(h);
					padres.put(h, c);
					if (h == verticesY[y]) {
						yFound = true;
						break;
					}
				}
			}
		}
		List<Arista> path = new LinkedList<Arista>();
		if (yFound) {
			Vertice p;
			c = verticesY[y];
			int yCount = 0;
			while (c != null) {
				p = padres.get(c);
				if (p != null) {
					if (yCount % 2 == 0) {
						path.add(new Arista(p, c));
					} else {
						path.add(new Arista(c, p));
					}
				}
				c = p;
				yCount++;
			}
			Collections.reverse(path);
		}
		return path;
	}

	private int[][] etiquetado(int[] xG2, int[] yG2, int minAlpha,
			Set<Integer> s, Set<Integer> t) {
		int[] X = new int[N];
		int[] Y = new int[N];
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
		int[][] r = new int[2][N];
		r[0] = X;
		r[1] = Y;
		return r;
	}

	private Set<Integer> vecinos(Set<Integer> s) {
		Set<Integer> vecinos = new HashSet<Integer>();
		for (int i : s) {
			for (int j = 0; j < N; j++) {
				if (mAdj[i][j] > 0) {
					vecinos.add(j);
				}
			}
		}
		return vecinos;
	}
}
