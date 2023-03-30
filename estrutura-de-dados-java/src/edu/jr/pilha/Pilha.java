/**
 * <h1>Classe Pilha</h1>
 * A classe Pilha representa uma estrutura de dados do tipo LIFO (Last In First Out)
 * 
 * @author Pinheiro Jr.
 * @version 1.0
 * @since 17/03/2023
 */

package edu.jr.pilha;

import edu.jr.util.No;

public class Pilha<T> {
    private No<T> refTopoPilha = null;

    /**
     * Construtor
     * @param objetoTopodaPilha - inicializa pilha com objeto passado por parâmetro
     */
    public Pilha(T objetoTopodaPilha) {
        this.refTopoPilha = new No<T>(objetoTopodaPilha);
    }

    /**
     * Este método retorna o elemento do topo da pilha sem removê-lo
     * @return elemento do topo da pilha
     */
    public T top () {
        return refTopoPilha.getConteudo();
    }

    /**
     * Este método insere um novo elemento na pilha
     * @param novoObjeto
     */
    public void push (T novoObjeto) {
        No<T> noAuxiliar = refTopoPilha;
        refTopoPilha = new No<T>(novoObjeto);
        refTopoPilha.setNoPosterior(noAuxiliar);
    }

    /**
     * Este método remove e retorna o elemento do topo da pilha
     * @return NoPoped
     */
    public T pop () {
        if (!isEmpty()) {
            No<T> NoPoped = refTopoPilha;
            refTopoPilha = refTopoPilha.getNoPosterior();
            NoPoped.setNoPosterior(null);
            return NoPoped.getConteudo();
        }
        return null;
    }

    /**
     * Este método verifica se a pilha está vazia
     * @return <b>true</b> ou <b>false</b>
     */
    public boolean isEmpty () {
        return refTopoPilha == null ? true : false;
    }

    @Override
    public String toString() {
        String str = "PILHA: \n";
        No<T> refNoAuxiliar = refTopoPilha;
        
        while (refNoAuxiliar != null) {
            str += refNoAuxiliar + " ->\n";
            refNoAuxiliar = refNoAuxiliar.getNoPosterior();
        }
        
        return str + "null";
    }

    
}
