package edu.jr.listaEncadeada;

public class MainListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        
        lista.add(0, 2);
        lista.add(1, 3);
        lista.add(2, 4);
        lista.add(3, 5);
        
        System.out.println(lista);
        
        lista.add(0, 1);
        lista.add(2, 22);
        System.out.println(lista);
        
        lista.remove(5);
        lista.remove(3);
        lista.remove(0);
        System.out.println(lista);
        
        lista.add(0, 0);
        lista.add(1, 11);
        System.out.println(lista);
        
        lista.add(44);
        lista.add(55);
        System.out.println(lista);

        int indiceRecuperado = 3;
        System.out.println("Recuperando elemento de índice " + indiceRecuperado + ": " + lista.get(indiceRecuperado));
        
        indiceRecuperado = -1;
        System.out.println("Recuperando elemento de índice " + indiceRecuperado + ": " + lista.get(indiceRecuperado));

    }
}
