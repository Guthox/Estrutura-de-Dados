import java.util.LinkedList;

public class Teste {
    public static void main(String[] args) {
        
        LinkedList<Integer> java = new LinkedList<>();
        ListaDupla<Integer> minha = new ListaDupla<>();

        long end;
        long start;

        start = System.currentTimeMillis();

        for (int i = 0; i <= 1000000; i+= 10){ 
            java.add(i);
        }

        java.removeFirstOccurrence(10);

        end = System.currentTimeMillis();
        System.out.println("Linked List: " + (end - start));


        start = System.currentTimeMillis();

        for (int i = 0; i <= 1000000; i+= 10){ 
            minha.add(i);
        }
        minha.removeFirstOccurrence(10);
        
        end = System.currentTimeMillis();
        System.out.println("Minha List: " + (end - start));
        // System.out.println("Igual: " + java.toString().equals(minha.toString()));
        // System.out.println("Igual: " + (java.size() == minha.size()));


        // System.out.println("Minha: " + minha.toString());
        // System.out.println("Java: " + java.toString());
        // System.out.println("Minha: " + minha.size());
        // System.out.println("Java: " + java.size());
    }
}
