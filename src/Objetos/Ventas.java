package Objetos;

import javax.swing.*;
import java.util.ArrayList;

public class Ventas {
    private String codigo;
    private String cuotas;
    private String metodoPago;
    private float valorTotal;
    ArrayList<Carrito> CarritoDeCompras = new ArrayList<Carrito>();

    public void setmetodoPago(String metodoDePago){
        this.metodoPago = metodoDePago;
    }
    // Setter para metodoPago
    public void setCuotas(String cuotas) {
        this.cuotas = cuotas;
    }
    public void agregarProducto(Catalogo Producto,String Cantida){
        if (Cantida.isEmpty()){
            mensajeError("Rellene el campo Cantidad");
            return;
        }
        int Cantidad = Integer.parseInt(Cantida);
        int indice = BuscarPorCodigo(Producto.getCodigo());
        if ( indice != -1){
            Cantidad = CarritoDeCompras.get(indice).getCantidad() + Cantidad;
        }
        if (!Producto.isBaja()) {
            mensajeError("EL PRODUCTO NO ESTA DISPONIBLE");
            return;
        }
        else if (!hayStock(Producto)){
            mensajeError("NO HAY STOCK");
            return;
        }
        else if (Cantidad > Integer.parseInt(Producto.getCantidad_en_stock()) && indice != -1){
            mensajeError("LA CANTIDAD ES MAYOR AL STOCK\n\nEL STOCK ACTUAL ES "+Producto.getCantidad_en_stock()+
                    "\nActualmente el el carrito ya hay: "+CarritoDeCompras.get(indice).getCantidad());
            return;
        }else if (Cantidad > Integer.parseInt(Producto.getCantidad_en_stock()) && indice == -1){
            mensajeError("LA CANTIDAD ES MAYOR AL STOCK\n\nEL STOCK ACTUAL ES "+Producto.getCantidad_en_stock());
            return;
        }
        else if (StockMayorAlMinimo(Producto) && hayStock(Producto) && indice == -1) {
            Carrito nuevoProducto = new Carrito();
            nuevoProducto.setDescripcion(Producto.getDescripcion());
            nuevoProducto.setCodigo(Producto.getCodigo());
            nuevoProducto.setPrecioUnitario(Float.parseFloat(Producto.getPrecio_unitario()));
            nuevoProducto.setCantidad(Cantidad);
            CarritoDeCompras.add(nuevoProducto);
        } else if ((StockMayorAlMinimo(Producto) && hayStock(Producto) && indice != -1)) {
            CarritoDeCompras.get(indice).setCantidad(Cantidad);
        }
        valorTotal = CalcularValorTotal();

    }

    private void mensajeError(String mensaje){
        StringBuilder contenido = new StringBuilder();
        contenido.append(mensaje);
        JOptionPane.showMessageDialog(null, contenido.toString(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean hayStock(Catalogo producto){
        return Integer.parseInt(producto.getCantidad_en_stock()) > 0;
    }
    private boolean StockMayorAlMinimo(Catalogo producto){
        return Integer.parseInt(producto.getStock_minimo()) > 0;
    }

    private float CalcularValorTotal() {
        float valorAcumulado = 0;
        for (Carrito producto : CarritoDeCompras) {
            valorAcumulado += producto.getPrecioUnitario() * producto.getCantidad();
        }
        return valorAcumulado;
    }

    public float getValorTotal(){
        return valorTotal;
    };
    protected void setValorTotal(float nuevoValor){
        this.valorTotal = nuevoValor;
    }

    protected String getCuotas() {
        return cuotas;
    }
    public String getMetodoPago(){
        return metodoPago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigoNuevo) {
        this.codigo = codigoNuevo;
    }

    public void ListarCarrito(){
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < CarritoDeCompras.size(); i++) {
            contenido.append("Codigo: ").append(CarritoDeCompras.get(i).getCodigo()).append(" ");
            contenido.append("Descripcion: ").append(CarritoDeCompras.get(i).getDescripcion()).append(" ");
            contenido.append("Precio Unitario: ").append(CarritoDeCompras.get(i).getPrecioUnitario()).append(" ");
            contenido.append("Cantidad: ").append(CarritoDeCompras.get(i).getCantidad()).append(" ").append("\n");
        }
        JOptionPane.showMessageDialog(null, contenido.toString(), "Catalogo listado", JOptionPane.INFORMATION_MESSAGE);
    }

    public ArrayList<Carrito> getCarrito() {
        return CarritoDeCompras;
    }

    public void printVenta(){
        System.out.println("codigo: "+codigo);
        System.out.println("cuotas: "+cuotas);
        System.out.println("metodoPago: "+metodoPago);
        System.out.println("valorTotal: "+valorTotal);
    }

    public ArrayList<Carrito> getCarritoDeCompras() {
        return CarritoDeCompras;
    }

    public void setCarritoDeCompras(ArrayList<Carrito> carritoDeCompras) {
        CarritoDeCompras = carritoDeCompras;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    public void borrarCarritos(){
        this.codigo = null;
        this.cuotas = null;
        this.metodoPago = null;
        this.valorTotal = 0.0f;
        this.CarritoDeCompras.clear();

    }
    public int BuscarPorCodigo(String codigo) {
        if (!codigo.isEmpty()) {
            for (int i = 0; i < CarritoDeCompras.size(); i++) {
                if (CarritoDeCompras.get(i).getCodigo().equals(codigo)) {
                    return i;
                }
            }
        }
        return -1;
    }

}

