public class App {

    public static void main(String[] args) {

        Grafo grafoDirigido = new Grafo();
        Grafo grafoNaoDirigido = new Grafo();

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

        grafoDirigido.adicionarNodo(n1);
        grafoDirigido.adicionarNodo(n2);
        grafoDirigido.adicionarNodo(n3);
        grafoDirigido.adicionarNodo(n4);
        grafoDirigido.adicionarNodo(n5);
        grafoDirigido.adicionarNodo(n6);
        grafoDirigido.adicionarNodo(n7);
        grafoDirigido.adicionarNodo(n8);

        // Grafo não dirigido
        Nodo n01 = new Nodo();
        Nodo n02 = new Nodo();
        Nodo n03 = new Nodo();
        Nodo n04 = new Nodo();
        Nodo n05 = new Nodo();
        Nodo n06 = new Nodo();

        n01.addIncidencia(n02);
        n01.addIncidencia(n05);

        n02.addIncidencia(n01);
        n02.addIncidencia(n05);
        n02.addIncidencia(n03);

        n03.addIncidencia(n02);
        n03.addIncidencia(n04);

        n04.addIncidencia(n03);
        n04.addIncidencia(n05);
        n04.addIncidencia(n06);

        n05.addIncidencia(n01);
        n05.addIncidencia(n02);
        n05.addIncidencia(n04);

        n06.addIncidencia(n04);

        grafoNaoDirigido.adicionarNodo(n01);
        grafoNaoDirigido.adicionarNodo(n02);
        grafoNaoDirigido.adicionarNodo(n03);
        grafoNaoDirigido.adicionarNodo(n04);
        grafoNaoDirigido.adicionarNodo(n05);
        grafoNaoDirigido.adicionarNodo(n06);

    }

}
