package modelo;
public class OperadorPuzzle {
	public static OperadorPuzzle U = new OperadorPuzzle('U');
	public static OperadorPuzzle D = new OperadorPuzzle('D');
	public static OperadorPuzzle R = new OperadorPuzzle('R');
	public static OperadorPuzzle L = new OperadorPuzzle('L');

	char operador;

	public OperadorPuzzle(char c) {
		operador = c;
	}

	public Puzzle transformar(Puzzle padre) {
		if (!posible(padre)) {
			return null;
		}
		Puzzle hijo = new Puzzle(padre);
		int x;// valor a remplazar
		Coordenada v = new Coordenada(padre.vacio);
		switch (operador) {
		case 'U':
			v.x -= 1;
			break;
		case 'D':
			v.x += 1;
			break;
		case 'L':
			v.y -= 1;
			break;
		case 'R':
			v.y += 1;
			break;
		default:
			return null;
		}

		x = hijo.valor(v);
		hijo.vaciar(v);
		hijo.actualizar(padre.vacio, x);
		hijo.vacio = v;
		hijo.calcularRepresentacion();
		hijo.operador = this;
		return hijo;
	}

	boolean posible(Puzzle p) {
		if (operador == 'D' && p.vacio.x == 2) {
			return false;
		}
		if (operador == 'U' && p.vacio.x == 0) {
			return false;
		}
		if (operador == 'L' && p.vacio.y == 0) {
			return false;
		}
		if (operador == 'R' && p.vacio.y == 2) {
			return false;
		}
		return true;
	}
}
