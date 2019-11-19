import java.util.List;

class Nodo
{
    class Incidencia
    {
        Nodo nodo;  // referência ao nodo adjacente
        int peso;   // valor da aresta

        public Incidencia(Nodo nodo, int peso) {
            this.nodo = nodo;
            this.peso = peso;
        }
    }

    List<Incidencia> incidencias;

    public void addIncidencia(Nodo nodo) {
        int peso = 0;
        incidencias.add(new Incidencia(nodo, peso));
    }
}