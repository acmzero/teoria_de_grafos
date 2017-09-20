package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Puzzle extends Vertice<Puzzle> implements Comparable<Puzzle> {
	private static char INCORRECTOS = 'I';
	private static char DIFERENCIA = 'D';
	static List<OperadorPuzzle> operadores = Arrays.asList(OperadorPuzzle.U,
			OperadorPuzzle.D, OperadorPuzzle.L, OperadorPuzzle.R);
	public String representacion;
	public OperadorPuzzle operador; // Operador con el que se llego desde el
									// padre

	Puzzle solucion;
	private char funcionHeuristica;
	int n; // tamano de puzzle n x n
	Integer[][] matriz;

	Integer vf = null; // altura en arbol y valor de funcion heuristica
	Integer vg;

	Coordenada vacio;

	public Puzzle() {
		hijos = new ArrayList<Puzzle>(4);
	}

	/**
	 * 
	 * @param s
	 *            Construye la matriz a partir de una linea de valores separados
	 *            por espacio
	 */
	public Puzzle(String s) {
		this();
		representacion = s.trim();
		String[] componentes = representacion.split(" ");
		// n = sqroot(len(s))
		n = (int) Math.sqrt(componentes.length);
		int x, y;
		vf = 0;
		this.matriz = new Integer[n][n];
		for (int i = 0; i < componentes.length; i++) {
			x = i / n;
			y = i % n;
			if ("X".equalsIgnoreCase(componentes[i])) {
				matriz[x][y] = null;
				vacio = new Coordenada(x, y);
			} else {
				matriz[x][y] = Integer.parseInt(componentes[i]);
			}
		}
		this.padre = null;
	}

	public Puzzle(Puzzle padre) {
		this();
		this.padre = padre;
		this.solucion = padre.solucion;
		this.factor = padre.factor;
		n = padre.n;
		this.funcionHeuristica = padre.funcionHeuristica;

		this.matriz = new Integer[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (padre.matriz[i][j] != null)
					matriz[i][j] = Integer.valueOf(padre.matriz[i][j]);
			}
		}
	}

	public float calcularG(Puzzle solucion) { // heuristica
		if (vg != null) {
			return vg;
		}
		vg = funcionHeuristica(solucion);
		return vg;
	}

	public Integer calcularF() { // altura
		if (vf != null) {
			return vf;
		}
		vf = padre.vf + 1;
		return vf;
	}

	Integer valor(Coordenada c) {
		int x = c.x, y = c.y;
		if (x < 0 || x > 2) {
			System.out.println(x);
		}
		if (y < 0 || y > 2) {
			System.out.println(x);
		}
		return matriz[c.x][c.y];
	}

	Integer valorVacio() {
		return valor(vacio);
	}

	void vaciar(Coordenada c) {
		actualizar(c, null);
	}

	void actualizar(Coordenada c, Integer x) {
		matriz[c.x][c.y] = x;

	}


	@Override
	public int compareTo(Puzzle o) {
		if (o == null) {
			valorPuzzle();
		}
		return valorPuzzle().compareTo(o.valorPuzzle());
//		return ((int) (valorPuzzle() * 100)) - ((int) (o.valorPuzzle() * 100));
	}

	public Float valorPuzzle() {
		if (vg == null) {
			calcularG(solucion);
		}
		return calcularF() + (factor * vg);
	}

	public int funcionHeuristica(Puzzle o) {
		Coordenada cp, cs;
		Integer xp, xs;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cp = new Coordenada(i, j);
				xp = this.valor(cp);
				if (o == null) {
					xs = valor(cp);
				}
				xs = o.valor(cp);
				if (xp != xs) {
					if (funcionHeuristica == INCORRECTOS) {
						sum++;
					} else if (funcionHeuristica == DIFERENCIA) {
						cs = o.coordenada(xp);
						sum += cp.compareTo(cs);
					}
				}
			}
		}

		return sum;
	}

	private Coordenada coordenada(Integer xp) {
		Coordenada c = new Coordenada(0, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c.x = i;
				c.y = j;
				if (xp == valor(c)) {
					return c;
				}
			}
		}
		return null;
	}

	public void heuristicaIncorrecto() {
		this.funcionHeuristica = INCORRECTOS;
	}

	public void heuristicaDifferencia() {
		this.funcionHeuristica = DIFERENCIA;
	}

	public static void main(String[] args) {
	}

	public List<Puzzle> obtenerSucesores() {
		List<Puzzle> sucesores = new LinkedList<Puzzle>();
		Puzzle hijo;
		for (OperadorPuzzle o : operadores) {
			hijo = o.transformar(this);
			if (hijo != null) {
				sucesores.add(hijo);
			}
		}
		return sucesores;
	}

	private int hash = 0;

	@Override
	public int hashCode() {
		calcularRepresentacion();
		if (hash == 0) {
			hash = representacion.hashCode();
		}
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		// return this.hashCode() == obj.hashCode();

		if (obj instanceof Puzzle) {
			calcularRepresentacion();
			Puzzle o = (Puzzle) obj;
			((Puzzle) obj).calcularRepresentacion();

			return this.representacion.equals(o.representacion);
		}
		return super.equals(obj);
	}

	public void calcularRepresentacion() {
		if (representacion != null)
			return;
		Coordenada c = new Coordenada(0, 0);
		Integer x;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c.x = i;
				c.y = j;
				x = valor(c);
				if (x == null) {
					sb.append("X ");
				} else {
					sb.append(x).append(" ");
				}
			}
		}
		representacion = sb.toString().trim();
	}

	@Override
	public String toString() {
		if (representacion == null)
			calcularRepresentacion();
		return representacion;
	}

	public Puzzle getParent() {
		return this.padre;
	}

	public List<Puzzle> hijos() {
		return hijos;
	}

	public String matrixString() {
		calcularRepresentacion();
		Coordenada c = new Coordenada(0, 0);
		Integer v;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c.x = i;
				c.y = j;
				v = valor(c);
				if (v == null) {
					sb.append("X ");
				} else {
					sb.append(valor(c)).append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void solucion(Puzzle s) {
		this.solucion = s;
	}

	Float factor = 1.0f;

	public void factor(float peso) {
		this.factor = peso;
	}
}
