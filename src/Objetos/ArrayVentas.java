package Objetos;

import javax.swing.*;
import java.util.ArrayList;

public class ArrayVentas extends ArrayListas<Ventas> {

    private static ArrayVentas instancia;

    private ArrayVentas() {
        // Constructor privado para evitar la creación de instancias desde fuera de la clase
    }


    public static ArrayVentas getInstancia() {
        if (instancia == null) {
            instancia = new ArrayVentas();
        }
        return instancia;
    }

    @Override
    public void inicializarArray() {
        ArrayList<Ventas> array = new ArrayList<Ventas>();
    }
    public boolean AgregarCredito (Ventas venta) {
        if (Credito.validar(venta)){
            agregarCodigoA(venta);
            Credito credito =  new Credito(venta);
            array.add(credito);
            return true;
        }
        else {
            mensajeError("RELLENE CON UNA CUTOA VALIDA (2; 3; 6)");
            return false;
        }
    }

    private void agregarCodigoA(Ventas venta) {
        String codigoNuevo;
        if (!array.isEmpty()) {
            int ultimoCodigo = Integer.parseInt(array.get(array.size() - 1).getCodigo());
            codigoNuevo = String.valueOf(ultimoCodigo + 1);
        }else{
            codigoNuevo = "0";
        }
        venta.setCodigo(codigoNuevo);
    }

    public boolean AgregarDebito (Ventas venta) {
        if (!venta.getCuotas().isEmpty()){
            mensajeError("Debito no recive Cuotas, deje el campo vacio");
            return false;
        }
        else if (Debito.validar(venta)){
            agregarCodigoA(venta);
            array.add(new Debito(venta));
            return true;
        }
        else {
            mensajeError("TODOS LOS CAMPOS SON OBLIGATORIOS");
            return false;
        }
    }
    public boolean AgregarEfectivo (Ventas venta) {
        if (!venta.getCuotas().isEmpty()){
            mensajeError("Efectivo no recive Cuotas, deje el campo vacio");
            return false;
        }
        else if (Efectivo.validar(venta)){
            agregarCodigoA(venta);
            array.add(new Efectivo(venta));
            return true;
        }
        else {
            mensajeError("TODOS LOS CAMPOS SON OBLIGATORIOS");
            return false;
        }
    }

    private void mensajeError(String mensaje){
        StringBuilder contenido = new StringBuilder();
        contenido.append(mensaje);
        JOptionPane.showMessageDialog(null, contenido.toString(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }



    public void listar() {
        StringBuilder contenido = new StringBuilder();
        for (Ventas venta : array) {
            System.out.println(venta.getValorTotal());
            contenido.append("La compra se hizo con: ").append(venta.getMetodoPago());
            contenido.append(" precio: "+venta.getValorTotal()).append(" cuotas: "+venta.getCuotas()).append("\n");
            contenido.append("Esta compra incluye los siguientes productos:\n");
            for (Carrito producto : venta.getCarritoDeCompras()) {
                contenido.append("Codigo: ").append(producto.getCodigo()).append(" ");
                contenido.append("Descripcion: ").append(producto.getDescripcion()).append(" ");
                contenido.append("cantidad: ").append(producto.getCantidad()).append(" ");
                contenido.append("Precio Unitario: ").append(producto.getPrecioUnitario()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, contenido.toString(), "Ventas listado", JOptionPane.INFORMATION_MESSAGE);
    }


}
