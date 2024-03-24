package Objetos;

import java.util.ArrayList;

public class Credito extends Ventas {
	public Credito(Ventas venta) {
		super();  // Llama al constructor de la clase base (Ventas) para inicializar los atributos de Ventas
		setCodigo(venta.getCodigo());
		setCuotas(venta.getCuotas());
		setMetodoPago(venta.getMetodoPago());
		setValorTotal(venta.getValorTotal());
		setCarritoDeCompras(new ArrayList<>(venta.getCarritoDeCompras()));

		float valor = getValorTotal();
		int cuotas = Integer.parseInt(getCuotas());

		if (cuotas == 2) {
			setValorTotal(valor + (valor * 0.6f));
		} else if (cuotas == 3) {
			setValorTotal(valor + (valor * 0.12f));
		} else if (cuotas == 6) {
			setValorTotal(valor + (valor * 0.2f));
		} else {
			setValorTotal(valor);
		}
	}
	public static boolean validar(Ventas venta) {
		if (!venta.getCuotas().isEmpty()) {
			try {
				int cuotas = Integer.parseInt(venta.getCuotas());
				return cuotas == 2 || cuotas == 3 || cuotas == 6;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}
}
