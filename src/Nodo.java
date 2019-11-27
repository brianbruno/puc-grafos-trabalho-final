import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class Nodo
{
    static class Incidencia {
        Nodo nodo;  // referência ao nodo adjacente
        int peso;   // valor da aresta

        public Incidencia(Nodo nodo, int peso) {
            this.nodo = nodo;
            this.peso = peso;
        }
    }

    private String valor;
    List<Incidencia> incidencias = new ArrayList<>();

    public Nodo(String valor) {
        this.valor = valor;
    }

    public void addIncidencia(Nodo nodo) {
        int peso = 0;
        incidencias.add(new Incidencia(nodo, peso));
    }

    public String getValor() {
        return valor;
    }
    public boolean incide(Nodo nodo) {
        AtomicBoolean incide = new AtomicBoolean(false);

        this.incidencias.forEach(incidencia -> {
            if (incidencia.nodo.getValor().equals(nodo.getValor())) {
                incide.set(true);
            }
        });

        return incide.get();
    }
}