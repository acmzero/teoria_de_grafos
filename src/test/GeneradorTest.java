package test;

import static org.junit.Assert.*;

import java.util.List;

import modelo.ArbolGeneradorPuzzle;
import modelo.OperadorPuzzle;
import modelo.Puzzle;

import org.junit.Test;

public class GeneradorTest {

	@Test
	public void test() {
		String sp, ss;

		sp = "2 8 3 1 6 4 7 X 5";
		ss = "1 2 3 8 X 4 7 6 5";
		// esta no tiene solucion
		// sp = "8 1 2 X 4 3 7 6 5";
		// ss = "1 2 3 4 5 6 7 8 X";
		// sp = "6 7 X 2 5 1 4 8 3";
		// ss = "1 2 3 8 X 4 7 6 5";

		Puzzle p = new Puzzle(sp);
		p.heuristicaIncorrecto();
		Puzzle s = new Puzzle(ss);
		p.solucion(s);

		ArbolGeneradorPuzzle G = new ArbolGeneradorPuzzle();
		G.generarArbol(p, s);
		List<OperadorPuzzle> camino = G.obtenerCamino();
		assertTrue(G.getQ().size() > 0);
		assertTrue("Camino no debe de ser vacio", !camino.isEmpty());
		G.imprimeCamino();
	}

}
