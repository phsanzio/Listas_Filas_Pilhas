public class Celula{
    int valor;
    Celula prox;
    Celula ant;

    public Celula(int v){
        this.valor = v;
        this.prox = null;
        this.ant = null;
    }
}