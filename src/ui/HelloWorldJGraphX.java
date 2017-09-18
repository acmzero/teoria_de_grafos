package ui;

import java.awt.Container;

import javax.swing.JFrame;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class HelloWorldJGraphX extends JFrame{

	private static final long serialVersionUID = 6621061840065056833L;
	
	public HelloWorldJGraphX(){
		super("Hello World JGraphX");
		
		mxGraph graph = new mxGraph();
		
		Object parent = graph.getDefaultParent();
		
		graph.getModel().beginUpdate();
	try{	
		Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 30, 80);
		Object v2 = graph.insertVertex(parent, null, "Hello", 240, 250, 80, 30);
		graph.insertEdge(parent, null, "Edge", v1, v2);
	}finally{
		graph.getModel().endUpdate();
	}
		
		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		
		this.add(graphComponent);
		
		new mxHierarchicalLayout(graph).execute(graph.getDefaultParent());
//		Container parentComponent = getParent();
		
//		getParent().add(graphComponent);
		
	}
	
	public static void main(String[] args) {
		HelloWorldJGraphX frame = new HelloWorldJGraphX();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,320);
		frame.setVisible(true);
	}

}
