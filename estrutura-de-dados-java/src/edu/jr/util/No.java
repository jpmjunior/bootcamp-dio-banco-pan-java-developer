/**
 * <h1>Classe No</h1>
 * A classe No representa um nó para uso em estruturas de dados e
 * armazena um conteudo genérico e uma referência para o próximo nó.
 * 
 * @author Pinheiro Jr.
 * @version 1.0
 * @since 17/03/2023
 */
 
package edu.jr.util;

public class No<T> {
    private T conteudo;
    private No<T> noPosterior;

    /**
     * Construtor
     * @param conteudo - recebe um conteúdo de tipo genérico
     */
    public No (T conteudo) {
        this.conteudo = conteudo;
        this.noPosterior = null;
    }
    
    /**
     * Este método retorna o conteúdo do nó
     * @return conteudo
     */
    public T getConteudo () {
        return conteudo;
    }
    
    /**
     * Este método atribui um novo valor para o conteúdo do nó
     * @param conteudo
     */
    public void setConteudo (T conteudo) {
        this.conteudo = conteudo;
    }
    
    /**
     * Este método retorna o próximo nó encadeado
     * @return proximoNo
     */
    public No<T> getNoPosterior() {
        return noPosterior;
    }
    
    /**
     * Este método atribui um novo nó para o atributo <b>proximoNo</b>
     * @param noPosterior
     */
    public void setNoPosterior (No<T> noPosterior) {
        this.noPosterior = noPosterior;
    }

    @Override
    public String toString() {
        return "No [conteudo = " + conteudo + "]";
    }

    /**
     * Este método converte a classe para String incluindo os atributos <b>conteudo</b> e
     * <b>proximoNo</b>
     * @return
     */
    public String toStringEncadeado() {
        String str;
        str = "No [conteudo = " + conteudo;

        if (noPosterior != null) {
            str += " -> " + noPosterior.getConteudo() + "]";
        } else {
            str += " -> null]";
        }
        return str;
    }

}
