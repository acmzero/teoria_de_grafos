package ui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.CellRendererPane;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import modelo.ArbolGeneradorPuzzle;
import modelo.Puzzle;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.view.mxInteractiveCanvas;
import com.mxgraph.view.mxCellState;

public class PuzzleCanvas extends mxInteractiveCanvas {

	private mxGraphComponent graphComponent;
	private JLabel vertexRenderer = new JLabel();
	private CellRendererPane rendererPane = new CellRendererPane();

	public PuzzleCanvas(mxGraphComponent graphComponent) {
		this.graphComponent = graphComponent;
		

	}
	
	public void drawVertex(mxCellState state, String label, ArbolGeneradorPuzzle arbol){
		Puzzle p = new Puzzle(label);
		String s = p.matrixString().replaceAll("\n", "<br>");

		vertexRenderer = new JLabel("<html>"+s+"</html>");
		vertexRenderer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		vertexRenderer.setHorizontalAlignment(JLabel.CENTER);
		vertexRenderer.setOpaque(true);
		if(arbol.getQ().contains(p)){
			vertexRenderer.setBackground(Color.GREEN);
		}

		
		rendererPane.paintComponent(g, vertexRenderer, graphComponent,
				(int) (state.getX() + translate.getX()),
				(int) (state.getY() + translate.getY()),
				(int) state.getWidth(), (int) state.getHeight(), true);
	}

}
