package kuhnmunkres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class Matching {
	List<Arista> aristas;
	boolean ySaturated[];
	boolean xSaturated[];
	int N;

	public Matching(int N) {
		aristas = new ArrayList<Arista>();
		this.N = N;
		inicializaSaturados();
	}

	private void inicializaSaturados() {
		ySaturated = new boolean[N];
		xSaturated = new boolean[N];
		Arrays.fill(xSaturated, false);
		Arrays.fill(ySaturated, false);

	}

	public Matching(Collection<Arista> diffM, int n2) {
		aristas = new LinkedList<Arista>(diffM);
		N = n2;
		inicializaSaturados();
		for (Arista a : aristas) {
			xSaturated[a.v1] = true;
			ySaturated[a.v2] = true;
		}
	}

	public boolean isYSaturated(int j) {
		return ySaturated[j];
	}

	public void addEdge(int i, int j, double peso) {
		Arista e = new Arista(i, j, peso);
		e.inMatching = true;
		aristas.add(e);
		ySaturated[j] = true;
		xSaturated[i] = true;

	}

	public int isXSaturated() {
		for (int i = 0; i < N; i++) {
			if (!xSaturated[i]) {
				return i;
			}
		}
		return -1;
	}
	public Integer getAdjacentVertex(int y) {
		for (Arista a : aristas) {
			if (a.v2 == y) {
				return a.v1;
			}
		}
		return -1;
	}

	public boolean contains(Arista a) {
		for (Arista b : aristas) {
			if (b.v1 == a.v1 && b.v2 == a.v2) {
				return true;
			}
		}
		return false;
	}

	public Collection<? extends Arista> notIn(List<Arista> path) {
		List<Arista> diff = new LinkedList<Arista>();
		boolean bFound;
		for (Arista b : aristas) {
			bFound = false;
			for (Arista a : path) {
				if (b.v1 == a.v1 && b.v2 == a.v2) {
					bFound = true;
					break;
				}
			}
			if (!bFound) {
				diff.add(b);
			}
		}
		return diff;
	}

	public boolean isXSaturated(int i) {
		return xSaturated[i];
	}

	public mxGraphComponent crearComponente() {
		mxGraph graph = new mxGraph();

		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		int sideSize = 15;
		Object[] xVertex = new Object[N];
		Object[] yVertex = new Object[N];
		int altura = 10;
		mxGeometry geometry = new mxGeometry();
		Object edge;
		try {
			for (int i = 0; i < N; i++) {
				xVertex[i] = graph.insertVertex(parent, null, "x" + i, 10,
						altura, sideSize, sideSize);
				yVertex[i] = graph.insertVertex(parent, null, "y" + i, 80,
						altura, sideSize, sideSize);
				altura += 35;
			}
			for (Arista a : aristas) {
				edge = graph.insertEdge(xVertex[a.v1], null, "" + a.peso,
						xVertex[a.v1], yVertex[a.v2]);
				geometry = graph.getModel().getGeometry(edge);
				geometry.setX(-0.5);

			}
		} finally {
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.setEnabled(false);
		// new mxParallelEdgeLayout(graph).execute(graph.getDefaultParent());
		// new mxHierarchicalLayout(graph).execute(graph.getDefaultParent());
		// new mxEdgeLabelLayout(graph).execute(graph.getDefaultParent());

		return graphComponent;
	}

    public List<Arista> regreAristas() {
        return aristas;
    }
}
