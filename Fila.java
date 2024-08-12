public class Fila {
    Celula frente;
    Celula tras;

    public Fila(){
        frente = new Celula(-1);
        tras = frente;
        frente.prox = null;
    }

    public boolean vazia(){
        return (frente == tras);
    }

    public void enfileira(Celula elemento){
        this.tras.prox = elemento;
        this.tras = this.tras.prox;
        this.tras.prox = null;
    }

    public Celula desenfileirar() throws Exception{
        Celula item = null;
        if (this.vazia()) {
            throw new Exception("Erro: A fila esta vazia");
        }
        item = this.frente.prox;
        frente.prox = item.prox;
        item.prox = null;
        if (tras == item) {
            tras = frente;
        }
        return item;
    }

    public void exibir(){
        if (vazia()) {
            System.out.println("Não há elementos na fila");
        } else {
            Celula aux = frente.prox;
            int i = 1;
            while (aux != null) {
                System.out.println(i++ + "° Elemento = "+ aux.valor);
                aux = aux.prox;
            }
        }
    }
}
