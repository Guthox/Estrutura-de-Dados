public class TesteLista {
    public static void main(String[] args) {
        
        ListaDupla lista = new ListaDupla();

        System.out.println(lista.toString());

        for (int i = 0; i <= 100; i += 10){
            lista.adicionarFim(i);
        }

        System.out.println(lista.toString());

        System.out.println(lista.tamanho());

    }
}
