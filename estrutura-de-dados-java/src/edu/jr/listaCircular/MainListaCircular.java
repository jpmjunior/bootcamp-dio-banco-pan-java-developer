package edu.jr.listaCircular;

public class MainListaCircular {
    public static void main(String[] args) {
        ListaCircular<String> lista = new ListaCircular<>();

        lista.add("str1");
        lista.add("str2");
        lista.add("str3");
        lista.add("str4");
        
        System.out.println(lista);
        System.out.println("Calda: " + lista.getNoPosterior(lista.size() - 1) + " - " + "Cabeça: " + lista.getCabeca());
        System.out.println("Calda: " + lista.getCauda() + " - " + "Cabeça: " + lista.getCabeca());
        
        System.out.println();
        lista.add(0,"str0.2");
        lista.add(1,"str0.5");
        System.out.println(lista);
        System.out.println("Calda: " + lista.getNoPosterior(lista.size() - 1) + " - " + "Cabeça: " + lista.getCabeca());
        System.out.println("Calda: " + lista.getCauda() + " - " + "Cabeça: " + lista.getCabeca());
        
        System.out.println();
        System.out.println("Removendo elemento: " + lista.remove(0));
        System.out.println(lista);
        System.out.println("Calda: " + lista.getNoPosterior(lista.size() - 1) + " - " + "Cabeça: " + lista.getCabeca());
        System.out.println("Calda: " + lista.getCauda() + " - " + "Cabeça: " + lista.getCabeca());
        
        System.out.println();
        System.out.println("Removendo elemento: " + lista.remove(1));
        System.out.println(lista);
        System.out.println("Calda: " + lista.getNoPosterior(lista.size() - 1) + " - " + "Cabeça: " + lista.getCabeca());
        System.out.println("Calda: " + lista.getCauda() + " - " + "Cabeça: " + lista.getCabeca());
        
        System.out.println();
        System.out.println("Removendo elemento: " + lista.remove(lista.size()-1));
        System.out.println(lista);
        System.out.println("Calda: " + lista.getNoPosterior(lista.size() - 1) + " - " + "Cabeça: " + lista.getCabeca());
        System.out.println("Calda: " + lista.getCauda() + " - " + "Cabeça: " + lista.getCabeca());
        

    }
}
