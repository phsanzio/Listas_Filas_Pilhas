public class ListaSE {
    private Celula primeiro;

    public ListaSE(){
        primeiro = null;
    }
    
    public boolean vazia(){
        return(primeiro == null);
    }
    
    public void inserirNoInicio(Celula c){
        c.prox = primeiro;
        primeiro = c;
    }
    
    public void inserirAoFinal(Celula c){
        if(vazia()){
            primeiro = c;
        } else {
            Celula aux = primeiro;
            while (aux.prox != null) {
                aux = aux.prox;
            }
            aux.prox = c;
        }
    }

    Celula pesquisar(int v){
        if(vazia()){
            return null;
        } else {
            Celula aux = primeiro;
            while (aux != null && aux.valor != v) {
                aux = aux.prox;
            }
            return aux;
        }
    }

    public boolean removerInicio(){
        if(vazia()){
            return false;
        } else {
            Celula aux = primeiro;
            if (aux.prox == null) {
                primeiro = null;
            } else {
                primeiro = aux.prox;
                aux.prox = null;
            }
            return true;
        }
    }

    public boolean removerElemento(int elemento){
        if (vazia()) {
            return false;
        } else {
            int contador = 1;
            Celula ant = primeiro;
            Celula aux = primeiro;
            while (contador != elemento) {
                ant = aux;
                aux = ant.prox;
                contador++;
            }
            if (aux == primeiro) {
                removerInicio();
                return true;
            } else if (aux.prox == null){
                removerFinal();
                return true;
            } else {
                Celula proxima = aux.prox;
                ant.prox = proxima;
                aux.prox = null;
                return true;
            }
        }
    }

    public boolean removerFinal(){
        if(vazia()){
            return false;
        } else {
            Celula ant = primeiro;
            Celula atual = primeiro.prox;
            if (atual != null) {
                while (atual.prox != null) {
                    ant = atual;
                    atual = atual.prox;
                }
                ant.prox = null;
            } else {
                atual = primeiro;
                primeiro = null;
            }
            return true;
        }
    }

    public void imprimir(){
        Celula aux = primeiro;
        int i = 1;
        while (aux != null) {
            System.out.println(i++ + "° Valor = "+ aux.valor);
            aux = aux.prox;
        }
    }

    public boolean existe(int v){
        if (vazia()) {
            return false;
        } else {
            Celula aux = primeiro;
            while (aux != null && aux.valor != v) {
                aux = aux.prox;
            }
            return true;
        }
    }

    public ListaSE inter(ListaSE lista){
        ListaSE lista_resol = new ListaSE();
        Celula aux = lista.primeiro;
        while (aux != null) {
            if (existe(aux.valor)) {
                Celula n = pesquisar(aux.valor);
                lista_resol.inserirOrdenado(n);
            }
            aux = aux.prox;
        }
        return lista_resol;
    }

    public void inserirOrdenado(Celula c){
        if(vazia()){
            primeiro = c;
        } else{
            Celula aux = primeiro;
            Celula aux2 = primeiro.prox;
            if(aux2 == null){
                if(aux.valor > c.valor){
                    inserirNoInicio(c);
                } else{
                    inserirAoFinal(c);
                }
            } else{
                while (aux2.prox != null && aux2.valor < c.valor) {
                    aux = aux2;
                    aux2 = aux2.prox;
                }
                if(aux2.prox == null && aux2.valor < c.valor){
                    inserirAoFinal(c);
                } else {
                    aux.prox = c;
                    c.prox = aux2;
                }
            }
        }
    }
}



