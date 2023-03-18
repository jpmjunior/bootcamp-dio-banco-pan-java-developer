package edu.jr.pilha;

import edu.jr.util.No;

public class MainPilha {
    public static void main(String[] args) {
        Pilha pilhaString = new Pilha(new No<String>("conteudo 1"));
        pilhaString.push(new No<String>("conteudo 2"));
        pilhaString.push(new No<String>("conteudo 3"));
        pilhaString.push(new No<String>("conteudo 4"));
        
        System.out.println(pilhaString);
        
        pilhaString.pop();
        System.out.println(pilhaString);
        System.out.println("Topo: " + pilhaString.top());
        
        System.out.println("----------------------");
        
        Pilha pilhaInt = new Pilha(new No<Integer>(8));
        pilhaInt.push(new No<Integer>(7));
        pilhaInt.push(new No<Integer>(6));
        pilhaInt.push(new No<Integer>(5));
        
        System.out.println(pilhaInt);
        
        pilhaInt.pop();
        pilhaInt.push(new No<Integer>(99));
        System.out.println(pilhaInt);
        System.out.println("Topo: " + pilhaInt.top());

    }
}
