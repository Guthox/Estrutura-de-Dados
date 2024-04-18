public class TestePilha {
    public static void main(String[] args) {
        
        Pilha pilha = new Pilha();

        for (int i = 0; i < 10; i++){
            pilha.push(i*10);
            System.out.println(pilha.toString());
            System.out.println("################");
        }
        System.out.println("PEEK: " + pilha.peek());
        System.out.println("################");
        for (int i = 0; i < 10; i++){
            pilha.pop();
            System.out.println(pilha.toString());
            System.out.println("################");
        }

    }
}
