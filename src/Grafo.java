import java.util.List;

public class Grafo {

    List<Nodo> nodos;  // todos os vértices do grafo

    public Grafo(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    boolean isadjacente (Nodo n1, Nodo n2) { return false; }

    int getGrau (Nodo n1) { return false; }

    boolean isRegular (Grafo G) { return false; }

    boolean isIsolado (Nodo n1) { return false; }

    boolean isPendente (Nodo n1) { return false; }

    boolean isNulo (Grafo G) { return false; }

    boolean isCompleto (Grafo G) { return false; }

    boolean isConexo (Grafo G) { return false; }

    boolean isBipartido (Grafo G) { return false; }

    Grafo getComplementar (Grafo G) { return false; }

    boolean isEuleriano (Grafo G ) { return false; }

    boolean isUnicursal (Grafo G ) { return false; }

    boolean hasCiclo (Grafo G) { return false; }

    int getGrauEntrada (Nodo n1) { return false; }

    void ordenacaoTopologica (Grafo G) { return false; } //verifique se o grafo é acíclico antes

    Grafo getTransposto (Grafo G) { return false; }

    boolean isFConexo (Grafo G) { return false; }

}
