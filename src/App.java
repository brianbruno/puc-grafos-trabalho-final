public class App {

    public static void main(String[] args) {

        // Grafo dirigido
        Nodo n1 = new Nodo();
        Nodo n2 = new Nodo();
        Nodo n3 = new Nodo();
        Nodo n4 = new Nodo();
        Nodo n5 = new Nodo();
        Nodo n6 = new Nodo();
        Nodo n7 = new Nodo();
        Nodo n8 = new Nodo();

        n3.addIncidencia(n1);
        n3.addIncidencia(n2);

        n4.addIncidencia(n3);

        n5.addIncidencia(n3);

        n6.addIncidencia(n3);
        n6.addIncidencia(n4);
        n6.addIncidencia(n5);

        n7.addIncidencia(n5);

        n8.addIncidencia(n6);
        n8.addIncidencia(n7);
    }

}
