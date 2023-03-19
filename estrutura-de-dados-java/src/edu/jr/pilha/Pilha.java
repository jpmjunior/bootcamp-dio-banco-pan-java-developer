/**
 * <h1>Classe Pilha</h1>
 * A classe Pilha representa uma estrutura de dados do tipo LIFO (Last In Last Out)
 * 
 * @author Pinheiro Jr.
 * @version 1.0
 * @since 17/03/2023
 */

package edu.jr.pilha;

import edu.jr.util.No;

public class Pilha {
    private No<?> refTopoPilha = null;

    /**
     * Construtor
     * @param refTopoPilha - referência para o nó do topo da pilha
     */
    public Pilha(No<?> refTopoPilha) {
        this.refTopoPilha = refTopoPilha;
    }

    /**
     * Este método retorna o nó do topo da pilha
     * @return refTopoPilha
     */
    public No<?> top () {
        return refTopoPilha;
    }

    /**
     * Este método insere um novo nó na pilha
     * @param novoNo
     */
    public void push (No<?> novoNo) {
        No<?> refNoAuxiliar = refTopoPilha;
        refTopoPilha = novoNo;
        novoNo.setProximoNo(refNoAuxiliar);
    }

    /**
     * Este método remove e retorna o nó do topo da pilha
     * @return NoPoped - nó removido do topo da pilha
     */
    public No<?> pop () {
        if (!isEmpty()) {
            No<?> NoPoped = refTopoPilha;
            refTopoPilha = refTopoPilha.getProximoNo();
            NoPoped.setProximoNo(null);
            return NoPoped;
        }
        return null;
    }

    /**
     * Este método verifica se a pilha está vazia
     * @return <b>true</b> ou <b>false</b>
     */
    public boolean isEmpty () {
        if (refTopoPilha == null) return true;
        return false;
    }

    @Override
    public String toString() {
        String str = "PILHA: \n";
        No<?> refNoAuxiliar = refTopoPilha;
        
        while (refNoAuxiliar != null) {
            str += refNoAuxiliar + " ->\n";
            refNoAuxiliar = refNoAuxiliar.getProximoNo();
        }
        str += "null";
        
        return str;
    }

    
}
