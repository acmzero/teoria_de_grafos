public class OperadorPuzzle {
	static OperadorPuzzle U = new OperadorPuzzle('U');
	static OperadorPuzzle D = new OperadorPuzzle('D');
	static OperadorPuzzle R = new OperadorPuzzle('R');
	static OperadorPuzzle L = new OperadorPuzzle('L');

	char operador;

	public OperadorPuzzle(char c) {
		operador = c;
	}

	Puzzle transformar(Puzzle padre, OperadorPuzzle o) {
		if (!posible(padre, o)) {
			return null;
		}
		Puzzle hijo = new Puzzle(padre);
		int x;// valor a remplazar
		Coordenada v = new Coordenada(padre.vacio);
		switch (operador) {
		case 'U':
			v.y -= 1;
			break;
		case 'D':
			v.y += 1;
			break;
		case 'L':
			v.x -= 1;
			break;
		case 'R':
			v.x += 1;
			break;
		default:
			return null;
		}

		x = hijo.valor(v);
		hijo.vaciar(v);
		hijo.actualizar(padre.vacio, x);
		hijo.vacio = v;
		return hijo;
	}

	boolean posible(Puzzle p, OperadorPuzzle o) {
		if (o.operador == 'D' && p.vacio.y == 2) {
			return false;
		}
		if (o.operador == 'U' && p.vacio.y == 0) {
			return false;
		}
		if (o.operador == 'L' && p.vacio.x == 0) {
			return false;
		}
		if (o.operador == 'R' && p.vacio.x == 2) {
			return false;
		}
		return true;
	}
}
