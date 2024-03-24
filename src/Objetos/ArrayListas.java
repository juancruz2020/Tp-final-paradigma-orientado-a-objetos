package Objetos;

import javax.swing.*;
import java.util.ArrayList;

public abstract class ArrayListas<T> {
    protected ArrayList<T> array = new ArrayList();

    public abstract void inicializarArray();

    public void Agregar (T objeto) {
        array.add(objeto);
    }

    public ArrayList<T> getArray(){
        return array;
    }

    public void modificar(T objeto, int indice) {
        array.set(indice,objeto);
    }
    public T get(int indice){
        return array.get(indice);
    }


    public void listar () {
        StringBuilder contenido = new StringBuilder();
        for (T objeto : array) {
            contenido.append(objeto).append("\n");
        }
        JOptionPane.showMessageDialog(null, contenido.toString(), "listado", JOptionPane.INFORMATION_MESSAGE);
    }
}
