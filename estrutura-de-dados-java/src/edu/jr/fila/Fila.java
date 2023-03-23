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

public class Fila {
    private No<?> refFinalDaFila = null;
    
    /**
     * Construtor
     * @param refFinalDaFila - referência para o nó final da fila
     */
    public Fila(No<?> refFinalDaFila) {
        this.refFinalDaFila = refFinalDaFila;
    }

    /**
     * Este método adiciona um novo nó no final da fila
     * @param novoNo
     */
    public void enqueue (No<?> novoNo) {
        if (refFinalDaFila != null) {
            No<?> noAuxiliar = refFinalDaFila;
            refFinalDaFila = novoNo;
            refFinalDaFila.setProximoNo(noAuxiliar);
        } else {
            refFinalDaFila = novoNo;
        }
    }

    public No<?> dequeue() {
        if (refFinalDaFila != null) {
            
            if (refFinalDaFila.getProximoNo() != null) {
                
                No<?> noAuxiliar = refFinalDaFila;

                if (noAuxiliar.getProximoNo().getProximoNo() != null) {
                    
                    while (noAuxiliar.getProximoNo().getProximoNo() != null) {
                        noAuxiliar = noAuxiliar.getProximoNo();
                    }
                    
                }
                
                No<?> noDequeued = noAuxiliar.getProximoNo();
                noAuxiliar.setProximoNo(null);
                return noDequeued;
                
            }
            
            No<?> noDequeued = refFinalDaFila;
            refFinalDaFila = null;
            return noDequeued;
            
        }

        return null;

    }

    public boolean isEmpty() {
        return refFinalDaFila == null ? true : false;
    }

    @Override
    public String toString() {
        
        if (refFinalDaFila != null) {
            String str = "Fila: ";
            
            No<?> noAuxiliar = refFinalDaFila;
            
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
