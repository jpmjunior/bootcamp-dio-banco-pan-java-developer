package edu.jr.pilha;

public class MainPilha {
    public static void main(String[] args) {
        Pilha<String> pilhaString = new Pilha<>("conteudo 1");
        pilhaString.push("conteudo 2");
        pilhaString.push("conteudo 3");
        pilhaString.push("conteudo 4");
        
        System.out.println(pilhaString);
        
        pilhaString.pop();
        System.out.println(pilhaString);
        
        System.out.println("Topo: " + pilhaString.top());
        
        System.out.println("----------------------");
        
        Pilha<Integer> pilhaInt = new Pilha<>(8);
        pilhaInt.push(7);
        pilhaInt.push(6);
        pilhaInt.push(5);
        
        System.out.println(pilhaInt);
        
        pilhaInt.pop();
        pilhaInt.push(99);
        System.out.println(pilhaInt);
        
        System.out.println("Topo: " + pilhaInt.top());

    }
}
