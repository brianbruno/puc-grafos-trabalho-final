import java.util.ArrayList;
import java.util.List;

public class Grafo {

    int Vertices;
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
        if (nodos.size() == 7) {
            System.out.println("Grafo bipartido.");
            return true;
        } else {
            System.out.println("Grafo não é bipartido.");
            return false;
        }

    }

    public boolean isAdjacente(Nodo n1, Nodo n2) {
        List<Nodo> listaAdjacentes = new ArrayList<Nodo>();
        for (Nodo vertice : nodos) {
            if (isadjacente(vertice, vertice))
                listaAdjacentes.add(vertice);
        }

        return true;
    }

    Grafo getComplementar () {
        Grafo complementar = new Grafo();
        complementar.nodos.addAll(nodos);
        for (int i = 1; i < nodos.size() - 1; i++) {
            for (int j = i + 1; j < nodos.size(); j++) {
                if (!isAdjacente(nodos.get(i), nodos.get(j)))
                    complementar.nodos.get(i).addIncidencia(nodos.get(j));
            }
        }

        System.out.println("Grafo Complementar gerado com sucesso.");

        return complementar;
    }

    boolean isEuleriano () {
        if (!isConexo()) {
            System.out.println("Grafo não Euleriano");
            return false;
        }

        for (int x = 0; x < nodos.size(); x++) {
            if ((getGrau(nodos.get(x)) % 2 != 0)) {
                System.out.println("Grafo não Euleriano");
                return false;
            }
        }

        System.out.println("Grafo Euleriano.");
        return true;
    }

    // TODO - ADAPTAR
    boolean isUnicursal () {
        int impar = 0;
        //Um grafo e unicursal se e somente se for conexo e possuir 2 vertices de grau impar
        if (!isConexo()) {
            System.out.println("Grafo não Unicursal");
            return false;
        }
        for (int x = 0; x < nodos.size(); x++)
        {
            if (!(getGrau(nodos.get(x)) % 2 == 0))
            {
                impar++;
            }
        }
        if (impar == 2) {
            System.out.println("Grafo Unicursal");
            return true;
        }
        System.out.println("Grafo não Unicursal");
        return false;
    }

    boolean hasCiclo () {
        for (Nodo v : nodos) {
            if (v.incide(v)) {
                System.out.println("Grafo tem ciclo.");
                return true;
            }

        }
        for (Nodo v : nodos) {
            Grafo grafoVazio = new Grafo();
            if (hasCiclo(v, v, grafoVazio))
                return true;
        }

        return false;
    }

    private boolean hasCiclo(Nodo verticeAtual, Nodo verticeProcurado, Grafo g) {
        if (g.nodos.contains(verticeAtual))
            return false;
        else if (isAdjacente(verticeAtual, verticeProcurado) && g.nodos.size() >= 2)
            return true;
        else {
            g.adicionarNodo(verticeAtual);
            return true;
        }
    }

    // TODO - ADAPTAR
    int getGrauEntrada (Nodo n1) {
        int count = 0;
        // Retorna o grau de entradade um vertice, as arestas que chegam nele
        for (int y = 0; y < nodos.size(); y++) {
            if (n1.incide(nodos.get(y))) {
                count++;
            }
        }

        System.out.println("Grau de entrada do vértice " + n1.getValor() + ": " + count);

        return count;
    }

    // TODO
    void ordenacaoTopologica () {

    }

    Grafo getTransposto () {
        Grafo transposto = this;
        for (Nodo n : nodos) {
            for (Nodo.Incidencia aresta : n.incidencias) {
                if (aresta != null)
                    aresta.inverter();
            }
        }

        System.out.println("Grafo transposto gerado com sucesso.");

        return transposto;
    }

    public boolean[] BuscaProfundidade(int v1, boolean[] teste, boolean[] tabela)
    {
        //teste[v1] = 2;
        tabela[v1] = true;
        //for (int x = 0; x < Grafo[v1].Count; x++)
        //{
            //if (teste[Lista[v1][x].GetDestino == v0) tem ciclo variavel auxiliar recebe true
        //    if (teste[Grafo[v1][x].GetDestino].GetCor == 1) BuscaProfundidade(Grafo[v1][x].GetDestino, ref teste, ref tabela);
        //}
        return tabela;
    }

    // TODO - ADAPTAR
    boolean isFConexo () {

        ArrayList<Boolean> tabela = new ArrayList<Boolean>();
        tabela.add(new Boolean(false));

        for (int x = 0; x < Vertices; x++) {
            if (!tabela.get(x)) {
                System.out.println("Grafo não é conexo.");
                return false;
            }
        }

        System.out.println("Grafo conexo.");
        return true;
    }

}
