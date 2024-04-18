public class TesteFila {
    public static void main(String[] args) {
        
        Fila fila = new Fila();
        for (int i = 0; i < 10; i++){
            fila.adicionar(i*10);
            System.out.println(fila.toString());
        }
        System.out.println(fila.peek());
        for (int i = 0; i < 10; i++){
            fila.remover();
            System.out.println(fila.toString());
        }
        


    }   
}
