package edu.jr.listaDuplamenteEncadeada;

public class MainListaDuplamenteEncadeada {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();

        lista.add("str1");
        lista.add("str2");
        lista.add("str3");
        lista.add("str4");
        
        System.out.println(lista);
        
        lista.add(1,"str1.5");
        System.out.println(lista);
        
        lista.add(0,"str0.5");
        System.out.println(lista);

        System.out.println("Removendo elemento: " + lista.remove(2));
        System.out.println("Removendo elemento: " + lista.remove(0));
        System.out.println(lista);

        int indiceRecuperado = 3;
        System.out.println("Recuperando elemento de índice " + indiceRecuperado + ": " + lista.get(indiceRecuperado));
        
        indiceRecuperado = -1;
        System.out.println("Recuperando elemento de índice " + indiceRecuperado + ": " + lista.get(indiceRecuperado));

        System.out.println("Tamanho da lista: " + lista.size());

        
    }
}
