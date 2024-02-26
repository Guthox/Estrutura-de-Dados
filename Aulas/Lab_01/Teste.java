import java.util.Random;

public class Teste {
    public static void main(String[] args) {
        // MeuVetor v1 = new MeuVetor(10);
        // System.out.println("ultima posicao depois de instanciar: " + v1.getUltimaPos());
        // v1.setUltimaPos(27);
        // System.out.println("ultima posicao depois do 27: " + v1.getUltimaPos());
        // System.out.println(v1);

        // if (v1.add(12)){
        //     System.out.println("elemento inserido com sucesso");
        // }
        // else {
        //     System.out.println("vetor esta cheio!");
        // }

        MeuVetor vetor = encherVetor(100);
        System.out.println("##############################");
        vetor = removerTodos(vetor);
    }

    public static MeuVetor removerTodos(MeuVetor v1){
        while (!v1.estaVazio()) {
            v1.remove();
            System.out.println("Capacidade: " + v1.getV().length);
        }
        return v1;
    }

    private static MeuVetor encherVetor (int quantidade){
        MeuVetor vetor = new MeuVetor(1);
        Random random = new Random();
        for (int i = 0; i < quantidade; i++){
            vetor.add(random.nextInt(100 + 1));
            System.out.println("Capacidade: " + vetor.getV().length);
        }
        return vetor;
    }
}