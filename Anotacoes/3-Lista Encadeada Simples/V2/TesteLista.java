public class TesteLista{
	public static void main(String[] args){
	
		ListaSimples lista = new ListaSimples();

		for (int i = 0; i <= 100; i += 10){
			lista.adicionarFim(i);
		}

		System.out.println(lista.toString());

		lista.trocarMenor();

		System.out.println(lista.toString());



	}
}

