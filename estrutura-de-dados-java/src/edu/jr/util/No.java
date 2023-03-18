package edu.jr.util;

public class No<T> {
    private T conteudo;
    private No<?> proximoNo;

    public No (T conteudo) {
        this.conteudo = conteudo;
        this.proximoNo = null;
    }
    
    public T getConteudo () {
        return conteudo;
    }
    
    public void setConteudo (T conteudo) {
        this.conteudo = conteudo;
    }
    
    public No<?> getProximoNo() {
        return proximoNo;
    }
    
    public void setProximoNo (No<?> proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        return "No [conteudo = " + conteudo + "]";
    }

    public String toStringEncadeado() {
        String str;
        str = "No [conteudo = " + conteudo;

        if (proximoNo != null) {
            str += " -> " + proximoNo.getConteudo() + "]";
        } else {
            str += " -> null]";
        }
        return str;
    }

}
