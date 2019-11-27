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

    int getGrau (Nodo n1) { return 0; }

    boolean isRegular (Grafo G) { return false; }

    boolean isIsolado (Nodo n1) { return false; }

    boolean isPendente (Nodo n1) { return false; }

    boolean isNulo (Grafo G) { return false; }

    boolean isCompleto (Grafo G) { return false; }

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
