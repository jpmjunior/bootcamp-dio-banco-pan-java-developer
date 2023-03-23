package edu.jr.fila;

public class MainFila {
    public static void main(String[] args) {
        Fila<String> fila = new Fila<>();
        fila.enqueue("1");
        fila.enqueue("2");
        fila.enqueue("3");
        fila.enqueue("4");
        
        System.out.println(fila);
        
        fila.dequeue();
        System.out.println(fila);
        
        fila.dequeue();
        fila.dequeue();
        fila.dequeue();
        System.out.println(fila);
        
        fila.enqueue("1");
        fila.enqueue("2");
        fila.enqueue("3");
        fila.enqueue("4");
        fila.enqueue("5");
        System.out.println(fila);

        System.out.println("--------------------");

        Fila<Integer> filaInt = new Fila<>();
        filaInt.enqueue(10);
        filaInt.enqueue(20);
        filaInt.enqueue(30);
        filaInt.enqueue(40);

        System.out.println(filaInt);

    }
}
