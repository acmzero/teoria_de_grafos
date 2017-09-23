package ui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;

import modelo.ArbolGeneradorPuzzle;
import modelo.Puzzle;
import ui.ArbolPuzzleGraph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author naty
 */
public class GUI_Puzzle extends javax.swing.JFrame {
	private ArbolGeneradorPuzzle arbol;
	char[] numeros = new char[8];
	char[] numerosP2 = new char[8];
	private List<JTextField> iniciales;
	private List<JTextField> finales;
	private ArrayList<JTextField> secuencia;

	/**
	 * Creates new form NewJFrame
	 */
	public GUI_Puzzle() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		I7 = new javax.swing.JTextField();
		I8 = new javax.swing.JTextField();
		I9 = new javax.swing.JTextField();
		I4 = new javax.swing.JTextField();
		I5 = new javax.swing.JTextField();
		I6 = new javax.swing.JTextField();
		I1 = new javax.swing.JTextField();
		I2 = new javax.swing.JTextField();
		I3 = new javax.swing.JTextField();
		iniciales = Arrays.asList(I1, I2, I3, I4, I5, I6, I7, I8, I9);
		jPanel2 = new javax.swing.JPanel();
		I19 = new javax.swing.JTextField();
		I20 = new javax.swing.JTextField();
		I21 = new javax.swing.JTextField();
		I22 = new javax.swing.JTextField();
		I23 = new javax.swing.JTextField();
		I24 = new javax.swing.JTextField();
		I25 = new javax.swing.JTextField();
		I26 = new javax.swing.JTextField();
		I27 = new javax.swing.JTextField();
		finales = Arrays.asList(I25, I26, I27, I22, I23, I24, I19, I20, I21);

		secuencia = new ArrayList<JTextField>(20);
		secuencia.addAll(iniciales);
		secuencia.addAll(finales);

		jLabel1 = new javax.swing.JLabel();
		opcion = new javax.swing.JComboBox<>();
		jLabel2 = new javax.swing.JLabel();
		pesoAlpha = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		btnGenerar = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		caminoJtext = new javax.swing.JTextField();
		verArbolBtn = new javax.swing.JButton();
		etiqueta = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		PJtext = new javax.swing.JTextField();
		QJtext = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setAutoRequestFocus(false);
		for (javax.swing.JTextField f : iniciales) {
			iniciarField(f);
		}
		for (javax.swing.JTextField f : finales) {
			iniciarField(f);
		}

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(19, 19, 19)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				I1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				I4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I6,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				I7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I8,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I9,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(28, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																I1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																I4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																I7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(28, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGap(19, 19, 19)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				I25,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I26,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I27,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				I22,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I23,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I24,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				I19,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I20,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				I21,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				66,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(28, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGap(18, 18, 18)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																I25,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I26,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I27,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																I22,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I23,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I24,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																I19,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I20,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																I21,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																62,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(28, Short.MAX_VALUE)));

		jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		jLabel1.setText("FUNCIÓN HEURÍSTICA: ");

		opcion.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
		opcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
				"INCORRECTOS", "DIFERENCIA" }));

		jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		jLabel2.setText("F(n) = G(n)  +  ");

		pesoAlpha.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				pesoAlphaKeyTyped(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		jLabel3.setText("H(n)");

		btnGenerar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		btnGenerar.setText("GENERAR");
		btnGenerar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnGenerarActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		jLabel4.setText("P: ");

		jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		jLabel5.setText("Q: ");

		jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		jLabel6.setText("CAMINO: ");

		verArbolBtn.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		verArbolBtn.setText("VER ÁRBOL");
		verArbolBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				verArbolBtnActionPerformed(evt);
			}
		});

		etiqueta.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
		etiqueta.setForeground(new java.awt.Color(255, 0, 0));
		etiqueta.setEnabled(false);

		jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
		jLabel7.setText("PUZZLE");

		jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
		jLabel8.setText("ALGORITMO - BEST FIRST (A) ");

		PJtext.setEditable(false);
		PJtext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PJtextActionPerformed(evt);
			}
		});

		QJtext.setEditable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(59, 59, 59)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		jLabel2)
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(
																																		pesoAlpha))
																												.addComponent(
																														jLabel1))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														opcion,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														155,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														jLabel3)))
																				.addComponent(
																						btnGenerar,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						123,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(48, 48,
																		48)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel6)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										caminoJtext))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		verArbolBtn,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		123,
																																		javax.swing.GroupLayout.PREFERRED_SIZE)
																																.addGap(18,
																																		18,
																																		18)
																																.addComponent(
																																		etiqueta,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		231,
																																		javax.swing.GroupLayout.PREFERRED_SIZE))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGroup(
																																		layout.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																				.addComponent(
																																						jLabel4)
																																				.addComponent(
																																						jLabel5))
																																.addGap(55,
																																		55,
																																		55)
																																.addGroup(
																																		layout.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																				.addComponent(
																																						QJtext,
																																						javax.swing.GroupLayout.PREFERRED_SIZE,
																																						50,
																																						javax.swing.GroupLayout.PREFERRED_SIZE)
																																				.addComponent(
																																						PJtext,
																																						javax.swing.GroupLayout.PREFERRED_SIZE,
																																						50,
																																						javax.swing.GroupLayout.PREFERRED_SIZE))))
																								.addGap(0,
																										9,
																										Short.MAX_VALUE)))
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jPanel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		jPanel2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(58, 58,
																		58))))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(293, 293, 293)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(70, 70,
																		70)
																.addComponent(
																		jLabel7))
												.addComponent(jLabel8))
								.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel7)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel8)
								.addGap(64, 64, 64)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jPanel2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jPanel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(26, 26,
																		26)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						opcion,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						pesoAlpha,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						43,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel3)))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(26,
																										26,
																										26)
																								.addComponent(
																										jLabel4))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										PJtext,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										36,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel5)
																				.addComponent(
																						QJtext,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						36,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						caminoJtext,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						40,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(38, 38,
																		38)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						btnGenerar,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						54,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						verArbolBtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						54,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(49, 49,
																		49)
																.addComponent(
																		etiqueta,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		31,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(109, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void iniciarField(final JTextField I7) {
		I7.setBackground(new java.awt.Color(221, 240, 251));
		I7.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
		I7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		I7.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		I7.setName("I1"); // NOI18N
		java.awt.event.KeyAdapter keyAdapter = null;
		keyAdapter = new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				validar(evt, I7);
			}
		};
		I7.addKeyListener(keyAdapter);

	}

	private void PJtextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_PJtextActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_PJtextActionPerformed

	private void pesoAlphaKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_pesoAlphaKeyTyped
		// TODO add your handling code here:
		char caracter = evt.getKeyChar();

		if (((caracter < '0') || (caracter > '9'))
				&& (caracter != evt.VK_BACK_SPACE) && (caracter != '.')) {

			evt.consume();
		}
	}// GEN-LAST:event_pesoAlphaKeyTyped

	private void verArbolBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_verArbolBtnActionPerformed
		// TODO add your handling code here:
		if (this.arbol.solucion() != null) {
			ArbolPuzzleGraph apg = new ArbolPuzzleGraph(this.arbol);
			// apg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			apg.setSize(1024, 768);
			apg.setVisible(true);
		}
	}// GEN-LAST:event_verArbolBtnActionPerformed

	private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGenerarActionPerformed
		// TODO add your handling code here:
		String cadenaInicial, cadenaSol, camino = "", p, q;
		boolean banderaSol = false;
		int P = 0, Q = 0, opcionL = 0;
		float peso = 1.0f;
		char opc = 'I';

		if (!pesoAlpha.getText().equals("")) {
			peso = Float.parseFloat(pesoAlpha.getText());
		}
		cadenaInicial = getString(iniciales);
		cadenaSol = getString(finales);


		Puzzle pInicial = new Puzzle(cadenaInicial.replaceAll("0", "X"));

		if (opc == 'I') {
			pInicial.heuristicaIncorrecto();
		} else {
			pInicial.heuristicaDifferencia();
		}
		Puzzle pFinal = new Puzzle(cadenaSol.replaceAll("0", "X"));
		pInicial.solucion(pFinal);
		pInicial.factor(peso);
		ArbolGeneradorPuzzle G = new ArbolGeneradorPuzzle();
		G.generarArbol(pInicial, pFinal);

		Puzzle solucionEncontrada = G.solucion();
		String strCamino = G.stringCamino();
		camino = strCamino;
		Q = G.getQ().size();
		P = G.getP().size();
		this.arbol = G;

		if (solucionEncontrada != null) {
			banderaSol = true;
		}

			caminoJtext.setEditable(false);
		if (banderaSol != false) {
			PJtext.setText("" + P);
			QJtext.setText("" + Q);
			caminoJtext.setText(camino);
			verArbolBtn.setEnabled(true);
			etiqueta.setEnabled(false);
			etiqueta.setText("");
		} else {
			etiqueta.setEnabled(true);
			etiqueta.setText("¡No hay solución!");
			caminoJtext.setText("");
			PJtext.setText("" + P);
			QJtext.setText("" + Q);
		}

	}// GEN-LAST:event_btnGenerarActionPerformed

	private static String caracterValidos = "123456780";

	public void validar(KeyEvent evt, JTextField text) {
		String caracter = evt.getKeyChar() + "";

		String cadenaActual = getString(text);
		if (!caracterValidos.contains(caracter)) {
			evt.consume();
			return;
		}
		if (cadenaActual.contains(caracter)) {
			evt.consume();
			return;
		}

		focusSiguiente(text);

	}

	private void focusSiguiente(JTextField text) {
		JTextField sig = siguienteField(text, secuencia);
		if (sig != null) {
			sig.requestFocus();
		}

	}

	private JTextField siguienteField(JTextField text,
			List<JTextField> iniciales2) {
		Iterator<JTextField> it = iniciales2.iterator();
		JTextField s = null;
		while (it.hasNext()) {
			if (it.next().equals(text) && it.hasNext()) {
				s = it.next();
			}
		}
		return s;
	}

	private String getString(JTextField text) {
		String s;
		if (iniciales.contains(text)) {
			s = getString(iniciales);
		} else {
			s = getString(finales);
		}
		return s;
	}

	private String getString(List<JTextField> iniciales2) {
		StringBuilder sb = new StringBuilder();
		for (JTextField f : iniciales2) {
			sb.append(f.getText());
			sb.append(" ");
		}
		return sb.toString().trim();
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
			java.util.logging.Logger.getLogger(GUI_Puzzle.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI_Puzzle.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI_Puzzle.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI_Puzzle.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI_Puzzle().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField I1;
	private javax.swing.JTextField I19;
	private javax.swing.JTextField I2;
	private javax.swing.JTextField I20;
	private javax.swing.JTextField I21;
	private javax.swing.JTextField I22;
	private javax.swing.JTextField I23;
	private javax.swing.JTextField I24;
	private javax.swing.JTextField I25;
	private javax.swing.JTextField I26;
	private javax.swing.JTextField I27;
	private javax.swing.JTextField I3;
	private javax.swing.JTextField I4;
	private javax.swing.JTextField I5;
	private javax.swing.JTextField I6;
	private javax.swing.JTextField I7;
	private javax.swing.JTextField I8;
	private javax.swing.JTextField I9;
	private javax.swing.JTextField PJtext;
	private javax.swing.JTextField QJtext;
	private javax.swing.JButton btnGenerar;
	private javax.swing.JTextField caminoJtext;
	private javax.swing.JLabel etiqueta;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JComboBox<String> opcion;
	private javax.swing.JTextField pesoAlpha;
	private javax.swing.JButton verArbolBtn;
	// End of variables declaration//GEN-END:variables
}