package edu.jr.pilha;

import edu.jr.util.No;

public class Pilha {
    private No<?> refTopoPilha = null;

    public Pilha(No<?> refTopoPilha) {
        this.refTopoPilha = refTopoPilha;
    }

    public No<?> getRefTopoPilha() {
        return refTopoPilha;
    }
    
    public No<?> top () {
        return refTopoPilha;
    }

    public void push (No<?> novoNo) {
        No<?> refNoAuxiliar = refTopoPilha;
        refTopoPilha = novoNo;
        novoNo.setProximoNo(refNoAuxiliar);
    }

    public No<?> pop () {
        if (!isEmpty()) {
            No<?> NoPoped = refTopoPilha;
            refTopoPilha = refTopoPilha.getProximoNo();
            NoPoped.setProximoNo(null);
            return NoPoped;
        }
        return null;
    }

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
