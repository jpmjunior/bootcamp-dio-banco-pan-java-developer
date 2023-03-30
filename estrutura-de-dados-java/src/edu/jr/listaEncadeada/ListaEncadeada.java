/**
 * <h1>Classe ListaEncadeada</h1>
 * A classe ListaEncadeada representa uma estrutura de dados do tipo lista, onde inserções podem ocorrer
 * em qualquer posição ou índice.
 * 
 * @author Pinheiro Jr.
 * @version 1.0
 * @since 28/03/2023
 */

package edu.jr.listaEncadeada;

import edu.jr.util.No;

public class ListaEncadeada<T> {
    private No<T> refInicioDaLista = null;
    private int tamanhoDaLista = 0;

    /**
     * Este método adiciona um elemento no final da lista e retorna <b>true</b> em caso de sucesso ou 
     * <b>false</b> em caso de falha
     * @param elemento
     * @return <b>true</b> ou <b>false</b>
     */
    public boolean add(T elemento) {
        return add(tamanhoDaLista, elemento);
    }
    
    /**
     * Este método adiciona um elemento na lista conforme índice recebido por parâmetro e retorna 
     * <b>true</b> em caso de sucesso ou <b>false</b> em caso de falha
     * @param indice
     * @param elemento
     * @return <b>true</b> ou <b>false</b>
     */
    public boolean add(int indice, T elemento) {
        
        if (indice < 0 || indice > tamanhoDaLista) return false;
        
        if (indice == tamanhoDaLista) addNoFinal(elemento);
        else addNoMeio(indice, elemento);
        
        tamanhoDaLista++;
        return true;
    }
    
    /**
     * Método privado que insere um elemento no meio da lista
     * @param indice
     * @param elemento
     */
    private void addNoMeio(int indice, T elemento) {
        
        No<T> noAnterior = null;
        No<T> noAtual = refInicioDaLista;
        
        for (int i = 0; i < indice; i++) {
            noAnterior = noAtual;
            noAtual = noAtual.getNoPosterior();
        }
        
        No<T> novoNo = new No<>(elemento);
        if (noAnterior != null) {
            noAnterior.setNoPosterior(novoNo);
            novoNo.setNoPosterior(noAtual);
        } else {
            refInicioDaLista = novoNo;
            refInicioDaLista.setNoPosterior(noAtual);
        }

    }
    
    /**
     * Método privado que insere um elemento no final da lista
     * @param elemento
     */
    private void addNoFinal(T elemento) {
        
        if (isEmpty()) refInicioDaLista = new No<T>(elemento);
        
        else {
            No<T> noAuxiliar = refInicioDaLista;
            
            for (int i = 0; i < tamanhoDaLista - 1; i++) {
                noAuxiliar = noAuxiliar.getNoPosterior();
            }
            
            noAuxiliar.setNoPosterior(new No<T>(elemento));
        }

    }

    /**
     * Este método um elemento da lista conforme índice informado e retorna o elemento removido em caso de sucesso 
     * ou null em caso de falha
     * @param indice
     * @return
     */
    public T remove(int indice) {
        
        if (indice < 0 || indice > tamanhoDaLista - 1) return null;

        No<T> noAnterior = null;
        No<T> noAtual = refInicioDaLista;
        
        for (int i = 0; i < indice; i++) {
            noAnterior = noAtual;
            noAtual = noAtual.getNoPosterior();
        }

        if (noAnterior != null) {
            noAnterior.setNoPosterior(noAtual.getNoPosterior());
        } else {
            refInicioDaLista = refInicioDaLista.getNoPosterior();
        }
        
        tamanhoDaLista--;
        return noAtual.getConteudo();
    
    }
    
    /**
     * Este método retorna um elemento da lista sem removê-lo, conforme índice informado
     * @param indice
     * @return
     */
    public T get(int indice) {
        
        if (indice < 0 || indice > tamanhoDaLista - 1) return null;

        No<T> noAuxiliar = refInicioDaLista;

        for (int i = 0; i < indice; i++) {
            noAuxiliar = noAuxiliar.getNoPosterior();
        }

        return noAuxiliar.getConteudo();
    
    }
    
    /**
     * Retorna quantidade de elementos da lista
     * @return
     */
    public int size() {
        return tamanhoDaLista;
    }

    /**
     * Este método verifica se a lista está vazia
     * @return <b>true</b> ou <b>false</b>
     */
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
                noAuxiliar = noAuxiliar.getNoPosterior();
            }

            str += "null";
            return str;

        } else {
            return "null";
        }
    }
}
