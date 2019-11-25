class Celula {
    int inicio, destino, peso;

//inicio endereços do último item da lista deadjacentes de cada vértice 
//destino: endereço do próximo item da lista de adjacentes.
//peso: valor do peso de cada aresta do grafo


    public Celula(int v1, int v2, int v3) {
        this.inicio = v1;
        this.destino = v2;
        this.peso = v3;
    }

    public int getInicio {
        return this.inicio;
        
    }

    public int getDestino {
        return this.destino;
        
    }

    public int getPeso {
        return this.peso;
        
    }
}