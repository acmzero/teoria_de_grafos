package modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ArbolGeneradorPuzzle extends Grafo<Puzzle> {
	Set<Puzzle> Q;
	Queue<Puzzle> P;
	Puzzle sol, solucionGenerada;

	public void generarArbol(Puzzle p, Puzzle s) {
		sol = s;
		Q = new HashSet<Puzzle>();
		P = new PuzzleQueue();
		P.add(p);

		Puzzle u;
		int sp, sq;
		while (!P.contains(s) && !P.isEmpty()) {
			u = P.poll();
			expander(u);
			sp = P.size();
			sq = Q.size();
		}

		// TODO: mejorar iteracion
		Iterator<Puzzle> it = P.iterator();
		Puzzle v;
		while (it.hasNext()) {
			v = it.next();
			if (sol.equals(v)) {
				solucionGenerada = v;
				break;
			}
		}
	}

	private void expander(Puzzle u) {
		Q.add(u);
		List<Puzzle> sucesores = u.obtenerSucesores();
		for (Puzzle v : sucesores) {
			if (!P.contains(v) && !Q.contains(v)) {
				v.calcularF();
				v.calcularG(sol);
				P.add(v);
			}
		}
	}

	List<OperadorPuzzle> camino = null;

	public List<OperadorPuzzle> obtenerCamino() {
		if (camino != null) {
			return camino;
		}
		Puzzle v = solucionGenerada;
		camino = new LinkedList<OperadorPuzzle>();
		while (v != null) {
			if (v.operador != null)
				camino.add(v.operador);

			v = v.padre;
		}
		Collections.reverse(camino);
		return camino;
	}

	public String stringCamino() {
		obtenerCamino();
		StringBuilder sb = new StringBuilder();
		Iterator<OperadorPuzzle> it = camino.iterator();
		if (it.hasNext()) {
			sb.append(it.next().operador);
		}
		while (it.hasNext()) {
			sb.append("->").append(it.next().operador);
		}

		return sb.toString();
	}

	public void imprimeCamino() {
		System.out.println(stringCamino());
	}
}
