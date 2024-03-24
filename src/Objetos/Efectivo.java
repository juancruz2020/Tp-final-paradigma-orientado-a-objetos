package Objetos;

import java.util.ArrayList;

public class Efectivo extends Ventas {
	public Efectivo(Ventas venta) {
		super();  // Llama al constructor de la clase base (Ventas) para inicializar los atributos de Ventas
		setCodigo(venta.getCodigo());
		setCuotas(venta.getCuotas());
		setMetodoPago(venta.getMetodoPago());
		setValorTotal(venta.getValorTotal());
		setCarritoDeCompras(new ArrayList<>(venta.getCarritoDeCompras()));

		float valor = getValorTotal();

		setValorTotal(valor - (valor * 0.1f));
	}
	public static boolean validar(Ventas venta){
		return true;
	}
}

