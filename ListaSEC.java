public class ListaSEC {
    private Celula cabeca;

    public ListaSEC(){
        cabeca = new Celula(-1);
        cabeca.prox = cabeca;
    }

    public boolean vazia(){
        return(cabeca.prox == cabeca);
    }
    
    public void inserirNoInicio(Celula c){
        Celula aux = cabeca.prox;
        cabeca.prox = c;
        c.prox = aux;
    }
    
    public void inserirAoFinal(Celula c){
        if(vazia()){
            cabeca.prox = c;
            c.prox = cabeca;
        } else {
            Celula aux = cabeca.prox;
            while (aux.prox != cabeca) {
                aux = aux.prox;
            }
            aux.prox = c;
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
            if (aux == cabeca) {
                return null;
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
            aux.prox = null;
            return true;
        }
    }

    public boolean removerFinal(){
        if(vazia()){
            return false;
        } else {
            Celula aux = cabeca.prox;
            if (aux.prox != cabeca) {
                while ((aux.prox).prox != cabeca) {
                    aux = aux.prox;
                }
                Celula aux2 = aux.prox;
                aux.prox = cabeca;
                aux2.prox = null;
            } else {
                cabeca.prox = cabeca;
                aux.prox = null;
            }
            return true;
        }
    }
    
    public int tamanho(){
        int contador = 0;
        Celula aux = cabeca.prox;
        while (aux != cabeca) {
            contador++;
            aux = aux.prox;
        }
        return contador;
    }
    
    public boolean concatenar(ListaSEC lista){
        Celula aux = (lista.cabeca).prox;
        while (aux != lista.cabeca) {
            Celula aux2 = new Celula(aux.valor);
            inserirNoInicio(aux2);
            aux = aux.prox;
        }
        return true;
    }

    public boolean eliminarValor(int v){
        if (vazia()) {
            return false;
        } else {
            Celula aux = cabeca;
            Celula ant = cabeca;
            while (aux.prox != cabeca && aux.valor != v) {
                ant = aux;
                aux = aux.prox;
                if (aux.prox == cabeca && aux.valor != v){
                    return false;
                }
            }
            if (aux.prox == cabeca) {
                removerFinal();
                return true;
            } else if (aux == cabeca){
                removerInicio();
                return true;
            } else {
                Celula proxima = aux.prox;
                ant.prox = proxima;
                aux.prox = null;
                return true;
            }
        }
    }

    public void imprimir(){
        Celula aux = cabeca.prox;
        int i = 1;
        while (aux != cabeca) {
            System.out.println(i++ + "° Valor = "+ aux.valor);
            aux = aux.prox;
        }
    }
}
