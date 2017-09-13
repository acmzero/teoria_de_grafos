import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Puzzle implements Comparable<Puzzle> {
	static char INCORRECTOS = 'I';
	static char DIFERENCIA = 'D';

	Puzzle padre;
	List<Puzzle> hijos;
	Puzzle solucion;
	char funcionHeuristica;
	int n; // tamano de puzzle n x n

	/**
	 * 
	 * @param s
	 *            Construye la matriz a partir de una linea de valores separados
	 *            por espacio
	 */
	public Puzzle(String s) {
		String[] componentes = s.split(" ");
		// n = sqroot(len(s))
		n = (int) Math.sqrt(componentes.length);
		int x, y;
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
	}

	public Puzzle(Puzzle padre) {
		this.matriz = new Integer[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = padre.matriz[i][j];
			}
		}
		vf = calcularF();
		vg = calcularG(solucion); // heuristica
	}

	private int calcularG(Puzzle solucion) { // heuristica
		return this.compareTo(solucion);
	}

	private int calcularF() { // altura
		return padre.vf + 1;
	}

	Integer valor(Coordenada c) {
		return matriz[c.x][c.y];
	}

	Integer valorVacio() {
		return valor(vacio);
	}

	void vaciar(Coordenada c) {
		actualizar(vacio, null);
	}

	void actualizar(Coordenada c, Integer x) {
		matriz[c.x][c.y] = x;

	}

	Integer[][] matriz;

	int vf, vg; // altura en arbol y valor de funcion heuristica

	Coordenada vacio;

	@Override
	public int compareTo(Puzzle o) {
		Coordenada cp, cs;
		Integer xp, xs;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cp = new Coordenada(i, j);
				xp = this.valor(cp);
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
				// if(xp!=null && xp.equals(valor(c))){
				// return c;
				// }else if(xp == null && valor(c)==null){
				// return c;
				// }
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String sp, ss;

		sp = "2 8 3 1 6 4 7 X 5";
		ss = "1 2 3 8 X 4 7 6 5";

		Puzzle p = new Puzzle(sp);
		p.funcionHeuristica = INCORRECTOS;
		Puzzle s = new Puzzle(ss);
		System.out.println(p.compareTo(s));

		List<Puzzle> lista = Arrays.asList(p, s);
		Collections.sort(lista);
	}
}
