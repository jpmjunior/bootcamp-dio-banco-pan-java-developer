package edu.jr.util;

public class NoArvoreBin<T extends Comparable<T>> {
    private T conteudo;
    private NoArvoreBin<T> noEsquerdo;
    private NoArvoreBin<T> noDireito;

    /**
     * Construtor
     * @param conteudo - recebe um conteúdo de tipo genérico
     */
    public NoArvoreBin (T conteudo) {
        this.conteudo = conteudo;
        this.noEsquerdo = null;
        this.noDireito = null;
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
     * Este método retorna o objeto noEsquerdo do tipo NoArvoreBin<T>
     * @return
     */
    public NoArvoreBin<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    /**
     * Este método atribui um novo objeto para o atributo noEsquerdo
     * @param noEsquerdo
     */
    public void setNoEsquerdo(NoArvoreBin<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    /**
     * Este método retorna o objeto noDireito do tipo NoArvoreBin<T>
     * @return
     */
    public NoArvoreBin<T> getNoDireito() {
        return noDireito;
    }

    /**
     * Este método atribui um novo objeto para o atributo noDireito
     * @param noDireito
     */
    public void setNoDireito(NoArvoreBin<T> noDireito) {
        this.noDireito = noDireito;
    }

    @Override
    public String toString() {
        return "No [conteudo = " + conteudo + "]";
    }

}
