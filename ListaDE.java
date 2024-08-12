public class ListaDE {
    private Celula primeiro;

    public ListaDE(){
        primeiro = null;
    }

    public boolean vazia(){
        return(primeiro == null);
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

    public void inserirNoInicio(Celula c){
        if (!vazia()) {
            c.prox = primeiro;
            primeiro.ant = c;
        }
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
            c.ant = aux;
        }
    }

    public void inserirOrdenado(Celula c){
        if(vazia()){
            primeiro = c;
        } else{
            Celula aux = primeiro;
            Celula aux2 = primeiro.prox;
            if (aux.valor > c.valor) {
                inserirNoInicio(c);
            } else if (aux2 == null){
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
                    c.ant = aux;
                    c.prox = aux2;
                    aux2.ant = c;
                }
            }
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
                primeiro.ant = null;
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
            Celula anterior = primeiro;
            Celula aux = primeiro;
            while (contador != elemento) {
                anterior = aux;
                aux = anterior.prox;
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
                anterior.prox = proxima;
                proxima.ant = anterior;
                aux.prox = null;
                aux.ant = null;
                return true;
            }
        }
    }

    public boolean removerFinal(){
        if(vazia()){
            return false;
        } else {
            Celula aux = primeiro;
            while (aux.prox != null) {
                aux = aux.prox;
            }
            if (aux.ant != null) {
                (aux.ant).prox = null;
                aux.ant = null;
            }
            return true;
        }
    }

    public ListaDE inter(ListaDE lista){
        ListaDE lista_resol = new ListaDE();
        Celula aux = lista.primeiro;
        while (aux != null) {
            if (existe(aux.valor)) {
                Celula n = pesquisar(aux.valor);
                lista_resol.inserirNoInicio(n);
            }
            aux = aux.prox;
        }
        return lista_resol;
    }

    public void imprimir(){
        Celula aux = primeiro;
        int i = 1;
        while (aux != null) {
            System.out.println(i++ + "° Valor = "+ aux.valor);
            aux = aux.prox;
        }
    }
}
