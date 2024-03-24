package Objetos;

import javax.swing.*;
import java.util.ArrayList;

public class ArrayProductos extends ArrayListas<Catalogo> {

	private static ArrayProductos instancia;

	private ArrayProductos() {
		// Constructor privado para evitar la creación de instancias desde fuera de la clase
	}
	@Override
	public void Agregar (Catalogo Producto) {
		if (Producto.getCodigo().isEmpty()){
			mensajeError("Ingrese un codigo valido");
		}
		if (!codigoExistente(Producto.getCodigo())){
			array.add(Producto);
			mensajeError("Producto Agregado Exitosamente");
		}else {
			mensajeError("Ese codigo ya esta siendo usado en otro producto");
		}
	}

	public static ArrayProductos getInstancia() {
		if (instancia == null) {
			instancia = new ArrayProductos();
		}
		return instancia;
	}
	@Override
	public void inicializarArray() {
		ArrayList<Catalogo> array = new ArrayList<Catalogo>();
	}
	public void modificar(String codigo_a_modificar, Catalogo nuevo) {
		int indice = -1;
        if (!codigo_a_modificar.isEmpty()) {
	        indice = BuscarPorCodigo(codigo_a_modificar);
			if (indice == -1){
				mensajeError("no se encontro el producto");
			} else if (!((codigo_a_modificar == nuevo.getCodigo()) ^ codigoExistente(nuevo.getCodigo()))) {
				Catalogo modifica = array.get(indice);
				if (nuevo.getCodigo() != null && !nuevo.getCodigo().isEmpty()) {
					modifica.setCodigo(nuevo.getCodigo());
				}
				if (nuevo.getDescripcion() != null && !nuevo.getDescripcion().isEmpty()) {
					modifica.setDescripcion(nuevo.getDescripcion());
				}
				if (nuevo.getPrecio_unitario() != null && !nuevo.getPrecio_unitario().isEmpty()) {
					modifica.setPrecio_unitario(nuevo.getPrecio_unitario());
				}
				if (nuevo.getCantidad_en_stock() != null && !nuevo.getCantidad_en_stock().isEmpty()) {
					modifica.setCantidad_en_stock(nuevo.getCantidad_en_stock());
				}
				if (nuevo.getStock_minimo() != null && !nuevo.getStock_minimo().isEmpty()) {
					modifica.setStock_minimo(nuevo.getStock_minimo());
				}
				array.set(indice, modifica);
			}
			else {
				mensajeError("Codigo nuevo invalido");
			}
        }
		else{
			mensajeError("INGRESE EL CODIGO DEL PRODUCTO A MODIFICAR");
			System.out.print("ERROR: no ingreso el codigo del producto a modificar");
		}
	}

	public void bajar(String codigo_baja){
		if (!codigo_baja.isEmpty()) {
			int indice = BuscarPorCodigo(codigo_baja);
			if (indice == -1){
				mensajeError("no se encontro el producto");
				return;
			}
			array.get(indice).setBaja(!array.get(indice).isBaja());
		}
	}
	public void bajarStock(String codigo_baja,int cantidad){
		if (!codigo_baja.isEmpty()) {
			int indice = BuscarPorCodigo(codigo_baja);
			if (indice == -1){mensajeError("no se encontro el producto");}
			int stock = Integer.parseInt(array.get(indice).getCantidad_en_stock());
			Catalogo producto = get(indice);
			producto.setCantidad_en_stock(Integer.toString(stock-cantidad));
			array.set(indice,producto);
		}
	}
	public int BuscarPorCodigo(String codigo) {
		if (!codigo.isEmpty()) {
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i).getCodigo().equals(codigo)) {
					return i;
				}
			}
		}
		return -1;
	}

	/*public float precio(String codigo_venta_c) {
		if (!codigo_venta_c.isEmpty()) {
			int indice = BuscarPorCodigo(codigo_venta_c);
			return Float.parseFloat(array.get(indice).getPrecio_unitario());
		}
		else {
			return 0f;
		}
	}
	private boolean hayStock(Catalogo producto){
		return Integer.parseInt(producto.getCantidad_en_stock()) > 0;
	}
	private boolean StockMayorAlMinimo(Catalogo producto){
		return Integer.parseInt(producto.getStock_minimo()) > 0;
	}
	*/

	/*
	private boolean aptoCredito(String cantidad_cuotas){
		return (cantidad_cuotas != null && !cantidad_cuotas.isEmpty());
	}
	private boolean cuotasValidas(String cantidad_cuotas){
		return ((Integer.parseInt(cantidad_cuotas)==2) ||
				(Integer.parseInt(cantidad_cuotas)==3) ||
				(Integer.parseInt(cantidad_cuotas)==6));
	}
	*/

	private void mensajeError(String mensaje){
		StringBuilder contenido = new StringBuilder();
		contenido.append(mensaje);
		JOptionPane.showMessageDialog(null, contenido.toString(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
	}

	public void listarMinimos() {
		StringBuilder contenido = new StringBuilder();
		for (int i = 0; i < array.size(); i++) {
			if ((Integer.parseInt(array.get(i).getStock_minimo()) >= (Integer.parseInt(array.get(i).getCantidad_en_stock())))) {
				contenido.append("Codigo: ").append(array.get(i).getCodigo()).append(" ");
				contenido.append("Descripcion: ").append(array.get(i).getDescripcion()).append(" ");
				contenido.append("Precio Unitario: ").append(array.get(i).getPrecio_unitario()).append(" ");
				contenido.append("Cantidad en Stock: ").append(array.get(i).getCantidad_en_stock()).append(" ");
				contenido.append("Stock Minimo: ").append(array.get(i).getStock_minimo()).append(" ");
				contenido.append("Baja: ").append(array.get(i).isBaja()).append("\n").append("\n");
			}
		}
		JOptionPane.showMessageDialog(null, contenido.toString(), "Catalogo minimos", JOptionPane.INFORMATION_MESSAGE);
	}

	public void listar () {
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            contenido.append("Codigo: ").append(array.get(i).getCodigo()).append(" ");
            contenido.append("Descripcion: ").append(array.get(i).getDescripcion()).append(" ");
            contenido.append("Precio Unitario: ").append(array.get(i).getPrecio_unitario()).append(" ");
            contenido.append("Cantidad en Stock: ").append(array.get(i).getCantidad_en_stock()).append(" ");
            contenido.append("Stock Minimo: ").append(array.get(i).getStock_minimo()).append(" ");
            contenido.append("Baja: ").append(array.get(i).isBaja()).append("\n");
        }
        JOptionPane.showMessageDialog(null, contenido.toString(), "Catalogo listado", JOptionPane.INFORMATION_MESSAGE);
    }

	public void bajados() {
		StringBuilder contenido = new StringBuilder();
		for (int i = 0; i < array.size(); i++) {
			if (!array.get(i).isBaja()) {
				contenido.append("Codigo: ").append(array.get(i).getCodigo()).append(" ");
				contenido.append("Descripcion: ").append(array.get(i).getDescripcion()).append(" ");
				contenido.append("Precio Unitario: ").append(array.get(i).getPrecio_unitario()).append(" ");
				contenido.append("Cantidad en Stock: ").append(array.get(i).getCantidad_en_stock()).append(" ");
				contenido.append("Stock Minimo: ").append(array.get(i).getStock_minimo()).append(" ");
				contenido.append("Baja: ").append(array.get(i).isBaja()).append("\n").append("\n");
			}
		}
		JOptionPane.showMessageDialog(null, contenido.toString(), "Catalogo Bajados", JOptionPane.INFORMATION_MESSAGE);
	}

	public void AgregarProductosPredefinidos() {
		String[][] datosProductos = {
				{"001", "Laptop UltraX", "799.99", "15", "5", "true"},
				{"002", "Smartphone SuperTech", "399.99", "30", "10", "true"},
				{"003", "Tablet MegaPad", "249.00", "20", "8", "true"},
				{"004", "Cámara Fotográfica ProShot", "599.95", "10", "3", "true"},
				{"005", "Televisor 4K CrystalView", "899.99", "8", "2", "true"},
				{"006", "Aspiradora TurboClean", "129.99", "25", "6", "true"},
				{"007", "Taladro PowerDrill", "79.99", "40", "10", "true"},
				{"008", "Cereal NutriFlakes", "4.49", "100", "20", "true"},
				{"009", "Muñeca Luna Brillante", "19.99", "50", "5", "true"},
				{"010", "Auriculares SonicWave", "59.95", "15", "4", "true"},
				{"011", "Impresora ColorJet", "199.99", "12", "3", "true"},
				{"012", "Silla ErgoComfort", "79.95", "18", "6", "true"},
				{"013", "Horno MasterChef", "299.00", "7", "2", "true"},
				{"014", "Gafas de Sol SunShield", "49.99", "35", "8", "true"},
				{"015", "Cepillo Dental ProClean", "9.95", "75", "15", "true"},
				{"016", "Mesa de Centro Elegance", "149.99", "10", "4", "true"},
				{"017", "Máquina de Café Barista", "129.99", "20", "5", "true"},
				{"018", "Mochila AdventureX", "59.95", "30", "7", "true"},
				{"019", "Reloj SmartTech", "129.00", "22", "6", "true"},
				{"020", "Bicicleta UrbanRider", "349.99", "15", "4", "true"}
		};

		for (String[] productoData : datosProductos) {
			Catalogo producto = new Catalogo();
			producto.setCodigo(productoData[0]);
			producto.setDescripcion(productoData[1]);
			producto.setPrecio_unitario(productoData[2]);
			producto.setCantidad_en_stock(productoData[3]);
			producto.setStock_minimo(productoData[4]);
			producto.setBaja(Boolean.parseBoolean(productoData[5]));

			array.add(producto);
		}
	}
	private boolean codigoExistente(String CodigoNuevo){
		if (BuscarPorCodigo(CodigoNuevo) == -1) {
			return false;
		}
		return true;
	}

	public Catalogo recuperarProducto(String codigo){
		if (codigo.isEmpty()){
			mensajeError("Ingrese un codigo valido");
			return null;
		}
		int indice = BuscarPorCodigo(codigo);
		if (indice == -1){
			mensajeError("No se encontro el producto");
			return null;
		}
		return array.get(indice);
	}
}
	
