/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuhnmunkres;

import kuhnmunkres.TextField;
import java.util.List;
import kuhnmunkres.Grafo;
import kuhnmunkres.Matching;
import kuhnmunkres.MatchingRender;

/**
 * 
 * @author naty
 */
public class Gui_Kun extends javax.swing.JFrame {

	public Gui_Kun() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		tamaño = new javax.swing.JTextField();
		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jLabel1.setText("ALGORITMO KUHN MUNKRES");

		jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
		jLabel2.setText("Matriz de pesos de: ");

		tamaño.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 665,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 514,
				Short.MAX_VALUE));

		jButton1.setText("Crear");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Resolver");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(147,
																		147,
																		147)
																.addComponent(
																		jLabel1))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(19, 19,
																		19)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jPanel1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel2)
																								.addGap(26,
																										26,
																										26)
																								.addComponent(
																										tamaño,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										53,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(57,
																										57,
																										57)
																								.addComponent(
																										jButton1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										108,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(35,
																										35,
																										35)
																								.addComponent(
																										jButton2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										108,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(18, 18, 18)
								.addComponent(jLabel1)
								.addGap(27, 27, 27)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														tamaño,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														38,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														43,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jButton2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														43,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(38, 38, 38)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(19, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		String f = tamaño.getText();
		dimension = Integer.parseInt(f);
		jPanel1.removeAll();

		cajitas = new TextField[dimension][dimension];

		for (int fila = 0; fila < dimension; fila++) {
			for (int columna = 0; columna < dimension; columna++) {
				cajitas[fila][columna] = new TextField(75 * columna, 30 * fila,
						75, 30);
				cajitas[fila][columna].setNombre(fila, columna);
				jPanel1.add(cajitas[fila][columna]);
			}
		}

		jPanel1.updateUI();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		double[][] matriz_pesos = new double[dimension][dimension];

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				matriz_pesos[i][j] = Double
						.parseDouble(cajitas[i][j].getText());
			}
		}

		Grafo g = new Grafo(matriz_pesos, dimension);
		List<Matching> resultado = g.solve();
		if (resultado != null) {
			MatchingRender mr = new MatchingRender(resultado);
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Gui_Kun.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Gui_Kun.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Gui_Kun.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Gui_Kun.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// new actual().setVisible(true);
				new Gui_Kun().setVisible(true);
				;
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField tamaño;
	// End of variables declaration
	TextField[][] cajitas;
	int dimension;

}