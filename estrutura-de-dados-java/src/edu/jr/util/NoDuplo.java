package edu.jr.util;

public class NoDuplo<T> {
    private T conteudo;
    private NoDuplo<T> noPosterior;
    private NoDuplo<T> noAnterior;

    /**
     * Construtor
     * @param conteudo - recebe um conteúdo de tipo genérico
     */
    public NoDuplo (T conteudo) {
        this.conteudo = conteudo;
        this.noPosterior = null;
        this.noAnterior = null;
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

    public NoDuplo<T> getNoPosterior() {
        return noPosterior;
    }

    public void setNoPosterior(NoDuplo<T> noPosterior) {
        this.noPosterior = noPosterior;
    }

    public NoDuplo<T> getNoAnterior() {
        return noAnterior;
    }

    public void setNoAnterior(NoDuplo<T> noAnterior) {
        this.noAnterior = noAnterior;
    }

    @Override
    public String toString() {
        return "No [conteudo = " + conteudo + "]";
    }

    /**
     * Este método converte a classe para String incluindo os atributos <b>conteudo</b>, 
     * <b>noAnterior</b> e <b>noPosterior</b> 
     * @return
     */
    public String toStringEncadeado() {
        String str;
        str = "No [";

        if (noAnterior != null) str += noAnterior.getConteudo() + " <- ";
        else str += "null <- ";

        str += this.getConteudo() + " -> ";

        if (noPosterior != null) str += noPosterior.getConteudo() + "]";
        else str += "null]";

        return str;
    }

}
