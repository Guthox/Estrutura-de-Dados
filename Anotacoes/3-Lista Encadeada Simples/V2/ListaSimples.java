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
	// Caso a posição for invália, um erro será gerado
	public void adicionarEm(int info, int posicao){
		if (posicao == 0){
			adicionarInicio(info);
			return;
		}
		
		No aux = inicio;
		int contador = 0;
		while (contador != (posicao - 1)) { // Chega no anterior da posicao
			aux = aux.getProximo();
			contador++;
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

}
