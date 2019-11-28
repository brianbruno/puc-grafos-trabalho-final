public class App {

    public static void main(String[] args) {

        Grafo grafoDirigido = new Grafo();
        Grafo grafoNaoDirigido = new Grafo();

        // Grafo dirigido
        Nodo n1 = new Nodo("1");
        Nodo n2 = new Nodo("2");
        Nodo n3 = new Nodo("3");
        Nodo n4 = new Nodo("4");
        Nodo n5 = new Nodo("5");
        Nodo n6 = new Nodo("6");
        Nodo n7 = new Nodo("7");
        Nodo n8 = new Nodo("8");

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

        // -------------- OPERACOES
        System.out.println("OPERAÇÕES COM GRAFO DIRIGIDO");

        grafoDirigido.getGrauEntrada(n1);
        grafoDirigido.getGrauEntrada(n2);
        grafoDirigido.getGrauEntrada(n3);
        grafoDirigido.ordenacaoTopologica();
        grafoDirigido.getTransposto();
        grafoDirigido.isFConexo();


        // Grafo não dirigido
        Nodo n01 = new Nodo("01");
        Nodo n02 = new Nodo("02");
        Nodo n03 = new Nodo("03");
        Nodo n04 = new Nodo("04");
        Nodo n05 = new Nodo("05");
        Nodo n06 = new Nodo("06");

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

        System.out.println("OPERAÇÕES COM GRAFO NÃO DIRIGIDO");

        grafoNaoDirigido.isadjacente(n06, n04);
        grafoNaoDirigido.isadjacente(n01, n03);

        grafoNaoDirigido.getGrau(n04);
        grafoNaoDirigido.getGrau(n03);

        grafoNaoDirigido.isRegular();

        grafoNaoDirigido.isIsolado(n02);
        grafoNaoDirigido.isIsolado(n05);

        grafoNaoDirigido.isPendente(n06);
        grafoNaoDirigido.isPendente(n01);

        grafoNaoDirigido.isNulo();

        grafoNaoDirigido.isCompleto();

        grafoNaoDirigido.isConexo();

        grafoNaoDirigido.getComplementar();

        grafoNaoDirigido.isBipartido();
        grafoNaoDirigido.isEuleriano();

        grafoNaoDirigido.isUnicursal();

        grafoNaoDirigido.hasCiclo();

    }

}
