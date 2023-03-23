package edu.jr.fila;

import edu.jr.util.No;

public class MainFila {
    public static void main(String[] args) {
        Fila fila = new Fila(null);
        fila.enqueue(new No<String>("1"));
        fila.enqueue(new No<String>("2"));
        fila.enqueue(new No<String>("3"));
        fila.enqueue(new No<String>("4"));
        
        System.out.println(fila);
        
        fila.dequeue();
        System.out.println(fila);
        
        fila.dequeue();
        fila.dequeue();
        fila.dequeue();
        System.out.println(fila);
        
        fila.enqueue(new No<String>("1"));
        fila.enqueue(new No<String>("2"));
        fila.enqueue(new No<String>("3"));
        fila.enqueue(new No<String>("4"));
        fila.enqueue(new No<Integer>(5));
        System.out.println(fila);

    }
}
