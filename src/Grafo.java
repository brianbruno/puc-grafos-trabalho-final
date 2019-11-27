import java.util.ArrayList;
import java.util.List;

public class Grafo {

    List<Nodo> nodos = new ArrayList<>();  // todos os vértices do grafo

    public void adicionarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    boolean isadjacente (Nodo n1, Nodo n2) {

        boolean adjacente = false;

        if (n1.incide(n2) || n2.incide(n1)) {
            adjacente = true;
            System.out.println("Grafo " + n1.getValor() + " e " + n2.getValor() + " são adjacentes.");
        } else {
            System.out.println("Grafo " + n1.getValor() + " e " + n2.getValor() + " não são adjacentes.");
        }

        return adjacente;
    }

    int getGrau (Nodo n1) {
        int grau = n1.incidencias.size();
        System.out.println("Grau do vértice " + n1.getValor() + ": " + grau);
        return grau;
    }

    boolean isRegular () {

        // Quando todos os vértices possuem o mesmo grau

        boolean isRegular = true;
        if (this.nodos.size() > 0) {
            int grauPadrao = this.nodos.get(0).incidencias.size();

            for(Nodo vertice : nodos){
                if(vertice.incidencias.size() != grauPadrao) {
                    isRegular = false;
                }
            }
        }

        if (isRegular) {
            System.out.println("Grafo regular.");
        } else {
            System.out.println("Grafo não regular.");
        }

        return isRegular;
    }

    boolean isIsolado (Nodo n1) {

        // Quando vértice possui grau zero.

        boolean isIsolado = false;

        if(n1.incidencias.size() == 0) {
            isIsolado = true;

            System.out.println("Vértice " + n1.getValor() + " é isolado");
        } else {
            System.out.println("Vértice " + n1.getValor() + " não é isolado");
        }

        return isIsolado;
    }

    boolean isPendente (Nodo n1) {
        // Quando o vértice possui grau 1

        boolean isPendente = false;

        if (n1.incidencias.size() == 1) {
            isPendente = true;

            System.out.println("Vértice " + n1.getValor() + " é pendente.");
        } else {
            System.out.println("Vértice " + n1.getValor() + " não é pendente.");
        }

        return isPendente;
    }

    boolean isNulo () {
        // Quando o grafo não tem arestas

        boolean possuiArestas = false;

        for(Nodo vertice : nodos){
            if(vertice.incidencias.size() > 0) {
                possuiArestas = true;
            }
        }

        if (possuiArestas) {
            System.out.println("Grafo não é nulo.");
        } else {
            System.out.println("Grafo é nulo.");
        }

        return possuiArestas;
    }

    boolean isCompleto (Grafo G) {
        return false;
    }

    boolean isConexo (Grafo G) { return false; }

    boolean isBipartido (Grafo G) { return false; }

    Grafo getComplementar (Grafo G) { return null; }

    boolean isEuleriano (Grafo G ) { return false; }

    boolean isUnicursal (Grafo G ) { return false; }

    boolean hasCiclo (Grafo G) { return false; }

    int getGrauEntrada (Nodo n1) { return 0; }

    void ordenacaoTopologica (Grafo G) { return; } //verifique se o grafo é acíclico antes

    Grafo getTransposto (Grafo G) { return null; }

    boolean isFConexo (Grafo G) { return false; }

}
