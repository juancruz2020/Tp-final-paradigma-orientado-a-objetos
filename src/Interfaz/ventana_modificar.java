package Interfaz;

import Objetos.ArrayProductos;
import Objetos.Catalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ventana_modificar {

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
	// variables singleton //

	private ArrayProductos arrayProductos = ArrayProductos.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void ventana_modificar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_modificar window = new ventana_modificar();
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
	public ventana_modificar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 600);
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
		
		textField_5 = new JTextField();
		textField_5.setBounds(140, 405, 300, 30);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("CODIGO A MODIFICAR");
		lblNewLabel.setBounds(10, 105, 150, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO");
		lblNewLabel_1.setBounds(10, 165, 150, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DESCRIPCION");
		lblNewLabel_2.setBounds(10, 225, 150, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRECIO UNITARIO");
		lblNewLabel_3.setBounds(10, 285, 150, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CANTIDAD EN STOCK");
		lblNewLabel_4.setBounds(10, 345, 150, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("STOCK MINIMO");
		lblNewLabel_5.setBounds(10, 405, 150, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("MODIFICAR PRODUCTO");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(240, 5, 333, 70);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(290, 465, 130, 60);
		frame.getContentPane().add(btnNewButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "MODIFICAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ModificarProducto();
		}
	}

	private void ModificarProducto(){
		Catalogo productoModificado = new Catalogo();

		productoModificado.setCodigo(textField_1.getText());
		productoModificado.setDescripcion(textField_2.getText());
		productoModificado.setPrecio_unitario(textField_3.getText());
		productoModificado.setCantidad_en_stock(textField_4.getText());
		productoModificado.setStock_minimo(textField_5.getText());
		productoModificado.setBaja(true);

		arrayProductos.modificar(textField.getText() ,productoModificado);
	}
}
