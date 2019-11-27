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

    boolean isCompleto () {

        // verifica se todos os vértices são adjacentes a todos os outros vértices

        boolean isCompleto = true;

        if (this.nodos.size() > 0) {
            int arestasNecessarias = this.nodos.size() - 1;

            for(Nodo vertice : nodos){
                if(vertice.incidencias.size() != arestasNecessarias) {
                    isCompleto = false;
                }
            }
        }

        if (isCompleto) {
            System.out.println("Grafo completo.");
        } else {
            System.out.println("Grafo não é completo.");
        }

        return isCompleto;
    }

    boolean isConexo () {
        for (int i = 1; i < nodos.size(); i++) {
            for (int j = 1; j < nodos.size(); j++) {
                Grafo grafoVazio = new Grafo();
                if (!consegueChegar(nodos.get(i), nodos.get(j), grafoVazio) && i != j) {
                    System.out.println("Grafo não conexo.");
                    return false;
                }
            }
        }
        System.out.println("Grafo é conexo.");
        return true;
    }

    private boolean consegueChegar(Nodo verticeAtual, Nodo verticeProcurado, Grafo g) {
        if (nodos.contains(verticeAtual))
            return false;
        else if (isadjacente(verticeAtual, verticeProcurado))
            return true;
        else {
            g.adicionarNodo(verticeAtual);
            List<Nodo> listaAdjacentes = buscarVerticesAdjacentes(verticeAtual);
            if (listaAdjacentes != null) {
                for (Nodo v : listaAdjacentes) {
                    if (consegueChegar(v, verticeProcurado, g)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private List<Nodo> buscarVerticesAdjacentes(Nodo v) {
        List<Nodo> listaAdjacentes = new ArrayList<Nodo>();
        for (Nodo vertice : nodos) {
            if (isadjacente(v, vertice))
                listaAdjacentes.add(vertice);
        }

        return listaAdjacentes;
    }

    boolean isBipartido () {

    }

    Grafo getComplementar (Grafo G) { return null; }

    boolean isEuleriano (Grafo G ) { return false; }

    boolean isUnicursal (Grafo G ) { return false; }

    boolean hasCiclo (Grafo G) { return false; }

    int getGrauEntrada (Nodo n1) { return 0; }

    void ordenacaoTopologica () { return; } //verifique se o grafo é acíclico antes

    Grafo getTransposto () { return null; }

    boolean isFConexo () { return false; }

}
