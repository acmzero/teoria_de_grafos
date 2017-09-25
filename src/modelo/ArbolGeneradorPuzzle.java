package modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ArbolGeneradorPuzzle extends Grafo<Puzzle> {
	Set<Puzzle> Q;
	PuzzleQueue P;
	Puzzle sol, solucionGenerada, raiz;

	public Collection<Puzzle> getQ() {
		return Q;
	}

	public Queue<Puzzle> getP() {
		return P;
	}

	public Puzzle raiz() {
		return raiz;
	}

	public void generarArbol(Puzzle p, Puzzle s) {
		sol = s;
		raiz = p;
		Q = new HashSet<Puzzle>();
		P = new PuzzleQueue(); //Coleccion optimizada de Puzzle
		P.add(p);
		Puzzle u;
		while (!P.contains(s) && !P.isEmpty()) {
			u = P.poll(); //Obtener y remover primer elemento de P
			expander(u);
		}
		solucionGenerada = P.get(sol);
		if (solucionGenerada != null) {
			Q.add(solucionGenerada);
			P.remove(solucionGenerada);
		}
	}

	public Puzzle solucion() {
		return solucionGenerada;
	}

	private void expander(Puzzle u) {
		Q.add(u);
		//Padre se agrega automaticamente en este paso
		List<Puzzle> sucesores = u.obtenerSucesores();
		for (Puzzle v : sucesores) {
			if (!P.contains(v) && !Q.contains(v)) {
				v.calcularAltura();
				v.calcularHeuristica(sol);
				P.add(v);
				u.hijos.add(v);
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
