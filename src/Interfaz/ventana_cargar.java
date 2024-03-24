package Interfaz;

import Objetos.ArrayProductos;
import Objetos.Catalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ventana_cargar {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction();

	// variables singleton //
	private ArrayProductos arrayProductos = ArrayProductos.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void ventana_cargar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_cargar window = new ventana_cargar();
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
	public ventana_cargar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(140, 105, 300, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 165, 300, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 225, 300, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(140, 285, 300, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(140, 345, 300, 30);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CODIGO");
		lblNewLabel.setBounds(10, 105, 150, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DESCRIPCION");
		lblNewLabel_1.setBounds(10, 165, 150, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRECIO UNITARIO");
		lblNewLabel_2.setBounds(10, 225, 150, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CANTIDAD EN STOCK");
		lblNewLabel_3.setBounds(10, 285, 150, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("STOCK MINIMO");
		lblNewLabel_4.setBounds(10, 345, 150, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("AGREGAR PRODUCTO");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(240, 5, 270, 70);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.setAction(action_1);
		btnNewButton.setBounds(290, 405, 130, 60);
		frame.getContentPane().add(btnNewButton);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "AGREGAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Catalogo productoNuevo = new Catalogo();

			productoNuevo.setCodigo(textField.getText());
			productoNuevo.setDescripcion(textField_1.getText());
			productoNuevo.setPrecio_unitario(textField_2.getText());
			productoNuevo.setCantidad_en_stock(textField_3.getText());
			productoNuevo.setStock_minimo(textField_4.getText());
			productoNuevo.setBaja(true);

			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");

			arrayProductos.Agregar(productoNuevo);
		}
	}
}
