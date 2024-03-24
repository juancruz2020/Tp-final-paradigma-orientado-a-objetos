package Interfaz;

import Objetos.ArrayProductos;
import Objetos.ArrayVentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ventana_listar {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	// variables singleton //
	private ArrayProductos arrayProductos = ArrayProductos.getInstancia();
	private ArrayVentas Ventas = ArrayVentas.getInstancia();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void ventana_lista() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_listar window = new ventana_listar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventana_listar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 125);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("TODOS");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(10, 15, 130, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BAJADOS");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(150, 15, 130, 60);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("MINIMOS");
		btnNewButton_1_1.setAction(action_2);
		btnNewButton_1_1.setBounds(290, 15, 130, 60);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("MINIMOS");
		btnNewButton_1_1_1.setAction(action_3);
		btnNewButton_1_1_1.setBounds(430, 15, 130, 60);
		frame.getContentPane().add(btnNewButton_1_1_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "TODOS");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			arrayProductos.listar();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "BAJADOS");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			arrayProductos.bajados();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "MINIMOS");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			arrayProductos.listarMinimos();
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "VENTAS");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Ventas.listar();
		}
	}
}
