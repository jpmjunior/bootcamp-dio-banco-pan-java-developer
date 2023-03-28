package edu.jr.listaEncadeada;

import edu.jr.util.No;

public class ListaEncadeada<T> {
    private No<T> refInicioDaLista = null;
    private int tamanhoDaLista = 0;

    public boolean add(T elemento) {
        return add(tamanhoDaLista, elemento);
    }
    
    public boolean add(int indice, T elemento) {
        
        if (indice < 0 || indice > tamanhoDaLista) return false;
        
        if (indice == tamanhoDaLista) addNoFinal(elemento);
        else addNoMeio(indice, elemento);
        
        tamanhoDaLista++;
        return true;
    }
    
    private void addNoMeio(int indice, T elemento) {
        
        No<T> noAnterior = null;
        No<T> noAtual = refInicioDaLista;
        
        for (int i = 0; i < indice; i++) {
            noAnterior = noAtual;
            noAtual = noAtual.getProximoNo();
        }
        
        No<T> novoNo = new No<>(elemento);
        if (noAnterior != null) {
            noAnterior.setProximoNo(novoNo);
            novoNo.setProximoNo(noAtual);
        } else {
            refInicioDaLista = novoNo;
            refInicioDaLista.setProximoNo(noAtual);
        }

    }
    
    private void addNoFinal(T elemento) {
        
        if (isEmpty()) refInicioDaLista = new No<T>(elemento);
        
        else {
            No<T> noAuxiliar = refInicioDaLista;
            
            for (int i = 0; i < tamanhoDaLista - 1; i++) {
                noAuxiliar = noAuxiliar.getProximoNo();
            }
            
            noAuxiliar.setProximoNo(new No<T>(elemento));
        }

    }

    public boolean remove(int indice) {
        
        if (indice < 0 || indice > tamanhoDaLista - 1) return false;

        No<T> noAnterior = null;
        No<T> noAtual = refInicioDaLista;
        
        for (int i = 0; i < indice; i++) {
            noAnterior = noAtual;
            noAtual = noAtual.getProximoNo();
        }

        if (noAnterior != null) {
            noAnterior.setProximoNo(noAtual.getProximoNo());
        } else {
            refInicioDaLista = refInicioDaLista.getProximoNo();
        }
        
        tamanhoDaLista--;
        return true;
    
    }
    
    public T get(int indice) {
        
        if (indice < 0 || indice > tamanhoDaLista - 1) {
            System.out.println("Índice inválido.");
            return null;
        }

        No<T> noAuxiliar = refInicioDaLista;

        for (int i = 0; i < indice; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar.getConteudo();
    
    }
    
    public boolean isEmpty() {
        return refInicioDaLista == null ? true : false;
    }

    @Override
    public String toString() {
        
        if (refInicioDaLista != null) {
            String str = "Lista: ";
            
            No<T> noAuxiliar = refInicioDaLista;
            
            while (noAuxiliar != null) {
                str += noAuxiliar + " -> ";
                noAuxiliar = noAuxiliar.getProximoNo();
            }

            str += "null";
            return str;

        } else {
            return "null";
        }
    }
}
