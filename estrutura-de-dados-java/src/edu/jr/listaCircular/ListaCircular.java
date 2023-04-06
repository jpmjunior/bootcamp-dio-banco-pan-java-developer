package edu.jr.listaCircular;

import edu.jr.util.No;

public class ListaCircular<T> {
    private No<T> refNoCalda = null;
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
        
        No<T> novoNo = new No<>(elemento);
        
        if (indice >= 1) {
            
            No<T> noAnterior = getNo(indice - 1);
            No<T> noAtual = noAnterior.getNoPosterior();

            noAnterior.setNoPosterior(novoNo);
            novoNo.setNoPosterior(noAtual);

        } else {
            
            No<T> noCabeca = getNo(size() - 1);
            
            novoNo.setNoPosterior(refNoCalda);
            noCabeca.setNoPosterior(novoNo);
            refNoCalda = novoNo;
            
        }

     }
    
    /**
     * Método privado que insere um elemento no final da lista
     * @param elemento
     */
    private void addNoFinal(T elemento) {

        No<T> novoNo = new No<>(elemento);
        
        if (!isEmpty()) {
            
            No<T> noAuxiliar = getNo(size() - 1);
            
            noAuxiliar.setNoPosterior(novoNo);
            novoNo.setNoPosterior(refNoCalda);
            
        }
        
        else {
            
            refNoCalda = novoNo;
            novoNo.setNoPosterior(refNoCalda);

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
        
        No<T> noRemovido = null;

        if (indice != 0) {
            
            No<T> noAnterior = getNo(indice - 1);
            noRemovido = noAnterior.getNoPosterior();
            noAnterior.setNoPosterior(noRemovido.getNoPosterior());

        } else {

            No<T> noCabeca = getNo(size() - 1);
            noRemovido = refNoCalda;
            refNoCalda = refNoCalda.getNoPosterior();
            noCabeca.setNoPosterior(refNoCalda);

        }

        tamanhoDaLista--;
        return noRemovido.getConteudo();

    }
    
    /**
     * Este método retorna um elemento da lista sem removê-lo, conforme índice informado
     * @param indice
     * @return
     */
    public T get(int indice) {
        
        if (indice < 0 || indice > tamanhoDaLista - 1) return null;

        No<T> noAuxiliar = getNo(indice);
        return noAuxiliar.getConteudo();
    
    }

    public T getNoPosterior(int indice) {

        if (indice < 0 || indice > tamanhoDaLista - 1) return null;

        No<T> noAuxiliar = getNo(indice);
        return noAuxiliar.getNoPosterior().getConteudo();
    }

    /**
     * Método privado que retorna um nó da lista conforme índice informado
     * @param indice
     * @return
     */
    private No<T> getNo(int indice) {

        No<T> noAtual = refNoCalda;
        
        for (int i = 0; i < indice; i++) {
            noAtual = noAtual.getNoPosterior();
        }

        return noAtual;
    }

    /**
     * Retorna conteúdo do nó cauda
     * @return
     */
    public T getCauda() {
        return refNoCalda.getConteudo();
    }

    /**
     * Retorna conteúdo no nó cabeça
     * @return
     */
    public T getCabeca() {
        return getNo(size() - 1).getConteudo();
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
        return refNoCalda == null ? true : false;
    }

    @Override
    public String toString() {
        
        String str = "Lista: ";

        if (refNoCalda != null) {
            
            No<T> noAuxiliar = refNoCalda;
            
            for (int i = 0; i < size(); i++) {
                str += noAuxiliar + " -> ";
                noAuxiliar = noAuxiliar.getNoPosterior();
            }

            return str;

        } else {
            return str + "null";
        }
    }


}
