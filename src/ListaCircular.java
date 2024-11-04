public class ListaCircular<T> {
    private No<T> inicio;
    private int tamanho;

    public ListaCircular(){
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adicionarNoFim(T dado){
        No<T> novoNo = new No<>(dado);
        if (inicio == null) {
            inicio = novoNo;
            novoNo.proximo = novoNo;
        }
        else {
            No<T> atual = inicio;
            while (atual.proximo != inicio){
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
            novoNo.proximo = inicio;
        }
        tamanho++;
    }

    public void adicionarNoInicio(T dado){
        No<T> novoNo = new No<>(dado);
        if (inicio == null){
            inicio = novoNo;
            novoNo.proximo = novoNo;
        }
        else {
            novoNo.proximo = inicio;
            No<T> ultimo = inicio;
            while (ultimo.proximo != inicio){
                ultimo = ultimo.proximo;
            }
            ultimo.proximo = novoNo;
            inicio = novoNo;
        }
        tamanho++;
    }

    public void adicionarNaPosicao(int posicao, T dado){
        if (posicao < 0 || posicao > tamanho){
            System.out.println("Posição inválida!");
        }
        if (posicao == 0){
            adicionarNoInicio(dado);
        } else if (posicao == tamanho){
            adicionarNoFim(dado);
        } else {
            No<T> novoNo = new No<>(dado);
            No<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++){
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
            tamanho++;
        }
    }

    public T removerNoInicio(){
        if (inicio == null){
            System.out.println("A listá está vazia, não há nada para remover.");
        }
        T dado = inicio.dado;
        if (inicio.proximo == inicio){
            inicio = null;
        }
        else {
            No<T> atual = inicio;
            while (atual.proximo != inicio) {
                atual = atual.proximo;
            }
            inicio = inicio.proximo;
            atual.proximo = inicio;
        }
        tamanho--;
        return dado;
    }

    public T removerNoFim(){
        if (inicio == null){
            System.out.println("A lista está vazia, não há nada a ser removido.");
        }
        T dado;
        if (inicio.proximo == inicio){
            dado = inicio.dado;
            inicio = null;
        }
        else{
            No<T> atual = inicio;
            No<T> anterior = null;
            while (atual.proximo != inicio){
                anterior = atual;
                atual = atual.proximo;
            }
            dado = atual.dado;
            anterior.proximo = inicio;
        }
        tamanho--;
        return dado;
    }

    public T removerDaPosicao(int posicao){
        if (posicao < 0 || posicao >= tamanho){
            System.out.println("Posição inválida!");
        }
        if (posicao == 0){
            return  removerNoInicio();
        }
        if (posicao == tamanho -1){
            return removerNoFim();
        }
        No<T> atual = inicio;
        for (int i = 0; i < posicao - 1; i++){
            atual = atual.proximo;
        }
        T dado = atual.proximo.dado;
        atual.proximo = atual.proximo.proximo;
        tamanho--;
        return dado;
    }

    public T removerPorValor(T elemento){
        if (tamanho == 0) {
            System.out.println("Lista vazia");
        }
        if (inicio.dado.equals(elemento)){
            return removerNoInicio();
        }

        No<T> atual = inicio;
        No<T> anterior = null;

        do {
            anterior = atual;
            atual = atual.proximo;
            if (atual.dado.equals(elemento)){
                if (atual == inicio) {
                    return removerNoFim();
                } else{
                    anterior.proximo = atual.proximo;
                    tamanho --;
                    return atual.dado;
                }
            }
        } while (atual != inicio);
        return null;
    }

    public T buscar(int posicao){
        if (posicao < 0 || posicao >= tamanho){
            System.out.println("Posição inválida!");
        }
        No<T> atual = inicio;
        for (int i = 0; i < posicao; i++){
            atual = atual.proximo;
        }
        return atual.dado;
    }

    public int buscarPosicao(T valor){
        No<T> atual = inicio;
        for (int i = 0; i < tamanho; i++){
            if (atual.dado.equals(valor)){
                return i;
            }
            atual = atual.proximo;
        }
        return -1;
    }

    public void imprimir(){
        if (inicio == null){
            System.out.println("A lista está vazia.");
            return;
        }
        No<T> atual = inicio;
        do {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        } while (atual != inicio);
        System.out.println();
    }
}

