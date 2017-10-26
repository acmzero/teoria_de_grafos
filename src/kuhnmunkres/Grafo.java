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
	double mAdj[][], mInicial[][];
	int N = 5;
	double XG[], YG[];

	public static void main(String[] args) {
		Grafo g = new Grafo();
		g.solve();
	}
	public Grafo(double[][] matriz, int N){
		mAdj =matriz;
		mInicial = matriz;
		this.N = N;
	}

	public Grafo() {
		mAdj = new double[N][N];
		double[][] mat = { { 4, 5, 50, 4, 1 }, { 2, 2, 0, 2, 2 },
				{ 2, 4, 4, 1, 0 }, { 0, 1, 1, 0, 0 }, { 1, 2, 1, 3, 3 } };
		mAdj = mat;
		mInicial = mat;
	}

	public Grafo(double[][] mAdj2, double[] X, double[] Y, int n) {
		this.N = n;
		this.XG = X;
		this.YG = Y;
		mAdj = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mAdj2[i][j] == X[i] + Y[j]) {
					mAdj[i][j] = mAdj2[i][j];
				} else {
					mAdj[i][j] = -1;
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
			verticesG.add(verticesX[i]);
			verticesG.add(verticesY[i]);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				verticesX[i].addChildren(verticesY[j]);
				verticesY[j].addChildren(verticesX[i]);
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
				if (mAdj[i][j] > 0 && !m.isYSaturated(j) && !m.isXSaturated(i)) {
					m.addEdge(i, j, mAdj[i][j]);
				}
			}
		}

		return m;
	}

	List<Matching> solve() {
		double[][] etInicial = etiquetadoInicial();
		System.out.println("Et inicial X " + Arrays.toString(etInicial[0]));
		System.out.println("Et inicial Y " + Arrays.toString(etInicial[1]));
		XG = etInicial[0];
		YG = etInicial[1];
		Grafo gl = new Grafo(mAdj, etInicial[0], etInicial[1], N);
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
//				Set<Integer> vecinosS = gl.vecinos(S);

				boolean tEqN = gl.vecinos(S).containsAll(T) && T.containsAll(gl.vecinos(S));
				if (tEqN) {
					// si !tSubN entonces T == Vecinos
					double minAlpha = Integer.MAX_VALUE, aux;
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
					double[][] etAum = etiquetado(XG, YG, minAlpha, S, T);
					System.out.println("Et X " + Arrays.toString(etAum[0]));
					System.out.println("Et Y " + Arrays.toString(etAum[1]));
					gl = new Grafo(mInicial, etAum[0], etAum[1], N);
//					vecinosS = gl.vecinos(S);
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
					// obten Path de idxU-> y con BFS este es el camino M aumentante
					List<Arista> path = gl.BFSPath(idxU, y);
					matchings.add(new Matching(path,N));
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
						path.add(new Arista(p, c, mAdj[p.id][c.id]));
					} else {
						path.add(new Arista(c, p, mAdj[c.id][p.id]));
					}
				}
				c = p;
				yCount++;
			}
			Collections.reverse(path);
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
}
