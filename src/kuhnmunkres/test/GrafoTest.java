package kuhnmunkres.test;

import java.util.List;

import kuhnmunkres.Grafo;
import kuhnmunkres.Matching;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrafoTest {

	public void test(double[][] mat, int n) {
		Grafo G = new Grafo(mat, n);

		Object ex = null;
		List<Matching> mi = null;

//		try {
			mi = G.solve();
//		} catch (Exception e) {
//			ex = e;
//		}

		assertNull(ex);
		assertNotNull(mi);
		assertTrue(!mi.isEmpty());
	}
	
	@Test
	public void testOriginal(){
		double[][] mat = { { 4, 5, 5, 4, 1 }, { 2, 2, 0, 2, 2 },
				{ 2, 4, 4, 1, 0 }, { 0, 1, 1, 0, 0 }, { 1, 2, 1, 3, 3 } };
//		test(mat,5);
	}
	
	@Test
	public void testRandom(){
		 double[][] mat = { { 250, 600, 350 }, { 400, 500, 250 },
		 { 200, 400, 350 } };
//		 test(mat,3);
	}
	@Test
	public void testI1(){
		double[][] mat = { { 1, 2, 3 }, { 2, 4, 6 }, { 3, 6, 9 } };
		 test(mat,3);
	}

}
