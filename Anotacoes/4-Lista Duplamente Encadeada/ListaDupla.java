public class ListaDupla {
    
    private No primeiro;
    private No ultimo;

    public ListaDupla(){
        primeiro = null;
        ultimo = null;
    }

    // Retorna se a lista esta vazia
    public boolean estaVazio(){
        return primeiro == null;
    }

    // Adiciona um elemento ao inicio da lista
    public void adicionarInicio(int valor){
        No aux = new No(valor);
        if (estaVazio()){
            ultimo = aux;
        }
        else{
            primeiro.setAnterior(aux);
            aux.setProximo(primeiro);
        }
        primeiro = aux;
    }

    // Adiciona um elemento ao final da lista
    public void adicionarFim(int valor){
        No aux = new No(valor);
        if (estaVazio()){
            primeiro = aux;
        }
        else{
            ultimo.setProximo(aux);
            aux.setAnterior(ultimo);
        }
        ultimo = aux;
    }

    // Remove um elemento no final da lista e retorna o valor
    // Caso a lista esteja vazia, um erro é gerado
    public int removerFim(){
        int valor = ultimo.getInfo();
        ultimo = ultimo.getAnterior();
        if (ultimo == null){ // Era o unico elemento
            primeiro = null;
        }
        else{
            ultimo.setProximo(null);
        }
        return valor;
    }

    // Remove um elemento no inicio da lista e retorna o valor
    // Caso a lista esteja vazia, um erro é gerado
    public int removerInicio(){
        int valor = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null){ // Era o unio elemento
            ultimo = null;
        }
        else{
            primeiro.setAnterior(null);
        }
        return valor;
    }

    // Adiciona um elemento na posição especificada
    // Caso a posição for a primeira ou menor, insere no inicio
    // Caso a posição for maior que a lista, insere no fim
    public void adicionarEm(int valor, int posicao){
        if (estaVazio() || posicao <= 0){
            adicionarInicio(valor);
            return;
        }

        int contadorPos = 0;
        No aux = primeiro;
        while (aux != null && contadorPos < posicao) {
            contadorPos++;
            aux = aux.getProximo();
        }
        if (aux == null){
            adicionarFim(valor);
            return;
        }
        No novo = new No(valor);
        aux.getAnterior().setProximo(novo);
        aux.setAnterior(novo);
        novo.setProximo(aux);
        novo.setAnterior(aux.getAnterior());
    }

    // Remove um elemento na posicao especificada
    // Caso a lista estiver vazia ou a posicao for inválida, um erro será gerado
    public int removerEm(int posicao){
        if (posicao == 0){
            return removerInicio();
        }

        No aux = primeiro;
        int contador = 0;
        while (contador < posicao) { // Chega até a posicao correta
            aux = aux.getProximo();
            contador++;
        }
        if (aux == ultimo){
            return removerFim();
        }
        aux.getAnterior().setProximo(aux.getProximo());
        aux.getProximo().setAnterior(aux.getAnterior());
        return aux.getInfo();
    }

    // Retorna o numero de ocorrências de um número na lista
    // Retorna -1 se o número não estiver na lista
    public int contar(int valor){
        if (estaVazio()){
            return -1;
        }

        No aux = primeiro;
        int contador = 0;
        while (aux != null) {
            if (aux.getInfo() == valor){
                contador++;
            }
            aux = aux.getProximo();
        }

        if (contador == 0){
            return -1;
        }
        return contador;
    }

    // Remove a primeira ocorrencia do número e retorna a posicao removida
    // Retorna -1 se o elemento não foi encontrado
    public int removerPrimeiraOcorrencia(int valor){
        if (estaVazio()){
            return -1;
        }
        int pos = 0;
        No aux = primeiro;
        while (aux != null) {
            if (aux.getInfo() == valor){
                if (aux == primeiro){ // Se for o primeiro item na lista
                    primeiro = aux.getProximo();
                    aux.getProximo().setAnterior(null);
                }
                else if(aux == ultimo){ // se for o ultimo item na lista
                    ultimo = aux.getAnterior();
                    aux.getAnterior().setProximo(null);
                }
                else{ // Se estiver no meio da lista
                    aux.getAnterior().setProximo(aux.getProximo());
                    aux.getProximo().setAnterior(aux.getAnterior());
                }
                return pos;
            }
            aux = aux.getProximo();
            pos++;
        }
        return -1;
    }

    // Remove todas as ocorrencias de um número e retorna o número de itens removidos
    // Retorna 0 caso não foi encontrado nenhum valor
    public int removerTodos(int valor){
        if (estaVazio()){
            return 0;
        }

        No aux = primeiro;
        int removidos = 0;

        while (aux != null){
            if (aux.getInfo() == valor){
                if (aux == primeiro){
                    primeiro = aux.getProximo();
                    aux.getProximo().setAnterior(null);
                }
                else if(aux == ultimo){
                    ultimo = aux.getAnterior();
                    aux.getAnterior().setProximo(null);
                }
                else{
                    aux.getAnterior().setProximo(aux.getProximo());
                    aux.getProximo().setAnterior(aux.getAnterior());
                }
                removidos++;
            }
            aux = aux.getProximo();
        }
        return removidos;
    }


    // Acha todas as ocorrencias de um valor e retorna uma lista com as posicoes das ocorrencias
    // Retorna uma lista vazia caso não tenha nenhuma ocorrencia
    public ListaDupla acharOcorrencias(int valor){
        ListaDupla novaLista = new ListaDupla();
        if (estaVazio()){
            return novaLista;
        }

        No aux = primeiro;
        int pos = 0;
        while (aux != null){
            if (aux.getInfo() == valor){
                novaLista.adicionarFim(pos);
            }
            aux = aux.getProximo();
            pos++;
        }
        return novaLista;
    }

    // Acha a primeira ocorrencia do valor e devolve a posicao.
    // Retorna -1 se não for encontrado na lista
    public int acharPrimeiro(int valor){
        if (estaVazio()){
            return -1;
        }

        No aux = primeiro;
        int cont = 0;
        while (aux != null) {
            if (aux.getInfo() == valor){
                return cont;
            }
            aux = aux.getProximo();
            cont++;
        }
        return -1;
    }

    // Devolve o número de elementos na lista
    // Retorna 0 caso não tenha nenhum elemento
    public int tamanho(){
        if (estaVazio()){
            return 0;
        }

        int contador = 0;
        No aux = primeiro;

        while (aux != null) {
            aux = aux.getProximo();
            contador++;
        }
        return contador;
    }

    @Override
    public String toString(){
        if (estaVazio()){
            return "Vazio";
        }
        No aux = primeiro;
        String dados = "";
        while (aux != null) {
            dados += aux.getInfo() + " ";
            aux = aux.getProximo();
        }
        return dados;
    }

}


/* 
1. Inserir um elemento em uma determinada posição ################################################ adicionarEm(int valor, int posicao)
2. Verificar quantas vezes um elemento aparece no vetor ########################################## contar(int valor)
3. Remover um elemento de uma determinada posição ################################################ removerEm(int posicao)
4. Remover a primeira ocorrência de um determinado elemento ###################################### removerPrimeiraOcorrencia(int valor)
5. Remover todas as ocorrências de um determinado elemento ####################################### removerTodos(int valor)
6. Criar uma nova instância da classe, com as posições de ocorrência de um determinado elemento ## acharOcorrencias(int valor)
7. Devolver o índice da primeira ocorrência de um determinado elemento ########################### acharPrimeiro(int valor)
8. Devolver o tamanho atual da lista de valores (quantos elementos ela tem) ###################### tamanho()
9. Esvaziar a lista ############################################################################## 
10. Devolver uma cópia da lista ################################################################## 
11. Reduzir o vetor ao tamanho dele ############################################################## Não se aplica
12. Receber 2 vetores de entrada e mesclá-los num único vetor. ################################### 
13. Somar os elementos da lista ################################################################## 
14. Encontrar o maior elemento armazenado ######################################################## 
15. Encontrar a posição do maior elemento armazenado ############################################# 
16. Encontrar o menor elemento armazenado e coloca-lo na posição 0 (fazer a troca) ############### 
*/