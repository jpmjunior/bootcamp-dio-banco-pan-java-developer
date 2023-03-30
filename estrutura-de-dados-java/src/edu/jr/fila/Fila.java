/**
 * <h1>Classe Fila</h1>
 * A classe Fila representa uma estrutura de dados do tipo FIFO (Fist In First Out)
 * 
 * @author Pinheiro Jr.
 * @version 1.0
 * @since 23/03/2023
 */

package edu.jr.fila;

import edu.jr.util.No;

public class Fila<T> {
    private No<T> refFinalDaFila = null;
    
    /**
     * Construtor vazio
     */
    public Fila() {}
    
    /**
     * Construtor
     * @param primeiroObjetoDaFila - inicializa a fila com o objeto passado por parâmetro
     */
    public Fila(T primeiroObjetoDaFila) {
        this.refFinalDaFila = new No<T>(primeiroObjetoDaFila);
    }

    /**
     * Este método adiciona um novo elemento no final da fila
     * @param novoObjeto
     */
    public void enqueue (T novoObjeto) {
        No<T> novoNo = new No<>(novoObjeto);
        if (!isEmpty()) {
            No<T> noAuxiliar = refFinalDaFila;
            refFinalDaFila = new No<T>(novoObjeto);
            refFinalDaFila.setNoPosterior(noAuxiliar);
        } else {
            refFinalDaFila = novoNo;
        }
    }

    /**
     * Este método remove e retorna o primeiro elemento da fila
     * @return noDequeued
     */
    public T dequeue() {
        if (!isEmpty()) {
            
            if (refFinalDaFila.getNoPosterior() != null) {
                
                No<T> noAuxiliar = refFinalDaFila;

                if (noAuxiliar.getNoPosterior().getNoPosterior() != null) {
                    
                    while (noAuxiliar.getNoPosterior().getNoPosterior() != null) {
                        noAuxiliar = noAuxiliar.getNoPosterior();
                    }
                    
                }
                
                No<T> noDequeued = noAuxiliar.getNoPosterior();
                noAuxiliar.setNoPosterior(null);
                return noDequeued.getConteudo();
                
            }
            
            No<T> noDequeued = refFinalDaFila;
            refFinalDaFila = null;
            return noDequeued.getConteudo();
            
        }

        return null;

    }

    /**
     * Este método retorna o primeiro elemento da fila sem removê-lo
     * @return
     */
    public T first() {
        if (!isEmpty()) {
            
            No<T> noAuxiliar = refFinalDaFila;
            
            while (noAuxiliar.getNoPosterior() != null) {
                
                noAuxiliar = noAuxiliar.getNoPosterior();
            
            }

            return noAuxiliar.getConteudo();
        
        } else {
            
            return null;
        
        }
    }

    /**
     * Este método verifica se a fila está vazia
     * @return <b>true</b> ou <b>false</b>
     */
    public boolean isEmpty() {
        return refFinalDaFila == null ? true : false;
    }

    @Override
    public String toString() {
        
        String str = "Fila: ";

        if (refFinalDaFila != null) {
            
            No<T> noAuxiliar = refFinalDaFila;
            
            while (noAuxiliar != null) {
                str += noAuxiliar + " -> ";
                noAuxiliar = noAuxiliar.getNoPosterior();
            }

            return str + "null";

        } else {
            return str + "null";
        }
    }

}
