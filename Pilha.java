public class Pilha {
    Celula topo;
    int quantos;

    public Pilha(){
        topo = null;
        quantos = 0;
    }

    public boolean vazia(){
        return (topo == null);
    }

    public void empilhar(Celula elemento){
        elemento.prox = topo;
        topo = elemento;
        quantos++;
    }
    
    public Celula desempilhar(){
        if (vazia()) {
            System.out.println("\nErr: Não há itens na pilha");
            return null;
        } else {
            Celula aux = topo;
            topo = topo.prox;
            aux.prox = null;
            quantos--;
            return aux;
        }
    }

    public void esvaziar(){
        topo = null;
    }

    public void exibir(){
        if (vazia()) {
            System.out.println("\n Não há elementos na pilha");
        } else {
            Celula aux = topo;
            int i = 1;
            while (aux != null) {
                System.out.println(i++ + "° Elemento = "+ aux.valor);
                aux = aux.prox;
            }
        }
    }
}
