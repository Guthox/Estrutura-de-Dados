import java.util.LinkedList;

public class TesteLista {
    public static void main(String[] args) {

        ListaDupla<Integer> minhaLista = new ListaDupla<>();
        LinkedList<Integer> javaLista = new LinkedList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i <= 100000; i+= 10){
            minhaLista.add(i * 10);
        }

        for (int i = 0; i <= 100000; i+= 10){
            minhaLista.add(i % 10 + 3, i);
        }

        long end = System.currentTimeMillis();
        //System.out.println(minhaLista.toString());
        System.out.println("Minha List Time: " + (end - start));


        start = System.currentTimeMillis();

        for (int i = 0; i <= 100000; i+= 10){
            javaLista.add(i * 10);
        }

        for (int i = 0; i <= 100000; i+= 10){
            javaLista.add(i % 10 + 3, i);
        }


        end = System.currentTimeMillis();
        //System.out.println(javaLista.toString());
        System.out.println("Linked Lista Time: " + (end - start));

        System.out.println("Sucesso: " + minhaLista.toString().equals(javaLista.toString()));
        

    }
}
