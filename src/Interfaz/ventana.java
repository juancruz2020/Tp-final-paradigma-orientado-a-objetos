package Interfaz;

import Objetos.ArrayProductos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ventana {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();

	// variables singleton //

	private ArrayProductos arrayProductos = ArrayProductos.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void ventanatoda() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana window = new ventana();
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
	public ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECCIONE UNA DE LAS OPCIONES");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel.setBounds(150, 11, 450, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CARGAR");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(129, 100, 130, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MODIFICAR");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(310 , 100, 130, 60);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DAR BAJA");
		btnNewButton_2.setAction(action_2);
		btnNewButton_2.setBounds(490, 100, 130, 60);
		frame.getContentPane().add(btnNewButton_2);
	
		JButton btnNewButton_3 = new JButton("COMPRAR");
		btnNewButton_3.setAction(action_3);
		btnNewButton_3.setBounds(129, 220, 130, 60);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LISTAR");
		btnNewButton_4.setAction(action_4);
		btnNewButton_4.setBounds(310, 220, 130, 60);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("AUTOMATICO");
		btnNewButton_5.setAction(action_5);
		btnNewButton_5.setBounds(490, 220, 130, 60);
		frame.getContentPane().add(btnNewButton_5);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "CARGAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ventana_cargar ventana_car = new ventana_cargar();
			ventana_car.ventana_cargar();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "MODIFICAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ventana_modificar ventana_mod = new ventana_modificar();
			ventana_mod.ventana_modificar();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "DAR BAJA");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ventana_dar_baja ventana_baja = new ventana_dar_baja();
			ventana_baja.ventana_baja();
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "COMPRAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ventana_compra ventana_com = new ventana_compra();
			ventana_com.ventana_compra();
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "LISTAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ventana_listar ventana_lis = new ventana_listar();
			ventana_lis.ventana_lista();
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "AUTOMATICO");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			arrayProductos.AgregarProductosPredefinidos();
		}
	}

}



