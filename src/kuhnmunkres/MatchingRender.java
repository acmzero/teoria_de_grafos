package kuhnmunkres;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;

public class MatchingRender extends JFrame {
	private static final long serialVersionUID = 6352840406648921413L;

	public MatchingRender(List<Matching> matchings) {
		this.setSize(1024, 768);
		this.setLayout(new GridLayout(1, matchings.size()));
		this.setVisible(true);
		mxGraphComponent c;
		for (Matching m : matchings) {
			c = m.crearComponente();
			if (c != null) {
				this.add(c);
			}

		}
	}

}
