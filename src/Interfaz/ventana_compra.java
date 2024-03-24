package Interfaz;

import Objetos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ventana_compra {

	private JFrame frame;
	private JTextField textField;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private JTextField textField_1;
	private Ventas venta;

	// variables singleton //
	private ArrayProductos arrayProductos = ArrayProductos.getInstancia();
	private ArrayVentas Aventa = ArrayVentas.getInstancia();
	private JTextField textField_2;

	public static void ventana_compra() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_compra window = new ventana_compra();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ventana_compra() {
		venta = new Ventas();
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 470, 449);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JLabel lblNewLabel = new JLabel("CODIGO VENDIDO");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel.setBounds(125, 30, 222, 32);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(135, 73, 300, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CARGAR VENTA");
		lblNewLabel_1.setBounds(10, 73, 130, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("CREDITO");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(10, 338, 130, 60);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("DEBITO");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(160, 338, 130, 60);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("EFECTIVO");
		btnNewButton_2.setAction(action_2);
		btnNewButton_2.setBounds(310, 338, 130, 60);
		frame.getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel_2 = new JLabel("CONFIRMAR METODO DE PAGO");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(26, 239, 378, 47);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_3 = new JButton("AGREGAR");
		btnNewButton_3.setAction(action_3);
		btnNewButton_3.setBounds(80, 168, 130, 60);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("VER CARRITO");
		btnNewButton_4.setAction(action_4);
		btnNewButton_4.setBounds(260, 168, 130, 60);
		frame.getContentPane().add(btnNewButton_4);

		JLabel lblNewLabel_1_1 = new JLabel("CANTIDAD");
		lblNewLabel_1_1.setBounds(10, 114, 130, 30);
		frame.getContentPane().add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 114, 300, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 285, 300, 30);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CUOTAS CON CREDITO");
		lblNewLabel_1_1_1.setBounds(10, 285, 130, 30);
		frame.getContentPane().add(lblNewLabel_1_1_1);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "CREDITO");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			venta.setCuotas(textField_2.getText());
			venta.setmetodoPago("Credito");
			if (Aventa.AgregarCredito(venta)) {
				for (Carrito Carro : venta.getCarrito())
					arrayProductos.bajarStock(Carro.getCodigo(), Carro.getCantidad());
				venta.borrarCarritos();
				textField_2.setText("");
			}
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "DEBITO");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			venta.setCuotas(textField_2.getText());
			venta.setmetodoPago("Debito");
			if (Aventa.AgregarDebito(venta)) {
				for (Carrito Carro : venta.getCarrito())
					arrayProductos.bajarStock(Carro.getCodigo(), Carro.getCantidad());
				venta.borrarCarritos();
				textField_2.setText("");
			}
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "EFECTIVO");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			venta.setCuotas(textField_2.getText());
			venta.setmetodoPago("Efectivo");
			if (Aventa.AgregarEfectivo(venta)) {
				for (Carrito Carro : venta.getCarrito())
					arrayProductos.bajarStock(Carro.getCodigo(), Carro.getCantidad());
				venta.borrarCarritos();
				textField_2.setText("");
			}
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "AGREGAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String Codigo = textField.getText();
			String Cantidad = textField_1.getText();
			Catalogo producto = arrayProductos.recuperarProducto(Codigo);
			venta.agregarProducto(producto, Cantidad);
			textField.setText("");
			textField_1.setText("");
		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "VER CARRITO");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println(venta);
			venta.ListarCarrito();
		}
	}
}
