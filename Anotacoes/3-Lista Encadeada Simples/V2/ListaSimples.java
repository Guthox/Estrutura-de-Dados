public class ListaSimples{

	private No inicio;
	private No fim;

	public ListaSimples(){
		inicio = null;
		fim  = null;	
	}

	// Retorna se a lista está vazia ou não
	public boolean estaVazio(){
		return inicio == null;
	}

	// Adiciona elemento no começo da lista
	public void adicionarInicio(int info){
		No novo = new No(info);
		if (!estaVazio()){
			novo.setProximo(inicio);
		}
		else{ // Set tiver vazia
			fim = novo;
		}
		inicio = novo;
	}

	// Adiciona elemento no fim da lista
	public void adicionarFim(int info){
		No novo = new No(info);
		if (estaVazio()){
			inicio = novo;
		}
		else{
			fim.setProximo(novo);
		}
		fim = novo;
	}

	// Inserir elemento na posição indicada
	// Caso a posicao for 0 ou menor, insere inicio
	// Caso a posicao for maior que o tamanho da lista, insere no fim
	public void adicionarEm(int info, int posicao){
		if (estaVazio() || posicao <= 0){
			adicionarInicio(info);
			return;
		}
		
		No aux = inicio;
		int contador = 0;
		while (contador != (posicao - 1) && aux != fim) { // Chega no anterior da posicao
			aux = aux.getProximo();
			contador++;
		}

		if (posicao > (contador + 1)){ // Se a posicao for maior que a lista
			adicionarFim(info);
			return;
		}
		
		No novo = new No(info);
		novo.setProximo(aux.getProximo());
		aux.setProximo(novo);
		
	}

	// Retorna a quantidade de elementos na lista
	public int contarElementos(){
		if (estaVazio()){
			return 0;
		}

		No aux = inicio;
		int contador = 1;
		while(aux.getProximo() != null){
			aux = aux.getProximo();
			contador++;
		}
		return contador;
	}

	// Remove o primeiro elemento.
	// Caso a lista estiver vazia, um erro será gerado.
	public int removerInicio(){
		int retorno = inicio.getInfo();
		if (inicio == fim){ // Se for o unico elemento
			inicio = null;
			fim = null;
			return retorno;
		} 
		inicio = inicio.getProximo();
		return retorno;
	}

	// Remove o elemento na posicao dada
	// Caso a lista estiver vazia, um erro sera gerado
	public int removerEm(int posicao){
		if (posicao == 0){
			return removerInicio();
		}
		if (posicao < 0){
			throw new java.lang.NullPointerException();
		}
		
		No aux = inicio;
		int contador = 0;
		while (contador < posicao - 1) {
			aux = aux.getProximo();
			contador++;
		}
		int info = aux.getProximo().getInfo();
		aux.setProximo(aux.getProximo().getProximo());
		return info;
	}

	// Remove o ultimo elemento.
	// Caso a lista estiver vazia, um erro será gerado.
	public int removerFim(){
		int retorno = fim.getInfo();
		No aux = inicio;
		if (inicio == fim){ // Se a lista tiver apenas um elemento
			inicio = null;
			fim = null;
			return retorno;
		}

		while (aux.getProximo() != fim){ // Loop para chegar no penultimo elemento
			aux = aux.getProximo();
		}

		aux.setProximo(null);
		fim = aux;

		return retorno;
	}

	@Override
	public String toString(){
		if (estaVazio()){
			return "Vazia";
		}
		No temp = inicio;
		String dados = "";
		while(temp != null){
			dados += temp.getInfo() + " ";
			temp = temp.getProximo();
		}
		return dados;
	}

	// Retorna uma copia exata da lista
	public ListaSimples copiarLista(){
		ListaSimples copia = new ListaSimples();
		if (estaVazio()){
			return copia;
		}

		No aux = inicio;
		while (aux != null) {
			copia.adicionarFim(aux.getInfo());
			aux = aux.getProximo();
		}
		return copia;
	}

	// Esvazia a lista
	public void esvaziarLista(){
		inicio = null;
		fim = null;
	}

	// Retorna o maior valor da lista
	// se a lista estiver vazia, retorna 0.
	public int acharMaior(){
		if (estaVazio()){
			return 0;
		}

		No aux = inicio;
		int maior = aux.getInfo();

		while (aux != null){
			if (aux.getInfo() > maior){
				maior = aux.getInfo();
			}
			aux = aux.getProximo();
		}
		return maior;
		
	}

	// Retorna o menor valor da lista
	// Se a lista estiver vazia, retorna 0.
	public int acharMenor(){
		if (estaVazio()){
			return 0;
		}

		No aux = inicio;
		int menor = aux.getInfo();

		while (aux != null){
			if (aux.getInfo() < menor){
				menor = aux.getInfo();
			}
			aux = aux.getProximo();
		}
		return menor;
		
	}

	// Retorna a soma dos elementos da lista
	// Se a lista estiver vazia, retorna 0
	public int somar(){
		if (estaVazio()){
			return 0;
		}

		int soma = 0;
		No aux = inicio;

		while (aux != null){
			soma += aux.getInfo();
			aux = aux.getProximo();
		}
		return soma;
	}

	// Retorna a primeira posicao do elemento
	// Se o elemento não estiver na lista, retorna -1
	public int acharValor(int valor){
		if (estaVazio()){
			return -1;
		}

		No aux = inicio;
		int indice = 0;
		while (aux != null) {
			if (aux.getInfo() == valor){
				return indice;
			}
			indice++;
			aux = aux.getProximo();
		}
		return -1;
	}

	// Retorna o número de vezes que o valor aparece na lista
	// Se o elemento não estiver na lista, retorna -1
	public int contar(int valor){
		if (estaVazio()){
			return -1;
		}

		int contador = 0;
		No aux = inicio;

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

	// Retorna a posicao do maior valor da lista
	public int posicaoMaior(){
		return acharValor(acharMaior());
	}

	// Retorna a posicao do menor valor da lista
	public int posicaoMenor(){
		return acharValor(acharMenor());
	}

	// Remove a primeira ocorrencia do valor dado
	public void removerPrimeiro(int valor){
		if (estaVazio()){
			return;
		}

		int index = acharValor(valor);
		if (index == -1){
			return;
		}
		removerEm(index);
	}

	// Remove todos os elementos do valor dado
	public void removerTodos(int valor){
		if (estaVazio()){
			return;
		}

		int index = acharValor(valor);
		while (index != -1){
			removerEm(index);
			index = acharValor(valor);
		}
	}

	// Mescla duas listas e retorna uma nova
	public ListaSimples mesclarLista(ListaSimples lista1, ListaSimples lista2){
		ListaSimples novaLista = new ListaSimples();

		No aux = lista1.inicio;
		while (aux != null){
			novaLista.adicionarFim(aux.getInfo());
			aux = aux.getProximo();
		}

		aux = lista2.inicio;
		while (aux != null){
			novaLista.adicionarFim(aux.getInfo());
			aux = aux.getProximo();
		}

		return novaLista;
	}

	// Cria uma lista contendo as posicoes do elemento dado
	public ListaSimples acharTodos(int valor){
		if (estaVazio()){
			return new ListaSimples();
		}

		ListaSimples lista = new ListaSimples();
		No aux = inicio;
		int pos = 0;
		while (aux != null){
			if (aux.getInfo() == valor){
				lista.adicionarFim(pos);
			}
			pos++;
			aux = aux.getProximo();
		}
		return lista;
	}

	// Troca a posicao do menor elemento com o elemento da primeira posicao	
	public void trocarMenor(){
		int pos = posicaoMenor();
		int infoZero = inicio.getInfo();
		No aux = inicio;
		int cont = 0;
		while (cont < pos) {
			cont++;
			aux = aux.getProximo();
		}
		inicio.setInfo(acharMenor());
		aux.setInfo(infoZero);
	}
}

/* 
1. Inserir um elemento em uma determinada posição ################################################ adicionarEm(int info, int posicao)
2. Verificar quantas vezes um elemento aparece no vetor ########################################## contar(int valor)
3. Remover um elemento de uma determinada posição ################################################ removerEm(int posicao)
4. Remover a primeira ocorrência de um determinado elemento ###################################### removerPrimeiro(int valor)
5. Remover todas as ocorrências de um determinado elemento ####################################### removerTodos(int valor)
6. Criar uma nova instância da classe, com as posições de ocorrência de um determinado elemento. # acharTodos(int valor)
7. Devolver o índice da primeira ocorrência de um determinado elemento ########################### acharValor(int valor)
8. Devolver o tamanho atual da lista de valores (quantos elementos ela tem) ###################### contarElementos()
9. Esvaziar a lista ############################################################################## esvaziarLista()
10. Devolver uma cópia da lista ################################################################## copiarLista()
11. Reduzir o vetor ao tamanho dele ############################################################## Não se aplica
12. Receber 2 vetores de entrada e mesclá-los num único vetor. ################################### mesclarLista(ListaSimples lista1, ListaSimples lista2)
13. Somar os elementos da lista ################################################################## somar()
14. Encontrar o maior elemento armazenado ######################################################## acharMaior()
15. Encontrar a posição do maior elemento armazenado ############################################# posicaoMaior()
16. Encontrar o menor elemento armazenado e coloca-lo na posição 0 (fazer a troca) ############### void trocarMenor()

*/