package edu.jr.listaDuplamenteEncadeada;

import edu.jr.util.NoDuplo;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> refInicioDaLista = null;
    private NoDuplo<T> refFinalDaLista = null;
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
        
        NoDuplo<T> noAtual = refInicioDaLista;
        
        for (int i = 0; i < indice; i++) {
            noAtual = noAtual.getNoPosterior();
        }
        
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        NoDuplo<T> noAnterior = noAtual.getNoAnterior();
        
        if (noAnterior != null) {
            noAnterior.setNoPosterior(novoNo);
            novoNo.setNoAnterior(noAnterior);
            novoNo.setNoPosterior(noAtual);
            noAtual.setNoAnterior(novoNo);
        } else {
            novoNo.setNoPosterior(refInicioDaLista);
            refInicioDaLista.setNoAnterior(novoNo);
            refInicioDaLista = novoNo;
        }

    }
    
    /**
     * Método privado que insere um elemento no final da lista
     * @param elemento
     */
    private void addNoFinal(T elemento) {
        
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        
        if (!isEmpty()) {
            refFinalDaLista.setNoPosterior(novoNo);
            novoNo.setNoAnterior(refFinalDaLista);
            refFinalDaLista = novoNo;
        } else {
            refInicioDaLista = novoNo;
            refFinalDaLista = novoNo;
        }

    }

    /**
     * Este método remove um elemento da lista conforme índice informado e retorna o elemento removido em caso de sucesso 
     * ou null em caso de falha
     * @param indice
     * @return
     */
    public T remove(int indice) {
        
        if (indice < 0 || indice > tamanhoDaLista - 1) return null;

        NoDuplo<T> noAtual = refInicioDaLista;
        
        for (int i = 0; i < indice; i++) {
            noAtual = noAtual.getNoPosterior();
        }
        
        NoDuplo<T> noAnterior = noAtual.getNoAnterior();
        NoDuplo<T> noPosterior = noAtual.getNoPosterior();
        
        if (noAnterior != null) {
            noAnterior.setNoPosterior(noPosterior);
            noPosterior.setNoAnterior(noAnterior);
        } else {
            refInicioDaLista = refInicioDaLista.getNoPosterior();
            refInicioDaLista.setNoAnterior(null);
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

        NoDuplo<T> noAuxiliar = refInicioDaLista;

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
            
            NoDuplo<T> noAuxiliar = refInicioDaLista;
            
            while (noAuxiliar != null) {
                str += noAuxiliar + " <-> ";
                noAuxiliar = noAuxiliar.getNoPosterior();
            }

            str += "null";
            return str;

        } else {
            return "null";
        }
    }

}
