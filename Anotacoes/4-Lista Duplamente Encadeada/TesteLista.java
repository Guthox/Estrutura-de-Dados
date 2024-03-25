public class TesteLista {
    public static void main(String[] args) {
        
        ListaDupla lista = new ListaDupla();

        System.out.println(lista.toString());

        for (int i = 0; i <= 100; i += 10){
            lista.adicionarFim(i);
        }

        System.out.println(lista.toString());
        lista.removerEm(-2);
        System.out.println(lista.toString());

    }
}
