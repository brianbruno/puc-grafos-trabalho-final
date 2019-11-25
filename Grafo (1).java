import Celula.java;

public class Grafos {
                
    int vertices; //numero de vertices
    List<Celula>[] Grafo; //contem a lista de adjacencia

    //Construtor
    public Grafos(int ver, List<Celula>[] Listas2) {
        this.vertices = ver;
        this.Grafo = Listas2;
    }

    public int getVertices {
        return this.vertices;
    }

    public void setVertices(int value) {
        this.vertices = value;
    }

    public void adicinarAresta(int inicio, int destino, int peso) {
        Celula aux = new Celula(inicio, destino, peso);
        Grafo[inicio].add(aux);

        //Grafo nao direcionado; função para cadastro das arestas
        Celula aux2 = new Celula(inicio, destino, peso);
        Grafo[destino].add(aux2);
    }


    public Celula getAresta(int x, int y) {
        return Grafo[x][y];
    }

    public bool isAdjacente(int v1, int v2) {
            // Pega o tamanho na lista na posição v1 do vetor 
        for (int x = 0; x < Grafo[v1].size(); x++)
            if (Grafo[v1][x].getDestino() == v2) 
                return true;

        return false;
    }

    public int getGrau(int vertice) {
        // Retorna o grau de um vertice ou numero de arestas incidentes nesse vértice
        return Grafo[vertice].size();
    }

    public int getGrauEntrada(int vertice) {
        int count = 0;
        // Retorna o número de arestas que chegam a um vértice, determimnando o grau de entrada           
        for (int y = 0; y < Vertices; y++)
            for (int x = 0; x < Grafo[y].size(); x++)
                if (Grafo[y][x].getDestino() == vertice) count++;
            
        return count;
    }

    public bool isIsolado(int v1) {
        // Procura o vértice que não é um ponto final de toda a aresta. Se encontrar um vertice com grau 0 ele é isolado.
        if (getGrau(v1) == 0) return true;
        
        return false;
    }

    public bool isPendente(int v1) {
        // Se um vertice tiver grau 1 ele é pendente- também chamado de vértice folha
        if (getGrau(v1) == 1) return true;

        return false;
    }

    public bool isRegular() {
         // Verifica se todos os vertices do grafo tem o mesmo grau
        for (int x = 1; x < Grafo.size(); x++) //roda o numero de vestices existente 
         // Compara o grau do vertice atual com o grau do vertice anterior e tenta encontrar o vertice com grau diferente.
            if (Grafo[x].size() != Grafo[x - 1].size()) return false;
        return true;
    }
}