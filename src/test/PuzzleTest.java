package test;

import static org.junit.Assert.*;
import modelo.OperadorPuzzle;
import modelo.Puzzle;

import org.junit.Test;

public class PuzzleTest {

	@Test
	public void test() {
		String sp, ss;

		sp = "2 8 3 1 6 4 7 X 5";
		ss = "1 2 3 8 X 4 7 6 5";

		Puzzle p = new Puzzle(sp);
		p.heuristicaIncorrecto();
		Puzzle s = new Puzzle(ss);
		assertEquals(5, p.compareTo(s));
		p.heuristicaDifferencia();
		assertEquals(6, p.compareTo(s));
		
		Puzzle u = OperadorPuzzle.U.transformar(p);
		String su = "2 8 3 1 X 4 7 6 5";
		assertEquals(su,u.representacion	);
	}

}
