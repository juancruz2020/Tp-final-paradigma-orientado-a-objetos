package Interfaz;

import Objetos.ArrayProductos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ventana_dar_baja {

	private JFrame frame;
	private final JTextField textField = new JTextField();
	private final Action action = new SwingAction();
	// variables singleton //
	private ArrayProductos arrayProductos = ArrayProductos.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void ventana_baja() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_dar_baja window = new ventana_dar_baja();
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
	public ventana_dar_baja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 259);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textField.setBounds(160, 60, 172, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("DAR BAJA");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel.setBounds(160, 11, 129, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SELECCIONAR CODIGO");
		lblNewLabel_1.setBounds(10, 60, 150, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(160, 130, 130, 60);
		frame.getContentPane().add(btnNewButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "DAR BAJA");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			arrayProductos.bajar(textField.getText());
		}
	}
}