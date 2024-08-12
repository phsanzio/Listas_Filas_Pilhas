public class ListaDEC {
    private Celula cabeca;

    public ListaDEC(){
        cabeca = new Celula(-1);
        cabeca.prox = cabeca;
        cabeca.ant = cabeca;
    }

    public boolean vazia(){
        return(cabeca.prox == cabeca);
    }
    
    public void inserirNoInicio(Celula c){
        Celula aux = cabeca.prox;
        cabeca.prox = c;
        c.ant = cabeca;
        c.prox = aux;
        aux.ant = c;
    }
    
    public void inserirAoFinal(Celula c){
        if(vazia()){
            cabeca.prox = c;
            c.prox = cabeca;
            c.ant = cabeca;
            cabeca.ant = c;
        } else {
            Celula aux = cabeca.ant;
            aux.prox = c;
            c.ant = aux;
            cabeca.ant = c;
            c.prox = cabeca;
        }
    }

    Celula pesquisar(int v){
        if(vazia()){
            return null;
        } else {
            Celula aux = cabeca.prox;
            while (aux != cabeca && aux.valor != v) {
                aux = aux.prox;
            }
            return aux;
        }
    }

    public boolean removerInicio(){
        if(vazia()){
            return false;
        } else {
            Celula aux = cabeca.prox;
            cabeca.prox = aux.prox;
            (aux.prox).ant = cabeca;
            aux.prox = null;
            aux.ant = null;
            return true;
        }
    }

    public boolean removerFinal(){
        if(vazia()){
            return false;
        } else {
            Celula aux = cabeca.ant;
            cabeca.ant = aux.ant;
            (aux.ant).prox = cabeca;
            aux.prox = null;
            aux.ant = null;
            return true;
        }
    }

    public void imprimir(){
        Celula aux = cabeca;
        int i = 1;
        while (aux != cabeca) {
            System.out.println(i++ + "° Valor = "+ aux.valor);
            aux = aux.prox;
        }
    }
}
