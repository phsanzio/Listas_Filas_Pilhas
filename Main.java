public class Main {
    public static void main(String[] args) {
        ListaDE lista1 = new ListaDE();
        Celula n1 = new Celula(10);
        lista1.inserirNoInicio(n1);
        n1 = new Celula(70);
        lista1.inserirNoInicio(n1);
        n1 = new Celula(56);
        lista1.inserirNoInicio(n1);
        n1 = new Celula(47);
        lista1.inserirNoInicio(n1);
        lista1.imprimir();
        System.out.println("------------");
        lista1.removerElemento(4);
        lista1.imprimir();
    }
}