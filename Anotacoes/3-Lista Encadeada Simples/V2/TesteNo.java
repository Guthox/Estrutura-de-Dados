public class TesteNo{
	public static void main(String[] args){

		No no1 = new No(0);

		System.out.println("Valor inicial: " + no1.getInfo());
		
		no1.setInfo(3);
		System.out.println("Valor alterado: " + no1.getInfo());

		System.out.println("Proximo inicial: " + no1.getProximo());
		
		No no2 = new No(5);
		no1.setProximo(no2);

		System.out.println("Proximo alterado: " + no1.getProximo());



	}	
}

