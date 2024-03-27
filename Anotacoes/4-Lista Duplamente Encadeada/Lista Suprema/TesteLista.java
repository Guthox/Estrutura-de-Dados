public class TesteLista {
    public static void main(String[] args) {
        
        ListaDupla<Integer> lista = new ListaDupla<>();
        System.out.println(lista.toString());
        lista.add(2);
        lista.addFirst(3);

        System.out.println(lista.get(1));

    }
}
