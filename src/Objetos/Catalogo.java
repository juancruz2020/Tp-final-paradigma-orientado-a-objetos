package Objetos;

public class Catalogo {
    private String codigo;
    private String descripcion;
    private String precio_unitario;
    private String cantidad_en_stock;
    private String stock_minimo;
	private boolean baja;

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public String getCantidad_en_stock() {
        return cantidad_en_stock;
    }

    public String getStock_minimo() {
        return stock_minimo;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setCantidad_en_stock(String cantidad_en_stock) {
        this.cantidad_en_stock = cantidad_en_stock;
    }

    public void setStock_minimo(String stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
}