package ui;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.mxgraph.canvas.mxICanvas;
import com.mxgraph.canvas.mxImageCanvas;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.view.mxInteractiveCanvas;
import com.mxgraph.view.mxCellState;
import com.mxgraph.view.mxGraph;

import modelo.ArbolGeneradorPuzzle;
import modelo.Puzzle;

public class ArbolPuzzleGraph extends JFrame {

	private static final long serialVersionUID = 2955532469972521064L;

	private ArbolGeneradorPuzzle arbol;

	private Map<Puzzle, Object> vertexMap = new HashMap<Puzzle, Object>();// stores
																			// Puzzle->
																			// Graphical
																			// vertex
	int PUZZLE_SIDE = 50;

	public ArbolPuzzleGraph(ArbolGeneradorPuzzle a) {
		super("Arbol generador puzzle");
		this.arbol = a;
		mxGraph graph = new mxGraph() {
			@Override
			public void drawState(mxICanvas canvas, mxCellState state,
					boolean drawLabel) {
				String label = (drawLabel) ? state.getLabel() : "";
				if (getModel().isVertex(state.getCell())
						&& canvas instanceof mxImageCanvas
						&& ((mxImageCanvas) canvas).getGraphicsCanvas() instanceof PuzzleCanvas) {
					((PuzzleCanvas) ((mxImageCanvas) canvas)
							.getGraphicsCanvas()).drawVertex(state, label,
							arbol);
				} else if (getModel().isVertex(state.getCell())
						&& canvas instanceof PuzzleCanvas) {
					((PuzzleCanvas) canvas).drawVertex(state, label, arbol);
				} else {
					super.drawState(canvas, state, drawLabel);
				}
			}
		};

		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try {
			// Puzzle parentPuzzle, p;
			Puzzle p;
			Object parentVertex, pVertex;
			String s;

			// for root
			parentVertex = arbol.raiz();
			parentVertex = graph.insertVertex(parent, null,
					parentVertex.toString(), 20, 50, PUZZLE_SIDE, PUZZLE_SIDE);
			vertexMap.put(arbol.raiz(), parentVertex);
			List<Puzzle> lista = new LinkedList<Puzzle>();

			lista.addAll(arbol.raiz().hijos());
			while (!lista.isEmpty()) {
				p = lista.remove(0);
				if (!arbol.getQ().contains(p)) {
					// continue;
				}
				parentVertex = vertexMap.get(p.getParent());
				pVertex = graph.insertVertex(parent, null, p.toString(), 240,
						250 * p.calcularAltura(), PUZZLE_SIDE, PUZZLE_SIDE);
				vertexMap.put(p, pVertex);
				if (p.operador != null) {
					s = p.operador.getOperatorChar();
				} else {
					s = "";
				}
				graph.insertEdge(parentVertex, null, s, parentVertex, pVertex);
				lista.addAll(p.hijos());
			}

		} finally {
			graph.getModel().endUpdate();
		}
		mxGraphComponent graphComponent = new mxGraphComponent(graph) {
			private static final long serialVersionUID = -9075598809892017209L;

			public mxInteractiveCanvas createCanvas() {
				return new PuzzleCanvas(this);
			}
		};
		graphComponent.setEnabled(false);

		this.add(graphComponent);

		// new mxFastOrganicLayout(graph).execute(graph.getDefaultParent());
		new mxHierarchicalLayout(graph).execute(graph.getDefaultParent());
		// new mxParallelEdgeLayout(graph).execute(graph.getDefaultParent());

	}

	public static void main(String[] args) {

		String sp, ss;

		sp = "2 8 3 1 6 4 7 X 5";
		ss = "1 2 3 8 X 4 7 6 5";
		sp = "8 1 2 X 4 3 7 6 5";
		ss = "1 2 3 4 5 6 7 8 X";

		Puzzle p = new Puzzle(sp);
		p.heuristicaIncorrecto();
		// p.heuristicaDifferencia();
		Puzzle s = new Puzzle(ss);
		p.solucion(s);

		ArbolGeneradorPuzzle G = new ArbolGeneradorPuzzle();
		G.generarArbol(p, s);

		ArbolPuzzleGraph gArbol = new ArbolPuzzleGraph(G);
		gArbol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gArbol.setSize(800, 600);
		gArbol.setVisible(true);

	}
}
